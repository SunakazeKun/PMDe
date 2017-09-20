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
import com.aurum.mystery2.game.Pokemon;
import com.aurum.mystery2.game.RomFile;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

public class PokemonEditor extends AbstractEditor {
    private Pokemon selected;
    
    private JLabel lblName, lblNamePointer, lblCategory, lblCategoryPointer;
    private JTextField txtName, txtNamePointer, txtCategory, txtCategoryPointer;
    
    private JLabel lblArea, lblWalkable, lblShadow, lblSize, lblSpeed;
    private JComboBox<String> cmoArea, cmoWalkable, cmoShadow;
    private JSlider sdrSize, sdrSpeed;
    private JCheckBox chkMove;
    
    private JLabel lblType1, lblType2, lblAbility1, lblAbility2, lblEXP, lblHP, lblAtk, lblDef, lblSpAtk, lblSpDef;
    private JComboBox<String> cmoType1, cmoType2, cmoAbility1, cmoAbility2;
    private JSpinner spnEXP, spnHP, spnAtk, spnDef, spnSpAtk, spnSpDef;
    
    private JLabel lblEvolveFrom, lblEvolveType, lblEvolveParam, lblEvolveAdditional;
    private JComboBox<String> cmoEvolveFrom, cmoEvolveType, cmoEvolveAdditional;
    private JSpinner spnEvolveParam;
    
    private JLabel lblInternalNo, lblParentNo, lblDexNo, lblAlphaNo;
    private JSpinner spnInternalNo, spnParentNo, spnDexNo, spnAlphaNo;
    
    private JLabel lblFaces, lblPalette, lblRecruit, lblLowKick, lblSizeBust;
    private JTextField txtFaces;
    private JSlider sdrPalette;
    private JSpinner spnPalette, spnRecruit, spnLowKick, spnSizeBust;
    
    private JLabel lblUnk1A, lblUnk1B, lblUnk1D, lblUnk22, lblUnk30, lblUnk31, lblUnk32;
    private JSpinner spnUnk1A, spnUnk1B, spnUnk1D, spnUnk22, spnUnk30, spnUnk31, spnUnk32;
    private JCheckBox chkUnk33;
    
    public PokemonEditor() {
        Lists.pokemon.stream().forEach((item) -> { model.addElement(item); });
        list.setSelectedIndex(0);
    }
    
