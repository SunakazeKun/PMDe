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
import com.aurum.mystery2.Main;
import com.aurum.mystery2.game.Item;
import com.aurum.mystery2.game.RomFile;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

public class ItemEditor extends AbstractEditor {
    private Item selected;
    
    private BufferedImage icons;
    
    private JLabel lblName, lblNamePointer, lblDesc, lblDescPointer;
    private JTextField txtName, txtNamePointer, txtDesc, txtDescPointer;
    
    private JLabel lblPreview, lblIcon, lblPalette;
    private JComboBox<String> cmoIcon;
    private JSlider sdrPalette;
    
    private JLabel lblShopPrice, lblSellPrice, lblOrder, lblMove, lblType, lblSubtype;
    private JSpinner spnShopPrice, spnSellPrice, spnOrder;
    private JComboBox<String> cmoMove, cmoType, cmoSubtype;
    
    private JLabel lblUnkThrow1, lblUnkThrow2;
    private JSpinner spnUnkThrow1, spnUnkThrow2;
    private JCheckBox chkThrowingDamage, chkUnkFood1, chkUnkFood2;
    
    public ItemEditor() {
        Lists.items.stream().forEach((item) -> { model.addElement(item); });
        list.setSelectedIndex(0);
    }
    
    @Override
    protected void initProperties() {
        setTitle("Item editor");
        
        // Initialize the components
        try {
            icons = ImageIO.read(Main.class.getResourceAsStream("/res/items.png"));
        }
        catch (IOException ex) {
            System.err.print(ex);
        }
        
        lblName = new JLabel("Name");
        lblNamePointer = new JLabel("Name pointer");
        lblDesc = new JLabel("Description");
        lblDescPointer = new JLabel("Description pointer");
        txtName = new JTextField();
        txtName.setEditable(false);
        txtNamePointer = new JTextField("00000000");
        txtNamePointer.setEditable(false);
        txtDesc = new JTextField();
        txtDesc.setEditable(false);
        txtDescPointer = new JTextField("00000000");
        txtDescPointer.setEditable(false);
        
        lblPreview = new JLabel("Preview: ");
        lblPreview.setHorizontalTextPosition(SwingConstants.LEFT);
        lblIcon = new JLabel("Icon");
        lblPalette = new JLabel("Palette");
        cmoIcon = new JComboBox();
        cmoIcon.setModel(new DefaultComboBoxModel(new String[] { "00: Spike", "01: Stone", "02: Berry", "03: Apple", "04: Ribbon", "05: Box", "06: Money", "07: Note", "08: TM", "09: Gear", "0A: Link Box", "0B: Chestnut", "0C: Healing item", "0D: Glasses", "0E: Seed", "0F: Orb", "10: Key", "11: Gummi", "12: Regi part", "13: Banana", "14: Scale", "15: Thrown spike", "16: Thrown spike (alt.)", "17: Flower" }));
        cmoIcon.addActionListener((java.awt.event.ActionEvent evt) -> {
            updateItemIcon();
        });
        sdrPalette = new JSlider(0, 12);
        sdrPalette.setPaintLabels(true);
        sdrPalette.setPaintTicks(true);
        sdrPalette.setMinorTickSpacing(1);
        sdrPalette.setMajorTickSpacing(6);
        sdrPalette.addChangeListener((javax.swing.event.ChangeEvent evt) -> {
            updateItemIcon();
        });
        
        lblShopPrice = new JLabel("Shop price");
        lblSellPrice = new JLabel("Sell price");
        lblOrder = new JLabel("Storage order");
        lblMove = new JLabel("Move");
        lblType = new JLabel("Type");
        lblSubtype = new JLabel("Category");
        spnShopPrice = new JSpinner();
        spnShopPrice.setModel(new SpinnerNumberModel(Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(2147483647L), Long.valueOf(1L)));
        spnSellPrice = new JSpinner();
        spnSellPrice.setModel(new SpinnerNumberModel(Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(2147483647L), Long.valueOf(1L)));
        spnOrder = new JSpinner();
        spnOrder.setModel(new SpinnerNumberModel(Short.valueOf((short)0), Short.valueOf((short)0), Short.valueOf((short)255), Short.valueOf((short)1)));
        cmoMove = new JComboBox();
        cmoMove.setModel(new DefaultComboBoxModel(Lists.moves.toArray()));
        cmoType = new JComboBox();
        cmoType.setModel(new DefaultComboBoxModel(new String[] { "00: Throwable", "01: Rock", "02: Berry / Seed", "03: Apple / Gummi", "04: Hold item", "05: TM", "06: Money", "07: Unused", "08: Misc.", "09: Orb", "0A: Link Box", "0B: Used TM" }));
        cmoSubtype = new JComboBox();
        cmoSubtype.setModel(new DefaultComboBoxModel(new String[] { "00: Nothing", "01: Throwable", "02: Rocks", "03: Ribbons", "04: Food", "05: Healing items", "06: Chestnut", "07: Money / Wish Stone", "08: Misc.", "09: TMs", "0A: Link Box", "0B: Specs", "0C: Scarfs", "0D: Orbs" }));
        
        lblUnkThrow1 = new JLabel("Unk. throwing factor 1");
        lblUnkThrow2 = new JLabel("Unk. throwing factor 2");
        spnUnkThrow1 = new JSpinner();
        spnUnkThrow1.setModel(new SpinnerNumberModel(Short.valueOf((short)0), Short.valueOf((short)0), Short.valueOf((short)255), Short.valueOf((short)1)));
        spnUnkThrow2 = new JSpinner();
        spnUnkThrow2.setModel(new SpinnerNumberModel(Short.valueOf((short)0), Short.valueOf((short)0), Short.valueOf((short)255), Short.valueOf((short)1)));
        chkThrowingDamage = new JCheckBox("Throwing damage");
        chkUnkFood1 = new JCheckBox("Unk. food bool 1");
        chkUnkFood2 = new JCheckBox("Unk. food bool 2");
        
        // Add the components to the property panel
        properties.addCaption("Text");
        properties.addComponent(lblName, txtName);
        properties.addComponent(lblNamePointer, txtNamePointer);
        properties.addComponent(lblDesc, txtDesc);
        properties.addComponent(lblDescPointer, txtDescPointer);
        properties.addSeparator();
        properties.addCaption("Sprite");
        properties.addComponent(lblPreview);
        properties.addComponent(lblIcon, cmoIcon);
        properties.addComponent(lblPalette, sdrPalette);
        properties.addSeparator();
        properties.addCaption("Misc.");
        properties.addComponent(lblShopPrice, spnShopPrice);
        properties.addComponent(lblSellPrice, spnSellPrice);
        properties.addComponent(lblOrder, spnOrder);
        properties.addComponent(lblMove, cmoMove);
        properties.addComponent(lblType, cmoType);
        properties.addComponent(lblSubtype, cmoSubtype);
        properties.addSeparator();
        properties.addComponent(lblUnkThrow1, spnUnkThrow1);
        properties.addComponent(lblUnkThrow2, spnUnkThrow2);
        properties.addComponent(chkThrowingDamage);
        properties.addComponent(chkUnkFood1);
        properties.addComponent(chkUnkFood2);
        properties.addTerminator();
    }

