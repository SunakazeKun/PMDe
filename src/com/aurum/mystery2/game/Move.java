package com.aurum.mystery2.game;

import com.aurum.mystery2.BitConverter;
import com.aurum.mystery2.ByteBuffer;
import com.aurum.mystery2.ByteOrder;

public class Move implements Cloneable {
    // Entry fields
    public int namePointer, descriptionPointer, logPointer;
    public int type;
    public String name, description, log;
    public short unk4, unk8, unkA, ap, range;
    public byte unkD, accuracy1, accuracy2, unk10, unk11, power, critical;
    public boolean unk14, unk15, unk16, unk17, unk18;
    
    // Static fields
    public static final int SIZE = 0x24;
    
    @Override
    public Object clone() {
        try {
            return super.clone();
        }
        catch (CloneNotSupportedException ex) {
            return null;
        } 
    }
    
    public static Move unpack(ByteBuffer buffer) {
        Move move = new Move();
        
        int nextOffset = buffer.position() + SIZE;
        
        // Fields
        move.namePointer = buffer.readInt();
        move.unk4 = buffer.readShort();
        move.type = buffer.readUShort();
        move.unk8 = buffer.readShort();
        move.unkA = buffer.readShort();
        move.ap = buffer.readUByte();
        move.unkD = buffer.readByte();
        move.accuracy1 = buffer.readByte();
        move.accuracy2 = buffer.readByte();
        move.unk10 = buffer.readByte();
        move.unk11 = buffer.readByte();
        move.power = buffer.readByte();
        move.critical = buffer.readByte();
        move.unk14 = buffer.readBoolean();
        move.unk15 = buffer.readBoolean();
        move.unk16 = buffer.readBoolean();
        move.unk17 = buffer.readBoolean();
        move.unk18 = buffer.readBoolean();
        move.range = buffer.readUByte();
        buffer.skip(0x2);
        move.descriptionPointer = buffer.readInt();
        move.logPointer = buffer.readInt();
        
        // Strings
        buffer.seek(BitConverter.pointerToOffset(move.namePointer));
        move.name = buffer.readString();
        buffer.seek(BitConverter.pointerToOffset(move.descriptionPointer));
        move.description = buffer.readString();
        buffer.seek(BitConverter.pointerToOffset(move.logPointer));
        move.log = buffer.readString();
        
        buffer.seek(nextOffset);
            
        return move;
    }
    
    public static byte[] pack(Move pokemon) {
        ByteBuffer buffer = new ByteBuffer(SIZE, ByteOrder.LITTLE_ENDIAN);
        return buffer.getContent();
    }
}