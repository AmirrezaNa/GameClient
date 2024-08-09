package controller.gameController;

import model.entity.*;
import model.entity.enemy.normalAndMiniBoss.*;
import model.entity.enemy.boss.LeftHandModel;
import model.entity.enemy.boss.PunchModel;
import model.entity.enemy.boss.RightHandModel;
import model.entity.enemy.boss.SmileyModel;
import view.SettingsPanel;
import controller.gameLoop.phase2.BossFight.EpsilonFrame;
import controller.gameLoop.phase2.normalAndMiniBossEnemies.CreateFrames;

import java.awt.*;
import java.io.Serializable;
import java.util.*;

public class GameController implements Serializable {
    private static final long serialVersionUID = 1L;
    public SmileyModel smiley;
    public RightHandModel rightHand;
    public LeftHandModel leftHand;
    public PunchModel punch;

    public BallModel ball;
    public BallDirection ballDirection;
    public BallAngle ballAngle;

    BulletModel bullet;
    EnemyModel1 enemy1;
    EnemyModel2 enemy2;
    ArchmireModel archmire;
    BarricadosModel1 barricados1;
    BarricadosModel2 barricados2;
    BlackOrbModel blackOrb;
    OmenoctModel omenoct;
    WyrmModel wyrm;
    NecropickModel necropick;
    Collectible collectible;
    public ArrayList<BulletModel> bullets;
    public ArrayList<BulletModel> enemyBullets;
    public ArrayList<EnemyModel1> enemies1;
    public ArrayList<EnemyModel2> enemies2;
    public ArrayList<ArchmireModel> archmireEnemies;
    public ArrayList<ArchmirePoints> archmirePoints;
    public ArrayList<BarricadosModel1> barricadosEnemies1;
    public ArrayList<BlackOrbModel> blackOrbEnemies;
    public ArrayList<BarricadosModel2> barricadosEnemies2;
    public ArrayList<OmenoctModel> omenoctEnemies;
    public ArrayList<WyrmModel> wyrmEnemies;
    public ArrayList<NecropickModel> necropickEnemies;
    public ArrayList<Collectible> collectibles;
    public int wave;
    public int Banish;
    public int Empower;
    public boolean bulletAres;
    public boolean gameOver;
    public boolean pause;

    public int elapsedTime;
    public int numberOfBullets;
    public boolean phase1over;
    public boolean stopWave;
    public boolean phase2Over;
    public boolean finalBossOver;
    public boolean empowerBullet;
    public EpsilonFrame epsilonFrame;
    public SettingsPanel settings;
    public CreateFrames[] createdFrames;
    public boolean framesCreated;
    public Set<Integer> collidedFrames;
    public boolean ballBetweenFrames;

    public GameController() {
        gameTime(this);
        this.settings = new SettingsPanel();

        this.smiley = null;
        this.rightHand = null;
        this.leftHand = null;
        this.punch = null;
        this.ball = null;
        this.ballDirection = null;
        this.ballAngle = null;
        this.bullet = null;
        this.enemy1 = null;
        this.enemy2 = null;
        this.archmire = null;
        this.barricados1 = null;
        this.barricados2 = null;
        this.blackOrb = null;
        this.omenoct = null;
        this.wyrm = null;
        this.necropick = null;
        this.collectible = null;


        this.epsilonFrame = null;
        this.createdFrames = null;
        this.framesCreated = false;
        this.collidedFrames = new HashSet<>();
        this.ballBetweenFrames = false;

        this.bullets = new ArrayList<>();
        this.enemyBullets = new ArrayList<>();
        this.enemies1 = new ArrayList<>();
        this.enemies2 = new ArrayList<>();
        this.archmireEnemies = new ArrayList<>();
        this.archmirePoints = new ArrayList<>();
        this.barricadosEnemies1 = new ArrayList<>();
        this.blackOrbEnemies = new ArrayList<>();
        this.barricadosEnemies2 = new ArrayList<>();
        this.omenoctEnemies = new ArrayList<>();
        this.wyrmEnemies = new ArrayList<>();
        this.necropickEnemies = new ArrayList<>();
        this.collectibles = new ArrayList<>();


        this.wave = 1;
        this.Banish = 0;
        this.Empower = 0;
        this.bulletAres = false;
        this.empowerBullet = false;
        this.elapsedTime = 0;
        this.numberOfBullets = 0;
        this.phase1over = false;
        this.phase2Over = false;
        this.finalBossOver = false;
        this.gameOver = false;
        this.pause = false;
        this.stopWave = false;
    }


    public void gameTime(GameController gameController) {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if (!gameController.pause) {
                    gameController.elapsedTime++;
                }
            }
        };
        timer.scheduleAtFixedRate(task, 0, 1000);
    }

}
