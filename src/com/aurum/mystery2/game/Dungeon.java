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
import java.util.List;
import com.aurum.mystery2.ByteBuffer;
import com.aurum.mystery2.ByteOrder;

public class Dungeon implements Cloneable {
    // Entry fields
    public boolean lvl1, noMoney, saveGame, recruitable;
    public short unk8, unkE;
    public byte unk1, unk3, unkB;
    public int timer;
    public short stairDirection, itemLimit, partyLimit;
    
    // Other fields
    public int mapX, mapY;
    public int floorsOffset;
    public short floorsCount;
    public List<Floor> floors = new ArrayList();
    
    // Static fields
    public static final int SIZE = 0x10;
    
    @Override
    public Object clone() {
        try {
            Dungeon clone = (Dungeon) super.clone();
            clone.floors = new ArrayList();
            for (Floor floor : floors)
                clone.floors.add((Floor) floor.clone());
            return clone;
        }
        catch (CloneNotSupportedException ex) {
            return null;
        }
    }
    
    public static Dungeon unpack(ByteBuffer buffer) {
        Dungeon dungeon = new Dungeon();
        
        dungeon.stairDirection = buffer.readUByte();
        dungeon.unk1 = buffer.readByte();
        dungeon.recruitable = buffer.readBoolean();
        dungeon.unk3 = buffer.readByte();
        dungeon.itemLimit = buffer.readUByte();
        dungeon.partyLimit = buffer.readUByte();
        dungeon.lvl1 = buffer.readBoolean();
        dungeon.noMoney = buffer.readBoolean();
        dungeon.unk8 = buffer.readShort();
        dungeon.saveGame = buffer.readBoolean();
        dungeon.unkB = buffer.readByte();
        dungeon.timer = buffer.readUShort();
        dungeon.unkE = buffer.readShort();
        
        return dungeon;
    }
    
    public static byte[] pack(Dungeon dungeon) {
        ByteBuffer buffer = new ByteBuffer(SIZE, ByteOrder.LITTLE_ENDIAN);
        
        buffer.writeUByte(dungeon.stairDirection);
        buffer.writeByte(dungeon.unk1);
        buffer.writeBoolean(dungeon.recruitable);
        buffer.writeByte(dungeon.unk3);
        buffer.writeUByte(dungeon.itemLimit);
        buffer.writeUByte(dungeon.partyLimit);
        buffer.writeBoolean(dungeon.lvl1);
        buffer.writeBoolean(dungeon.noMoney);
        buffer.writeShort(dungeon.unk8);
        buffer.writeBoolean(dungeon.saveGame);
        buffer.writeByte(dungeon.unkB);
        buffer.writeUShort(dungeon.timer);
        buffer.writeShort(dungeon.unkE);
        
        return buffer.getContent();
    }
}