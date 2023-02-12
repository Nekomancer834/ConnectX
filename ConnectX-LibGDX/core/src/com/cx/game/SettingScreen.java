/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;

/**
 *
 * @author Trent
 */
public class SettingScreen implements Screen {
    protected final ConnectX game;
    OrthographicCamera camera;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Slider playerCount;
    Slider boardScale;
    Slider goFeature;
    Image player1Color;
    Stage settingStage;
    Color[] temporaryColorArray = {Color.PURPLE, Color.PINK};
    float shift = -600;
    float rightshift;
    public SettingScreen(final ConnectX game) {
        this.game = game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1600, 900);
        settingStage = new Stage(game.viewport);
        Gdx.input.setInputProcessor(settingStage);
        
        button1 = new TextButton("BACK",game.mySkin);
        button1.setSize(400, 66);
        button1.setPosition(shift, 80);
        button1.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                //outputLabel.setText("Press a Button");
                System.out.println("button released");
                game.setScreen(new TitleScreen(game));
                dispose();
                
                
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("button pressed");
                
                return true;
            }
            @Override
            public void enter (InputEvent event, float x, float y, int pointer, Actor fromActor) {
                button1.moveBy(-shift, 0);
                
            }
            @Override
            public void exit (InputEvent event, float x, float y, int pointer, Actor fromActor) {
                button1.moveBy(shift, 0);
            }
        });
        button2 = new TextButton("TEST",game.mySkin);
        button2.setSize(400, 66);
        button2.setPosition(shift, 400);
        button2.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                //outputLabel.setText("Press a Button");
                System.out.println("loading test case: 2 players, one pink with id 1 and one purple with id 2");
                game.playerQueue.add(new Player(Color.PINK, 1, "player 1"));
                game.playerQueue.add(new Player(Color.PURPLE, 2, "player 2"));
                game.gameBoard = new Board(game, game.playerQueue, new int[12][14]);
                
                
                
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("button pressed");
                
                return true;
            }
            @Override
            public void enter (InputEvent event, float x, float y, int pointer, Actor fromActor) {
                button2.moveBy(-shift, 0);
                
            }
            @Override
            public void exit (InputEvent event, float x, float y, int pointer, Actor fromActor) {
                button2.moveBy(shift, 0);
            }
        });
        
        
        button4 = new TextButton("PLAY",game.mySkin, "right");
        button4.setSize(400, 66);
        button4.setPosition(settingStage.getWidth()-button4.getWidth()-shift, 80);
        button4.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                //outputLabel.setText("Press a Button");
                System.out.println("button released");
                
                //for(int i = 1; i<=playerCount.getValue(); i++){
                //    game.playerQueue.add(new Player(temporaryColorArray[i-1], i, "NYE"));    
                //}
                //System.out.println("# of players: "+game.playerQueue.size());
                //game.gameBoard = new Board(game, game.playerQueue, new int[6][7]);
                game.setScreen(new GameScreen(game));
                dispose();
                
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("button pressed");
                
                return true;
            }
            @Override
            public void enter (InputEvent event, float x, float y, int pointer, Actor fromActor) {
                button4.moveBy(shift, 0);
                
            }
            @Override
            public void exit (InputEvent event, float x, float y, int pointer, Actor fromActor) {
                button4.moveBy(-shift, 0);
            }
        });
        
        playerCount = new Slider(2, 6, 1, false, game.defaultSkin);
        playerCount.setSize(300, 21);
        playerCount.setPosition(784, 900-150);
        boardScale = new Slider(-2, 2, 1, false, game.defaultSkin);
        boardScale.setValue(0);
        boardScale.setSize(300, 21);
        boardScale.setPosition(784, 900-255);
        goFeature = new Slider(1, 3, 1, false, game.defaultSkin);
        goFeature.setSize(300, 21);
        goFeature.setPosition(784, 900-375);
        
        player1Color = new Image(game.gradientBar);
        player1Color.setPosition(20, 20);
        player1Color.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                
                
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("button pressed");
                temporaryColorArray[0] = colorPicker(x,y);
                button4.setColor(temporaryColorArray[0]);
                System.out.println("Color: "+temporaryColorArray[0].toString());
                return true;
            }
            @Override
            public void enter (InputEvent event, float x, float y, int pointer, Actor fromActor) {
                
                
            }
            @Override
            public void exit (InputEvent event, float x, float y, int pointer, Actor fromActor) {
                
            }
        });
        
        settingStage.addActor(button1);
        settingStage.addActor(button2);
        settingStage.addActor(button4);
        settingStage.addActor(playerCount);
        settingStage.addActor(boardScale);
        settingStage.addActor(goFeature);
        settingStage.addActor(player1Color);
        
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(.5f, 0f, 1f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        
        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();
        //game.batch.draw(game.settingBackground,0,0);
        game.batch.draw(game.settingBackground,0,0);
        game.batch.end();
        settingStage.act();
        
        if(shift<-30){
            shift += 40;
            if(shift>-30){
                shift=-30;
            }

            button1.setX(shift);
            button2.setX(shift);
            //button3.setX(shift);
            rightshift = settingStage.getWidth()-button4.getWidth()-shift;
            button4.setX(rightshift);
        }
        
        
        
        
        
        settingStage.draw();
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
    }
    
    private Color colorPicker(float x, float y){
        if (!game.gradientBar.getTextureData().isPrepared()) {
            game.gradientBar.getTextureData().prepare();
        }
        Pixmap pixmap = game.gradientBar.getTextureData().consumePixmap();
        game.gradientBar.getTextureData().disposePixmap();
        return new Color(pixmap.getPixel((int)x, (int)(pixmap.getHeight()-y)));
    }
}
