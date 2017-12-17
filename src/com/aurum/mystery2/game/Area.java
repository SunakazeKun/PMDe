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

public class Area implements Cloneable {
    // Entry fields
    public int count, condition;
    public long price;
    
    // Other fields
    public String name;
    public int namePointer;
    
    // Static fields
    public static final int SIZE = 0x8;
    
    @Override
    public String toString() {
        return name;
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
    
    public static Area unpack(ByteBuffer buffer) {
        Area area = new Area();
        
        area.count = buffer.readUnsignedShort();
        area.condition = buffer.readUnsignedShort();
        area.price = buffer.readUnsignedInt();
        
        return area;
    }
    
    public static byte[] pack(Area area) {
        ByteBuffer buffer = new ByteBuffer(SIZE, ByteOrder.LITTLE_ENDIAN);
        
        buffer.writeUnsignedShort(area.count);
        buffer.writeUnsignedShort(area.condition);
        buffer.writeUnsignedInt(area.price);
        
        return buffer.getBuffer();
    }
}