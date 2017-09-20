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

import com.aurum.mystery2.game.DungeonLayout;
import com.aurum.mystery2.game.RomFile;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

public class DungeonLayoutEditor extends AbstractEditor {
    private DungeonLayout selected;
    
    private JLabel lblLayoutNo, lblMusic, lblWeather, lblVisibility, lblEvent;
    private JSpinner spnLayoutNo;
    private JComboBox cmoMusic, cmoWeather, cmoVisibility, cmoEvent;
    
    private JLabel lblPreview, lblSecretPower, lblNaturalPower, lblCamouflage, lblTileset;
    private JTextField txtSecretPower, txtNaturalPower, txtCamouflage;
    private JSpinner spnTileset;
    
    private JLabel lblLayout1, lblLayout2, lblTerrain;
    private JSpinner spnLayout1, spnLayout2, spnTiles;
    private JCheckBox chkTerrainPond, chkTerrainTile, chkUnk9, chkUnkB, chkUnkE;
    
    private JLabel lblPokemon, lblItems, lblTraps, lblMoney, lblDensityMonsters, lblDensityShops;
    private JSpinner spnPokemon, spnItems, spnTraps, spnMoney, spnDensityMonsters, spnDensityShops;
    
    private JLabel lblUnk5, lblUnkA, lblUnk18;
    private JSpinner spnUnk5, spnUnkA, spnUnk18;
    
    private static final List<String> tilesetProperties = new ArrayList() {{
        add("Attack down,Surf,Water");
        add("Poison,Stun Spore,Grass");
        add("Confusion,Rock Slide,Rock");
        add("Cringing,Shadow Ball,Rock");
        add("Cringing,Shadow Ball,Rock");
        add("Confusion,Rock Slide,Rock");
        add("Confusion,Rock Slide,Rock");
        add("Cringing,Shadow Ball,Rock");
        add("Paralysis,Swift,Normal");
        add("Confusion,Rock Slide,Rock");
        add("Poison,Stun Spore,Grass");
        add("Accuracy down,Earthquake,Ground");
        add("Paralysis,Swift,Normal");
        add("Paralysis,Swift,Normal");
        add("Poison,Stun Spore,Grass");
        add("Paralysis,Swift,Ice");
        add("Paralysis,Swift,Normal");
        add("Cringing,Shadow Ball,Rock");
        add("Cringing,Shadow Ball,Ice");
        add("Cringing,Shadow Ball,Ice");
        add("null,null,null");
        add("Accuracy down,Earthquake,Ground");
        add("null,null,null");
        add("Paralysis,Swift,Normal");
        add("Confusion,Rock Slide,Ice");
        add("Poison,Stun Spore,Grass");
        add("Poison,Stun Spore,Grass");
        add("Paralysis,Swift,Normal");
        add("Confusion,Rock Slide,Rock");
        add("Sleep,Razor Leaf,Grass");
        add("Cringing,Shadow Ball,Rock");
        add("Cringing,Shadow Ball,Rock");
        add("Sleep,Razor Leaf,Grass");
        add("Sleep,Razor Leaf,Grass");
        add("Confusion,Rock Slide,Rock");
        add("Paralysis,Swift,Normal");
        add("Paralysis,Swift,Ice");
        add("Cringing,Shadow Ball,Rock");
        add("Confusion,Rock Slide,Rock");
        add("Confusion,Rock Slide,Rock");
        add("Confusion,Rock Slide,Rock");
        add("Poison,Stun Spore,Grass");
        add("Confusion,Rock Slide,Rock");
        add("Confusion,Rock Slide,Rock");
        add("Accuracy down,Earthquake,Ground");
        add("Paralysis,Swift,Normal");
        add("Confusion,Rock Slide,Rock");
        add("Confusion,Rock Slide,Ice");
        add("Confusion,Rock Slide,Rock");
        add("Attack down,Surf,Water");
        add("Poison,Stun Spore,Grass");
        add("Poison,Stun Spore,Grass");
        add("Accuracy down,Earthquake,Ground");
        add("Movement Speed down,Bubblebeam,Water");
        add("Cringing,Shadow Ball,Rock");
        add("Confusion,Rock Slide,Rock");
        add("Poison,Stun Spore,Grass");
        add("Paralysis,Swift,Normal");
        add("Paralysis,Swift,Normal");
        add("Confusion,Rock Slide,Rock");
        add("Poison,Stun Spore,Grass");
        add("Cringing,Shadow Ball,Rock");
        add("Poison,Stun Spore,Grass");
        add("Poison,Stun Spore,Grass");
        add("Confusion,Rock Slide,Rock");
        add("Sleep,Razor Leaf,Grass");
        add("Confusion,Rock Slide,Rock");
        add("Confusion,Rock Slide,Rock");
        add("Paralysis,Swift,Normal");
        add("Paralysis,Swift,Normal");
        add("Confusion,Rock Slide,Rock");
        add("Paralysis,Swift,Normal");
        add("Paralysis,Swift,Ice");
        add("Attack down,Surf,Water");
        add("Attack down,Surf,Water");
        add("Confusion,Rock Slide,Rock");
    }};
    
