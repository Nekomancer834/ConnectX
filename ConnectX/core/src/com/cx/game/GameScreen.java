/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cx.game;

import java.util.HashMap;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;

/**
 *
 * @author Trent
 */
public class GameScreen implements Screen {
    
    protected final ConnectX game;
    protected Screen thisScreen;
    protected OrthographicCamera camera;
    protected Stage gameStage;
    protected float spacer;
    protected float gap;
    protected float x;
    protected float y;
    protected int temp;
    protected int iterator = 0;
    protected int hPieces;
    protected int vPieces;
    protected float shift1 = 0;
    protected float shift2 = 0;
    protected boolean flyoutFlag = false;
    protected boolean gameOver = false;
    protected Texture boardBlankTexture;
    protected Texture boardGoTexture;
    protected Label playerNameLabel1;
    protected Label playerNameLabel2;
    protected Label playerNameLabel3;
    protected Label playerNameLabel4;
    protected Label playerNameLabel5;
    protected Label playerNameLabel6;
    protected Label[] playerNameList = new Label[6];
    protected Label winnerName;
    protected TextButton helpButton;
    protected TextButton endGameButton;
    protected Image topBar;
    protected Image follower;
    protected Image flyout;
    protected Image gameOverBanner;
    
    public GameScreen(final ConnectX game) {
        this.game = game;
        this.thisScreen = this;
        
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1600, 900);
        gameStage = new Stage(game.viewport, game.batch);
        Gdx.input.setInputProcessor(gameStage);
        
        hPieces = game.gameBoard.getBoardWidth();
        vPieces = game.gameBoard.getBoardHeight();
        
