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
import com.aurum.mystery2.Lists;

public class ExclusivePokemon implements Cloneable {
    // Entry fields
    public int species;
    public boolean red, blue;
    
    // Static fields
    public static int SIZE = 0x4;
    
    @Override
    public String toString() {
        return Lists.pokemon.get(species) + ((red && blue) ? " (R & B)"
                : (red ? " (R)"
                : (blue ? " (B)"
                : "")));
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
    
    public static ExclusivePokemon unpack(ByteBuffer buffer) {
        ExclusivePokemon exclusive = new ExclusivePokemon();
        
        exclusive.species = buffer.readUnsignedShort();
        exclusive.red = buffer.readBoolean();
        exclusive.blue = buffer.readBoolean();
        
        return exclusive;
    }
    
    public static byte[] pack(ExclusivePokemon exc) {
        ByteBuffer buffer = new ByteBuffer(SIZE, ByteOrder.LITTLE_ENDIAN);
        
        buffer.writeUnsignedShort(exc.species);
        buffer.writeBoolean(exc.red);
        buffer.writeBoolean(exc.blue);
        
        return buffer.getBuffer();
    }
}