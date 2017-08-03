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

import java.awt.Component;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import com.aurum.mystery2.Lists;
import com.aurum.mystery2.Main;
import com.aurum.mystery2.game.RomFile;
import com.aurum.mystery2.game.Dungeon;
import com.aurum.mystery2.game.Floor;

public class DungeonEditor extends javax.swing.JFrame {
    public DungeonEditor() {
        initComponents();
        Lists.dungeons.stream().forEach((dungeon) -> { model.addElement(dungeon); });
        listDungeons.setSelectedIndex(0);
        load();
    }
    
    private void load() {
        selectedDungeon = (Dungeon) RomFile.current.dungeons.get(listDungeons.getSelectedIndex()).clone();
        
        if (selectedDungeon.floors.size() > 0) {
            pnlFloors.setEnabled(true);
            spnFloorNo.setModel(new SpinnerNumberModel(1, 1,selectedDungeon.floors.size() - 1, 1));
            loadFloorData();
        }
        else {
            pnlFloors.setEnabled(false);
        }
        
        for (Component comp : pnlFloors.getComponents())
            comp.setEnabled(pnlFloors.isEnabled());
        
        cmoStairType.setSelectedIndex(selectedDungeon.stairDirection);
        spnTimerLimit.setValue(selectedDungeon.timer);
        chkRecruitable.setSelected(selectedDungeon.recruitable);
        chkCondLevel.setSelected(selectedDungeon.lvl1);
        chkCondMoney.setSelected(!selectedDungeon.noMoney);
        chkCondSave.setSelected(!selectedDungeon.saveGame);
        spnMaxItems.setValue(selectedDungeon.itemLimit);
        spnMaxParty.setValue(selectedDungeon.partyLimit);
        
        loadUnknownBytes();
    }
    
    private void loadFloorData() {
        selectedFloor = selectedDungeon.floors.get((int) spnFloorNo.getValue());
        spnFloorLayout.setValue(selectedFloor.layoutID);
        spnFloorPokemon.setValue(selectedFloor.pokemonID);
        spnFloorItems.setValue(selectedFloor.itemsID);
        spnFloorTraps.setValue(selectedFloor.trapsID);
        spnFloorUnknown1.setValue(selectedFloor.unk8);
        spnFloorUnknown2.setValue(selectedFloor.unkA);
        spnFloorUnknown3.setValue(selectedFloor.unkC);
        spnFloorUnknown4.setValue(selectedFloor.unkE);
    }
    
    private void loadUnknownBytes() {
        switch(cmoUnknownOffset.getSelectedIndex()) {
            case 0: txtUnknownValue.setText(String.valueOf(selectedDungeon.unk1)); break;
            case 1: txtUnknownValue.setText(String.valueOf(selectedDungeon.unk3)); break;
            case 2: txtUnknownValue.setText(String.valueOf(selectedDungeon.unk8)); break;
            case 3: txtUnknownValue.setText(String.valueOf(selectedDungeon.unkB)); break;
            case 4: txtUnknownValue.setText(String.valueOf(selectedDungeon.unkE)); break;
        }
    }
    
    private void save() {
        selectedDungeon.stairDirection = (short) cmoStairType.getSelectedIndex();
        selectedDungeon.timer = (int) spnTimerLimit.getValue();
        selectedDungeon.recruitable = chkRecruitable.isSelected();
        selectedDungeon.lvl1 = chkCondLevel.isSelected();
        selectedDungeon.noMoney = !chkCondMoney.isSelected();
        selectedDungeon.saveGame = !chkCondSave.isSelected();
        selectedDungeon.itemLimit = (short) spnMaxItems.getValue();
        selectedDungeon.partyLimit = (short) spnMaxParty.getValue();
        
        RomFile.current.dungeons.set(listDungeons.getSelectedIndex(), selectedDungeon);
    }
    