    public DungeonLayoutEditor() {
        this(-1);
    }
    
    public DungeonLayoutEditor(int layout) {
        for (int i = 0 ; i < RomFile.current.dungeonLayouts.size() ; i++)
            model.addElement("Layout no. " + i);
        
        list.setSelectedIndex(layout);
        list.ensureIndexIsVisible(layout);
    }
    
    @Override
    protected void initProperties() {
        setTitle("Dungeon layout editor");
        
        // Initialize the components
        lblLayoutNo = new JLabel("Layout No.");
        lblMusic = new JLabel("Music");
        lblWeather = new JLabel("Weather");
        lblVisibility = new JLabel("Visibility");
        lblEvent = new JLabel("Event");
        spnLayoutNo = new JSpinner();
        spnLayoutNo.setModel(new SpinnerNumberModel(Short.valueOf((short)1), Short.valueOf((short)1), Short.valueOf((short)99), Short.valueOf((short)1)));
        cmoMusic = new JComboBox();
        cmoMusic.setModel(new DefaultComboBoxModel(new String[] { "00: No music", "01: Tiny Woods", "02: Thunderwave Cave", "03: Mt. Steel", "04: Sinister Woods", "05: Silent Chasm", "06: Mt. Thunder", "07: Great Canyon", "08: Lapis Cave", "09: Mt. Blaze", "0A: Frosty Forest", "0B: Mt. Freeze", "0C: Magma Cavern", "0D: Sky Tower", "0E: Tiny Woods", "0F: Tiny Woods", "10: Tiny Woods", "11: Tiny Woods", "12: Buried Relic", "13: Stormy Sea", "14: Sinister Woods", "15: Mt. Thunder Peak", "16: Mt. Blaze Peak", "17: Frosty Grotto", "18: Mt. Freeze Peak", "19: Magma Cavern Pit", "1A: Sky Tower Summit", "1B: Tiny Woods", "1C:Tiny Woods", "1D: Tiny Woods", "1E: Tiny Woods", "1F: Tiny Woods", "20: Tiny Woods", "21: Tiny Woods", "22: Tiny Woods", "23: Tiny Woods", "24: Tiny Woods", "25: Great Canyon", "26: Tiny Woods", "27: Tiny Woods", "28: Ambience", "29: Makuhita Dojo", "2A: Makuhita Dojo", "2B: Tiny Woods", "2C: Tiny Woods", "2D: Tiny Woods", "2E: Tiny Woods", "2F: Tiny Woods", "30: Tiny Woods", "31: Tiny Woods", "32: Tiny Woods", "33: Tiny Woods", "34: Tiny Woods", "35: Tiny Woods", "36: Tiny Woods", "37: Tiny Woods", "38: Tiny Woods", "39: Tiny Woods", "3A: Tiny Woods", "3B: Tiny Woods", "3C: Tiny Woods", "3D: Tiny Woods", "3E: Tiny Woods", "3F: Tiny Woods", "40: Tiny Woods", "41: Ambience", "42: Beach Ambience", "43: Mt. Thunder Peak Ambience", "44: Mt. Blaze Peak Ambience", "45: Frosty Grotto Ambience", "46: Tiny Woods", "47: Tiny Woods", "48: Tiny Woods", "49: Silver Trench Ambience", "4A: Stormy Sea Ambience" }));
        cmoWeather = new JComboBox();
        cmoWeather.setModel(new DefaultComboBoxModel(new String[] { "00: Clear", "01: Sunny", "02: Sandstorm", "03: Cloudy", "04: Rain", "05: Hail", "06: Fog", "07: Snow", "08: Random" }));
        cmoVisibility = new JComboBox();
        cmoVisibility.setModel(new DefaultComboBoxModel(new String[] { "00: Normal", "01: 1 tile", "02: 2 tiles" }));
        cmoEvent = new JComboBox();
        cmoEvent.setModel(new DefaultComboBoxModel(new String[] { "00: Nothing", "01: Boss: Mt. Steel", "02: Boss: Sinister Forest", "03: Boss: Mt. Thunder", "04: Boss: Mt. Blaze", "05: Boss: Frost Grotto", "06: Boss: Mt. Freeze", "07: Boss: Magma Cavern", "08: Boss: Sky Tower", "09: Boss: Meteor Cave", "0A: Boss: Wish Cave", "0B: Boss: Uproar Forest", "0C: Boss: Fiery Field", "0D: Boss: Lightning Field", "0E: Boss: Northwind Field", "0F: Boss: Mt. Faraway", "10: Boss: Northern Range", "11: Boss: Buried Relic 1", "12: Boss: Buried Relic 2", "13: Boss: Buried Relic 3", "14: Special: Magma Cavern Pit", "15: Boss: Silver Trench", "16: Boss: Stormy Sea", "17: Boss: Meteor Cave", "18: Special: Howling Forest", "19: Special: Purity Forest", "1A: Special: Wish Cave", "1B: Boss: Normal Maze", "1C: Boss: Fire Maze", "1D: Boss: Water Maze", "1E: Boss: Grass Maze", "1F: Boss: Electric Maze", "20: Boss: Ice Maze", "21: Boss: Fighting Maze", "22: Boss: Ground Maze", "23: Boss: Flying Maze", "24: Boss: Psychic Maze", "25: Boss: Poison Maze", "26: Boss: Bug Maze", "27: Boss: Rock Maze", "28: Boss: Ghost Maze", "29: Boss: Dragon Maze", "2A: Boss: Dark Maze", "2B: Boss: Steel Maze", "2C: Boss: Team Shifty", "2D: Boss: Team Constrictor", "2E: Boss: Team Hydro", "2F: Boss: Team Rublerock", "30: Boss: Rescue Team 2", "31: Boss: Rescue Team Maze", "32: Item: HM Fly", "33: Item: HM Dive", "34: Item: HM Waterfall", "35: Item: HM Surf", "36: Item: TM Wide Slash", "37: Item: TM Vacuum-Cut", "38: Item: Friend Bow", "39: Item: Sun Ribbon", "3A: Item: Lunar Ribbon", "3B: Item: Beauty Scarf", "3C: Item: HM Cut", "3D: Item: HM Strength", "3E: Item: HM Flash", "3F: Item: HM Rock Smash", "40: Item: Deepseatooth", "41: Item: Wish Stone", "42: Item: Deepseascale" }));
        
        lblPreview = new JLabel();
        lblPreview.setSize(72, 120);
        lblSecretPower = new JLabel("Secret Power");
        lblNaturalPower = new JLabel("Natural Power");
        lblCamouflage = new JLabel("Camouflage");
        lblTileset = new JLabel("Tileset");
        txtSecretPower = new JTextField();
        txtSecretPower.setEditable(false);
        txtNaturalPower = new JTextField();
        txtNaturalPower.setEditable(false);
        txtCamouflage = new JTextField();
        txtCamouflage.setEditable(false);
        spnTileset = new JSpinner();
        spnTileset.setModel(new SpinnerNumberModel(Short.valueOf((short)0), Short.valueOf((short)0), Short.valueOf((short)75), Short.valueOf((short)1)));
        spnTileset.addChangeListener((javax.swing.event.ChangeEvent evt) -> {
            int tileset = (short) spnTileset.getValue();
            String[] properties = tilesetProperties.get(tileset).split(",");
            
            lblPreview.setIcon(new ImageIcon(getClass().getResource("/res/tilesets/" + tileset + ".png")));
            txtSecretPower.setText(properties[0]);
            txtNaturalPower.setText(properties[1]);
            txtCamouflage.setText(properties[2]);
        });
        
        lblLayout1 = new JLabel("General");
        lblLayout2 = new JLabel("Crossings");
        lblTerrain = new JLabel("Terrain tile density");
        spnLayout1 = new JSpinner();
        spnLayout1.setModel(new javax.swing.SpinnerNumberModel(0, 0, 8191, 1));
        spnLayout1.setEditor(new javax.swing.JSpinner.NumberEditor(spnLayout1, "0"));
        spnLayout2 = new JSpinner();
        spnLayout2.setModel(new javax.swing.SpinnerNumberModel(0, 0, 2047, 1));
        spnLayout2.setEditor(new javax.swing.JSpinner.NumberEditor(spnLayout2, "0"));
        spnTiles = new JSpinner();
        spnTiles.setModel(new javax.swing.SpinnerNumberModel(Short.valueOf((short)0), Short.valueOf((short)0), Short.valueOf((short)255), Short.valueOf((short)1)));
        chkTerrainTile = new JCheckBox("Has terrain tiles");
        chkTerrainPond = new JCheckBox("Has terrain pond");
        chkUnk9 = new JCheckBox("bool (0x9)");
        chkUnkB = new JCheckBox("bool (0xB)");
        chkUnkE = new JCheckBox("bool (0xE)");
        
        lblPokemon = new JLabel("Pokémon");
        lblItems = new JLabel("Items");
        lblTraps = new JLabel("Traps");
        lblMoney = new JLabel("Max. POKé factor");
        lblDensityMonsters = new JLabel("Monster Rooms");
        lblDensityShops = new JLabel("Kecelon Shops");
        spnPokemon = new JSpinner();
        spnPokemon.setModel(new javax.swing.SpinnerNumberModel(Short.valueOf((short)0), Short.valueOf((short)0), Short.valueOf((short)255), Short.valueOf((short)1)));
        spnItems = new JSpinner();
        spnItems.setModel(new javax.swing.SpinnerNumberModel(Short.valueOf((short)0), Short.valueOf((short)0), Short.valueOf((short)255), Short.valueOf((short)1)));
        spnTraps = new JSpinner();
        spnTraps.setModel(new javax.swing.SpinnerNumberModel(Short.valueOf((short)0), Short.valueOf((short)0), Short.valueOf((short)255), Short.valueOf((short)1)));
        spnMoney = new JSpinner();
        spnMoney.setModel(new javax.swing.SpinnerNumberModel(Short.valueOf((short)0), Short.valueOf((short)0), Short.valueOf((short)255), Short.valueOf((short)1)));
        spnDensityMonsters = new JSpinner();
        spnDensityMonsters.setModel(new javax.swing.SpinnerNumberModel(Short.valueOf((short)0), Short.valueOf((short)0), Short.valueOf((short)255), Short.valueOf((short)1)));
        spnDensityShops = new JSpinner();
        spnDensityShops.setModel(new javax.swing.SpinnerNumberModel(Short.valueOf((short)0), Short.valueOf((short)0), Short.valueOf((short)255), Short.valueOf((short)1)));
        
        lblUnk5 = new JLabel("byte (0x5)");
        lblUnkA = new JLabel("byte (0xA)");
        lblUnk18 = new JLabel("int (0x18)");
        spnUnk5 = new JSpinner();
        spnUnk5.setModel(new SpinnerNumberModel((byte)0, null, null, (byte)1));
        spnUnkA = new JSpinner();
        spnUnkA.setModel(new SpinnerNumberModel((byte)0, null, null, (byte)1));
        spnUnk18 = new JSpinner();
        spnUnk18.setModel(new SpinnerNumberModel());
        
        // Add the components to the property panel
        properties.addCaption("General");
        properties.addComponent(lblLayoutNo, spnLayoutNo);
        properties.addComponent(lblMusic, cmoMusic);
        properties.addComponent(lblWeather, cmoWeather);
        properties.addComponent(lblVisibility, cmoVisibility);
        properties.addComponent(lblEvent, cmoEvent);
        properties.addSeparator();
        properties.addCaption("Tileset");
        properties.addComponent(lblPreview);
        properties.addComponent(lblSecretPower, txtSecretPower);
        properties.addComponent(lblNaturalPower, txtNaturalPower);
        properties.addComponent(lblCamouflage, txtCamouflage);
        properties.addComponent(lblTileset, spnTileset);
        properties.addSeparator();
        properties.addCaption("Generator factors");
        properties.addComponent(lblLayout1, spnLayout1);
        properties.addComponent(lblLayout2, spnLayout2);
        properties.addComponent(lblTerrain, spnTiles);
        properties.addComponent(chkTerrainTile);
        properties.addComponent(chkTerrainPond);
        properties.addComponent(chkUnk9);
        properties.addComponent(chkUnkB);
        properties.addComponent(chkUnkE);
        properties.addSeparator();
        properties.addCaption("Object factors");
        properties.addComponent(lblPokemon, spnPokemon);
        properties.addComponent(lblItems, spnItems);
        properties.addComponent(lblTraps, spnTraps);
        properties.addComponent(lblMoney, spnMoney);
        properties.addComponent(lblDensityMonsters, spnDensityMonsters);
        properties.addComponent(lblDensityShops, spnDensityShops);
        properties.addSeparator();
        properties.addCaption("Unknown");
        properties.addComponent(lblUnk5, spnUnk5);
        properties.addComponent(lblUnkA, spnUnkA);
        properties.addComponent(lblUnk18, spnUnk18);
        properties.addTerminator();
    }

