package com.aurum.mystery2.game;

import com.aurum.mystery2.BitConverter;
import com.aurum.mystery2.ByteBuffer;
import com.aurum.mystery2.ByteOrder;

public class Move implements Cloneable {
    // Entry fields
    public String name, desc, log, japUnk1, japUnk2, japNext;
    public int namePointer, descPointer, logPointer, japUnk1Pointer, japUnk2Pointer, japNextPointer;
    public int type;
    public short ap, usesPerRound, range;
    public byte accuracy1, accuracy2, critical;
    
    // Unknown fields
    public byte unkD, unk10, unk12;
    public short unk4, unk8, unkA;
    public boolean unk14, unk15, unk16, unk17, unk18;
    
    // Static fields
    public static final int SIZE = 0x24;
    public static final int SIZE_JAP = 0x2C;
    
    @Override
    public String toString() {
        return name;
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
    
    public static Move unpack(ByteBuffer buffer) {
        Move move = new Move();
        
        int nextOffset = buffer.position() + (RomFile.current.isJapanese() ? SIZE_JAP : SIZE);
        
        // Fields
        if (RomFile.current.isJapanese()) {
            move.namePointer = buffer.readInt();
            move.unk4 = buffer.readShort();
            move.type = buffer.readUnsignedShort();
            move.unk8 = buffer.readShort();
            move.unkA = buffer.readShort();
            move.ap = buffer.readUnsignedByte();
            move.unkD = buffer.readByte();
            move.accuracy1 = buffer.readByte();
            move.accuracy2 = buffer.readByte();
            move.unk10 = buffer.readByte();
            move.usesPerRound = buffer.readUnsignedByte();
            move.unk12 = buffer.readByte();
            move.critical = buffer.readByte();
            move.unk14 = buffer.readBoolean();
            move.unk15 = buffer.readBoolean();
            move.unk16 = buffer.readBoolean();
            move.unk17 = buffer.readBoolean();
            move.unk18 = buffer.readBoolean();
            move.range = buffer.readUnsignedByte();
            buffer.skip(0x2);
            move.descPointer = buffer.readInt();
            move.japUnk1Pointer = buffer.readInt();
            move.japUnk2Pointer = buffer.readInt();
            move.logPointer = buffer.readInt();
            move.japNextPointer = buffer.readInt();
        }
        else {
            move.namePointer = buffer.readInt();
            move.unk4 = buffer.readShort();
            move.type = buffer.readUnsignedShort();
            move.unk8 = buffer.readShort();
            move.unkA = buffer.readShort();
            move.ap = buffer.readUnsignedByte();
            move.unkD = buffer.readByte();
            move.accuracy1 = buffer.readByte();
            move.accuracy2 = buffer.readByte();
            move.unk10 = buffer.readByte();
            move.usesPerRound = buffer.readUnsignedByte();
            move.unk12 = buffer.readByte();
            move.critical = buffer.readByte();
            move.unk14 = buffer.readBoolean();
            move.unk15 = buffer.readBoolean();
            move.unk16 = buffer.readBoolean();
            move.unk17 = buffer.readBoolean();
            move.unk18 = buffer.readBoolean();
            move.range = buffer.readUnsignedByte();
            buffer.skip(0x2);
            move.descPointer = buffer.readInt();
            move.logPointer = buffer.readInt();
        }
        
        // Strings
        if (move.namePointer != 0x00000000) move.name = buffer.readStringAt(BitConverter.pointerToOffset(move.namePointer));
        if (move.descPointer != 0x00000000) move.desc = buffer.readStringAt(BitConverter.pointerToOffset(move.descPointer));
        if (move.logPointer != 0x00000000) move.log = buffer.readStringAt(BitConverter.pointerToOffset(move.logPointer));
        if (move.japUnk1Pointer != 0x00000000) move.japUnk1 = buffer.readStringAt(BitConverter.pointerToOffset(move.japUnk1Pointer));
        if (move.japUnk2Pointer != 0x00000000) move.japUnk2 = buffer.readStringAt(BitConverter.pointerToOffset(move.japUnk2Pointer));
        if (move.japNextPointer != 0x00000000) move.japNext = buffer.readStringAt(BitConverter.pointerToOffset(move.japNextPointer));
        
        buffer.seek(nextOffset);
            
        return move;
    }
    
    public static byte[] pack(Move move) {
        ByteBuffer buffer = new ByteBuffer(RomFile.current.isJapanese() ? SIZE_JAP : SIZE, ByteOrder.LITTLE_ENDIAN);
        
        if (RomFile.current.isJapanese()) {
            buffer.writeInt(move.namePointer);
            buffer.writeShort(move.unk4);
            buffer.writeUnsignedShort(move.type);
            buffer.writeShort(move.unk8);
            buffer.writeShort(move.unkA);
            buffer.writeUnsignedByte(move.ap);
            buffer.writeByte(move.unkD);
            buffer.writeByte(move.accuracy1);
            buffer.writeByte(move.accuracy2);
            buffer.writeByte(move.unk10);
            buffer.writeUnsignedByte(move.usesPerRound);
            buffer.writeByte(move.unk12);
            buffer.writeByte(move.critical);
            buffer.writeBoolean(move.unk14);
            buffer.writeBoolean(move.unk15);
            buffer.writeBoolean(move.unk16);
            buffer.writeBoolean(move.unk17);
            buffer.writeBoolean(move.unk18);
            buffer.writeUnsignedByte(move.range);
            buffer.writeShort((short) 0);
            buffer.writeInt(move.descPointer);
            buffer.writeInt(move.japUnk1Pointer);
            buffer.writeInt(move.japUnk2Pointer);
            buffer.writeInt(move.logPointer);
            buffer.writeInt(move.japNextPointer);
        }
        else {
            buffer.writeInt(move.namePointer);
            buffer.writeShort(move.unk4);
            buffer.writeUnsignedShort(move.type);
            buffer.writeShort(move.unk8);
            buffer.writeShort(move.unkA);
            buffer.writeUnsignedByte(move.ap);
            buffer.writeByte(move.unkD);
            buffer.writeByte(move.accuracy1);
            buffer.writeByte(move.accuracy2);
            buffer.writeByte(move.unk10);
            buffer.writeUnsignedByte(move.usesPerRound);
            buffer.writeByte(move.unk12);
            buffer.writeByte(move.critical);
            buffer.writeBoolean(move.unk14);
            buffer.writeBoolean(move.unk15);
            buffer.writeBoolean(move.unk16);
            buffer.writeBoolean(move.unk17);
            buffer.writeBoolean(move.unk18);
            buffer.writeUnsignedByte(move.range);
            buffer.writeShort((short) 0);
            buffer.writeInt(move.descPointer);
            buffer.writeInt(move.logPointer);
        }
        
        return buffer.getBuffer();
    }
}