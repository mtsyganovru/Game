package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;


public class MyGdxGame implements Screen {
	Secondgame game;

	float elapsedTime;
	private Texture foranim;
	Animation<TextureRegion> redanimright,redanimup,redanimdown,redanimleft;
	Texture img;

	Sprite background;
	static int batchx ;
	static int batchy ;
	static Controller controller;
	OrthographicCamera cam;
	TextureRegion[][] tmpFrames;

	Texture house;

	private void CutTextures (){
		TextureRegion[] animationFrames;

		foranim=new Texture("redguy\\right.png");
		TextureRegion[][] tmpFrames = TextureRegion.split(foranim,22,33);
		animationFrames = new TextureRegion[4];

		int index = 0;
		for (int i = 0; i < 4; i++){
			for(int j = 0; j < 1; j++) {
				animationFrames[index++] = tmpFrames[j][i];
			}
		}

		redanimright = new Animation(1f/4f,animationFrames);

		foranim=new Texture("redguy\\left.png");
		tmpFrames = TextureRegion.split(foranim,22,33);
		animationFrames = new TextureRegion[4];

		index = 0;
		for (int i = 0; i < 4; i++){
			for(int j = 0; j < 1; j++) {
				animationFrames[index++] = tmpFrames[j][i];
			}
		}

		redanimleft = new Animation(1f/4f,animationFrames);

		foranim=new Texture("redguy\\up.png");
		tmpFrames = TextureRegion.split(foranim,23,35);
		animationFrames = new TextureRegion[4];

		index = 0;
		for (int i = 0; i < 4; i++){
			for(int j = 0; j < 1; j++) {
				animationFrames[index++] = tmpFrames[j][i];
			}
		}

		redanimup = new Animation(1f/4f,animationFrames);

		foranim=new Texture("redguy\\down.png");
		tmpFrames = TextureRegion.split(foranim,25,35);
		animationFrames = new TextureRegion[4];

		index = 0;
		for (int i = 0; i < 4; i++){
			for(int j = 0; j < 1; j++) {
				animationFrames[index++] = tmpFrames[j][i];
			}
		}

		redanimdown = new Animation(1f/4f,animationFrames);

	}

	public MyGdxGame() {
	}

	public void show() {
		game = new Secondgame();
		game.createbatch();
  		house = new Texture("badlogic.jpg");
		cam = new OrthographicCamera(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());


		background =new Sprite( new Texture("trava.png"));
		img =new Texture("redguy\\right3.png");

		controller.upPr = false;
		controller.rightPr = false;
		controller.downPr = false;
		controller.leftPr = false;

		controller.BbutPr = false;
		CutTextures();
	}

	@Override
	public void render(float delta) {
		{
			elapsedTime += Gdx.graphics.getDeltaTime();
			Gdx.gl.glClearColor(0.2f, 0.4f, 0.5f, 1);
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
			cam.position.set(batchx,batchy,0);
			cam.update();

			game.batch.begin();

			game.batch.setProjectionMatrix(cam.combined);
			background.draw(game.batch);
			game.batch.draw(house, Gdx.graphics.getWidth()/2 +50, Gdx.graphics.getHeight()/2 + 60);
			if (controller.getRightPr()||controller.getLeftPr()||controller.getDownPr()||controller.getUpPr())
				handleInput();
			else game.batch.draw(img,batchx,batchy);

			if (controller.getBbutPr()) {
				controller.dispose();
			}

			game.batch.end();
			controller.draw();

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
		dispose();
	}

	public void handleInput() {
		if (controller.getUpPr()) {
			if (background.getHeight() - Gdx.graphics.getHeight()/2 > batchy) batchy+=2;
			img = new Texture("redguy\\up3.png");
			game.batch.draw(redanimup.getKeyFrame(elapsedTime,true),batchx,batchy);

		}
		else if (controller.getDownPr()) {
			if (Gdx.graphics.getHeight()/2 < batchy) batchy-=2;
			img = new Texture("redguy\\down3.png");
			game.batch.draw(redanimdown.getKeyFrame(elapsedTime,true),batchx,batchy);

		}
		else if (controller.getLeftPr()) {
			if (Gdx.graphics.getWidth()/2 < batchx) batchx-=2;
			img = new Texture("redguy\\left3.png");
			game.batch.draw(redanimleft.getKeyFrame(elapsedTime,true),batchx,batchy);

		}
		else if (controller.getRightPr()) {
			if (background.getWidth() - Gdx.graphics.getHeight()/2 > batchx) batchx+=2;
			img = new Texture("redguy\\right3.png");
			game.batch.draw(redanimright.getKeyFrame(elapsedTime,true),batchx,batchy);

		}
	}

	public void dispose() {
		img.dispose();
		house.dispose();
		background.getTexture().dispose();
	}

    public MyGdxGame(Secondgame game) {
        this.game = game;
    }
}
