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

import com.aurum.mystery2.game.DungeonItems;
import com.aurum.mystery2.game.RomFile;
import javax.swing.DefaultListModel;

public class DungeonItemsEditor extends AbstractEditor {
    private DungeonItems selected;
    private DungeonItems.Entry selectedEntry;
    private DefaultListModel entryModel;
    
    public DungeonItemsEditor() {
        this(-1);
    }
    
    public DungeonItemsEditor(int items) {
        for (int i = 0 ; i < RomFile.current.dungeonItems.size() ; i++)
            model.addElement("Items no. " + i);
        
        list.setSelectedIndex(items);
        list.ensureIndexIsVisible(items);
    }
    
    @Override
    protected void initProperties() {
        setTitle("Dungeon items editor");
        
        // Initialize the components
        // Add the components to the property panel
    }

    @Override
    protected void load() {
    }

    @Override
    protected void save() {
    }

    @Override
    protected void warningLabel() {}
}