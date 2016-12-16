--停车场内共享数据库


--收费员
create table toll_collector(
	tollCollectorName varchar(30) primary key,
	password varchar(30)
);

--收款人
create table accountant(
	accountantName varchar(30) primary key,
	password varchar(30)
);

--车位预定
create table park_slot_order(
	plateNo varchar(20),
	vehicleType varchar(20),
	expire_time	int	--预定到期时间戳
);

--预付费
create table prepay(
	plateNo varchar(20),
	vehicleType varchar(20),
	fee float
);

--白名单，始终免费车辆
create table white_list(
	outerUUID varchar(32) primary key,	--外部系统主键
	plateNo varchar(20),
	vehicleType varchar(20),
	updateTime int
);
create index white_list_idx on white_list(plateNo);

--电子牌-车牌号绑定关系，用于某些不能自行读取车牌号的RFID设备及标签
create table rfid_plateno_binding(
	rfid varchar(50) primary key,
	plateNo varchar(20),
	vehicleType varchar(20)
); 


--预付费停车用户表
--包月、错时停车用户使用该表
create table prepayment_parking(
	outerUUID varchar(32) primary key,	--外部系统主键
	plateNo varchar(20),
	vehicleType varchar(20),
	begin_date int,	--开始日期
	end_date int,	--结束日期
	begin_time int,	--时间段开始时刻，为距离当天00:00:00的毫秒数
	end_time int,	--时间段结束时刻
	slot varchar(20),	--车位号，暂时空
	updateTime int
);

create index prepayment_parking_indx on prepayment_parking(plateNo);


--入场记录
create table entry_record(
	id integer primary key AUTOINCREMENT,
	enterTime int not null,
	entryId varchar(20) not null,	--入口编号
	plateNo varchar(20) not null,
	vehicleType varchar(20),--车型
	rfidParsePlateNoResult varchar(20),
	imgParsePlateNoResult varchar(20),
	enterImg BLOB,
	state varchar(20),
	exited smallint default 0 not null,--是否已出场
	ordering smallint default 0 	--是否为预定车辆
);

--为加快入场记录的检索，增加如下的索引
create index entry_record_indx on entry_record(plateNo);
create index entry_record_exited_indx on entry_record(exited);



--出场记录
create table exit_record(
	id INTEGER primary key AUTOINCREMENT,
	exitTime int not null,
	exitId varchar(20) not null,	--出口编号
	plateNo varchar(20) not null,
	vehicleType varchar(20),	--车型
	rfidParsePlateNoResult varchar(20),
	imgParsePlateNoResult varchar(20),
	exitImg BLOB,
	state varchar(20)
);

create index exit_record_indx on exit_record(plateNo);

--交易记录
create table trading_record(
	id integer primary key AUTOINCREMENT,
	tradeTime int not null,
	plateNo varchar(20) not null,
	vehicleType varchar(20),	--车型
	entryRecordId int references entry_record(id) null,
	exitRecordId int references exit_record(id) not null,
	tradeType varchar(30),	--现场交易类型
	tollRateVersion varchar(20),	--费率版本
	accounts float not null,	--应收费用
	cash float not null	--现场实收现金
);

--现金处置明细：现金收费、收费员交班中的现金移交、财务收缴等记录
create table cash_biz(
	id integer primary key AUTOINCREMENT,
	terminalId varchar(30),
	bizTime int,
	tollCollectorName varchar(30),
	event varchar(100),
	cash float,
	currentTotalCash float
);

--操作员日志
create table toll_collector_operate_log(
	id integer primary key AUTOINCREMENT,
	terminalId varchar(30),
	tollCollectorName varchar(50),	--这里是违反范式的，松耦合有时候更方便
	logTime int not null,
	level varchar(10) not null,
	message varchar(100),
	photo BLOB
);

--终端列表，用于集中控制之
create table inner_park_terminal(
	terminalId varchar(30) primary key,
	terminalIp varchar(20),
	entryList varchar(100),
	exitList varchar(100)
);




