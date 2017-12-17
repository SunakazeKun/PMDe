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

import com.aurum.mystery2.Lists;
import com.aurum.mystery2.Main;
import com.aurum.mystery2.game.Dungeon;
import com.aurum.mystery2.game.RomFile;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class MapEditor extends AbstractEditor {
    private JMapPoint selected;
    private JMapPanel map;
    private JLabel lblX,lblY;
    private JSpinner spnX, spnY;
    
    @Override
    protected void initProperties() {
        setTitle("Map editor");
        
        // Initialize the components
        map = new JMapPanel();
        lblX = new JLabel("X");
        lblY = new JLabel("Y");
        spnX = new JSpinner();
        spnX.setModel(new SpinnerNumberModel(0, 0, 480, 1));
        spnX.addChangeListener((javax.swing.event.ChangeEvent evt) -> {
            selected.setPointX((int) spnX.getValue());
        });
        spnY = new JSpinner();
        spnY.setModel(new SpinnerNumberModel(0, 0, 320, 1));
        spnY.addChangeListener((javax.swing.event.ChangeEvent evt) -> {
            selected.setPointY((int) spnY.getValue());
        });
        
        // Add the components to the property panel
        properties.addComponent(map);
        properties.addLabeledComponent(lblX, spnX);
        properties.addLabeledComponent(lblY, spnY);
        properties.addTerminator();
        
        // Add map points
        for (int i = 0 ; i < 64 ; i++) {
            model.addElement(Lists.dungeons.get(i));
            
            Dungeon dungeon = (Dungeon) RomFile.current.dungeons.get(i).clone();
            JMapPoint point = new JMapPoint(i, dungeon.mapX, dungeon.mapY);
            point.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent evt) {
                    list.setSelectedIndex(point.getIndex());
                    list.ensureIndexIsVisible(point.getIndex());
                }
            });
            
            map.add(point);
        }
    }

    @Override
    protected void load() {
        int selectedIndex = list.getSelectedIndex();
        boolean enable = selectedIndex >= 0;
        spnX.setEnabled(enable);
        spnY.setEnabled(enable);
        
        if (!enable)
            return;
        
        selected = map.setSelected(selectedIndex);
        spnX.setValue(selected.getPointX());
        spnY.setValue(selected.getPointY());
    }

    @Override
    protected void save() {
        for (int i = 0 ; i < 64 ; i++) {
            Dungeon dungeon = RomFile.current.dungeons.get(i);
            dungeon.mapX = map.points().get(i).getPointX();
            dungeon.mapY = map.points().get(i).getPointY();
        }
    }

    @Override
    protected void warningLabel() {}
    
    private static class JMapPanel extends JPanel {
        private final Image background = Toolkit.getDefaultToolkit().createImage(Main.class.getResource("/res/map.png"));
        private List<JMapPoint> points;
        private JMapPoint selectedPoint;

        public JMapPanel() {
            super.setLayout(null);
            points = new ArrayList();
            super.setMinimumSize(new Dimension(480, 320));
            super.setMaximumSize(new Dimension(480, 320));
            super.setPreferredSize(new Dimension(480, 320));
        }
        
        public List<JMapPoint> points() {
            return points;
        }
        
        public JMapPoint getSelected() {
            return selectedPoint;
        }

        public JMapPoint setSelected(int index) {
            if (selectedPoint != null)
                selectedPoint.setSelected(false);

            selectedPoint = points.get(index);
            selectedPoint.setSelected(true);
            if (selectedPoint.getIndex() != index)
                System.out.println("WARNING! Point indexes are not equal!");

            return selectedPoint;
        }

        @Override
        public Component add(Component comp) {
            if (comp instanceof JMapPoint)
                points.add((JMapPoint) comp);

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
    
    private static class JMapPoint extends JLabel {
        private boolean selected;
        private int x, y;
        private final int index;
        private final Icon mapIcon = new ImageIcon(getClass().getResource("/res/mapPoint.png"));
        private final Icon mapIconSelected = new ImageIcon(getClass().getResource("/res/mapPointSelected.png"));

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

        public void setPointX(int val) {
            x = val;
            setBounds(x-5, y-5, 12, 12);
            repaint();
        }

        public int getPointY() {
            return y;
        }

        public void setPointY(int val) {
            y = val;
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
}