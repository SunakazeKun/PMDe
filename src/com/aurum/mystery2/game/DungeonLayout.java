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
    public boolean hasTerrainTiles, hasTerrainPond;
    public short no, tileset, music, weather, visibility, event;
    public short pokemonDensity, itemDensity, trapDensity, terrainDensity, stickyChance;
    public short moneyFactor, shopsFactor, monstersFactor;
    
    // Unknown fields
    public byte unk5;
    public int unk18;
    public boolean unk9, unkB, unkE;
    
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
        
        layout.layout1 = buffer.readUnsignedShort();
        layout.tileset = buffer.readUnsignedByte();
        layout.music = buffer.readUnsignedByte();
        layout.weather = buffer.readUnsignedByte();
        layout.unk5 = buffer.readByte();
        layout.pokemonDensity = buffer.readUnsignedByte();
        layout.shopsFactor = buffer.readUnsignedByte();
        layout.monstersFactor = buffer.readUnsignedByte();
        layout.unk9 = buffer.readBoolean();
        layout.stickyChance = buffer.readUnsignedByte();
        layout.unkB = buffer.readBoolean();
        layout.hasTerrainPond = buffer.readBoolean();
        layout.hasTerrainTiles = buffer.readBoolean();
        layout.unkE = buffer.readBoolean();
        layout.itemDensity = buffer.readUnsignedByte();
        layout.trapDensity = buffer.readUnsignedByte();
        layout.no = buffer.readUnsignedByte();
        layout.event = buffer.readUnsignedByte();
        layout.layout2 = buffer.readUnsignedShort();
        layout.terrainDensity = buffer.readUnsignedByte();
        layout.visibility = buffer.readUnsignedByte();
        layout.moneyFactor = buffer.readUnsignedByte();
        layout.unk18 = buffer.readInt();
        
        return layout;
    }
    
    public static byte[] pack(DungeonLayout layout) {
        ByteBuffer buffer = new ByteBuffer(SIZE, ByteOrder.LITTLE_ENDIAN);
        
        buffer.writeUnsignedShort(layout.layout1);
        buffer.writeUnsignedByte(layout.tileset);
        buffer.writeUnsignedByte(layout.music);
        buffer.writeUnsignedByte(layout.weather);
        buffer.writeByte(layout.unk5);
        buffer.writeUnsignedByte(layout.pokemonDensity);
        buffer.writeUnsignedByte(layout.shopsFactor);
        buffer.writeUnsignedByte(layout.monstersFactor);
        buffer.writeBoolean(layout.unk9);
        buffer.writeUnsignedByte(layout.stickyChance);
        buffer.writeBoolean(layout.unkB);
        buffer.writeBoolean(layout.hasTerrainPond);
        buffer.writeBoolean(layout.hasTerrainTiles);
        buffer.writeBoolean(layout.unkE);
        buffer.writeUnsignedByte(layout.itemDensity);
        buffer.writeUnsignedByte(layout.trapDensity);
        buffer.writeUnsignedByte(layout.no);
        buffer.writeUnsignedByte(layout.event);
        buffer.writeUnsignedShort(layout.layout2);
        buffer.writeUnsignedByte(layout.terrainDensity);
        buffer.writeUnsignedByte(layout.visibility);
        buffer.writeUnsignedByte(layout.moneyFactor);
        buffer.writeInt(layout.unk18);
        
        return buffer.getBuffer();
    }
}