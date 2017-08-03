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
import javax.swing.ImageIcon;
import com.aurum.mystery2.Main;
import com.aurum.mystery2.game.RomFile;
import com.aurum.mystery2.game.DungeonLayout;

public class DungeonLayoutEditor extends javax.swing.JFrame {
    public DungeonLayoutEditor() {
        this(0);
    }
    
    public DungeonLayoutEditor(int floor) {
        initComponents();
        for (int i = 0 ; i < RomFile.current.dungeonLayouts.size() ; i++)
            model.addElement("Layout no. " + i);
        listLayouts.setSelectedIndex(floor);
        listLayouts.ensureIndexIsVisible(floor);
        load();
    }
    
    private void load() {
        selectedLayout = (DungeonLayout) RomFile.current.dungeonLayouts.get(listLayouts.getSelectedIndex()).clone();
        
        spnLayout1.setValue(selectedLayout.layout1);
        spnLayout2.setValue(selectedLayout.layout2);
        spnKecleonShops.setValue(selectedLayout.kecleonShopsFactor);
        spnMonsterRooms.setValue(selectedLayout.monsterRoomsFactor);
        spnTerrainTileDensity.setValue(selectedLayout.terrainDensity);
        chkTerrainTile.setSelected(selectedLayout.useTerrainTiles);
        
        spnTileset.setValue(selectedLayout.tileset);
        cmoMusic.setSelectedIndex(selectedLayout.music);
        cmoWeather.setSelectedIndex(selectedLayout.weather);
        spnEvent.setValue(selectedLayout.event);
        
        spnFloorNo.setValue(selectedLayout.no);
        spnVisibility.setValue(selectedLayout.visibility);
        spnMoney.setValue(selectedLayout.money);
        spnPokemon.setValue(selectedLayout.pokemonDensity);
        spnItems.setValue(selectedLayout.itemDensity);
        spnTraps.setValue(selectedLayout.trapDensity);
        
        loadUnknownBytes();
    }
    
    private void loadUnknownBytes() {
        switch(cmoUnknownOffset.getSelectedIndex()) {
            case 0: txtUnknownValue.setText(String.valueOf(selectedLayout.unk5)); break;
            case 1: txtUnknownValue.setText(String.valueOf(selectedLayout.unk9[0])); break;
            case 2: txtUnknownValue.setText(String.valueOf(selectedLayout.unk9[1])); break;
            case 3: txtUnknownValue.setText(String.valueOf(selectedLayout.unk9[2])); break;
            case 4: txtUnknownValue.setText(String.valueOf(selectedLayout.unk9[3])); break;
            case 5: txtUnknownValue.setText(String.valueOf(selectedLayout.unkE)); break;
            case 6: txtUnknownValue.setText(String.valueOf(selectedLayout.unk18[0])); break;
            case 7: txtUnknownValue.setText(String.valueOf(selectedLayout.unk18[1])); break;
            case 8: txtUnknownValue.setText(String.valueOf(selectedLayout.unk18[2])); break;
            case 9: txtUnknownValue.setText(String.valueOf(selectedLayout.unk18[3])); break;
        }
    }
    
