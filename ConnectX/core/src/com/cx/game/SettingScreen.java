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
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.kotcrab.vis.ui.widget.color.*;

/**
 *
 * @author Trent
 */
public class SettingScreen implements Screen {
    protected final ConnectX game;
    OrthographicCamera camera;
    Button backButton;
    Button playButton;
    Slider playerCount;
    Slider boardScale;
    Slider goFeature;
    BasicColorPicker player1Color;
    BasicColorPicker player2Color;
    BasicColorPicker player3Color;
    BasicColorPicker player4Color;
    BasicColorPicker player5Color;
    BasicColorPicker player6Color;
    Stage settingStage;
    Color[] ColorArray = new Color[6]; //this needs to go away for the final game
    float shift = -600;
    float rightshift;
    public SettingScreen(final ConnectX game) {
        this.game = game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1600, 900);
        settingStage = new Stage(game.viewport);
        Gdx.input.setInputProcessor(settingStage);
        
        backButton = new TextButton("BACK",game.mySkin, "Left");
        backButton.setSize(400, 66);
        backButton.setPosition(shift, 80);
        backButton.addListener(new InputListener(){
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
                backButton.moveBy(-shift, 0);
                
            }
            @Override
            public void exit (InputEvent event, float x, float y, int pointer, Actor fromActor) {
                backButton.moveBy(shift, 0);
            }
        });
        
        playButton = new TextButton("PLAY",game.mySkin, "Right");
        playButton.setSize(400, 66);
        playButton.setPosition(settingStage.getWidth()-playButton.getWidth()-shift, 80);
        playButton.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                for(int i = 1; i<= playerCount.getValue(); i++)
                    game.playerQueue.add(new Player(ColorArray[i-1], i, (int)goFeature.getValue(), "player "+(i)));
                switch((int)playerCount.getValue()){
                    case 2: game.gameBoard = new Board(game, game.playerQueue, (int)(7+boardScale.getValue()), (int)(6+boardScale.getValue()));
                            break;
                    case 3: game.gameBoard = new Board(game, game.playerQueue, (int)(11+boardScale.getValue()), (int)(9+boardScale.getValue()));
                            break;
                    case 4: game.gameBoard = new Board(game, game.playerQueue, (int)(14+boardScale.getValue()), (int)(12+boardScale.getValue()));
                            break;
                    case 5:
                    case 6: game.gameBoard = new Board(game, game.playerQueue, (int)(16+boardScale.getValue()), (int)(14+boardScale.getValue()));
                            break;
                    default: game.gameBoard = new Board(game, game.playerQueue, (int)((3.5*playerCount.getValue())+boardScale.getValue()), (int)((3*playerCount.getValue())+boardScale.getValue()));
                }
                //game.gameBoard = new Board(game, game.playerQueue, new int[(int)((3*playerCount.getValue())+boardScale.getValue())][(int)((3.5*playerCount.getValue())+boardScale.getValue())]);
                game.setScreen(new GameScreen(game));
                dispose();
                
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                
                return true;
            }
            @Override
            public void enter (InputEvent event, float x, float y, int pointer, Actor fromActor) {
                playButton.moveBy(shift, 0);
                
            }
            @Override
            public void exit (InputEvent event, float x, float y, int pointer, Actor fromActor) {
                playButton.moveBy(-shift, 0);
            }
        });
        
        playerCount = new Slider(2, 6, 1, false, game.mySkin);
        playerCount.setSize(300, 21);
        playerCount.setPosition(784, 900-120);
        boardScale = new Slider(-2, 2, 1, false, game.mySkin);
        boardScale.setValue(0);
        boardScale.setSize(300, 21);
        boardScale.setPosition(784, 900-225);
        goFeature = new Slider(0, 2, 1, false, game.mySkin);
        goFeature.setSize(300, 21);
        goFeature.setPosition(784, 900-345);
        //p1 colorpicker
        player1Color = new BasicColorPicker(
                       new ColorPickerAdapter(){
                           @Override
                           public void changed(Color newColor){
                               ColorArray[0] = newColor;
                           }
        });
        player1Color.setPosition(547, 380);
        player1Color.setColor(Color.RED);
        player1Color.setShowHexFields(false);
        //p2 colorpicker
        player2Color = new BasicColorPicker(
                       new ColorPickerAdapter(){
                           @Override
                           public void changed(Color newColor){
                               ColorArray[1] = newColor;
                           }
        });
        player2Color.setPosition(547+240, 380);
        player2Color.setColor(Color.YELLOW);
        player2Color.setShowHexFields(false);
        //p3 colorpicker
        player3Color = new BasicColorPicker(
                       new ColorPickerAdapter(){
                           @Override
                           public void changed(Color newColor){
                               ColorArray[2] = newColor;
                           }
        });
        player3Color.setPosition(547+480, 380);
        player3Color.setColor(Color.CYAN);
        player3Color.setShowHexFields(false);
        //p4 colorpicker
        player4Color = new BasicColorPicker(
                       new ColorPickerAdapter(){
                           @Override
                           public void changed(Color newColor){
                               ColorArray[3] = newColor;
                           }
        });
        player4Color.setPosition(547, 125);
        player4Color.setColor(Color.PURPLE);
        player4Color.setShowHexFields(false);
        //p5 colorpicker
        player5Color = new BasicColorPicker(
                       new ColorPickerAdapter(){
                           @Override
                           public void changed(Color newColor){
                               ColorArray[4] = newColor;
                           }
        });
        player5Color.setPosition(547+240, 125);
        player5Color.setColor(Color.PINK);
        player5Color.setShowHexFields(false);
        //p6 colorpicker
        player6Color = new BasicColorPicker(
                       new ColorPickerAdapter(){
                           @Override
                           public void changed(Color newColor){
                               ColorArray[5] = newColor;
                           }
        });
        player6Color.setPosition(547+480, 125);
        player6Color.setColor(Color.GREEN);
        player6Color.setShowHexFields(false);
        
        settingStage.addActor(backButton);
        settingStage.addActor(playButton);
        settingStage.addActor(playerCount);
        settingStage.addActor(boardScale);
        settingStage.addActor(goFeature);
        settingStage.addActor(player1Color);
        settingStage.addActor(player2Color);
        settingStage.addActor(player3Color);
        settingStage.addActor(player4Color);
        settingStage.addActor(player5Color);
        settingStage.addActor(player6Color);
        
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
        game.batch.draw(game.settingBackground,0,0);
        game.batch.end();
        settingStage.act();
        
        if(shift<-30){
            shift += 40;
            if(shift>-30){
                shift=-30;
            }

            backButton.setX(shift);
            rightshift = settingStage.getWidth()-playButton.getWidth()-shift;
            playButton.setX(rightshift);
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
        settingStage.dispose();
        player1Color.dispose();
        player2Color.dispose();
        player3Color.dispose();
        player4Color.dispose();
        player5Color.dispose();
        player6Color.dispose();
    }
}
