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
import javax.swing.JFrame;

public abstract class AbstractEditor extends JFrame {
    public AbstractEditor() {
        initComponents();
        initProperties();
    }
    
    protected abstract void initProperties();
    protected abstract void load();
    protected abstract void save();
    protected abstract void warningLabel();

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        saveButton = new javax.swing.JButton();
        warningLabel = new javax.swing.JLabel();
        scrollList = new javax.swing.JScrollPane();
        list = new javax.swing.JList<>();
        scrollProperties = new javax.swing.JScrollPane();
        properties = new com.aurum.mystery2.swing.JPropertyPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Abstract editor form");
        setIconImage(com.aurum.mystery2.Main.icon);
        setResizable(false);

        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        warningLabel.setForeground(new java.awt.Color(255, 0, 0));

        list.setModel(model = new DefaultListModel());
        list.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        list.setMaximumSize(new java.awt.Dimension(275, 535));
        list.setMinimumSize(new java.awt.Dimension(275, 535));
        list.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listValueChanged(evt);
            }
        });
        scrollList.setViewportView(list);

        scrollProperties.setMaximumSize(new java.awt.Dimension(400, 525));
        scrollProperties.setMinimumSize(new java.awt.Dimension(400, 525));
        scrollProperties.setPreferredSize(new java.awt.Dimension(400, 525));

        properties.setMaximumSize(new java.awt.Dimension(400, 505));
        properties.setMinimumSize(new java.awt.Dimension(400, 505));
        scrollProperties.setViewportView(properties);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(512, 512, 512)
                        .addComponent(warningLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(scrollList, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollProperties, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(scrollProperties, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scrollList, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(warningLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        save();
    }//GEN-LAST:event_saveButtonActionPerformed

    private void listValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listValueChanged
        load();
    }//GEN-LAST:event_listValueChanged
    
    protected DefaultListModel model;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JList<String> list;
    protected com.aurum.mystery2.swing.JPropertyPanel properties;
    protected javax.swing.JButton saveButton;
    protected javax.swing.JScrollPane scrollList;
    protected javax.swing.JScrollPane scrollProperties;
    protected javax.swing.JLabel warningLabel;
    // End of variables declaration//GEN-END:variables
}