    @Override
    protected void load() {
        if (list.getSelectedIndex() < 0)
            return;
        
        selected = (DungeonLayout) RomFile.current.dungeonLayouts.get(list.getSelectedIndex()).clone();
        
        spnLayoutNo.setValue(selected.no);
        cmoMusic.setSelectedIndex(selected.music);
        cmoWeather.setSelectedIndex(selected.weather);
        cmoVisibility.setSelectedIndex(selected.visibility);
        cmoEvent.setSelectedIndex(selected.event);
        
        spnTileset.setValue(selected.tileset);
        
        spnLayout1.setValue(selected.layout1);
        spnLayout2.setValue(selected.layout2);
        spnTiles.setValue(selected.terrainDensity);
        chkTerrainTile.setSelected(selected.hasTerrainTiles);
        chkTerrainPond.setSelected(selected.hasTerrainPond);
        chkUnk9.setSelected(selected.hasTerrainUnk9);
        chkUnkB.setSelected(selected.hasTerrainUnkB);
        chkUnkE.setSelected(selected.hasTerrainUnkE);
        
        spnPokemon.setValue(selected.pokemonDensity);
        spnItems.setValue(selected.itemDensity);
        spnTraps.setValue(selected.trapDensity);
        spnMoney.setValue(selected.moneyFactor);
        spnDensityMonsters.setValue(selected.monstersFactor);
        spnDensityShops.setValue(selected.shopsFactor);
        
        spnUnk5.setValue(selected.unk5);
        spnUnkA.setValue(selected.unkA);
        spnUnk18.setValue(selected.unk18);
    }

