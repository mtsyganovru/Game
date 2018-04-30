package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;


public class Fight implements Screen {
    Secondgame game;
    static Controller controller;
    Texture img;
    int imgx;
    int imgy;
    OrthographicCamera cam;

    @Override
    public void show() {
        imgx = 0;
        imgy = 0;
        img = new Texture("button\\attack.png");
        game = new Secondgame();
        controller.upPr = false;
        controller.rightPr = false;
        controller.downPr = false;
        controller.leftPr = false;
        controller.BbutPr = false;
        game.createbatch();
        cam = new OrthographicCamera(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.2f, 0.4f, 0.5f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        cam.position.set(imgx,imgy,0);
        cam.update();
        game.batch.begin();
        game.batch.draw(img,imgx,imgy);
        game.batch.end();
        controller.draw();
    }

    public void handleInput() {
        if (controller.getUpPr()) {
            imgy+=2;
        }
        else if (controller.getDownPr()) {
            imgy-=2;
        }
        else if (controller.getLeftPr()) {
            imgx-=2;
        }
        else if (controller.getRightPr()) {
            imgx+=2;
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        img.dispose();
        game.batch.dispose();

    }

    public Fight(Secondgame game) {
        this.game = game;
    }
}
