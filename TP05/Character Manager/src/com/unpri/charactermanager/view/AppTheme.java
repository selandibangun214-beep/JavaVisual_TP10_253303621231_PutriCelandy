package com.unpri.charactermanager.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

import com.unpri.charactermanager.model.CharacterType;

public final class AppTheme {

    private AppTheme() {
        // Mencegah pembuatan objek AppTheme
    }

    // Warna utama aplikasi
    public static final Color BACKGROUND = new Color(245, 247, 250);
    public static final Color TEXT = new Color(35, 40, 48);
    public static final Color MUTED_TEXT = new Color(100, 110, 125);
    public static final Color GOLD = new Color(184, 134, 11);

    // Batas level tinggi
    public static final int HIGH_LEVEL_THRESHOLD = 5;

    // Font aplikasi
    public static final Font TITLE_FONT =
            new Font("SansSerif", Font.BOLD, 22);

    public static final Font LABEL_FONT =
            new Font("SansSerif", Font.BOLD, 16);

    public static final Font BODY_FONT =
            new Font("SansSerif", Font.PLAIN, 13);

    public static final Font LEVEL_FONT =
            new Font("SansSerif", Font.PLAIN, 14);

    // Warna kartu berdasarkan role
    public static Color colorFor(CharacterType type) {

        if (type == CharacterType.WARRIOR) {
            return new Color(255, 220, 220);
        }

        if (type == CharacterType.MAGE) {
            return new Color(220, 230, 255);
        }

        if (type == CharacterType.ARCHER) {
            return new Color(220, 245, 225);
        }

        return Color.WHITE;
    }

    // Border kartu berdasarkan role
    public static Border borderFor(CharacterType type) {

        Color roleColor = colorFor(type);

        return BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(roleColor.darker(), 1),
                BorderFactory.createEmptyBorder(14, 14, 14, 14)
        );
    }

    // Border utama jendela
    public static final Border WINDOW_BORDER =
            BorderFactory.createEmptyBorder(16, 16, 16, 16);
}