package com.aurum.mystery2.game;

import com.aurum.mystery2.BitConverter;
import com.aurum.mystery2.ByteBuffer;
import com.aurum.mystery2.ByteOrder;

public class Move implements Cloneable {
    // Entry fields
    public String name, description, log, unk1, unk2, unk3;
    public int namePointer, descriptionPointer, logPointer, unk1Pointer, unk2Pointer, unk3Pointer;
    public int type;
    public short ap, range;
    public byte accuracy1, accuracy2, power, critical;
    
    // Unknown fields
    public byte unkD, unk10, unk11;
    public short unk4, unk8, unkA;
    public boolean unk14, unk15, unk16, unk17, unk18;
    
    // Static fields
    public static final int SIZE = 0x24;
    public static final int SIZE_JAP = 0x2C;
    
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
        
        boolean japanese = RomFile.current.isJapanese();
        int nextOffset = buffer.position() + (japanese ? SIZE_JAP : SIZE);
        
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
        
        if (japanese) {
            // Fields
            move.unk1Pointer = buffer.readInt();
            move.unk2Pointer = buffer.readInt();
            move.unk3Pointer = buffer.readInt();
            
            // Strings
            if (move.unk1Pointer != 0x00000000) {
                buffer.seek(BitConverter.pointerToOffset(move.unk1Pointer));
                move.unk1 = buffer.readString();
            }
            if (move.unk2Pointer != 0x00000000) {
                buffer.seek(BitConverter.pointerToOffset(move.unk2Pointer));
                move.unk2 = buffer.readString();
            }
            if (move.unk3Pointer != 0x00000000) {
                buffer.seek(BitConverter.pointerToOffset(move.unk3Pointer));
                move.unk3 = buffer.readString();
            }
        }
        
        // Strings
        if (move.namePointer != 0x00000000) {
            buffer.seek(BitConverter.pointerToOffset(move.namePointer));
            move.name = buffer.readString();
        }
        if (move.descriptionPointer != 0x00000000) {
            buffer.seek(BitConverter.pointerToOffset(move.descriptionPointer));
            move.description = buffer.readString();
        }
        if (move.logPointer != 0x00000000) {
            buffer.seek(BitConverter.pointerToOffset(move.logPointer));
            move.log = buffer.readString();
        }
        
        buffer.seek(nextOffset);
            
        return move;
    }
    
    public static byte[] pack(Move move) {
        boolean japanese = RomFile.current.isJapanese();
        
        ByteBuffer buffer = new ByteBuffer(japanese ? SIZE_JAP : SIZE, ByteOrder.LITTLE_ENDIAN);
        
        buffer.writeInt(move.namePointer);
        buffer.writeShort(move.unk4);
        buffer.writeUShort(move.type);
        buffer.writeShort(move.unk8);
        buffer.writeShort(move.unkA);
        buffer.writeUByte(move.ap);
        buffer.writeByte(move.unkD);
        buffer.writeByte(move.accuracy1);
        buffer.writeByte(move.accuracy2);
        buffer.writeByte(move.unk10);
        buffer.writeByte(move.unk11);
        buffer.writeByte(move.power);
        buffer.writeByte(move.critical);
        buffer.writeBoolean(move.unk14);
        buffer.writeBoolean(move.unk15);
        buffer.writeBoolean(move.unk16);
        buffer.writeBoolean(move.unk17);
        buffer.writeBoolean(move.unk18);
        buffer.writeUByte(move.range);
        buffer.writeShort((short) 0);
        buffer.writeInt(move.descriptionPointer);
        buffer.writeInt(move.logPointer);
        
        if (japanese) {
            buffer.writeInt(move.unk1Pointer);
            buffer.writeInt(move.unk2Pointer);
            buffer.writeInt(move.unk3Pointer);
        }
        
        return buffer.getContent();
    }
}