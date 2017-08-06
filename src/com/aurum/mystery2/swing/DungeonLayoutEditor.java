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
    }
    
    private void load() {
        selected = (DungeonLayout) RomFile.current.dungeonLayouts.get(listLayouts.getSelectedIndex()).clone();
        
        spnLayout1.setValue(selected.layout1);
        spnLayout2.setValue(selected.layout2);
        spnDensityTerrain.setValue(selected.terrainDensity);
        chkTerrainUnknown9.setSelected(selected.hasTerrainUnknown9);
        chkTerrainUnknownB.setSelected(selected.hasTerrainUnknownB);
        chkTerrainTile.setSelected(selected.hasTerrainTiles);
        chkTerrainPond.setSelected(selected.hasTerrainPond);
        chkTerrainUnknownE.setSelected(selected.hasTerrainUnknownE);
        
        spnTileset.setValue(selected.tileset);
        cmoMusic.setSelectedIndex(selected.music);
        cmoWeather.setSelectedIndex(selected.weather);
        cmoVisibility.setSelectedIndex(selected.visibility);
        cmoEvent.setSelectedIndex(selected.event);
        
        spnFloorNo.setValue(selected.no);
        spnDensityShops.setValue(selected.shopsFactor);
        spnDensityMonsters.setValue(selected.monstersFactor);
        spnMoney.setValue(selected.moneyFactor);
        spnPokemon.setValue(selected.pokemonDensity);
        spnItems.setValue(selected.itemDensity);
        spnTraps.setValue(selected.trapDensity);
        
        spnUnk5.setValue(selected.unk5);
        spnUnkA.setValue(selected.unkA);
        spnUnk18.setValue(selected.unk18);
    }
    
    private void save() {
        selected.layout1 = (int) spnLayout1.getValue();
        selected.layout2 = (int) spnLayout2.getValue();
        selected.terrainDensity = (short) spnDensityTerrain.getValue();
        selected.hasTerrainUnknown9 = chkTerrainUnknown9.isSelected();
        selected.hasTerrainUnknownB = chkTerrainUnknownB.isSelected();
        selected.hasTerrainTiles = chkTerrainTile.isSelected();
        selected.hasTerrainPond = chkTerrainPond.isSelected();
        selected.hasTerrainUnknownE = chkTerrainUnknownE.isSelected();
        
        selected.no = (short) spnFloorNo.getValue();
        selected.tileset = (short) spnTileset.getValue();
        selected.music = (short) cmoMusic.getSelectedIndex();
        selected.weather = (short) cmoWeather.getSelectedIndex();
        selected.visibility = (short) cmoVisibility.getSelectedIndex();
        selected.event = (short) cmoEvent.getSelectedIndex();
        
        selected.pokemonDensity = (short) spnPokemon.getValue();
        selected.itemDensity = (short) spnItems.getValue();
        selected.trapDensity = (short) spnTraps.getValue();
        selected.shopsFactor = (short) spnDensityShops.getValue();
        selected.monstersFactor = (short) spnDensityMonsters.getValue();
        selected.moneyFactor = (short) spnMoney.getValue();
        
        selected.unk5 = (byte) spnUnk5.getValue();
        selected.unkA = (byte) spnUnkA.getValue();
        selected.unk18 = (int) spnUnk18.getValue();
        
        RomFile.current.dungeonLayouts.set(listLayouts.getSelectedIndex(), selected);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTileset = new javax.swing.JPanel();
        lblTileset = new javax.swing.JLabel();
        spnTileset = new javax.swing.JSpinner();
        pnlGeneral = new javax.swing.JPanel();
        lblFloorNo = new javax.swing.JLabel();
        lblMusic = new javax.swing.JLabel();
        lblWeather = new javax.swing.JLabel();
        lblVisibility = new javax.swing.JLabel();
        lblEvent = new javax.swing.JLabel();
        spnFloorNo = new javax.swing.JSpinner();
        cmoMusic = new javax.swing.JComboBox<>();
        cmoWeather = new javax.swing.JComboBox<>();
        cmoVisibility = new javax.swing.JComboBox<>();
        cmoEvent = new javax.swing.JComboBox<>();
        pnlGenerator = new javax.swing.JPanel();
        lblLayout1 = new javax.swing.JLabel();
        lblLayout2 = new javax.swing.JLabel();
        lblDensityTerrain = new javax.swing.JLabel();
        spnLayout1 = new javax.swing.JSpinner();
        spnLayout2 = new javax.swing.JSpinner();
        spnDensityTerrain = new javax.swing.JSpinner();
        chkTerrainUnknown9 = new javax.swing.JCheckBox();
        chkTerrainUnknownB = new javax.swing.JCheckBox();
        chkTerrainTile = new javax.swing.JCheckBox();
        chkTerrainPond = new javax.swing.JCheckBox();
        chkTerrainUnknownE = new javax.swing.JCheckBox();
        pnlObject = new javax.swing.JPanel();
        lblPokemon = new javax.swing.JLabel();
        lblItems = new javax.swing.JLabel();
        lblTraps = new javax.swing.JLabel();
        lblDensityShops = new javax.swing.JLabel();
        lblDensityMonsters = new javax.swing.JLabel();
        lblMoney = new javax.swing.JLabel();
        spnPokemon = new javax.swing.JSpinner();
        spnItems = new javax.swing.JSpinner();
        spnTraps = new javax.swing.JSpinner();
        spnDensityShops = new javax.swing.JSpinner();
        spnDensityMonsters = new javax.swing.JSpinner();
        spnMoney = new javax.swing.JSpinner();
        pnlUnknown = new javax.swing.JPanel();
        lblUnk5 = new javax.swing.JLabel();
        lblUnkA = new javax.swing.JLabel();
        lblUnk18 = new javax.swing.JLabel();
        spnUnk5 = new javax.swing.JSpinner();
        spnUnkA = new javax.swing.JSpinner();
        spnUnk18 = new javax.swing.JSpinner();
        btnSave = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listLayouts = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Dungeon layout editor");
        setIconImage(com.aurum.mystery2.Main.icon);
        setResizable(false);

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

        pnlGeneral.setBorder(javax.swing.BorderFactory.createTitledBorder("General"));

        lblFloorNo.setText("No. for debugging");

        lblMusic.setText("Music");

        lblWeather.setText("Weather");

        lblVisibility.setText("Visibility");

        lblEvent.setText("Event");

        spnFloorNo.setModel(new javax.swing.SpinnerNumberModel(Byte.valueOf((byte)1), Byte.valueOf((byte)1), Byte.valueOf((byte)99), Byte.valueOf((byte)1)));

        cmoMusic.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00: No music", "01: Tiny Woods", "02: Thunderwave Cave", "03: Mt. Steel", "04: Sinister Woods", "05: Silent Chasm", "06: Mt. Thunder", "07: Great Canyon", "08: Lapis Cave", "09: Mt. Blaze", "0A: Frosty Forest", "0B: Mt. Freeze", "0C: Magma Cavern", "0D: Sky Tower", "0E: Tiny Woods", "0F: Tiny Woods", "10: Tiny Woods", "11: Tiny Woods", "12: Buried Relic", "13: Stormy Sea", "14: Sinister Woods", "15: Mt. Thunder Peak", "16: Mt. Blaze Peak", "17: Frosty Grotto", "18: Mt. Freeze Peak", "19: Magma Cavern Pit", "1A: Sky Tower Summit", "1B: Tiny Woods", "1C:Tiny Woods", "1D: Tiny Woods", "1E: Tiny Woods", "1F: Tiny Woods", "20: Tiny Woods", "21: Tiny Woods", "22: Tiny Woods", "23: Tiny Woods", "24: Tiny Woods", "25: Great Canyon", "26: Tiny Woods", "27: Tiny Woods", "28: Ambience", "29: Makuhita Dojo", "2A: Makuhita Dojo", "2B: Tiny Woods", "2C: Tiny Woods", "2D: Tiny Woods", "2E: Tiny Woods", "2F: Tiny Woods", "30: Tiny Woods", "31: Tiny Woods", "32: Tiny Woods", "33: Tiny Woods", "34: Tiny Woods", "35: Tiny Woods", "36: Tiny Woods", "37: Tiny Woods", "38: Tiny Woods", "39: Tiny Woods", "3A: Tiny Woods", "3B: Tiny Woods", "3C: Tiny Woods", "3D: Tiny Woods", "3E: Tiny Woods", "3F: Tiny Woods", "40: Tiny Woods", "41: Ambience", "42: Beach Ambience", "43: Mt. Thunder Peak Ambience", "44: Mt. Blaze Peak Ambience", "45: Frosty Grotto Ambience", "46: Tiny Woods", "47: Tiny Woods", "48: Tiny Woods", "49: Silver Trench Ambience", "4A: Stormy Sea Ambience" }));

        cmoWeather.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00: Clear", "01: Sunny", "02: Sandstorm", "03: Cloudy", "04: Rain", "05: Hail", "06: Fog", "07: Snow", "08: Random" }));

        cmoVisibility.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00: Normal", "01: 1 tile", "02: 2 tiles" }));

        cmoEvent.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00: Nothing", "01: Boss: Mt. Steel", "02: Boss: Sinister Forest", "03: Boss: Mt. Thunder", "04: Boss: Mt. Blaze", "05: Boss: Frost Grotto", "06: Boss: Mt. Freeze", "07: Boss: Magma Cavern", "08: Boss: Sky Tower", "09: Boss: Meteor Cave", "0A: Boss: Wish Cave", "0B: Boss: Uproar Forest", "0C: Boss: Fiery Field", "0D: Boss: Lightning Field", "0E: Boss: Northwind Field", "0F: Boss: Mt. Faraway", "10: Boss: Northern Range", "11: Boss: Buried Relic 1", "12: Boss: Buried Relic 2", "13: Boss: Buried Relic 3", "14: Special: Magma Cavern Pit", "15: Boss: Silver Trench", "16: Boss: Stormy Sea", "17: Boss: Meteor Cave", "18: Special: Howling Forest", "19: Special: Purity Forest", "1A: Special: Wish Cave", "1B: Boss: Normal Maze", "1C: Boss: Fire Maze", "1D: Boss: Water Maze", "1E: Boss: Grass Maze", "1F: Boss: Electric Maze", "20: Boss: Ice Maze", "21: Boss: Fighting Maze", "22: Boss: Ground Maze", "23: Boss: Flying Maze", "24: Boss: Psychic Maze", "25: Boss: Poison Maze", "26: Boss: Bug Maze", "27: Boss: Rock Maze", "28: Boss: Ghost Maze", "29: Boss: Dragon Maze", "2A: Boss: Dark Maze", "2B: Boss: Steel Maze", "2C: Boss: Team Shifty", "2D: Boss: Team Constrictor", "2E: Boss: Team Hydro", "2F: Boss: Team Rublerock", "30: Boss: Rescue Team 2", "31: Boss: Rescue Team Maze", "32: Item: HM Fly", "33: Item: HM Dive", "34: Item: HM Waterfall", "35: Item: HM Surf", "36: Item: TM Wide Slash", "37: Item: TM Vacuum-Cut", "38: Item: Friend Bow", "39: Item: Sun Ribbon", "3A: Item: Lunar Ribbon", "3B: Item: Beauty Scarf", "3C: Item: HM Cut", "3D: Item: HM Strength", "3E: Item: HM Flash", "3F: Item: HM Rock Smash", "40: Item: Deepseatooth", "41: Item: Wish Stone", "42: Item: Deepseascale" }));

        javax.swing.GroupLayout pnlGeneralLayout = new javax.swing.GroupLayout(pnlGeneral);
        pnlGeneral.setLayout(pnlGeneralLayout);
        pnlGeneralLayout.setHorizontalGroup(
            pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGeneralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlGeneralLayout.createSequentialGroup()
                        .addComponent(lblFloorNo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(spnFloorNo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlGeneralLayout.createSequentialGroup()
                        .addGroup(pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMusic)
                            .addComponent(lblWeather)
                            .addComponent(lblVisibility)
                            .addComponent(lblEvent))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmoEvent, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmoVisibility, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmoWeather, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmoMusic, 0, 200, Short.MAX_VALUE))))
                .addContainerGap())
        );
        pnlGeneralLayout.setVerticalGroup(
            pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlGeneralLayout.createSequentialGroup()
                .addGroup(pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFloorNo)
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
                    .addComponent(cmoVisibility, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblVisibility))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmoEvent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEvent))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlGenerator.setBorder(javax.swing.BorderFactory.createTitledBorder("Generator factors"));

        lblLayout1.setText("General");

        lblLayout2.setText("Crossings");

        lblDensityTerrain.setText("Terrain tile density");

        spnLayout1.setModel(new javax.swing.SpinnerNumberModel(0, 0, 8191, 1));
        spnLayout1.setEditor(new javax.swing.JSpinner.NumberEditor(spnLayout1, "0"));

        spnLayout2.setModel(new javax.swing.SpinnerNumberModel(0, 0, 2047, 1));
        spnLayout2.setEditor(new javax.swing.JSpinner.NumberEditor(spnLayout2, "0"));

        spnDensityTerrain.setModel(new javax.swing.SpinnerNumberModel(Short.valueOf((short)0), Short.valueOf((short)0), Short.valueOf((short)255), Short.valueOf((short)1)));

        chkTerrainUnknown9.setText("bool (0x9)");

        chkTerrainUnknownB.setText("bool (0xB)");

        chkTerrainTile.setText("Has terrain tiles");

        chkTerrainPond.setText("Has terrain pond");

        chkTerrainUnknownE.setText("bool (0xE)");

        javax.swing.GroupLayout pnlGeneratorLayout = new javax.swing.GroupLayout(pnlGenerator);
        pnlGenerator.setLayout(pnlGeneratorLayout);
        pnlGeneratorLayout.setHorizontalGroup(
            pnlGeneratorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGeneratorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlGeneratorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlGeneratorLayout.createSequentialGroup()
                        .addComponent(lblLayout1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(spnLayout1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlGeneratorLayout.createSequentialGroup()
                        .addComponent(lblLayout2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(spnLayout2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlGeneratorLayout.createSequentialGroup()
                        .addComponent(lblDensityTerrain)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                        .addComponent(spnDensityTerrain, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlGeneratorLayout.createSequentialGroup()
                        .addGroup(pnlGeneratorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkTerrainUnknownE)
                            .addComponent(chkTerrainPond)
                            .addComponent(chkTerrainTile)
                            .addComponent(chkTerrainUnknownB)
                            .addComponent(chkTerrainUnknown9))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlGeneratorLayout.setVerticalGroup(
            pnlGeneratorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGeneratorLayout.createSequentialGroup()
                .addGroup(pnlGeneratorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLayout1)
                    .addComponent(spnLayout1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlGeneratorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLayout2)
                    .addComponent(spnLayout2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlGeneratorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spnDensityTerrain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDensityTerrain))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkTerrainUnknown9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkTerrainUnknownB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkTerrainTile)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkTerrainPond)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkTerrainUnknownE))
        );

        pnlObject.setBorder(javax.swing.BorderFactory.createTitledBorder("Object factors"));

        lblPokemon.setText("Pokémon");

        lblItems.setText("Items");

        lblTraps.setText("Traps");

        lblDensityShops.setText("Kecleon Shops");

        lblDensityMonsters.setText("Monster Rooms");

        lblMoney.setText("Max. POKé factor");

        spnPokemon.setModel(new javax.swing.SpinnerNumberModel(Short.valueOf((short)0), Short.valueOf((short)0), Short.valueOf((short)255), Short.valueOf((short)1)));

        spnItems.setModel(new javax.swing.SpinnerNumberModel(Short.valueOf((short)0), Short.valueOf((short)0), Short.valueOf((short)255), Short.valueOf((short)1)));

        spnTraps.setModel(new javax.swing.SpinnerNumberModel(Short.valueOf((short)0), Short.valueOf((short)0), Short.valueOf((short)255), Short.valueOf((short)1)));

        spnDensityShops.setModel(new javax.swing.SpinnerNumberModel(Short.valueOf((short)0), Short.valueOf((short)0), Short.valueOf((short)255), Short.valueOf((short)1)));

        spnDensityMonsters.setModel(new javax.swing.SpinnerNumberModel(Short.valueOf((short)0), Short.valueOf((short)0), Short.valueOf((short)255), Short.valueOf((short)1)));

        spnMoney.setModel(new javax.swing.SpinnerNumberModel(Short.valueOf((short)0), Short.valueOf((short)0), Short.valueOf((short)255), Short.valueOf((short)1)));

        javax.swing.GroupLayout pnlObjectLayout = new javax.swing.GroupLayout(pnlObject);
        pnlObject.setLayout(pnlObjectLayout);
        pnlObjectLayout.setHorizontalGroup(
            pnlObjectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlObjectLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlObjectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPokemon)
                    .addComponent(lblItems)
                    .addComponent(lblTraps)
                    .addComponent(lblDensityShops)
                    .addComponent(lblDensityMonsters)
                    .addComponent(lblMoney))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlObjectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(spnMoney, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                    .addComponent(spnDensityShops, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                    .addComponent(spnTraps, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(spnItems, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(spnPokemon, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(spnDensityMonsters))
                .addContainerGap())
        );
        pnlObjectLayout.setVerticalGroup(
            pnlObjectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlObjectLayout.createSequentialGroup()
                .addGroup(pnlObjectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPokemon)
                    .addComponent(spnPokemon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlObjectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblItems)
                    .addComponent(spnItems, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlObjectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTraps)
                    .addComponent(spnTraps, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlObjectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDensityShops)
                    .addComponent(spnDensityShops, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlObjectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDensityMonsters)
                    .addComponent(spnDensityMonsters, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlObjectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMoney)
                    .addComponent(spnMoney, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pnlUnknown.setBorder(javax.swing.BorderFactory.createTitledBorder("Unknown"));

        lblUnk5.setText("byte (0x5)");

        lblUnkA.setText("byte (0xA)");

        lblUnk18.setText("int (0x18)");

        spnUnk5.setModel(new javax.swing.SpinnerNumberModel((byte)0, null, null, (byte)1));

        spnUnkA.setModel(new javax.swing.SpinnerNumberModel((byte)0, null, null, (byte)1));

        spnUnk18.setModel(new javax.swing.SpinnerNumberModel());

        javax.swing.GroupLayout pnlUnknownLayout = new javax.swing.GroupLayout(pnlUnknown);
        pnlUnknown.setLayout(pnlUnknownLayout);
        pnlUnknownLayout.setHorizontalGroup(
            pnlUnknownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUnknownLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlUnknownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlUnknownLayout.createSequentialGroup()
                        .addComponent(lblUnk5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                        .addComponent(spnUnk5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlUnknownLayout.createSequentialGroup()
                        .addGroup(pnlUnknownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUnkA)
                            .addComponent(lblUnk18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlUnknownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(spnUnk18, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                            .addComponent(spnUnkA))))
                .addContainerGap())
        );
        pnlUnknownLayout.setVerticalGroup(
            pnlUnknownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUnknownLayout.createSequentialGroup()
                .addGroup(pnlUnknownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUnk5)
                    .addComponent(spnUnk5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlUnknownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUnkA)
                    .addComponent(spnUnkA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlUnknownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUnk18)
                    .addComponent(spnUnk18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlTileset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlGenerator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pnlObject, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnlUnknown, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlObject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlUnknown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(pnlTileset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pnlGenerator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
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

    private void spnTilesetStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnTilesetStateChanged
        lblTileset.setIcon(new ImageIcon(getClass().getResource("/res/tilesets/" + spnTileset.getValue() + ".png")));
    }//GEN-LAST:event_spnTilesetStateChanged

    private void listLayoutsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listLayoutsValueChanged
        load();
    }//GEN-LAST:event_listLayoutsValueChanged
    
    private DefaultListModel model;
    private DungeonLayout selected;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JCheckBox chkTerrainPond;
    private javax.swing.JCheckBox chkTerrainTile;
    private javax.swing.JCheckBox chkTerrainUnknown9;
    private javax.swing.JCheckBox chkTerrainUnknownB;
    private javax.swing.JCheckBox chkTerrainUnknownE;
    private javax.swing.JComboBox<String> cmoEvent;
    private javax.swing.JComboBox<String> cmoMusic;
    private javax.swing.JComboBox<String> cmoVisibility;
    private javax.swing.JComboBox<String> cmoWeather;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDensityMonsters;
    private javax.swing.JLabel lblDensityShops;
    private javax.swing.JLabel lblDensityTerrain;
    private javax.swing.JLabel lblEvent;
    private javax.swing.JLabel lblFloorNo;
    private javax.swing.JLabel lblItems;
    private javax.swing.JLabel lblLayout1;
    private javax.swing.JLabel lblLayout2;
    private javax.swing.JLabel lblMoney;
    private javax.swing.JLabel lblMusic;
    private javax.swing.JLabel lblPokemon;
    private javax.swing.JLabel lblTileset;
    private javax.swing.JLabel lblTraps;
    private javax.swing.JLabel lblUnk18;
    private javax.swing.JLabel lblUnk5;
    private javax.swing.JLabel lblUnkA;
    private javax.swing.JLabel lblVisibility;
    private javax.swing.JLabel lblWeather;
    private javax.swing.JList<String> listLayouts;
    private javax.swing.JPanel pnlGeneral;
    private javax.swing.JPanel pnlGenerator;
    private javax.swing.JPanel pnlObject;
    private javax.swing.JPanel pnlTileset;
    private javax.swing.JPanel pnlUnknown;
    private javax.swing.JSpinner spnDensityMonsters;
    private javax.swing.JSpinner spnDensityShops;
    private javax.swing.JSpinner spnDensityTerrain;
    private javax.swing.JSpinner spnFloorNo;
    private javax.swing.JSpinner spnItems;
    private javax.swing.JSpinner spnLayout1;
    private javax.swing.JSpinner spnLayout2;
    private javax.swing.JSpinner spnMoney;
    private javax.swing.JSpinner spnPokemon;
    private javax.swing.JSpinner spnTileset;
    private javax.swing.JSpinner spnTraps;
    private javax.swing.JSpinner spnUnk18;
    private javax.swing.JSpinner spnUnk5;
    private javax.swing.JSpinner spnUnkA;
    // End of variables declaration//GEN-END:variables
}