    @Override
    protected void initProperties() {
        setTitle("Pokémon editor");
        
        // Initialize the components
        lblName = new JLabel("Name");
        lblNamePointer = new JLabel("Name pointer");
        lblCategory = new JLabel("Category");
        lblCategoryPointer = new JLabel("Category pointer");
        txtName = new JTextField();
        txtName.setEditable(false);
        txtNamePointer = new JTextField("00000000");
        txtNamePointer.setEditable(false);
        txtCategory = new JTextField();
        txtCategory.setEditable(false);
        txtCategoryPointer = new JTextField("00000000");
        txtCategoryPointer.setEditable(false);
        
        lblArea = new JLabel("Friend area");
        lblWalkable = new JLabel("Walkable tiles");
        lblShadow = new JLabel("Shadow size");
        lblSize = new JLabel("Sprite size");
        lblSpeed = new JLabel("Movement speed");
        cmoArea = new JComboBox();
        cmoArea.setModel(new DefaultComboBoxModel(Lists.areas.toArray()));
        cmoWalkable = new JComboBox();
        cmoWalkable.setModel(new DefaultComboBoxModel(new String[] { "00: Normal", "01: Magma, Water", "02: Magma, Water, Sky", "03: Wall", "04: Magma, Water, Sky, Wall", "05: Magma", "06: Water" }));
        cmoShadow = new JComboBox();
        cmoShadow.setModel(new DefaultComboBoxModel(new String[] { "00: Small", "01: Medium", "02: Large" }));
        sdrSize = new JSlider(0,4);
        sdrSize.setPaintLabels(true);
        sdrSize.setPaintTicks(true);
        sdrSize.setMinorTickSpacing(1);
        sdrSize.setMajorTickSpacing(2);
        sdrSpeed = new JSlider(-6,6);
        sdrSpeed.setPaintLabels(true);
        sdrSpeed.setPaintTicks(true);
        sdrSpeed.setMinorTickSpacing(1);
        sdrSpeed.setMajorTickSpacing(6);
        chkMove = new JCheckBox("Does move?");
        
        lblType1 = new JLabel("First type");
        lblType2 = new JLabel("Second type");
        lblAbility1 = new JLabel("First ability");
        lblAbility2 = new JLabel("Second ability");
        lblEXP = new JLabel("Base Exp.");
        lblHP = new JLabel("HP");
        lblAtk = new JLabel("Attack");
        lblDef = new JLabel("Defense");
        lblSpAtk = new JLabel("Sp. Attack");
        lblSpDef = new JLabel("Sp. Defense");
        Object[] types = Lists.types.toArray();
        cmoType1 = new JComboBox();
        cmoType1.setModel(new DefaultComboBoxModel(types));
        cmoType2 = new JComboBox();
        cmoType2.setModel(new DefaultComboBoxModel(types));
        Object[] abilities = Lists.abilities.toArray();
        cmoAbility1 = new JComboBox();
        cmoAbility1.setModel(new DefaultComboBoxModel(abilities));
        cmoAbility2 = new JComboBox();
        cmoAbility2.setModel(new DefaultComboBoxModel(abilities));
        spnEXP = new JSpinner();
        spnEXP.setModel(new SpinnerNumberModel(0, 0, 65535, 1));
        spnHP = new JSpinner();
        spnHP.setModel(new SpinnerNumberModel(0, 0, 65535, 1));
        spnAtk = new JSpinner();
        spnAtk.setModel(new SpinnerNumberModel(0, 0, 65535, 1));
        spnDef = new JSpinner();
        spnDef.setModel(new SpinnerNumberModel(0, 0, 65535, 1));
        spnSpAtk = new JSpinner();
        spnSpAtk.setModel(new SpinnerNumberModel(0, 0, 65535, 1));
        spnSpDef = new JSpinner();
        spnSpDef.setModel(new SpinnerNumberModel(0, 0, 65535, 1));
        
        Object[] evolveTypes = { "00: Nothing", "01: Level", "02: IQ", "03: Item", "04: Link Cable", "05: Attack > Defense", "06: Attack < Defense", "07: Attack = Defense", "08: Sun Ribbon", "09: Lunar Ribbon", "0A: Beauty Scarf", "0B: 50% (Silcoon)", "0C: 50% (Cascoon)", "0D: Trade" };
        lblEvolveFrom = new JLabel("Evolves from");
        lblEvolveType = new JLabel("Type");
        lblEvolveParam = new JLabel("Parameter");
        lblEvolveAdditional = new JLabel("Additional");
        cmoEvolveFrom = new JComboBox();
        cmoEvolveFrom.setModel(new DefaultComboBoxModel(Lists.pokemon.toArray()));
        cmoEvolveType = new JComboBox();
        cmoEvolveType.setModel(new DefaultComboBoxModel(evolveTypes));
        spnEvolveParam = new JSpinner();
        spnEvolveParam.setModel(new SpinnerNumberModel(0, 0, 65535, 1));
        cmoEvolveAdditional = new JComboBox();
        cmoEvolveAdditional.setModel(new DefaultComboBoxModel(evolveTypes));
        
        lblInternalNo = new JLabel("Internal no.");
        lblParentNo = new JLabel("Parent no.");
        lblDexNo = new JLabel("Dex no.");
        lblAlphaNo = new JLabel("Alphabetical no.");
        spnInternalNo = new JSpinner();
        spnParentNo = new JSpinner();
        spnDexNo = new JSpinner();
        spnAlphaNo = new JSpinner();
        
        lblFaces = new JLabel("Faces bitfield");
        lblPalette = new JLabel("Palette");
        lblRecruit = new JLabel("Recruitment factor");
        lblLowKick = new JLabel("Low Kick damage");
        lblSizeBust = new JLabel("Size Bust damage");
        txtFaces = new JTextField();
        txtFaces.setEditable(false);
        sdrPalette = new JSlider(0, 12);
        sdrPalette.setPaintLabels(true);
        sdrPalette.setPaintTicks(true);
        sdrPalette.setMinorTickSpacing(1);
        sdrPalette.setMajorTickSpacing(6);
        spnPalette = new JSpinner();
        spnPalette.setModel(new SpinnerNumberModel(Short.valueOf((short)0), Short.valueOf((short)0), Short.valueOf((short)12), Short.valueOf((short)1)));
        spnRecruit = new JSpinner();
        spnRecruit.setModel(new SpinnerNumberModel((short)0, null, null, (short)1));
        spnLowKick = new JSpinner();
        spnLowKick.setModel(new SpinnerNumberModel(0, 0, 65535, 1));
        spnSizeBust = new JSpinner();
        spnSizeBust.setModel(new SpinnerNumberModel(0, 0, 65535, 1));
        
        lblUnk1A = new JLabel("byte (0x1A)");
        lblUnk1B = new JLabel("byte (0x1B)");
        lblUnk1D = new JLabel("byte (0x1D)");
        lblUnk22 = new JLabel("ushort (0x22)");
        lblUnk30 = new JLabel("byte (0x30)");
        lblUnk31 = new JLabel("byte (0x31)");
        lblUnk32 = new JLabel("byte (0x32)");
        spnUnk1A = new JSpinner();
        spnUnk1A.setModel(new SpinnerNumberModel((byte)0, null, null, (byte)1));
        spnUnk1B = new JSpinner();
        spnUnk1B.setModel(new SpinnerNumberModel((byte)0, null, null, (byte)1));
        spnUnk1D = new JSpinner();
        spnUnk1D.setModel(new SpinnerNumberModel((byte)0, null, null, (byte)1));
        spnUnk22 = new JSpinner();
        spnUnk22.setModel(new SpinnerNumberModel(0, 0, 65535, 1));
        spnUnk30 = new JSpinner();
        spnUnk30.setModel(new SpinnerNumberModel((byte)0, null, null, (byte)1));
        spnUnk31 = new JSpinner();
        spnUnk31.setModel(new SpinnerNumberModel((byte)0, null, null, (byte)1));
        spnUnk32 = new JSpinner();
        spnUnk32.setModel(new SpinnerNumberModel((byte)0, null, null, (byte)1));
        chkUnk33 = new JCheckBox("bool (0x33)");
        
        // Add the components to the property panel
        properties.addCaption("Text");
        properties.addComponent(lblName, txtName);
        properties.addComponent(lblNamePointer, txtNamePointer);
        properties.addComponent(lblCategory, txtCategory);
        properties.addComponent(lblCategoryPointer, txtCategoryPointer);
        properties.addSeparator();
        properties.addCaption("General");
        properties.addComponent(lblArea, cmoArea);
        properties.addComponent(lblWalkable, cmoWalkable);
        properties.addComponent(lblShadow, cmoShadow);
        properties.addComponent(lblSize, sdrSize);
        properties.addComponent(lblSpeed, sdrSpeed);
        properties.addComponent(chkMove);
        properties.addSeparator();
        properties.addCaption("Stats");
        properties.addComponent(lblType1, cmoType1);
        properties.addComponent(lblType2, cmoType2);
        properties.addComponent(lblAbility1, cmoAbility1);
        properties.addComponent(lblAbility2, cmoAbility2);
        properties.addComponent(lblEXP, spnEXP);
        properties.addComponent(lblHP, spnHP);
        properties.addComponent(lblAtk, spnAtk);
        properties.addComponent(lblDef, spnDef);
        properties.addComponent(lblSpAtk, spnSpAtk);
        properties.addComponent(lblSpDef, spnSpDef);
        properties.addSeparator();
        properties.addCaption("Evolution");
        properties.addComponent(lblEvolveFrom, cmoEvolveFrom);
        properties.addComponent(lblEvolveType, cmoEvolveType);
        properties.addComponent(lblEvolveParam, spnEvolveParam);
        properties.addComponent(lblEvolveAdditional, cmoEvolveAdditional);
        properties.addSeparator();
        properties.addCaption("Indexes");
        properties.addComponent(lblInternalNo, spnInternalNo);
        properties.addComponent(lblParentNo, spnParentNo);
        properties.addComponent(lblDexNo, spnDexNo);
        properties.addComponent(lblAlphaNo, spnAlphaNo);
        properties.addSeparator();
        properties.addCaption("Misc.");
        properties.addComponent(lblFaces, txtFaces);
        properties.addComponent(lblPalette, sdrPalette);
        properties.addComponent(lblRecruit, spnRecruit);
        properties.addComponent(lblLowKick, spnLowKick);
        properties.addComponent(lblSizeBust, spnSizeBust);
        properties.addSeparator();
        properties.addCaption("Unknown");
        properties.addComponent(lblUnk1A, spnUnk1A);
        properties.addComponent(lblUnk1B, spnUnk1B);
        properties.addComponent(lblUnk1D, spnUnk1D);
        properties.addComponent(lblUnk22, spnUnk22);
        properties.addComponent(lblUnk30, spnUnk30);
        properties.addComponent(lblUnk31, spnUnk31);
        properties.addComponent(lblUnk32, spnUnk32);
        properties.addComponent(chkUnk33);
        properties.addTerminator();
    }

