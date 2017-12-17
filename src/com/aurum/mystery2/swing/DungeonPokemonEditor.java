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
import com.aurum.mystery2.game.DungeonPokemon;
import com.aurum.mystery2.game.RomFile;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class DungeonPokemonEditor extends AbstractEditor {
    private DungeonPokemon selected;
    private DungeonPokemon.Entry selectedEntry;
    private DefaultListModel entryModel;
    
    private JList<String> listEntries;
    private JScrollPane scroll;
    
    private JLabel lblPokemon, lblLevel, lblProbability;
    private JComboBox<String> cmoPokemon;
    private JSpinner spnLevel, spnProbability;
    
    public DungeonPokemonEditor() {
        this(-1);
    }
    
    public DungeonPokemonEditor(int pokemon) {
        for (int i = 0 ; i < RomFile.current.dungeonPokemon.size() ; i++)
            model.addElement("Pokémon no. " + i);
        
        list.setSelectedIndex(pokemon);
        list.ensureIndexIsVisible(pokemon);
    }
    
    @Override
    protected void initProperties() {
        setTitle("Dungeon Pokémon editor");
        
        // Initialize the components
        entryModel = new DefaultListModel();
        listEntries = new JList();
        listEntries.setModel(entryModel);
        listEntries.addListSelectionListener((javax.swing.event.ListSelectionEvent evt) -> {
            if (selected == null || listEntries.getSelectedIndex() < 0)
                return;

            selectedEntry = selected.entries.get(listEntries.getSelectedIndex());

            cmoPokemon.setSelectedIndex(selectedEntry.species);
            spnLevel.setValue(selectedEntry.level);
            spnProbability.setValue(selectedEntry.probability);
        });
        scroll = new JScrollPane();
        scroll.setViewportView(listEntries);
        
        lblPokemon = new JLabel("Pokémon");
        lblLevel = new JLabel("Level");
        lblProbability = new JLabel("Probability");
        cmoPokemon = new JComboBox();
        cmoPokemon.setModel(new DefaultComboBoxModel(Lists.pokemon.toArray()));
        cmoPokemon.addActionListener((java.awt.event.ActionEvent evt) -> {
            if (selectedEntry == null)
                return;
            
            selectedEntry.species = cmoPokemon.getSelectedIndex();
            entryModel.set(listEntries.getSelectedIndex(), selectedEntry.toString());
        });
        spnLevel = new JSpinner();
        spnLevel.setModel(new SpinnerNumberModel(1, 1, 99, 1));
        spnLevel.addChangeListener((javax.swing.event.ChangeEvent evt) -> {
            if (selectedEntry == null)
                return;
            
            selectedEntry.level = (int) spnLevel.getValue();
            entryModel.set(listEntries.getSelectedIndex(), selectedEntry.toString());
        });
        spnProbability = new JSpinner();
        spnProbability.setModel(new SpinnerNumberModel(0, 0, 10000, 1));
        spnProbability.setEditor(new JSpinner.NumberEditor(spnProbability, "#,##0,00'%'"));
        spnProbability.addChangeListener((javax.swing.event.ChangeEvent evt) -> {
            if (selectedEntry == null)
                return;
            
            selectedEntry.probability = (int) spnProbability.getValue();
            entryModel.set(listEntries.getSelectedIndex(), selectedEntry.toString());
            warningLabel();
        });
        
        // Add the components to the property panel
        properties.addCaption("Entries");
        properties.addComponent(scroll);
        properties.addSeparator();
        properties.addCaption("Entry settings");
        properties.addLabeledComponent(lblPokemon, cmoPokemon);
        properties.addLabeledComponent(lblLevel, spnLevel);
        properties.addLabeledComponent(lblProbability, spnProbability);
        properties.addTerminator();
    }

    @Override
    protected void load() {
        if (list.getSelectedIndex() < 0)
            return;
        
        entryModel.clear();
        selected = (DungeonPokemon) RomFile.current.dungeonPokemon.get(list.getSelectedIndex()).clone();
        selected.entries.forEach((entry) -> { entryModel.addElement(entry.toString()); });
        listEntries.setSelectedIndex(selected.entries.size() > 0 ? 0 : -1);
        
        warningLabel();
    }

    @Override
    protected void save() {
        if (selected == null || list.getSelectedIndex() < 0)
            return;
        
        RomFile.current.dungeonPokemon.set(list.getSelectedIndex(), selected);
    }
    
    @Override
    protected void warningLabel() {
        warningLabel.setText(selected.checkProbabilitySum() ? "Warning! Probability sum does not equal 10000." : "");
    }
}