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

public class DungeonTraps implements Cloneable {
    // Entry fields
    public int[] traps;
    
    // Other fields
    public int offset;
    
    // Static fields
    public static final int SIZE = 0x28;
    
    @Override
    public Object clone() {
        try {
            DungeonTraps clone = (DungeonTraps) super.clone();
            clone.traps = new int[20];
            System.arraycopy(traps, 0, clone.traps, 0, 20);
            return clone;
        }
        catch (CloneNotSupportedException ex) {
            return null;
        }
    }
    
    public boolean checkProbabilitySum() {
        int sum = 0;
        for (int trap : traps)
            sum += trap;
        return sum != 10000;
    }
    
    public static DungeonTraps unpack(ByteBuffer buffer) {
        DungeonTraps trapentry = new DungeonTraps();
        
        trapentry.offset = buffer.position();
        trapentry.traps = new int[20];
        int diff = 0;
        for (int i = 0 ; i < 20 ; i++) {
            int mval = buffer.readUnsignedShort();
            int val = mval;
            if (mval != 0) {
                val -= diff;
                diff = mval;
            }
            trapentry.traps[i] = val;
        }
        
        return trapentry;
    }
    
    public static byte[] pack(DungeonTraps trapentry) {
        ByteBuffer buffer = new ByteBuffer(SIZE, ByteOrder.LITTLE_ENDIAN);
        
        int sum = 0;
        for (int trap : trapentry.traps)
            buffer.writeUnsignedShort(sum < 10000 ? ((trap > 0) ? sum += trap : 0) : 0);
        
        return buffer.getBuffer();
    }
}