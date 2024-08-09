package controller.gameController;

import model.entity.*;
import model.entity.enemy.AllEnemies;
import model.entity.enemy.boss.LeftHandModel;
import model.entity.enemy.boss.PunchModel;
import model.entity.enemy.boss.RightHandModel;
import model.entity.enemy.boss.SmileyModel;
import view.SettingsPanel;
import controller.gameLoop.phase2.BossFight.EpsilonFrame;
import controller.gameLoop.phase2.normalAndMiniBossEnemies.CreateFrames;

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
    AllEnemies.EnemyModel1 enemy1;
    AllEnemies.EnemyModel2 enemy2;
    AllEnemies.ArchmireModel archmire;
    AllEnemies.BarricadosModel1 barricados1;
    AllEnemies.BarricadosModel2 barricados2;
    AllEnemies.BlackOrbModel blackOrb;
    AllEnemies.OmenoctModel omenoct;
    AllEnemies.WyrmModel wyrm;
    AllEnemies.NecropickModel necropick;
    Collectible collectible;
    public ArrayList<BulletModel> bullets;
    public ArrayList<BulletModel> enemyBullets;
    public ArrayList<AllEnemies.EnemyModel1> enemies1;
    public ArrayList<AllEnemies.EnemyModel2> enemies2;
    public ArrayList<AllEnemies.ArchmireModel> archmireEnemies;
    public ArrayList<AllEnemies.ArchmirePoints> archmirePoints;
    public ArrayList<AllEnemies.BarricadosModel1> barricadosEnemies1;
    public ArrayList<AllEnemies.BlackOrbModel> blackOrbEnemies;
    public ArrayList<AllEnemies.BarricadosModel2> barricadosEnemies2;
    public ArrayList<AllEnemies.OmenoctModel> omenoctEnemies;
    public ArrayList<AllEnemies.WyrmModel> wyrmEnemies;
    public ArrayList<AllEnemies.NecropickModel> necropickEnemies;
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

    public int xFrame1;
    public int yFrame1;
    public int widthFrame1;
    public int heightFrame1;

    public int xEpsilonFrame;
    public int yEpsilonFrame;
    public int widthEpsilonFrame;
    public int heightEpsilonFrame;

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

        this.xFrame1 = 300;
        this.yFrame1 = 50;
        this.widthFrame1 = 600;
        this.heightFrame1 = 600;
        this.xEpsilonFrame = 450;
        this.yEpsilonFrame = 300;
        this.widthEpsilonFrame = 400;
        this.heightEpsilonFrame = 400;
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
