package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Secondgame extends Game {
    SpriteBatch batch;
    MyGdxGame walk;
    Fight fight;
    Menu menu;


    @Override
    public void create() {
        MyGdxGame.controller = new Controller();
        Fight.controller = new Controller();
        Menu.controller = new Controller();

        MyGdxGame.controller.AbutPr = false;
        Fight.controller.AbutPr = false;
        Menu.controller.AbutPr = false;

        batch = new SpriteBatch();
        menu = new Menu(this);
        fight = new Fight(this);
        walk = new MyGdxGame(this);
        setScreen(menu);

    }

    public void createbatch (){batch = new SpriteBatch();}

    @Override
    public void dispose() {
        super.dispose();
        batch.dispose();
    }

    @Override
    public void render() {
        if (Menu.controller.getAbutPr()){
            setScreen(walk);
            MyGdxGame.batchx = Gdx.graphics.getWidth()/2;
            MyGdxGame.batchy = Gdx.graphics.getHeight()/2;
        }
        if (MyGdxGame.controller.getAbutPr()){
            setScreen(fight);
        }
        if (Fight.controller.getAbutPr()){
            setScreen(walk);
        }
    }

}
