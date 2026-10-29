package com.unpri.charactermanager;

import javax.swing.SwingUtilities;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;
import com.unpri.charactermanager.model.CharacterManager;
import com.unpri.charactermanager.view.MainWindow;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            CharacterManager manager = new CharacterManager();

            manager.addCharacter(
                    new Character("Regnar", 10, CharacterType.WARRIOR)
            );

            manager.addCharacter(
                    new Character("Arka", 15, CharacterType.WARRIOR)
            );

            manager.addCharacter(
                    new Character("Luna", 3, CharacterType.MAGE)
            );

            manager.addCharacter(
                    new Character("Raka", 5, CharacterType.WARRIOR)
            );

            manager.addCharacter(
                    new Character("Nara", 2, CharacterType.HEALER)
            );

            manager.addCharacter(
                    new Character("Kirana", 7, CharacterType.ARCHER)
            );

            manager.addCharacter(
                    new Character("Bima", 7, CharacterType.WARRIOR)
            );

            manager.addCharacter(
                    new Character("Maya", 7, CharacterType.MAGE)
            );

            MainWindow window = new MainWindow(manager);
            window.setVisible(true);
        });
    }
}