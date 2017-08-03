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

public class BitConverter {
    public static String toHexIntString(int value) {
        return String.format("%08X", value);
    }
    
    public static String toBinIntString(int value) {
        String ret = Integer.toBinaryString(value);
        while (ret.length() < 32)
            ret = '0' + ret;
        return ret;
    }
    
    public static int pointerToOffset(int pointer) {
        return pointer & 0x07FFFFFF;
    }
    
    public static int offsetToPointer(int offset) {
        return offset | 0x08000000;
    }
    
    public static byte[] reverse(byte[] data) {
        byte[] ret = new byte[data.length];
        for (int i = 0 ; i < data.length ; i++)
            ret[i] = data[data.length - 1 - i];
        return ret;
    }
    
    public static byte toByte(byte[] data, int offset) {
        return data[offset];
    }
    
    public static short toUByte(byte[] data, int offset) {
        return (short) (data[offset] & 0xFF);
    }
    
    public static short toShort(byte[] data, ByteOrder endian, int offset) {
        byte[] bytes = new byte[Short.BYTES];
        for (int i = 0 ; i < Short.BYTES ; i++)
            bytes[i] = data[i+offset];
        bytes = endian == ByteOrder.LITTLE_ENDIAN ? reverse(bytes) : bytes;
        return (short) (
                ((bytes[0] & 0xFF) << 8)
                | (bytes[1] & 0xFF)
                );
    }
    
    public static int toUShort(byte[] data, ByteOrder endian, int offset) {
        return (int) (toShort(data, endian, offset) & 0xFFFF);
    }
    
    public static int toInt(byte[] data, ByteOrder endian, int offset) {
        byte[] bytes = new byte[Integer.BYTES];
        for (int i = 0 ; i < Integer.BYTES ; i++)
            bytes[i] = data[i+offset];
        bytes = endian == ByteOrder.LITTLE_ENDIAN ? reverse(bytes) : bytes;
        return (int) (
                ((bytes[0] & 0xFF) << 24)
                | ((bytes[1] & 0xFF) << 16)
                | ((bytes[2] & 0xFF) << 8)
                | (bytes[3] & 0xFF)
                );
    }
    
    public static long toUInt(byte[] data, ByteOrder endian, int offset) {
        return (long) (toInt(data, endian, offset) & 0xFFFFFFFF);
    }
    
    public static long toLong(byte[] data, ByteOrder endian, int offset) {
        byte[] bytes = new byte[Long.BYTES];
        for (int i = 0 ; i < Long.BYTES ; i++)
            bytes[i] = data[i+offset];
        bytes = endian == ByteOrder.LITTLE_ENDIAN ? reverse(bytes) : bytes;
        return (long) (
                ((long) (bytes[0] & 0xFF) << 56)
                | ((long) (bytes[1] & 0xFF) << 48)
                | ((long) (bytes[2] & 0xFF) << 40)
                | ((long) (bytes[3] & 0xFF) << 32)
                | ((long) (bytes[4] & 0xFF) << 24)
                | ((long) (bytes[5] & 0xFF) << 16)
                | ((long) (bytes[6] & 0xFF) << 8)
                | (long) (bytes[7] & 0xFF)
                );
    }
    
    public static float toFloat(byte[] data, ByteOrder endian, int offset) {
        return Float.intBitsToFloat(toInt(data, endian, offset));
    }
    
    public static double toDouble(byte[] data, ByteOrder endian, int offset) {
        return Double.longBitsToDouble(toLong(data, endian, offset));
    }
    
    public static char toCharacter(byte[] data, ByteOrder endian, int offset) {
        return (char) toShort(data, endian, offset);
    }
    
    public static boolean toBoolean(byte[] data, int offset) {
        return data[offset] != 0;
    }
    
    public static byte[] getBytes(short val, ByteOrder endian) {
        byte[] bytes = new byte[Short.BYTES];
        bytes[0] = (byte) ((val >> 8) & 0xFF);
        bytes[1] = (byte) (val & 0xFF);
        return endian == ByteOrder.LITTLE_ENDIAN ? reverse(bytes) : bytes;
    }
    
    public static byte[] getBytes(int val, ByteOrder endian) {
        byte[] bytes = new byte[Integer.BYTES];
        bytes[0] = (byte) ((val >> 24) & 0xFF);
        bytes[1] = (byte) ((val >> 16) & 0xFF);
        bytes[2] = (byte) ((val >> 8) & 0xFF);
        bytes[3] = (byte) (val & 0xFF);
        return endian == ByteOrder.LITTLE_ENDIAN ? reverse(bytes) : bytes;
    }
    
    public static byte[] getBytes(long val, ByteOrder endian) {
        byte[] bytes = new byte[Long.BYTES];
        bytes[0] = (byte) ((val >> 56) & 0xFF);
        bytes[1] = (byte) ((val >> 48) & 0xFF);
        bytes[2] = (byte) ((val >> 40) & 0xFF);
        bytes[3] = (byte) ((val >> 32) & 0xFF);
        bytes[4] = (byte) ((val >> 24) & 0xFF);
        bytes[5] = (byte) ((val >> 16) & 0xFF);
        bytes[6] = (byte) ((val >> 8) & 0xFF);
        bytes[7] = (byte) (val & 0xFF);
        return endian == ByteOrder.LITTLE_ENDIAN ? reverse(bytes) : bytes;
    }
    
    public static byte[] getBytes(float val, ByteOrder endian) {
        return getBytes(Float.floatToIntBits(val), endian);
    }
    
    public static byte[] getBytes(double val, ByteOrder endian) {
        return getBytes(Double.doubleToLongBits(val), endian);
    }
    
    public static byte[] getBytes(char val, ByteOrder endian) {
        return getBytes((short) val, endian);
    }
    
    public static byte[] getBytes(boolean val) {
        return new byte[] { (byte) (val ? 1 : 0) };
    }
}