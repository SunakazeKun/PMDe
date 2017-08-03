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

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;

public class JMapPanel extends JPanel {
    private final Image background = Toolkit.getDefaultToolkit().createImage(JMapPanel.class.getResource("/res/map/bg.png"));
    private JMapPoint selectedPoint;
    
    public JMapPanel() {
        super.setLayout(null);
        selectedPoint = null;
    }
    
    public JMapPoint getSelected() {
        return selectedPoint;
    }
    
    public JMapPoint setSelected(int index) {
        if (selectedPoint != null)
            selectedPoint.setSelected(false);
        
        selectedPoint = (JMapPoint) getComponent(index);
        selectedPoint.setSelected(true);
        if (selectedPoint.getIndex() != index)
            System.out.println("WARNING! Point indexes are not equal!");
        
        return selectedPoint;
    }
    
    @Override
    public Component add(Component comp) {
        if (!(comp instanceof JMapPoint))
            return comp;
        
        super.add(comp);
        super.repaint();
        
        return comp;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        if (background == null)
            return;
        g.drawImage(background, 0, 0, this);
    }
}