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

package com.aurum.mystery2.swing;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class JMapPoint extends JLabel {
    private boolean selected;
    private int x, y;
    private final int index;
    private final Icon mapIcon = new ImageIcon(getClass().getResource("/res/map/point.png"));
    private final Icon mapIconSelected = new ImageIcon(getClass().getResource("/res/map/pointSelected.png"));
    
    public JMapPoint(int index, int x, int y) {
        this.index = index;
        this.x = x;
        this.y = y;
        this.selected = false;
        setIcon(mapIcon);
        setBounds(x-5, y-5, 12, 12);
    }
    
    public int getIndex() {
        return index;
    }
    
    public int getPointX() {
        return x;
    }
    
    public void setPointX(int x) {
        this.x = x;
        setBounds(x-5, y-5, 12, 12);
        repaint();
    }
    
    public int getPointY() {
        return y;
    }
    
    public void setPointY(int y) {
        this.y = y;
        setBounds(x-5, y-5, 12, 12);
        repaint();
    }
    
    public boolean isSelected() {
        return selected;
    }
    
    public void setSelected(boolean b) {
        selected = b;
        setIcon(selected ? mapIconSelected : mapIcon);
        repaint();
    }
}