    @Override
    protected void load() {
        selected = (Pokemon) RomFile.current.pokemon.get(list.getSelectedIndex()).clone();
        
        txtName.setText(selected.species);
        txtName.setCaretPosition(0);
        txtNamePointer.setText(BitConverter.toHexIntString(selected.speciesPointer));
        txtCategory.setText(selected.category);
        txtCategory.setCaretPosition(0);
        txtCategoryPointer.setText(BitConverter.toHexIntString(selected.categoryPointer));
        
        cmoArea.setSelectedIndex(selected.area);
        cmoWalkable.setSelectedIndex(selected.walkable);
        cmoShadow.setSelectedIndex(selected.shadow);
        sdrSize.setValue(selected.size);
        sdrSpeed.setValue(selected.speed);
        chkMove.setSelected(selected.isMoving);
        
        cmoType1.setSelectedIndex(selected.type1);
        cmoType2.setSelectedIndex(selected.type2);
        cmoAbility1.setSelectedIndex(selected.ability1);
        cmoAbility2.setSelectedIndex(selected.ability2);
        spnEXP.setValue(selected.basexp);
        spnHP.setValue(selected.hp);
        spnAtk.setValue(selected.atk);
        spnDef.setValue(selected.def);
        spnSpAtk.setValue(selected.spatk);
        spnSpDef.setValue(selected.spdef);
        
        cmoEvolveFrom.setSelectedIndex(selected.evolveFrom);
        cmoEvolveType.setSelectedIndex(selected.evolveType);
        spnEvolveParam.setValue(selected.evolveParam);
        cmoEvolveAdditional.setSelectedIndex(selected.evolveAddition);
        
        spnInternalNo.setValue(selected.internalNo);
        spnParentNo.setValue(selected.parentNo);
        spnDexNo.setValue(selected.dexNo);
        spnAlphaNo.setValue(selected.alphabetNo);
        
        txtFaces.setText(BitConverter.toBinShortString(selected.faces));
        sdrPalette.setValue(selected.palette);
        spnRecruit.setValue(selected.recruit);
        spnLowKick.setValue(selected.lowKick);
        spnSizeBust.setValue(selected.sizeBust);
        
        spnUnk1A.setValue(selected.unk1A);
        spnUnk1B.setValue(selected.unk1B);
        spnUnk1D.setValue(selected.unk1D);
        spnUnk22.setValue(selected.unk22);
        spnUnk30.setValue(selected.unk30);
        spnUnk31.setValue(selected.unk31);
        spnUnk32.setValue(selected.unk32);
        chkUnk33.setSelected(selected.unk33);
    }

