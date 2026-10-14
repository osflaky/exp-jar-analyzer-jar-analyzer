/*
 * GPLv3 License
 *
 * Copyright (c) 2022-2026 4ra1n (Jar Analyzer Team)
 *
 * This project is distributed under the GPLv3 license.
 *
 * https://github.com/jar-analyzer/jar-analyzer/blob/master/LICENSE
 */

package me.n1ar4.jar.analyzer.gadget;

import me.n1ar4.jar.analyzer.gui.render.ZebraTableCellRenderer;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

@SuppressWarnings("all")
public class GadgetTableCellRender extends DefaultTableCellRenderer {
    private static final String BLUE_COLOR = "#007ACC";
    private static final String ORANGE_COLOR = "#FFA500";

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus,
                                                   int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (isSelected) {
            Color selBg = UIManager.getColor("Table.selectionBackground");
            Color selFg = UIManager.getColor("Table.selectionForeground");
            c.setBackground(selBg != null ? selBg : new Color(184, 207, 229));
            c.setForeground(selFg != null ? selFg : Color.BLACK);
        } else {
            Color base = UIManager.getColor("Table.background");
            if (base == null) base = table.getBackground();
            c.setBackground(row % 2 == 0 ? base : ZebraTableCellRenderer.zebraOdd(base));
            c.setForeground(table.getForeground());
        }

        if (value != null) {
            String text = value.toString();
            switch (column) {
                case 0:
                    setText("<html><font color='" + BLUE_COLOR + "'>" + text + "</font></html>");
                    break;
                case 1:
                    setText("<html><font color='" + ORANGE_COLOR + "'><strong>" + text + "</strong></font></html>");
                    break;
                case 2:
                    setText(text);
                    break;
                default:
                    setText(text);
            }
        }

        return c;
    }
}