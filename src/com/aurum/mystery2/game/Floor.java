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
    public int layoutID, pokemonID, trapsID, itemsID, itemsShopID, itemsMonsterID, itemsBuriedID;
    
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
        
        floor.layoutID = buffer.readUShort();
        floor.pokemonID = buffer.readUShort();
        floor.trapsID = buffer.readUShort();
        floor.itemsID = buffer.readUShort();
        floor.itemsShopID = buffer.readUShort();
        floor.itemsMonsterID = buffer.readUShort();
        floor.itemsBuriedID = buffer.readUShort();
        buffer.skip(0x2);
        
        return floor;
    }
    
    public static byte[] pack(Floor floor) {
        ByteBuffer buffer = new ByteBuffer(SIZE, ByteOrder.LITTLE_ENDIAN);
        
        buffer.writeUShort(floor.layoutID);
        buffer.writeUShort(floor.pokemonID);
        buffer.writeUShort(floor.trapsID);
        buffer.writeUShort(floor.itemsID);
        buffer.writeUShort(floor.itemsShopID);
        buffer.writeUShort(floor.itemsMonsterID);
        buffer.writeUShort(floor.itemsBuriedID);
        buffer.writeShort((short) 0x0);
        
        return buffer.getContent();
    }
}