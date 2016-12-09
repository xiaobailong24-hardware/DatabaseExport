package com.tjkcht.databaseexport;

import com.tjkcht.databaseexport.util.DbFileFilter;
import com.tjkcht.databaseexport.util.MySqlJDBC;
import com.tjkcht.databaseexport.util.SQLiteJDBC;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by LiuYinlong on 2016/10/13.
 */
public class UiInit extends JFrame {
    private static UiInit uiInit = new UiInit();

    private UiInit() {
        initComponents();
    }

    public static void start() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                uiInit.setVisible(true);
            }
        });
    }

    //界面初始化
    private void initComponents() {

        Components.buttonGroupExport = new ButtonGroup();
        Components.jLabelOrigin = new JLabel();
        Components.jLabelState = new JLabel();
        Components.jProgressBar = new JProgressBar();
        Components.jTextFieldOrigin = new JTextField();
        Components.jButtonOrigin = new JButton();
        Components.jLabelExport = new JLabel();
        Components.jTextFieldExport = new JTextField();
        Components.jButtonMysql = new JButton();
        Components.jRadioButtonSQLite = new JRadioButton();
        Components.jRadioButtonMySQL = new JRadioButton();
        Components.jInternalFrame1 = new JInternalFrame();/**/
        Components.jCheckBoxEnt = new JCheckBox();
        Components.jInternalFrame2 = new JInternalFrame();
        Components.jTextFieldPre = new JTextField();
        Components.jCheckBoxPre = new JCheckBox();
        Components.jRadioButtonPre = new JRadioButton();
        Components.jInternalFrame3 = new JInternalFrame();
        Components.jCheckBoxWhi1 = new JCheckBox();
        Components.jCheckBoxWhi2 = new JCheckBox();
        Components.jCheckBoxWhi3 = new JCheckBox();
        Components.jCheckBoxWhi4 = new JCheckBox();
        Components.jTextFieldWhi1 = new JTextField();
        Components.jTextFieldWhi2 = new JTextField();
        Components.jTextFieldWhi3 = new JTextField();
        Components.jTextFieldWhi4 = new JTextField();
        Components.jRadioButtonWhi1 = new JRadioButton();
        Components.jRadioButtonWhi2 = new JRadioButton();
        Components.jRadioButtonWhi3 = new JRadioButton();
        Components.jRadioButtonWhi4 = new JRadioButton();
        Components.jInternalFrame4 = new JInternalFrame();
        Components.jCheckBoxTer1 = new JCheckBox();
        Components.jCheckBoxTer2 = new JCheckBox();
        Components.jCheckBoxTer3 = new JCheckBox();
        Components.jCheckBoxTer4 = new JCheckBox();
        Components.jTextFieldTer1 = new JTextField();
        Components.jTextFieldTer2 = new JTextField();
        Components.jTextFieldTer3 = new JTextField();
        Components.jTextFieldTer4 = new JTextField();
        Components.jRadioButtonTer1 = new JRadioButton();
        Components.jRadioButtonTer2 = new JRadioButton();
        Components.jRadioButtonTer3 = new JRadioButton();
        Components.jRadioButtonTer4 = new JRadioButton();
        Components.jCheckBoxTer5 = new JCheckBox();
        Components.jTextFieldTer5 = new JTextField();
        Components.jRadioButtonTer5 = new JRadioButton();
        Components.jButtonExit = new JButton();
        Components.jButtonExport = new JButton();
        Components.jButtonBackup = new JButton();
        Components.jDialog = new JDialog();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("数据库导出工具");
        setResizable(false);

        Components.jLabelOrigin.setText("原数据库（请先备份）：");

        Components.jTextFieldOrigin.setToolTipText("请选择原数据库文件");
        Components.jTextFieldOrigin.setName(""); // NOI18N

        Components.jButtonOrigin.setText("选择");
        Components.jButtonOrigin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonOriginActionPerformed(evt);
            }
        });

        Components.jLabelExport.setText("导出数据库：");

        Components.jTextFieldExport.setToolTipText("jdbc:mysql://localhost/parking_test?user=root&password=tjkcht");
        Components.jTextFieldExport.setName(""); // NOI18N
        Components.jTextFieldExport.setEnabled(false);

        Components.jButtonMysql.setText("测试");
        Components.jButtonMysql.setEnabled(false);
        Components.jButtonMysql.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonMysqlActionPerformed(evt);
            }
        });

        Components.buttonGroupExport.add(Components.jRadioButtonSQLite);
        Components.jRadioButtonSQLite.setSelected(true);
        Components.jRadioButtonSQLite.setText("SQLite");
        Components.jRadioButtonSQLite.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jRadioButtonSQLiteActionPerformed(evt);
            }
        });

        Components.buttonGroupExport.add(Components.jRadioButtonMySQL);
        Components.jRadioButtonMySQL.setText("MySQL");
        Components.jRadioButtonMySQL.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jRadioButtonMySQLActionPerformed(evt);
            }
        });

        Components.jInternalFrame1.setTitle("1. 入场纪录表");
        Components.jInternalFrame1.setToolTipText("入场记录");
        Components.jInternalFrame1.setVisible(true);

        Components.jCheckBoxEnt.setSelected(true);
        Components.jCheckBoxEnt.setText("exited");
        Components.jCheckBoxEnt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jCheckBoxEntActionPerformed(evt);
            }
        });

        GroupLayout jInternalFrame1Layout = new GroupLayout(Components.jInternalFrame1.getContentPane());
        Components.jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
                jInternalFrame1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(Components.jCheckBoxEnt)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jInternalFrame1Layout.setVerticalGroup(
                jInternalFrame1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(Components.jCheckBoxEnt, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );

        Components.jInternalFrame2.setTitle("2. 预付费停车用户表");
        Components.jInternalFrame2.setToolTipText("包月、错时停车用户使用该表");
        Components.jInternalFrame2.setVisible(true);

        Components.jTextFieldPre.setText("null");
        Components.jTextFieldPre.setEnabled(false);

        Components.jCheckBoxPre.setSelected(true);
        Components.jCheckBoxPre.setText("attachedScript");
        Components.jCheckBoxPre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jCheckBoxPreActionPerformed(evt);
            }
        });

        Components.jRadioButtonPre.setText("自定义");
        Components.jRadioButtonPre.setToolTipText("新增附加脚本，默认为null");
        Components.jRadioButtonPre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jRadioButtonPreActionPerformed(evt);
            }
        });

        GroupLayout jInternalFrame2Layout = new GroupLayout(Components.jInternalFrame2.getContentPane());
        Components.jInternalFrame2.getContentPane().setLayout(jInternalFrame2Layout);
        jInternalFrame2Layout.setHorizontalGroup(
                jInternalFrame2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jInternalFrame2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(Components.jCheckBoxPre)
                                .addGap(24, 24, 24)
                                .addComponent(Components.jTextFieldPre, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(Components.jRadioButtonPre)
                                .addContainerGap(40, Short.MAX_VALUE))
        );
        jInternalFrame2Layout.setVerticalGroup(
                jInternalFrame2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jInternalFrame2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(Components.jCheckBoxPre, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Components.jTextFieldPre))
                        .addComponent(Components.jRadioButtonPre)
        );

        Components.jInternalFrame3.setTitle("3. 白名单表");
        Components.jInternalFrame3.setToolTipText("白名单，始终免费车辆");
        Components.jInternalFrame3.setVisible(true);

        Components.jCheckBoxWhi1.setSelected(true);
        Components.jCheckBoxWhi1.setText("validTime");
        Components.jCheckBoxWhi1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jCheckBoxWhi1ActionPerformed(evt);
            }
        });

        Components.jCheckBoxWhi2.setSelected(true);
        Components.jCheckBoxWhi2.setText("expireTime");
        Components.jCheckBoxWhi2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jCheckBoxWhi2ActionPerformed(evt);
            }
        });

        Components.jCheckBoxWhi3.setSelected(true);
        Components.jCheckBoxWhi3.setText("selectedChannels");
        Components.jCheckBoxWhi3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jCheckBoxWhi3ActionPerformed(evt);
            }
        });

        Components.jCheckBoxWhi4.setSelected(true);
        Components.jCheckBoxWhi4.setText("attachedScript");
        Components.jCheckBoxWhi4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jCheckBoxWhi4ActionPerformed(evt);
            }
        });

        Components.jTextFieldWhi1.setText("0");
        Components.jTextFieldWhi1.setEnabled(false);

        Components.jTextFieldWhi2.setText("0");
        Components.jTextFieldWhi2.setEnabled(false);

        Components.jTextFieldWhi3.setText("null");
        Components.jTextFieldWhi3.setEnabled(false);

        Components.jTextFieldWhi4.setText("null");
        Components.jTextFieldWhi4.setEnabled(false);

        Components.jRadioButtonWhi1.setText("自定义");
        Components.jRadioButtonWhi1.setToolTipText("新增附加脚本，默认为null");
        Components.jRadioButtonWhi1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jRadioButtonWhi1ActionPerformed(evt);
            }
        });

        Components.jRadioButtonWhi2.setText("自定义");
        Components.jRadioButtonWhi2.setToolTipText("新增附加脚本，默认为null");
        Components.jRadioButtonWhi2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jRadioButtonWhi2ActionPerformed(evt);
            }
        });

        Components.jRadioButtonWhi3.setText("自定义");
        Components.jRadioButtonWhi3.setToolTipText("新增附加脚本，默认为null");
        Components.jRadioButtonWhi3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jRadioButtonWhi3ActionPerformed(evt);
            }
        });

        Components.jRadioButtonWhi4.setText("自定义");
        Components.jRadioButtonWhi4.setToolTipText("新增附加脚本，默认为null");
        Components.jRadioButtonWhi4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jRadioButtonWhi4ActionPerformed(evt);
            }
        });

        GroupLayout jInternalFrame3Layout = new GroupLayout(Components.jInternalFrame3.getContentPane());
        Components.jInternalFrame3.getContentPane().setLayout(jInternalFrame3Layout);
        jInternalFrame3Layout.setHorizontalGroup(
                jInternalFrame3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jInternalFrame3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jInternalFrame3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(Components.jCheckBoxWhi1)
                                        .addComponent(Components.jCheckBoxWhi2)
                                        .addComponent(Components.jCheckBoxWhi3)
                                        .addComponent(Components.jCheckBoxWhi4))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                                .addGroup(jInternalFrame3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(Components.jTextFieldWhi1, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Components.jTextFieldWhi2, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Components.jTextFieldWhi3, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Components.jTextFieldWhi4, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jInternalFrame3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(Components.jRadioButtonWhi1, GroupLayout.Alignment.TRAILING)
                                        .addComponent(Components.jRadioButtonWhi2, GroupLayout.Alignment.TRAILING)
                                        .addComponent(Components.jRadioButtonWhi3, GroupLayout.Alignment.TRAILING)
                                        .addComponent(Components.jRadioButtonWhi4, GroupLayout.Alignment.TRAILING))
                                .addContainerGap())
        );
        jInternalFrame3Layout.setVerticalGroup(
                jInternalFrame3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jInternalFrame3Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jInternalFrame3Layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                        .addComponent(Components.jTextFieldWhi1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Components.jCheckBoxWhi1)
                                        .addComponent(Components.jRadioButtonWhi1))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jInternalFrame3Layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                        .addComponent(Components.jCheckBoxWhi2)
                                        .addComponent(Components.jTextFieldWhi2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Components.jRadioButtonWhi2))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jInternalFrame3Layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                        .addComponent(Components.jCheckBoxWhi3)
                                        .addComponent(Components.jTextFieldWhi3, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Components.jRadioButtonWhi3))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jInternalFrame3Layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                        .addComponent(Components.jCheckBoxWhi4)
                                        .addComponent(Components.jTextFieldWhi4, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Components.jRadioButtonWhi4))
                                .addContainerGap())
        );

        jInternalFrame3Layout.linkSize(SwingConstants.VERTICAL, Components.jCheckBoxWhi1, Components.jRadioButtonWhi1, Components.jTextFieldWhi1);

        jInternalFrame3Layout.linkSize(SwingConstants.VERTICAL, Components.jCheckBoxWhi2, Components.jRadioButtonWhi2, Components.jTextFieldWhi2);

        jInternalFrame3Layout.linkSize(SwingConstants.VERTICAL, Components.jCheckBoxWhi3, Components.jRadioButtonWhi3, Components.jTextFieldWhi3);

        jInternalFrame3Layout.linkSize(SwingConstants.VERTICAL, Components.jCheckBoxWhi4, Components.jRadioButtonWhi4, Components.jTextFieldWhi4);

        Components.jInternalFrame4.setTitle("4. 终端列表");
        Components.jInternalFrame4.setToolTipText("用于集中控制监视之");
        Components.jInternalFrame4.setVisible(true);

        Components.jCheckBoxTer1.setSelected(true);
        Components.jCheckBoxTer1.setText("occupiedSlotCount");
        Components.jCheckBoxTer1.setToolTipText("占用车位数");
        Components.jCheckBoxTer1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jCheckBoxTer1ActionPerformed(evt);
            }
        });

        Components.jCheckBoxTer2.setSelected(true);
        Components.jCheckBoxTer2.setText("orderedSlotCount");
        Components.jCheckBoxTer2.setToolTipText("已预订车位数");
        Components.jCheckBoxTer2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jCheckBoxTer2ActionPerformed(evt);
            }
        });

        Components.jCheckBoxTer3.setSelected(true);
        Components.jCheckBoxTer3.setText("subRegion1SlotCount");
        Components.jCheckBoxTer3.setToolTipText("子区域1占用车位数");
        Components.jCheckBoxTer3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jCheckBoxTer3ActionPerformed(evt);
            }
        });

        Components.jCheckBoxTer4.setSelected(true);
        Components.jCheckBoxTer4.setText("subRegion2SlotCount");
        Components.jCheckBoxTer4.setToolTipText("子区域2占用车位数");
        Components.jCheckBoxTer4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jCheckBoxTer4ActionPerformed(evt);
            }
        });

        Components.jCheckBoxTer5.setSelected(true);
        Components.jCheckBoxTer5.setText("totalCash");
        Components.jCheckBoxTer5.setToolTipText("当前现金数");
        Components.jCheckBoxTer5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jCheckBoxTer5ActionPerformed(evt);
            }
        });

        Components.jTextFieldTer1.setText("0");
        Components.jTextFieldTer1.setEnabled(false);

        Components.jTextFieldTer2.setText("0");
        Components.jTextFieldTer2.setEnabled(false);

        Components.jTextFieldTer3.setText("0");
        Components.jTextFieldTer3.setEnabled(false);

        Components.jTextFieldTer4.setText("0");
        Components.jTextFieldTer4.setEnabled(false);

        Components.jTextFieldTer5.setText("0.0");
        Components.jTextFieldTer5.setEnabled(false);

        Components.jRadioButtonTer1.setText("自定义");
        Components.jRadioButtonTer1.setToolTipText("新增附加脚本，默认为0");
        Components.jRadioButtonTer1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jRadioButtonTer1ActionPerformed(evt);
            }
        });

        Components.jRadioButtonTer2.setText("自定义");
        Components.jRadioButtonTer2.setToolTipText("新增附加脚本，默认为0");
        Components.jRadioButtonTer2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jRadioButtonTer2ActionPerformed(evt);
            }
        });

        Components.jRadioButtonTer3.setText("自定义");
        Components.jRadioButtonTer3.setToolTipText("新增附加脚本，默认为0");
        Components.jRadioButtonTer3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jRadioButtonTer3ActionPerformed(evt);
            }
        });

        Components.jRadioButtonTer4.setText("自定义");
        Components.jRadioButtonTer4.setToolTipText("新增附加脚本，默认为0");
        Components.jRadioButtonTer4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jRadioButtonTer4ActionPerformed(evt);
            }
        });

        Components.jRadioButtonTer5.setText("自定义");
        Components.jRadioButtonTer5.setToolTipText("新增附加脚本，默认为0.0");
        Components.jRadioButtonTer5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jRadioButtonTer5ActionPerformed(evt);
            }
        });

        GroupLayout jInternalFrame4Layout = new GroupLayout(Components.jInternalFrame4.getContentPane());
        Components.jInternalFrame4.getContentPane().setLayout(jInternalFrame4Layout);
        jInternalFrame4Layout.setHorizontalGroup(
                jInternalFrame4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jInternalFrame4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jInternalFrame4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(Components.jCheckBoxTer1)
                                        .addComponent(Components.jCheckBoxTer2)
                                        .addComponent(Components.jCheckBoxTer3)
                                        .addComponent(Components.jCheckBoxTer4)
                                        .addComponent(Components.jCheckBoxTer5))
                                .addGap(27, 27, 27)
                                .addGroup(jInternalFrame4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(Components.jTextFieldTer1, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Components.jTextFieldTer2, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Components.jTextFieldTer3, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Components.jTextFieldTer4, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Components.jTextFieldTer5, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jInternalFrame4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jInternalFrame4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addComponent(Components.jRadioButtonTer1, GroupLayout.Alignment.TRAILING)
                                                .addComponent(Components.jRadioButtonTer2, GroupLayout.Alignment.TRAILING)
                                                .addComponent(Components.jRadioButtonTer3, GroupLayout.Alignment.TRAILING)
                                                .addComponent(Components.jRadioButtonTer4, GroupLayout.Alignment.TRAILING))
                                        .addComponent(Components.jRadioButtonTer5))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jInternalFrame4Layout.setVerticalGroup(
                jInternalFrame4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jInternalFrame4Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jInternalFrame4Layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                        .addComponent(Components.jTextFieldTer1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Components.jCheckBoxTer1)
                                        .addComponent(Components.jRadioButtonTer1))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jInternalFrame4Layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                        .addComponent(Components.jCheckBoxTer2)
                                        .addComponent(Components.jTextFieldTer2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Components.jRadioButtonTer2))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jInternalFrame4Layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                        .addComponent(Components.jCheckBoxTer3)
                                        .addComponent(Components.jTextFieldTer3, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Components.jRadioButtonTer3))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jInternalFrame4Layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                        .addComponent(Components.jCheckBoxTer4)
                                        .addComponent(Components.jTextFieldTer4, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Components.jRadioButtonTer4))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jInternalFrame4Layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                        .addComponent(Components.jCheckBoxTer5)
                                        .addComponent(Components.jTextFieldTer5, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Components.jRadioButtonTer5))
                                .addContainerGap())
        );

        Components.jButtonExit.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        Components.jButtonExit.setText("退出");
        Components.jButtonExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonExitActionPerformed(evt);
            }
        });

        Components.jButtonExport.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        Components.jButtonExport.setText("导出");
        Components.jButtonExport.setEnabled(false);
        Components.jButtonExport.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonExportActionPerformed(evt);
            }
        });
        Components.jButtonBackup.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        Components.jButtonBackup.setText("备份");
        Components.jButtonBackup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonBackupActionPerformed(evt);
            }
        });

        Components.jLabelState.setText("数据库未连接...");
        Components.jDialog.setSize(400, 50);
        Components.jDialog.setLocationRelativeTo(null);
        Components.jDialog.setVisible(false);
        Components.jProgressBar.setMaximum(100);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(Components.jProgressBar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                .addComponent(Components.jLabelOrigin)
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(Components.jTextFieldOrigin, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(Components.jButtonOrigin))
                                                                .addComponent(Components.jInternalFrame1, GroupLayout.Alignment.TRAILING)
                                                                .addComponent(Components.jInternalFrame3))
                                                        .addComponent(Components.jLabelState))))
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(Components.jInternalFrame4)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(Components.jLabelExport)
                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(Components.jRadioButtonSQLite)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(Components.jRadioButtonMySQL))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(Components.jTextFieldExport, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(Components.jButtonMysql))
                                                                        .addComponent(Components.jInternalFrame2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                                .addGap(0, 0, Short.MAX_VALUE))))
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(Components.jButtonBackup)
                                                .addGap(18, 18, 18)
                                                .addComponent(Components.jButtonExport)
                                                .addGap(18, 18, 18)
                                                .addComponent(Components.jButtonExit)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(Components.jLabelOrigin)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(Components.jTextFieldOrigin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(Components.jButtonOrigin)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(Components.jLabelExport)
                                                        .addComponent(Components.jRadioButtonSQLite)
                                                        .addComponent(Components.jRadioButtonMySQL))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(Components.jTextFieldExport, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(Components.jButtonMysql))))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(Components.jInternalFrame2)
                                        .addComponent(Components.jInternalFrame1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(Components.jInternalFrame3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(30, 30, 30))
                                        .addComponent(Components.jInternalFrame4))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(Components.jLabelState)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Components.jProgressBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(Components.jButtonExit, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(Components.jButtonExport, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(Components.jButtonBackup, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)))
                                .addGap(5, 5, 5))
        );
        pack();
    }

    //更新SQLite控制
    private void jRadioButtonSQLiteActionPerformed(ActionEvent evt) {
        Components.jTextFieldExport.setEnabled(false);
        Components.jTextFieldExport.setText("");
        Components.jButtonMysql.setEnabled(false);
        Components.jLabelState.setText("SQLite:");
        Components.jProgressBar.setValue(0);
    }

    //更新MySQL控制
    private void jRadioButtonMySQLActionPerformed(ActionEvent evt) {
        Components.jTextFieldExport.setEnabled(true);
        Components.jTextFieldExport.setText("jdbc:mysql://127.0.0.1/parking_test?user=root&password=tjkcht");
        Components.jButtonMysql.setEnabled(true);
        Components.jLabelState.setText("MySQL:");
        Components.jProgressBar.setValue(0);
    }

    //打开文件选择框
    private void jButtonOriginActionPerformed(ActionEvent evt) {
        //产生一个文件选择器
        JFileChooser jFileChooser = new JFileChooser();
        //设置默认的打开目录
        jFileChooser.setCurrentDirectory(new File("."));
        //设置打开文件类型
        jFileChooser.setFileFilter(new DbFileFilter());
        jFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        //打开一个对话框
        int index = jFileChooser.showDialog(null, "打开数据库文件");
        if (index == JFileChooser.APPROVE_OPTION) {
            //把获取到的文件的绝对路径显示在文本编辑框中
            Components.jTextFieldOrigin.setText(jFileChooser.getSelectedFile().getAbsolutePath());
        }
    }

    //测试MySQL连接
    private void jButtonMysqlActionPerformed(ActionEvent evt) {
        String export = Components.jTextFieldExport.getText();
        if (!export.equals("")) {
            MySqlJDBC mySqlJDBC = new MySqlJDBC();
            boolean myConn = mySqlJDBC.connect(export);
            if (myConn) {
                Components.jDialog.setTitle("MySQL地址有效");
                Components.jDialog.setVisible(true);
            } else {
                Components.jDialog.setTitle("请检查MySQL地址");
                Components.jDialog.setVisible(true);
            }
            if (mySqlJDBC != null) {
                mySqlJDBC.close();
            }
        }
    }

    //选择入场记录表
    private void jCheckBoxEntActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    //选择预付费停车用户表attachedScript
    private void jCheckBoxPreActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    //自定义预付费停车用户表attachedScript
    private void jRadioButtonPreActionPerformed(ActionEvent evt) {
        if (Components.jRadioButtonPre.isSelected()) {
            Components.jTextFieldPre.setEnabled(true);
        } else {
            Components.jTextFieldPre.setEnabled(false);
        }
    }

    //选择白名单表validTime
    private void jCheckBoxWhi1ActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    //自定义白名单表validTime
    private void jRadioButtonWhi1ActionPerformed(ActionEvent evt) {
        if (Components.jRadioButtonWhi1.isSelected()) {
            Components.jTextFieldWhi1.setEnabled(true);
        } else {
            Components.jTextFieldWhi1.setEnabled(false);
        }
    }

    //选择白名单表expireTime
    private void jCheckBoxWhi2ActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    //自定义白名单表expireTime
    private void jRadioButtonWhi2ActionPerformed(ActionEvent evt) {
        if (Components.jRadioButtonWhi2.isSelected()) {
            Components.jTextFieldWhi2.setEnabled(true);
        } else {
            Components.jTextFieldWhi2.setEnabled(false);
        }
    }

    //选择白名单表selectedChannels
    private void jCheckBoxWhi3ActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    //自定义白名单表selectedChannels
    private void jRadioButtonWhi3ActionPerformed(ActionEvent evt) {
        if (Components.jRadioButtonWhi3.isSelected()) {
            Components.jTextFieldWhi3.setEnabled(true);
        } else {
            Components.jTextFieldWhi3.setEnabled(false);
        }
    }

    //选择白名单表attachedScript
    private void jCheckBoxWhi4ActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    //自定义白名单表attachedScript
    private void jRadioButtonWhi4ActionPerformed(ActionEvent evt) {
        if (Components.jRadioButtonWhi4.isSelected()) {
            Components.jTextFieldWhi4.setEnabled(true);
        } else {
            Components.jTextFieldWhi4.setEnabled(false);
        }
    }

    //选择终端列表occupiedSlotCount
    private void jCheckBoxTer1ActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    //自定义终端列表occupiedSlotCount
    private void jRadioButtonTer1ActionPerformed(ActionEvent evt) {
        if (Components.jRadioButtonTer1.isSelected()) {
            Components.jTextFieldTer1.setEnabled(true);
        } else {
            Components.jTextFieldTer1.setEnabled(false);
        }
    }

    //选择终端列表orderedSlotCount
    private void jCheckBoxTer2ActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    //自定义终端列表orderedSlotCount
    private void jRadioButtonTer2ActionPerformed(ActionEvent evt) {
        if (Components.jRadioButtonTer2.isSelected()) {
            Components.jTextFieldTer2.setEnabled(true);
        } else {
            Components.jTextFieldTer2.setEnabled(false);
        }
    }

    //选择终端列表subRegion1SlotCount
    private void jCheckBoxTer3ActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    //自定义终端列表subRegion1SlotCount
    private void jRadioButtonTer3ActionPerformed(ActionEvent evt) {
        if (Components.jRadioButtonTer3.isSelected()) {
            Components.jTextFieldTer3.setEnabled(true);
        } else {
            Components.jTextFieldTer3.setEnabled(false);
        }
    }

    //选择终端列表subRegion2SlotCount
    private void jCheckBoxTer4ActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    //自定义终端列表subRegion2SlotCount
    private void jRadioButtonTer4ActionPerformed(ActionEvent evt) {
        if (Components.jRadioButtonTer4.isSelected()) {
            Components.jTextFieldTer4.setEnabled(true);
        } else {
            Components.jTextFieldTer4.setEnabled(false);
        }
    }

    //选择终端列表totalCash
    private void jCheckBoxTer5ActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    //自定义终端列表totalCash
    private void jRadioButtonTer5ActionPerformed(ActionEvent evt) {
        if (Components.jRadioButtonTer5.isSelected()) {
            Components.jTextFieldTer5.setEnabled(true);
        } else {
            Components.jTextFieldTer5.setEnabled(false);
        }
    }

    //备份数据库
    private void jButtonBackupActionPerformed(ActionEvent evt) {
        //备份旧的数据库文件.old
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");//设置日期格式
        String date = df.format(new Date());
        System.out.println(date);
        String origin = Components.jTextFieldOrigin.getText();
        System.out.println(origin);
        if (!origin.equals("") && origin.endsWith(".db")) {
            File old = new File(origin.replace(".db", "") + ".old." + date + ".db");
            File originFile = new File(origin);
            if (old.exists()) {
                old.delete();
            }
            try {
                Files.copy(originFile.toPath(), old.toPath());
                Components.jDialog.setTitle("备份成功！");
                Components.jDialog.setVisible(true);
                Components.jButtonExport.setEnabled(true);
            } catch (IOException e) {
                System.err.println("SQLite备份失败！");
            }
        } else {
            Components.jDialog.setTitle("请选择正确的数据库文件...");
            Components.jDialog.setVisible(true);
        }
    }

    //退出
    private void jButtonExitActionPerformed(ActionEvent evt) {
        //退出系统
        System.out.println("退出！");
        System.exit(0);
    }

    //导出
    private void jButtonExportActionPerformed(ActionEvent evt) {
        String origin = Components.jTextFieldOrigin.getText();
        System.out.println(origin);
        if (!origin.equals("") && origin.endsWith(".db")) {
            //连接数据库
            File db = new File(origin);
            SQLiteJDBC sqLiteJDBC = new SQLiteJDBC();
            MySqlJDBC mySqlJDBC = new MySqlJDBC();
            boolean sConn = sqLiteJDBC.connect(db.toPath().toString());
            if (sConn) {
                //更新SQLite数据库
                if (Components.jRadioButtonSQLite.isSelected()) {
                    updateSQLite(sqLiteJDBC);
                } else {
                    updateMySQL(sqLiteJDBC, mySqlJDBC);
                }
                //关闭数据库连接
                sqLiteJDBC.close();
            } else {
                Components.jDialog.setTitle("数据库打开失败！！！");
                Components.jDialog.setVisible(true);
            }
        } else {
            Components.jDialog.setTitle("请选择正确的数据库文件，并且在导出之前备份...");
            Components.jDialog.setVisible(true);
        }

    }

    //更新SQLite数据库
    private void updateSQLite(SQLiteJDBC sqLiteJDBC) {
        boolean er = false;
        boolean pp = false;
        boolean wl = false;
        boolean ipt = false;
        StringBuffer sb = new StringBuffer("SQLite:");
        Components.jDialog.setTitle("更新SQLite数据库...");
        //更新数据库：入场纪录表
        if (sqLiteJDBC.isTableExist("entry_record")) {//判断表是否存在
            if (sqLiteJDBC.delete("entry_record", "exited=1")) {
                System.out.println("Update entry_record successfully!!!");
                Components.jProgressBar.setValue(25);
                er = true;
                sb.append("入场(√).");
            }
        }

        //更新数据库：预付费停车用户表
        if (sqLiteJDBC.isTableExist("prepayment_parking")) {
            if (sqLiteJDBC.addColumn("prepayment_parking", "attachedScript", "blob", Components.jTextFieldPre.getText())) {
                System.out.println("Update prepayment_parking successfully!!!");
                Components.jProgressBar.setValue(Components.jProgressBar.getValue() + 25);
                pp = true;
                sb.append("预付费(√).");
            }
        }

        //更新数据库：白名单表
        if (sqLiteJDBC.isTableExist("white_list")) {
            if (sqLiteJDBC.addColumn("white_list", "validTime", "int", Components.jTextFieldWhi1.getText())
                    & sqLiteJDBC.addColumn("white_list", "expireTime", "int", Components.jTextFieldWhi2.getText())
                    & sqLiteJDBC.addColumn("white_list", "selectedChannels", "varchar(128)", Components.jTextFieldWhi3.getText())
                    & sqLiteJDBC.addColumn("white_list", "attachedScript", "blob", Components.jTextFieldWhi4.getText())) {
                System.out.println("Update white_list successfully!!!");
                Components.jProgressBar.setValue(Components.jProgressBar.getValue() + 25);
                wl = true;
                sb.append("白名单(√).");
            }
        }

        //更新数据库：终端列表
        if (sqLiteJDBC.isTableExist("inner_park_terminal")) {
            if (sqLiteJDBC.addColumn("inner_park_terminal", "occupiedSlotCount", "int", Components.jTextFieldTer1.getText())
                    & sqLiteJDBC.addColumn("inner_park_terminal", "orderedSlotCount", "int", Components.jTextFieldTer2.getText())
                    & sqLiteJDBC.addColumn("inner_park_terminal", "subRegion1SlotCount", "int", Components.jTextFieldTer3.getText())
                    & sqLiteJDBC.addColumn("inner_park_terminal", "subRegion2SlotCount", "int", Components.jTextFieldTer4.getText())
                    & sqLiteJDBC.addColumn("inner_park_terminal", "totalCash", "float", Components.jTextFieldTer5.getText())) {
                System.out.println("Update inner_park_terminal successfully!!!");
                Components.jProgressBar.setValue(Components.jProgressBar.getValue() + 25);
                ipt = true;
                sb.append("终端(√).");
            }
        }
        if (er && pp && wl && ipt) Components.jDialog.setTitle("更新SQLite数据库完成！");
        else Components.jDialog.setTitle("更新SQLite数据库失败！");

        Components.jDialog.setVisible(true);
        Components.jLabelState.setText(sb.toString());
    }

    //更新至MySQL数据库
    private void updateMySQL(SQLiteJDBC sqLiteJDBC, MySqlJDBC mySqlJDBC) {
        boolean mConn = false;
        String mySQLUrl = Components.jTextFieldExport.getText();
        if (!mySQLUrl.equals("")) {
            mConn = mySqlJDBC.connect(mySQLUrl);
        }
        StringBuffer sb = new StringBuffer("MySQL:");
        if (mConn) {
            try {
                Components.jDialog.setTitle("请耐心等待，不要关闭。。。");
                Components.jDialog.setVisible(true);
                mySqlJDBC.setResultSet(sqLiteJDBC.selectAll("entry_record"));
                boolean er = mySqlJDBC.insertEntryRecord();
                if (er) {
                    sb.append("入场(√).");
                    Components.jLabelState.setText(sb.toString());
                    Components.jProgressBar.setValue(Components.jProgressBar.getValue() + 25);
                }

                mySqlJDBC.setResultSet(sqLiteJDBC.selectAll("prepayment_parking"));
                boolean pp = mySqlJDBC.insertPrepaymentParking();
                if (pp) {
                    sb.append("预付费(√).");
                    Components.jLabelState.setText(sb.toString());
                    Components.jProgressBar.setValue(Components.jProgressBar.getValue() + 25);
                }

                mySqlJDBC.setResultSet(sqLiteJDBC.selectAll("white_list"));
                boolean wl = mySqlJDBC.insertWhiteList();
                if (wl) {
                    sb.append("白名单(√).");
                    Components.jLabelState.setText(sb.toString());
                    Components.jProgressBar.setValue(Components.jProgressBar.getValue() + 25);
                }

                mySqlJDBC.setResultSet(sqLiteJDBC.selectAll("inner_park_terminal"));
                boolean ipt = mySqlJDBC.insertInnerParkTerminal();
                if (ipt) {
                    sb.append("终端(√).");
                    Components.jLabelState.setText(sb.toString());
                    Components.jProgressBar.setValue(Components.jProgressBar.getValue() + 25);
                }
                if (er && pp && wl && ipt) {
                    Components.jDialog.setTitle("导出MySQL完成！");
                    Components.jProgressBar.setValue(100);
                } else Components.jDialog.setTitle("导出MySQL失败！请保证MySQL表存在。");
            } catch (Exception e) {
                System.err.println("数据库导出异常!");
            } finally {
                if (mySqlJDBC != null) {
                    mySqlJDBC.close();
                }
            }
        }
    }

}
