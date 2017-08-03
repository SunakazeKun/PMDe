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

package com.aurum.mystery2;

import com.aurum.mystery2.swing.MoneyEditor;
import com.aurum.mystery2.swing.PokemonEditor;
import com.aurum.mystery2.swing.ItemEditor;
import com.aurum.mystery2.swing.StarterEditor;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.prefs.Preferences;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;
import com.aurum.mystery2.game.RomFile;
import com.aurum.mystery2.swing.CalcProbability;
import com.aurum.mystery2.swing.DungeonEditor;
import com.aurum.mystery2.swing.MapEditor;
import com.aurum.mystery2.swing.MoveEditor;

public class Main extends javax.swing.JFrame {
    public static String name = "PMDe v1 (Beta)";
    public static Image icon = Toolkit.getDefaultToolkit().createImage(Main.class.getResource("/res/icon.png"));
    
    public static void main(String[] args) throws IOException {
        try {
            javax.swing.UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            System.out.println(ex);
        }
        
        new Main().setVisible(true);
    }
    
    public Main() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlGameInfo = new javax.swing.JPanel();
        lblGameTitle = new javax.swing.JLabel();
        lblGameInternal = new javax.swing.JLabel();
        btnStarterEditor = new javax.swing.JButton();
        btnDungeonEditor = new javax.swing.JButton();
        btnPokemonEditor = new javax.swing.JButton();
        btnMapEditor = new javax.swing.JButton();
        btnMoneyEditor = new javax.swing.JButton();
        btnItemEditor = new javax.swing.JButton();
        btnMoveEditor = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuFile = new javax.swing.JMenu();
        mnuOpen = new javax.swing.JMenuItem();
        mnuSave = new javax.swing.JMenuItem();
        mnuSaveAs = new javax.swing.JMenuItem();
        sep1 = new javax.swing.JPopupMenu.Separator();
        mnuClose = new javax.swing.JMenuItem();
        mnuTools = new javax.swing.JMenu();
        mnuCalcRecruitment = new javax.swing.JMenuItem();
        mnuHelp = new javax.swing.JMenu();
        mnuAbout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(Main.name);
        setIconImage(Main.icon);
        setResizable(false);

        pnlGameInfo.setBackground(new java.awt.Color(255, 255, 255));
        pnlGameInfo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlGameInfo.setEnabled(false);

        lblGameTitle.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblGameTitle.setText("Unknown game");

        lblGameInternal.setText("Unknown");

