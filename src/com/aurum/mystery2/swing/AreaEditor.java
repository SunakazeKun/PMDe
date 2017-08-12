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

import com.aurum.mystery2.BitConverter;
import javax.swing.DefaultListModel;
import com.aurum.mystery2.Lists;
import com.aurum.mystery2.game.RomFile;
import com.aurum.mystery2.game.Area;

public class AreaEditor extends javax.swing.JFrame {
    public AreaEditor() {
        initComponents();
        Lists.areas.stream().forEach((area) -> { model.addElement(area); });
        listAreas.setSelectedIndex(0);
    }
    
    private void load() {
        selected = (Area) RomFile.current.areas.get(listAreas.getSelectedIndex()).clone();
        
        txtName.setText(selected.name);
        txtName.setCaretPosition(0);
        txtNamePointer.setText(BitConverter.toHexIntString(selected.namePointer));
        
        spnCount.setValue(selected.count);
        cmoCondition.setSelectedIndex(selected.condition);
        spnPrice.setValue(selected.price);
    }
    
    private void save() {
        selected.count = (int) spnCount.getValue();
        selected.condition = cmoCondition.getSelectedIndex();
        selected.price = (long) spnPrice.getValue();
        
        RomFile.current.areas.set(listAreas.getSelectedIndex(), selected);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pneMain = new javax.swing.JPanel();
        lblName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblCount = new javax.swing.JLabel();
        spnCount = new javax.swing.JSpinner();
        cmoCondition = new javax.swing.JComboBox<>();
        lblCondition = new javax.swing.JLabel();
        spnPrice = new javax.swing.JSpinner();
        lblPrice = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listAreas = new javax.swing.JList<>();
        pneMisc = new javax.swing.JPanel();
        lblNamePointer = new javax.swing.JLabel();
        txtNamePointer = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Area editor");
        setIconImage(com.aurum.mystery2.Main.icon);
        setResizable(false);

        pneMain.setBorder(javax.swing.BorderFactory.createTitledBorder("Main"));

        lblName.setText("Name");

        txtName.setEditable(false);
        txtName.setToolTipText("");

        lblCount.setText("No. of Pokémon");

        spnCount.setModel(new javax.swing.SpinnerNumberModel(0, 0, 15, 1));

        cmoCondition.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0x0: Shop (Story-game)", "0x1: Shop (Post-game)", "0x2: Wonder mail event", "0x3: Legendary request" }));

        lblCondition.setText("Unlock condition");

        spnPrice.setModel(new javax.swing.SpinnerNumberModel(Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(99999L), Long.valueOf(1L)));

        lblPrice.setText("Price");

        javax.swing.GroupLayout pneMainLayout = new javax.swing.GroupLayout(pneMain);
        pneMain.setLayout(pneMainLayout);
        pneMainLayout.setHorizontalGroup(
            pneMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pneMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pneMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblName)
                    .addComponent(lblCount)
                    .addComponent(lblCondition)
                    .addComponent(lblPrice))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pneMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(spnPrice)
                    .addComponent(cmoCondition, 0, 165, Short.MAX_VALUE)
                    .addComponent(txtName)
                    .addComponent(spnCount))
                .addContainerGap())
        );
        pneMainLayout.setVerticalGroup(
            pneMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pneMainLayout.createSequentialGroup()
                .addGroup(pneMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pneMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCount)
                    .addComponent(spnCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pneMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmoCondition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCondition))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pneMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spnPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPrice)))
        );

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        listAreas.setModel(model = new DefaultListModel());
        listAreas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listAreas.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listAreasValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listAreas);

        pneMisc.setBorder(javax.swing.BorderFactory.createTitledBorder("Misc."));

        lblNamePointer.setText("Name pointer");
        lblNamePointer.setToolTipText("");

        txtNamePointer.setEditable(false);
        txtNamePointer.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        javax.swing.GroupLayout pneMiscLayout = new javax.swing.GroupLayout(pneMisc);
        pneMisc.setLayout(pneMiscLayout);
        pneMiscLayout.setHorizontalGroup(
            pneMiscLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pneMiscLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNamePointer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
                .addComponent(txtNamePointer, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pneMiscLayout.setVerticalGroup(
            pneMiscLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pneMiscLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblNamePointer)
                .addComponent(txtNamePointer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pneMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pneMisc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pneMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pneMisc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSave)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        save();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void listAreasValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listAreasValueChanged
        load();
    }//GEN-LAST:event_listAreasValueChanged
    
    private DefaultListModel model;
    private Area selected;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cmoCondition;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCondition;
    private javax.swing.JLabel lblCount;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNamePointer;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JList<String> listAreas;
    private javax.swing.JPanel pneMain;
    private javax.swing.JPanel pneMisc;
    private javax.swing.JSpinner spnCount;
    private javax.swing.JSpinner spnPrice;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNamePointer;
    // End of variables declaration//GEN-END:variables
}