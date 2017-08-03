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

import javax.swing.DefaultListModel;
import com.aurum.mystery2.Lists;
import com.aurum.mystery2.game.RomFile;
import com.aurum.mystery2.BitConverter;
import com.aurum.mystery2.game.Move;

public class MoveEditor extends javax.swing.JFrame {
    public MoveEditor() {
        initComponents();
        Lists.moves.stream().forEach((move) -> { model.addElement(move); });
        Lists.types.stream().forEach((type) -> { cmoType.addItem(type); });
        listMoves.setSelectedIndex(0);
    }
    
    private void load() {
        if (cmoType.getItemCount() != Lists.types.size())
            return;
        
        selected = (Move) RomFile.current.moves.get(listMoves.getSelectedIndex()).clone();
        
        txtName.setText(selected.name);
        txtName.setCaretPosition(0);
        txtDescription.setText(selected.description);
        txtDescription.setCaretPosition(0);
        txtLog.setText(selected.log);
        txtLog.setCaretPosition(0);
        cmoType.setSelectedIndex(selected.type);
        cmoRange.setSelectedIndex(selected.range);
        txtAP.setText(String.valueOf(selected.ap));
        txtAccuracy1.setText(String.valueOf(selected.accuracy1));
        txtAccuracy2.setText(String.valueOf(selected.accuracy2));
        txtPower.setText(String.valueOf(selected.power));
        txtCriticalHit.setText(String.valueOf(selected.critical));
            
        txtNamePointer.setText(BitConverter.toHexIntString(selected.namePointer));
        txtDescriptionPointer.setText(BitConverter.toHexIntString(selected.descriptionPointer));
        txtLogPointer.setText(BitConverter.toHexIntString(selected.logPointer));
        
        loadUnknownBytes();
    }
    
    private void loadUnknownBytes() {
        switch(cmoUnknownOffset.getSelectedIndex()) {
            case 0: txtUnknownValue.setText(String.valueOf(selected.unk4)); break;
            case 1: txtUnknownValue.setText(String.valueOf(selected.unk8)); break;
            case 2: txtUnknownValue.setText(String.valueOf(selected.unkA)); break;
            case 3: txtUnknownValue.setText(String.valueOf(selected.unkD)); break;
            case 4: txtUnknownValue.setText(String.valueOf(selected.unk10)); break;
            case 5: txtUnknownValue.setText(String.valueOf(selected.unk11)); break;
            case 6: txtUnknownValue.setText(String.valueOf(selected.unk14)); break;
            case 7: txtUnknownValue.setText(String.valueOf(selected.unk15)); break;
            case 8: txtUnknownValue.setText(String.valueOf(selected.unk16)); break;
            case 9: txtUnknownValue.setText(String.valueOf(selected.unk17)); break;
            case 10: txtUnknownValue.setText(String.valueOf(selected.unk18)); break;
        }
    }
    