        javax.swing.GroupLayout pnlGameInfoLayout = new javax.swing.GroupLayout(pnlGameInfo);
        pnlGameInfo.setLayout(pnlGameInfoLayout);
        pnlGameInfoLayout.setHorizontalGroup(
            pnlGameInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGameInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlGameInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblGameTitle)
                    .addComponent(lblGameInternal))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlGameInfoLayout.setVerticalGroup(
            pnlGameInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGameInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblGameTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblGameInternal)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnStarterEditor.setText("Edit starters & partners");
        btnStarterEditor.setEnabled(false);
        btnStarterEditor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStarterEditorActionPerformed(evt);
            }
        });

        btnDungeonEditor.setText("Edit dungeon data");
        btnDungeonEditor.setEnabled(false);
        btnDungeonEditor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDungeonEditorActionPerformed(evt);
            }
        });

        btnPokemonEditor.setText("Edit Pokémon data");
        btnPokemonEditor.setEnabled(false);
        btnPokemonEditor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPokemonEditorActionPerformed(evt);
            }
        });

        btnMapEditor.setText("Edit map coordinates");
        btnMapEditor.setEnabled(false);
        btnMapEditor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMapEditorActionPerformed(evt);
            }
        });

        btnMoneyEditor.setText("Edit POKé factors");
        btnMoneyEditor.setEnabled(false);
        btnMoneyEditor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoneyEditorActionPerformed(evt);
            }
        });

        btnItemEditor.setText("Edit items");
        btnItemEditor.setToolTipText("");
        btnItemEditor.setEnabled(false);
        btnItemEditor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnItemEditorActionPerformed(evt);
            }
        });

        btnMoveEditor.setText("Edit moves");
        btnMoveEditor.setEnabled(false);
        btnMoveEditor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoveEditorActionPerformed(evt);
            }
        });

        mnuFile.setMnemonic('F');
        mnuFile.setText("File");

        mnuOpen.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        mnuOpen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/open.png"))); // NOI18N
        mnuOpen.setMnemonic('O');
        mnuOpen.setText("Open");
        mnuOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuOpenActionPerformed(evt);
            }
        });
        mnuFile.add(mnuOpen);

        mnuSave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        mnuSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/save.png"))); // NOI18N
        mnuSave.setMnemonic('S');
        mnuSave.setText("Save");
        mnuSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSaveActionPerformed(evt);
            }
        });
        mnuFile.add(mnuSave);

        mnuSaveAs.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        mnuSaveAs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/save-as.png"))); // NOI18N
        mnuSaveAs.setMnemonic('A');
        mnuSaveAs.setText("Save as");
        mnuSaveAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSaveAsActionPerformed(evt);
            }
        });
        mnuFile.add(mnuSaveAs);
        mnuFile.add(sep1);

        mnuClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/cancel.png"))); // NOI18N
        mnuClose.setMnemonic('C');
        mnuClose.setText("Exit");
        mnuClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCloseActionPerformed(evt);
            }
        });
        mnuFile.add(mnuClose);

        jMenuBar1.add(mnuFile);

        mnuTools.setMnemonic('T');
        mnuTools.setText("Tools");

        mnuCalcRecruitment.setText("Recruitment calculator");
        mnuCalcRecruitment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCalcRecruitmentActionPerformed(evt);
            }
        });
        mnuTools.add(mnuCalcRecruitment);

        jMenuBar1.add(mnuTools);

        mnuHelp.setMnemonic('H');
        mnuHelp.setText("Help");

        mnuAbout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/info.png"))); // NOI18N
        mnuAbout.setMnemonic('A');
        mnuAbout.setText("About");
        mnuAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAboutActionPerformed(evt);
            }
        });
        mnuHelp.add(mnuAbout);

        jMenuBar1.add(mnuHelp);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlGameInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnDungeonEditor, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                            .addComponent(btnPokemonEditor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnMapEditor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnItemEditor, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnMoneyEditor, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnMoveEditor, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnStarterEditor, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlGameInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnDungeonEditor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMapEditor, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnItemEditor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPokemonEditor, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMoveEditor, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnStarterEditor, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMoneyEditor, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void mnuOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuOpenActionPerformed
        final JFileChooser fc = new JFileChooser() {{
            setDialogTitle("Open ROM file");
            setFileFilter(new FileNameExtensionFilter("GBA files (*.gba)", ".gba", "gba"));
            addChoosableFileFilter(new FileNameExtensionFilter("ROM files (*.rom)", ".rom", "rom"));
        }};
        
        String lastdir = Preferences.userRoot().get("mystery_lastDir", null);
        if (lastdir != null)
            fc.setSelectedFile(new File(lastdir));
        if (fc.showOpenDialog(this) != JFileChooser.APPROVE_OPTION)
            return;
        
        File file = fc.getSelectedFile();
        if (!(file.exists() && file.isFile()))
            return;
        
        Preferences.userRoot().put("mystery_lastDir", file.getPath());
        
        try {
            RomFile.current = new RomFile(file);
            RomFile.current.load();
            
            btnStarterEditor.setEnabled(RomFile.current.isLoaded());
            btnDungeonEditor.setEnabled(RomFile.current.isLoaded());
            btnPokemonEditor.setEnabled(RomFile.current.isLoaded());
            btnItemEditor.setEnabled(RomFile.current.isLoaded());
            btnMoveEditor.setEnabled(RomFile.current.isLoaded());
            btnMapEditor.setEnabled(RomFile.current.isLoaded());
            btnMoneyEditor.setEnabled(RomFile.current.isLoaded());
            
            lblGameTitle.setText(RomFile.current.getRomDescription());
            lblGameInternal.setText(RomFile.current.toString());
        }
        catch (IOException ex) { System.out.println(ex); }
    }//GEN-LAST:event_mnuOpenActionPerformed

    private void mnuSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSaveActionPerformed
        if (RomFile.current == null) return;
        if (!RomFile.current.isLoaded()) return;
        
        try {
            RomFile.current.save();
        }
        catch (IOException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_mnuSaveActionPerformed

    private void mnuSaveAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSaveAsActionPerformed
        if (RomFile.current == null) return;
        if (!RomFile.current.isLoaded()) return;
        
        final JFileChooser fc = new JFileChooser() {{
            setDialogTitle("Save ROM file");
            setFileFilter(new FileNameExtensionFilter("GBA files (*.gba)", ".gba", "gba"));
            addChoosableFileFilter(new FileNameExtensionFilter("ROM files (*.rom)", ".rom", "rom"));
        }};
        
        String lastdir = Preferences.userRoot().get("mystery_lastDir", null);
        if (lastdir != null)
            fc.setSelectedFile(new File(lastdir));
        if (fc.showSaveDialog(this) != JFileChooser.APPROVE_OPTION)
            return;
        String newdir = fc.getSelectedFile().getPath();
        Preferences.userRoot().put("mystery_lastDir", newdir);
        
        RomFile.current.setFile(new File(newdir));
        
        try {
            RomFile.current.save();
        }
        catch (IOException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_mnuSaveAsActionPerformed

    private void mnuCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCloseActionPerformed
        dispose();
    }//GEN-LAST:event_mnuCloseActionPerformed

    private void mnuAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAboutActionPerformed
        JOptionPane.showMessageDialog(this, "Copyright 2016 - 2017 SunakazeKun\nhttps://github.com/SunakazeKun/PMDe", Main.name, JOptionPane.PLAIN_MESSAGE, null);
    }//GEN-LAST:event_mnuAboutActionPerformed

    private void btnStarterEditorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStarterEditorActionPerformed
        if (RomFile.current.starters == null || RomFile.current.partners == null)
            RomFile.current.loadStarters();
        new StarterEditor().setVisible(true);
    }//GEN-LAST:event_btnStarterEditorActionPerformed

    private void btnDungeonEditorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDungeonEditorActionPerformed
        if (RomFile.current.dungeons == null)
            RomFile.current.loadDungeons();
        new DungeonEditor().setVisible(true);
    }//GEN-LAST:event_btnDungeonEditorActionPerformed

    private void btnPokemonEditorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPokemonEditorActionPerformed
        if (RomFile.current.pokemon == null)
            RomFile.current.loadPokemon();
        new PokemonEditor().setVisible(true);
    }//GEN-LAST:event_btnPokemonEditorActionPerformed

    private void btnMapEditorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMapEditorActionPerformed
        if (RomFile.current.dungeons == null)
            RomFile.current.loadDungeons();
        new MapEditor().setVisible(true);
    }//GEN-LAST:event_btnMapEditorActionPerformed

    private void btnMoneyEditorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoneyEditorActionPerformed
        if (RomFile.current.moneyfactors == null)
            RomFile.current.loadMoneyFactors();
        new MoneyEditor().setVisible(true);
    }//GEN-LAST:event_btnMoneyEditorActionPerformed

    private void btnItemEditorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnItemEditorActionPerformed
        if (RomFile.current.items == null)
            RomFile.current.loadItems();
        new ItemEditor().setVisible(true);
    }//GEN-LAST:event_btnItemEditorActionPerformed

    private void mnuCalcRecruitmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCalcRecruitmentActionPerformed
        new CalcProbability().setVisible(true);
    }//GEN-LAST:event_mnuCalcRecruitmentActionPerformed

    private void btnMoveEditorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoveEditorActionPerformed
        if (RomFile.current.moves == null)
            RomFile.current.loadMoves();
        new MoveEditor().setVisible(true);
    }//GEN-LAST:event_btnMoveEditorActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDungeonEditor;
    private javax.swing.JButton btnItemEditor;
    private javax.swing.JButton btnMapEditor;
    private javax.swing.JButton btnMoneyEditor;
    private javax.swing.JButton btnMoveEditor;
    private javax.swing.JButton btnPokemonEditor;
    private javax.swing.JButton btnStarterEditor;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel lblGameInternal;
    private javax.swing.JLabel lblGameTitle;
    private javax.swing.JMenuItem mnuAbout;
    private javax.swing.JMenuItem mnuCalcRecruitment;
    private javax.swing.JMenuItem mnuClose;
    private javax.swing.JMenu mnuFile;
    private javax.swing.JMenu mnuHelp;
    private javax.swing.JMenuItem mnuOpen;
    private javax.swing.JMenuItem mnuSave;
    private javax.swing.JMenuItem mnuSaveAs;
    private javax.swing.JMenu mnuTools;
    private javax.swing.JPanel pnlGameInfo;
    private javax.swing.JPopupMenu.Separator sep1;
    // End of variables declaration//GEN-END:variables
}