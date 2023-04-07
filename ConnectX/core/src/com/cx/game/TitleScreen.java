package com.cx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.ui.*;

/**
 *
 * @author Trent
 */
public class TitleScreen implements Screen{
    protected final ConnectX game;
    protected Screen thisScreen;
    protected OrthographicCamera camera;
    protected Button playButton;
    protected Button helpButton;
    protected Button quitButton;
    protected Stage titleStage;
    protected Image logoImage;
    protected float shift = -600;
    protected float rightshift;
    
    public TitleScreen(final ConnectX game) {
        //assign reference to the original game class
        this.game = game;
        this.thisScreen = this;
        //set up camera
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1600, 900);
        titleStage = new Stage(game.viewport);
        Gdx.input.setInputProcessor(titleStage);
        
        logoImage = new Image(game.logo);
        logoImage.setPosition(25, 900-15-game.logo.getHeight());
        logoImage.setScale(.8f);
        
        //Main Menu Buttons
        playButton = new TextButton("PLAY",game.mySkin, "Left");
        playButton.setSize(600, 100);
        playButton.setPosition(shift, 220);
        playButton.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(new SettingScreen(game));
                dispose();
                
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
            @Override
            public void enter (InputEvent event, float x, float y, int pointer, Actor fromActor) {
                playButton.moveBy(-shift, 0);
                
            }
            @Override
            public void exit (InputEvent event, float x, float y, int pointer, Actor fromActor) {
                playButton.moveBy(shift, 0);
            }
        });
        
        helpButton = new TextButton("HELP",game.mySkin, "Left");
        helpButton.setSize(600, 100);
        helpButton.setPosition(shift, 100);
        helpButton.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                //System.err.println("no one can help you (yet)");
                game.setScreen(new HelpScreen(game, thisScreen));
                
                
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
            @Override
            public void enter (InputEvent event, float x, float y, int pointer, Actor fromActor) {
                helpButton.moveBy(-shift, 0);
                
            }
            @Override
            public void exit (InputEvent event, float x, float y, int pointer, Actor fromActor) {
                helpButton.moveBy(shift, 0);
            }
        });
        
        quitButton = new TextButton("QUIT",game.mySkin, "Right");
        quitButton.setSize(400, 66);
        quitButton.setPosition(titleStage.getWidth()-quitButton.getWidth()-shift, 80);
        quitButton.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.exit();
                
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
            @Override
            public void enter (InputEvent event, float x, float y, int pointer, Actor fromActor) {
                quitButton.moveBy(shift, 0);
                
            }
            @Override
            public void exit (InputEvent event, float x, float y, int pointer, Actor fromActor) {
                quitButton.moveBy(-shift, 0);
            }
        });
        
        
        //Add Buttons to the stage
        titleStage.addActor(playButton);
        titleStage.addActor(helpButton);
        titleStage.addActor(quitButton);
    }

    @Override
    public void render(float delta) {
        camera.update();
        
        //the contents of render are drawn top first to bottom last so backgrounds should be drawn first
        //and active buttons/pieces are drawn later
        
        //textures and text
        game.batch.setProjectionMatrix(camera.combined);
        titleStage.act();
        game.batch.begin();
        
        //clear screen
        Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        
        
        
        game.batch.draw(game.titleBackground,(titleStage.getWidth()/2)-(game.titleBackground.getWidth()/2),(titleStage.getHeight()/2)-(game.titleBackground.getHeight()/2));
        
        
        //animating the buttons entering the screen
        //this animation is done wrong in that it needs to be in terms of frame rate so that 
        //the animations don't change if the game runs fast or slow
        if(shift<-30){
            shift += 40;
            if(shift>-30){
                shift=-30;
            }

            playButton.setX(shift);
            helpButton.setX(shift);
            rightshift = titleStage.getWidth()-quitButton.getWidth()-shift;
            quitButton.setX(rightshift);
        }
        
        
        titleStage.addActor(logoImage);
        
        //finish render
        game.batch.end();
        titleStage.draw();
    }

    @Override
    public void show() {
        
    }

    @Override
    public void resize(int width, int height) {
        titleStage.getViewport().update(width, height, true);
        rightshift = titleStage.getWidth()-quitButton.getWidth()-shift;
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
        Gdx.input.setInputProcessor(titleStage);
    }

    @Override
    public void hide() {
    }

    @Override
    public void dispose() {
        titleStage.dispose();
    }

   
    
}
