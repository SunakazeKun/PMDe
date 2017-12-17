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
import com.aurum.mystery2.Lists;
import com.aurum.mystery2.game.Move;
import com.aurum.mystery2.game.RomFile;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

public class MoveEditor extends AbstractEditor {
    private Move selected;
    
    private JLabel lblName, lblNamePointer, lblDescription, lblDescriptionPointer, lblLog, lblLogPointer;
    private JLabel lblJapUnk1, lblJapUnk1Pointer, lblJapUnk2, lblJapUnk2Pointer, lblJapNext, lblJapNextPointer;
    private JTextField txtName, txtNamePointer, txtDesc, txtDescPointer, txtLog, txtLogPointer;
    private JTextField txtJapUnk1, txtJapUnk1Pointer, txtJapUnk2, txtJapUnk2Pointer, txtJapNext, txtJapNextPointer;
    
    private JLabel lblType, lblRange, lblAP, lblCriticalHit, lblAccuracy1, lblAccuracy2;
    private JComboBox<String> cmoType, cmoRange;
    private JSpinner spnAP, spnCriticalHit, spnAccuracy1, spnAccuracy2;
    
    private JLabel lblUnk4, lblUnk8, lblUnkA, lblUnkD, lblUnk10, lblUsesPerRound, lblUnk12;
    private JSpinner spnUnk4, spnUnk8, spnUnkA, spnUnkD, spnUnk10, spnUsesPerRound, spnUnk12;
    private JCheckBox chkUnk14, chkUnk15, chkUnk16, chkUnk17, chkUnk18;
    
    public MoveEditor() {
        Lists.moves.stream().forEach((item) -> { model.addElement(item); });
        list.setSelectedIndex(0);
    }
    
