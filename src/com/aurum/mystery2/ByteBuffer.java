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

package com.aurum.mystery2;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashMap;

public class ByteBuffer {
    protected byte[] buffer;
    protected int position;
    protected ByteOrder endianness;
    protected HashMap<String, Integer> marks;
    private static final Charset CHARSET = Charset.forName("SJIS");
    
    public ByteBuffer() {
        buffer = new byte[0];
        endianness = ByteOrder.LITTLE_ENDIAN;
        marks = new HashMap();
    }
    
    public ByteBuffer(int length) {
        this();
        buffer = new byte[length];
    }
    
    public ByteBuffer(int length, ByteOrder endian) {
        this();
        buffer = new byte[length];
        endianness = endian;
    }
    
    public ByteBuffer(byte[] bytes) {
        this();
        buffer = bytes;
    }
    
    public ByteBuffer(byte[] bytes, ByteOrder endian) {
        this();
        buffer = bytes;
        endianness = endian;
    }
    
    /**
     * Returns a string representation.
     * @return a string representation.
     */
    @Override
    public String toString() {
        return "Size: " + buffer.length + ", Position: " + position;
    }
    
    /**
     * Returns the hash code value.
     * @return the hash code value.
     */
    @Override
    public int hashCode() {
        return Arrays.hashCode(buffer);
    }
    
    /**
     * Checks if another object is equal to this buffer.
     * @param o the other object
     * @return {@code true} if the both objects are equal.
     */
    @Override
    public boolean equals(Object o) {
        return (o instanceof ByteBuffer) ? hashCode() == o.hashCode() : false;
    }
    
    /**
     * Returns the content of this buffer.
     * @return the content of this buffer.
     */
    public byte[] getContent() {
        return buffer;
    }
    
    /**
     * Sets the content of this buffer.
     * @param bytes the new content
     */
    public void setContent(byte[] bytes) {
        buffer = bytes;
        position = 0;
        marks.clear();
    }
    
    /**
     * Returns the endianness.
     * @return the endianness.
     */
    public ByteOrder getEndianness() {
        return endianness;
    }
    
    /**
     * Sets the endianness.
     * @param endian the endianness
     */
    public void setEndianness(ByteOrder endian) {
        endianness = endian;
    }
    
    /**
     * Returns the size of this buffer.
     * @return the size of this buffer.
     */
    public int size() {
        return buffer.length;
    }
    
    /**
     * Returns the number of  bytes between the current position and the end
     * of the buffer.
     * @return the number of remaining bytes.
     */
    public int remaining() {
        return (position < buffer.length) ? buffer.length - position : 0;
    }
    
    /**
     * Checks if there are remaining bytes between the current position and
     * the end of the buffer.
     * @return {@code true} if the number of remaining bytes is greater than 0.
     */
    public boolean hasRemaining() {
        return remaining() > 0;
    }
    
    /**
     * Returns the current position.
     * @return the current position.
     */
    public int position() {
        return position;
    }
    
    /**
     * Sets the position.
     * @param newpos the new position
     */
    public void seek(int newpos) {
        if (newpos < 0)
            throw new IllegalArgumentException();
        position = newpos;
    }
    
    /**
     * Sets the current position to a mark.
     * If the mark does not exist, the position will not be changed.
     * @param key the mark key.
     */
    public void seek(String key) {
        position = marks.containsKey(key) ? marks.get(key) : position;
    }
    
    /**
     * Skips over {@code len} bytes of data.
     * @param len the number of bytes to be skipped.
     */
    public void skip(int len) {
        position += len;
    }
    
    public int indexOf(byte val, int off) {
        if (off < 0)
            throw new IllegalArgumentException("offset " + off + " is < than 0");
        
        while(off < buffer.length) {
            if (buffer[off] == val)
                return off;
            off++;
        }
        
        return -1;
    }
    
    /**
     * Returns the value of a marked position.
     * @param key the mark key.
     * @return the value of a marked position.
     */
    public int getMark(String key) {
        return marks.containsKey(key) ? marks.get(key) : 0;
    }
    
    /**
     * Marks the current position and assigns the key {@code key} to it.
     * @param key
     * @return the current position.
     */
    public int setMark(String key) {
        return addMark(key, position);
    }
    
    /**
     * Adds a new marked position and assigns the key {@code key} to it.
     * @param name the mark key.
     * @param pos the mark value.
     * @return the same value as {@code pos}.
     */
    public int addMark(String name, int pos) {
        if (pos < 0)
            throw new IllegalArgumentException("position " + pos + " < 0");
        
        if (marks.containsKey(name))
            marks.replace(name, pos);
        else
            marks.put(name, pos);
        
        return pos;
    }
    
