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
import com.aurum.mystery2.game.RomFile;

public class StarterEditor extends javax.swing.JFrame {

    public StarterEditor() {
        initComponents();
        
        Lists.pokemon.forEach((pokemon) -> {
            cmoMon1.addItem(pokemon); cmoMon2.addItem(pokemon);
            cmoMon3.addItem(pokemon); cmoMon4.addItem(pokemon);
            cmoMon5.addItem(pokemon); cmoMon6.addItem(pokemon);
            cmoMon7.addItem(pokemon); cmoMon8.addItem(pokemon);
            cmoMon9.addItem(pokemon); cmoMon10.addItem(pokemon);
            cmoMon11.addItem(pokemon); cmoMon12.addItem(pokemon);
            cmoMon13.addItem(pokemon); cmoMon14.addItem(pokemon);
            cmoMon15.addItem(pokemon); cmoMon16.addItem(pokemon);
            cmoMon17.addItem(pokemon); cmoMon18.addItem(pokemon);
            cmoMon19.addItem(pokemon); cmoMon20.addItem(pokemon);
            cmoMon21.addItem(pokemon); cmoMon22.addItem(pokemon);
            cmoMon23.addItem(pokemon); cmoMon24.addItem(pokemon);
            cmoMon25.addItem(pokemon); cmoMon26.addItem(pokemon);
                
            cmoPartner1.addItem(pokemon); cmoPartner2.addItem(pokemon);
            cmoPartner3.addItem(pokemon); cmoPartner4.addItem(pokemon);
            cmoPartner5.addItem(pokemon); cmoPartner6.addItem(pokemon);
            cmoPartner7.addItem(pokemon); cmoPartner8.addItem(pokemon);
            cmoPartner9.addItem(pokemon); cmoPartner10.addItem(pokemon);
        });
        
        load();
    }

    private void load() {
        starters = RomFile.current.starters;
        partners = RomFile.current.partners;
        
        cmoMon1.setSelectedIndex(starters[0]);
        cmoMon2.setSelectedIndex(starters[1]);
        cmoMon3.setSelectedIndex(starters[2]);
        cmoMon4.setSelectedIndex(starters[3]);
        cmoMon5.setSelectedIndex(starters[4]);
        cmoMon6.setSelectedIndex(starters[5]);
        cmoMon7.setSelectedIndex(starters[6]);
        cmoMon8.setSelectedIndex(starters[7]);
        cmoMon9.setSelectedIndex(starters[8]);
        cmoMon10.setSelectedIndex(starters[9]);
        cmoMon11.setSelectedIndex(starters[10]);
        cmoMon12.setSelectedIndex(starters[11]);
        cmoMon13.setSelectedIndex(starters[12]);
        cmoMon14.setSelectedIndex(starters[13]);
        cmoMon15.setSelectedIndex(starters[14]);
        cmoMon16.setSelectedIndex(starters[15]);
        cmoMon17.setSelectedIndex(starters[16]);
        cmoMon18.setSelectedIndex(starters[17]);
        cmoMon19.setSelectedIndex(starters[18]);
        cmoMon20.setSelectedIndex(starters[19]);
        cmoMon21.setSelectedIndex(starters[20]);
        cmoMon22.setSelectedIndex(starters[21]);
        cmoMon23.setSelectedIndex(starters[22]);
        cmoMon24.setSelectedIndex(starters[23]);
        cmoMon25.setSelectedIndex(starters[24]);
        cmoMon26.setSelectedIndex(starters[25]);
        
        cmoPartner1.setSelectedIndex(partners[0]);
        cmoPartner2.setSelectedIndex(partners[1]);
        cmoPartner3.setSelectedIndex(partners[2]);
        cmoPartner4.setSelectedIndex(partners[3]);
        cmoPartner5.setSelectedIndex(partners[4]);
        cmoPartner6.setSelectedIndex(partners[5]);
        cmoPartner7.setSelectedIndex(partners[6]);
        cmoPartner8.setSelectedIndex(partners[7]);
        cmoPartner9.setSelectedIndex(partners[8]);
        cmoPartner10.setSelectedIndex(partners[9]);
    }
    
