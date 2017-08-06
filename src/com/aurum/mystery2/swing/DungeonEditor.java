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
        chkRecruitable.setSelected(selectedDungeon.setRecruitable);
        chkCondLevel.setSelected(selectedDungeon.setLvl1);
        chkCondMoney.setSelected(selectedDungeon.setNoMoney);
        chkCondSave.setSelected(selectedDungeon.setSaveGame);
        spnMaxItems.setValue(selectedDungeon.itemLimit);
        spnMaxParty.setValue(selectedDungeon.partyLimit);
        chkHMFly.setSelected(selectedDungeon.condFly);
        chkHMDive.setSelected(selectedDungeon.condDive);
        chkHMWaterfall.setSelected(selectedDungeon.condWaterfall);
        chkHMSurf.setSelected(selectedDungeon.condSurf);
        chkWaterType.setSelected(selectedDungeon.condWater);
        spnUnk1.setValue(selectedDungeon.unk1);
        spnUnk3.setValue(selectedDungeon.unk3);
        chkUnk8.setSelected(selectedDungeon.unk8);
        chkUnk9.setSelected(selectedDungeon.unk9);
        spnUnkE.setValue(selectedDungeon.unkE);
    }
    
    private void loadFloorData() {
        selectedFloor = selectedDungeon.floors.get((int) spnFloorNo.getValue());
        spnFloorLayout.setValue(selectedFloor.layoutID);
        spnFloorPokemon.setValue(selectedFloor.pokemonID);
        spnFloorItems.setValue(selectedFloor.itemsID);
        spnFloorTraps.setValue(selectedFloor.trapsID);
        spnFloorItemsShop.setValue(selectedFloor.itemsShopID);
        spnFloorItemsMonster.setValue(selectedFloor.itemsMonsterID);
        spnFloorItemsBuried.setValue(selectedFloor.itemsBuriedID);
    }
    
    private void save() {
        selectedDungeon.stairDirection = (short) cmoStairType.getSelectedIndex();
        selectedDungeon.timer = (int) spnTimerLimit.getValue();
        selectedDungeon.setRecruitable = chkRecruitable.isSelected();
        selectedDungeon.setLvl1 = chkCondLevel.isSelected();
        selectedDungeon.setNoMoney = chkCondMoney.isSelected();
        selectedDungeon.setSaveGame = chkCondSave.isSelected();
        selectedDungeon.itemLimit = (short) spnMaxItems.getValue();
        selectedDungeon.partyLimit = (short) spnMaxParty.getValue();
        selectedDungeon.condFly = chkHMFly.isSelected();
        selectedDungeon.condDive = chkHMDive.isSelected();
        selectedDungeon.condWaterfall = chkHMWaterfall.isSelected();
        selectedDungeon.condSurf = chkHMSurf.isSelected();
        selectedDungeon.condWater = chkWaterType.isSelected();
        selectedDungeon.unk1 = (byte) spnUnk1.getValue();
        selectedDungeon.unk3 = (short) spnUnk3.getValue();
        selectedDungeon.unk8 = chkUnk8.isSelected();
        selectedDungeon.unk9 = chkUnk9.isSelected();
        selectedDungeon.unkE = (short) spnUnkE.getValue();
        
        RomFile.current.dungeons.set(listDungeons.getSelectedIndex(), selectedDungeon);
    }
    
    private void saveFloorData() {
        selectedFloor.layoutID = (int) spnFloorLayout.getValue();
        selectedFloor.pokemonID = (int) spnFloorPokemon.getValue();
        selectedFloor.itemsID = (int) spnFloorItems.getValue();
        selectedFloor.trapsID = (int) spnFloorTraps.getValue();
        selectedFloor.itemsShopID = (int) spnFloorItemsShop.getValue();
        selectedFloor.itemsMonsterID = (int) spnFloorItemsMonster.getValue();
        selectedFloor.itemsBuriedID = (int) spnFloorItemsBuried.getValue();
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
        lblUnk1 = new javax.swing.JLabel();
        lblUnk3 = new javax.swing.JLabel();
        lblUnkE = new javax.swing.JLabel();
        spnUnk1 = new javax.swing.JSpinner();
        spnUnk3 = new javax.swing.JSpinner();
        spnUnkE = new javax.swing.JSpinner();
        chkUnk8 = new javax.swing.JCheckBox();
        chkUnk9 = new javax.swing.JCheckBox();
        pnlFloors = new javax.swing.JPanel();
        lblFloorNo = new javax.swing.JLabel();
        spnFloorNo = new javax.swing.JSpinner();
        lblFloorLayout = new javax.swing.JLabel();
        lblFloorPokemon = new javax.swing.JLabel();
        lblFloorItems = new javax.swing.JLabel();
        lblFloorTraps = new javax.swing.JLabel();
        lblFloorItemsShop = new javax.swing.JLabel();
        lblFloorItemsMonster = new javax.swing.JLabel();
        lblFloorItemsBuried = new javax.swing.JLabel();
        spnFloorLayout = new javax.swing.JSpinner();
        spnFloorPokemon = new javax.swing.JSpinner();
        spnFloorItems = new javax.swing.JSpinner();
        spnFloorTraps = new javax.swing.JSpinner();
        spnFloorItemsShop = new javax.swing.JSpinner();
        spnFloorItemsMonster = new javax.swing.JSpinner();
        spnFloorItemsBuried = new javax.swing.JSpinner();
        btnFloorLayout = new javax.swing.JButton();
        btnFloorPokemon = new javax.swing.JButton();
        btnFloorItems = new javax.swing.JButton();
        btnFloorTraps = new javax.swing.JButton();
        btnSaveFloor = new javax.swing.JButton();
        btnFloorItemsShop = new javax.swing.JButton();
        btnFloorItemsMonster = new javax.swing.JButton();
        btnFloorItemsBuried = new javax.swing.JButton();
        pnlEntrance = new javax.swing.JPanel();
        chkHMFly = new javax.swing.JCheckBox();
        chkHMDive = new javax.swing.JCheckBox();
        chkHMSurf = new javax.swing.JCheckBox();
        chkWaterType = new javax.swing.JCheckBox();
        chkHMWaterfall = new javax.swing.JCheckBox();
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
                    .addComponent(lblMaxParty)
                    .addComponent(lblMaxItems)
                    .addComponent(lblTimerLimit)
                    .addComponent(lblStairType)
                    .addComponent(chkCondMoney)
                    .addComponent(chkCondLevel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 4, Short.MAX_VALUE)
                .addGroup(pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chkCondSave)
                    .addGroup(pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(cmoStairType, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(spnTimerLimit, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(spnMaxItems, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(spnMaxParty, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(chkRecruitable))
                .addContainerGap())
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
                .addGroup(pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkCondLevel)
                    .addComponent(chkCondSave))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkCondMoney)
                    .addComponent(chkRecruitable))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlUnknown.setBorder(javax.swing.BorderFactory.createTitledBorder("Unknown"));

        lblUnk1.setText("byte (0x1)");
        lblUnk1.setToolTipText("");

        lblUnk3.setText("ubyte (0x3)");

        lblUnkE.setText("short (0xE)");

        spnUnk1.setModel(new javax.swing.SpinnerNumberModel((byte)0, null, null, (byte)1));

        spnUnk3.setModel(new javax.swing.SpinnerNumberModel(Short.valueOf((short)0), Short.valueOf((short)0), Short.valueOf((short)255), Short.valueOf((short)1)));

        spnUnkE.setModel(new javax.swing.SpinnerNumberModel((short)0, null, null, (short)1));

        chkUnk8.setText("bool (0x8) (seen in post-game dungeons)");

        chkUnk9.setText("bool (0x9) (seen in story-game dungeons)");

        javax.swing.GroupLayout pnlUnknownLayout = new javax.swing.GroupLayout(pnlUnknown);
        pnlUnknown.setLayout(pnlUnknownLayout);
        pnlUnknownLayout.setHorizontalGroup(
            pnlUnknownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUnknownLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlUnknownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlUnknownLayout.createSequentialGroup()
                        .addComponent(lblUnkE)
                        .addGap(21, 21, 21)
                        .addComponent(spnUnkE, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlUnknownLayout.createSequentialGroup()
                        .addGroup(pnlUnknownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlUnknownLayout.createSequentialGroup()
                                .addComponent(lblUnk1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(spnUnk1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlUnknownLayout.createSequentialGroup()
                                .addComponent(lblUnk3)
                                .addGap(18, 18, 18)
                                .addComponent(spnUnk3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(pnlUnknownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkUnk8)
                            .addComponent(chkUnk9))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlUnknownLayout.setVerticalGroup(
            pnlUnknownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUnknownLayout.createSequentialGroup()
                .addGroup(pnlUnknownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUnk1)
                    .addComponent(spnUnk1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkUnk8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlUnknownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUnk3)
                    .addComponent(spnUnk3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkUnk9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlUnknownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUnkE)
                    .addComponent(spnUnkE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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

        lblFloorItemsShop.setText("Kecleon Shop items");

        lblFloorItemsMonster.setText("Monster Room items");

        lblFloorItemsBuried.setText("Buried items");

        spnFloorLayout.setEditor(new javax.swing.JSpinner.NumberEditor(spnFloorLayout, "0"));

        spnFloorPokemon.setEditor(new javax.swing.JSpinner.NumberEditor(spnFloorPokemon, "0"));

        spnFloorItems.setEditor(new javax.swing.JSpinner.NumberEditor(spnFloorItems, "0"));

        spnFloorTraps.setEditor(new javax.swing.JSpinner.NumberEditor(spnFloorTraps, "0"));

        spnFloorItemsShop.setModel(new javax.swing.SpinnerNumberModel(0, 0, 65535, 1));
        spnFloorItemsShop.setEditor(new javax.swing.JSpinner.NumberEditor(spnFloorItemsShop, "0"));

        spnFloorItemsMonster.setModel(new javax.swing.SpinnerNumberModel(0, 0, 65535, 1));
        spnFloorItemsMonster.setEditor(new javax.swing.JSpinner.NumberEditor(spnFloorItemsMonster, "0"));

        spnFloorItemsBuried.setModel(new javax.swing.SpinnerNumberModel(0, 0, 65535, 1));
        spnFloorItemsBuried.setEditor(new javax.swing.JSpinner.NumberEditor(spnFloorItemsBuried, "0"));

        btnFloorLayout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/to-editor.png"))); // NOI18N
        btnFloorLayout.setMaximumSize(new java.awt.Dimension(49, 20));
        btnFloorLayout.setMinimumSize(new java.awt.Dimension(49, 20));
        btnFloorLayout.setPreferredSize(new java.awt.Dimension(49, 20));
        btnFloorLayout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFloorLayoutActionPerformed(evt);
            }
        });

        btnFloorPokemon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/to-editor.png"))); // NOI18N
        btnFloorPokemon.setMaximumSize(new java.awt.Dimension(49, 20));
        btnFloorPokemon.setMinimumSize(new java.awt.Dimension(49, 20));
        btnFloorPokemon.setPreferredSize(new java.awt.Dimension(49, 20));
        btnFloorPokemon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFloorPokemonActionPerformed(evt);
            }
        });

        btnFloorItems.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/to-editor.png"))); // NOI18N
        btnFloorItems.setMaximumSize(new java.awt.Dimension(49, 20));
        btnFloorItems.setMinimumSize(new java.awt.Dimension(49, 20));
        btnFloorItems.setPreferredSize(new java.awt.Dimension(49, 20));
        btnFloorItems.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFloorItemsActionPerformed(evt);
            }
        });

        btnFloorTraps.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/to-editor.png"))); // NOI18N
        btnFloorTraps.setMaximumSize(new java.awt.Dimension(49, 20));
        btnFloorTraps.setMinimumSize(new java.awt.Dimension(49, 20));
        btnFloorTraps.setPreferredSize(new java.awt.Dimension(49, 20));
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

        btnFloorItemsShop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/to-editor.png"))); // NOI18N
        btnFloorItemsShop.setMaximumSize(new java.awt.Dimension(49, 20));
        btnFloorItemsShop.setMinimumSize(new java.awt.Dimension(49, 20));
        btnFloorItemsShop.setPreferredSize(new java.awt.Dimension(49, 20));
        btnFloorItemsShop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFloorItemsActionPerformed(evt);
            }
        });

        btnFloorItemsMonster.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/to-editor.png"))); // NOI18N
        btnFloorItemsMonster.setMaximumSize(new java.awt.Dimension(49, 20));
        btnFloorItemsMonster.setMinimumSize(new java.awt.Dimension(49, 20));
        btnFloorItemsMonster.setPreferredSize(new java.awt.Dimension(49, 20));
        btnFloorItemsMonster.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFloorItemsActionPerformed(evt);
            }
        });

        btnFloorItemsBuried.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/to-editor.png"))); // NOI18N
        btnFloorItemsBuried.setMaximumSize(new java.awt.Dimension(49, 20));
        btnFloorItemsBuried.setMinimumSize(new java.awt.Dimension(49, 20));
        btnFloorItemsBuried.setPreferredSize(new java.awt.Dimension(49, 20));
        btnFloorItemsBuried.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFloorItemsActionPerformed(evt);
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
                        .addComponent(lblFloorPokemon)
                        .addGap(67, 67, 67)
                        .addComponent(spnFloorPokemon))
                    .addGroup(pnlFloorsLayout.createSequentialGroup()
                        .addComponent(lblFloorLayout)
                        .addGap(77, 77, 77)
                        .addComponent(spnFloorLayout))
                    .addComponent(btnSaveFloor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlFloorsLayout.createSequentialGroup()
                        .addComponent(lblFloorNo)
                        .addGap(18, 18, 18)
                        .addComponent(spnFloorNo))
                    .addGroup(pnlFloorsLayout.createSequentialGroup()
                        .addGroup(pnlFloorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFloorTraps)
                            .addComponent(lblFloorItems)
                            .addComponent(lblFloorItemsMonster)
                            .addComponent(lblFloorItemsBuried)
                            .addComponent(lblFloorItemsShop))
                        .addGap(13, 13, 13)
                        .addGroup(pnlFloorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(spnFloorItemsBuried, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                            .addComponent(spnFloorItemsMonster, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(spnFloorItemsShop, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(spnFloorTraps, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(spnFloorItems))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFloorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFloorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlFloorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnFloorPokemon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnFloorLayout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnFloorItems, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnFloorTraps, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnFloorItemsShop, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(btnFloorItemsMonster, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnFloorItemsBuried, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        pnlFloorsLayout.setVerticalGroup(
            pnlFloorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFloorsLayout.createSequentialGroup()
                .addGroup(pnlFloorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFloorNo)
                    .addComponent(spnFloorNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlFloorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlFloorsLayout.createSequentialGroup()
                        .addGroup(pnlFloorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlFloorsLayout.createSequentialGroup()
                                .addGroup(pnlFloorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(pnlFloorsLayout.createSequentialGroup()
                                        .addGroup(pnlFloorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(pnlFloorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(lblFloorLayout)
                                                .addComponent(spnFloorLayout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(btnFloorLayout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(pnlFloorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(pnlFloorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(lblFloorPokemon)
                                                .addComponent(spnFloorPokemon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(btnFloorPokemon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(pnlFloorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(pnlFloorsLayout.createSequentialGroup()
                                                .addGroup(pnlFloorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(spnFloorItems, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(lblFloorItems))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(pnlFloorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(spnFloorTraps, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(lblFloorTraps)))
                                            .addGroup(pnlFloorsLayout.createSequentialGroup()
                                                .addComponent(btnFloorItems, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnFloorTraps, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(pnlFloorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(lblFloorItemsShop)
                                            .addComponent(spnFloorItemsShop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(btnFloorItemsShop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlFloorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(spnFloorItemsMonster, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblFloorItemsMonster)))
                            .addComponent(btnFloorItemsMonster, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFloorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(spnFloorItemsBuried, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblFloorItemsBuried)))
                    .addComponent(btnFloorItemsBuried, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addComponent(btnSaveFloor)
                .addContainerGap())
        );

        pnlEntrance.setBorder(javax.swing.BorderFactory.createTitledBorder("Entry conditions"));

        chkHMFly.setText("HM Fly required");

        chkHMDive.setText("HM Dive required");

        chkHMSurf.setText("HM Surf required");

        chkWaterType.setText("Water-type required");

        chkHMWaterfall.setText("HM Waterfall required");

        javax.swing.GroupLayout pnlEntranceLayout = new javax.swing.GroupLayout(pnlEntrance);
        pnlEntrance.setLayout(pnlEntranceLayout);
        pnlEntranceLayout.setHorizontalGroup(
            pnlEntranceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEntranceLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlEntranceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEntranceLayout.createSequentialGroup()
                        .addComponent(chkHMSurf)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlEntranceLayout.createSequentialGroup()
                        .addGroup(pnlEntranceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkWaterType)
                            .addComponent(chkHMWaterfall)
                            .addComponent(chkHMFly)
                            .addComponent(chkHMDive))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        pnlEntranceLayout.setVerticalGroup(
            pnlEntranceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEntranceLayout.createSequentialGroup()
                .addComponent(chkHMFly)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkHMWaterfall)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkHMDive)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkHMSurf)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkWaterType))
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
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(pnlGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(pnlEntrance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pnlFloors, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(pnlUnknown, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(pnlGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pnlEntrance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(pnlFloors, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlUnknown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSave)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        save();
    }//GEN-LAST:event_btnSaveActionPerformed

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
        //new DungeonItemEditor((int) ((JSpinner) evt.getSource()).getValue()).setVisible(true);
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
    private javax.swing.JButton btnFloorItemsBuried;
    private javax.swing.JButton btnFloorItemsMonster;
    private javax.swing.JButton btnFloorItemsShop;
    private javax.swing.JButton btnFloorLayout;
    private javax.swing.JButton btnFloorPokemon;
    private javax.swing.JButton btnFloorTraps;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSaveFloor;
    private javax.swing.JCheckBox chkCondLevel;
    private javax.swing.JCheckBox chkCondMoney;
    private javax.swing.JCheckBox chkCondSave;
    private javax.swing.JCheckBox chkHMDive;
    private javax.swing.JCheckBox chkHMFly;
    private javax.swing.JCheckBox chkHMSurf;
    private javax.swing.JCheckBox chkHMWaterfall;
    private javax.swing.JCheckBox chkRecruitable;
    private javax.swing.JCheckBox chkUnk8;
    private javax.swing.JCheckBox chkUnk9;
    private javax.swing.JCheckBox chkWaterType;
    private javax.swing.JComboBox<String> cmoStairType;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFloorItems;
    private javax.swing.JLabel lblFloorItemsBuried;
    private javax.swing.JLabel lblFloorItemsMonster;
    private javax.swing.JLabel lblFloorItemsShop;
    private javax.swing.JLabel lblFloorLayout;
    private javax.swing.JLabel lblFloorNo;
    private javax.swing.JLabel lblFloorPokemon;
    private javax.swing.JLabel lblFloorTraps;
    private javax.swing.JLabel lblMaxItems;
    private javax.swing.JLabel lblMaxParty;
    private javax.swing.JLabel lblStairType;
    private javax.swing.JLabel lblTimerLimit;
    private javax.swing.JLabel lblUnk1;
    private javax.swing.JLabel lblUnk3;
    private javax.swing.JLabel lblUnkE;
    private javax.swing.JList<String> listDungeons;
    private javax.swing.JPanel pnlEntrance;
    private javax.swing.JPanel pnlFloors;
    private javax.swing.JPanel pnlGeneral;
    private javax.swing.JPanel pnlUnknown;
    private javax.swing.JSpinner spnFloorItems;
    private javax.swing.JSpinner spnFloorItemsBuried;
    private javax.swing.JSpinner spnFloorItemsMonster;
    private javax.swing.JSpinner spnFloorItemsShop;
    private javax.swing.JSpinner spnFloorLayout;
    private javax.swing.JSpinner spnFloorNo;
    private javax.swing.JSpinner spnFloorPokemon;
    private javax.swing.JSpinner spnFloorTraps;
    private javax.swing.JSpinner spnMaxItems;
    private javax.swing.JSpinner spnMaxParty;
    private javax.swing.JSpinner spnTimerLimit;
    private javax.swing.JSpinner spnUnk1;
    private javax.swing.JSpinner spnUnk3;
    private javax.swing.JSpinner spnUnkE;
    // End of variables declaration//GEN-END:variables
}