package com.mygdx.game.Actor;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.MyBaseClasses.Scene2D.MyStage;
import com.mygdx.game.Szamitasok.Ballistics;
import com.mygdx.game.Stage.GameStage;
import com.mygdx.game.GlobalClasses.Assets;
import com.mygdx.game.Szamitasok.Lagrange;
import com.mygdx.game.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import com.mygdx.game.MyBaseClasses.Scene2D.ShapeType;

/**
 * Created by tanulo on 2017. 10. 25..
 */

public class LovedekActor extends OneSpriteStaticActor {
    Sound becsapodas = Assets.manager.get(Assets.BECSAPODAS_SOUND);
    Sound kiloves = Assets.manager.get(Assets.KILOVES_SOUND);

    float elapsedTime2 = 0;

    GameStage gameStage;
    Ballistics ballistics;
    int indexOfAngles;
    VarActor varActor;
    SatorActor satorActor;
    RavenActor ravenActor;
    Lagrange lagrange;

    private float[] pos;
    static int i=0;


    public LovedekActor(Ballistics ballistics, int indexOfAngles, GameStage myStage, VarActor varActor, SatorActor satorActor, RavenActor ravenActor, Lagrange lagrange) {
        super(Assets.manager.get(Assets.LOVEDEK_TEXTURE));
        this.ballistics = ballistics;
        this.indexOfAngles = indexOfAngles;
        setSize(0.50f,0.50f);
        i=0;
        this.gameStage = myStage;
        kiloves.play();
        this.varActor = varActor;
        this.satorActor = satorActor;
        this.ravenActor = ravenActor;
        this.lagrange = lagrange;
    }

    public void robbanas(){
        if (getStage()!=null) {
            ExplosionActor explosionActor;
            getStage().addActor(explosionActor = new ExplosionActor());
            explosionActor.setPosition(getX()-getWidth(),getY()-getHeight());
            explosionActor.setSize(getWidth()*3, getHeight()*3);
        }

    }

    public void felrobban(){
        if (getStage()!=null) {
            robbanas();
            getStage().getActors().removeValue(this, true);
        }
    }


    @Override
    public void act(float delta) {
        super.act(delta);
            elapsedTime2 += delta * gameStage.timeScale;
            float[] pos = ballistics.getXYbyTime(elapsedTime2, indexOfAngles);
            setPosition(pos[0] - getWidth() / 2 + gameStage.getOffsetX(), pos[1] - getHeight() / 2 + gameStage.getOffsetY());
        /*if((getX()+"").equals("NaN") && i==0) {
            System.out.println("Nem jó");
            i++;
        }*/
        setRotation((float)Math.sqrt(elapsedTime2*2000000f)); // pörgetés átállítása
        //if (elapsedTime2>ballistics.getTimeOfFlight(indexOfAngles))getStage().getActors().removeValue(this, true);
        for (Actor a :getStage().getActors()) {
            if (a instanceof KatonaActor){
                if(((KatonaActor)a).overlaps(ShapeType.Rectangle, this)){
                    //getStage().getActors().removeValue(this, true);
                    felrobban();
                    ((KatonaActor)a).halal();
                }
            }
        }
        if(varActor.overlaps(ShapeType.Rectangle, this)){
            becsapodas.play();
            //getStage().getActors().removeValue(this, true);
            felrobban();
            varActor.decLife(100);
        }
        if(satorActor.overlaps(ShapeType.Rectangle, this)){
            //getStage().getActors().removeValue(this, true);
            felrobban();
            satorActor.decLife(100);
        }
        if(ravenActor.overlaps(ShapeType.Rectangle, this)){
            //getStage().getActors().removeValue(this, true);
            felrobban();
            ravenActor.dead();
        }
        if(getY() <= lagrange.getY(getX())){
            felrobban();
            //getStage().getActors().removeValue(this, true);
        }
        if (elapsedTime==delta){
            robbanas();
        }
        //System.out.println("X=" + pos[0]+" Y="  + pos[1]);
    }
}
