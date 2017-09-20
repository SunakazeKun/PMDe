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
    public boolean setLvl1, setNoMoney, setSaveGame, setRecruitable;
    public int timer;
    public short stair, itemLimit, partyLimit;
    public boolean hmFly, hmDive, hmWaterfall, hmSurf, typeWater;
    
    // Unknown fields
    public byte unk1;
    public short unk3, unkE;
    public boolean unk8, unk9;
    
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
        
        dungeon.stair = buffer.readUByte();
        dungeon.unk1 = buffer.readByte();
        dungeon.setRecruitable = buffer.readBoolean();
        dungeon.unk3 = buffer.readUByte();
        dungeon.itemLimit = buffer.readUByte();
        dungeon.partyLimit = buffer.readUByte();
        dungeon.setLvl1 = buffer.readBoolean();
        dungeon.setNoMoney = !buffer.readBoolean();
        dungeon.unk8 = buffer.readBoolean();
        dungeon.unk9 = buffer.readBoolean();
        dungeon.setSaveGame = !buffer.readBoolean();
        
        int condmask = buffer.readUByte();
        dungeon.hmFly = (condmask & 1) != 0;
        dungeon.hmDive = (condmask & 2) != 0;
        dungeon.hmWaterfall = (condmask & 4) != 0;
        dungeon.hmSurf = (condmask & 8) != 0;
        dungeon.typeWater = (condmask & 16) != 0;
        
        dungeon.timer = buffer.readUShort();
        dungeon.unkE = buffer.readShort();
        
        return dungeon;
    }
    
    public static byte[] pack(Dungeon dungeon) {
        ByteBuffer buffer = new ByteBuffer(SIZE, ByteOrder.LITTLE_ENDIAN);
        
        buffer.writeUByte(dungeon.stair);
        buffer.writeByte(dungeon.unk1);
        buffer.writeBoolean(dungeon.setRecruitable);
        buffer.writeUByte(dungeon.unk3);
        buffer.writeUByte(dungeon.itemLimit);
        buffer.writeUByte(dungeon.partyLimit);
        buffer.writeBoolean(dungeon.setLvl1);
        buffer.writeBoolean(!dungeon.setNoMoney);
        buffer.writeBoolean(dungeon.unk8);
        buffer.writeBoolean(dungeon.unk9);
        buffer.writeBoolean(!dungeon.setSaveGame);
        
        int condmask = 0;
        condmask ^= dungeon.hmFly ? 1 : 0;
        condmask ^= dungeon.hmDive ? 2 : 0;
        condmask ^= dungeon.hmWaterfall ? 4 : 0;
        condmask ^= dungeon.hmSurf ? 8 : 0;
        condmask ^= dungeon.typeWater ? 16 : 0;
        buffer.writeByte((byte) condmask);
        
        buffer.writeUShort(dungeon.timer);
        buffer.writeShort(dungeon.unkE);
        
        return buffer.getContent();
    }
}