/*
 * Copyright (C) 2017 Aurum
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
import com.aurum.mystery2.game.Item;
import com.aurum.mystery2.game.RomFile;
import com.aurum.mystery2.BitConverter;

public class ItemEditor extends javax.swing.JFrame {

    public ItemEditor() {
        initComponents();
        Lists.items.stream().forEach((item) -> { model.addElement(item); });
        Lists.moves.stream().forEach((move) -> { cmoMove.addItem(move); });
        listItems.setSelectedIndex(0);
    }

    private void load() {
        if (cmoMove.getItemCount() != Lists.moves.size())
            return;
        
        selected = RomFile.current.items.get(listItems.getSelectedIndex());
        txtName.setText(selected.name);
        txtName.setCaretPosition(0);
        txtDescription.setText(selected.description);
        txtDescription.setCaretPosition(0);
        spnShopPrice.setValue(selected.buyPrice);
        spnSellPrice.setValue(selected.sellPrice);
        spnOrder.setValue(selected.order);
        cmoMove.setSelectedIndex(selected.move);
        cmoType.setSelectedIndex(selected.type);
        cmoSubtype.setSelectedIndex(selected.subtype);
        
        cmoIcon.setSelectedIndex(selected.icon);
        spnPalette.setValue(selected.palette);
        
        spnUnkThrowing1.setValue(selected.unkThrowing1B);
        spnUnkThrowing2.setValue(selected.unkThrowing1C);
        chkThrowingDamage.setSelected(selected.throwingDamage);
        chkUnkFood1.setSelected(selected.unkFood1);
        chkUnkFood2.setSelected(selected.unkFood2);
        
        txtNamePointer.setText(BitConverter.toHexIntString(selected.namePointer));
        txtDescriptionPointer.setText(BitConverter.toHexIntString(selected.descriptionPointer));
    }
    
    private void save() {
        selected.buyPrice = (long) spnShopPrice.getValue();
        selected.sellPrice = (long) spnSellPrice.getValue();
        selected.order = (short) spnOrder.getValue();
        selected.move = (short) cmoMove.getSelectedIndex();
        selected.type = (short) cmoType.getSelectedIndex();
        selected.subtype = (short) cmoSubtype.getSelectedIndex();
        
        selected.icon = (short) cmoIcon.getSelectedIndex();
        selected.palette = (short) spnPalette.getValue();
        
        selected.unkThrowing1B = (short) spnUnkThrowing1.getValue();
        selected.unkThrowing1C = (short) spnUnkThrowing2.getValue();
        selected.throwingDamage = chkThrowingDamage.isSelected();
        selected.unkFood1 = chkUnkFood1.isSelected();
        selected.unkFood2 = chkUnkFood2.isSelected();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSave = new javax.swing.JButton();
        pnlGeneral = new javax.swing.JPanel();
        lblName = new javax.swing.JLabel();
        lblDescription = new javax.swing.JLabel();
        lblShopPrice = new javax.swing.JLabel();
        lblSellPrice = new javax.swing.JLabel();
        lblOrder = new javax.swing.JLabel();
        lblMove = new javax.swing.JLabel();
        lblType = new javax.swing.JLabel();
        lblSubtype = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtDescription = new javax.swing.JTextField();
        spnShopPrice = new javax.swing.JSpinner();
        spnSellPrice = new javax.swing.JSpinner();
        spnOrder = new javax.swing.JSpinner();
        cmoMove = new javax.swing.JComboBox<>();
        cmoType = new javax.swing.JComboBox<>();
        cmoSubtype = new javax.swing.JComboBox<>();
        pnlDungeon = new javax.swing.JPanel();
        lblUnkThrowing1 = new javax.swing.JLabel();
        lblUnkThrowing2 = new javax.swing.JLabel();
        spnUnkThrowing1 = new javax.swing.JSpinner();
        spnUnkThrowing2 = new javax.swing.JSpinner();
        chkThrowingDamage = new javax.swing.JCheckBox();
        chkUnkFood1 = new javax.swing.JCheckBox();
        chkUnkFood2 = new javax.swing.JCheckBox();
        pnlMisc = new javax.swing.JPanel();
        lblIcon = new javax.swing.JLabel();
        lblPalette = new javax.swing.JLabel();
        lblNamePointer = new javax.swing.JLabel();
        lblDescriptionPointer = new javax.swing.JLabel();
        cmoIcon = new javax.swing.JComboBox<>();
        spnPalette = new javax.swing.JSpinner();
        txtNamePointer = new javax.swing.JTextField();
        txtDescriptionPointer = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        listItems = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Item editor");
        setIconImage(com.aurum.mystery2.Main.icon);
        setResizable(false);

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        pnlGeneral.setBorder(javax.swing.BorderFactory.createTitledBorder("General"));

        lblName.setText("Name");

        lblDescription.setText("Description");

        lblShopPrice.setText("Shop price");

        lblSellPrice.setText("Sell price");

        lblOrder.setText("Storage order");

        lblMove.setText("Move");

        lblType.setText("Type");

        lblSubtype.setText("Category");

        txtName.setEditable(false);

        txtDescription.setEditable(false);

        spnShopPrice.setModel(new javax.swing.SpinnerNumberModel(Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(2147483647L), Long.valueOf(1L)));
        spnShopPrice.setEditor(new javax.swing.JSpinner.NumberEditor(spnShopPrice, "0"));

        spnSellPrice.setModel(new javax.swing.SpinnerNumberModel(Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(2147483647L), Long.valueOf(1L)));
        spnSellPrice.setEditor(new javax.swing.JSpinner.NumberEditor(spnSellPrice, "0"));

        spnOrder.setModel(new javax.swing.SpinnerNumberModel(Short.valueOf((short)0), Short.valueOf((short)0), Short.valueOf((short)255), Short.valueOf((short)1)));
        spnOrder.setEditor(new javax.swing.JSpinner.NumberEditor(spnOrder, "0"));

        cmoType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00: Throwable", "01: Rock", "02: Berry / Seed", "03: Apple / Gummi", "04: Hold item", "05: TM", "06: Money", "07: Unused", "08: Misc.", "09: Orb", "0A: Link Box", "0B: Used TM" }));

        cmoSubtype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00: Nothing", "01: Throwable", "02: Rocks", "03: Ribbons", "04: Food", "05: Healing items", "06: Chestnut", "07: Money / Wish Stone", "08: Misc.", "09: TMs", "0A: Link Box", "0B: Specs", "0C: Scarfs", "0D: Orbs" }));

        javax.swing.GroupLayout pnlGeneralLayout = new javax.swing.GroupLayout(pnlGeneral);
        pnlGeneral.setLayout(pnlGeneralLayout);
        pnlGeneralLayout.setHorizontalGroup(
            pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGeneralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlGeneralLayout.createSequentialGroup()
                        .addGroup(pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblShopPrice)
                            .addComponent(lblSellPrice)
                            .addComponent(lblOrder))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                        .addGroup(pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(spnOrder)
                            .addComponent(spnSellPrice)
                            .addComponent(spnShopPrice)))
                    .addGroup(pnlGeneralLayout.createSequentialGroup()
                        .addGroup(pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblName)
                            .addComponent(lblDescription)
                            .addComponent(lblMove))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmoMove, 0, 130, Short.MAX_VALUE)
                            .addComponent(txtDescription)
                            .addComponent(txtName)))
                    .addGroup(pnlGeneralLayout.createSequentialGroup()
                        .addComponent(lblType)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmoType, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlGeneralLayout.createSequentialGroup()
                        .addComponent(lblSubtype)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmoSubtype, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlGeneralLayout.setVerticalGroup(
            pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGeneralLayout.createSequentialGroup()
                .addGroup(pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDescription)
                    .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblShopPrice)
                    .addComponent(spnShopPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSellPrice)
                    .addComponent(spnSellPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOrder)
                    .addComponent(spnOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMove)
                    .addComponent(cmoMove, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblType)
                    .addComponent(cmoType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmoSubtype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSubtype)))
        );

        pnlDungeon.setBorder(javax.swing.BorderFactory.createTitledBorder("Dungeon"));

        lblUnkThrowing1.setText("Unk. throwing factor");

        lblUnkThrowing2.setText("Unk. throwing factor");

        spnUnkThrowing1.setModel(new javax.swing.SpinnerNumberModel(Short.valueOf((short)0), Short.valueOf((short)0), Short.valueOf((short)255), Short.valueOf((short)1)));
        spnUnkThrowing1.setEditor(new javax.swing.JSpinner.NumberEditor(spnUnkThrowing1, "0"));

        spnUnkThrowing2.setModel(new javax.swing.SpinnerNumberModel(Short.valueOf((short)0), Short.valueOf((short)0), Short.valueOf((short)255), Short.valueOf((short)1)));
        spnUnkThrowing2.setEditor(new javax.swing.JSpinner.NumberEditor(spnUnkThrowing2, "0"));

        chkThrowingDamage.setText("Throwing damage");

        chkUnkFood1.setText("Unk. food bool");

        chkUnkFood2.setText("Unk. food bool");

        javax.swing.GroupLayout pnlDungeonLayout = new javax.swing.GroupLayout(pnlDungeon);
        pnlDungeon.setLayout(pnlDungeonLayout);
        pnlDungeonLayout.setHorizontalGroup(
            pnlDungeonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDungeonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDungeonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDungeonLayout.createSequentialGroup()
                        .addGroup(pnlDungeonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUnkThrowing1)
                            .addComponent(lblUnkThrowing2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlDungeonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(spnUnkThrowing2)
                            .addComponent(spnUnkThrowing1, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)))
                    .addGroup(pnlDungeonLayout.createSequentialGroup()
                        .addComponent(chkThrowingDamage)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlDungeonLayout.createSequentialGroup()
                        .addComponent(chkUnkFood1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(chkUnkFood2)))
                .addContainerGap())
        );
        pnlDungeonLayout.setVerticalGroup(
            pnlDungeonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDungeonLayout.createSequentialGroup()
                .addGroup(pnlDungeonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUnkThrowing1)
                    .addComponent(spnUnkThrowing1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDungeonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUnkThrowing2)
                    .addComponent(spnUnkThrowing2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkThrowingDamage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDungeonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkUnkFood1)
                    .addComponent(chkUnkFood2)))
        );

        pnlMisc.setBorder(javax.swing.BorderFactory.createTitledBorder("Misc."));

        lblIcon.setText("Icon");

        lblPalette.setText("Palette");

        lblNamePointer.setText("Name pointer");

        lblDescriptionPointer.setText("Description pointer");

        cmoIcon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00: Spike", "01: Stone", "02: Berry", "03: Apple", "04: Ribbon", "05: Box", "06: Money", "07: Note", "08: TM", "09: Gear", "0A: Link Box", "0B: Chestnut", "0C: Healing item", "0D: Glasses", "0E: Seed", "0F: Orb", "10: Key", "11: Gummi", "12: Regi part", "13: Banana", "14: Scale", "15: Thrown spike", "16: Thrown spike (alt.)", "17: Flower" }));

        spnPalette.setModel(new javax.swing.SpinnerNumberModel(Short.valueOf((short)0), Short.valueOf((short)0), Short.valueOf((short)12), Short.valueOf((short)1)));
        spnPalette.setEditor(new javax.swing.JSpinner.NumberEditor(spnPalette, "0"));

        txtNamePointer.setEditable(false);
        txtNamePointer.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtNamePointer.setText("00000000");

        txtDescriptionPointer.setEditable(false);
        txtDescriptionPointer.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtDescriptionPointer.setText("00000000");

        javax.swing.GroupLayout pnlMiscLayout = new javax.swing.GroupLayout(pnlMisc);
        pnlMisc.setLayout(pnlMiscLayout);
        pnlMiscLayout.setHorizontalGroup(
            pnlMiscLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMiscLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMiscLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNamePointer)
                    .addComponent(lblPalette)
                    .addComponent(lblDescriptionPointer)
                    .addComponent(lblIcon))
                .addGap(37, 37, 37)
                .addGroup(pnlMiscLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmoIcon, 0, 1, Short.MAX_VALUE)
                    .addComponent(txtNamePointer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                    .addComponent(spnPalette)
                    .addComponent(txtDescriptionPointer))
                .addContainerGap())
        );
        pnlMiscLayout.setVerticalGroup(
            pnlMiscLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMiscLayout.createSequentialGroup()
                .addGroup(pnlMiscLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIcon)
                    .addComponent(cmoIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMiscLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spnPalette, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPalette))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMiscLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNamePointer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNamePointer))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMiscLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDescriptionPointer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDescriptionPointer)))
        );

        listItems.setModel(model = new DefaultListModel());
        listItems.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listItems.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listItemsValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listItems);

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
                .addComponent(pnlGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlDungeon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlMisc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlDungeon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlMisc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSave)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        save();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void listItemsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listItemsValueChanged
        load();
    }//GEN-LAST:event_listItemsValueChanged
    
    private DefaultListModel model;
    private Item selected;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JCheckBox chkThrowingDamage;
    private javax.swing.JCheckBox chkUnkFood1;
    private javax.swing.JCheckBox chkUnkFood2;
    private javax.swing.JComboBox<String> cmoIcon;
    private javax.swing.JComboBox<String> cmoMove;
    private javax.swing.JComboBox<String> cmoSubtype;
    private javax.swing.JComboBox<String> cmoType;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDescription;
    private javax.swing.JLabel lblDescriptionPointer;
    private javax.swing.JLabel lblIcon;
    private javax.swing.JLabel lblMove;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNamePointer;
    private javax.swing.JLabel lblOrder;
    private javax.swing.JLabel lblPalette;
    private javax.swing.JLabel lblSellPrice;
    private javax.swing.JLabel lblShopPrice;
    private javax.swing.JLabel lblSubtype;
    private javax.swing.JLabel lblType;
    private javax.swing.JLabel lblUnkThrowing1;
    private javax.swing.JLabel lblUnkThrowing2;
    private javax.swing.JList<String> listItems;
    private javax.swing.JPanel pnlDungeon;
    private javax.swing.JPanel pnlGeneral;
    private javax.swing.JPanel pnlMisc;
    private javax.swing.JSpinner spnOrder;
    private javax.swing.JSpinner spnPalette;
    private javax.swing.JSpinner spnSellPrice;
    private javax.swing.JSpinner spnShopPrice;
    private javax.swing.JSpinner spnUnkThrowing1;
    private javax.swing.JSpinner spnUnkThrowing2;
    private javax.swing.JTextField txtDescription;
    private javax.swing.JTextField txtDescriptionPointer;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNamePointer;
    // End of variables declaration//GEN-END:variables
}