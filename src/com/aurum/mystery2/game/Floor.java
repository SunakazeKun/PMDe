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

import com.aurum.mystery2.ByteBuffer;
import com.aurum.mystery2.ByteOrder;

public class Floor implements Cloneable {
    // Entry fields
    public int layout, pokemon, traps, items, itemsShop, itemsMonster, itemsBuried;
    
    // Static fields
    public static final int SIZE = 0x10;
    
    @Override
    public Object clone() {
        try {
            return super.clone();
        }
        catch (CloneNotSupportedException ex) {
            return null;
        }
    }
    
    public static Floor unpack(ByteBuffer buffer) {
        Floor floor = new Floor();
        
        floor.layout = buffer.readUnsignedShort();
        floor.pokemon = buffer.readUnsignedShort();
        floor.traps = buffer.readUnsignedShort();
        floor.items = buffer.readUnsignedShort();
        floor.itemsShop = buffer.readUnsignedShort();
        floor.itemsMonster = buffer.readUnsignedShort();
        floor.itemsBuried = buffer.readUnsignedShort();
        buffer.skip(0x2);
        
        return floor;
    }
    
    public static byte[] pack(Floor floor) {
        ByteBuffer buffer = new ByteBuffer(SIZE, ByteOrder.LITTLE_ENDIAN);
        
        buffer.writeUnsignedShort(floor.layout);
        buffer.writeUnsignedShort(floor.pokemon);
        buffer.writeUnsignedShort(floor.traps);
        buffer.writeUnsignedShort(floor.items);
        buffer.writeUnsignedShort(floor.itemsShop);
        buffer.writeUnsignedShort(floor.itemsMonster);
        buffer.writeUnsignedShort(floor.itemsBuried);
        buffer.writeShort((short) 0x0);
        
        return buffer.getBuffer();
    }
}