    @Override
    protected void initProperties() {
        setTitle("Move editor");
        
        // Initialize the components
        lblName = new JLabel("Name");
        lblNamePointer = new JLabel("Name pointer");
        lblDescription = new JLabel("Description");
        lblDescriptionPointer = new JLabel("Description pointer");
        lblLog = new JLabel("Log");
        lblLogPointer = new JLabel("Log pointer");
        txtName = new JTextField();
        txtName.setEditable(false);
        txtNamePointer = new JTextField("00000000");
        txtNamePointer.setEditable(false);
        txtDesc = new JTextField();
        txtDesc.setEditable(false);
        txtDescPointer = new JTextField("00000000");
        txtDescPointer.setEditable(false);
        txtLog = new JTextField();
        txtLog.setEditable(false);
        txtLogPointer = new JTextField("00000000");
        txtLogPointer.setEditable(false);
        
        if (RomFile.current.isJapanese()) {
            lblJapUnk1 = new JLabel("Unk. string 1");
            lblJapUnk1Pointer = new JLabel("Unk. string 1 pointer");
            lblJapUnk2 = new JLabel("Unk. string 2");
            lblJapUnk2Pointer = new JLabel("Unk. string 2 pointer");
            lblJapNext = new JLabel("Next move");
            lblJapNextPointer = new JLabel("Next move pointer");
            
            txtJapUnk1 = new JTextField();
            txtJapUnk1.setEditable(false);
            txtJapUnk1Pointer = new JTextField("00000000");
            txtJapUnk1Pointer.setEditable(false);
            txtJapUnk2 = new JTextField();
            txtJapUnk2.setEditable(false);
            txtJapUnk2Pointer = new JTextField("00000000");
            txtJapUnk2Pointer.setEditable(false);
            txtJapNext = new JTextField();
            txtJapNext.setEditable(false);
            txtJapNextPointer = new JTextField("00000000");
            txtJapNextPointer.setEditable(false);
        }
        
        lblType = new JLabel("Type");
        lblRange = new JLabel("Range");
        lblAP = new JLabel("Attack points");
        lblCriticalHit = new JLabel("Critical Hit chance");
        lblUsesPerRound = new JLabel("Uses per round");
        lblAccuracy1 = new JLabel("Accuracy factor 1");
        lblAccuracy2 = new JLabel("Accuracy factor 2");
        cmoType = new JComboBox();
        cmoType.setModel(new DefaultComboBoxModel(Lists.types.toArray()));
        cmoRange = new JComboBox();
        cmoRange.setModel(new DefaultComboBoxModel(new String[] { "None", "3 tiles diagonally and in front", "Foes within 1-tile range", "Foe in front, cuts corners", "Partners on floor(?)", "Partners on floor(?)", "Pokémon on floor", "Foes on floor", "Unknown, unused", "Foe at side", "Special", "Foe in front", "Pokémon at side", "Foe up to 2 tiles ahead", "Foes in line", "Foes in room", "Allies in room", "Pokémon in room", "All except user", "User(?)", "User(?)", "User(?)", "Members in room", "Items", "Floor", "Wall", "Pokémon within 1-tile range", "Pokémon within 2-tiles range", "User, cuts corners", "Floor", "Pokémon in front" }));
        spnAP = new JSpinner();
        spnAP.setModel(new SpinnerNumberModel(Short.valueOf((short)0), Short.valueOf((short)0), Short.valueOf((short)255), Short.valueOf((short)1)));
        spnCriticalHit = new JSpinner();
        spnCriticalHit.setModel(new SpinnerNumberModel((byte)0, null, null, (byte)1));
        spnUsesPerRound = new JSpinner();
        spnUsesPerRound.setModel(new SpinnerNumberModel(Short.valueOf((short)0), Short.valueOf((short)0), Short.valueOf((short)255), Short.valueOf((short)1)));
        spnAccuracy1 = new JSpinner();
        spnAccuracy1.setModel(new SpinnerNumberModel((byte)0, null, null, (byte)1));
        spnAccuracy2 = new JSpinner();
        spnAccuracy2.setModel(new SpinnerNumberModel((byte)0, null, null, (byte)1));
        
        lblUnk4 = new JLabel("short (0x4)");
        lblUnk8 = new JLabel("short (0x8)");
        lblUnkA = new JLabel("short (0xA)");
        lblUnkD = new JLabel("byte (0xD)");
        lblUnk10 = new JLabel("byte (0x10)");
        lblUnk12 = new JLabel("byte (0x12)");
        spnUnk4 = new JSpinner();
        spnUnk4.setModel(new SpinnerNumberModel((short)0, null, null, (short)1));
        spnUnk8 = new JSpinner();
        spnUnk8.setModel(new SpinnerNumberModel((short)0, null, null, (short)1));
        spnUnkA = new JSpinner();
        spnUnkA.setModel(new SpinnerNumberModel((short)0, null, null, (short)1));
        spnUnkD = new JSpinner();
        spnUnkD.setModel(new SpinnerNumberModel((byte)0, null, null, (byte)1));
        spnUnk10 = new JSpinner();
        spnUnk10.setModel(new SpinnerNumberModel((byte)0, null, null, (byte)1));
        spnUnk12 = new JSpinner();
        spnUnk12.setModel(new SpinnerNumberModel((byte)0, null, null, (byte)1));
        chkUnk14 = new JCheckBox("bool (0x14)");
        chkUnk15 = new JCheckBox("bool (0x15)");
        chkUnk16 = new JCheckBox("bool (0x16)");
        chkUnk17 = new JCheckBox("bool (0x17)");
        chkUnk18 = new JCheckBox("bool (0x18)");
        
        // Add the components to the property panel
        properties.addCaption("Text");
        properties.addLabeledComponent(lblName, txtName);
        properties.addLabeledComponent(lblNamePointer, txtNamePointer);
        properties.addLabeledComponent(lblDescription, txtDesc);
        properties.addLabeledComponent(lblDescriptionPointer, txtDescPointer);
        properties.addLabeledComponent(lblLog, txtLog);
        properties.addLabeledComponent(lblLogPointer, txtLogPointer);
        if (RomFile.current.isJapanese()) {
            properties.addLabeledComponent(lblJapUnk1, txtJapUnk1);
            properties.addLabeledComponent(lblJapUnk1Pointer, txtJapUnk1Pointer);
            properties.addLabeledComponent(lblJapUnk2, txtJapUnk2);
            properties.addLabeledComponent(lblJapUnk2Pointer, txtJapUnk2Pointer);
            properties.addLabeledComponent(lblJapNext, txtJapNext);
            properties.addLabeledComponent(lblJapNextPointer, txtJapNextPointer);
        }
        properties.addSeparator();
        properties.addCaption("Misc.");
        properties.addLabeledComponent(lblType, cmoType);
        properties.addLabeledComponent(lblRange, cmoRange);
        properties.addLabeledComponent(lblAP, spnAP);
        properties.addLabeledComponent(lblCriticalHit, spnCriticalHit);
        properties.addLabeledComponent(lblUsesPerRound, spnUsesPerRound);
        properties.addLabeledComponent(lblAccuracy1, spnAccuracy1);
        properties.addLabeledComponent(lblAccuracy2, spnAccuracy2);
        properties.addSeparator();
        properties.addCaption("Unknown");
        properties.addLabeledComponent(lblUnk4, spnUnk4);
        properties.addLabeledComponent(lblUnk8, spnUnk8);
        properties.addLabeledComponent(lblUnkA, spnUnkA);
        properties.addLabeledComponent(lblUnkD, spnUnkD);
        properties.addLabeledComponent(lblUnk10, spnUnk10);
        properties.addLabeledComponent(lblUnk12, spnUnk12);
        properties.addComponent(chkUnk14);
        properties.addComponent(chkUnk15);
        properties.addComponent(chkUnk16);
        properties.addComponent(chkUnk17);
        properties.addComponent(chkUnk18);
        properties.addTerminator();
    }

