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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.aurum.mystery2.ByteBuffer;
import com.aurum.mystery2.ByteOrder;
import com.aurum.mystery2.Lists;

public class DungeonPokemon implements Cloneable {
    // Entry fields
    public List<Entry> entries;
    
    // Other fields
    public int offset;
    
    // Static fields
    public static final int SIZE = 0x8;
    private static final byte[] NULL = new byte[SIZE];
    
    public static class Entry implements Cloneable {
        public int species, level, probability;
        
        @Override
        public String toString() {
            return Lists.pokemon.get(species) + ": Lv. " + level + " (" + probability + ")";
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
    }
    
    @Override
    public Object clone() {
        try {
            DungeonPokemon clone = (DungeonPokemon) super.clone();
            clone.entries = new ArrayList();
            for (Entry entry : entries)
                clone.entries.add((Entry) entry.clone());
            return clone;
        }
        catch (CloneNotSupportedException ex) {
            return null;
        }
    }
    
    public boolean checkProbabilitySum() {
        int sum = 0;
        for (Entry entry : entries)
            sum += entry.probability;
        return sum != 10000;
    }
    
    public static DungeonPokemon unpack(ByteBuffer buffer) {
        DungeonPokemon pokemon = new DungeonPokemon();
        
        pokemon.offset = buffer.position();
        pokemon.entries = new ArrayList();
        
        int storedoffset = buffer.position();
        int diff = 0;
        
        while(!Arrays.equals(buffer.readBytes(SIZE), NULL)) {
            buffer.seek(storedoffset);
            
            Entry entry = new Entry();
            int mask = buffer.readUShort();
            entry.level = (mask ^ 0x1A8) / 0x200;
            entry.species = mask - 0x200 * entry.level;
            entry.probability = buffer.readUShort();
            int val = entry.probability;
            if (val != 0) {
                val -= diff;
                diff = entry.probability;
            }
            entry.probability = val;
            pokemon.entries.add(entry);
            
            buffer.skip(0x4);
            storedoffset = buffer.position();
        }
        
        return pokemon;
    }
    
    public static byte[] pack(DungeonPokemon pokemon) {
        ByteBuffer buffer = new ByteBuffer(pokemon.entries.size() * 8 + 8, ByteOrder.LITTLE_ENDIAN);
        
        int sum = 0;
        for (Entry entry : pokemon.entries) {
            buffer.writeUShort(entry.species + entry.level * 0x200);
            if (sum < 10000) {
                int val = (entry.probability != 0) ? sum += entry.probability : 0;
                buffer.writeUShort(val);
                buffer.writeUShort(val);
            }
            else {
                buffer.writeUShort(0);
                buffer.writeUShort(0);
            }
            buffer.writeUShort(0);
        }
        
        return buffer.getContent();
    }
}