package com.kindachess.input;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Mouse
 */
public class Controls implements InputProcessor {
    private List<LeftClickObserver> leftClickObservers = new CopyOnWriteArrayList<>();
    private static Logger LOGGER = LoggerFactory.getLogger(InputProcessor.class);
    private static Controls instance;

    public static Controls getInstance() {
        if (instance == null) {
            instance = new Controls();
        }

        return instance;
    }

    public static void setInstance(Controls textureLoader) {
        instance = textureLoader;
    }

    public static void resetInstance() {
        instance = new Controls();
    }

    private Controls() {
        // Empty private initialiser to prevent duplicate instances
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if (button != Input.Buttons.LEFT || pointer > 0) {
            return false;
        }

        LOGGER.trace("Left click at: ({}, {})", screenX, screenY);
        for (LeftClickObserver observer : leftClickObservers) {
            observer.alertLeftClick(screenX, screenY);
        }
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

    public void addLeftClickObserver(LeftClickObserver observer) {
        LOGGER.trace("Adding left click observer {}", observer.getClass());
        leftClickObservers.add(observer);
    }
}