    private void save() {
        starters[0] = cmoMon1.getSelectedIndex();
        starters[1] = cmoMon2.getSelectedIndex();
        starters[2] = cmoMon3.getSelectedIndex();
        starters[3] = cmoMon4.getSelectedIndex();
        starters[4] = cmoMon5.getSelectedIndex();
        starters[5] = cmoMon6.getSelectedIndex();
        starters[6] = cmoMon7.getSelectedIndex();
        starters[7] = cmoMon8.getSelectedIndex();
        starters[8] = cmoMon9.getSelectedIndex();
        starters[9] = cmoMon10.getSelectedIndex();
        starters[10] = cmoMon11.getSelectedIndex();
        starters[11] = cmoMon12.getSelectedIndex();
        starters[12] = cmoMon13.getSelectedIndex();
        starters[13] = cmoMon14.getSelectedIndex();
        starters[14] = cmoMon15.getSelectedIndex();
        starters[15] = cmoMon16.getSelectedIndex();
        starters[16] = cmoMon17.getSelectedIndex();
        starters[17] = cmoMon18.getSelectedIndex();
        starters[18] = cmoMon19.getSelectedIndex();
        starters[19] = cmoMon20.getSelectedIndex();
        starters[20] = cmoMon21.getSelectedIndex();
        starters[21] = cmoMon22.getSelectedIndex();
        starters[22] = cmoMon23.getSelectedIndex();
        starters[23] = cmoMon24.getSelectedIndex();
        starters[24] = cmoMon25.getSelectedIndex();
        starters[25] = cmoMon26.getSelectedIndex();
        
        partners[0] = cmoPartner1.getSelectedIndex();
        partners[1] = cmoPartner2.getSelectedIndex();
        partners[2] = cmoPartner3.getSelectedIndex();
        partners[3] = cmoPartner4.getSelectedIndex();
        partners[4] = cmoPartner5.getSelectedIndex();
        partners[5] = cmoPartner6.getSelectedIndex();
        partners[6] = cmoPartner7.getSelectedIndex();
        partners[7] = cmoPartner8.getSelectedIndex();
        partners[8] = cmoPartner9.getSelectedIndex();
        partners[9] = cmoPartner10.getSelectedIndex();
        
        RomFile.current.starters = starters;
        RomFile.current.partners = partners;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSave = new javax.swing.JButton();
        btnLoad = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblMale = new javax.swing.JLabel();
        lblFemale = new javax.swing.JLabel();
        lblCategory1 = new javax.swing.JLabel();
        lblCategory2 = new javax.swing.JLabel();
        lblCategory3 = new javax.swing.JLabel();
        lblCategory4 = new javax.swing.JLabel();
        lblCategory5 = new javax.swing.JLabel();
        lblCategory6 = new javax.swing.JLabel();
        lblCategory7 = new javax.swing.JLabel();
        lblCategory8 = new javax.swing.JLabel();
        lblCategory9 = new javax.swing.JLabel();
        lblCategory10 = new javax.swing.JLabel();
        lblCategory11 = new javax.swing.JLabel();
        lblCategory12 = new javax.swing.JLabel();
        lblCategory13 = new javax.swing.JLabel();
        cmoMon1 = new javax.swing.JComboBox<>();
        cmoMon2 = new javax.swing.JComboBox<>();
        cmoMon3 = new javax.swing.JComboBox<>();
        cmoMon4 = new javax.swing.JComboBox<>();
        cmoMon5 = new javax.swing.JComboBox<>();
        cmoMon6 = new javax.swing.JComboBox<>();
        cmoMon7 = new javax.swing.JComboBox<>();
        cmoMon8 = new javax.swing.JComboBox<>();
        cmoMon9 = new javax.swing.JComboBox<>();
        cmoMon10 = new javax.swing.JComboBox<>();
        cmoMon11 = new javax.swing.JComboBox<>();
        cmoMon12 = new javax.swing.JComboBox<>();
        cmoMon13 = new javax.swing.JComboBox<>();
        cmoMon14 = new javax.swing.JComboBox<>();
        cmoMon15 = new javax.swing.JComboBox<>();
        cmoMon16 = new javax.swing.JComboBox<>();
        cmoMon17 = new javax.swing.JComboBox<>();
        cmoMon18 = new javax.swing.JComboBox<>();
        cmoMon19 = new javax.swing.JComboBox<>();
        cmoMon20 = new javax.swing.JComboBox<>();
        cmoMon21 = new javax.swing.JComboBox<>();
        cmoMon22 = new javax.swing.JComboBox<>();
        cmoMon23 = new javax.swing.JComboBox<>();
        cmoMon24 = new javax.swing.JComboBox<>();
        cmoMon25 = new javax.swing.JComboBox<>();
        cmoMon26 = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        cmoPartner1 = new javax.swing.JComboBox<>();
        cmoPartner2 = new javax.swing.JComboBox<>();
        cmoPartner3 = new javax.swing.JComboBox<>();
        cmoPartner4 = new javax.swing.JComboBox<>();
        cmoPartner5 = new javax.swing.JComboBox<>();
        cmoPartner6 = new javax.swing.JComboBox<>();
        cmoPartner7 = new javax.swing.JComboBox<>();
        cmoPartner8 = new javax.swing.JComboBox<>();
        cmoPartner9 = new javax.swing.JComboBox<>();
        cmoPartner10 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Starters editor");
        setIconImage(com.aurum.mystery2.Main.icon);
        setResizable(false);

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnLoad.setText("Reload");
        btnLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Starters"));

        lblMale.setText("Male");

        lblFemale.setText("Female");

        lblCategory1.setText("Hardy");

        lblCategory2.setText("Docile");

        lblCategory3.setText("Brave");

        lblCategory4.setText("Jolly");

        lblCategory5.setText("Impish");

        lblCategory6.setText("Naive");

        lblCategory7.setText("Timid");

        lblCategory8.setText("Hasty");

        lblCategory9.setText("Sassy");

        lblCategory10.setText("Calm");

        lblCategory11.setText("Relaxed");

        lblCategory12.setText("Lonely");

        lblCategory13.setText("Quirky");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCategory1)
                            .addComponent(lblCategory2)
                            .addComponent(lblCategory3)
                            .addComponent(lblCategory4)
                            .addComponent(lblCategory5)
                            .addComponent(lblCategory6)
                            .addComponent(lblCategory7)
                            .addComponent(lblCategory8))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmoMon3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmoMon5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmoMon7, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmoMon9, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmoMon11, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmoMon13, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmoMon1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblMale)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmoMon15, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFemale)
                            .addComponent(cmoMon4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmoMon6, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmoMon8, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmoMon10, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmoMon12, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmoMon14, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmoMon16, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmoMon2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCategory9)
                            .addComponent(lblCategory10)
                            .addComponent(lblCategory11)
                            .addComponent(lblCategory12)
                            .addComponent(lblCategory13))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmoMon17, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmoMon19, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmoMon21, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmoMon23, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmoMon25, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmoMon18, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmoMon20, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmoMon22, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmoMon24, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmoMon26, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cmoMon1, cmoMon10, cmoMon11, cmoMon12, cmoMon13, cmoMon14, cmoMon15, cmoMon16, cmoMon17, cmoMon18, cmoMon19, cmoMon2, cmoMon20, cmoMon21, cmoMon22, cmoMon23, cmoMon24, cmoMon25, cmoMon26, cmoMon3, cmoMon4, cmoMon5, cmoMon6, cmoMon7, cmoMon8, cmoMon9});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMale, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblFemale, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmoMon1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmoMon2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCategory1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmoMon3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmoMon4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCategory2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmoMon5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmoMon6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCategory3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmoMon7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmoMon8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCategory4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmoMon9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmoMon10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCategory5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmoMon11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmoMon12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCategory6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmoMon13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmoMon14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCategory7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmoMon15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmoMon16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCategory8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmoMon17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmoMon18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCategory9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmoMon19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmoMon20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCategory10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmoMon21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmoMon22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCategory11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmoMon23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmoMon24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCategory12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmoMon25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmoMon26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCategory13))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cmoMon1, cmoMon10, cmoMon11, cmoMon12, cmoMon13, cmoMon14, cmoMon15, cmoMon16, cmoMon17, cmoMon18, cmoMon19, cmoMon2, cmoMon20, cmoMon21, cmoMon22, cmoMon23, cmoMon24, cmoMon25, cmoMon26, cmoMon3, cmoMon4, cmoMon5, cmoMon6, cmoMon7, cmoMon8, cmoMon9});

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Partners"));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(cmoPartner2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmoPartner3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmoPartner4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmoPartner5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmoPartner6, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmoPartner7, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmoPartner1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmoPartner8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cmoPartner9, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmoPartner10, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(cmoPartner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmoPartner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmoPartner3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmoPartner4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmoPartner5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmoPartner6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmoPartner7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmoPartner8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmoPartner9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmoPartner10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnLoad))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        save();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadActionPerformed
        load();
    }//GEN-LAST:event_btnLoadActionPerformed

    private int[] partners, starters;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLoad;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cmoMon1;
    private javax.swing.JComboBox<String> cmoMon10;
    private javax.swing.JComboBox<String> cmoMon11;
    private javax.swing.JComboBox<String> cmoMon12;
    private javax.swing.JComboBox<String> cmoMon13;
    private javax.swing.JComboBox<String> cmoMon14;
    private javax.swing.JComboBox<String> cmoMon15;
    private javax.swing.JComboBox<String> cmoMon16;
    private javax.swing.JComboBox<String> cmoMon17;
    private javax.swing.JComboBox<String> cmoMon18;
    private javax.swing.JComboBox<String> cmoMon19;
    private javax.swing.JComboBox<String> cmoMon2;
    private javax.swing.JComboBox<String> cmoMon20;
    private javax.swing.JComboBox<String> cmoMon21;
    private javax.swing.JComboBox<String> cmoMon22;
    private javax.swing.JComboBox<String> cmoMon23;
    private javax.swing.JComboBox<String> cmoMon24;
    private javax.swing.JComboBox<String> cmoMon25;
    private javax.swing.JComboBox<String> cmoMon26;
    private javax.swing.JComboBox<String> cmoMon3;
    private javax.swing.JComboBox<String> cmoMon4;
    private javax.swing.JComboBox<String> cmoMon5;
    private javax.swing.JComboBox<String> cmoMon6;
    private javax.swing.JComboBox<String> cmoMon7;
    private javax.swing.JComboBox<String> cmoMon8;
    private javax.swing.JComboBox<String> cmoMon9;
    private javax.swing.JComboBox<String> cmoPartner1;
    private javax.swing.JComboBox<String> cmoPartner10;
    private javax.swing.JComboBox<String> cmoPartner2;
    private javax.swing.JComboBox<String> cmoPartner3;
    private javax.swing.JComboBox<String> cmoPartner4;
    private javax.swing.JComboBox<String> cmoPartner5;
    private javax.swing.JComboBox<String> cmoPartner6;
    private javax.swing.JComboBox<String> cmoPartner7;
    private javax.swing.JComboBox<String> cmoPartner8;
    private javax.swing.JComboBox<String> cmoPartner9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblCategory1;
    private javax.swing.JLabel lblCategory10;
    private javax.swing.JLabel lblCategory11;
    private javax.swing.JLabel lblCategory12;
    private javax.swing.JLabel lblCategory13;
    private javax.swing.JLabel lblCategory2;
    private javax.swing.JLabel lblCategory3;
    private javax.swing.JLabel lblCategory4;
    private javax.swing.JLabel lblCategory5;
    private javax.swing.JLabel lblCategory6;
    private javax.swing.JLabel lblCategory7;
    private javax.swing.JLabel lblCategory8;
    private javax.swing.JLabel lblCategory9;
    private javax.swing.JLabel lblFemale;
    private javax.swing.JLabel lblMale;
    // End of variables declaration//GEN-END:variables
}