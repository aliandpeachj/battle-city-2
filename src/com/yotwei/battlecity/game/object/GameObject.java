package com.yotwei.battlecity.game.object;

import java.awt.*;

/**
 * Created by YotWei on 2019/2/25.
 */
public abstract class GameObject {

    private static long idGenerator = 1000;

    protected GameObject(LevelContext lvlCtx) {
        levelContext = lvlCtx;

        // unique id generate by increasing long integer
        uid = idGenerator++;
    }

    private final LevelContext levelContext;

    /*
     * id is a unique long integer for every game object
     * it's generated by increasing long integer
     */
    private long uid;

    /*
     * tag of the object
     */
    private String tag;

    private boolean isActive;

    public long getUID() {
        return uid;
    }

    public LevelContext getLevelContext() {
        return levelContext;
    }

    public void setTag(String tagStr) {
        tag = tagStr;
    }

    public String getTag() {
        return tag;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public int hashCode() {
        return (int) uid;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof GameObject &&
                this.uid == ((GameObject) obj).uid;
    }

    /**
     * object update every frame
     */
    public abstract void update();

    /**
     * object draw every frame
     *
     * @param g a {@link Graphics2D} instance
     */
    public abstract void draw(Graphics2D g);

}