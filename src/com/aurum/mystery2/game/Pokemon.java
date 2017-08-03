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
    public int speciesPointer, categoryPointer;
    public String species, category;
    public int speed;
    public short recruit, facesBitfield;
    public byte[] unkA, unk1A, unk30;
    public short type1, type2, ability1, ability2, area, palette, size, shadow, walkable, unk12;
    public int evolveFrom, evolveType, evolveParam, evolveAddition;
    public int stat_hp, stat_attack, stat_spattack, stat_defense, stat_spdefense, stat_unknown, basexp;
    public int dexNo, internalNo, parentNo, alphabetNo, damageLowKick, damageSizeBust;
    
    // Static fields
    public static final int SIZE = 0x48;
    
    @Override
    public Object clone() {
        try {
            Pokemon clone = (Pokemon) super.clone();
            clone.unkA = new byte[0x2];
            clone.unk1A = new byte[0x4];
            clone.unk30 = new byte[0x4];
            System.arraycopy(unkA, 0, clone.unkA, 0, 0x2);
            System.arraycopy(unk1A, 0, clone.unk1A, 0, 0x4);
            System.arraycopy(unk30, 0, clone.unk30, 0, 0x4);
            return clone;
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
        pokemon.unkA = buffer.readBytes(0x2);
        pokemon.speed = buffer.readInt();
        pokemon.facesBitfield = buffer.readShort();
        pokemon.unk12 = buffer.readUByte();
        pokemon.type1 = buffer.readUByte();
        pokemon.type2 = buffer.readUByte();
        pokemon.walkable = buffer.readUByte();
        pokemon.area = buffer.readUByte();
        pokemon.ability1 = buffer.readUByte();
        pokemon.ability2 = buffer.readUByte();
        pokemon.shadow = buffer.readUByte();
        pokemon.unk1A = buffer.readBytes(0x4);
        pokemon.stat_hp = buffer.readUShort();
        pokemon.basexp = buffer.readUShort();
        pokemon.stat_unknown = buffer.readUShort();
        pokemon.stat_attack = buffer.readUShort();
        pokemon.stat_spattack = buffer.readUShort();
        pokemon.stat_defense = buffer.readUShort();
        pokemon.stat_spdefense = buffer.readUShort();
        pokemon.damageLowKick = buffer.readUShort();
        pokemon.damageSizeBust = buffer.readUShort();
        pokemon.unk30 = buffer.readBytes(0x4);
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
        buffer.seek(BitConverter.pointerToOffset(pokemon.speciesPointer));
        pokemon.species = buffer.readString();
        buffer.seek(BitConverter.pointerToOffset(pokemon.categoryPointer));
        pokemon.category = buffer.readString();
        
        buffer.seek(nextOffset);
        
        return pokemon;
    }
    
    public static byte[] pack(Pokemon pokemon) {
        ByteBuffer buffer = new ByteBuffer(0x48, ByteOrder.LITTLE_ENDIAN);
        
        buffer.writeInt(pokemon.speciesPointer);
        buffer.writeInt(pokemon.categoryPointer);
        buffer.writeUByte(pokemon.palette);
        buffer.writeUByte(pokemon.size);
        buffer.writeBytes(pokemon.unkA);
        buffer.writeInt(pokemon.speed);
        buffer.writeShort(pokemon.facesBitfield);
        buffer.writeUByte(pokemon.unk12);
        buffer.writeUByte(pokemon.type1);
        buffer.writeUByte(pokemon.type2);
        buffer.writeUByte(pokemon.walkable);
        buffer.writeUByte(pokemon.area);
        buffer.writeUByte(pokemon.ability1);
        buffer.writeUByte(pokemon.ability2);
        buffer.writeUByte(pokemon.shadow);
        buffer.writeBytes(pokemon.unk1A);
        buffer.writeUShort(pokemon.stat_hp);
        buffer.writeUShort(pokemon.basexp);
        buffer.writeUShort(pokemon.stat_unknown);
        buffer.writeUShort(pokemon.stat_attack);
        buffer.writeUShort(pokemon.stat_spattack);
        buffer.writeUShort(pokemon.stat_defense);
        buffer.writeUShort(pokemon.stat_spdefense);
        buffer.writeUShort(pokemon.damageLowKick);
        buffer.writeUShort(pokemon.damageSizeBust);
        buffer.writeBytes(pokemon.unk30);
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