    @Override
    protected void load() {
        if (list.getSelectedIndex() < 0)
            return;
        
        selected = (Move) RomFile.current.moves.get(list.getSelectedIndex()).clone();
        
        txtName.setText(selected.name);
        txtName.setCaretPosition(0);
        txtNamePointer.setText(BitConverter.toHexIntString(selected.namePointer));
        txtDesc.setText(selected.desc);
        txtDesc.setCaretPosition(0);
        txtDescPointer.setText(BitConverter.toHexIntString(selected.descPointer));
        txtLog.setText(selected.log);
        txtLog.setCaretPosition(0);
        txtLogPointer.setText(BitConverter.toHexIntString(selected.logPointer));
        
        cmoType.setSelectedIndex(selected.type);
        cmoRange.setSelectedIndex(selected.range);
        spnAP.setValue(selected.ap);
        spnCriticalHit.setValue(selected.critical);
        spnUsesPerRound.setValue(selected.usesPerRound);
        spnAccuracy1.setValue(selected.accuracy1);
        spnAccuracy2.setValue(selected.accuracy2);
        
        spnUnk4.setValue(selected.unk4);
        spnUnk8.setValue(selected.unk8);
        spnUnkA.setValue(selected.unkA);
        spnUnkD.setValue(selected.unkD);
        spnUnk10.setValue(selected.unk10);
        spnUnk12.setValue(selected.unk12);
        chkUnk14.setSelected(selected.unk14);
        chkUnk15.setSelected(selected.unk15);
        chkUnk16.setSelected(selected.unk16);
        chkUnk17.setSelected(selected.unk17);
        chkUnk18.setSelected(selected.unk18);
        
        if (RomFile.current.isJapanese()) {
            txtJapUnk1.setText(selected.japUnk1);
            txtJapUnk1.setCaretPosition(0);
            txtJapUnk1Pointer.setText(BitConverter.toHexIntString(selected.japUnk1Pointer));
            txtJapUnk2.setText(selected.japUnk2);
            txtJapUnk2.setCaretPosition(0);
            txtJapUnk2Pointer.setText(BitConverter.toHexIntString(selected.japUnk2Pointer));
            txtJapNext.setText(selected.japNext);
            txtJapNext.setCaretPosition(0);
            txtJapNextPointer.setText(BitConverter.toHexIntString(selected.japNextPointer));
        }
    }

    @Override
    protected void save() {
        if (selected == null || list.getSelectedIndex() < 0)
            return;
        
        selected.type = cmoType.getSelectedIndex();
        selected.range = (short) cmoRange.getSelectedIndex();
        selected.ap = (short) spnAP.getValue();
        selected.critical = (byte) spnCriticalHit.getValue();
        selected.usesPerRound = (short) spnUsesPerRound.getValue();
        selected.accuracy1 = (byte) spnAccuracy1.getValue();
        selected.accuracy2 = (byte) spnAccuracy2.getValue();
        
        selected.unk4 = (short) spnUnk4.getValue();
        selected.unk8 = (short) spnUnk8.getValue();
        selected.unkA = (short) spnUnkA.getValue();
        selected.unkD = (byte) spnUnkD.getValue();
        selected.unk10 = (byte) spnUnk10.getValue();
        selected.unk12 = (byte) spnUnk12.getValue();
        selected.unk14 = chkUnk14.isSelected();
        selected.unk15 = chkUnk15.isSelected();
        selected.unk16 = chkUnk16.isSelected();
        selected.unk17 = chkUnk17.isSelected();
        selected.unk18 = chkUnk18.isSelected();
        
        RomFile.current.moves.set(list.getSelectedIndex(), selected);
    }

    @Override
    protected void warningLabel() {}
}