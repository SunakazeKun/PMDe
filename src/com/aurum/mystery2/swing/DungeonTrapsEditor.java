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
import com.aurum.mystery2.Main;
import com.aurum.mystery2.game.RomFile;
import com.aurum.mystery2.game.DungeonTraps;

public class DungeonTrapsEditor extends javax.swing.JFrame {
    public DungeonTrapsEditor() {
        this(-1);
    }
    
    public DungeonTrapsEditor(int traps) {
        initComponents();
        for (int i = 0 ; i < RomFile.current.dungeonTraps.size() ; i++)
            model.addElement("Traps no. " + i);
        listTraps.setSelectedIndex(traps);
        listTraps.ensureIndexIsVisible(traps);
        load();
    }
    
    private boolean enabled() {
        boolean enable = listTraps.getSelectedIndex() >= 0;
        btnSave.setEnabled(enable);
        spnTrip.setEnabled(enable);
        spnMud.setEnabled(enable);
        spnSticky.setEnabled(enable);
        spnGrimy.setEnabled(enable);
        spnSummon.setEnabled(enable);
        spnPitfall.setEnabled(enable);
        spnWarp.setEnabled(enable);
        spnGust.setEnabled(enable);
        spnSpin.setEnabled(enable);
        spnSlumber.setEnabled(enable);
        spnSlow.setEnabled(enable);
        spnSeal.setEnabled(enable);
        spnPoison.setEnabled(enable);
        spnSelfdestruct.setEnabled(enable);
        spnExplosion.setEnabled(enable);
        spnPPZero.setEnabled(enable);
        spnChestnut.setEnabled(enable);
        spnWonder.setEnabled(enable);
        spnPokemon.setEnabled(enable);
        spnSpiked.setEnabled(enable);
        return enable;
    }
    
    private void warningLabel() {
        lblWarning.setText(selectedTraps.checkProbabilitySum() ? "Warning! Probability sum does not equal 10000." : "");
    }
    
    private void load() {
        selectedTraps = (DungeonTraps) RomFile.current.dungeonTraps.get(listTraps.getSelectedIndex()).clone();
        
        spnTrip.setValue(selectedTraps.traps[0]);
        spnMud.setValue(selectedTraps.traps[1]);
        spnSticky.setValue(selectedTraps.traps[2]);
        spnGrimy.setValue(selectedTraps.traps[3]);
        spnSummon.setValue(selectedTraps.traps[4]);
        spnPitfall.setValue(selectedTraps.traps[5]);
        spnWarp.setValue(selectedTraps.traps[6]);
        spnGust.setValue(selectedTraps.traps[7]);
        spnSpin.setValue(selectedTraps.traps[8]);
        spnSlumber.setValue(selectedTraps.traps[9]);
        spnSlow.setValue(selectedTraps.traps[10]);
        spnSeal.setValue(selectedTraps.traps[11]);
        spnPoison.setValue(selectedTraps.traps[12]);
        spnSelfdestruct.setValue(selectedTraps.traps[13]);
        spnExplosion.setValue(selectedTraps.traps[14]);
        spnPPZero.setValue(selectedTraps.traps[15]);
        spnChestnut.setValue(selectedTraps.traps[16]);
        spnWonder.setValue(selectedTraps.traps[17]);
        spnPokemon.setValue(selectedTraps.traps[18]);
        spnSpiked.setValue(selectedTraps.traps[19]);
        
        warningLabel();
    }
    
