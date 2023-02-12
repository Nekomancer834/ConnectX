/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cx.game;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.*;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Trent
 */
public class ConnectX extends Game{
    protected SpriteBatch batch;
    protected BitmapFont font;
    //backgrounds
    protected Texture gameBackground;
    protected Texture titleBackground;
    protected Texture settingBackground;
    protected Texture playerListBackground;
    //buttons
    protected Texture yellowButton;
    protected Texture redButton;
    //pieces
    protected Texture blank96Piece;
    protected Texture blank48Piece;
    protected Texture goPiece;
    //misc
    protected Texture blankBar;
    protected Texture logo;
    protected Viewport viewport;
    protected Skin mySkin;
    protected Skin defaultSkin;
    protected Texture gradientBar;
    //game logic
    protected Board gameBoard;
    protected Queue<Player> playerQueue;
    
    public void create() {
		batch = new SpriteBatch();
		font = new BitmapFont(); // use libGDX's default Arial font
                //backgrounds
                gameBackground = new Texture(Gdx.files.internal("Backgrounds/gameBackground.png"));
                titleBackground = new Texture(Gdx.files.internal("Backgrounds/titleBackground.jpg"));
                settingBackground = new Texture(Gdx.files.internal("Backgrounds/settingBackground.png"));
                playerListBackground = new Texture(Gdx.files.internal("Backgrounds/playerListBackground.png"));
                //buttons
                redButton = new Texture(Gdx.files.internal("Buttons/titleButtonRed.png"));
                yellowButton = new Texture(Gdx.files.internal("Buttons/titleButtonYellow.png"));
                //pieces
                blank96Piece = new Texture(Gdx.files.internal("Pieces/96x96test.png"));
                blank48Piece = new Texture(Gdx.files.internal("Pieces/48x48test.png"));
                goPiece = new Texture(Gdx.files.internal("Pieces/96x96testGO.png"));
                //misc
                blankBar = new Texture(Gdx.files.internal("Misc/blankBar.png"));
                logo = new Texture(Gdx.files.internal("Misc/ConnectXLogo.png"));
                gradientBar = new Texture(Gdx.files.internal("Misc/GradientBar.png"));
                mySkin = new Skin(Gdx.files.internal("Custom/custom.json"));
                defaultSkin = new Skin(Gdx.files.internal("default/skin/uiskin.json"));
                //game logic
                playerQueue = new LinkedList<>();
                
                viewport = new FitViewport(1600,900);
                
                //temporarily open the game screen rather than the title screen, for development
                //this.setScreen(new TitleScreen(this));
                this.setScreen(new TitleScreen(this));
	}

	public void render() {
		super.render(); // important!
	}

	public void dispose() {
		batch.dispose();
		font.dispose();
                gameBackground.dispose();
                titleBackground.dispose();
                redButton.dispose();
                yellowButton.dispose();
                logo.dispose();
                mySkin.dispose();
	}
    
    /*
    private static final int FRAME_COLS = 5, FRAME_ROWS = 1;
    private Animation<TextureRegion> xButtonAnimation;
    private Texture backgroundTexture;
    private Texture testTexture;
    private SpriteBatch batch;
    private ShapeRenderer shape;
    private OrthographicCamera camera;
    private TextureAtlas atlas;
    private Circle circleTest;
    private float horizontalemptyspace;
    private float horizontalgap;
    private float verticalemptyspace;
    private float verticalgap;
    private int vertpiece;
    private int horizpiece;
    private float boardframeystart;
    private float boardframexstart;

    float stateTime;
    @Override
    public void create(){
        atlas = new TextureAtlas(Gdx.files.internal("xButton.atlas"));
        xButtonAnimation = new Animation<TextureRegion>(.33f, atlas.findRegions("XButton"), PlayMode.LOOP);
        backgroundTexture = new Texture(Gdx.files.internal("backgroundTexture.jpg"));
        testTexture = new Texture(Gdx.files.internal("64x64test.png"));
        circleTest = new Circle(50, 50, 25);
        batch = new SpriteBatch();
        shape = new ShapeRenderer();
        stateTime = 0f;
        
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1600, 960);
        
    }
    
    @Override
    public void render(){
        //draw purple background
        Gdx.gl.glClearColor(.5f, 0f, 1f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        //grab delta time since last frame draw
        stateTime += Gdx.graphics.getDeltaTime();
        
        //update animation frames
        TextureRegion currentFrame = xButtonAnimation.getKeyFrame(stateTime, true);
        
        //set projection to camera's matrix
        batch.setProjectionMatrix(camera.combined);
        shape.setProjectionMatrix(camera.combined);
        
        //begin allowing drawing of textures and shapes
        
        shape.begin(ShapeType.Filled);
        batch.begin();
        
        //draw the background, the red square, and the animation
        batch.draw(backgroundTexture, 0, 0); //heh this won't ever be seen, its here as a tribute to my hate for libgdx even though it really isn't that bad
        
        //draw the orange circle
        shape.setColor(1f,.5f,0f,1f);
        shape.circle(50, 50, 12.5f);
        
        //example board drawing
        //6 x 4 pieces and 1300 x 860 pixels
        horizpiece = 6;
        vertpiece = 4;
        //start at the top left of the "board", 150,430 is the top left corner
        //calculate the size of the empty board space horizontally
        horizontalemptyspace = 1300-(horizpiece*64);
        horizontalgap = horizontalemptyspace/(horizpiece+1);
        
        verticalemptyspace = 860-(vertpiece*64);
        verticalgap = verticalemptyspace/(vertpiece+1);
        
        boardframeystart = camera.viewportHeight - 100;
        boardframexstart = 200;
        
        batch.setColor(Color.RED);
        for(int i=0;i<vertpiece;i++){
            for(int j=0;j<horizpiece;j++){
                batch.draw(testTexture, boardframexstart+(horizontalgap+(64*j)+(horizontalgap*j)), boardframeystart-(verticalgap+(64*i)+(verticalgap*i)));
            }
        }
        
        
        batch.draw(testTexture, 50, 50);
        batch.setColor(Color.WHITE);
        batch.draw(currentFrame, 50, 50);
        
        
        
        
        
        
        batch.end(); //end sprite drawing
        shape.end(); //end shape drawing
        
    }
    */
}
