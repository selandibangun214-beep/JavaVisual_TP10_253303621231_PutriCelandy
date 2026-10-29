package com.unpri.charactermanager.model;

import java.util.ArrayList;

public class CharacterManager {

    private final ArrayList<Character> characters = new ArrayList<>();

    // Menambahkan karakter dan menolak nama duplikat
    public boolean addCharacter(Character character) {

        if (character == null || character.getName() == null) {
            return false;
        }

        if (findByName(character.getName()) != null) {
            return false;
        }

        characters.add(character);
        return true;
    }

    // Mencari karakter berdasarkan nama
    public Character findByName(String name) {

        if (name == null) {
            return null;
        }

        for (Character character : characters) {
            if (character.getName() != null
                    && character.getName().equalsIgnoreCase(name)) {
                return character;
            }
        }

        return null;
    }

    // Menghapus karakter berdasarkan nama
    public boolean removeCharacter(String name) {

        Character character = findByName(name);

        if (character == null) {
            return false;
        }

        characters.remove(character);
        return true;
    }

    // Menghitung jumlah karakter
    public int getTotalCharacters() {
        return characters.size();
    }

    // Mengembalikan salinan daftar karakter (defensive copy)
    public ArrayList<Character> getAllCharacters() {
        return new ArrayList<>(characters);
    }

    // Menghitung rata-rata level karakter
    public double getAverageLevel() {

        if (characters.isEmpty()) {
            return 0.0;
        }

        int total = 0;

        for (Character character : characters) {
            total += character.getLevel();
        }

        return (double) total / characters.size();
    }

    // Mencari karakter berdasarkan tipe
    public ArrayList<Character> findByType(CharacterType type) {

        ArrayList<Character> result = new ArrayList<>();

        if (type == null) {
            return result;
        }

        for (Character character : characters) {
            if (character.getType() == type) {
                result.add(character);
            }
        }

        return result;
    }

    // Menghitung jumlah karakter berdasarkan tipe
    public int countByType(CharacterType type) {

        int count = 0;

        if (type == null) {
            return count;
        }

        for (Character character : characters) {
            if (character.getType() == type) {
                count++;
            }
        }

        return count;
    }
}