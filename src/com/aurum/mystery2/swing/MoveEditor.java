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
        
        spnAP.setValue(selected.ap);
        spnAccuracy1.setValue(selected.accuracy1);
        spnAccuracy2.setValue(selected.accuracy2);
        spnPower.setValue(selected.power);
        spnCriticalHit.setValue(selected.critical);
        
        chkUnk14.setSelected(selected.unk14);
        chkUnk15.setSelected(selected.unk15);
        chkUnk16.setSelected(selected.unk16);
        chkUnk17.setSelected(selected.unk17);
        chkUnk18.setSelected(selected.unk18);
        
        txtNamePointer.setText(BitConverter.toHexIntString(selected.namePointer));
        txtDescriptionPointer.setText(BitConverter.toHexIntString(selected.descriptionPointer));
        txtLogPointer.setText(BitConverter.toHexIntString(selected.logPointer));
        
        if (RomFile.current.isJapanese()) {
            txtJapString1.setText(selected.unk1);
            txtJapString1.setCaretPosition(0);
            txtJapString2.setText(selected.unk2);
            txtJapString2.setCaretPosition(0);
            txtJapString3.setText(selected.unk3);
            txtJapString3.setCaretPosition(0);
            
            txtJapPointer1.setText(BitConverter.toHexIntString(selected.unk1Pointer));
            txtJapPointer2.setText(BitConverter.toHexIntString(selected.unk2Pointer));
            txtJapPointer3.setText(BitConverter.toHexIntString(selected.unk3Pointer));
        }
        
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
        }
    }
    
    private void save() {
        selected.type = cmoType.getSelectedIndex();
        selected.range = (short) cmoRange.getSelectedIndex();
        
        selected.ap = (short) spnAP.getValue();
        selected.accuracy1 = (byte) spnAccuracy1.getValue();
        selected.accuracy2 = (byte) spnAccuracy2.getValue();
        selected.power = (byte) spnPower.getValue();
        selected.critical = (byte) spnCriticalHit.getValue();
        
        selected.unk14 = chkUnk14.isSelected();
        selected.unk15 = chkUnk15.isSelected();
        selected.unk16 = chkUnk16.isSelected();
        selected.unk17 = chkUnk17.isSelected();
        selected.unk18 = chkUnk18.isSelected();
        
        RomFile.current.moves.set(listMoves.getSelectedIndex(), selected);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pneMain = new javax.swing.JPanel();
        lblName = new javax.swing.JLabel();
        lblDescription = new javax.swing.JLabel();
        lblLog = new javax.swing.JLabel();
        lblType = new javax.swing.JLabel();
        lblRange = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtDescription = new javax.swing.JTextField();
        txtLog = new javax.swing.JTextField();
        cmoType = new javax.swing.JComboBox<>();
        cmoRange = new javax.swing.JComboBox<>();
        pneFactors = new javax.swing.JPanel();
        lblAP = new javax.swing.JLabel();
        lblAccuracy1 = new javax.swing.JLabel();
        lblAccuracy2 = new javax.swing.JLabel();
        lblPower = new javax.swing.JLabel();
        lblCriticalHit = new javax.swing.JLabel();
        spnAP = new javax.swing.JSpinner();
        spnAccuracy1 = new javax.swing.JSpinner();
        spnAccuracy2 = new javax.swing.JSpinner();
        spnPower = new javax.swing.JSpinner();
        spnCriticalHit = new javax.swing.JSpinner();
        pneMisc = new javax.swing.JPanel();
        lblNamePointer = new javax.swing.JLabel();
        lblDescriptionPointer = new javax.swing.JLabel();
        lblLogPointer = new javax.swing.JLabel();
        txtNamePointer = new javax.swing.JTextField();
        txtDescriptionPointer = new javax.swing.JTextField();
        txtLogPointer = new javax.swing.JTextField();
        pneBools = new javax.swing.JPanel();
        chkUnk14 = new javax.swing.JCheckBox();
        chkUnk15 = new javax.swing.JCheckBox();
        chkUnk16 = new javax.swing.JCheckBox();
        chkUnk17 = new javax.swing.JCheckBox();
        chkUnk18 = new javax.swing.JCheckBox();
        pneUnknown = new javax.swing.JPanel();
        lblOffset = new javax.swing.JLabel();
        lblValue = new javax.swing.JLabel();
        cmoUnknownOffset = new javax.swing.JComboBox<>();
        txtUnknownValue = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        listMoves = new javax.swing.JList<>();
        btnSave = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblJapString1 = new javax.swing.JLabel();
        lblJapString2 = new javax.swing.JLabel();
        lblJapString3 = new javax.swing.JLabel();
        lblJapPointer1 = new javax.swing.JLabel();
        lblJapPointer2 = new javax.swing.JLabel();
        lblJapPointer3 = new javax.swing.JLabel();
        txtJapString1 = new javax.swing.JTextField();
        txtJapString2 = new javax.swing.JTextField();
        txtJapString3 = new javax.swing.JTextField();
        txtJapPointer1 = new javax.swing.JTextField();
        txtJapPointer2 = new javax.swing.JTextField();
        txtJapPointer3 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Move editor");
        setIconImage(com.aurum.mystery2.Main.icon);
        setResizable(false);

        pneMain.setBorder(javax.swing.BorderFactory.createTitledBorder("Main"));

        lblName.setText("Name");

        lblDescription.setText("Description");

        lblLog.setText("Log");

        lblType.setText("Type");

        lblRange.setText("Range");

        txtName.setEditable(false);

        txtDescription.setEditable(false);

        txtLog.setEditable(false);

        cmoRange.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00: None", "01: 3 tiles diagonally and in front", "02: Foes within 1-tile range", "03: Foe in front, cuts corners", "04: Partners on floor(?)", "05: Partners on floor(?)", "06: Pokémon on floor", "07: Foes on floor", "08: Unknown, unused", "09: Foe at side", "0A: Special", "0B: Foe in front", "0C: Pokémon at side", "0D: Foe up to 2 tiles ahead", "0E: Foes in line", "0F: Foes in room", "10: Allies in room", "11: Pokémon in room", "12: All except user", "13: User(?)", "14: User(?)", "15: User(?)", "16: Members in room", "17: Items", "18: Floor", "19: Wall", "1A: Pokémon within 1-tile range", "1B: Pokémon within 2-tiles range", "1C: User, cuts corners", "1D: Floor", "1E: Pokémon in front" }));

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
                            .addComponent(cmoType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmoRange, 0, 180, Short.MAX_VALUE))))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pneMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmoRange, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRange)))
        );

        pneFactors.setBorder(javax.swing.BorderFactory.createTitledBorder("Factors"));

        lblAP.setText("Attack points");

        lblAccuracy1.setText("Accuracy factor 1");

        lblAccuracy2.setText("Accuracy factor 2");

        lblPower.setText("Power");

        lblCriticalHit.setText("Critical Hit chance");

        spnAP.setModel(new javax.swing.SpinnerNumberModel(Short.valueOf((short)0), Short.valueOf((short)0), Short.valueOf((short)255), Short.valueOf((short)1)));

        spnAccuracy1.setModel(new javax.swing.SpinnerNumberModel((byte)0, null, null, (byte)1));

        spnAccuracy2.setModel(new javax.swing.SpinnerNumberModel((byte)0, null, null, (byte)1));

        spnPower.setModel(new javax.swing.SpinnerNumberModel((byte)0, null, null, (byte)1));

        spnCriticalHit.setModel(new javax.swing.SpinnerNumberModel((byte)0, null, null, (byte)1));

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
                        .addComponent(spnAP, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pneFactorsLayout.createSequentialGroup()
                        .addComponent(lblAccuracy1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(spnAccuracy1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pneFactorsLayout.createSequentialGroup()
                        .addComponent(lblAccuracy2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(spnAccuracy2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pneFactorsLayout.createSequentialGroup()
                        .addGroup(pneFactorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPower)
                            .addComponent(lblCriticalHit))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pneFactorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(spnCriticalHit, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(spnPower))))
                .addContainerGap())
        );
        pneFactorsLayout.setVerticalGroup(
            pneFactorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pneFactorsLayout.createSequentialGroup()
                .addGroup(pneFactorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAP)
                    .addComponent(spnAP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pneFactorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAccuracy1)
                    .addComponent(spnAccuracy1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pneFactorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAccuracy2)
                    .addComponent(spnAccuracy2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pneFactorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPower)
                    .addComponent(spnPower, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pneFactorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCriticalHit)
                    .addComponent(spnCriticalHit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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

        pneBools.setBorder(javax.swing.BorderFactory.createTitledBorder("Unknown bools"));

        chkUnk14.setText("bool (0x14)");

        chkUnk15.setText("bool (0x15)");
        chkUnk15.setToolTipText("");

        chkUnk16.setText("bool (0x16)");

        chkUnk17.setText("bool (0x17)");

        chkUnk18.setText("bool (0x18)");

        javax.swing.GroupLayout pneBoolsLayout = new javax.swing.GroupLayout(pneBools);
        pneBools.setLayout(pneBoolsLayout);
        pneBoolsLayout.setHorizontalGroup(
            pneBoolsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pneBoolsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pneBoolsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pneBoolsLayout.createSequentialGroup()
                        .addComponent(chkUnk14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(chkUnk15))
                    .addGroup(pneBoolsLayout.createSequentialGroup()
                        .addComponent(chkUnk18)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pneBoolsLayout.createSequentialGroup()
                        .addComponent(chkUnk16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(chkUnk17)))
                .addContainerGap())
        );
        pneBoolsLayout.setVerticalGroup(
            pneBoolsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pneBoolsLayout.createSequentialGroup()
                .addGroup(pneBoolsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkUnk14)
                    .addComponent(chkUnk15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pneBoolsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkUnk16)
                    .addComponent(chkUnk17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkUnk18)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pneUnknown.setBorder(javax.swing.BorderFactory.createTitledBorder("Unknown"));

        lblOffset.setText("Offset");

        lblValue.setText("Value");

        cmoUnknownOffset.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0x4 (Short)", "0x8 (Short)", "0xA (Short)", "0xD (Byte)", "0x10 (Byte)", "0x11 (Byte)" }));
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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pneUnknownLayout.createSequentialGroup()
                        .addComponent(lblOffset)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmoUnknownOffset, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pneUnknownLayout.createSequentialGroup()
                        .addComponent(lblValue)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtUnknownValue, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pneUnknownLayout.setVerticalGroup(
            pneUnknownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pneUnknownLayout.createSequentialGroup()
                .addGroup(pneUnknownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmoUnknownOffset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblOffset))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pneUnknownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUnknownValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblValue)))
        );

        listMoves.setModel(model = new DefaultListModel());
        listMoves.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listMoves.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listMovesValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listMoves);

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Japanese-only"));

        lblJapString1.setText("Unk. string 1");

        lblJapString2.setText("Unk. string 2");

        lblJapString3.setText("Unk. string 3");

        lblJapPointer1.setText("Pointer 1");

        lblJapPointer2.setText("Pointer 2");

        lblJapPointer3.setText("Pointer 3");

        txtJapString1.setEditable(false);

        txtJapString2.setEditable(false);

        txtJapString3.setEditable(false);

        txtJapPointer1.setEditable(false);
        txtJapPointer1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        txtJapPointer2.setEditable(false);
        txtJapPointer2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        txtJapPointer3.setEditable(false);
        txtJapPointer3.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblJapString1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                        .addComponent(txtJapString1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblJapString2)
                            .addComponent(lblJapString3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtJapString3, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                            .addComponent(txtJapString2)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblJapPointer1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtJapPointer1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblJapPointer2)
                            .addComponent(lblJapPointer3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtJapPointer3, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                            .addComponent(txtJapPointer2))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblJapString1)
                    .addComponent(txtJapString1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblJapString2)
                    .addComponent(txtJapString2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblJapString3)
                    .addComponent(txtJapString3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblJapPointer1)
                    .addComponent(txtJapPointer1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblJapPointer2)
                    .addComponent(txtJapPointer2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblJapPointer3)
                    .addComponent(txtJapPointer3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

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
                            .addComponent(pneMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pneUnknown, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pneBools, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pneFactors, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pneMisc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pneBools, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pneUnknown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
    private javax.swing.JCheckBox chkUnk14;
    private javax.swing.JCheckBox chkUnk15;
    private javax.swing.JCheckBox chkUnk16;
    private javax.swing.JCheckBox chkUnk17;
    private javax.swing.JCheckBox chkUnk18;
    private javax.swing.JComboBox<String> cmoRange;
    private javax.swing.JComboBox<String> cmoType;
    private javax.swing.JComboBox<String> cmoUnknownOffset;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAP;
    private javax.swing.JLabel lblAccuracy1;
    private javax.swing.JLabel lblAccuracy2;
    private javax.swing.JLabel lblCriticalHit;
    private javax.swing.JLabel lblDescription;
    private javax.swing.JLabel lblDescriptionPointer;
    private javax.swing.JLabel lblJapPointer1;
    private javax.swing.JLabel lblJapPointer2;
    private javax.swing.JLabel lblJapPointer3;
    private javax.swing.JLabel lblJapString1;
    private javax.swing.JLabel lblJapString2;
    private javax.swing.JLabel lblJapString3;
    private javax.swing.JLabel lblLog;
    private javax.swing.JLabel lblLogPointer;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNamePointer;
    private javax.swing.JLabel lblOffset;
    private javax.swing.JLabel lblPower;
    private javax.swing.JLabel lblRange;
    private javax.swing.JLabel lblType;
    private javax.swing.JLabel lblValue;
    private javax.swing.JList<String> listMoves;
    private javax.swing.JPanel pneBools;
    private javax.swing.JPanel pneFactors;
    private javax.swing.JPanel pneMain;
    private javax.swing.JPanel pneMisc;
    private javax.swing.JPanel pneUnknown;
    private javax.swing.JSpinner spnAP;
    private javax.swing.JSpinner spnAccuracy1;
    private javax.swing.JSpinner spnAccuracy2;
    private javax.swing.JSpinner spnCriticalHit;
    private javax.swing.JSpinner spnPower;
    private javax.swing.JTextField txtDescription;
    private javax.swing.JTextField txtDescriptionPointer;
    private javax.swing.JTextField txtJapPointer1;
    private javax.swing.JTextField txtJapPointer2;
    private javax.swing.JTextField txtJapPointer3;
    private javax.swing.JTextField txtJapString1;
    private javax.swing.JTextField txtJapString2;
    private javax.swing.JTextField txtJapString3;
    private javax.swing.JTextField txtLog;
    private javax.swing.JTextField txtLogPointer;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNamePointer;
    private javax.swing.JTextField txtUnknownValue;
    // End of variables declaration//GEN-END:variables
}