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

public class Pokemon implements Cloneable {
    // Entry fields
    public String species, category;
    public int speciesPointer, categoryPointer;
    public short size, shadow, walkable, recruit, faces;
    public short type1, type2, ability1, ability2, area, palette;
    public int evolveFrom, evolveType, evolveParam, evolveAddition, speed;
    public int hp, atk, spatk, def, spdef, basexp;
    public int dexNo, internalNo, parentNo, alphabetNo, lowKick, sizeBust;
    public boolean isMoving;
    
    // Unknown fields
    public byte unk1A, unk1B, unk1D, unk30, unk31, unk32;
    public int unk22;
    public boolean unk33;
    
    // Static fields
    public static final int SIZE = 0x48;
    
    @Override
    public Object clone() {
        try {
            return super.clone();
        }
        catch (CloneNotSupportedException ex) {
            return null;
        }
    }
    
    public static Pokemon unpack(ByteBuffer buffer) {
        Pokemon mon = new Pokemon();
        
        int nextOffset = buffer.position() + SIZE;
        
        // Fields
        mon.speciesPointer = buffer.readInt();
        mon.categoryPointer = buffer.readInt();
        mon.palette = buffer.readUByte();
        mon.size = buffer.readUByte();
        buffer.skip(0x2);
        mon.speed = buffer.readInt();
        mon.faces = buffer.readShort();
        buffer.skip(0x1);
        mon.type1 = buffer.readUByte();
        mon.type2 = buffer.readUByte();
        mon.walkable = buffer.readUByte();
        mon.area = buffer.readUByte();
        mon.ability1 = buffer.readUByte();
        mon.ability2 = buffer.readUByte();
        mon.shadow = buffer.readUByte();
        mon.unk1A = buffer.readByte();
        mon.unk1B = buffer.readByte();
        mon.isMoving = buffer.readBoolean();
        mon.unk1D = buffer.readByte();
        mon.hp = buffer.readUShort();
        mon.basexp = buffer.readUShort();
        mon.unk22 = buffer.readUShort();
        mon.atk = buffer.readUShort();
        mon.spatk = buffer.readUShort();
        mon.def = buffer.readUShort();
        mon.spdef = buffer.readUShort();
        mon.lowKick = buffer.readUShort();
        mon.sizeBust = buffer.readUShort();
        mon.unk30 = buffer.readByte();
        mon.unk31 = buffer.readByte();
        mon.unk32 = buffer.readByte();
        mon.unk33 = buffer.readBoolean();
        mon.evolveFrom = buffer.readUShort();
        mon.evolveType = buffer.readUShort();
        mon.evolveParam = buffer.readUShort();
        mon.evolveAddition = buffer.readUShort();
        mon.dexNo = buffer.readUShort();
        mon.internalNo = buffer.readUShort();
        mon.recruit = buffer.readShort();
        mon.alphabetNo = buffer.readUShort();
        mon.parentNo = buffer.readUShort();
        
        // Strings
        if (mon.speciesPointer != 0x00000000) mon.species = buffer.readStringAt(BitConverter.pointerToOffset(mon.speciesPointer));
        if (mon.categoryPointer != 0x00000000) mon.category = buffer.readStringAt(BitConverter.pointerToOffset(mon.categoryPointer));
        
        buffer.seek(nextOffset);
        
        return mon;
    }
    
    public static byte[] pack(Pokemon pokemon) {
        ByteBuffer buffer = new ByteBuffer(0x48, ByteOrder.LITTLE_ENDIAN);
        
        buffer.writeInt(pokemon.speciesPointer);
        buffer.writeInt(pokemon.categoryPointer);
        buffer.writeUByte(pokemon.palette);
        buffer.writeUByte(pokemon.size);
        buffer.writeShort((short) 0);
        buffer.writeInt(pokemon.speed);
        buffer.writeShort(pokemon.faces);
        buffer.writeByte((byte) 0);
        buffer.writeUByte(pokemon.type1);
        buffer.writeUByte(pokemon.type2);
        buffer.writeUByte(pokemon.walkable);
        buffer.writeUByte(pokemon.area);
        buffer.writeUByte(pokemon.ability1);
        buffer.writeUByte(pokemon.ability2);
        buffer.writeUByte(pokemon.shadow);
        buffer.writeByte(pokemon.unk1A);
        buffer.writeByte(pokemon.unk1B);
        buffer.writeBoolean(pokemon.isMoving);
        buffer.writeByte(pokemon.unk1D);
        buffer.writeUShort(pokemon.hp);
        buffer.writeUShort(pokemon.basexp);
        buffer.writeUShort(pokemon.unk22);
        buffer.writeUShort(pokemon.atk);
        buffer.writeUShort(pokemon.spatk);
        buffer.writeUShort(pokemon.def);
        buffer.writeUShort(pokemon.spdef);
        buffer.writeUShort(pokemon.lowKick);
        buffer.writeUShort(pokemon.sizeBust);
        buffer.writeByte(pokemon.unk30);
        buffer.writeByte(pokemon.unk31);
        buffer.writeByte(pokemon.unk32);
        buffer.writeBoolean(pokemon.unk33);
        buffer.writeUShort(pokemon.evolveFrom);
        buffer.writeUShort(pokemon.evolveType);
        buffer.writeUShort(pokemon.evolveParam);
        buffer.writeUShort(pokemon.evolveAddition);
        buffer.writeUShort(pokemon.dexNo);
        buffer.writeUShort(pokemon.internalNo);
        buffer.writeShort(pokemon.recruit);
        buffer.writeUShort(pokemon.alphabetNo);
        buffer.writeUShort(pokemon.parentNo);
        
        return buffer.getContent();
    }
}