    private void saveFloorData() {
        selectedFloor.layoutID = (int) spnFloorLayout.getValue();
        selectedFloor.pokemonID = (int) spnFloorPokemon.getValue();
        selectedFloor.itemsID = (int) spnFloorItems.getValue();
        selectedFloor.trapsID = (int) spnFloorTraps.getValue();
        selectedFloor.unk8 = (int) spnFloorUnknown1.getValue();
        selectedFloor.unkA = (int) spnFloorUnknown2.getValue();
        selectedFloor.unkC = (int) spnFloorUnknown3.getValue();
        selectedFloor.unkE = (int) spnFloorUnknown4.getValue();
        selectedDungeon.floors.set((int) spnFloorNo.getValue(), selectedFloor);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlGeneral = new javax.swing.JPanel();
        lblStairType = new javax.swing.JLabel();
        lblTimerLimit = new javax.swing.JLabel();
        lblMaxItems = new javax.swing.JLabel();
        lblMaxParty = new javax.swing.JLabel();
        cmoStairType = new javax.swing.JComboBox<>();
        spnTimerLimit = new javax.swing.JSpinner();
        spnMaxItems = new javax.swing.JSpinner();
        spnMaxParty = new javax.swing.JSpinner();
        chkCondLevel = new javax.swing.JCheckBox();
        chkCondMoney = new javax.swing.JCheckBox();
        chkCondSave = new javax.swing.JCheckBox();
        chkRecruitable = new javax.swing.JCheckBox();
        pnlUnknown = new javax.swing.JPanel();
        lblOffset = new javax.swing.JLabel();
        lblValue = new javax.swing.JLabel();
        cmoUnknownOffset = new javax.swing.JComboBox<>();
        txtUnknownValue = new javax.swing.JTextField();
        pnlFloors = new javax.swing.JPanel();
        lblFloorNo = new javax.swing.JLabel();
        spnFloorNo = new javax.swing.JSpinner();
        lblFloorLayout = new javax.swing.JLabel();
        lblFloorPokemon = new javax.swing.JLabel();
        lblFloorItems = new javax.swing.JLabel();
        lblFloorTraps = new javax.swing.JLabel();
        lblFloorUnknown1 = new javax.swing.JLabel();
        lblFloorUnknown2 = new javax.swing.JLabel();
        lblFloorUnknown3 = new javax.swing.JLabel();
        lblFloorUnknown4 = new javax.swing.JLabel();
        spnFloorLayout = new javax.swing.JSpinner();
        spnFloorPokemon = new javax.swing.JSpinner();
        spnFloorItems = new javax.swing.JSpinner();
        spnFloorTraps = new javax.swing.JSpinner();
        spnFloorUnknown1 = new javax.swing.JSpinner();
        spnFloorUnknown2 = new javax.swing.JSpinner();
        spnFloorUnknown3 = new javax.swing.JSpinner();
        spnFloorUnknown4 = new javax.swing.JSpinner();
        btnFloorLayout = new javax.swing.JButton();
        btnFloorPokemon = new javax.swing.JButton();
        btnFloorItems = new javax.swing.JButton();
        btnFloorTraps = new javax.swing.JButton();
        btnSaveFloor = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listDungeons = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Dungeon editor");
        setIconImage(com.aurum.mystery2.Main.icon);
        setResizable(false);

        pnlGeneral.setBorder(javax.swing.BorderFactory.createTitledBorder("General"));

        lblStairType.setText("Stair direction");

        lblTimerLimit.setText("Timer limit");

        lblMaxItems.setText("Item limit");

        lblMaxParty.setText("Party limit");

        cmoStairType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00: Down", "01: Up" }));

        spnTimerLimit.setModel(new javax.swing.SpinnerNumberModel(0, 0, 65535, 1));
        spnTimerLimit.setEditor(new javax.swing.JSpinner.NumberEditor(spnTimerLimit, "0"));

        spnMaxItems.setModel(new javax.swing.SpinnerNumberModel(Short.valueOf((short)0), Short.valueOf((short)0), Short.valueOf((short)40), Short.valueOf((short)1)));

        spnMaxParty.setModel(new javax.swing.SpinnerNumberModel(Short.valueOf((short)0), Short.valueOf((short)0), Short.valueOf((short)4), Short.valueOf((short)1)));

        chkCondLevel.setText("Set level to 1");

        chkCondMoney.setText("Set money to 0");

        chkCondSave.setText("Save game");

        chkRecruitable.setText("Recruitable?");

        javax.swing.GroupLayout pnlGeneralLayout = new javax.swing.GroupLayout(pnlGeneral);
        pnlGeneral.setLayout(pnlGeneralLayout);
        pnlGeneralLayout.setHorizontalGroup(
            pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGeneralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlGeneralLayout.createSequentialGroup()
                        .addComponent(chkRecruitable)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlGeneralLayout.createSequentialGroup()
                        .addGroup(pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlGeneralLayout.createSequentialGroup()
                                .addComponent(chkCondSave)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(pnlGeneralLayout.createSequentialGroup()
                                .addGroup(pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblMaxParty)
                                    .addComponent(lblMaxItems)
                                    .addComponent(lblTimerLimit)
                                    .addComponent(lblStairType)
                                    .addComponent(chkCondMoney)
                                    .addComponent(chkCondLevel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmoStairType, javax.swing.GroupLayout.Alignment.TRAILING, 0, 100, Short.MAX_VALUE)
                                    .addComponent(spnTimerLimit, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(spnMaxItems, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(spnMaxParty, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addContainerGap())))
        );
        pnlGeneralLayout.setVerticalGroup(
            pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGeneralLayout.createSequentialGroup()
                .addGroup(pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStairType)
                    .addComponent(cmoStairType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spnTimerLimit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTimerLimit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaxItems)
                    .addComponent(spnMaxItems, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaxParty)
                    .addComponent(spnMaxParty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chkCondLevel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkCondMoney)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkCondSave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkRecruitable))
        );

        pnlUnknown.setBorder(javax.swing.BorderFactory.createTitledBorder("Unknown"));

        lblOffset.setText("Offset");

        lblValue.setText("Value");

        cmoUnknownOffset.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0x1 (Byte)", "0x3 (Byte)", "0x8 (Short)", "0xB (Byte)", "0xE (Short)" }));
        cmoUnknownOffset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmoUnknownOffsetActionPerformed(evt);
            }
        });

        txtUnknownValue.setEditable(false);
        txtUnknownValue.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        javax.swing.GroupLayout pnlUnknownLayout = new javax.swing.GroupLayout(pnlUnknown);
        pnlUnknown.setLayout(pnlUnknownLayout);
        pnlUnknownLayout.setHorizontalGroup(
            pnlUnknownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUnknownLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlUnknownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblOffset)
                    .addComponent(lblValue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addGroup(pnlUnknownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmoUnknownOffset, 0, 100, Short.MAX_VALUE)
                    .addComponent(txtUnknownValue))
                .addContainerGap())
        );
        pnlUnknownLayout.setVerticalGroup(
            pnlUnknownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUnknownLayout.createSequentialGroup()
                .addGroup(pnlUnknownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOffset)
                    .addComponent(cmoUnknownOffset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlUnknownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblValue)
                    .addComponent(txtUnknownValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pnlFloors.setBorder(javax.swing.BorderFactory.createTitledBorder("Floor data"));

        lblFloorNo.setText("Floor No.");

        spnFloorNo.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnFloorNoStateChanged(evt);
            }
        });

        lblFloorLayout.setText("Layout");

        lblFloorPokemon.setText("Pokémon");

        lblFloorItems.setText("Items");

        lblFloorTraps.setText("Traps");

        lblFloorUnknown1.setText("Unknown ID");

        lblFloorUnknown2.setText("Unknown ID");

        lblFloorUnknown3.setText("Unknown ID");

        lblFloorUnknown4.setText("Unknown ID");

        spnFloorLayout.setEditor(new javax.swing.JSpinner.NumberEditor(spnFloorLayout, "0"));

        spnFloorPokemon.setEditor(new javax.swing.JSpinner.NumberEditor(spnFloorPokemon, "0"));

        spnFloorItems.setEditor(new javax.swing.JSpinner.NumberEditor(spnFloorItems, "0"));

        spnFloorTraps.setEditor(new javax.swing.JSpinner.NumberEditor(spnFloorTraps, "0"));

        spnFloorUnknown1.setModel(new javax.swing.SpinnerNumberModel(0, 0, 65535, 1));
        spnFloorUnknown1.setEditor(new javax.swing.JSpinner.NumberEditor(spnFloorUnknown1, "0"));

        spnFloorUnknown2.setModel(new javax.swing.SpinnerNumberModel(0, 0, 65535, 1));
        spnFloorUnknown2.setEditor(new javax.swing.JSpinner.NumberEditor(spnFloorUnknown2, "0"));

        spnFloorUnknown3.setModel(new javax.swing.SpinnerNumberModel(0, 0, 65535, 1));
        spnFloorUnknown3.setEditor(new javax.swing.JSpinner.NumberEditor(spnFloorUnknown3, "0"));

        spnFloorUnknown4.setModel(new javax.swing.SpinnerNumberModel(0, 0, 65535, 1));
        spnFloorUnknown4.setEditor(new javax.swing.JSpinner.NumberEditor(spnFloorUnknown4, "0"));

        btnFloorLayout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/to-editor.png"))); // NOI18N
        btnFloorLayout.setText("Edit");
        btnFloorLayout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFloorLayoutActionPerformed(evt);
            }
        });

        btnFloorPokemon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/to-editor.png"))); // NOI18N
        btnFloorPokemon.setText("Edit");
        btnFloorPokemon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFloorPokemonActionPerformed(evt);
            }
        });

        btnFloorItems.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/to-editor.png"))); // NOI18N
        btnFloorItems.setText("Edit");
        btnFloorItems.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFloorItemsActionPerformed(evt);
            }
        });

        btnFloorTraps.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/to-editor.png"))); // NOI18N
        btnFloorTraps.setText("Edit");
        btnFloorTraps.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFloorTrapsActionPerformed(evt);
            }
        });

        btnSaveFloor.setText("Save floor");
        btnSaveFloor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveFloorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlFloorsLayout = new javax.swing.GroupLayout(pnlFloors);
        pnlFloors.setLayout(pnlFloorsLayout);
        pnlFloorsLayout.setHorizontalGroup(
            pnlFloorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFloorsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFloorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFloorsLayout.createSequentialGroup()
                        .addGroup(pnlFloorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlFloorsLayout.createSequentialGroup()
                                .addComponent(lblFloorNo)
                                .addGap(18, 18, 18)
                                .addComponent(spnFloorNo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlFloorsLayout.createSequentialGroup()
                                .addGroup(pnlFloorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblFloorTraps)
                                    .addComponent(lblFloorLayout)
                                    .addComponent(lblFloorPokemon)
                                    .addComponent(lblFloorItems)
                                    .addComponent(lblFloorUnknown1)
                                    .addComponent(lblFloorUnknown2)
                                    .addComponent(lblFloorUnknown3))
                                .addGap(30, 30, 30)
                                .addGroup(pnlFloorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(spnFloorUnknown3)
                                    .addComponent(spnFloorUnknown2)
                                    .addComponent(spnFloorUnknown1)
                                    .addComponent(spnFloorLayout, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(spnFloorTraps, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(spnFloorItems)
                                    .addComponent(spnFloorPokemon)
                                    .addComponent(spnFloorUnknown4))))
                        .addGap(10, 10, 10)
                        .addGroup(pnlFloorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnFloorPokemon)
                            .addComponent(btnFloorLayout, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnFloorItems)
                            .addComponent(btnFloorTraps)))
                    .addGroup(pnlFloorsLayout.createSequentialGroup()
                        .addGroup(pnlFloorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFloorUnknown4)
                            .addComponent(btnSaveFloor, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        pnlFloorsLayout.setVerticalGroup(
            pnlFloorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFloorsLayout.createSequentialGroup()
                .addGroup(pnlFloorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFloorNo)
                    .addComponent(spnFloorNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFloorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFloorLayout)
                    .addComponent(spnFloorLayout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFloorLayout))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFloorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFloorPokemon)
                    .addComponent(spnFloorPokemon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFloorPokemon))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFloorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFloorItems)
                    .addComponent(spnFloorItems, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFloorItems))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFloorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFloorTraps)
                    .addComponent(spnFloorTraps, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFloorTraps))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFloorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFloorUnknown1)
                    .addComponent(spnFloorUnknown1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFloorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFloorUnknown2)
                    .addComponent(spnFloorUnknown2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFloorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFloorUnknown3)
                    .addComponent(spnFloorUnknown3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFloorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFloorUnknown4)
                    .addComponent(spnFloorUnknown4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSaveFloor)
                .addContainerGap())
        );

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        listDungeons.setModel(model = new DefaultListModel());
        listDungeons.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listDungeons.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listDungeonsValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listDungeons);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlUnknown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlFloors, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlUnknown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jScrollPane1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnSave))
                        .addComponent(pnlFloors, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        save();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void cmoUnknownOffsetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmoUnknownOffsetActionPerformed
        loadUnknownBytes();
    }//GEN-LAST:event_cmoUnknownOffsetActionPerformed

    private void spnFloorNoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnFloorNoStateChanged
        loadFloorData();
    }//GEN-LAST:event_spnFloorNoStateChanged

    private void btnFloorLayoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFloorLayoutActionPerformed
        new DungeonLayoutEditor((int) spnFloorLayout.getValue()).setVisible(true);
    }//GEN-LAST:event_btnFloorLayoutActionPerformed

    private void btnFloorPokemonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFloorPokemonActionPerformed
        new DungeonPokemonEditor((int) spnFloorPokemon.getValue()).setVisible(true);
    }//GEN-LAST:event_btnFloorPokemonActionPerformed

    private void btnFloorItemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFloorItemsActionPerformed
        JOptionPane.showMessageDialog(this, "Item editing is not supported.", Main.name, JOptionPane.PLAIN_MESSAGE, null);
        //new DungeonItemEditor((int) spnFloorItems.getValue()).setVisible(true);
    }//GEN-LAST:event_btnFloorItemsActionPerformed

    private void btnFloorTrapsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFloorTrapsActionPerformed
        new DungeonTrapsEditor((int) spnFloorTraps.getValue()).setVisible(true);
    }//GEN-LAST:event_btnFloorTrapsActionPerformed

    private void btnSaveFloorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveFloorActionPerformed
        saveFloorData();
    }//GEN-LAST:event_btnSaveFloorActionPerformed

    private void listDungeonsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listDungeonsValueChanged
        load();
    }//GEN-LAST:event_listDungeonsValueChanged
    
    private DefaultListModel model;
    private Dungeon selectedDungeon;
    private Floor selectedFloor;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFloorItems;
    private javax.swing.JButton btnFloorLayout;
    private javax.swing.JButton btnFloorPokemon;
    private javax.swing.JButton btnFloorTraps;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSaveFloor;
    private javax.swing.JCheckBox chkCondLevel;
    private javax.swing.JCheckBox chkCondMoney;
    private javax.swing.JCheckBox chkCondSave;
    private javax.swing.JCheckBox chkRecruitable;
    private javax.swing.JComboBox<String> cmoStairType;
    private javax.swing.JComboBox<String> cmoUnknownOffset;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFloorItems;
    private javax.swing.JLabel lblFloorLayout;
    private javax.swing.JLabel lblFloorNo;
    private javax.swing.JLabel lblFloorPokemon;
    private javax.swing.JLabel lblFloorTraps;
    private javax.swing.JLabel lblFloorUnknown1;
    private javax.swing.JLabel lblFloorUnknown2;
    private javax.swing.JLabel lblFloorUnknown3;
    private javax.swing.JLabel lblFloorUnknown4;
    private javax.swing.JLabel lblMaxItems;
    private javax.swing.JLabel lblMaxParty;
    private javax.swing.JLabel lblOffset;
    private javax.swing.JLabel lblStairType;
    private javax.swing.JLabel lblTimerLimit;
    private javax.swing.JLabel lblValue;
    private javax.swing.JList<String> listDungeons;
    private javax.swing.JPanel pnlFloors;
    private javax.swing.JPanel pnlGeneral;
    private javax.swing.JPanel pnlUnknown;
    private javax.swing.JSpinner spnFloorItems;
    private javax.swing.JSpinner spnFloorLayout;
    private javax.swing.JSpinner spnFloorNo;
    private javax.swing.JSpinner spnFloorPokemon;
    private javax.swing.JSpinner spnFloorTraps;
    private javax.swing.JSpinner spnFloorUnknown1;
    private javax.swing.JSpinner spnFloorUnknown2;
    private javax.swing.JSpinner spnFloorUnknown3;
    private javax.swing.JSpinner spnFloorUnknown4;
    private javax.swing.JSpinner spnMaxItems;
    private javax.swing.JSpinner spnMaxParty;
    private javax.swing.JSpinner spnTimerLimit;
    private javax.swing.JTextField txtUnknownValue;
    // End of variables declaration//GEN-END:variables
}