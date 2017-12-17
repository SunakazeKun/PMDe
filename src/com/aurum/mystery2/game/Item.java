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

import com.aurum.mystery2.BitConverter;
import com.aurum.mystery2.ByteBuffer;
import com.aurum.mystery2.ByteOrder;

public class Item implements Cloneable {
    // Entry fields
    public String name, desc;
    public int namePointer, descPointer;
    public long buyPrice, sellPrice;
    public short icon, palette, type, subtype, move, order;
    public boolean throwDamage;
    
    // Unknown fields
    public short unkThrow1B, unkThrow1C;
    public boolean unkFood1, unkFood2;
    
    // Static fields
    public static final int SIZE = 0x20;
    
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
    
    public static Item unpack(ByteBuffer buffer) {
        Item item = new Item();
        
        int nextOffset = buffer.position() + SIZE;
        
        // Fields
        item.namePointer = buffer.readInt();
        item.buyPrice = buffer.readUnsignedInt();
        item.sellPrice = buffer.readUnsignedInt();
        item.type = buffer.readUnsignedByte();
        item.icon = buffer.readUnsignedByte();
        buffer.skip(0x2);
        item.descPointer = buffer.readInt();
        item.unkFood1 = buffer.readBoolean();
        item.unkFood2 = buffer.readBoolean();
        item.throwDamage = buffer.readBoolean();
        buffer.skip(0x1);
        item.move = buffer.readShort();
        item.order = buffer.readUnsignedByte();
        item.unkThrow1B = buffer.readUnsignedByte();
        item.unkThrow1C = buffer.readUnsignedByte();
        item.palette = buffer.readUnsignedByte();
        item.subtype = buffer.readUnsignedByte();
        buffer.skip(0x1);
        
        // Strings
        if (item.namePointer != 0x00000000) item.name = buffer.readStringAt(BitConverter.pointerToOffset(item.namePointer));
        if (item.descPointer != 0x00000000) item.desc = buffer.readStringAt(BitConverter.pointerToOffset(item.descPointer));
        
        buffer.seek(nextOffset);
        
        return item;
    }
    
    public static byte[] pack(Item item) {
        ByteBuffer buffer = new ByteBuffer(0x20, ByteOrder.LITTLE_ENDIAN);
        
        buffer.writeInt(item.namePointer);
        buffer.writeUnsignedInt(item.buyPrice);
        buffer.writeUnsignedInt(item.sellPrice);
        buffer.writeUnsignedByte(item.type);
        buffer.writeUnsignedByte(item.icon);
        buffer.writeShort((short) 0);
        buffer.writeInt(item.descPointer);
        buffer.writeBoolean(item.unkFood1);
        buffer.writeBoolean(item.unkFood2);
        buffer.writeBoolean(item.throwDamage);
        buffer.writeByte((byte) 0);
        buffer.writeShort(item.move);
        buffer.writeUnsignedByte(item.order);
        buffer.writeUnsignedByte(item.unkThrow1B);
        buffer.writeUnsignedByte(item.unkThrow1C);
        buffer.writeUnsignedByte(item.palette);
        buffer.writeUnsignedByte(item.subtype);
        buffer.writeByte((byte) 0);
        
        return buffer.getBuffer();
    }
}