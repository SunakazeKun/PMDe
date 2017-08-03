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

public enum ByteOrder {
    BIG_ENDIAN    (new byte[] { (byte) 0xFE, (byte) 0xFF }),  // Left to right
    LITTLE_ENDIAN (new byte[] { (byte) 0xFF, (byte) 0xFE });  // Right to left
    
    private final byte[] identifier;
    private ByteOrder(byte[] identifier) {
        this.identifier = identifier;
    }
    
    /**
     * Returns the bytes identifier.
     * @return the bytes identifier.
     */
    public byte[] getIdentifier() {
        return identifier;
    }
    
    /**
     * Returns the byte order for the given identifier.
     * @param i the identifier
     * @return the byte order for the given identifier.
     */
    public static ByteOrder getByteOrder(byte[] i) {
        return (i == BIG_ENDIAN.identifier) ? BIG_ENDIAN :
                (i == LITTLE_ENDIAN.identifier) ? LITTLE_ENDIAN : null;
    }
}