    private void save() {
        int index = listTraps.getSelectedIndex();
        if (selectedTraps == null || index < 0)
            return;
        
        RomFile.current.dungeonTraps.set(index, selectedTraps);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl1 = new javax.swing.JPanel();
        lblTrip = new javax.swing.JLabel();
        lblMud = new javax.swing.JLabel();
        lblSticky = new javax.swing.JLabel();
        lblGrimy = new javax.swing.JLabel();
        lblSummon = new javax.swing.JLabel();
        lblPitfall = new javax.swing.JLabel();
        lblWarp = new javax.swing.JLabel();
        lblGust = new javax.swing.JLabel();
        lblSpin = new javax.swing.JLabel();
        lblSlumber = new javax.swing.JLabel();
        spnTrip = new javax.swing.JSpinner();
        spnMud = new javax.swing.JSpinner();
        spnSticky = new javax.swing.JSpinner();
        spnGrimy = new javax.swing.JSpinner();
        spnSummon = new javax.swing.JSpinner();
        spnPitfall = new javax.swing.JSpinner();
        spnWarp = new javax.swing.JSpinner();
        spnGust = new javax.swing.JSpinner();
        spnSpin = new javax.swing.JSpinner();
        spnSlumber = new javax.swing.JSpinner();
        pnl2 = new javax.swing.JPanel();
        lblSlow = new javax.swing.JLabel();
        lblSeal = new javax.swing.JLabel();
        lblPoison = new javax.swing.JLabel();
        lblSelfdestruct = new javax.swing.JLabel();
        lblExplosion = new javax.swing.JLabel();
        lblPPZero = new javax.swing.JLabel();
        lblChestnut = new javax.swing.JLabel();
        lblWonder = new javax.swing.JLabel();
        lblPokémon = new javax.swing.JLabel();
        lblSpiked = new javax.swing.JLabel();
        spnSlow = new javax.swing.JSpinner();
        spnSeal = new javax.swing.JSpinner();
        spnPoison = new javax.swing.JSpinner();
        spnSelfdestruct = new javax.swing.JSpinner();
        spnExplosion = new javax.swing.JSpinner();
        spnPPZero = new javax.swing.JSpinner();
        spnChestnut = new javax.swing.JSpinner();
        spnWonder = new javax.swing.JSpinner();
        spnPokemon = new javax.swing.JSpinner();
        spnSpiked = new javax.swing.JSpinner();
        btnSave = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listTraps = new javax.swing.JList<>();
        lblWarning = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Dungeon traps editor");
        setIconImage(com.aurum.mystery2.Main.icon);
        setResizable(false);

        lblTrip.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/traps/trip.png"))); // NOI18N
        lblTrip.setText("Trip trap");

        lblMud.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/traps/mud.png"))); // NOI18N
        lblMud.setText("Mud trap");

        lblSticky.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/traps/sticky.png"))); // NOI18N
        lblSticky.setText("Sticky trap");

        lblGrimy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/traps/grimy.png"))); // NOI18N
        lblGrimy.setText("Grimy trap");

        lblSummon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/traps/summon.png"))); // NOI18N
        lblSummon.setText("Summon trip");

        lblPitfall.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/traps/pitfall.png"))); // NOI18N
        lblPitfall.setText("Pitfall trap");

        lblWarp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/traps/warp.png"))); // NOI18N
        lblWarp.setText("Warp trap");

        lblGust.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/traps/gust.png"))); // NOI18N
        lblGust.setText("Gust trap");

        lblSpin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/traps/spin.png"))); // NOI18N
        lblSpin.setText("Spin trap");

        lblSlumber.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/traps/slumber.png"))); // NOI18N
        lblSlumber.setText("Slumber trap");

        spnTrip.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10000, 1));
        spnTrip.setEditor(new javax.swing.JSpinner.NumberEditor(spnTrip, "#,##0,00'%'"));
        spnTrip.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnTripStateChanged(evt);
            }
        });

        spnMud.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10000, 1));
        spnMud.setEditor(new javax.swing.JSpinner.NumberEditor(spnMud, "#,##0,00'%'"));
        spnMud.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnMudStateChanged(evt);
            }
        });

        spnSticky.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10000, 1));
        spnSticky.setEditor(new javax.swing.JSpinner.NumberEditor(spnSticky, "#,##0,00'%'"));
        spnSticky.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnStickyStateChanged(evt);
            }
        });

        spnGrimy.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10000, 1));
        spnGrimy.setEditor(new javax.swing.JSpinner.NumberEditor(spnGrimy, "#,##0,00'%'"));
        spnGrimy.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnGrimyStateChanged(evt);
            }
        });

        spnSummon.setModel(new javax.swing.SpinnerNumberModel());
        spnSummon.setEditor(new javax.swing.JSpinner.NumberEditor(spnSummon, "#,##0,00'%'"));
        spnSummon.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnSummonStateChanged(evt);
            }
        });

        spnPitfall.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10000, 1));
        spnPitfall.setEditor(new javax.swing.JSpinner.NumberEditor(spnPitfall, "#,##0,00'%'"));
        spnPitfall.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnPitfallStateChanged(evt);
            }
        });

        spnWarp.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10000, 1));
        spnWarp.setEditor(new javax.swing.JSpinner.NumberEditor(spnWarp, "#,##0,00'%'"));
        spnWarp.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnWarpStateChanged(evt);
            }
        });

        spnGust.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10000, 1));
        spnGust.setEditor(new javax.swing.JSpinner.NumberEditor(spnGust, "#,##0,00'%'"));
        spnGust.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnGustStateChanged(evt);
            }
        });

        spnSpin.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10000, 1));
        spnSpin.setEditor(new javax.swing.JSpinner.NumberEditor(spnSpin, "#,##0,00'%'"));
        spnSpin.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnSpinStateChanged(evt);
            }
        });

        spnSlumber.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10000, 1));
        spnSlumber.setEditor(new javax.swing.JSpinner.NumberEditor(spnSlumber, "#,##0,00'%'"));
        spnSlumber.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnSlumberStateChanged(evt);
            }
        });

        javax.swing.GroupLayout pnl1Layout = new javax.swing.GroupLayout(pnl1);
        pnl1.setLayout(pnl1Layout);
        pnl1Layout.setHorizontalGroup(
            pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTrip)
                    .addComponent(lblMud)
                    .addComponent(lblGrimy)
                    .addComponent(lblSticky)
                    .addComponent(lblSummon)
                    .addComponent(lblPitfall)
                    .addComponent(lblWarp)
                    .addComponent(lblGust)
                    .addComponent(lblSpin)
                    .addComponent(lblSlumber))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(spnSlumber, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                    .addComponent(spnSpin)
                    .addComponent(spnGust)
                    .addComponent(spnWarp)
                    .addComponent(spnPitfall)
                    .addComponent(spnSummon)
                    .addComponent(spnSticky)
                    .addComponent(spnGrimy)
                    .addComponent(spnMud)
                    .addComponent(spnTrip, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnl1Layout.setVerticalGroup(
            pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl1Layout.createSequentialGroup()
                .addGroup(pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTrip)
                    .addComponent(spnTrip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMud)
                    .addComponent(spnMud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSticky)
                    .addComponent(spnSticky, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGrimy)
                    .addComponent(spnGrimy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSummon)
                    .addComponent(spnSummon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPitfall)
                    .addComponent(spnPitfall, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblWarp)
                    .addComponent(spnWarp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGust)
                    .addComponent(spnGust, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSpin)
                    .addComponent(spnSpin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSlumber)
                    .addComponent(spnSlumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        lblSlow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/traps/slow.png"))); // NOI18N
        lblSlow.setText("Slow trap");

        lblSeal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/traps/seal.png"))); // NOI18N
        lblSeal.setText("Seal trap");

        lblPoison.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/traps/poison.png"))); // NOI18N
        lblPoison.setText("Poison trap");

        lblSelfdestruct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/traps/selfdestruct.png"))); // NOI18N
        lblSelfdestruct.setText("Selfdestruct trap");

        lblExplosion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/traps/explosion.png"))); // NOI18N
        lblExplosion.setText("Explosion trap");

        lblPPZero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/traps/zero.png"))); // NOI18N
        lblPPZero.setText("PP-Zero trap");

        lblChestnut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/traps/chestnut.png"))); // NOI18N
        lblChestnut.setText("Chestnut trap");

        lblWonder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/traps/wonder.png"))); // NOI18N
        lblWonder.setText("Wonder tile");

        lblPokémon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/traps/pokemon.png"))); // NOI18N
        lblPokémon.setText("Pokémon trap");

        lblSpiked.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/traps/spiked.png"))); // NOI18N
        lblSpiked.setText("Spiked tile");

        spnSlow.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10000, 1));
        spnSlow.setEditor(new javax.swing.JSpinner.NumberEditor(spnSlow, "#,##0,00'%'"));
        spnSlow.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnSlowStateChanged(evt);
            }
        });

        spnSeal.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10000, 1));
        spnSeal.setEditor(new javax.swing.JSpinner.NumberEditor(spnSeal, "#,##0,00'%'"));
        spnSeal.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnSealStateChanged(evt);
            }
        });

        spnPoison.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10000, 1));
        spnPoison.setEditor(new javax.swing.JSpinner.NumberEditor(spnPoison, "#,##0,00'%'"));
        spnPoison.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnPoisonStateChanged(evt);
            }
        });

        spnSelfdestruct.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10000, 1));
        spnSelfdestruct.setEditor(new javax.swing.JSpinner.NumberEditor(spnSelfdestruct, "#,##0,00'%'"));
        spnSelfdestruct.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnSelfdestructStateChanged(evt);
            }
        });

        spnExplosion.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10000, 1));
        spnExplosion.setEditor(new javax.swing.JSpinner.NumberEditor(spnExplosion, "#,##0,00'%'"));
        spnExplosion.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnExplosionStateChanged(evt);
            }
        });

        spnPPZero.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10000, 1));
        spnPPZero.setEditor(new javax.swing.JSpinner.NumberEditor(spnPPZero, "#,##0,00'%'"));
        spnPPZero.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnPPZeroStateChanged(evt);
            }
        });

        spnChestnut.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10000, 1));
        spnChestnut.setEditor(new javax.swing.JSpinner.NumberEditor(spnChestnut, "#,##0,00'%'"));
        spnChestnut.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnChestnutStateChanged(evt);
            }
        });

        spnWonder.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10000, 1));
        spnWonder.setEditor(new javax.swing.JSpinner.NumberEditor(spnWonder, "#,##0,00'%'"));
        spnWonder.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnWonderStateChanged(evt);
            }
        });

        spnPokemon.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10000, 1));
        spnPokemon.setEditor(new javax.swing.JSpinner.NumberEditor(spnPokemon, "#,##0,00'%'"));
        spnPokemon.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnPokemonStateChanged(evt);
            }
        });

        spnSpiked.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10000, 1));
        spnSpiked.setEditor(new javax.swing.JSpinner.NumberEditor(spnSpiked, "#,##0,00'%'"));
        spnSpiked.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnSpikedStateChanged(evt);
            }
        });

        javax.swing.GroupLayout pnl2Layout = new javax.swing.GroupLayout(pnl2);
        pnl2.setLayout(pnl2Layout);
        pnl2Layout.setHorizontalGroup(
            pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl2Layout.createSequentialGroup()
                        .addComponent(lblSlow)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(spnSlow, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl2Layout.createSequentialGroup()
                        .addComponent(lblSeal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(spnSeal, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl2Layout.createSequentialGroup()
                        .addComponent(lblPoison)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(spnPoison, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl2Layout.createSequentialGroup()
                        .addComponent(lblSelfdestruct)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                        .addComponent(spnSelfdestruct, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl2Layout.createSequentialGroup()
                        .addComponent(lblExplosion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(spnExplosion, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl2Layout.createSequentialGroup()
                        .addComponent(lblPPZero)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(spnPPZero, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl2Layout.createSequentialGroup()
                        .addComponent(lblChestnut)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(spnChestnut, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl2Layout.createSequentialGroup()
                        .addComponent(lblWonder)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(spnWonder, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl2Layout.createSequentialGroup()
                        .addGroup(pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPokémon)
                            .addComponent(lblSpiked))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(spnSpiked, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                            .addComponent(spnPokemon))))
                .addContainerGap())
        );
        pnl2Layout.setVerticalGroup(
            pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl2Layout.createSequentialGroup()
                .addGroup(pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSlow)
                    .addComponent(spnSlow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSeal)
                    .addComponent(spnSeal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPoison)
                    .addComponent(spnPoison, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSelfdestruct)
                    .addComponent(spnSelfdestruct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblExplosion)
                    .addComponent(spnExplosion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPPZero)
                    .addComponent(spnPPZero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblChestnut)
                    .addComponent(spnChestnut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblWonder)
                    .addComponent(spnWonder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPokémon)
                    .addComponent(spnPokemon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSpiked)
                    .addComponent(spnSpiked, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        listTraps.setModel(model = new DefaultListModel());
        listTraps.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listTraps.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listTrapsValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listTraps);

        lblWarning.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(pnl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pnl2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblWarning)))
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pnl2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblWarning))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSave)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        save();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void listTrapsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listTrapsValueChanged
        if (!enabled())
            return;
        
        load();
    }//GEN-LAST:event_listTrapsValueChanged

    private void spnTripStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnTripStateChanged
        if (!enabled())
            return;
        
        selectedTraps.traps[0] = (int) spnTrip.getValue();
        warningLabel();
    }//GEN-LAST:event_spnTripStateChanged

    private void spnMudStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnMudStateChanged
        if (!enabled())
            return;
        
        selectedTraps.traps[1] = (int) spnMud.getValue();
        warningLabel();
    }//GEN-LAST:event_spnMudStateChanged

    private void spnStickyStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnStickyStateChanged
        if (!enabled())
            return;
        
        selectedTraps.traps[2] = (int) spnSticky.getValue();
        warningLabel();
    }//GEN-LAST:event_spnStickyStateChanged

    private void spnGrimyStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnGrimyStateChanged
        if (!enabled())
            return;
        
        selectedTraps.traps[3] = (int) spnGrimy.getValue();
        warningLabel();
    }//GEN-LAST:event_spnGrimyStateChanged

    private void spnSummonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnSummonStateChanged
        if (!enabled())
            return;
        
        selectedTraps.traps[4] = (int) spnSummon.getValue();
        warningLabel();
    }//GEN-LAST:event_spnSummonStateChanged

    private void spnPitfallStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnPitfallStateChanged
        if (!enabled())
            return;
        
        selectedTraps.traps[5] = (int) spnPitfall.getValue();
        warningLabel();
    }//GEN-LAST:event_spnPitfallStateChanged

    private void spnWarpStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnWarpStateChanged
        if (!enabled())
            return;
        
        selectedTraps.traps[6] = (int) spnWarp.getValue();
        warningLabel();
    }//GEN-LAST:event_spnWarpStateChanged

    private void spnGustStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnGustStateChanged
        if (!enabled())
            return;
        
        selectedTraps.traps[7] = (int) spnGust.getValue();
        warningLabel();
    }//GEN-LAST:event_spnGustStateChanged

    private void spnSpinStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnSpinStateChanged
        if (!enabled())
            return;
        
        selectedTraps.traps[8] = (int) spnSpin.getValue();
        warningLabel();
    }//GEN-LAST:event_spnSpinStateChanged

    private void spnSlumberStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnSlumberStateChanged
        if (!enabled())
            return;
        
        selectedTraps.traps[9] = (int) spnSlumber.getValue();
        warningLabel();
    }//GEN-LAST:event_spnSlumberStateChanged

    private void spnSlowStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnSlowStateChanged
        if (!enabled())
            return;
        
        selectedTraps.traps[10] = (int) spnSlow.getValue();
        warningLabel();
    }//GEN-LAST:event_spnSlowStateChanged

    private void spnSealStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnSealStateChanged
        if (!enabled())
            return;
        
        selectedTraps.traps[11] = (int) spnSeal.getValue();
        warningLabel();
    }//GEN-LAST:event_spnSealStateChanged

    private void spnPoisonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnPoisonStateChanged
        if (!enabled())
            return;
        
        selectedTraps.traps[12] = (int) spnPoison.getValue();
        warningLabel();
    }//GEN-LAST:event_spnPoisonStateChanged

    private void spnSelfdestructStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnSelfdestructStateChanged
        if (!enabled())
            return;
        
        selectedTraps.traps[13] = (int) spnSelfdestruct.getValue();
        warningLabel();
    }//GEN-LAST:event_spnSelfdestructStateChanged

    private void spnExplosionStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnExplosionStateChanged
        if (!enabled())
            return;
        
        selectedTraps.traps[14] = (int) spnExplosion.getValue();
        warningLabel();
    }//GEN-LAST:event_spnExplosionStateChanged

    private void spnPPZeroStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnPPZeroStateChanged
        if (!enabled())
            return;
        
        selectedTraps.traps[15] = (int) spnPPZero.getValue();
        warningLabel();
    }//GEN-LAST:event_spnPPZeroStateChanged

    private void spnChestnutStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnChestnutStateChanged
        if (!enabled())
            return;
        
        selectedTraps.traps[16] = (int) spnChestnut.getValue();
        warningLabel();
    }//GEN-LAST:event_spnChestnutStateChanged

    private void spnWonderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnWonderStateChanged
        if (!enabled())
            return;
        
        selectedTraps.traps[17] = (int) spnWonder.getValue();
        warningLabel();
    }//GEN-LAST:event_spnWonderStateChanged

    private void spnPokemonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnPokemonStateChanged
        if (!enabled())
            return;
        
        selectedTraps.traps[18] = (int) spnPokemon.getValue();
        warningLabel();
    }//GEN-LAST:event_spnPokemonStateChanged

    private void spnSpikedStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnSpikedStateChanged
        selectedTraps.traps[19] = (int) spnSpiked.getValue();
        warningLabel();
    }//GEN-LAST:event_spnSpikedStateChanged
    
    private DefaultListModel model;
    private DungeonTraps selectedTraps;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblChestnut;
    private javax.swing.JLabel lblExplosion;
    private javax.swing.JLabel lblGrimy;
    private javax.swing.JLabel lblGust;
    private javax.swing.JLabel lblMud;
    private javax.swing.JLabel lblPPZero;
    private javax.swing.JLabel lblPitfall;
    private javax.swing.JLabel lblPoison;
    private javax.swing.JLabel lblPokémon;
    private javax.swing.JLabel lblSeal;
    private javax.swing.JLabel lblSelfdestruct;
    private javax.swing.JLabel lblSlow;
    private javax.swing.JLabel lblSlumber;
    private javax.swing.JLabel lblSpiked;
    private javax.swing.JLabel lblSpin;
    private javax.swing.JLabel lblSticky;
    private javax.swing.JLabel lblSummon;
    private javax.swing.JLabel lblTrip;
    private javax.swing.JLabel lblWarning;
    private javax.swing.JLabel lblWarp;
    private javax.swing.JLabel lblWonder;
    private javax.swing.JList<String> listTraps;
    private javax.swing.JPanel pnl1;
    private javax.swing.JPanel pnl2;
    private javax.swing.JSpinner spnChestnut;
    private javax.swing.JSpinner spnExplosion;
    private javax.swing.JSpinner spnGrimy;
    private javax.swing.JSpinner spnGust;
    private javax.swing.JSpinner spnMud;
    private javax.swing.JSpinner spnPPZero;
    private javax.swing.JSpinner spnPitfall;
    private javax.swing.JSpinner spnPoison;
    private javax.swing.JSpinner spnPokemon;
    private javax.swing.JSpinner spnSeal;
    private javax.swing.JSpinner spnSelfdestruct;
    private javax.swing.JSpinner spnSlow;
    private javax.swing.JSpinner spnSlumber;
    private javax.swing.JSpinner spnSpiked;
    private javax.swing.JSpinner spnSpin;
    private javax.swing.JSpinner spnSticky;
    private javax.swing.JSpinner spnSummon;
    private javax.swing.JSpinner spnTrip;
    private javax.swing.JSpinner spnWarp;
    private javax.swing.JSpinner spnWonder;
    // End of variables declaration//GEN-END:variables
}