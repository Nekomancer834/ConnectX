/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.ui.*;

public class HelpScreen implements Screen{
    protected final ConnectX game;
    protected Screen callingScreen;
    protected OrthographicCamera camera;
    protected Stage helpStage;
    protected TextButton nextButton;
    protected TextButton lastButton;
    protected TextButton backButton;
    protected int helpPage;
    
    public HelpScreen(final ConnectX game, Screen lastScreen){
        //assign reference to the original game class
        this.game = game;
        this.callingScreen = lastScreen;
        //set up camera
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1600, 900);
        helpStage = new Stage(game.viewport);
        Gdx.input.setInputProcessor(helpStage);
        
        helpPage = 1;
        
        nextButton = new TextButton(">",game.mySkin, "Right");
        nextButton.setSize(200, 33);
        nextButton.setPosition(helpStage.getWidth()-nextButton.getWidth(), 80);
        nextButton.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                //move to next help background
                //if at x, don't do anything
                if(game.helpBackground.findRegion("helpBackground"+(helpPage+1))!=null)
                    helpPage++;
                
                
                //Gdx.app.exit();
                
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
            @Override
            public void enter (InputEvent event, float x, float y, int pointer, Actor fromActor) {
                
            }
            @Override
            public void exit (InputEvent event, float x, float y, int pointer, Actor fromActor) {
            }
        });
        
        lastButton = new TextButton("<",game.mySkin, "Left");
        lastButton.setSize(200, 33);
        lastButton.setPosition(0, 80);
        lastButton.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                //move to previous help background
                //if at 0, don't do anything
                if(game.helpBackground.findRegion("helpBackground"+(helpPage-1))!=null)
                    helpPage--;
                
                
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
            @Override
            public void enter (InputEvent event, float x, float y, int pointer, Actor fromActor) {
                
            }
            @Override
            public void exit (InputEvent event, float x, float y, int pointer, Actor fromActor) {
            }
        });
        
        backButton = new TextButton("BACK",game.mySkin, "Right");
        backButton.setSize(200, 33);
        backButton.setPosition(helpStage.getWidth()-nextButton.getWidth(), 40);
        backButton.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(callingScreen);
                callingScreen.resume();
                dispose();
                
                
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
            @Override
            public void enter (InputEvent event, float x, float y, int pointer, Actor fromActor) {
                
            }
            @Override
            public void exit (InputEvent event, float x, float y, int pointer, Actor fromActor) {
            }
        });
        
        helpStage.addActor(nextButton);
        helpStage.addActor(lastButton);
        helpStage.addActor(backButton);
    }
    
    @Override
    public void render(float delta){
        camera.update();
        
        //the contents of render are drawn top first to bottom last so backgrounds should be drawn first
        //and active buttons/pieces are drawn later
        
        //textures and text
        game.batch.setProjectionMatrix(camera.combined);
        helpStage.act();
        game.batch.begin();
        
        //clear screen
        Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        
        
        
        game.batch.draw(game.helpBackground.findRegion("helpBackground"+helpPage),(helpStage.getWidth()/2)-(game.titleBackground.getWidth()/2),(helpStage.getHeight()/2)-(game.titleBackground.getHeight()/2));
        
        
        game.batch.end();
        helpStage.draw();
    }
    @Override
    public void show() {
        
    }

    @Override
    public void resize(int width, int height) {
        helpStage.getViewport().update(width, height, true);
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
        helpStage.dispose();
    }
}