    private void save() {
        selectedLayout.layout1 = (int) spnLayout1.getValue();
        selectedLayout.layout2 = (int) spnLayout2.getValue();
        selectedLayout.kecleonShopsFactor = (short) spnKecleonShops.getValue();
        selectedLayout.monsterRoomsFactor = (short) spnMonsterRooms.getValue();
        selectedLayout.terrainDensity = (short) spnTerrainTileDensity.getValue();
        selectedLayout.useTerrainTiles = chkTerrainTile.isSelected();
        
        selectedLayout.tileset = (short) spnTileset.getValue();
        selectedLayout.music = (short) cmoMusic.getSelectedIndex();
        selectedLayout.weather = (short) cmoWeather.getSelectedIndex();
        selectedLayout.event = (short) spnEvent.getValue();
        
        selectedLayout.no = (short) spnFloorNo.getValue();
        selectedLayout.visibility = (short) spnVisibility.getValue();
        selectedLayout.money = (short) spnMoney.getValue();
        selectedLayout.pokemonDensity = (short) spnPokemon.getValue();
        selectedLayout.itemDensity = (short) spnItems.getValue();
        selectedLayout.trapDensity = (short) spnTraps.getValue();
        
        RomFile.current.dungeonLayouts.set(listLayouts.getSelectedIndex(), selectedLayout);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlGeneral = new javax.swing.JPanel();
        lblNo = new javax.swing.JLabel();
        lblMusic = new javax.swing.JLabel();
        lblWeather = new javax.swing.JLabel();
        lblVisibility = new javax.swing.JLabel();
        lblEvent = new javax.swing.JLabel();
        lblMoney = new javax.swing.JLabel();
        cmoMusic = new javax.swing.JComboBox<>();
        cmoWeather = new javax.swing.JComboBox<>();
        spnVisibility = new javax.swing.JSpinner();
        spnFloorNo = new javax.swing.JSpinner();
        spnEvent = new javax.swing.JSpinner();
        spnMoney = new javax.swing.JSpinner();
        pnlDensity = new javax.swing.JPanel();
        lblPokemon = new javax.swing.JLabel();
        lblItems = new javax.swing.JLabel();
        lblTraps = new javax.swing.JLabel();
        spnPokemon = new javax.swing.JSpinner();
        spnItems = new javax.swing.JSpinner();
        spnTraps = new javax.swing.JSpinner();
        pnlLayout = new javax.swing.JPanel();
        lblLayout1 = new javax.swing.JLabel();
        lblLayout2 = new javax.swing.JLabel();
        lblKecleonShops = new javax.swing.JLabel();
        lblMonsterRooms = new javax.swing.JLabel();
        lblTerrainTileDensity = new javax.swing.JLabel();
        chkTerrainTile = new javax.swing.JCheckBox();
        spnLayout1 = new javax.swing.JSpinner();
        spnLayout2 = new javax.swing.JSpinner();
        spnKecleonShops = new javax.swing.JSpinner();
        spnMonsterRooms = new javax.swing.JSpinner();
        spnTerrainTileDensity = new javax.swing.JSpinner();
        pnlUnknown = new javax.swing.JPanel();
        lblOffset = new javax.swing.JLabel();
        lblValue = new javax.swing.JLabel();
        cmoUnknownOffset = new javax.swing.JComboBox<>();
        txtUnknownValue = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        pnlTileset = new javax.swing.JPanel();
        lblTileset = new javax.swing.JLabel();
        spnTileset = new javax.swing.JSpinner();
        jScrollPane1 = new javax.swing.JScrollPane();
        listLayouts = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Dungeon layout editor");
        setIconImage(com.aurum.mystery2.Main.icon);
        setResizable(false);

        pnlGeneral.setBorder(javax.swing.BorderFactory.createTitledBorder("General"));

        lblNo.setText("No.");

        lblMusic.setText("Music");

        lblWeather.setText("Weather");

        lblVisibility.setText("Visibility");

        lblEvent.setText("Event");

        lblMoney.setText("Max. POKé factor");

        cmoMusic.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00: No music", "01: Tiny Woods", "02: Thunderwave Cave", "03: Mt. Steel", "04: Sinister Woods", "05: Silent Chasm", "06: Mt. Thunder", "07: Great Canyon", "08: Lapis Cave", "09: Mt. Blaze", "0A: Frosty Forest", "0B: Mt. Freeze", "0C: Magma Cavern", "0D: Sky Tower", "0E: Tiny Woods", "0F: Tiny Woods", "10: Tiny Woods", "11: Tiny Woods", "12: Buried Relic", "13: Stormy Sea", "14: Sinister Woods", "15: Mt. Thunder Peak", "16: Mt. Blaze Peak", "17: Frosty Grotto", "18: Mt. Freeze Peak", "19: Magma Cavern Pit", "1A: Sky Tower Summit", "1B: Tiny Woods", "1C:Tiny Woods", "1D: Tiny Woods", "1E: Tiny Woods", "1F: Tiny Woods", "20: Tiny Woods", "21: Tiny Woods", "22: Tiny Woods", "23: Tiny Woods", "24: Tiny Woods", "25: Great Canyon", "26: Tiny Woods", "27: Tiny Woods", "28: Ambience", "29: Makuhita Dojo", "2A: Makuhita Dojo", "2B: Tiny Woods", "2C: Tiny Woods", "2D: Tiny Woods", "2E: Tiny Woods", "2F: Tiny Woods", "30: Tiny Woods", "31: Tiny Woods", "32: Tiny Woods", "33: Tiny Woods", "34: Tiny Woods", "35: Tiny Woods", "36: Tiny Woods", "37: Tiny Woods", "38: Tiny Woods", "39: Tiny Woods", "3A: Tiny Woods", "3B: Tiny Woods", "3C: Tiny Woods", "3D: Tiny Woods", "3E: Tiny Woods", "3F: Tiny Woods", "40: Tiny Woods", "41: Ambience", "42: Beach Ambience", "43: Mt. Thunder Peak Ambience", "44: Mt. Blaze Peak Ambience", "45: Frosty Grotto Ambience", "46: Tiny Woods", "47: Tiny Woods", "48: Tiny Woods", "49: Tiny Woods", "4A: Stormy Sea Boss" }));

        cmoWeather.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00: Clear", "01: Sunny", "02: Sandstorm", "03: Cloudy", "04: Rain", "05: Hail", "06: Fog", "07: Snow", "08: Random" }));

        spnVisibility.setModel(new javax.swing.SpinnerNumberModel(Short.valueOf((short)0), Short.valueOf((short)0), Short.valueOf((short)255), Short.valueOf((short)1)));

        spnFloorNo.setModel(new javax.swing.SpinnerNumberModel(Byte.valueOf((byte)1), Byte.valueOf((byte)1), Byte.valueOf((byte)99), Byte.valueOf((byte)1)));

        spnEvent.setModel(new javax.swing.SpinnerNumberModel(Short.valueOf((short)0), Short.valueOf((short)0), Short.valueOf((short)255), Short.valueOf((short)1)));

        spnMoney.setModel(new javax.swing.SpinnerNumberModel(Short.valueOf((short)0), Short.valueOf((short)0), Short.valueOf((short)255), Short.valueOf((short)1)));

        javax.swing.GroupLayout pnlGeneralLayout = new javax.swing.GroupLayout(pnlGeneral);
        pnlGeneral.setLayout(pnlGeneralLayout);
        pnlGeneralLayout.setHorizontalGroup(
            pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGeneralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlGeneralLayout.createSequentialGroup()
                        .addComponent(lblNo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(spnFloorNo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlGeneralLayout.createSequentialGroup()
                        .addGroup(pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMoney)
                            .addComponent(lblEvent)
                            .addComponent(lblVisibility))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(spnVisibility, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                            .addComponent(spnEvent)
                            .addComponent(spnMoney)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlGeneralLayout.createSequentialGroup()
                        .addGroup(pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMusic)
                            .addComponent(lblWeather))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                        .addGroup(pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmoMusic, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmoWeather, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        pnlGeneralLayout.setVerticalGroup(
            pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlGeneralLayout.createSequentialGroup()
                .addGroup(pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNo)
                    .addComponent(spnFloorNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmoMusic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMusic))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmoWeather, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblWeather))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spnVisibility, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblVisibility))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spnEvent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEvent))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spnMoney, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMoney))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlDensity.setBorder(javax.swing.BorderFactory.createTitledBorder("Density"));

        lblPokemon.setText("Pokémon");

        lblItems.setText("Items");

        lblTraps.setText("Traps");

        spnPokemon.setModel(new javax.swing.SpinnerNumberModel(Short.valueOf((short)0), Short.valueOf((short)0), Short.valueOf((short)255), Short.valueOf((short)1)));

        spnItems.setModel(new javax.swing.SpinnerNumberModel(Short.valueOf((short)0), Short.valueOf((short)0), Short.valueOf((short)255), Short.valueOf((short)1)));

        spnTraps.setModel(new javax.swing.SpinnerNumberModel(Short.valueOf((short)0), Short.valueOf((short)0), Short.valueOf((short)255), Short.valueOf((short)1)));

        javax.swing.GroupLayout pnlDensityLayout = new javax.swing.GroupLayout(pnlDensity);
        pnlDensity.setLayout(pnlDensityLayout);
        pnlDensityLayout.setHorizontalGroup(
            pnlDensityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDensityLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDensityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPokemon)
                    .addComponent(lblItems)
                    .addComponent(lblTraps))
                .addGap(37, 37, 37)
                .addGroup(pnlDensityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spnPokemon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                    .addComponent(spnItems)
                    .addComponent(spnTraps))
                .addContainerGap())
        );
        pnlDensityLayout.setVerticalGroup(
            pnlDensityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDensityLayout.createSequentialGroup()
                .addGroup(pnlDensityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPokemon)
                    .addComponent(spnPokemon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDensityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblItems)
                    .addComponent(spnItems, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDensityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTraps)
                    .addComponent(spnTraps, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pnlLayout.setBorder(javax.swing.BorderFactory.createTitledBorder("Generator factors"));

        lblLayout1.setText("General");

        lblLayout2.setText("Crossings");

        lblKecleonShops.setText("Kecleon Shops");

        lblMonsterRooms.setText("Monster Rooms");

        lblTerrainTileDensity.setText("Terrain tile density");

        chkTerrainTile.setText("Use terrain tiles");

        spnLayout1.setModel(new javax.swing.SpinnerNumberModel(0, 0, 65535, 1));
        spnLayout1.setEditor(new javax.swing.JSpinner.NumberEditor(spnLayout1, "0"));

        spnLayout2.setModel(new javax.swing.SpinnerNumberModel(0, 0, 65535, 1));
        spnLayout2.setEditor(new javax.swing.JSpinner.NumberEditor(spnLayout2, "0"));

        spnKecleonShops.setModel(new javax.swing.SpinnerNumberModel(Short.valueOf((short)0), Short.valueOf((short)0), Short.valueOf((short)255), Short.valueOf((short)1)));

        spnMonsterRooms.setModel(new javax.swing.SpinnerNumberModel(Short.valueOf((short)0), Short.valueOf((short)0), Short.valueOf((short)255), Short.valueOf((short)1)));

        spnTerrainTileDensity.setModel(new javax.swing.SpinnerNumberModel(Short.valueOf((short)0), Short.valueOf((short)0), Short.valueOf((short)255), Short.valueOf((short)1)));

        javax.swing.GroupLayout pnlLayoutLayout = new javax.swing.GroupLayout(pnlLayout);
        pnlLayout.setLayout(pnlLayoutLayout);
        pnlLayoutLayout.setHorizontalGroup(
            pnlLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLayoutLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlLayoutLayout.createSequentialGroup()
                        .addComponent(lblLayout1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(spnLayout1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlLayoutLayout.createSequentialGroup()
                        .addComponent(lblLayout2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(spnLayout2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlLayoutLayout.createSequentialGroup()
                        .addComponent(lblKecleonShops)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(spnKecleonShops, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlLayoutLayout.createSequentialGroup()
                        .addComponent(lblMonsterRooms)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(spnMonsterRooms, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlLayoutLayout.createSequentialGroup()
                        .addComponent(chkTerrainTile)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlLayoutLayout.createSequentialGroup()
                        .addComponent(lblTerrainTileDensity)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addComponent(spnTerrainTileDensity, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlLayoutLayout.setVerticalGroup(
            pnlLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLayoutLayout.createSequentialGroup()
                .addGroup(pnlLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLayout1)
                    .addComponent(spnLayout1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLayout2)
                    .addComponent(spnLayout2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblKecleonShops)
                    .addComponent(spnKecleonShops, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMonsterRooms)
                    .addComponent(spnMonsterRooms, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTerrainTileDensity)
                    .addComponent(spnTerrainTileDensity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chkTerrainTile))
        );

        pnlUnknown.setBorder(javax.swing.BorderFactory.createTitledBorder("Unknown"));

        lblOffset.setText("Offset");

        lblValue.setText("Value");

        cmoUnknownOffset.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0x5", "0x9", "0xA", "0xB", "0xC", "0xE", "0x18", "0x19", "0x1A", "0x1B" }));
        cmoUnknownOffset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmoUnknownOffsetActionPerformed(evt);
            }
        });

        txtUnknownValue.setEditable(false);
        txtUnknownValue.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        javax.swing.GroupLayout pnlUnknownLayout = new javax.swing.GroupLayout(pnlUnknown);
        pnlUnknown.setLayout(pnlUnknownLayout);
        pnlUnknownLayout.setHorizontalGroup(
            pnlUnknownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUnknownLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlUnknownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblOffset)
                    .addComponent(lblValue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlUnknownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmoUnknownOffset, 0, 85, Short.MAX_VALUE)
                    .addComponent(txtUnknownValue))
                .addContainerGap())
        );
        pnlUnknownLayout.setVerticalGroup(
            pnlUnknownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUnknownLayout.createSequentialGroup()
                .addGroup(pnlUnknownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOffset)
                    .addComponent(cmoUnknownOffset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlUnknownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblValue)
                    .addComponent(txtUnknownValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        pnlTileset.setBorder(javax.swing.BorderFactory.createTitledBorder("Tileset"));

        lblTileset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/tilesets/0.png"))); // NOI18N

        spnTileset.setModel(new javax.swing.SpinnerNumberModel(Short.valueOf((short)0), Short.valueOf((short)0), Short.valueOf((short)75), Short.valueOf((short)1)));
        spnTileset.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnTilesetStateChanged(evt);
            }
        });

        javax.swing.GroupLayout pnlTilesetLayout = new javax.swing.GroupLayout(pnlTileset);
        pnlTileset.setLayout(pnlTilesetLayout);
        pnlTilesetLayout.setHorizontalGroup(
            pnlTilesetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTilesetLayout.createSequentialGroup()
                .addComponent(lblTileset)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(spnTileset)
        );
        pnlTilesetLayout.setVerticalGroup(
            pnlTilesetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTilesetLayout.createSequentialGroup()
                .addComponent(lblTileset)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spnTileset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        listLayouts.setModel(model = new DefaultListModel());
        listLayouts.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listLayouts.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listLayoutsValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listLayouts);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlLayout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pnlUnknown, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnlDensity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlTileset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlTileset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnlGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pnlLayout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(pnlDensity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pnlUnknown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void cmoUnknownOffsetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmoUnknownOffsetActionPerformed
        loadUnknownBytes();
    }//GEN-LAST:event_cmoUnknownOffsetActionPerformed

    private void spnTilesetStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnTilesetStateChanged
        lblTileset.setIcon(new ImageIcon(getClass().getResource("/res/tilesets/" + spnTileset.getValue() + ".png")));
    }//GEN-LAST:event_spnTilesetStateChanged

    private void listLayoutsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listLayoutsValueChanged
        load();
    }//GEN-LAST:event_listLayoutsValueChanged
    
    private DefaultListModel model;
    private DungeonLayout selectedLayout;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JCheckBox chkTerrainTile;
    private javax.swing.JComboBox<String> cmoMusic;
    private javax.swing.JComboBox<String> cmoUnknownOffset;
    private javax.swing.JComboBox<String> cmoWeather;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblEvent;
    private javax.swing.JLabel lblItems;
    private javax.swing.JLabel lblKecleonShops;
    private javax.swing.JLabel lblLayout1;
    private javax.swing.JLabel lblLayout2;
    private javax.swing.JLabel lblMoney;
    private javax.swing.JLabel lblMonsterRooms;
    private javax.swing.JLabel lblMusic;
    private javax.swing.JLabel lblNo;
    private javax.swing.JLabel lblOffset;
    private javax.swing.JLabel lblPokemon;
    private javax.swing.JLabel lblTerrainTileDensity;
    private javax.swing.JLabel lblTileset;
    private javax.swing.JLabel lblTraps;
    private javax.swing.JLabel lblValue;
    private javax.swing.JLabel lblVisibility;
    private javax.swing.JLabel lblWeather;
    private javax.swing.JList<String> listLayouts;
    private javax.swing.JPanel pnlDensity;
    private javax.swing.JPanel pnlGeneral;
    private javax.swing.JPanel pnlLayout;
    private javax.swing.JPanel pnlTileset;
    private javax.swing.JPanel pnlUnknown;
    private javax.swing.JSpinner spnEvent;
    private javax.swing.JSpinner spnFloorNo;
    private javax.swing.JSpinner spnItems;
    private javax.swing.JSpinner spnKecleonShops;
    private javax.swing.JSpinner spnLayout1;
    private javax.swing.JSpinner spnLayout2;
    private javax.swing.JSpinner spnMoney;
    private javax.swing.JSpinner spnMonsterRooms;
    private javax.swing.JSpinner spnPokemon;
    private javax.swing.JSpinner spnTerrainTileDensity;
    private javax.swing.JSpinner spnTileset;
    private javax.swing.JSpinner spnTraps;
    private javax.swing.JSpinner spnVisibility;
    private javax.swing.JTextField txtUnknownValue;
    // End of variables declaration//GEN-END:variables
}