    /**
     * Deletes an existing marked position.
     * @param key the key for the mark
     */
    public void deleteMark(String key) {
        if (marks.containsKey(key))
            marks.remove(key);
    }
    
    /**
     * Clears all marked positions.
     */
    public void clearMarks() {
        marks.clear();
    }
    
    /**
     * Clears the buffer, the resets the position to 0 and removes all marks.
     * The endianness remains untouched.
     * @param size the new size
     */
    public void allocate(int size) {
        if (size < 0)
            throw new IllegalArgumentException("new size " + size + " < 0");
        buffer = new byte[size];
        position = 0;
        marks.clear();
    }
    
    /**
     * Clears the buffer, the resets the position to 0 and removes all marks.
     * The endianness remains untouched.
     */
    public void clear() {
        allocate(0);
    }
    
    /**
     * Clears the bytes between the given indexes.
     * @param start the starting offset
     * @param end the end offset
     */
    public void clear(int start, int end) {
        if (start >= buffer.length || end >= buffer.length)
            throw new IllegalArgumentException("indexes out-of-bounds");
        if (end < start)
            throw new IllegalArgumentException("end index > start index");
        
        for ( ; start <= end ; start++)
            buffer[start] = (byte) 0x0;
    }
    
    /**
     * Extends this buffer by the specified number.
     * @param addsize the length that is added to the current length.
     */
    public void extend(int addsize) {
        if (addsize < 0)
            throw new IllegalArgumentException("addsize " + addsize + " < 0");
        if (addsize == 0)
            return;
        
        byte[] extended = new byte[buffer.length + addsize];
        System.arraycopy(buffer, 0, extended, 0, buffer.length);
        buffer = extended;
    }
    
    /**
     * Reads up to {@code len} bytes from this buffer.
     * @param len
     * @return An array of bytes.
     */
    public byte[] readBytes(int len) {
        if (len < 0)
            throw new IllegalArgumentException("negative length " + len);
        
        byte[] b = new byte[len];
        if (remaining() >= len && len != 0) {
            for (int c = 0 ; c < len ; c++)
                b[c] = buffer[position++];
        }
        return b;
    }
    
    /**
     * Reads up all remaining bytes.
     * @return an array of all remaining bytes.
     */
    public byte[] readRemaining() {
        return readBytes(remaining());
    }
    
    /**
     * Reads the next byte from this buffer.
     * @return the 8-bit value.
     */
    public byte readByte() {
        return (remaining() >= Byte.BYTES) ? buffer[position++] : 0;
    }
    
    /**
     * Reads the next unsigned byte from this buffer.
     * @return the unsigned 8-bit value.
     */
    public short readUByte() {
        return (short) (readByte() & 0xFF);
    }
    
    /**
     * Reads the next short value from this buffer.
     * @return the 16-bit value.
     */
    public short readShort() {
        return (remaining() >= Short.BYTES) ? BitConverter.toShort(readBytes(Short.BYTES), endianness, 0) : 0;
    }
    
    /**
     * Reads the next unsigned short value from this buffer.
     * @return the unsigned 16-bit value.
     */
    public int readUShort() {
        return (remaining() >= Short.BYTES) ? BitConverter.toUShort(readBytes(Short.BYTES), endianness, 0) : 0;
    }
    
    /**
     * Reads the next int value from this buffer.
     * @return the 32-bit value.
     */
    public int readInt() {
        return (remaining() >= Integer.BYTES) ? BitConverter.toInt(readBytes(Integer.BYTES), endianness, 0) : 0;
    }
    
    /**
     * Reads the next unsigned int value from this buffer.
     * @return the unsigned 32-bit value.
     */
    public long readUInt() {
        return (remaining() >= Integer.BYTES) ? BitConverter.toUInt(readBytes(Integer.BYTES), endianness, 0) : 0;
    }
    
    /**
     * Reads the next long value from the buffer.
     * @return the 64-bit value.
     */
    public long readLong() {
        return (remaining() >= Long.BYTES) ? BitConverter.toLong(readBytes(Long.BYTES), endianness, 0) : 0;
    }
    
    /**
     * Reads the next float value from the buffer.
     * @return the float value.
     */
    public float readFloat() {
        return (remaining() >= Float.BYTES) ? BitConverter.toFloat(readBytes(Float.BYTES), endianness, 0) : 0;
    }
    
    /**
     * Reads the next double value from the buffer.
     * @return the double value.
     */
    public double readDouble() {
        return (remaining() >= Double.BYTES) ? BitConverter.toDouble(readBytes(Double.BYTES), endianness, 0) : 0;
    }
    
