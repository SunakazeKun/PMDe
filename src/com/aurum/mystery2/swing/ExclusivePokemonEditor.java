package com.aurum.mystery2.swing;

import com.aurum.mystery2.Lists;
import com.aurum.mystery2.game.ExclusivePokemon;
import com.aurum.mystery2.game.RomFile;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;

public class ExclusivePokemonEditor extends AbstractEditor {
    private ExclusivePokemon selected;
    
    private JButton btnClear;
    
    private JLabel lblPokemon;
    private JComboBox cmoPokemon;
    private JCheckBox chkRed, chkBlue;
    
    public ExclusivePokemonEditor() {
        RomFile.current.exclusivePokemon.forEach((exc) -> { model.addElement(exc.toString()); });
        list.setSelectedIndex(0);
    }
    
    @Override
    protected void initProperties() {
        setTitle("Exclusive Pokémon editor");
        
        // Initialize the components
        
        lblPokemon = new JLabel("Pokémon");
        cmoPokemon = new JComboBox();
        cmoPokemon.setModel(new DefaultComboBoxModel(Lists.pokemon.toArray()));
        chkRed = new JCheckBox("Found in Red Rescue Team");
        chkBlue = new JCheckBox("Found in Blue Rescue Team");
        
        // Add the components to the property panel
        properties.addCaption("Exclusive Pokémon settings");
        properties.addLabeledComponent(lblPokemon, cmoPokemon);
        properties.addComponent(chkRed);
        properties.addComponent(chkBlue);
        properties.addTerminator();
        
        // Create additional toolbar components
        btnClear = new JButton("Clear entries");
        btnClear.addActionListener((java.awt.event.ActionEvent evt) -> {
            for (int i = 0 ; i < RomFile.current.exclusivePokemon.size() ; i++) {
                ExclusivePokemon exc = RomFile.current.exclusivePokemon.get(i);
                exc.species = 0;
                exc.red = false;
                exc.blue = false;
                model.set(i, exc.toString());
            }
        });
        toolbar.add(btnClear);
    }

    @Override
    protected void load() {
        if (list.getSelectedIndex() < 0)
            return;
        
        selected = (ExclusivePokemon) RomFile.current.exclusivePokemon.get(list.getSelectedIndex()).clone();
        
        cmoPokemon.setSelectedIndex(selected.species);
        chkRed.setSelected(selected.red);
        chkBlue.setSelected(selected.blue);
    }

    @Override
    protected void save() {
        if (selected == null || list.getSelectedIndex() < 0)
            return;
        
        selected.species = cmoPokemon.getSelectedIndex();
        selected.red = chkRed.isSelected();
        selected.blue = chkBlue.isSelected();
        
        model.set(list.getSelectedIndex(), selected.toString());
        RomFile.current.exclusivePokemon.set(list.getSelectedIndex(), selected);
    }

    @Override
    protected void warningLabel() {}
}