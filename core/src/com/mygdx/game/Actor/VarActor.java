package com.mygdx.game.Actor;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.MainScreen;
import com.mygdx.game.Menu.MainMenuScreen;
import com.mygdx.game.Stage.GameStage;
import com.mygdx.game.GlobalClasses.Assets;
import com.mygdx.game.InfoLabelActor;
import com.mygdx.game.MyBaseClasses.Scene2D.MyStage;
import com.mygdx.game.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import com.mygdx.game.Vege.VegeScreen;

import java.util.Random;

/**
 * Created by Majzer on 27/10/2017.
 */

public class VarActor extends OneSpriteStaticActor {

    public InfoLabelActor infoLabelActor;
    float life = 1000;
    long ido1Katona, ido2Katona =System.currentTimeMillis(), ido1Raven, ido2Raven=System.currentTimeMillis();
    Sound sebesules = Assets.manager.get(Assets.SEBESULES_SOUND);
    Texture var2 = Assets.manager.get(Assets.VAR2_TEXTURE);
    Texture var1 = Assets.manager.get(Assets.VAR1_TEXTURE);
    Texture var3 = Assets.manager.get(Assets.VAR3_TEXTURE);
    Texture var2Top = Assets.manager.get(Assets.VAR2_TOP_TEXTURE);
    Texture var3Top = Assets.manager.get(Assets.VAR3_TOP_TEXTURE);
    public boolean canSpawnNewRaven=false, robbanhat=false;
    static long deadTime= System.currentTimeMillis();
    GameStage gameStage;
    static VarActor varActor;
    VarTopActor varTopActor;
    CannonActor cannonActor;
    MyStage myStage;
    long ido = System.currentTimeMillis();
    Random random = new Random();


    public VarActor(MyStage myStage, VarTopActor varTopActor, CannonActor cannonActor) {


        super(Assets.manager.get(Assets.CASTLE_TEXTURE));
        this.cannonActor=cannonActor;
        setSize(2.5f, 2.3f);
        if(((GameStage)myStage).getPalya()==2){
            //-0.2f, 1.7f
            setPosition(-0.3f, 1.7f);
        }
        else{
            //-0.2f, 2f
            setPosition(-0.2f, 2f);
        }
        this.gameStage = (GameStage) myStage;
        this.varTopActor = varTopActor;
    }

    public float getLife() {
        return life;
    }

    public void addHp(int hp){
        life+=hp;
        System.out.println(hp +" "+life);
    }

    public void decLife(float damage){
        life -= damage;
        //System.out.println("damage = " + damage);
        //System.out.println("life = " + life);

        if(life<1){
            life = 0;
            setTexture(var3);
            varTopActor.setTexture(var3Top);
            cannonActor.felrobban();
            robbanhat=true;
            //((MyStage)getStage()).game.setScreen(new MainScreen(((GameStage) getStage()).game, ((GameStage) getStage()).getPalya()), false);
        } else if(life<334){
            if(hang334){
                sebesules.play();
                hang334=false;
            }
            setTexture(var2);
            varTopActor.setTexture(var2Top);
        } else if(life<667){
            if(hang667){
                sebesules.play();
                hang667=false;
            }
            hang334=true;
            setTexture(var1);
            varTopActor.setTexture(Assets.manager.get(Assets.CASTLE_TOP_TEXTURE));
        }
        else if(life>=667){
            setTexture(Assets.manager.get(Assets.CASTLE_TEXTURE));
            varTopActor.setTexture(Assets.manager.get(Assets.CASTLE_TOP_TEXTURE));
            hang667=true;
        }
    }

    boolean hang667=true, hang334=true;

    public void setCanSpawnNewRaven(boolean canSpawnNewRaven) {
        this.canSpawnNewRaven = canSpawnNewRaven;
    }

    public boolean isTextureChanged(Texture texture){
        return texture == this.getTexture();
    }

    public void setRobbanhat(boolean robbanhat) {
        this.robbanhat = robbanhat;
    }

    @Override
    public void act(float delta){
        ido1Katona = System.currentTimeMillis();
        ido1Raven = System.currentTimeMillis();
        gameStage.nezoke();
        //System.out.println("ido1 = " + ido1);
        //System.out.println("ido2Katona = " + ido2Katona);
        //System.out.println("(ido1-ido2Katona) = " + (ido1-ido2Katona));
            if (ido1Katona - ido2Katona > 5000) {
                //System.out.println("Kész");
                gameStage.addKatona();
                ido2Katona = ido1Katona;
            }
            gameStage.addRaven(deadTime, canSpawnNewRaven);
            //System.out.println(deadTime + " " +canSpawnNewRaven);
        decLife(0);


        //System.out.println(robbanhat);
        if(robbanhat){
                if (getStage()!=null) {
                    if(System.currentTimeMillis()-ido>120){
                        felrobban();
                    }
                }
        }
    }

    public void felrobban(){
        ExplosionActor explosionActor;
        getStage().addActor(explosionActor = new ExplosionActor());
        explosionActor.setPosition(random.nextFloat()+random.nextInt(2), random.nextFloat()+random.nextInt(2)+2);
        explosionActor.setSize(1, 1);
        ido=System.currentTimeMillis();
    }

}
