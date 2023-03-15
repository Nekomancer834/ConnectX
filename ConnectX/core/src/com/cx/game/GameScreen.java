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
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;

/**
 *
 * @author Trent
 */
public class GameScreen implements Screen {
    
    ConnectX game;
    OrthographicCamera camera;
    Stage gameStage;
    float spacer;
    float gap;
    float x;
    float y;
    int temp;
    int iterator = 0;
    int hPieces;
    int vPieces;
    boolean flyoutFlag = false;
    Texture boardBlankTexture;
    Texture boardGoTexture;
    Image topBar;
    Image follower;
    Image flyout;
    public GameScreen(final ConnectX game) {
        this.game = game;
        
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
                //add piece to internal board
                //check win
                //cycle players
                //if(temp>0 || temp<hPieces){
                    switch(game.gameBoard.updateInternalGameBoard(temp, game.gameBoard.getPlayers().peek().peekNextPiece())){
                        case 0: game.playerQueue.clear();
                                game.setScreen(new TitleScreen(game));
                                dispose();
                                break;
                        case 1: follower.setColor(game.gameBoard.getPlayers().peek().getColor());
                                break;
                        case 2: System.out.println("not a valid move");
                        default: break; 
                    }
                //}
                
                
                //in the future, only act on click if above board not to left or right
                //game.setScreen(new TitleScreen(game));
                //dispose();
                return true;
            }
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                //outputLabel.setText("Press a Button");
                //System.out.println("secret bar released");
                //game.setScreen(new TitleScreen(game));
                //dispose();
            }
            @Override
            public void enter (InputEvent event, float x, float y, int pointer, Actor fromActor) {
                //System.out.println("secret bar entered");
            }
            @Override
            public boolean mouseMoved (InputEvent event, float x, float y) {
                //System.out.printf("Mouse X: %s\n",x);
                //System.out.printf("temp: %s spacer: %s gap: %s\n",temp,spacer,gap);
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
        

        gameStage.addActor(follower);
        gameStage.addActor(topBar);
        gameStage.addActor(flyout);
        
        
        
        
        
    }

    @Override
    public void show() {
        
    }

    @Override
    public void render(float delta) {
        //https://libgdx.com/wiki/graphics/2d/masking is a good resource for what I'm going to have to do for the board to have "gravity"
        
        //requried screen start stuff
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
            if(x.peekNextPiece()<=6){
                gameStage.getBatch().draw(game.blank48Piece, flyout.getX()+flyout.getWidth()-70, flyout.getY()+flyout.getHeight()-20-(68*++iterator));
            }else{
                gameStage.getBatch().draw(game.go48Piece, flyout.getX()+flyout.getWidth()-70, flyout.getY()+flyout.getHeight()-20-(68*++iterator));;
            }
            //flyoutPlayerIcon.setPosition(flyout.getX()+flyout.getWidth()-70, flyout.getY()+flyout.getHeight()-75-(68*++iterator));
            
            
        }

        //required screen end stuff
        
        gameStage.getBatch().setColor(Color.WHITE);
        gameStage.getBatch().end();
        
        
        
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
        
    }

    @Override
    public void hide() {
        
    }

    @Override
    public void dispose() {
        gameStage.dispose();
    }
    
}
