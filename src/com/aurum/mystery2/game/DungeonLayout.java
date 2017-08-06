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
    public boolean hasTerrainUnknown9, hasTerrainUnknownB, hasTerrainTiles, hasTerrainPond, hasTerrainUnknownE;
    public short no, tileset, music, weather, visibility, event;
    public short pokemonDensity, itemDensity, trapDensity, terrainDensity;
    public short moneyFactor, shopsFactor, monstersFactor;
    
    // Unknown fields
    public byte unk5, unkA;
    public int unk18;
    
    // Static fields
    public static final int SIZE = 0x1C;
    
    @Override
    public Object clone() {
        try {
            return super.clone();
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
        layout.shopsFactor = buffer.readUByte();
        layout.monstersFactor = buffer.readUByte();
        layout.hasTerrainUnknown9 = buffer.readBoolean();
        layout.unkA = buffer.readByte();
        layout.hasTerrainUnknownB = buffer.readBoolean();
        layout.hasTerrainPond = buffer.readBoolean();
        layout.hasTerrainTiles = buffer.readBoolean();
        layout.hasTerrainUnknownE = buffer.readBoolean();
        layout.itemDensity = buffer.readUByte();
        layout.trapDensity = buffer.readUByte();
        layout.no = buffer.readUByte();
        layout.event = buffer.readUByte();
        layout.layout2 = buffer.readUShort();
        layout.terrainDensity = buffer.readUByte();
        layout.visibility = buffer.readUByte();
        layout.moneyFactor = buffer.readUByte();
        layout.unk18 = buffer.readInt();
        
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
        buffer.writeUByte(layout.shopsFactor);
        buffer.writeUByte(layout.monstersFactor);
        buffer.writeBoolean(layout.hasTerrainUnknown9);
        buffer.writeByte(layout.unkA);
        buffer.writeBoolean(layout.hasTerrainUnknownB);
        buffer.writeBoolean(layout.hasTerrainPond);
        buffer.writeBoolean(layout.hasTerrainTiles);
        buffer.writeBoolean(layout.hasTerrainUnknownE);
        buffer.writeUByte(layout.itemDensity);
        buffer.writeUByte(layout.trapDensity);
        buffer.writeUByte(layout.no);
        buffer.writeUByte(layout.event);
        buffer.writeUShort(layout.layout2);
        buffer.writeUByte(layout.terrainDensity);
        buffer.writeUByte(layout.visibility);
        buffer.writeUByte(layout.moneyFactor);
        buffer.writeInt(layout.unk18);
        
        return buffer.getContent();
    }
}