    @Override
    protected void load() {
        if (list.getSelectedIndex() < 0)
            return;
        
        selected = (Item) RomFile.current.items.get(list.getSelectedIndex()).clone();
        
        txtName.setText(selected.name);
        txtName.setCaretPosition(0);
        txtDesc.setText(selected.desc);
        txtDesc.setCaretPosition(0);
        spnShopPrice.setValue(selected.buyPrice);
        spnSellPrice.setValue(selected.sellPrice);
        spnOrder.setValue(selected.order);
        cmoMove.setSelectedIndex(selected.move);
        cmoType.setSelectedIndex(selected.type);
        cmoSubtype.setSelectedIndex(selected.subtype);
        
        spnUnkThrow1.setValue(selected.unkThrow1B);
        spnUnkThrow2.setValue(selected.unkThrow1C);
        chkThrowingDamage.setSelected(selected.throwDamage);
        chkUnkFood1.setSelected(selected.unkFood1);
        chkUnkFood2.setSelected(selected.unkFood2);
        
        cmoIcon.setSelectedIndex(selected.icon);
        sdrPalette.setValue(selected.palette);
        
        txtNamePointer.setText(BitConverter.toHexIntString(selected.namePointer));
        txtDescPointer.setText(BitConverter.toHexIntString(selected.descPointer));
    }

    @Override
    protected void save() {
        if (selected == null || list.getSelectedIndex() < 0)
            return;
        
        selected.buyPrice = (long) spnShopPrice.getValue();
        selected.sellPrice = (long) spnSellPrice.getValue();
        selected.order = (short) spnOrder.getValue();
        selected.move = (short) cmoMove.getSelectedIndex();
        selected.type = (short) cmoType.getSelectedIndex();
        selected.subtype = (short) cmoSubtype.getSelectedIndex();
        
        selected.unkThrow1B = (short) spnUnkThrow1.getValue();
        selected.unkThrow1C = (short) spnUnkThrow2.getValue();
        selected.throwDamage = chkThrowingDamage.isSelected();
        selected.unkFood1 = chkUnkFood1.isSelected();
        selected.unkFood2 = chkUnkFood2.isSelected();
        
        selected.icon = (short) cmoIcon.getSelectedIndex();
        selected.palette = (short) sdrPalette.getValue();
        
        RomFile.current.items.set(list.getSelectedIndex(), selected);
    }

    @Override
    protected void warningLabel() {}
    
    private void updateItemIcon() {
        lblPreview.setIcon(new ImageIcon(icons.getSubimage(sdrPalette.getValue() * 16, cmoIcon.getSelectedIndex() * 16, 16, 16)));
    }
}