    @Override
    protected void save() {
        if (selected == null || list.getSelectedIndex() < 0)
            return;
        
        selected.no = (short) spnLayoutNo.getValue();
        selected.music = (short) cmoMusic.getSelectedIndex();
        selected.weather = (short) cmoWeather.getSelectedIndex();
        selected.visibility = (short) cmoVisibility.getSelectedIndex();
        selected.event = (short) cmoEvent.getSelectedIndex();
        
        selected.tileset = (short) spnTileset.getValue();
        
        selected.layout1 = (int) spnLayout1.getValue();
        selected.layout2 = (int) spnLayout2.getValue();
        selected.terrainDensity = (short) spnTiles.getValue();
        selected.hasTerrainTiles = chkTerrainTile.isSelected();
        selected.hasTerrainPond = chkTerrainPond.isSelected();
        selected.hasTerrainUnk9 = chkUnk9.isSelected();
        selected.hasTerrainUnkB = chkUnkB.isSelected();
        selected.hasTerrainUnkE = chkUnkE.isSelected();
        
        selected.pokemonDensity = (short) spnPokemon.getValue();
        selected.itemDensity = (short) spnItems.getValue();
        selected.trapDensity = (short) spnTraps.getValue();
        selected.moneyFactor = (short) spnMoney.getValue();
        selected.monstersFactor = (short) spnDensityMonsters.getValue();
        selected.shopsFactor = (short) spnDensityShops.getValue();
        
        selected.unk5 = (byte) spnUnk5.getValue();
        selected.unkA = (byte) spnUnkA.getValue();
        selected.unk18 = (int) spnUnk18.getValue();
        
        RomFile.current.dungeonLayouts.set(list.getSelectedIndex(), selected);
    }
    
    @Override
    protected void warningLabel() {}
}