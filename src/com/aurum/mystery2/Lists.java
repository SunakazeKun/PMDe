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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Lists {
    private static List<String> populate(String filepath, int padlength) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(Lists.class.getResourceAsStream(filepath)));
        List<String> list = new ArrayList();
        
        String line;
        int index = 0;
        
        try {
            while ((line = reader.readLine()) != null)
                list.add(String.format("%0" + padlength + "X", index++) + ": " + line.trim());
        }
        catch (IOException ex) {
            System.out.println(ex);
        }
        
        return list;
    }
    
    static {
        pokemon = populate("/res/lists/pokemon.txt", 3);
        dungeons = populate("/res/lists/dungeons.txt", 2);
        areas = populate("/res/lists/areas.txt", 2);
        items = populate("/res/lists/items.txt", 2);
        types = populate("/res/lists/types.txt", 2);
        moves = populate("/res/lists/moves.txt", 3);
        abilities = populate("/res/lists/abilities.txt", 2);
    }
    
    public static List<String> dungeons, pokemon, items, types, moves, abilities, areas;
}