package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Controller {
    SpriteBatch batch;
    Viewport viewport;
    Stage stage;
    Boolean AbutPr;
    Boolean BbutPr;
    Boolean leftPr;
    Boolean downPr;
    Boolean rightPr;
    Boolean upPr;
    OrthographicCamera cam = new OrthographicCamera();

    public Controller() {
        batch = new SpriteBatch();
        cam = new OrthographicCamera();
        viewport = new FitViewport(Gdx.graphics.getWidth(),Gdx.graphics.getHeight(),cam);
        stage = new Stage(viewport, batch);
        Gdx.input.setInputProcessor(stage);

        Table table = new Table();
        Table tableb = new Table();
        tableb.left().bottom();
        table.left().bottom();

        final Image upImg= new Image(new Texture("controller\\up.png"));
        upImg.setSize(85,85);
        upImg.addListener(new InputListener(){


            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                upPr=true;
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                upPr=false;
            }
        });

        final Image leftImg= new Image(new Texture("controller\\left.png"));
        leftImg.setSize(85,85);
        leftImg.addListener(new InputListener(){


            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                leftPr=true;
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                leftPr=false;
            }
        });

        final Image downImg= new Image(new Texture("controller\\down.png"));
        downImg.setSize(85,85);
        downImg.addListener(new InputListener(){


            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                downPr=true;
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                downPr=false;
            }
        });

        final Image rightImg= new Image(new Texture("controller\\right.png"));
        rightImg.setSize(85,85);
        rightImg.addListener(new InputListener(){


            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                rightPr=true;
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                rightPr=false;
            }
        });

        Image center = new Image(new Texture("controller\\center.png"));
        center.setSize(85,85);

        final Image Abutton= new Image(new Texture("controller\\buttonA.png"));
        Abutton.setSize(100,100);
        Abutton.addListener(new InputListener(){


            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                AbutPr=true;
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                AbutPr=false;
            }
        });

        final Image Bbutton= new Image(new Texture("controller\\buttunB.png"));
        Bbutton.setSize(100,100);
        Bbutton.addListener(new InputListener(){


            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                BbutPr=true;
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                BbutPr=false;
            }
        });

        Bbutton.setY(10);
        Bbutton.setX(Gdx.graphics.getWidth() - 230);
        Abutton.setX(Gdx.graphics.getWidth() - 130);
        Abutton.setY(110);


        table.add().padLeft(10);
        table.add(upImg).size(upImg.getWidth(), upImg.getHeight());
        table.add();

        table.row();

        table.add(leftImg).padLeft(10).size(leftImg.getWidth(), leftImg.getHeight());
        table.add(center).size(center.getWidth(), center.getHeight());
        table.add(rightImg).size(rightImg.getWidth(), rightImg.getHeight());

        table.row().padBottom(10);

        table.add().padLeft(10);
        table.add(downImg).size(downImg.getWidth(), downImg.getHeight());
        table.add();

        stage.addActor(table);
        stage.addActor(Abutton);
        stage.addActor(Bbutton);
    }

    public void draw() {
       stage.draw();

    }


    public Boolean getLeftPr() {
        return this.leftPr;
    }

    public Boolean getDownPr() {
        return this.downPr;
    }

    public Boolean getRightPr() {
        return this.rightPr;
    }

    public Boolean getUpPr() {
        return this.upPr;
    }

    public Boolean getAbutPr() {
        return AbutPr;
    }

    public Boolean getBbutPr() {
        return BbutPr;
    }

    public void dispose (){
        stage.dispose();
    }
}




