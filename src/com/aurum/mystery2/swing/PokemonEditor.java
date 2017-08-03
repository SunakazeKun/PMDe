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
import com.aurum.mystery2.Main;
import com.aurum.mystery2.game.RomFile;
import com.aurum.mystery2.game.Pokemon;
import com.aurum.mystery2.BitConverter;

public class PokemonEditor extends javax.swing.JFrame {
    public PokemonEditor() {
        initComponents();
        Lists.pokemon.stream().forEach((pokemon) -> { model.addElement(pokemon); cmoEvolveFrom.addItem(pokemon); });
        Lists.types.stream().forEach((type) -> { cmoType1.addItem(type); cmoType2.addItem(type); });
        Lists.areas.stream().forEach((area) -> { cmoArea.addItem(area); });
        Lists.abilities.stream().forEach((ability) -> { cmoAbility1.addItem(ability); cmoAbility2.addItem(ability); });
        listPokemon.setSelectedIndex(0);
    }
    
    private void load() {
        if (cmoAbility2.getItemCount() != Lists.abilities.size())
            return;
        
        selected = (Pokemon) RomFile.current.pokemon.get(listPokemon.getSelectedIndex()).clone();
        
        txtName.setText(selected.species);
        txtCategory.setText(selected.category);
        
        cmoType1.setSelectedIndex(selected.type1);
        cmoType2.setSelectedIndex(selected.type2);
        cmoAbility1.setSelectedIndex(selected.ability1);
        cmoAbility2.setSelectedIndex(selected.ability2);
        cmoArea.setSelectedIndex(selected.area);
            
        txtNamePointer.setText(BitConverter.toHexIntString(selected.speciesPointer));
        txtCategoryPointer.setText(BitConverter.toHexIntString(selected.categoryPointer));
        spnPalette.setValue(selected.palette);
        txtFacesBitfield.setText(Integer.toBinaryString(selected.facesBitfield));
        spnDexNo.setValue(selected.dexNo);
        spnAlphabeticalNo.setValue(selected.alphabetNo);
        spnInternalNo.setValue(selected.internalNo);
        spnParentNo.setValue(selected.parentNo);
        
        spnSize.setValue(selected.size);
        cmoShadow.setSelectedIndex(selected.shadow);
        spnSpeed.setValue(selected.speed);
        cmoWalkable.setSelectedIndex(selected.walkable);
        
        cmoEvolveFrom.setSelectedIndex(selected.evolveFrom);
        cmoEvolutionType.setSelectedIndex(selected.evolveType);
        spnEvolutionParam.setValue(selected.evolveParam);
        cmoEvolutionAddition.setSelectedIndex(selected.evolveAddition);
        
        spnAttack.setValue(selected.stat_attack);
        spnDefense.setValue(selected.stat_defense);
        spnSpAttack.setValue(selected.stat_spattack);
        spnSpDefense.setValue(selected.stat_spdefense);
        spnHP.setValue(selected.stat_hp);
        spnUnknown.setValue(selected.stat_unknown);
        spnEXP.setValue(selected.basexp);
        
        spnRecruit.setValue(selected.recruit);
        spnLowKick.setValue(selected.damageLowKick);
        spnSizeBust.setValue(selected.damageSizeBust);
        
        showUnknownBytes();
    }
    
    private void showUnknownBytes() {
        switch(cmoUnknown.getSelectedIndex()) {
            case 0: txtUnknown.setText(String.valueOf(selected.unkA[0])); break;
            case 1: txtUnknown.setText(String.valueOf(selected.unkA[1])); break;
            case 2: txtUnknown.setText(String.valueOf(selected.unk12)); break;
            case 3: txtUnknown.setText(String.valueOf(selected.unk1A[0])); break;
            case 4: txtUnknown.setText(String.valueOf(selected.unk1A[1])); break;
            case 5: txtUnknown.setText(String.valueOf(selected.unk1A[2])); break;
            case 6: txtUnknown.setText(String.valueOf(selected.unk1A[3])); break;
            case 7: txtUnknown.setText(String.valueOf(selected.unk30[0])); break;
            case 8: txtUnknown.setText(String.valueOf(selected.unk30[1])); break;
            case 9: txtUnknown.setText(String.valueOf(selected.unk30[2])); break;
            case 10: txtUnknown.setText(String.valueOf(selected.unk30[3])); break;
        }
    }
    
