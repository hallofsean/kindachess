package com.kindachess.game;

import java.util.concurrent.ConcurrentHashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

/**
 * Singleton for storing instance of all textures to ensure all instance can be changed at once and minimise memory usage.
 */
public class TextureRegistry {
    private static TextureRegistry instance;
    private ConcurrentHashMap<String, Texture> textures;

    public static TextureRegistry getInstance() {
        if (instance == null) {
            instance = new TextureRegistry();
        }

        return instance;
    }

    public static void setInstance(TextureRegistry textureLoader) {
        instance = textureLoader;
    }

    public static void resetInstance() {
        instance.dispose();
        instance = new TextureRegistry();
    }

    /**
     * private constructor to add all textures to central library
     */
    private TextureRegistry() {
        textures = new ConcurrentHashMap<>();

        // Pieces
        //// Black Pieces
        addTexture("BK", "pieces/placeholder/BK.png"); // Black King
        addTexture("BQ", "pieces/placeholder/BQ.png"); // Black Queen
        addTexture("BKn", "pieces/placeholder/BKn.png"); // Black Knight
        addTexture("BB", "pieces/placeholder/BB.png"); // Black Bishop
        addTexture("BR", "pieces/placeholder/BR.png"); // Black Rook

        //// White pieces
        addTexture("WK", "pieces/placeholder/WK.png"); // White King
        addTexture("WQ", "pieces/placeholder/WQ.png"); // White Queen
        addTexture("WKn", "pieces/placeholder/WKn.png"); // White Knight
        addTexture("WB", "pieces/placeholder/WB.png"); // White Bishop
        addTexture("WR", "pieces/placeholder/WR.png"); // White Rook
    }

    private void addTexture(String name, String location) {
        textures.put(name, new Texture(Gdx.files.internal(location)));
    }

    public Texture getTexture(String name) {
        return textures.get(name);
    }

    public void dispose() {
        for (Texture texture: textures.values()) {
            texture.dispose();
        }

        textures = null;
    }
}