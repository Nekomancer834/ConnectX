package com.cx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.ui.*;

/**
 *
 * @author Trent
 */
public class TitleScreen implements Screen{
    protected final ConnectX game;
    OrthographicCamera camera;
    Button playButton;
    Button helpButton;
    Button quitButton;
    Stage titleStage;
    float shift = -600;
    float rightshift;
    public TitleScreen(final ConnectX game) {
        //assign reference to the original game class
        this.game = game;
        
        //set up camera
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1600, 900);
        titleStage = new Stage(game.viewport);
        Gdx.input.setInputProcessor(titleStage);
        
        
        //Main Menu Buttons
        playButton = new TextButton("PLAY",game.mySkin);
        playButton.setSize(600, 100);
        playButton.setPosition(shift, 220);
        playButton.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                //outputLabel.setText("Press a Button");
                System.out.println("button released");
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
        
        helpButton = new TextButton("HELP",game.mySkin);
        helpButton.setSize(600, 100);
        helpButton.setPosition(shift, 100);
        helpButton.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                System.err.println("no one can help you (yet)");
                
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
        
        quitButton = new TextButton("QUIT",game.mySkin, "right");
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
        Gdx.gl.glClearColor(.5f, 0f, 1f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        
        
        
        game.batch.draw(game.titleBackground,(titleStage.getWidth()/2)-(game.titleBackground.getWidth()/2),(titleStage.getHeight()/2)-(game.titleBackground.getHeight()/2));
        game.batch.draw(game.logo, 25, 750);
        
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
    }

    @Override
    public void hide() {
    }

    @Override
    public void dispose() {
        titleStage.dispose();
    }


   
    
}