    private void save() {
        selected.type1 = (short) cmoType1.getSelectedIndex();
        selected.type2 = (short) cmoType2.getSelectedIndex();
        selected.ability1 = (short) cmoAbility1.getSelectedIndex();
        selected.ability2 = (short) cmoAbility2.getSelectedIndex();
        selected.area = (short) cmoArea.getSelectedIndex();
        
        selected.palette = (short) spnPalette.getValue();
        selected.dexNo = (int) spnDexNo.getValue();
        selected.alphabetNo = (int) spnAlphabeticalNo.getValue();
        selected.internalNo = (int) spnInternalNo.getValue();
        selected.parentNo = (int) spnParentNo.getValue();
        
        selected.size = (short) spnSize.getValue();
        selected.shadow = (short) cmoShadow.getSelectedIndex();
        selected.speed = (int) spnSpeed.getValue();
        selected.walkable = (short) cmoWalkable.getSelectedIndex();
        
        selected.evolveFrom = (int) cmoEvolveFrom.getSelectedIndex();
        selected.evolveType = (int) cmoEvolutionType.getSelectedIndex();
        selected.evolveParam = (int) spnEvolutionParam.getValue();
        selected.evolveAddition = (int) cmoEvolutionAddition.getSelectedIndex();
        
        selected.stat_attack = (int) spnAttack.getValue();
        selected.stat_defense = (int) spnDefense.getValue();
        selected.stat_spattack = (int) spnSpAttack.getValue();
        selected.stat_spdefense = (int) spnSpDefense.getValue();
        selected.stat_hp = (int) spnHP.getValue();
        selected.stat_unknown = (int) spnUnknown.getValue();
        selected.basexp = (int) spnEXP.getValue();
        selected.recruit = (short) spnRecruit.getValue();
        selected.damageLowKick = (int) spnLowKick.getValue();
        selected.damageSizeBust = (int) spnSizeBust.getValue();
        
        RomFile.current.pokemon.set(listPokemon.getSelectedIndex(), selected);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pneMain = new javax.swing.JPanel();
        lblType1 = new javax.swing.JLabel();
        lblType2 = new javax.swing.JLabel();
        lblAbility1 = new javax.swing.JLabel();
        lblAbility2 = new javax.swing.JLabel();
        lblArea = new javax.swing.JLabel();
        lblSize = new javax.swing.JLabel();
        lblShadow = new javax.swing.JLabel();
        lblSpeed = new javax.swing.JLabel();
        cmoType1 = new javax.swing.JComboBox<>();
        cmoType2 = new javax.swing.JComboBox<>();
        cmoAbility1 = new javax.swing.JComboBox<>();
        cmoAbility2 = new javax.swing.JComboBox<>();
        cmoArea = new javax.swing.JComboBox<>();
        spnSize = new javax.swing.JSpinner();
        cmoShadow = new javax.swing.JComboBox<>();
        spnSpeed = new javax.swing.JSpinner();
        lblWalkable = new javax.swing.JLabel();
        cmoWalkable = new javax.swing.JComboBox<>();
        lblName = new javax.swing.JLabel();
        lblCategory = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtCategory = new javax.swing.JTextField();
        pneEvolution = new javax.swing.JPanel();
        lblEvolveFrom = new javax.swing.JLabel();
        lblEvolutionType = new javax.swing.JLabel();
        lblEvolutionParam = new javax.swing.JLabel();
        lblEvolutionUnknown = new javax.swing.JLabel();
        cmoEvolveFrom = new javax.swing.JComboBox<>();
        cmoEvolutionType = new javax.swing.JComboBox<>();
        spnEvolutionParam = new javax.swing.JSpinner();
        cmoEvolutionAddition = new javax.swing.JComboBox<>();
        pneMisc = new javax.swing.JPanel();
        lblPalette = new javax.swing.JLabel();
        lblFacesBitfield = new javax.swing.JLabel();
        lblNamePointer = new javax.swing.JLabel();
        lblCategoryPointer = new javax.swing.JLabel();
        lblDexNo = new javax.swing.JLabel();
        lblInternalNo = new javax.swing.JLabel();
        lblParentNo = new javax.swing.JLabel();
        lblInternalNo3 = new javax.swing.JLabel();
        txtNamePointer = new javax.swing.JTextField();
        txtCategoryPointer = new javax.swing.JTextField();
        spnPalette = new javax.swing.JSpinner();
        txtFacesBitfield = new javax.swing.JTextField();
        spnDexNo = new javax.swing.JSpinner();
        spnInternalNo = new javax.swing.JSpinner();
        spnParentNo = new javax.swing.JSpinner();
        spnAlphabeticalNo = new javax.swing.JSpinner();
        pneStats = new javax.swing.JPanel();
        lblAttack = new javax.swing.JLabel();
        lblDefense = new javax.swing.JLabel();
        lblSpAttack = new javax.swing.JLabel();
        lblSpDefense = new javax.swing.JLabel();
        lblHP = new javax.swing.JLabel();
        lblUnknown = new javax.swing.JLabel();
        spnAttack = new javax.swing.JSpinner();
        spnDefense = new javax.swing.JSpinner();
        spnSpAttack = new javax.swing.JSpinner();
        spnSpDefense = new javax.swing.JSpinner();
        spnHP = new javax.swing.JSpinner();
        spnUnknown = new javax.swing.JSpinner();
        lblEXP = new javax.swing.JLabel();
        spnEXP = new javax.swing.JSpinner();
        pneFactors = new javax.swing.JPanel();
        lblRecruit = new javax.swing.JLabel();
        lblLowKick = new javax.swing.JLabel();
        lblSizeBust = new javax.swing.JLabel();
        spnRecruit = new javax.swing.JSpinner();
        spnLowKick = new javax.swing.JSpinner();
        spnSizeBust = new javax.swing.JSpinner();
        jPanel1 = new javax.swing.JPanel();
        lblUnknownOffset = new javax.swing.JLabel();
        lblUnknownValue = new javax.swing.JLabel();
        cmoUnknown = new javax.swing.JComboBox<>();
        txtUnknown = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listPokemon = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pokémon editor");
        setIconImage(com.aurum.mystery2.Main.icon);
        setResizable(false);

        pneMain.setBorder(javax.swing.BorderFactory.createTitledBorder("Main"));

        lblType1.setText("First type");

        lblType2.setText("Second type");

        lblAbility1.setText("First ability");

        lblAbility2.setText("Second ability");

        lblArea.setText("Friend area");

        lblSize.setText("Sprite size");

        lblShadow.setText("Shadow size");

        lblSpeed.setText("Speed");

        spnSize.setModel(new javax.swing.SpinnerNumberModel(Byte.valueOf((byte)0), Byte.valueOf((byte)0), Byte.valueOf((byte)4), Byte.valueOf((byte)1)));

        cmoShadow.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00: Small", "01: Medium", "02: Large" }));

        spnSpeed.setModel(new javax.swing.SpinnerNumberModel(0, -6, 6, 1));

        lblWalkable.setText("Walkable tiles");

        cmoWalkable.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00: Normal", "01: Magma, Water", "02: Magma, Water, Sky", "04: Magma, Water, Sky, Wall", "05: Magma", "06: Water" }));

        lblName.setText("Name");

        lblCategory.setText("Category");

        txtName.setEditable(false);

        txtCategory.setEditable(false);

        javax.swing.GroupLayout pneMainLayout = new javax.swing.GroupLayout(pneMain);
        pneMain.setLayout(pneMainLayout);
        pneMainLayout.setHorizontalGroup(
            pneMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pneMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pneMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pneMainLayout.createSequentialGroup()
                        .addGroup(pneMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSize)
                            .addComponent(lblShadow))
                        .addGroup(pneMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pneMainLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(spnSize, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pneMainLayout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addComponent(cmoShadow, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pneMainLayout.createSequentialGroup()
                        .addGroup(pneMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblType1)
                            .addComponent(lblType2)
                            .addComponent(lblAbility1)
                            .addComponent(lblAbility2)
                            .addComponent(lblArea)
                            .addComponent(lblSpeed)
                            .addComponent(lblWalkable))
                        .addGap(71, 71, 71)
                        .addGroup(pneMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmoAbility1, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmoType2, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmoType1, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(spnSpeed, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmoWalkable, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmoArea, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmoAbility2, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(pneMainLayout.createSequentialGroup()
                        .addGroup(pneMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblName)
                            .addComponent(lblCategory))
                        .addGap(92, 92, 92)
                        .addGroup(pneMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCategory)
                            .addComponent(txtName))))
                .addContainerGap())
        );
        pneMainLayout.setVerticalGroup(
            pneMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pneMainLayout.createSequentialGroup()
                .addGroup(pneMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pneMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCategory)
                    .addComponent(txtCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pneMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblType1)
                    .addComponent(cmoType1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pneMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblType2)
                    .addComponent(cmoType2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pneMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAbility1)
                    .addComponent(cmoAbility1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pneMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAbility2)
                    .addComponent(cmoAbility2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pneMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmoArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblArea))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pneMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSize)
                    .addComponent(spnSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pneMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblShadow)
                    .addComponent(cmoShadow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pneMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSpeed)
                    .addComponent(spnSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pneMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmoWalkable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblWalkable))
                .addContainerGap())
        );

        pneEvolution.setBorder(javax.swing.BorderFactory.createTitledBorder("Evolution"));
        pneEvolution.setPreferredSize(new java.awt.Dimension(218, 122));

        lblEvolveFrom.setText("Evolve from");

        lblEvolutionType.setText("Type");

        lblEvolutionParam.setText("Parameter");

        lblEvolutionUnknown.setText("Additional");

        cmoEvolutionType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00: Nothing", "01: Level", "02: IQ", "03: Item", "04: Link Cable", "05: Attack > Defense", "06: Attack < Defense", "07: Attack = Defense", "08: Sun Ribbon", "09: Lunar Ribbon", "0A: Beauty Scarf", "0B: 50% (Silcoon)", "0C: 50% (Cascoon)", "0D: Trade" }));

        spnEvolutionParam.setModel(new javax.swing.SpinnerNumberModel(0, 0, 65535, 1));

        cmoEvolutionAddition.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00: Nothing", "01: Level", "02: IQ", "03: Item", "04: Link Cable", "05: Attack > Defense", "06: Attack < Defense", "07: Attack = Defense", "08: Sun Ribbon", "09: Lunar Ribbon", "0A: Beauty Scarf", "0B: 50% (Silcoon)", "0C: 50% (Cascoon)", "0D: Trade" }));

        javax.swing.GroupLayout pneEvolutionLayout = new javax.swing.GroupLayout(pneEvolution);
        pneEvolution.setLayout(pneEvolutionLayout);
        pneEvolutionLayout.setHorizontalGroup(
            pneEvolutionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pneEvolutionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pneEvolutionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pneEvolutionLayout.createSequentialGroup()
                        .addComponent(lblEvolveFrom)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmoEvolveFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pneEvolutionLayout.createSequentialGroup()
                        .addComponent(lblEvolutionParam)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(spnEvolutionParam, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pneEvolutionLayout.createSequentialGroup()
                        .addGroup(pneEvolutionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEvolutionType)
                            .addComponent(lblEvolutionUnknown))
                        .addGap(116, 116, 116)
                        .addGroup(pneEvolutionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmoEvolutionAddition, 0, 165, Short.MAX_VALUE)
                            .addComponent(cmoEvolutionType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        pneEvolutionLayout.setVerticalGroup(
            pneEvolutionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pneEvolutionLayout.createSequentialGroup()
                .addGroup(pneEvolutionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEvolveFrom)
                    .addComponent(cmoEvolveFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pneEvolutionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEvolutionType)
                    .addComponent(cmoEvolutionType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pneEvolutionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEvolutionParam)
                    .addComponent(spnEvolutionParam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pneEvolutionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEvolutionUnknown)
                    .addComponent(cmoEvolutionAddition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 1, Short.MAX_VALUE))
        );

        pneMisc.setBorder(javax.swing.BorderFactory.createTitledBorder("Misc."));

        lblPalette.setText("Palette");

        lblFacesBitfield.setText("Faces bitfield");

        lblNamePointer.setText("Name pointer");

        lblCategoryPointer.setText("Category pointer");

        lblDexNo.setText("Dex no.");

        lblInternalNo.setText("Internal no.");

        lblParentNo.setText("Parent no.");

        lblInternalNo3.setText("Alphabetical no.");

        txtNamePointer.setEditable(false);
        txtNamePointer.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        txtCategoryPointer.setEditable(false);
        txtCategoryPointer.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        spnPalette.setModel(new javax.swing.SpinnerNumberModel(Byte.valueOf((byte)0), Byte.valueOf((byte)0), Byte.valueOf((byte)12), Byte.valueOf((byte)1)));

        txtFacesBitfield.setEditable(false);
        txtFacesBitfield.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        spnDexNo.setModel(new javax.swing.SpinnerNumberModel(0, 0, 65535, 1));
        spnDexNo.setEditor(new javax.swing.JSpinner.NumberEditor(spnDexNo, "0"));

        spnInternalNo.setModel(new javax.swing.SpinnerNumberModel(0, 0, 65535, 1));
        spnInternalNo.setEditor(new javax.swing.JSpinner.NumberEditor(spnInternalNo, "0"));

        spnParentNo.setModel(new javax.swing.SpinnerNumberModel(0, 0, 65535, 1));
        spnParentNo.setEditor(new javax.swing.JSpinner.NumberEditor(spnParentNo, "0"));

        spnAlphabeticalNo.setModel(new javax.swing.SpinnerNumberModel(0, 0, 65535, 1));
        spnAlphabeticalNo.setEditor(new javax.swing.JSpinner.NumberEditor(spnAlphabeticalNo, "0"));

        javax.swing.GroupLayout pneMiscLayout = new javax.swing.GroupLayout(pneMisc);
        pneMisc.setLayout(pneMiscLayout);
        pneMiscLayout.setHorizontalGroup(
            pneMiscLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pneMiscLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pneMiscLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pneMiscLayout.createSequentialGroup()
                        .addComponent(lblNamePointer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtNamePointer, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pneMiscLayout.createSequentialGroup()
                        .addGroup(pneMiscLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblInternalNo)
                            .addComponent(lblParentNo)
                            .addComponent(lblInternalNo3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pneMiscLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(spnParentNo, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                            .addComponent(spnAlphabeticalNo)
                            .addComponent(spnInternalNo, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(pneMiscLayout.createSequentialGroup()
                        .addGroup(pneMiscLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCategoryPointer)
                            .addComponent(lblFacesBitfield)
                            .addComponent(lblDexNo)
                            .addComponent(lblPalette))
                        .addGap(70, 70, 70)
                        .addGroup(pneMiscLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(spnPalette)
                            .addComponent(spnDexNo)
                            .addComponent(txtCategoryPointer)
                            .addComponent(txtFacesBitfield))))
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
                    .addComponent(lblCategoryPointer)
                    .addComponent(txtCategoryPointer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pneMiscLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPalette)
                    .addComponent(spnPalette, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pneMiscLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFacesBitfield)
                    .addComponent(txtFacesBitfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pneMiscLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDexNo)
                    .addComponent(spnDexNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pneMiscLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblInternalNo)
                    .addComponent(spnInternalNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pneMiscLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spnParentNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblParentNo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pneMiscLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblInternalNo3)
                    .addComponent(spnAlphabeticalNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pneStats.setBorder(javax.swing.BorderFactory.createTitledBorder("Stats"));

        lblAttack.setText("Attack");

        lblDefense.setText("Defense");

        lblSpAttack.setText("Special Attack");

        lblSpDefense.setText("Special Defense");

        lblHP.setText("HP");

        lblUnknown.setText("Unknown");

        spnAttack.setModel(new javax.swing.SpinnerNumberModel());
        spnAttack.setEditor(new javax.swing.JSpinner.NumberEditor(spnAttack, "0"));

        spnDefense.setModel(new javax.swing.SpinnerNumberModel(0, 0, 65535, 1));
        spnDefense.setEditor(new javax.swing.JSpinner.NumberEditor(spnDefense, "0"));

        spnSpAttack.setModel(new javax.swing.SpinnerNumberModel(0, 0, 65535, 1));
        spnSpAttack.setEditor(new javax.swing.JSpinner.NumberEditor(spnSpAttack, "0"));

        spnSpDefense.setModel(new javax.swing.SpinnerNumberModel(0, 0, 65535, 1));
        spnSpDefense.setEditor(new javax.swing.JSpinner.NumberEditor(spnSpDefense, "0"));

        spnHP.setModel(new javax.swing.SpinnerNumberModel(0, 0, 65535, 1));
        spnHP.setEditor(new javax.swing.JSpinner.NumberEditor(spnHP, "0"));

        spnUnknown.setModel(new javax.swing.SpinnerNumberModel(0, 0, 65535, 1));
        spnUnknown.setEditor(new javax.swing.JSpinner.NumberEditor(spnUnknown, "0"));

        lblEXP.setText("Base EXP");

        spnEXP.setModel(new javax.swing.SpinnerNumberModel());
        spnEXP.setEditor(new javax.swing.JSpinner.NumberEditor(spnEXP, "0"));

        javax.swing.GroupLayout pneStatsLayout = new javax.swing.GroupLayout(pneStats);
        pneStats.setLayout(pneStatsLayout);
        pneStatsLayout.setHorizontalGroup(
            pneStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pneStatsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pneStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pneStatsLayout.createSequentialGroup()
                        .addGroup(pneStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblHP)
                            .addComponent(lblUnknown)
                            .addComponent(lblEXP))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pneStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(spnEXP)
                            .addComponent(spnUnknown, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                            .addComponent(spnHP, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pneStatsLayout.createSequentialGroup()
                        .addGroup(pneStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAttack)
                            .addComponent(lblDefense)
                            .addComponent(lblSpAttack)
                            .addComponent(lblSpDefense))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
                        .addGroup(pneStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(spnSpDefense, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                            .addComponent(spnSpAttack)
                            .addComponent(spnDefense)
                            .addComponent(spnAttack))))
                .addContainerGap())
        );
        pneStatsLayout.setVerticalGroup(
            pneStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pneStatsLayout.createSequentialGroup()
                .addGroup(pneStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAttack)
                    .addComponent(spnAttack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pneStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDefense)
                    .addComponent(spnDefense, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pneStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSpAttack)
                    .addComponent(spnSpAttack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pneStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSpDefense)
                    .addComponent(spnSpDefense, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pneStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHP)
                    .addComponent(spnHP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pneStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUnknown)
                    .addComponent(spnUnknown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pneStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEXP)
                    .addComponent(spnEXP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pneFactors.setBorder(javax.swing.BorderFactory.createTitledBorder("Factors"));

        lblRecruit.setText("Recruit factor");

        lblLowKick.setText("Low Kick damage");

        lblSizeBust.setText("Size Bust damage");

        spnRecruit.setModel(new javax.swing.SpinnerNumberModel((short)0, null, null, (short)1));
        spnRecruit.setEditor(new javax.swing.JSpinner.NumberEditor(spnRecruit, "0"));

        spnLowKick.setModel(new javax.swing.SpinnerNumberModel(0, 0, 65535, 1));
        spnLowKick.setEditor(new javax.swing.JSpinner.NumberEditor(spnLowKick, "0"));

        spnSizeBust.setModel(new javax.swing.SpinnerNumberModel(0, 0, 65535, 1));
        spnSizeBust.setEditor(new javax.swing.JSpinner.NumberEditor(spnSizeBust, "0"));

        javax.swing.GroupLayout pneFactorsLayout = new javax.swing.GroupLayout(pneFactors);
        pneFactors.setLayout(pneFactorsLayout);
        pneFactorsLayout.setHorizontalGroup(
            pneFactorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pneFactorsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pneFactorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pneFactorsLayout.createSequentialGroup()
                        .addComponent(lblRecruit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(spnRecruit, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pneFactorsLayout.createSequentialGroup()
                        .addGroup(pneFactorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblLowKick)
                            .addComponent(lblSizeBust))
                        .addGap(119, 119, 119)
                        .addGroup(pneFactorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(spnLowKick)
                            .addComponent(spnSizeBust))))
                .addContainerGap())
        );
        pneFactorsLayout.setVerticalGroup(
            pneFactorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pneFactorsLayout.createSequentialGroup()
                .addGroup(pneFactorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRecruit)
                    .addComponent(spnRecruit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pneFactorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLowKick, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spnLowKick, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pneFactorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spnSizeBust, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSizeBust)))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Unknown"));

        lblUnknownOffset.setText("Offset");

        lblUnknownValue.setText("Value");

        cmoUnknown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0xA", "0xB", "0x12", "0x1A", "0x1B", "0x1C", "0x1D", "0x30", "0x31", "0x32", "0x33" }));
        cmoUnknown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmoUnknownActionPerformed(evt);
            }
        });

        txtUnknown.setEditable(false);
        txtUnknown.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUnknownOffset)
                    .addComponent(lblUnknownValue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtUnknown)
                    .addComponent(cmoUnknown, 0, 125, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUnknownOffset)
                    .addComponent(cmoUnknown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUnknownValue)
                    .addComponent(txtUnknown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        listPokemon.setModel(model = new DefaultListModel());
        listPokemon.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listPokemon.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listPokemonValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listPokemon);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pneMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pneStats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(pneFactors, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pneMisc, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pneEvolution, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSave))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pneMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pneStats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pneEvolution, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pneFactors, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pneMisc, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        save();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void cmoUnknownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmoUnknownActionPerformed
        showUnknownBytes();
    }//GEN-LAST:event_cmoUnknownActionPerformed

    private void listPokemonValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listPokemonValueChanged
        load();
    }//GEN-LAST:event_listPokemonValueChanged
    
    private DefaultListModel model;
    private Pokemon selected;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cmoAbility1;
    private javax.swing.JComboBox<String> cmoAbility2;
    private javax.swing.JComboBox<String> cmoArea;
    private javax.swing.JComboBox<String> cmoEvolutionAddition;
    private javax.swing.JComboBox<String> cmoEvolutionType;
    private javax.swing.JComboBox<String> cmoEvolveFrom;
    private javax.swing.JComboBox<String> cmoShadow;
    private javax.swing.JComboBox<String> cmoType1;
    private javax.swing.JComboBox<String> cmoType2;
    private javax.swing.JComboBox<String> cmoUnknown;
    private javax.swing.JComboBox<String> cmoWalkable;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAbility1;
    private javax.swing.JLabel lblAbility2;
    private javax.swing.JLabel lblArea;
    private javax.swing.JLabel lblAttack;
    private javax.swing.JLabel lblCategory;
    private javax.swing.JLabel lblCategoryPointer;
    private javax.swing.JLabel lblDefense;
    private javax.swing.JLabel lblDexNo;
    private javax.swing.JLabel lblEXP;
    private javax.swing.JLabel lblEvolutionParam;
    private javax.swing.JLabel lblEvolutionType;
    private javax.swing.JLabel lblEvolutionUnknown;
    private javax.swing.JLabel lblEvolveFrom;
    private javax.swing.JLabel lblFacesBitfield;
    private javax.swing.JLabel lblHP;
    private javax.swing.JLabel lblInternalNo;
    private javax.swing.JLabel lblInternalNo3;
    private javax.swing.JLabel lblLowKick;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNamePointer;
    private javax.swing.JLabel lblPalette;
    private javax.swing.JLabel lblParentNo;
    private javax.swing.JLabel lblRecruit;
    private javax.swing.JLabel lblShadow;
    private javax.swing.JLabel lblSize;
    private javax.swing.JLabel lblSizeBust;
    private javax.swing.JLabel lblSpAttack;
    private javax.swing.JLabel lblSpDefense;
    private javax.swing.JLabel lblSpeed;
    private javax.swing.JLabel lblType1;
    private javax.swing.JLabel lblType2;
    private javax.swing.JLabel lblUnknown;
    private javax.swing.JLabel lblUnknownOffset;
    private javax.swing.JLabel lblUnknownValue;
    private javax.swing.JLabel lblWalkable;
    private javax.swing.JList<String> listPokemon;
    private javax.swing.JPanel pneEvolution;
    private javax.swing.JPanel pneFactors;
    private javax.swing.JPanel pneMain;
    private javax.swing.JPanel pneMisc;
    private javax.swing.JPanel pneStats;
    private javax.swing.JSpinner spnAlphabeticalNo;
    private javax.swing.JSpinner spnAttack;
    private javax.swing.JSpinner spnDefense;
    private javax.swing.JSpinner spnDexNo;
    private javax.swing.JSpinner spnEXP;
    private javax.swing.JSpinner spnEvolutionParam;
    private javax.swing.JSpinner spnHP;
    private javax.swing.JSpinner spnInternalNo;
    private javax.swing.JSpinner spnLowKick;
    private javax.swing.JSpinner spnPalette;
    private javax.swing.JSpinner spnParentNo;
    private javax.swing.JSpinner spnRecruit;
    private javax.swing.JSpinner spnSize;
    private javax.swing.JSpinner spnSizeBust;
    private javax.swing.JSpinner spnSpAttack;
    private javax.swing.JSpinner spnSpDefense;
    private javax.swing.JSpinner spnSpeed;
    private javax.swing.JSpinner spnUnknown;
    private javax.swing.JTextField txtCategory;
    private javax.swing.JTextField txtCategoryPointer;
    private javax.swing.JTextField txtFacesBitfield;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNamePointer;
    private javax.swing.JTextField txtUnknown;
    // End of variables declaration//GEN-END:variables
}