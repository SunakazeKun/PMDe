package com.aurum.mystery2.swing;

import com.aurum.mystery2.BitConverter;
import com.aurum.mystery2.Lists;
import com.aurum.mystery2.game.Area;
import com.aurum.mystery2.game.RomFile;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

public class AreaEditor extends AbstractEditor {
    private Area selected;
    
    private JLabel lblCondition, lblPrice, lblCount, lblName, lblNamePointer;
    private JComboBox cmoCondition;
    private JSpinner spnPrice, spnCount;
    private JTextField txtName, txtNamePointer;
    
    public AreaEditor() {
        Lists.areas.stream().forEach((area) -> { model.addElement(area); });
        list.setSelectedIndex(0);
    }
    
    @Override
    protected void initProperties() {
        setTitle("Friend area editor");
        
        // Initialize the components
        lblName = new JLabel("Name");
        lblNamePointer = new JLabel("Name pointer");
        lblCount = new JLabel("No. of Pokémon");
        lblCondition = new JLabel("Unlock condition");
        lblPrice = new JLabel("Price");
        txtName = new JTextField("00000000");
        txtName.setEditable(false);
        txtNamePointer = new JTextField();
        txtNamePointer.setEditable(false);
        spnCount = new JSpinner();
        spnCount.setModel(new SpinnerNumberModel(0, 0, 15, 1));
        cmoCondition = new JComboBox();
        cmoCondition.setModel(new DefaultComboBoxModel(new String[] { "0x0: Shop (Story-game)", "0x1: Shop (Post-game)", "0x2: Wonder mail event", "0x3: Legendary request" }));
        spnPrice = new JSpinner();
        spnPrice.setModel(new SpinnerNumberModel(Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(99999L), Long.valueOf(1L)));
        
        // Add the components to the property panel
        properties.addCaption("Area settings");
        properties.addLabeledComponent(lblName, txtName);
        properties.addLabeledComponent(lblNamePointer, txtNamePointer);
        properties.addLabeledComponent(lblCount, spnCount);
        properties.addLabeledComponent(lblCondition, cmoCondition);
        properties.addLabeledComponent(lblPrice, spnPrice);
        properties.addTerminator();
    }

    @Override
    protected void load() {
        if (list.getSelectedIndex() < 0)
            return;
        
        selected = (Area) RomFile.current.areas.get(list.getSelectedIndex()).clone();
        
        txtName.setText(selected.name);
        txtName.setCaretPosition(0);
        txtNamePointer.setText(BitConverter.toHexIntString(selected.namePointer));
        
        spnCount.setValue(selected.count);
        cmoCondition.setSelectedIndex(selected.condition);
        spnPrice.setValue(selected.price);
    }

    @Override
    protected void save() {
        if (selected == null || list.getSelectedIndex() < 0)
            return;
        
        selected.count = (int) spnCount.getValue();
        selected.condition = cmoCondition.getSelectedIndex();
        selected.price = (long) spnPrice.getValue();
        
        RomFile.current.areas.set(list.getSelectedIndex(), selected);
    }

    @Override
    protected void warningLabel() {}
}