    @Override
    protected void save() {
        if (list.getSelectedIndex() < 0)
            return;
        
        if (selected == null || list.getSelectedIndex() < 0)
            return;
        
        selected.area = (short) cmoArea.getSelectedIndex();
        selected.walkable = (short) cmoWalkable.getSelectedIndex();
        selected.shadow = (short) cmoShadow.getSelectedIndex();
        selected.size = (short) sdrSize.getValue();
        selected.speed = (int) sdrSpeed.getValue();
        selected.isMoving = chkMove.isSelected();
        
        selected.type1 = (short) cmoType1.getSelectedIndex();
        selected.type2 = (short) cmoType2.getSelectedIndex();
        selected.ability1 = (short) cmoAbility1.getSelectedIndex();
        selected.ability2 = (short) cmoAbility2.getSelectedIndex();
        selected.basexp = (int) spnEXP.getValue();
        selected.hp = (int) spnHP.getValue();
        selected.atk = (int) spnAtk.getValue();
        selected.def = (int) spnDef.getValue();
        selected.spatk = (int) spnSpAtk.getValue();
        selected.spdef = (int) spnSpDef.getValue();
        
        selected.evolveFrom = (int) cmoEvolveFrom.getSelectedIndex();
        selected.evolveType = (int) cmoEvolveType.getSelectedIndex();
        selected.evolveParam = (int) spnEvolveParam.getValue();
        selected.evolveAddition = (int) cmoEvolveAdditional.getSelectedIndex();
        
        selected.internalNo = (int) spnInternalNo.getValue();
        selected.parentNo = (int) spnParentNo.getValue();
        selected.dexNo = (int) spnDexNo.getValue();
        selected.alphabetNo = (int) spnAlphaNo.getValue();
        
        selected.palette = (short) sdrPalette.getValue();
        selected.recruit = (short) spnRecruit.getValue();
        selected.lowKick = (int) spnLowKick.getValue();
        selected.sizeBust = (int) spnSizeBust.getValue();
        
        selected.unk1A = (byte) spnUnk1A.getValue();
        selected.unk1B = (byte) spnUnk1B.getValue();
        selected.unk1D = (byte) spnUnk1D.getValue();
        selected.unk22 = (int) spnUnk22.getValue();
        selected.unk30 = (byte) spnUnk30.getValue();
        selected.unk31 = (byte) spnUnk31.getValue();
        selected.unk32 = (byte) spnUnk32.getValue();
        selected.unk33 = chkUnk33.isSelected();
        
        RomFile.current.pokemon.set(list.getSelectedIndex(), selected);
    }

    @Override
    protected void warningLabel() {}
}