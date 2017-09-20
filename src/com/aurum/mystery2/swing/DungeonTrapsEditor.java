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

import com.aurum.mystery2.game.DungeonTraps;
import com.aurum.mystery2.game.RomFile;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JSpinner;

public class DungeonTrapsEditor extends AbstractEditor {
    private DungeonTraps selected;
    
    private JLabel lblTrip, lblMud, lblSticky, lblGrimy, lblSummon, lblPitfall, lblWarp, lblGust, lblSpin, lblSlumber;
    private JLabel lblSlow, lblSeal, lblPoison, lblSelfdestruct, lblExplosion, lblPPZero, lblChestnut, lblWonder, lblPokemon, lblSpiked;
    private JSpinner spnTrip, spnMud, spnSticky, spnGrimy, spnSummon, spnPitfall, spnWarp, spnGust, spnSpin, spnSlumber;
    private JSpinner spnSlow, spnSeal, spnPoison, spnSelfdestruct, spnExplosion, spnPPZero, spnChestnut, spnWonder, spnPokemon, spnSpiked;
    
    public DungeonTrapsEditor() {
        this(-1);
    }
    
    public DungeonTrapsEditor(int traps) {
        for (int i = 0 ; i < RomFile.current.dungeonTraps.size() ; i++)
            model.addElement("Traps no. " + i);
        
        list.setSelectedIndex(traps);
        list.ensureIndexIsVisible(traps);
    }
    
