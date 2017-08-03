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

package com.aurum.mystery2.game;

import java.util.List;
import com.aurum.mystery2.ByteBuffer;
import com.aurum.mystery2.ByteOrder;

public class DungeonItems implements Cloneable {
    // Entry fields
    public List<Entry> entries;
    
    // Other fields
    public int offset;
    
    // Static fields
    
    public static class Entry implements Cloneable {
        @Override
        public Object clone() {
            try {
                return super.clone();
            }
            catch (CloneNotSupportedException ex) {
                return null;
            }
        }
    }
    
    @Override
    public Object clone() {
        try {
            return super.clone();
        }
        catch (CloneNotSupportedException ex) {
            return null;
        }
    }
    
    public static DungeonItems unpack(ByteBuffer buffer) {
        DungeonItems items = new DungeonItems();
        
        items.offset = buffer.position();
        
        return items;
    }
    
    public static byte[] pack(DungeonItems pokemon) {
        ByteBuffer buffer = new ByteBuffer(-1, ByteOrder.LITTLE_ENDIAN);
        return buffer.getContent();
    }
}