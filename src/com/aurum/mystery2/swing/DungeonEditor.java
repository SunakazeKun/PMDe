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

import com.aurum.mystery2.Lists;
import com.aurum.mystery2.Main;
import com.aurum.mystery2.game.Dungeon;
import com.aurum.mystery2.game.Floor;
import com.aurum.mystery2.game.RomFile;
import java.awt.Dimension;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class DungeonEditor extends AbstractEditor {
    private Dungeon selected;
    private Floor selectedFloor;
    private DefaultListModel entryModel;
    
    private JList<String> listFloors;
    private JScrollPane scroll;
    
    private JLabel lblFloorLayout, lblFloorPokemon, lblFloorItems, lblFloorTraps, lblFloorItemsShop, lblFloorItemsMonster, lblFloorItemsBuried;
    private JSpinner spnFloorLayout, spnFloorPokemon, spnFloorTraps, spnFloorItems, spnFloorItemsShop, spnFloorItemsMonster, spnFloorItemsBuried;
    private JButton btnFloorLayout, btnFloorPokemon, btnFloorItems, btnFloorTraps, btnFloorItemsShop, btnFloorItemsMonster, btnFloorItemsBuried;
    
    private JLabel lblStair, lblTimer, lblItemLimit, lblPartyLimit;
    private JComboBox<String> cmoStair;
    private JSpinner spnTimer, spnItemLimit, spnPartyLimit;
    private JCheckBox chkCondLvl1, chkCondNoMoney, chkCondSaveGame, chkCondRecruit;
    
    private JCheckBox chkHMFly, chkHMWaterfall, chkHMDive, chkHMSurf, chkWaterType;
    
    private JLabel lblUnk1, lblUnk3, lblUnkE;
    private JSpinner spnUnk1, spnUnk3, spnUnkE;
    private JCheckBox chkUnk8, chkUnk9;
    
    public DungeonEditor() {
        Lists.dungeons.forEach((dungeon) -> { model.addElement(dungeon); });
        list.setSelectedIndex(0);
    }
    
    @Override
    protected void initProperties() {
        setTitle("Dungeon editor");
        
        // Initialize the components
        entryModel = new DefaultListModel();
        listFloors = new JList();
        listFloors.setModel(entryModel);
        listFloors.addListSelectionListener((javax.swing.event.ListSelectionEvent evt) -> {
            enableFloorComponents();
            
            if (selected == null || listFloors.getSelectedIndex() < 0)
                return;
            
            selectedFloor = selected.floors.get(listFloors.getSelectedIndex() + 1);
            
            spnFloorLayout.setValue(selectedFloor.layout);
            spnFloorPokemon.setValue(selectedFloor.pokemon);
            spnFloorTraps.setValue(selectedFloor.traps);
            spnFloorItems.setValue(selectedFloor.items);
            spnFloorItemsShop.setValue(selectedFloor.itemsShop);
            spnFloorItemsMonster.setValue(selectedFloor.itemsMonster);
            spnFloorItemsBuried.setValue(selectedFloor.itemsBuried);
        });
        scroll = new JScrollPane();
        scroll.setViewportView(listFloors);
        lblFloorLayout = new JLabel("Layout");
        lblFloorPokemon = new JLabel("Pokémon");
        lblFloorTraps = new JLabel("Traps");
        lblFloorItems = new JLabel("Items");
        lblFloorItemsShop = new JLabel("Kecleon Shop items");
        lblFloorItemsMonster = new JLabel("Monster Room items");
        lblFloorItemsBuried = new JLabel("Buried items");
        spnFloorLayout = new JSpinner();
        spnFloorLayout.setModel(new SpinnerNumberModel(0, 0, RomFile.current.dungeonLayouts.size() - 1, 1));
        spnFloorLayout.addChangeListener((javax.swing.event.ChangeEvent evt) -> {
            selectedFloor.layout = (int) spnFloorLayout.getValue();
        });
        spnFloorPokemon = new JSpinner();
        spnFloorPokemon.setModel(new SpinnerNumberModel(0, 0, RomFile.current.dungeonPokemon.size() - 1, 1));
        spnFloorPokemon.addChangeListener((javax.swing.event.ChangeEvent evt) -> {
            selectedFloor.pokemon = (int) spnFloorPokemon.getValue();
        });
        spnFloorTraps = new JSpinner();
        spnFloorTraps.setModel(new SpinnerNumberModel(0, 0, RomFile.current.dungeonTraps.size() - 1, 1));
        spnFloorTraps.addChangeListener((javax.swing.event.ChangeEvent evt) -> {
            selectedFloor.traps = (int) spnFloorTraps.getValue();
        });
        spnFloorItems = new JSpinner();
        spnFloorItems.setModel(new SpinnerNumberModel(0, 0, RomFile.current.dungeonItems.size() - 1, 1));
        spnFloorItems.addChangeListener((javax.swing.event.ChangeEvent evt) -> {
            selectedFloor.items = (int) spnFloorItems.getValue();
        });
        spnFloorItemsShop = new JSpinner();
        spnFloorItemsShop.setModel(new SpinnerNumberModel(0, 0, RomFile.current.dungeonItems.size() - 1, 1));
        spnFloorItemsShop.addChangeListener((javax.swing.event.ChangeEvent evt) -> {
            selectedFloor.itemsShop = (int) spnFloorItemsShop.getValue();
        });
        spnFloorItemsMonster = new JSpinner();
        spnFloorItemsMonster.setModel(new SpinnerNumberModel(0, 0, RomFile.current.dungeonItems.size() - 1, 1));
        spnFloorItemsMonster.addChangeListener((javax.swing.event.ChangeEvent evt) -> {
            selectedFloor.itemsMonster = (int) spnFloorItemsMonster.getValue();
        });
        spnFloorItemsBuried = new JSpinner();
        spnFloorItemsBuried.setModel(new SpinnerNumberModel(0, 0, RomFile.current.dungeonItems.size() - 1, 1));
        spnFloorItemsBuried.addChangeListener((javax.swing.event.ChangeEvent evt) -> {
            selectedFloor.itemsBuried = (int) spnFloorItemsBuried.getValue();
        });
        
        ImageIcon icnEditor = new ImageIcon(getClass().getResource("/res/tl_to-editor.png"));
        
        btnFloorLayout = new JButton();
        btnFloorLayout.setPreferredSize(new Dimension(20, 20));
        btnFloorLayout.setIcon(icnEditor);
        btnFloorLayout.addActionListener((java.awt.event.ActionEvent evt) -> {
            new DungeonLayoutEditor((int) spnFloorLayout.getValue()).setVisible(true);
        });
        btnFloorPokemon = new JButton();
        btnFloorPokemon.setPreferredSize(new Dimension(20, 20));
        btnFloorPokemon.setIcon(icnEditor);
        btnFloorPokemon.addActionListener((java.awt.event.ActionEvent evt) -> {
            new DungeonPokemonEditor((int) spnFloorPokemon.getValue()).setVisible(true);
        });
        btnFloorTraps = new JButton();
        btnFloorTraps.setPreferredSize(new Dimension(20, 20));
        btnFloorTraps.setIcon(icnEditor);
        btnFloorTraps.addActionListener((java.awt.event.ActionEvent evt) -> {
            new DungeonTrapsEditor((int) spnFloorTraps.getValue()).setVisible(true);
        });
        btnFloorItems = new JButton();
        btnFloorItems.setPreferredSize(new Dimension(20, 20));
        btnFloorItems.setIcon(icnEditor);
        btnFloorItems.addActionListener((java.awt.event.ActionEvent evt) -> {
            JOptionPane.showMessageDialog(this, "Item editing is not supported.", Main.name, JOptionPane.PLAIN_MESSAGE, null);
            //new DungeonItemsEditor((int) spnFloorItems.getValue()).setVisible(true);
        });
        btnFloorItemsShop = new JButton();
        btnFloorItemsShop.setPreferredSize(new Dimension(20, 20));
        btnFloorItemsShop.setIcon(icnEditor);
        btnFloorItemsShop.addActionListener((java.awt.event.ActionEvent evt) -> {
            JOptionPane.showMessageDialog(this, "Item editing is not supported.", Main.name, JOptionPane.PLAIN_MESSAGE, null);
            //new DungeonItemsEditor((int) spnFloorItemsShop.getValue()).setVisible(true);
        });
        btnFloorItemsMonster = new JButton();
        btnFloorItemsMonster.setPreferredSize(new Dimension(20, 20));
        btnFloorItemsMonster.setIcon(icnEditor);
        btnFloorItemsMonster.addActionListener((java.awt.event.ActionEvent evt) -> {
            JOptionPane.showMessageDialog(this, "Item editing is not supported.", Main.name, JOptionPane.PLAIN_MESSAGE, null);
            //new DungeonItemsEditor((int) spnFloorItemsMonster.getValue()).setVisible(true);
        });
        btnFloorItemsBuried = new JButton();
        btnFloorItemsBuried.setPreferredSize(new Dimension(20, 20));
        btnFloorItemsBuried.setIcon(icnEditor);
        btnFloorItemsBuried.addActionListener((java.awt.event.ActionEvent evt) -> {
            JOptionPane.showMessageDialog(this, "Item editing is not supported.", Main.name, JOptionPane.PLAIN_MESSAGE, null);
            //new DungeonItemsEditor((int) spnFloorItemsBuried.getValue()).setVisible(true);
        });
        
        lblStair = new JLabel("Stair direction");
        lblTimer = new JLabel("Timer limit");
        lblItemLimit = new JLabel("Item limit");
        lblPartyLimit = new JLabel("Party limit");
        cmoStair = new JComboBox();
        cmoStair.setModel(new DefaultComboBoxModel(new String[] { "Down", "Up" }));
        cmoStair.addActionListener((java.awt.event.ActionEvent evt) -> {
            if (selected == null)
                return;
            
            selected.stair = (short) cmoStair.getSelectedIndex();
            updateFloorsList();
        });
        spnTimer = new JSpinner();
        spnTimer.setModel(new SpinnerNumberModel(0, 0, 65535, 1));
        spnItemLimit = new JSpinner();
        spnItemLimit.setModel(new SpinnerNumberModel(Short.valueOf((short)0), Short.valueOf((short)0), Short.valueOf((short)40), Short.valueOf((short)1)));
        spnPartyLimit = new JSpinner();
        spnPartyLimit.setModel(new SpinnerNumberModel(Short.valueOf((short)0), Short.valueOf((short)0), Short.valueOf((short)4), Short.valueOf((short)1)));
        chkCondLvl1 = new JCheckBox("Set level to 1");
        chkCondNoMoney = new JCheckBox("Set money to 0");
        chkCondSaveGame = new JCheckBox("Save game");
        chkCondRecruit = new JCheckBox("Recruitable?");
        
        chkHMFly = new JCheckBox("HM Fly required");
        chkHMWaterfall = new JCheckBox("HM Waterfall required");
        chkHMDive = new JCheckBox("HM Dive required");
        chkHMSurf = new JCheckBox("HM Surf required");
        chkWaterType = new JCheckBox("Water-type required");
        
        lblUnk1 = new JLabel("byte (0x1)");
        lblUnk3 = new JLabel("ubyte (0x3)");
        lblUnkE = new JLabel("short (0xE)");
        spnUnk1 = new JSpinner();
        spnUnk1.setModel(new SpinnerNumberModel((byte)0, null, null, (byte)1));
        spnUnk3 = new JSpinner();
        spnUnk3.setModel(new SpinnerNumberModel(Short.valueOf((short)0), Short.valueOf((short)0), Short.valueOf((short)255), Short.valueOf((short)1)));
        spnUnkE = new JSpinner();
        spnUnkE.setModel(new SpinnerNumberModel((short)0, null, null, (short)1));
        chkUnk8 = new JCheckBox("bool (0x8) (seen in post-game dungeons)");
        chkUnk9 = new JCheckBox("bool (0x9) (seen in story-game dungeons)");
        
        // Add the components to the property panel
        properties.addCaption("Floors");
        properties.addComponent(scroll);
        properties.addEditor(lblFloorLayout, spnFloorLayout, btnFloorLayout);
        properties.addEditor(lblFloorPokemon, spnFloorPokemon, btnFloorPokemon);
        properties.addEditor(lblFloorTraps, spnFloorTraps, btnFloorTraps);
        properties.addEditor(lblFloorItems, spnFloorItems, btnFloorItems);
        properties.addEditor(lblFloorItemsShop, spnFloorItemsShop, btnFloorItemsShop);
        properties.addEditor(lblFloorItemsMonster, spnFloorItemsMonster, btnFloorItemsMonster);
        properties.addEditor(lblFloorItemsBuried, spnFloorItemsBuried, btnFloorItemsBuried);
        properties.addSeparator();
        properties.addCaption("General");
        properties.addLabeledComponent(lblStair, cmoStair);
        properties.addLabeledComponent(lblTimer, spnTimer);
        properties.addLabeledComponent(lblItemLimit, spnItemLimit);
        properties.addLabeledComponent(lblPartyLimit, spnPartyLimit);
        properties.addComponent(chkCondLvl1);
        properties.addComponent(chkCondNoMoney);
        properties.addComponent(chkCondSaveGame);
        properties.addComponent(chkCondRecruit);
        properties.addSeparator();
        properties.addCaption("Conditions");
        properties.addComponent(chkHMFly);
        properties.addComponent(chkHMWaterfall);
        properties.addComponent(chkHMDive);
        properties.addComponent(chkHMSurf);
        properties.addComponent(chkWaterType);
        properties.addSeparator();
        properties.addCaption("Unknown");
        properties.addLabeledComponent(lblUnk1, spnUnk1);
        properties.addLabeledComponent(lblUnk3, spnUnk3);
        properties.addLabeledComponent(lblUnkE, spnUnkE);
        properties.addComponent(chkUnk8);
        properties.addComponent(chkUnk9);
        properties.addTerminator();
    }

    @Override
    protected void load() {
        if (list.getSelectedIndex() < 0)
            return;
        
        selected = (Dungeon) RomFile.current.dungeons.get(list.getSelectedIndex()).clone();
        updateFloorsList();
        listFloors.setSelectedIndex(selected.floors.size() > 1 ? 0 : -1);
        
        cmoStair.setSelectedIndex(selected.stair);
        spnTimer.setValue(selected.timer);
        spnItemLimit.setValue(selected.itemLimit);
        spnPartyLimit.setValue(selected.partyLimit);
        chkCondLvl1.setSelected(selected.setLvl1);
        chkCondNoMoney.setSelected(selected.setNoMoney);
        chkCondSaveGame.setSelected(selected.setSaveGame);
        chkCondRecruit.setSelected(selected.setRecruitable);
        
        chkHMFly.setSelected(selected.hmFly);
        chkHMWaterfall.setSelected(selected.hmWaterfall);
        chkHMDive.setSelected(selected.hmDive);
        chkHMSurf.setSelected(selected.hmSurf);
        chkWaterType.setSelected(selected.typeWater);
        
        spnUnk1.setValue(selected.unk1);
        spnUnk3.setValue(selected.unk3);
        spnUnkE.setValue(selected.unkE);
        chkUnk8.setSelected(selected.unk8);
        chkUnk9.setSelected(selected.unk9);
    }

    @Override
    protected void save() {
        if (selected == null || list.getSelectedIndex() < 0)
            return;
        
        selected.stair = (short) cmoStair.getSelectedIndex();
        selected.timer = (int) spnTimer.getValue();
        selected.itemLimit = (short) spnItemLimit.getValue();
        selected.partyLimit = (short) spnPartyLimit.getValue();
        selected.setLvl1 = chkCondLvl1.isSelected();
        selected.setNoMoney = chkCondNoMoney.isSelected();
        selected.setSaveGame = chkCondSaveGame.isSelected();
        selected.setRecruitable = chkCondRecruit.isSelected();
        
        selected.hmFly = chkHMFly.isSelected();
        selected.hmWaterfall = chkHMWaterfall.isSelected();
        selected.hmDive = chkHMDive.isSelected();
        selected.hmSurf = chkHMSurf.isSelected();
        selected.typeWater = chkWaterType.isSelected();
        
        selected.unk1 = (byte) spnUnk1.getValue();
        selected.unk3 = (short) spnUnk3.getValue();
        selected.unkE = (short) spnUnkE.getValue();
        selected.unk8 = chkUnk8.isSelected();
        selected.unk9 = chkUnk9.isSelected();
        
        RomFile.current.dungeons.set(list.getSelectedIndex(), selected);
    }

    @Override
    protected void warningLabel() {}
    
    private void enableFloorComponents() {
        boolean hasFloors = selected.floors.size() > 1 && selectedFloor != null;
        spnFloorLayout.setEnabled(hasFloors);
        spnFloorPokemon.setEnabled(hasFloors);
        spnFloorTraps.setEnabled(hasFloors);
        spnFloorItems.setEnabled(hasFloors);
        spnFloorItemsShop.setEnabled(hasFloors);
        spnFloorItemsMonster.setEnabled(hasFloors);
        spnFloorItemsBuried.setEnabled(hasFloors);
        btnFloorLayout.setEnabled(hasFloors);
        btnFloorPokemon.setEnabled(hasFloors);
        btnFloorTraps.setEnabled(hasFloors);
        btnFloorItems.setEnabled(hasFloors);
        btnFloorItemsShop.setEnabled(hasFloors);
        btnFloorItemsMonster.setEnabled(hasFloors);
        btnFloorItemsBuried.setEnabled(hasFloors);
    }
    
    private void updateFloorsList() {
        int curidx = listFloors.getSelectedIndex();
        entryModel.clear();
        for (int i = 1 ; i < selected.floors.size() ; i++) {
            entryModel.addElement((selected.stair == 0 ? "B" : "") + i + 'F');
        }
        listFloors.setSelectedIndex(curidx < selected.floors.size() - 1 ? curidx : -1);
    }
}