    @Override
    protected void initProperties() {
        setTitle("Dungeon traps editor");
        
        // Initialize the components
        lblTrip = new JLabel("Trip trap");
        lblTrip.setIcon(new ImageIcon(getClass().getResource("/res/traps/trip.png")));
        lblMud = new JLabel("Mud trap");
        lblMud.setIcon(new ImageIcon(getClass().getResource("/res/traps/mud.png")));
        lblSticky = new JLabel("Sticky trap");
        lblSticky.setIcon(new ImageIcon(getClass().getResource("/res/traps/sticky.png")));
        lblGrimy = new JLabel("Grimy trap");
        lblGrimy.setIcon(new ImageIcon(getClass().getResource("/res/traps/grimy.png")));
        lblSummon = new JLabel("Summon trap");
        lblSummon.setIcon(new ImageIcon(getClass().getResource("/res/traps/summon.png")));
        lblPitfall = new JLabel("Pitfall trap");
        lblPitfall.setIcon(new ImageIcon(getClass().getResource("/res/traps/pitfall.png")));
        lblWarp = new JLabel("Warp trap");
        lblWarp.setIcon(new ImageIcon(getClass().getResource("/res/traps/warp.png")));
        lblGust = new JLabel("Gust trap");
        lblGust.setIcon(new ImageIcon(getClass().getResource("/res/traps/gust.png")));
        lblSpin = new JLabel("Spin trap");
        lblSpin.setIcon(new ImageIcon(getClass().getResource("/res/traps/spin.png")));
        lblSlumber = new JLabel("Slumber trap");
        lblSlumber.setIcon(new ImageIcon(getClass().getResource("/res/traps/slumber.png")));
        lblSlow = new JLabel("Slow trap");
        lblSlow.setIcon(new ImageIcon(getClass().getResource("/res/traps/slow.png")));
        lblSeal = new JLabel("Seal trap");
        lblSeal.setIcon(new ImageIcon(getClass().getResource("/res/traps/seal.png")));
        lblPoison = new JLabel("Poison trap");
        lblPoison.setIcon(new ImageIcon(getClass().getResource("/res/traps/poison.png")));
        lblSelfdestruct = new JLabel("Selfdestruct trap");
        lblSelfdestruct.setIcon(new ImageIcon(getClass().getResource("/res/traps/selfdestruct.png")));
        lblExplosion = new JLabel("Explosion trap");
        lblExplosion.setIcon(new ImageIcon(getClass().getResource("/res/traps/explosion.png")));
        lblPPZero = new JLabel("PP-Zero trap");
        lblPPZero.setIcon(new ImageIcon(getClass().getResource("/res/traps/zero.png")));
        lblChestnut = new JLabel("Chestnut trap");
        lblChestnut.setIcon(new ImageIcon(getClass().getResource("/res/traps/chestnut.png")));
        lblWonder = new JLabel("Wonder trap");
        lblWonder.setIcon(new ImageIcon(getClass().getResource("/res/traps/wonder.png")));
        lblPokemon = new JLabel("Pokémon trap");
        lblPokemon.setIcon(new ImageIcon(getClass().getResource("/res/traps/pokemon.png")));
        lblSpiked = new JLabel("Spiked trap");
        lblSpiked.setIcon(new ImageIcon(getClass().getResource("/res/traps/spiked.png")));
        
        spnTrip = new JSpinner();
        spnTrip.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10000, 1));
        spnTrip.setEditor(new javax.swing.JSpinner.NumberEditor(spnTrip, "#,##0,00'%'"));
        spnTrip.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                selected.traps[0] = (int) ((JSpinner) evt.getSource()).getValue();
                warningLabel();
            }
        });
        spnMud = new JSpinner();
        spnMud.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10000, 1));
        spnMud.setEditor(new javax.swing.JSpinner.NumberEditor(spnMud, "#,##0,00'%'"));
        spnMud.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                selected.traps[1] = (int) ((JSpinner) evt.getSource()).getValue();
                warningLabel();
            }
        });
        spnSticky = new JSpinner();
        spnSticky.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10000, 1));
        spnSticky.setEditor(new javax.swing.JSpinner.NumberEditor(spnSticky, "#,##0,00'%'"));
        spnSticky.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                selected.traps[2] = (int) ((JSpinner) evt.getSource()).getValue();
                warningLabel();
            }
        });
        spnGrimy = new JSpinner();
        spnGrimy.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10000, 1));
        spnGrimy.setEditor(new javax.swing.JSpinner.NumberEditor(spnGrimy, "#,##0,00'%'"));
        spnGrimy.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                selected.traps[3] = (int) ((JSpinner) evt.getSource()).getValue();
                warningLabel();
            }
        });
        spnSummon = new JSpinner();
        spnSummon.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10000, 1));
        spnSummon.setEditor(new javax.swing.JSpinner.NumberEditor(spnSummon, "#,##0,00'%'"));
        spnSummon.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                selected.traps[4] = (int) ((JSpinner) evt.getSource()).getValue();
                warningLabel();
            }
        });
        spnPitfall = new JSpinner();
        spnPitfall.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10000, 1));
        spnPitfall.setEditor(new javax.swing.JSpinner.NumberEditor(spnPitfall, "#,##0,00'%'"));
        spnPitfall.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                selected.traps[5] = (int) ((JSpinner) evt.getSource()).getValue();
                warningLabel();
            }
        });
        spnWarp = new JSpinner();
        spnWarp.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10000, 1));
        spnWarp.setEditor(new javax.swing.JSpinner.NumberEditor(spnWarp, "#,##0,00'%'"));
        spnWarp.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                selected.traps[6] = (int) ((JSpinner) evt.getSource()).getValue();
                warningLabel();
            }
        });
        spnGust = new JSpinner();
        spnGust.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10000, 1));
        spnGust.setEditor(new javax.swing.JSpinner.NumberEditor(spnGust, "#,##0,00'%'"));
        spnGust.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                selected.traps[7] = (int) ((JSpinner) evt.getSource()).getValue();
                warningLabel();
            }
        });
        spnSpin = new JSpinner();
        spnSpin.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10000, 1));
        spnSpin.setEditor(new javax.swing.JSpinner.NumberEditor(spnSpin, "#,##0,00'%'"));
        spnSpin.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                selected.traps[8] = (int) ((JSpinner) evt.getSource()).getValue();
                warningLabel();
            }
        });
        spnSlumber = new JSpinner();
        spnSlumber.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10000, 1));
        spnSlumber.setEditor(new javax.swing.JSpinner.NumberEditor(spnSlumber, "#,##0,00'%'"));
        spnSlumber.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                selected.traps[9] = (int) ((JSpinner) evt.getSource()).getValue();
                warningLabel();
            }
        });
        spnSlow = new JSpinner();
        spnSlow.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10000, 1));
        spnSlow.setEditor(new javax.swing.JSpinner.NumberEditor(spnSlow, "#,##0,00'%'"));
        spnSlow.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                selected.traps[10] = (int) ((JSpinner) evt.getSource()).getValue();
                warningLabel();
            }
        });
        spnSeal = new JSpinner();
        spnSeal.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10000, 1));
        spnSeal.setEditor(new javax.swing.JSpinner.NumberEditor(spnSeal, "#,##0,00'%'"));
        spnSeal.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                selected.traps[11] = (int) ((JSpinner) evt.getSource()).getValue();
                warningLabel();
            }
        });
        spnPoison = new JSpinner();
        spnPoison.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10000, 1));
        spnPoison.setEditor(new javax.swing.JSpinner.NumberEditor(spnPoison, "#,##0,00'%'"));
        spnPoison.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                selected.traps[12] = (int) ((JSpinner) evt.getSource()).getValue();
                warningLabel();
            }
        });
        spnSelfdestruct = new JSpinner();
        spnSelfdestruct.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10000, 1));
        spnSelfdestruct.setEditor(new javax.swing.JSpinner.NumberEditor(spnSelfdestruct, "#,##0,00'%'"));
        spnSelfdestruct.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                selected.traps[13] = (int) ((JSpinner) evt.getSource()).getValue();
                warningLabel();
            }
        });
        spnExplosion = new JSpinner();
        spnExplosion.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10000, 1));
        spnExplosion.setEditor(new javax.swing.JSpinner.NumberEditor(spnExplosion, "#,##0,00'%'"));
        spnExplosion.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                selected.traps[14] = (int) ((JSpinner) evt.getSource()).getValue();
                warningLabel();
            }
        });
        spnPPZero = new JSpinner();
        spnPPZero.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10000, 1));
        spnPPZero.setEditor(new javax.swing.JSpinner.NumberEditor(spnPPZero, "#,##0,00'%'"));
        spnPPZero.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                selected.traps[15] = (int) ((JSpinner) evt.getSource()).getValue();
                warningLabel();
            }
        });
        spnChestnut = new JSpinner();
        spnChestnut.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10000, 1));
        spnChestnut.setEditor(new javax.swing.JSpinner.NumberEditor(spnChestnut, "#,##0,00'%'"));
        spnChestnut.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                selected.traps[16] = (int) ((JSpinner) evt.getSource()).getValue();
                warningLabel();
            }
        });
        spnWonder = new JSpinner();
        spnWonder.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10000, 1));
        spnWonder.setEditor(new javax.swing.JSpinner.NumberEditor(spnWonder, "#,##0,00'%'"));
        spnWonder.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                selected.traps[17] = (int) ((JSpinner) evt.getSource()).getValue();
                warningLabel();
            }
        });
        spnPokemon = new JSpinner();
        spnPokemon.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10000, 1));
        spnPokemon.setEditor(new javax.swing.JSpinner.NumberEditor(spnPokemon, "#,##0,00'%'"));
        spnPokemon.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                selected.traps[18] = (int) ((JSpinner) evt.getSource()).getValue();
                warningLabel();
            }
        });
        spnSpiked = new JSpinner();
        spnSpiked.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10000, 1));
        spnSpiked.setEditor(new javax.swing.JSpinner.NumberEditor(spnSpiked, "#,##0,00'%'"));
        spnSpiked.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                selected.traps[19] = (int) ((JSpinner) evt.getSource()).getValue();
                warningLabel();
            }
        });
        
        // Add the components to the property panel
        properties.addComponent(lblTrip, spnTrip);
        properties.addComponent(lblMud, spnMud);
        properties.addComponent(lblSticky, spnSticky);
        properties.addComponent(lblGrimy, spnGrimy);
        properties.addComponent(lblSummon, spnSummon);
        properties.addComponent(lblPitfall, spnPitfall);
        properties.addComponent(lblWarp, spnWarp);
        properties.addComponent(lblGust, spnGust);
        properties.addComponent(lblSpin, spnSpin);
        properties.addComponent(lblSlumber, spnSlumber);
        properties.addComponent(lblSlow, spnSlow);
        properties.addComponent(lblSeal, spnSeal);
        properties.addComponent(lblPoison, spnPoison);
        properties.addComponent(lblSelfdestruct, spnSelfdestruct);
        properties.addComponent(lblExplosion, spnExplosion);
        properties.addComponent(lblPPZero, spnPPZero);
        properties.addComponent(lblChestnut, spnChestnut);
        properties.addComponent(lblWonder, spnWonder);
        properties.addComponent(lblPokemon, spnPokemon);
        properties.addComponent(lblSpiked, spnSpiked);
        properties.addTerminator();
    }

    @Override
    protected void load() {
        if (list.getSelectedIndex() < 0)
            return;
        
        selected = (DungeonTraps) RomFile.current.dungeonTraps.get(list.getSelectedIndex()).clone();
        
        spnTrip.setValue(selected.traps[0]);
        spnMud.setValue(selected.traps[1]);
        spnSticky.setValue(selected.traps[2]);
        spnGrimy.setValue(selected.traps[3]);
        spnSummon.setValue(selected.traps[4]);
        spnPitfall.setValue(selected.traps[5]);
        spnWarp.setValue(selected.traps[6]);
        spnGust.setValue(selected.traps[7]);
        spnSpin.setValue(selected.traps[8]);
        spnSlumber.setValue(selected.traps[9]);
        spnSlow.setValue(selected.traps[10]);
        spnSeal.setValue(selected.traps[11]);
        spnPoison.setValue(selected.traps[12]);
        spnSelfdestruct.setValue(selected.traps[13]);
        spnExplosion.setValue(selected.traps[14]);
        spnPPZero.setValue(selected.traps[15]);
        spnChestnut.setValue(selected.traps[16]);
        spnWonder.setValue(selected.traps[17]);
        spnPokemon.setValue(selected.traps[18]);
        spnSpiked.setValue(selected.traps[19]);
        
        warningLabel();
    }

    @Override
    protected void save() {
        if (selected == null || list.getSelectedIndex() < 0)
            return;
        
        RomFile.current.dungeonTraps.set(list.getSelectedIndex(), selected);
    }
    
    @Override
    protected void warningLabel() {
        warningLabel.setText(selected.checkProbabilitySum() ? "Warning! Probability sum does not equal 10000." : "");
    }
}