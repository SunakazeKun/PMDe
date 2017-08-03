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

public class DungeonLayout implements Cloneable {
    // Entry fields
    public int layout1, layout2;
    public byte unk5, unkE;
    public byte[] unk9, unk18;
    public boolean useTerrainTiles;
    
    public short kecleonShopsFactor, monsterRoomsFactor;
    public short tileset, music, weather, event;
    public short no, visibility, money, pokemonDensity, itemDensity, trapDensity, terrainDensity;
    
    // Static fields
    public static final int SIZE = 0x1C;
    
    @Override
    public Object clone() {
        try {
            DungeonLayout clone = (DungeonLayout) super.clone();
            clone.unk9 = new byte[0x4];
            clone.unk18 = new byte[0x4];
            System.arraycopy(unk9, 0, clone.unk9, 0, 0x4);
            System.arraycopy(unk18, 0, clone.unk18, 0, 0x4);
            return clone;
        }
        catch (CloneNotSupportedException ex) {
            return null;
        }
    }
    
    public static DungeonLayout unpack(ByteBuffer buffer) {
        DungeonLayout layout = new DungeonLayout();
        
        layout.layout1 = buffer.readUShort();
        layout.tileset = buffer.readUByte();
        layout.music = buffer.readUByte();
        layout.weather = buffer.readUByte();
        layout.unk5 = buffer.readByte();
        layout.pokemonDensity = buffer.readUByte();
        layout.kecleonShopsFactor = buffer.readUByte();
        layout.monsterRoomsFactor = buffer.readUByte();
        layout.unk9 = buffer.readBytes(0x4);
        layout.useTerrainTiles = buffer.readBoolean();
        layout.unkE = buffer.readByte();
        layout.itemDensity = buffer.readUByte();
        layout.trapDensity = buffer.readUByte();
        layout.no = buffer.readUByte();
        layout.event = buffer.readUByte();
        layout.layout2 = buffer.readUShort();
        layout.terrainDensity = buffer.readUByte();
        layout.visibility = buffer.readUByte();
        layout.money = buffer.readUByte();
        layout.unk18 = buffer.readBytes(0x4);
        
        return layout;
    }
    
    public static byte[] pack(DungeonLayout layout) {
        ByteBuffer buffer = new ByteBuffer(SIZE, ByteOrder.LITTLE_ENDIAN);
        
        buffer.writeUShort(layout.layout1);
        buffer.writeUByte(layout.tileset);
        buffer.writeUByte(layout.music);
        buffer.writeUByte(layout.weather);
        buffer.writeByte(layout.unk5);
        buffer.writeUByte(layout.pokemonDensity);
        buffer.writeUByte(layout.kecleonShopsFactor);
        buffer.writeUByte(layout.monsterRoomsFactor);
        buffer.writeBytes(layout.unk9);
        buffer.writeBoolean(layout.useTerrainTiles);
        buffer.writeByte(layout.unkE);
        buffer.writeUByte(layout.itemDensity);
        buffer.writeUByte(layout.trapDensity);
        buffer.writeUByte(layout.no);
        buffer.writeUByte(layout.event);
        buffer.writeUShort(layout.layout2);
        buffer.writeUByte(layout.terrainDensity);
        buffer.writeUByte(layout.visibility);
        buffer.writeUByte(layout.money);
        buffer.writeBytes(layout.unk18);
        
        return buffer.getContent();
    }
}