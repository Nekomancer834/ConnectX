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
    int hPieces = 7;
    int vPieces = 6;
    Image topBar;
    Image follower;
    public GameScreen(final ConnectX game) {
        this.game = game;
        
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1600, 900);
        gameStage = new Stage(game.viewport);
        Gdx.input.setInputProcessor(gameStage);
        
        
        follower = new Image(new SpriteDrawable(new Sprite(game.goPiece)));
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
                //if(temp<0 || temp>game.gameBoard.getBoardWidth()){
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
                temp = (int)((x-.5*spacer-gap)/(game.blank96Piece.getWidth()+gap));
                if(temp<hPieces & temp>=0)
                    follower.setPosition((float)((.5*spacer)+gap+(game.blank96Piece.getWidth()*temp)+(gap*(temp))),850-(follower.getImageHeight()/2));
                return true;
            }
               
            
        });
        
        gameStage.addActor(follower);
        gameStage.addActor(topBar);
        
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
        game.batch.begin();
        
        //Game Screen bread and butter
        game.batch.draw(game.gameBackground,0,0); //this background contains boxes and dimensions for laying out the real game graphics
        
        
        
        
        //draw the game board dots
        gap = (float)(800 - (game.blank96Piece.getHeight()*vPieces))/(vPieces+1);
        spacer = (float)1600-((game.blank96Piece.getWidth()*hPieces)+(gap*(hPieces+1)));
        
        game.batch.setColor(Color.WHITE);
        for(int i = 0; i<game.gameBoard.getBoardHeight();i++){
            for(int j = 0; j<game.gameBoard.getBoardWidth();j++){
                game.batch.setColor(game.gameBoard.getPlayerFromID(game.gameBoard.getInternalGameBoard()[i][j]).getColor()); //set this to change based on internal board ID
                
                x = (float)((.5*spacer)+gap+(game.blank96Piece.getWidth()*j)+(gap*(j)));
                y = (float)(800 - ((gap+(game.blank96Piece.getHeight()*i)+(gap*i))+game.blank96Piece.getHeight()));
                if(game.gameBoard.getInternalGameBoard()[i][j]<=6){
                    game.batch.draw(game.blank96Piece, x, y);
                }else{
                    game.batch.draw(game.goPiece, x, y);
                }
            }
        }
        if(game.gameBoard.getPlayers().peek().peekNextPiece()<=6){
            follower.setDrawable(new SpriteDrawable(new Sprite(game.blank96Piece)));
        }else{
            follower.setDrawable(new SpriteDrawable(new Sprite(game.goPiece)));
        }
        game.batch.setColor(Color.WHITE);
        
        //System.out.println(Gdx.graphics.getDeltaTime()); // display the time between frames

        //required screen end stuff
        game.batch.end();
        
        //if (Gdx.input.isTouched()) {
        //        game.setScreen(new TitleScreen(game));
        //        dispose();
        //}
        gameStage.draw();
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