    /**
     * Reads the next Unicode char from the buffer.
     * @return the Unicode char.
     */
    public char readCharacter() {
        return (remaining() >= Character.BYTES) ? BitConverter.toCharacter(readBytes(Character.BYTES), endianness, 0) : 0;
    }
    
    /**
     * Reads the next boolean value from the buffer.
     * @return the boolean value.
     */
    public boolean readBoolean() {
        return readByte() != 0;
    }
    
    /**
     * Reads the next String from the buffer.
     * @param charset the charset
     * @param len the length of the String
     * @return the String.
     */
    public String readString(Charset charset, int len) {
        return (len > 0) ? new String(readBytes(len), charset) : new String();
    }
    
    /**
     * Reads the next String from the buffer.
     * @param len the length of the String
     * @return the String.
     */
    public String readString(int len) {
        return readString(CHARSET, len);
    }
    
    /**
     * Decodes and returns the next null-terminated String from the buffer.
     * @param charset
     * @return A string.
     */
    public String readString(Charset charset) {
        return readString(charset, indexOf((byte) 0, position) - position);
    }
    
    /**
     * Decodes and returns the next null-terminated String from the buffer.
     * @return A string.
     */
    public String readString() {
        return readString(CHARSET);
    }
    
    /**
     * Returns the next pointer as an offset
     * @return an offset
     */
    public int readPointerAsOffset() {
        return BitConverter.pointerToOffset(readInt());
    }
    
    /**
     * Writes the content of the specified byte array to this buffer.
     * @param val the byte array
     */
    public void writeBytes(byte[] val) {
        if (position + val.length > buffer.length)
            extend(val.length);
        for (byte b : val)
            buffer[position++] = b;
    }
    
    /**
     * Writes the specified byte to this buffer.
     * @param val the 8-bit integer value
     */
    public void writeByte(byte val) {
        if (position + 1 > buffer.length)
            extend(1);
        buffer[position++] = val;
    }
    
    /**
     * Writes the specified unsigned byte to this buffer.
     * @param val the unsigned 8-bit integer value
     */
    public void writeUByte(short val) {
        writeByte((byte) val);
    }
    
    /**
     * Writes the specified short value to this buffer.
     * @param val the 16-bit integer value
     */
    public void writeShort(short val) {
        writeBytes(BitConverter.getBytes(val, endianness));
    }
    
    /**
     * Writes the specified unsigned short value to this buffer.
     * @param val the unsigned 16-bit integer value
     */
    public void writeUShort(int val) {
        writeShort((short) val);
    }
    
    /**
     * Writes the specified int value to this buffer.
     * @param val the 32-bit integer value
     */
    public void writeInt(int val) {
        writeBytes(BitConverter.getBytes(val, endianness));
    }
    
    /**
     * Writes the specified unsigned int value to this buffer.
     * @param val the unsigned 32-bit integer value
     */
    public void writeUInt(long val) {
        writeInt((int) val);
    }
    
    /**
     * Writes the specified long value to this buffer.
     * @param val the 64-bit integer value
     */
    public void writeLong(long val) {
        writeBytes(BitConverter.getBytes(val, endianness));
    }
    
    /**
     * Writes the specified float value to this buffer.
     * @param val the float value
     */
    public void writeFloat(float val) {
        writeBytes(BitConverter.getBytes(val, endianness));
    }
    
    /**
     * Writes the specified double value to this buffer.
     * @param val the double value
     */
    public void writeDouble(double val) {
        writeBytes(BitConverter.getBytes(val, endianness));
    }
    
    /**
     * Writes a Unicode char to this buffer.
     * @param val the Unicode char
     */
    public void writeCharacter(char val) {
        writeBytes(BitConverter.getBytes(val, endianness));
    }
    
    /**
     * Writes a boolean value to this buffer.
     * @param val the boolean value
     */
    public void writeBoolean(boolean val) {
        writeByte((byte) (val ? 1 : 0));
    }
    
    /**
     * Writes a String to this buffer.
     * @param val the String
     * @param charset the charset
     * @return the offset to this String.
     */
    public int writeString(String val, Charset charset) {
        int pos = position;
        writeBytes(val.getBytes(charset));
        writeByte((byte) 0x0);
        return pos;
    }
    
    /**
     * Writes a String to this buffer.
     * @param val the String
     * @return the offset to this String.
     */
    public int writeString(String val) {
        return writeString(val, CHARSET);
    }
    
    public void writeOffsetAsPointer(int val) {
        writeInt(BitConverter.offsetToPointer(val));
    }
}