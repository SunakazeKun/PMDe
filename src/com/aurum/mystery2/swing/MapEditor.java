package com.aurum.mystery2.swing;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultListModel;
import com.aurum.mystery2.Lists;
import com.aurum.mystery2.game.RomFile;
import com.aurum.mystery2.game.Dungeon;

public class MapEditor extends javax.swing.JFrame {
    public MapEditor() {
        initComponents();
        for (int i = 0 ; i < 64 ; i++) {
            model.addElement(Lists.dungeons.get(i));
            
            Dungeon dungeon = (Dungeon) RomFile.current.dungeons.get(i).clone();
            JMapPoint point = new JMapPoint(i, dungeon.mapX, dungeon.mapY);
            point.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent evt) {
                    listDungeons.setSelectedIndex(point.getIndex());
                    listDungeons.ensureIndexIsVisible(point.getIndex());
                }
            });
            
            map.add(point);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listDungeons = new javax.swing.JList<>();
        map = new com.aurum.mystery2.swing.JMapPanel();
        jLabel1 = new javax.swing.JLabel();
        spnX = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        spnY = new javax.swing.JSpinner();
        btnSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Dungeon map editor");
        setIconImage(com.aurum.mystery2.Main.icon);
        setResizable(false);

        listDungeons.setModel(model = new DefaultListModel());
        listDungeons.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listDungeons.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listDungeonsValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listDungeons);

        map.setMaximumSize(new java.awt.Dimension(480, 320));
        map.setMinimumSize(new java.awt.Dimension(480, 320));

        jLabel1.setText("X: ");

        spnX.setModel(new javax.swing.SpinnerNumberModel(0, 0, 480, 1));
        spnX.setEnabled(false);
        spnX.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnXStateChanged(evt);
            }
        });

        jLabel2.setText("Y: ");

        spnY.setModel(new javax.swing.SpinnerNumberModel(0, 0, 320, 1));
        spnY.setEnabled(false);
        spnY.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnYStateChanged(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(spnX, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(spnY, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(map, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(map, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(spnY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(spnX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSave)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void listDungeonsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listDungeonsValueChanged
        int selectedIndex = listDungeons.getSelectedIndex();
        boolean enable = selectedIndex >= 0;
        spnX.setEnabled(enable);
        spnY.setEnabled(enable);
        
        if (!enable)
            return;
        
        selected = map.setSelected(selectedIndex);
        spnX.setValue(selected.getPointX());
        spnY.setValue(selected.getPointY());
    }//GEN-LAST:event_listDungeonsValueChanged

    private void spnXStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnXStateChanged
        selected.setPointX((int) spnX.getValue());
    }//GEN-LAST:event_spnXStateChanged

    private void spnYStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnYStateChanged
        selected.setPointY((int) spnY.getValue());
    }//GEN-LAST:event_spnYStateChanged

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if (selected == null)
            return;
        
        Dungeon dungeon = RomFile.current.dungeons.get(selected.getIndex());
        dungeon.mapX = selected.getPointX();
        dungeon.mapY = selected.getPointY();
    }//GEN-LAST:event_btnSaveActionPerformed
    
    private JMapPoint selected;
    private DefaultListModel model;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listDungeons;
    private com.aurum.mystery2.swing.JMapPanel map;
    private javax.swing.JSpinner spnX;
    private javax.swing.JSpinner spnY;
    // End of variables declaration//GEN-END:variables
}