    private void save() {
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pneMain = new javax.swing.JPanel();
        lblName = new javax.swing.JLabel();
        lblDescription = new javax.swing.JLabel();
        lblLog = new javax.swing.JLabel();
        lblType = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtDescription = new javax.swing.JTextField();
        txtLog = new javax.swing.JTextField();
        cmoType = new javax.swing.JComboBox<>();
        cmoRange = new javax.swing.JComboBox<>();
        lblRange = new javax.swing.JLabel();
        pneMisc = new javax.swing.JPanel();
        lblNamePointer = new javax.swing.JLabel();
        lblDescriptionPointer = new javax.swing.JLabel();
        lblLogPointer = new javax.swing.JLabel();
        txtNamePointer = new javax.swing.JTextField();
        txtDescriptionPointer = new javax.swing.JTextField();
        txtLogPointer = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listMoves = new javax.swing.JList<>();
        pneFactors = new javax.swing.JPanel();
        lblAP = new javax.swing.JLabel();
        txtAP = new javax.swing.JTextField();
        txtAccuracy1 = new javax.swing.JTextField();
        txtAccuracy2 = new javax.swing.JTextField();
        txtPower = new javax.swing.JTextField();
        txtCriticalHit = new javax.swing.JTextField();
        lblAccuracy1 = new javax.swing.JLabel();
        lblAccuracy2 = new javax.swing.JLabel();
        lblPower = new javax.swing.JLabel();
        lblCriticalHit = new javax.swing.JLabel();
        pneUnknown = new javax.swing.JPanel();
        lblOffset = new javax.swing.JLabel();
        lblValue = new javax.swing.JLabel();
        cmoUnknownOffset = new javax.swing.JComboBox<>();
        txtUnknownValue = new javax.swing.JTextField();
        lblNoEdit = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Move editor");
        setIconImage(com.aurum.mystery2.Main.icon);
        setResizable(false);

        pneMain.setBorder(javax.swing.BorderFactory.createTitledBorder("Main"));

        lblName.setText("Name");

        lblDescription.setText("Description");

        lblLog.setText("Log");

        lblType.setText("Type");

        txtName.setEditable(false);

        txtDescription.setEditable(false);

        txtLog.setEditable(false);

        cmoRange.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00: None", "01: 3 tiles diagonally and in front", "02: Foes within 1-tile range", "03: Foe in front, cuts corners", "04: Partners on floor(?)", "05: Partners on floor(?)", "06: Pokémon on floor", "07: Foes on floor", "08: Unknown, unused", "09: Foe at side", "0A: Special", "0B: Foe in front", "0C: Pokémon at side", "0D: Foe up to 2 tiles ahead", "0E: Foes in line", "0F: Foes in room", "10: Allies in room", "11: Pokémon in room", "12: All except user", "13: User(?)", "14: User(?)", "15: User(?)", "16: Members in room", "17: Items", "18: Floor", "19: Wall", "1A: Pokémon within 1-tile range", "1B: Pokémon within 2-tile range", "1C: User, cuts corners", "1D: Floor", "1E: Pokémon in front" }));

        lblRange.setText("Range");

        javax.swing.GroupLayout pneMainLayout = new javax.swing.GroupLayout(pneMain);
        pneMain.setLayout(pneMainLayout);
        pneMainLayout.setHorizontalGroup(
            pneMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pneMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pneMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pneMainLayout.createSequentialGroup()
                        .addGroup(pneMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblName)
                            .addComponent(lblDescription)
                            .addComponent(lblLog))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                        .addGroup(pneMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtLog, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(txtDescription, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtName, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pneMainLayout.createSequentialGroup()
                        .addGroup(pneMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblType)
                            .addComponent(lblRange))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pneMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmoRange, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmoType, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        pneMainLayout.setVerticalGroup(
            pneMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pneMainLayout.createSequentialGroup()
                .addGroup(pneMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pneMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDescription))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pneMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLog))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pneMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmoType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblType))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pneMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmoRange, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRange))
                .addContainerGap())
        );

        pneMisc.setBorder(javax.swing.BorderFactory.createTitledBorder("Misc."));

        lblNamePointer.setText("Name pointer");

        lblDescriptionPointer.setText("Description pointer");

        lblLogPointer.setText("Log pointer");

        txtNamePointer.setEditable(false);
        txtNamePointer.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        txtDescriptionPointer.setEditable(false);
        txtDescriptionPointer.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        txtLogPointer.setEditable(false);
        txtLogPointer.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        javax.swing.GroupLayout pneMiscLayout = new javax.swing.GroupLayout(pneMisc);
        pneMisc.setLayout(pneMiscLayout);
        pneMiscLayout.setHorizontalGroup(
            pneMiscLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pneMiscLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pneMiscLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNamePointer)
                    .addComponent(lblDescriptionPointer)
                    .addComponent(lblLogPointer))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pneMiscLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtLogPointer, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(txtDescriptionPointer, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(txtNamePointer))
                .addContainerGap())
        );
        pneMiscLayout.setVerticalGroup(
            pneMiscLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pneMiscLayout.createSequentialGroup()
                .addGroup(pneMiscLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNamePointer)
                    .addComponent(txtNamePointer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pneMiscLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDescriptionPointer)
                    .addComponent(txtDescriptionPointer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pneMiscLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLogPointer)
                    .addComponent(txtLogPointer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnSave.setText("Save");
        btnSave.setEnabled(false);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        listMoves.setModel(model = new DefaultListModel());
        listMoves.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listMoves.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listMovesValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listMoves);

        pneFactors.setBorder(javax.swing.BorderFactory.createTitledBorder("Factors"));

        lblAP.setText("Attack points");

        txtAP.setEditable(false);
        txtAP.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        txtAccuracy1.setEditable(false);
        txtAccuracy1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        txtAccuracy2.setEditable(false);
        txtAccuracy2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        txtPower.setEditable(false);
        txtPower.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        txtCriticalHit.setEditable(false);
        txtCriticalHit.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        lblAccuracy1.setText("Accuracy factor 1");

        lblAccuracy2.setText("Accuracy factor 2");

        lblPower.setText("Power");

        lblCriticalHit.setText("Critical Hit chance");

        javax.swing.GroupLayout pneFactorsLayout = new javax.swing.GroupLayout(pneFactors);
        pneFactors.setLayout(pneFactorsLayout);
        pneFactorsLayout.setHorizontalGroup(
            pneFactorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pneFactorsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pneFactorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pneFactorsLayout.createSequentialGroup()
                        .addComponent(lblAP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtAP, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pneFactorsLayout.createSequentialGroup()
                        .addComponent(lblAccuracy1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                        .addComponent(txtAccuracy1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pneFactorsLayout.createSequentialGroup()
                        .addComponent(lblAccuracy2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtAccuracy2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pneFactorsLayout.createSequentialGroup()
                        .addComponent(lblCriticalHit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtCriticalHit, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pneFactorsLayout.createSequentialGroup()
                        .addComponent(lblPower)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtPower, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pneFactorsLayout.setVerticalGroup(
            pneFactorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pneFactorsLayout.createSequentialGroup()
                .addGroup(pneFactorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAP)
                    .addComponent(txtAP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pneFactorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAccuracy1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAccuracy1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pneFactorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAccuracy2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAccuracy2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pneFactorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPower, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPower))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pneFactorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCriticalHit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCriticalHit))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pneUnknown.setBorder(javax.swing.BorderFactory.createTitledBorder("Unknown"));

        lblOffset.setText("Offset");

        lblValue.setText("Value");

        cmoUnknownOffset.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0x4 (Short)", "0x8 (Short)", "0xA (Short)", "0xD (Byte)", "0x10 (Byte)", "0x11 (Byte)", "0x14 (Boolean)", "0x15 (Boolean)", "0x16 (Boolean)", "0x17 (Boolean)", "0x18 (Boolean)" }));
        cmoUnknownOffset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmoUnknownOffsetActionPerformed(evt);
            }
        });

        txtUnknownValue.setEditable(false);
        txtUnknownValue.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        javax.swing.GroupLayout pneUnknownLayout = new javax.swing.GroupLayout(pneUnknown);
        pneUnknown.setLayout(pneUnknownLayout);
        pneUnknownLayout.setHorizontalGroup(
            pneUnknownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pneUnknownLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pneUnknownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblOffset)
                    .addComponent(lblValue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pneUnknownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtUnknownValue)
                    .addComponent(cmoUnknownOffset, 0, 125, Short.MAX_VALUE))
                .addContainerGap())
        );
        pneUnknownLayout.setVerticalGroup(
            pneUnknownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pneUnknownLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pneUnknownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOffset)
                    .addComponent(cmoUnknownOffset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pneUnknownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblValue)
                    .addComponent(txtUnknownValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblNoEdit.setForeground(new java.awt.Color(255, 0, 0));
        lblNoEdit.setText("Move editing is not available at the moment.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pneMisc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pneMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNoEdit)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pneFactors, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pneUnknown, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pneMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pneFactors, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pneMisc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pneUnknown, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(lblNoEdit))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        save();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void listMovesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listMovesValueChanged
        load();
    }//GEN-LAST:event_listMovesValueChanged

    private void cmoUnknownOffsetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmoUnknownOffsetActionPerformed
        loadUnknownBytes();
    }//GEN-LAST:event_cmoUnknownOffsetActionPerformed
    
    private DefaultListModel model;
    private Move selected;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cmoRange;
    private javax.swing.JComboBox<String> cmoType;
    private javax.swing.JComboBox<String> cmoUnknownOffset;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAP;
    private javax.swing.JLabel lblAccuracy1;
    private javax.swing.JLabel lblAccuracy2;
    private javax.swing.JLabel lblCriticalHit;
    private javax.swing.JLabel lblDescription;
    private javax.swing.JLabel lblDescriptionPointer;
    private javax.swing.JLabel lblLog;
    private javax.swing.JLabel lblLogPointer;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNamePointer;
    private javax.swing.JLabel lblNoEdit;
    private javax.swing.JLabel lblOffset;
    private javax.swing.JLabel lblPower;
    private javax.swing.JLabel lblRange;
    private javax.swing.JLabel lblType;
    private javax.swing.JLabel lblValue;
    private javax.swing.JList<String> listMoves;
    private javax.swing.JPanel pneFactors;
    private javax.swing.JPanel pneMain;
    private javax.swing.JPanel pneMisc;
    private javax.swing.JPanel pneUnknown;
    private javax.swing.JTextField txtAP;
    private javax.swing.JTextField txtAccuracy1;
    private javax.swing.JTextField txtAccuracy2;
    private javax.swing.JTextField txtCriticalHit;
    private javax.swing.JTextField txtDescription;
    private javax.swing.JTextField txtDescriptionPointer;
    private javax.swing.JTextField txtLog;
    private javax.swing.JTextField txtLogPointer;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNamePointer;
    private javax.swing.JTextField txtPower;
    private javax.swing.JTextField txtUnknownValue;
    // End of variables declaration//GEN-END:variables
}