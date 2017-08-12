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
    public short size, shadow, walkable, recruit, facesBitfield;
    public short type1, type2, ability1, ability2, area, palette;
    public int evolveFrom, evolveType, evolveParam, evolveAddition, speed;
    public int stat_hp, stat_attack, stat_spattack, stat_defense, stat_spdefense, stat_unknown, basexp;
    public int dexNo, internalNo, parentNo, alphabetNo, damageLowKick, damageSizeBust;
    public boolean isNotMoving;
    
    // Unknown fields
    public byte unk1A, unk1B, unk1D, unk30, unk31, unk32;
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
        Pokemon pokemon = new Pokemon();
        
        int nextOffset = buffer.position() + SIZE;
        
        // Fields
        pokemon.speciesPointer = buffer.readInt();
        pokemon.categoryPointer = buffer.readInt();
        pokemon.palette = buffer.readUByte();
        pokemon.size = buffer.readUByte();
        buffer.skip(0x2);
        pokemon.speed = buffer.readInt();
        pokemon.facesBitfield = buffer.readShort();
        buffer.skip(0x1);
        pokemon.type1 = buffer.readUByte();
        pokemon.type2 = buffer.readUByte();
        pokemon.walkable = buffer.readUByte();
        pokemon.area = buffer.readUByte();
        pokemon.ability1 = buffer.readUByte();
        pokemon.ability2 = buffer.readUByte();
        pokemon.shadow = buffer.readUByte();
        pokemon.unk1A = buffer.readByte();
        pokemon.unk1B = buffer.readByte();
        pokemon.isNotMoving = !buffer.readBoolean();
        pokemon.unk1D = buffer.readByte();
        pokemon.stat_hp = buffer.readUShort();
        pokemon.basexp = buffer.readUShort();
        pokemon.stat_unknown = buffer.readUShort();
        pokemon.stat_attack = buffer.readUShort();
        pokemon.stat_spattack = buffer.readUShort();
        pokemon.stat_defense = buffer.readUShort();
        pokemon.stat_spdefense = buffer.readUShort();
        pokemon.damageLowKick = buffer.readUShort();
        pokemon.damageSizeBust = buffer.readUShort();
        pokemon.unk30 = buffer.readByte();
        pokemon.unk31 = buffer.readByte();
        pokemon.unk32 = buffer.readByte();
        pokemon.unk33 = buffer.readBoolean();
        pokemon.evolveFrom = buffer.readUShort();
        pokemon.evolveType = buffer.readUShort();
        pokemon.evolveParam = buffer.readUShort();
        pokemon.evolveAddition = buffer.readUShort();
        pokemon.dexNo = buffer.readUShort();
        pokemon.internalNo = buffer.readUShort();
        pokemon.recruit = buffer.readShort();
        pokemon.alphabetNo = buffer.readUShort();
        pokemon.parentNo = buffer.readUShort();
        
        // Strings
        if (pokemon.speciesPointer != 0x00000000) {
            buffer.seek(BitConverter.pointerToOffset(pokemon.speciesPointer));
            pokemon.species = buffer.readString();
        }
        if (pokemon.categoryPointer != 0x00000000) {
            buffer.seek(BitConverter.pointerToOffset(pokemon.categoryPointer));
            pokemon.category = buffer.readString();
        }
        
        buffer.seek(nextOffset);
        
        return pokemon;
    }
    
    public static byte[] pack(Pokemon pokemon) {
        ByteBuffer buffer = new ByteBuffer(0x48, ByteOrder.LITTLE_ENDIAN);
        
        buffer.writeInt(pokemon.speciesPointer);
        buffer.writeInt(pokemon.categoryPointer);
        buffer.writeUByte(pokemon.palette);
        buffer.writeUByte(pokemon.size);
        buffer.writeShort((short) 0);
        buffer.writeInt(pokemon.speed);
        buffer.writeShort(pokemon.facesBitfield);
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
        buffer.writeBoolean(!pokemon.isNotMoving);
        buffer.writeByte(pokemon.unk1D);
        buffer.writeUShort(pokemon.stat_hp);
        buffer.writeUShort(pokemon.basexp);
        buffer.writeUShort(pokemon.stat_unknown);
        buffer.writeUShort(pokemon.stat_attack);
        buffer.writeUShort(pokemon.stat_spattack);
        buffer.writeUShort(pokemon.stat_defense);
        buffer.writeUShort(pokemon.stat_spdefense);
        buffer.writeUShort(pokemon.damageLowKick);
        buffer.writeUShort(pokemon.damageSizeBust);
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
        buffer.writeUShort(pokemon.recruit);
        buffer.writeUShort(pokemon.alphabetNo);
        buffer.writeUShort(pokemon.parentNo);
        
        return buffer.getContent();
    }
}
