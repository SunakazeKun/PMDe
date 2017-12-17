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
    
    private JLabel lblUnk5, lblStickyChance, lblUnk18;
    private JSpinner spnUnk5, spnStickyChance, spnUnk18;
    
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
        add("Poison,Stun Spore,Grass");
        add("Accuracy down,Earthquake,Ground");
        add("Confusion,Rock Slide,Rock");
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
        cmoMusic.setModel(new DefaultComboBoxModel(new String[] { "No music", "Tiny Woods", "Thunderwave Cave", "Mt. Steel", "Sinister Woods", "Silent Chasm", "Mt. Thunder", "Great Canyon", "Lapis Cave", "Mt. Blaze", "Frosty Forest", "Mt. Freeze", "Magma Cavern", "Sky Tower", "Tiny Woods (0E)", "Tiny Woods (0F)", "Tiny Woods (10)", "Tiny Woods (11)", "Buried Relic", "Stormy Sea", "Sinister Woods", "Mt. Thunder Peak", "Mt. Blaze Peak", "Frosty Grotto", "Mt. Freeze Peak", "Magma Cavern Pit", "Sky Tower Summit", "Tiny Woods (1B)", "Tiny Woods (1C)", "Tiny Woods (1D)", "Tiny Woods (1E)", "Tiny Woods (1F)", "Tiny Woods (20)", "Tiny Woods (21)", "Tiny Woods (22)", "Tiny Woods (23)", "Tiny Woods (24)", "Great Canyon (25)", "Tiny Woods (26)", "Tiny Woods (27)", "Ambience", "Makuhita Dojo", "Makuhita Dojo (2A)", "Tiny Woods (2B)", "Tiny Woods (2C)", "Tiny Woods (2D)", "Tiny Woods (2E)", "Tiny Woods (2F)", "Tiny Woods (30)", "Tiny Woods (31)", "Tiny Woods (32)", "Tiny Woods (33)", "Tiny Woods (34)", "Tiny Woods (35)", "Tiny Woods (36)", "Tiny Woods (37)", "Tiny Woods (38)", "Tiny Woods (39)", "Tiny Woods (3A)", "Tiny Woods (3B)", "Tiny Woods (3C)", "Tiny Woods (3D)", "Tiny Woods (3E)", "Tiny Woods (3F)", "Tiny Woods (40)", "Ambience (41)", "Beach Ambience", "Mt. Thunder Peak Ambience", "Mt. Blaze Peak Ambience", "Frosty Grotto Ambience", "Tiny Woods (46)", "Tiny Woods (47)", "Tiny Woods (48)", "Silver Trench Ambience", "Stormy Sea Ambience" }));
        cmoWeather = new JComboBox();
        cmoWeather.setModel(new DefaultComboBoxModel(new String[] { "Clear", "Sunny", "Sandstorm", "Cloudy", "Rain", "Hail", "Fog", "Snow", "Random" }));
        cmoVisibility = new JComboBox();
        cmoVisibility.setModel(new DefaultComboBoxModel(new String[] { "Normal", "1 tile", "2 tiles" }));
        cmoEvent = new JComboBox();
        cmoEvent.setModel(new DefaultComboBoxModel(new String[] { "Nothing", "Boss: Mt. Steel", "Boss: Sinister Forest", "Boss: Mt. Thunder", "Boss: Mt. Blaze", "Boss: Frost Grotto", "Boss: Mt. Freeze", "Boss: Magma Cavern", "Boss: Sky Tower", "Boss: Meteor Cave", "Boss: Wish Cave", "Boss: Uproar Forest", "Boss: Fiery Field", "Boss: Lightning Field", "Boss: Northwind Field", "Boss: Mt. Faraway", "Boss: Northern Range", "Boss: Buried Relic 1", "Boss: Buried Relic 2", "Boss: Buried Relic 3", "Special: Magma Cavern Pit", "Boss: Silver Trench", "Boss: Stormy Sea", "Boss: Meteor Cave", "Special: Howling Forest", "Special: Purity Forest", "Special: Wish Cave", "Boss: Normal Maze", "Boss: Fire Maze", "Boss: Water Maze", "Boss: Grass Maze", "Boss: Electric Maze", "Boss: Ice Maze", "Boss: Fighting Maze", "Boss: Ground Maze", "Boss: Flying Maze", "Boss: Psychic Maze", "Boss: Poison Maze", "Boss: Bug Maze", "Boss: Rock Maze", "Boss: Ghost Maze", "Boss: Dragon Maze", "Boss: Dark Maze", "Boss: Steel Maze", "Boss: Team Shifty", "Boss: Team Constrictor", "Boss: Team Hydro", "Boss: Team Rublerock", "Boss: Rescue Team 2", "Boss: Rescue Team Maze", "Item: HM Fly", "Item: HM Dive", "Item: HM Waterfall", "Item: HM Surf", "Item: TM Wide Slash", "Item: TM Vacuum-Cut", "Item: Friend Bow", "Item: Sun Ribbon", "Item: Lunar Ribbon", "Item: Beauty Scarf", "Item: HM Cut", "Item: HM Strength", "Item: HM Flash", "Item: HM Rock Smash", "Item: Deepseatooth", "Item: Wish Stone", "Item: Deepseascale" }));
                
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
        
        lblPokemon = new JLabel("Pokémon");
        lblItems = new JLabel("Items");
        lblTraps = new JLabel("Traps");
        lblStickyChance = new JLabel("Sticky chance");
        lblMoney = new JLabel("Max. POKé factor");
        lblDensityMonsters = new JLabel("Monster Rooms");
        lblDensityShops = new JLabel("Kecelon Shops");
        spnPokemon = new JSpinner();
        spnPokemon.setModel(new javax.swing.SpinnerNumberModel(Short.valueOf((short)0), Short.valueOf((short)0), Short.valueOf((short)255), Short.valueOf((short)1)));
        spnItems = new JSpinner();
        spnItems.setModel(new javax.swing.SpinnerNumberModel(Short.valueOf((short)0), Short.valueOf((short)0), Short.valueOf((short)255), Short.valueOf((short)1)));
        spnTraps = new JSpinner();
        spnTraps.setModel(new javax.swing.SpinnerNumberModel(Short.valueOf((short)0), Short.valueOf((short)0), Short.valueOf((short)255), Short.valueOf((short)1)));
        spnStickyChance = new JSpinner();
        spnStickyChance.setModel(new SpinnerNumberModel(Short.valueOf((short)0), Short.valueOf((short)0), Short.valueOf((short)255), Short.valueOf((short)1)));
        spnMoney = new JSpinner();
        spnMoney.setModel(new javax.swing.SpinnerNumberModel(Short.valueOf((short)0), Short.valueOf((short)0), Short.valueOf((short)255), Short.valueOf((short)1)));
        spnDensityMonsters = new JSpinner();
        spnDensityMonsters.setModel(new javax.swing.SpinnerNumberModel(Short.valueOf((short)0), Short.valueOf((short)0), Short.valueOf((short)255), Short.valueOf((short)1)));
        spnDensityShops = new JSpinner();
        spnDensityShops.setModel(new javax.swing.SpinnerNumberModel(Short.valueOf((short)0), Short.valueOf((short)0), Short.valueOf((short)255), Short.valueOf((short)1)));
        
        lblUnk5 = new JLabel("byte (0x5)");
        lblUnk18 = new JLabel("int (0x18)");
        spnUnk5 = new JSpinner();
        spnUnk5.setModel(new SpinnerNumberModel((byte)0, null, null, (byte)1));
        spnUnk18 = new JSpinner();
        spnUnk18.setModel(new SpinnerNumberModel());
        chkUnk9 = new JCheckBox("bool (0x9)");
        chkUnkB = new JCheckBox("bool (0xB)");
        chkUnkE = new JCheckBox("bool (0xE)");
        
        // Add the components to the property panel
        properties.addCaption("General");
        properties.addLabeledComponent(lblLayoutNo, spnLayoutNo);
        properties.addLabeledComponent(lblMusic, cmoMusic);
        properties.addLabeledComponent(lblWeather, cmoWeather);
        properties.addLabeledComponent(lblVisibility, cmoVisibility);
        properties.addLabeledComponent(lblEvent, cmoEvent);
        properties.addSeparator();
        properties.addCaption("Tileset");
        properties.addComponent(lblPreview);
        properties.addLabeledComponent(lblSecretPower, txtSecretPower);
        properties.addLabeledComponent(lblNaturalPower, txtNaturalPower);
        properties.addLabeledComponent(lblCamouflage, txtCamouflage);
        properties.addLabeledComponent(lblTileset, spnTileset);
        properties.addSeparator();
        properties.addCaption("Generator settings");
        properties.addLabeledComponent(lblLayout1, spnLayout1);
        properties.addLabeledComponent(lblLayout2, spnLayout2);
        properties.addLabeledComponent(lblTerrain, spnTiles);
        properties.addComponent(chkTerrainTile);
        properties.addComponent(chkTerrainPond);
        properties.addSeparator();
        properties.addCaption("Object parameters");
        properties.addLabeledComponent(lblPokemon, spnPokemon);
        properties.addLabeledComponent(lblItems, spnItems);
        properties.addLabeledComponent(lblTraps, spnTraps);
        properties.addLabeledComponent(lblStickyChance, spnStickyChance);
        properties.addLabeledComponent(lblMoney, spnMoney);
        properties.addLabeledComponent(lblDensityMonsters, spnDensityMonsters);
        properties.addLabeledComponent(lblDensityShops, spnDensityShops);
        properties.addSeparator();
        properties.addCaption("Unknown");
        properties.addLabeledComponent(lblUnk5, spnUnk5);
        properties.addLabeledComponent(lblUnk18, spnUnk18);
        properties.addComponent(chkUnk9);
        properties.addComponent(chkUnkB);
        properties.addComponent(chkUnkE);
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
        
        spnPokemon.setValue(selected.pokemonDensity);
        spnItems.setValue(selected.itemDensity);
        spnTraps.setValue(selected.trapDensity);
        spnStickyChance.setValue(selected.stickyChance);
        spnMoney.setValue(selected.moneyFactor);
        spnDensityMonsters.setValue(selected.monstersFactor);
        spnDensityShops.setValue(selected.shopsFactor);
        
        spnUnk5.setValue(selected.unk5);
        spnUnk18.setValue(selected.unk18);
        chkUnk9.setSelected(selected.unk9);
        chkUnkB.setSelected(selected.unkB);
        chkUnkE.setSelected(selected.unkE);
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
        
        selected.pokemonDensity = (short) spnPokemon.getValue();
        selected.itemDensity = (short) spnItems.getValue();
        selected.trapDensity = (short) spnTraps.getValue();
        selected.stickyChance = (short) spnStickyChance.getValue();
        selected.moneyFactor = (short) spnMoney.getValue();
        selected.monstersFactor = (short) spnDensityMonsters.getValue();
        selected.shopsFactor = (short) spnDensityShops.getValue();
        
        selected.unk5 = (byte) spnUnk5.getValue();
        selected.unk18 = (int) spnUnk18.getValue();
        selected.unk9 = chkUnk9.isSelected();
        selected.unkB = chkUnkB.isSelected();
        selected.unkE = chkUnkE.isSelected();
        
        RomFile.current.dungeonLayouts.set(list.getSelectedIndex(), selected);
    }
    
    @Override
    protected void warningLabel() {}
}