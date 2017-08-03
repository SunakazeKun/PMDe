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
import com.aurum.mystery2.game.DungeonPokemon;

public class DungeonPokemonEditor extends javax.swing.JFrame {
    public DungeonPokemonEditor() {
        this(-1);
    }
    
    public DungeonPokemonEditor(int traps) {
        initComponents();
        Lists.pokemon.forEach((pokemon) -> { cmoPokemon.addItem(pokemon); });
        for (int i = 0 ; i < RomFile.current.dungeonPokemon.size() ; i++)
            model.addElement("Pokémon no. " + i);
        listPokemon.setSelectedIndex(traps);
        listPokemon.ensureIndexIsVisible(traps);
        load();
    }
    
    private boolean enabled() {
        boolean enable = listEntries.getSelectedIndex() >= 0 && cmoPokemon.getItemCount() == Lists.pokemon.size();
        cmoPokemon.setEnabled(enable);
        spnLevel.setEnabled(enable);
        spnProbability.setEnabled(enable);
        return enable;
    }
    
    private void warningLabel() {
        lblWarning.setText(selectedPokemon.checkProbabilitySum() ? "Warning! Probability sum does not equal 10000." : "");
    }
    
    private void load() {
        selectedPokemon = (DungeonPokemon) RomFile.current.dungeonPokemon.get(listPokemon.getSelectedIndex()).clone();
        entryModel.clear();

        selectedPokemon.entries.forEach((entry) -> {
            entryModel.addElement(entry.toString());
        });
        listEntries.setSelectedIndex(-1);

        warningLabel();
    }
    
    private void save() {
        int index = listPokemon.getSelectedIndex();
        if (selectedPokemon == null || index < 0)
            return;
        
        RomFile.current.dungeonPokemon.set(listPokemon.getSelectedIndex(), selectedPokemon);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSave = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listPokemon = new javax.swing.JList<>();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listEntries = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        cmoPokemon = new javax.swing.JComboBox<>();
        lblLevel = new javax.swing.JLabel();
        spnLevel = new javax.swing.JSpinner();
        lblProbability = new javax.swing.JLabel();
        spnProbability = new javax.swing.JSpinner();
        lblWarning = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Dungeon Pokémon editor");
        setIconImage(com.aurum.mystery2.Main.icon);
        setResizable(false);

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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Pokémon entries"));

        listEntries.setModel(entryModel = new DefaultListModel());
        listEntries.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listEntries.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listEntriesValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(listEntries);

        jLabel1.setText("Pokémon");

        cmoPokemon.setEnabled(false);
        cmoPokemon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmoPokemonActionPerformed(evt);
            }
        });

        lblLevel.setText("Level");

        spnLevel.setModel(new javax.swing.SpinnerNumberModel(1, 1, 99, 1));
        spnLevel.setEnabled(false);
        spnLevel.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnLevelStateChanged(evt);
            }
        });

        lblProbability.setText("Probability");

        spnProbability.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10000, 1));
        spnProbability.setEditor(new javax.swing.JSpinner.NumberEditor(spnProbability, "#,##0,00'%'"));
        spnProbability.setEnabled(false);
        spnProbability.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnProbabilityStateChanged(evt);
            }
        });

        lblWarning.setForeground(new java.awt.Color(255, 0, 0));
        lblWarning.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(lblLevel))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(spnLevel)
                                .addComponent(cmoPokemon, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(spnProbability, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))))
                    .addComponent(lblProbability)
                    .addComponent(lblWarning))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmoPokemon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLevel)
                    .addComponent(spnLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProbability)
                    .addComponent(spnProbability, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblWarning)
                .addContainerGap())
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(btnSave)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        save();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void listPokemonValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listPokemonValueChanged
        if (listPokemon.getSelectedIndex() < 0)
            return;
        
        load();
    }//GEN-LAST:event_listPokemonValueChanged

    private void listEntriesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listEntriesValueChanged
        if (!enabled())
            return;
        
        selectedEntry = selectedPokemon.entries.get(listEntries.getSelectedIndex());
        
        cmoPokemon.setSelectedIndex(selectedEntry.species);
        spnLevel.setValue(selectedEntry.level);
        spnProbability.setValue(selectedEntry.probability);
    }//GEN-LAST:event_listEntriesValueChanged

    private void spnLevelStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnLevelStateChanged
        if (!enabled())
            return;
        
        selectedEntry.level = (int) spnLevel.getValue();
        
        entryModel.set(listEntries.getSelectedIndex(), selectedEntry.toString());
    }//GEN-LAST:event_spnLevelStateChanged

    private void spnProbabilityStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnProbabilityStateChanged
        if (!enabled())
            return;
        
        selectedEntry.probability = (int) spnProbability.getValue();
        
        entryModel.set(listEntries.getSelectedIndex(), selectedEntry.toString());
        warningLabel();
    }//GEN-LAST:event_spnProbabilityStateChanged

    private void cmoPokemonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmoPokemonActionPerformed
        if (!enabled())
            return;
        
        selectedEntry.species = cmoPokemon.getSelectedIndex();
        
        entryModel.set(listEntries.getSelectedIndex(), selectedEntry.toString());
    }//GEN-LAST:event_cmoPokemonActionPerformed
    
    private DefaultListModel model, entryModel;
    private DungeonPokemon selectedPokemon;
    private DungeonPokemon.Entry selectedEntry;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cmoPokemon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblLevel;
    private javax.swing.JLabel lblProbability;
    private javax.swing.JLabel lblWarning;
    private javax.swing.JList<String> listEntries;
    private javax.swing.JList<String> listPokemon;
    private javax.swing.JSpinner spnLevel;
    private javax.swing.JSpinner spnProbability;
    // End of variables declaration//GEN-END:variables
}