        if(hPieces <= 7){
            boardBlankTexture = game.blank96Piece;
            boardGoTexture = game.go96Piece;
            follower = new Image(new SpriteDrawable(new Sprite(boardBlankTexture)));
        }else{
            boardBlankTexture = game.blank48Piece;
            boardGoTexture = game.go48Piece;
            follower = new Image(new SpriteDrawable(new Sprite(boardBlankTexture)));
        }
        
        
        follower.setPosition(-200, 850-(follower.getImageHeight()/2));
        follower.setColor(game.gameBoard.getPlayers().peek().getColor());
        
        
        topBar = new Image(game.blankBar);
        topBar.setPosition(0, 800);
        topBar.addListener(new InputListener(){
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                    switch(game.gameBoard.updateInternalGameBoard(temp, game.gameBoard.getPlayers().peek().peekNextPiece())){
                        case 0: gameOver = true;
                                break;
                        case 1: follower.setColor(game.gameBoard.getPlayers().peek().getColor());
                                break;
                        case 2: System.out.println("not a valid move");
                        default: break; 
                    }
                //in the future, only act on click if above board not to left or right
                //game.setScreen(new TitleScreen(game));
                //dispose();
                return true;
            }
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
            }
            @Override
            public void enter (InputEvent event, float x, float y, int pointer, Actor fromActor) {
            }
            @Override
            public boolean mouseMoved (InputEvent event, float x, float y) {
                temp = (int)((x-.5*spacer-gap)/(boardBlankTexture.getWidth()+gap));
                if(temp<hPieces && temp>=0){
                    follower.setPosition((float)((.5*spacer)+gap+(boardBlankTexture.getWidth()*temp)+(gap*(temp))),850-(follower.getImageHeight()/2));
                }else{
                    if(temp>hPieces)
                        temp=hPieces-1;
                    if(temp<0)
                        temp=0;
                }
                return true;
            }
               
            
        });
        
        gameOverBanner = new Image(game.gameOverBanner);
        gameOverBanner.setPosition(-1600, 0);
        gameOverBanner.addListener(new InputListener(){
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                game.playerQueue.clear();
                game.setScreen(new TitleScreen(game)); //move this and below to event handler for end game card
                dispose();
                //in the future, only act on click if above board not to left or right
                //game.setScreen(new TitleScreen(game));
                //dispose();
                return true;
            }
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
            }
            @Override
            public void enter (InputEvent event, float x, float y, int pointer, Actor fromActor) {
            }
            @Override
            public boolean mouseMoved (InputEvent event, float x, float y) {
                return true;
            }
               
            
        });
        
        flyout = new Image(game.flyoutBackground);
        flyout.setPosition(-600,0);
        flyout.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                flyoutFlag = !flyoutFlag;
                return true;
            }
            @Override
            public void enter (InputEvent event, float x, float y, int pointer, Actor fromActor) {
            }
            @Override
            public void exit (InputEvent event, float x, float y, int pointer, Actor fromActor) {
            }
        });
        
        helpButton = new TextButton("HELP",game.mySkin, "Left");
        helpButton.setSize(200, 33);
        helpButton.setPosition(-1600, 80);
        helpButton.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(new HelpScreen(game, thisScreen));
                
                
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                
                return true;
            }
            @Override
            public void enter (InputEvent event, float x, float y, int pointer, Actor fromActor) {
                shift1-=10;
                
            }
            @Override
            public void exit (InputEvent event, float x, float y, int pointer, Actor fromActor) {
                shift1+=10;
            }
        });
        
        endGameButton = new TextButton("END GAME",game.mySkin, "Left");
        endGameButton.setSize(200, 33);
        endGameButton.setPosition(-1600, 80);
        endGameButton.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                game.playerQueue.clear();
                game.setScreen(new TitleScreen(game)); //move this and below to event handler for end game card
                dispose();
                
                
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                
                return true;
            }
            @Override
            public void enter (InputEvent event, float x, float y, int pointer, Actor fromActor) {
                shift2-=10;
                
            }
            @Override
            public void exit (InputEvent event, float x, float y, int pointer, Actor fromActor) {
                shift2+=10;
            }
        });
        
        winnerName = new Label("", game.mySkin);
        winnerName.setPosition(0,0);
        winnerName.setAlignment(1);
        
        //this is super ugly... needs to change
        playerNameLabel1 = new Label("", game.mySkin);
        playerNameList[0] = playerNameLabel1;
        playerNameLabel2 = new Label("", game.mySkin);
        playerNameList[1] = playerNameLabel2;
        playerNameLabel3 = new Label("", game.mySkin);
        playerNameList[2] = playerNameLabel3;
        playerNameLabel4 = new Label("", game.mySkin);
        playerNameList[3] = playerNameLabel4;
        playerNameLabel5 = new Label("", game.mySkin);
        playerNameList[4] = playerNameLabel5;
        playerNameLabel6 = new Label("", game.mySkin);
        playerNameList[5] = playerNameLabel6;
        
        iterator = 0;
        for(Player x : game.playerQueue){
            playerNameList[iterator].setPosition(-100, 0);
            iterator++;
        }
        iterator = 0;
        
        
        

        gameStage.addActor(follower);
        gameStage.addActor(topBar);
        gameStage.addActor(flyout);
        gameStage.addActor(gameOverBanner);
        gameStage.addActor(helpButton);
        gameStage.addActor(endGameButton);
        gameStage.addActor(winnerName);
        gameStage.addActor(playerNameLabel1);
        gameStage.addActor(playerNameLabel2);
        gameStage.addActor(playerNameLabel3);
        gameStage.addActor(playerNameLabel4);
        gameStage.addActor(playerNameLabel5);
        gameStage.addActor(playerNameLabel6);
        
        
        
        
        
    }

    @Override
    public void show() {
        
    }

    @Override
    public void render(float delta) {
        //https://libgdx.com/wiki/graphics/2d/masking is a good resource for what I'm going to have to do for the board to have "gravity"
        
        //required screen start stuff
        camera.update();
        game.batch.setProjectionMatrix(camera.combined);
        
        
        
        gameStage.act();
        gameStage.getBatch().begin();
        
        //Game Screen bread and butter
        gameStage.getBatch().draw(game.gameBackground,0,0); //this background contains boxes and dimensions for laying out the real game graphics
        
        //draw the game board dots
        gap = (float)(800 - (boardBlankTexture.getHeight()*vPieces))/(vPieces+1);
        spacer = (float)1600-((boardBlankTexture.getWidth()*hPieces)+(gap*(hPieces+1)));
        
        gameStage.getBatch().setColor(Color.WHITE);
        for(int i = 0; i<game.gameBoard.getBoardHeight();i++){
            for(int j = 0; j<game.gameBoard.getBoardWidth();j++){
                gameStage.getBatch().setColor(game.gameBoard.getPlayerFromID(game.gameBoard.getInternalGameBoard()[i][j]).getColor()); //set this to change based on internal board ID
                
                x = (float)((.5*spacer)+gap+(boardBlankTexture.getWidth()*j)+(gap*(j)));
                y = (float)(800 - ((gap+(boardBlankTexture.getHeight()*i)+(gap*i))+boardBlankTexture.getHeight()));
                
                if(game.gameBoard.getInternalGameBoard()[i][j]<=6){
                    gameStage.getBatch().draw(boardBlankTexture, x, y);
                }else{
                    gameStage.getBatch().draw(boardGoTexture, x, y);
                }
            }
        }
        if(game.gameBoard.getPlayers().peek().peekNextPiece()<=6){
            if(hPieces > 7){
                follower.setDrawable(new SpriteDrawable(new Sprite(game.blank48Piece)));
            }else{
                follower.setDrawable(new SpriteDrawable(new Sprite(game.blank96Piece)));
            }
        }else{
            if(hPieces > 7){
                follower.setDrawable(new SpriteDrawable(new Sprite(game.go48Piece)));
            }else{
                follower.setDrawable(new SpriteDrawable(new Sprite(game.go96Piece)));
            }
        }
        
        gameStage.getBatch().setColor(Color.WHITE);
        
        
        //control flyout
        if(flyoutFlag){
            //move flyout x to -375 
            if(flyout.getX()>=-375)
                flyout.setX(-375);
            else
                flyout.setX(flyout.getX()+10);
        }else{
            //move flyout to -600
            if(flyout.getX()<=-600)
                flyout.setX(-600);
            else
                flyout.setX(flyout.getX()-10);
        }
        
        
        
        //draw the flyout above the background and board dots
        //but then below the contents "in" the flyout
        gameStage.getBatch().end();
        gameStage.draw();
        gameStage.getBatch().begin();
        
        
        //add things to flyout
        iterator = 0;
        for (Player x : game.playerQueue){
            gameStage.getBatch().setColor(x.getColor());
            playerNameList[iterator].setText(x.getName());
            playerNameList[iterator].setPosition(flyout.getX()+flyout.getWidth()-140, flyout.getY()+flyout.getHeight()-63-(68*iterator));
            helpButton.setPosition(flyout.getX()+flyout.getWidth()-315+shift1, flyout.getY()+163);
            endGameButton.setPosition(flyout.getX()+flyout.getWidth()-315+shift2, flyout.getY()+113);
            if(x.peekNextPiece()<=6){
                //draw player list dot and name
                gameStage.getBatch().draw(game.blank48Piece, flyout.getX()+flyout.getWidth()-70, flyout.getY()+flyout.getHeight()-20-(68*++iterator));
                
            }else{
                gameStage.getBatch().draw(game.go48Piece, flyout.getX()+flyout.getWidth()-70, flyout.getY()+flyout.getHeight()-20-(68*++iterator));;
                
            }
        }
        iterator = 0;
        //required screen end stuff
        
        gameStage.getBatch().setColor(Color.WHITE);
        gameStage.getBatch().end();
        
        if(gameOver){
            //move winner banner, winner message, and winner name to screen
            gameOverBanner.setPosition(0,0);
            switch(game.gameBoard.getWinnerID()){
                case 0:  winnerName.setText("draw");
                         break;
                default: winnerName.setText(game.gameBoard.getPlayerFromID(game.gameBoard.getWinnerID()).getName()+" wins");
            }
            
            winnerName.setFontScale(1.8f);
            winnerName.setPosition(800,430);
            iterator=0;
            for(Player x : game.playerQueue){
                playerNameList[iterator++].setText("");
            }
            iterator=0;
            helpButton.setPosition(-1600, 0);
            endGameButton.setPosition(-1600, 0);
            gameStage.draw(); //little secret: calling this here stops drawing the player list and that isn't intentional but who does it hurt? :P
        }else{
           gameOverBanner.setPosition(-1600,0); 
        }
        
    }

    @Override
    public void resize(int width, int height) {
        gameStage.getViewport().update(width, height, true);
    }

    @Override
    public void pause() {
        
    }

    @Override
    public void resume() {
        Gdx.input.setInputProcessor(gameStage);
    }

    @Override
    public void hide() {
        
    }

    @Override
    public void dispose() {
        gameStage.dispose();
    }
    
}
