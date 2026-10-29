package com.unpri.charactermanager.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.List;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import com.unpri.charactermanager.model.CharacterManager;
import com.unpri.charactermanager.model.Character;

public class MainWindow extends JFrame {

    private final CharacterManager manager;

    private JPanel cardsPanel;
    private JLabel totalLabel;
    private JLabel averageLabel;

    public MainWindow(CharacterManager manager) {
        this.manager = manager;

        setTitle("Character Manager v0.4");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(700, 450));

        buildUI();
        refreshCharacters();

        setLocationRelativeTo(null);
    }

    private void buildUI() {

        JPanel root = new JPanel(new BorderLayout(12, 12));
        root.setBackground(AppTheme.BACKGROUND);
        root.setBorder(AppTheme.WINDOW_BORDER);

        JLabel titleLabel = new JLabel(
                "CHARACTER MANAGER",
                SwingConstants.CENTER
        );
        titleLabel.setFont(AppTheme.TITLE_FONT);
        titleLabel.setForeground(AppTheme.TEXT);

        totalLabel = new JLabel("Total karakter: 0");
        totalLabel.setFont(AppTheme.BODY_FONT);
        totalLabel.setForeground(AppTheme.TEXT);

        averageLabel = new JLabel("Rata-rata level: 0.00");
        averageLabel.setFont(AppTheme.BODY_FONT);
        averageLabel.setForeground(AppTheme.MUTED_TEXT);

        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.Y_AXIS));
        header.setBackground(AppTheme.BACKGROUND);

        header.add(titleLabel);
        header.add(Box.createVerticalStrut(12));
        header.add(totalLabel);
        header.add(averageLabel);

        cardsPanel = new JPanel(new GridLayout(0, 3, 12, 12));
        cardsPanel.setBackground(AppTheme.BACKGROUND);

        JScrollPane scrollPane = new JScrollPane(cardsPanel);
        scrollPane.getViewport().setBackground(AppTheme.BACKGROUND);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());

        root.add(header, BorderLayout.NORTH);
        root.add(scrollPane, BorderLayout.CENTER);

        setContentPane(root);
    }

    public void refreshCharacters() {

        cardsPanel.removeAll();

        List<Character> characters = manager.getAllCharacters();

        int totalLevel = 0;

        for (Character character : characters) {
            cardsPanel.add(createCharacterCard(character));
            totalLevel += character.getLevel();
        }

        totalLabel.setText(
                "Total karakter: " + characters.size()
        );

        double average = characters.isEmpty()
                ? 0.0
                : (double) totalLevel / characters.size();

        averageLabel.setText(
                String.format(
                        Locale.US,
                        "Rata-rata level: %.2f",
                        average
                )
        );

        cardsPanel.revalidate();
        cardsPanel.repaint();
    }

    private JPanel createCharacterCard(Character character) {

        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));

        Color roleColor = AppTheme.colorFor(character.getType());

        card.setBackground(roleColor);
        card.setBorder(AppTheme.borderFor(character.getType()));

        JLabel nameLabel = new JLabel(character.getName());
        nameLabel.setFont(AppTheme.LABEL_FONT);
        nameLabel.setForeground(AppTheme.TEXT);
        nameLabel.setAlignmentX(LEFT_ALIGNMENT);

        JLabel roleLabel = new JLabel(
                "Role: " + character.getType()
        );
        roleLabel.setFont(AppTheme.BODY_FONT);
        roleLabel.setForeground(AppTheme.TEXT);
        roleLabel.setAlignmentX(LEFT_ALIGNMENT);

        JLabel levelLabel = new JLabel(
                "Level: " + character.getLevel()
        );
        levelLabel.setAlignmentX(LEFT_ALIGNMENT);

        if (character.getLevel() >= AppTheme.HIGH_LEVEL_THRESHOLD) {
            levelLabel.setForeground(AppTheme.GOLD);
            levelLabel.setFont(
                    AppTheme.LEVEL_FONT.deriveFont(Font.BOLD)
            );
        } else {
            levelLabel.setForeground(AppTheme.TEXT);
            levelLabel.setFont(AppTheme.LEVEL_FONT);
        }

        // Properti tambahan 1: tooltip informasi karakter
        card.setToolTipText(
                "Nama: " + character.getName()
                + " | Role: " + character.getType()
                + " | Level: " + character.getLevel()
        );

        // Properti tambahan 2: nama kartu sebagai aksesibilitas
        card.getAccessibleContext().setAccessibleName(
                "Karakter " + character.getName()
        );

        card.add(nameLabel);
        card.add(Box.createVerticalStrut(8));
        card.add(roleLabel);
        card.add(Box.createVerticalStrut(5));
        card.add(levelLabel);

        return card;
    }
}