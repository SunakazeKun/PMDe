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

package com.aurum.mystery2.exception;

import com.aurum.mystery2.Main;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class UncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        String thread = "Exception in thread " + t.getName();
        System.err.println(thread);
        e.printStackTrace(System.err);
        
        new UncaughtExceptionForm(t, e).setVisible(true);
    }
    
    private final class UncaughtExceptionForm extends JFrame {
        public UncaughtExceptionForm(Thread t, Throwable e) {
            JScrollPane pane = new JScrollPane();
            JTextArea text = new JTextArea();
            
            final StringWriter sw = new StringWriter();
            final PrintWriter pw = new PrintWriter(sw, true);
            e.printStackTrace(pw);
            
            text.setText(sw.getBuffer().toString());
            text.setEditable(false);
            text.setCaretPosition(0);
            pane.setViewportView(text);
            
            this.setResizable(false);
            this.setIconImage(Main.icon);
            this.setTitle(Main.name);
            this.setSize(600, 700);
            this.setLocationRelativeTo(null);
            this.add(pane);
        }
    }
}