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

import static java.awt.GridBagConstraints.*;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class JPropertyPanel extends JPanel {
    protected int index;
    
    public JPropertyPanel() {
        super.setLayout(new GridBagLayout());
        super.setBorder(new EmptyBorder(8, 8, 8, 8));
        index = 0;
    }
    
    public void clear() {
        index = 0;
        removeAll();
        repaint();
    }
    
    private void prepareComponent(Component c) {
        if (c instanceof JTextField) ((JTextField) c).setColumns(20);
    }
    
    public void addCaption(String c) {
        JLabel l = new JLabel(c);
        l.setFont(l.getFont().deriveFont(Font.BOLD));
        add(l, new GridBagConstraints(0, index++, 3, 1, 1f, 0f, CENTER, HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
    }
    
    public void addComponent(Component c) {
        prepareComponent(c);
        
        add(c, new GridBagConstraints(0, index++, 3, 1, 0.4f, 0f, CENTER, HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
    }
    
    public void addComponent(JLabel l, Component c) {
        prepareComponent(c);
        
        add(l, new GridBagConstraints(0, index, 1, 1, 0.5f, 0f, LINE_START, NONE, new Insets(1, 1, 1, 1), 0, 0));
        add(c, new GridBagConstraints(1, index, 2, 1, 0.5f, 0f, CENTER, HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        index++;
    }
    
    public void addEditor(JLabel l, Component c, JButton b) {
        prepareComponent(c);
        
        add(l, new GridBagConstraints(0, index, 1, 1, 0.5f, 0f, LINE_START, NONE, new Insets(1, 1, 1, 1), 0, 0));
        add(c, new GridBagConstraints(1, index, 1, 1, 0.5f, 0f, CENTER, HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(b, new GridBagConstraints(2, index, 1, 1, 0.5f, 0f, CENTER, HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        index++;
    }
    
    public void addSeparator() {
        add(new JSeparator(), new GridBagConstraints(0, index++, 3, 1, 1f, 0f, LINE_START, HORIZONTAL, new Insets(12, 1, 12, 1), 0, 0));
    }
    
    public void addTerminator() {
        add(Box.createVerticalGlue(), new GridBagConstraints(0, index++, 3, 1, 1f, 1f, CENTER, BOTH, new Insets(1, 1, 1, 1), 0, 0));
    }
}