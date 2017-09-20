/*
 * Copyright (C) 2016 - 2017 Aurum
 *
 * Mystery is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Mystery is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.aurum.mystery2.swing;

import com.aurum.mystery2.game.RomFile;

public class MoneyEditor extends javax.swing.JFrame {

    public MoneyEditor() {
        initComponents();
        spnFactor.setValue(1);
        spnValue.setValue(RomFile.current.moneyfactors[0]);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblFactor = new javax.swing.JLabel();
        lblValue = new javax.swing.JLabel();
        spnFactor = new javax.swing.JSpinner();
        spnValue = new javax.swing.JSpinner();
        btnSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("POKé factors editor");
        setIconImage(com.aurum.mystery2.Main.icon);
        setResizable(false);

        lblFactor.setText("Factor");

        lblValue.setText("Value");

        spnFactor.setModel(new javax.swing.SpinnerNumberModel(1, 1, 100, 1));
        spnFactor.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnFactorStateChanged(evt);
            }
        });

        spnValue.setModel(new javax.swing.SpinnerNumberModel(Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(2147483647L), Long.valueOf(1L)));
        spnValue.setEditor(new javax.swing.JSpinner.NumberEditor(spnValue, "0"));

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
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblFactor)
                        .addGap(29, 29, 29)
                        .addComponent(spnFactor, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSave)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblValue)
                                .addGap(34, 34, 34)
                                .addComponent(spnValue)))
                        .addGap(10, 10, 10))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFactor)
                    .addComponent(spnFactor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblValue)
                    .addComponent(spnValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSave)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void spnFactorStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnFactorStateChanged
        spnValue.setValue(RomFile.current.moneyfactors[(int) spnFactor.getValue() - 1]);
    }//GEN-LAST:event_spnFactorStateChanged

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        RomFile.current.moneyfactors[(int) spnFactor.getValue() - 1] = (long) spnValue.getValue();
    }//GEN-LAST:event_btnSaveActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel lblFactor;
    private javax.swing.JLabel lblValue;
    private javax.swing.JSpinner spnFactor;
    private javax.swing.JSpinner spnValue;
    // End of variables declaration//GEN-END:variables
}