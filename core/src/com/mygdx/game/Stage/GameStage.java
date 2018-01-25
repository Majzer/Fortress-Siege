package com.mygdx.game.Stage;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.mygdx.game.Actor.*;
import com.mygdx.game.FortressSiege;
import com.mygdx.game.GlobalClasses.Assets;
import com.mygdx.game.MainScreen;
import com.mygdx.game.MyBaseClasses.Scene2D.MyActor;
import com.mygdx.game.MyBaseClasses.Scene2D.MyStage;
import com.mygdx.game.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import com.mygdx.game.Szamitasok.*;
import com.mygdx.game.Vege.VegeScreen;

import java.util.Random;

/**
 * Created by tanulo on 2017. 10. 25..
 */

public class GameStage extends MyStage {

    Ballistics ballistics;
    Lagrange lagrange;
    ClickListener stageClickListener;

    Sound osszeomlas = Assets.manager.get(Assets.OSSZEOMLAS_SOUND);
    Sound trumpet_2 = Assets.manager.get(Assets.TROMBITA_2_SOUND);
    Button tryAgaiunTextButton;

    public void setControlStage(ControlStage controlStage) {
        this.controlStage = controlStage;
    }

    ControlStage controlStage;
    KatonaActor katonaActor;
    OneSpriteStaticActor bg;
    VarActor varActor;
    VarTopActor varTopActor;
    SatorTopActor satorTopActor;
    SatorActor satorActor;
    RavenActor ravenActor;
    HPActorFekete hpActorFekete, hpActorFekete1;
    HPActorPiros hpActorPiros, hpActorPiros1;
    CloudActor cloudActor;
    MyActor actor;
    CannonActor cannonActor;
    CannonTopActor cannonTopActor;
    float offsetX = 0.9499998f;
    float offsetY = 5.5199995f;
    public float timeScale = 1;
    long ido1, ido2=0, idoKatona=System.currentTimeMillis();
    byte level = 1;
    int point=0, coin=0;
    public Label lblCoin, lblPoint;
    TextButton btnHeal;
    boolean nyert;

    public void setNyert(boolean nyert) {
        this.nyert = nyert;
    }

    public int getPalya() {
        return palya;
    }

    private int palya;

    public void addHp(int a){
        varActor.addHp(a);
    }

    public TextButton getBtnHeal() {
        return btnHeal;
    }

    public int getPoint() {
        return point;
    }

    public void addPoint(int point){
        this.point+=point;
        setLblPoint();
    }

    public int getCoin() {
        return coin;
    }

    public int removeCoin(int coinminus){
        coin-=coinminus;
        setLblCoin();
        System.out.println(coin);
        return coin;
    }

    public void addCoin(int coin){
        this.coin+=coin;
        setLblCoin();
    }

    public void setTimeScale(float timeScale) {
        this.timeScale = timeScale;
    }

    public float getOffsetX() {
        return offsetX;
    }

    public float getOffsetY() {
        return offsetY;
    }

    public GameStage getGameStage() {
        return this;
    }

    public void setV0(float v0) {
        this.v0 = v0;
    }

    public void nezoke(){
        controlStage.nezoke();
    }


    float v0 = 7.5f;
    int i = 0;

    public float round(float f){
        return ((float)((int)(f*10f)))/10f;
    }

    boolean isNextLevel(){
        return System.currentTimeMillis()-idoKatona>15000;
    }

    public void addRaven(long ido, boolean canSpawnNewRaven){
        //System.out.println(System.currentTimeMillis()+" "+ido + " " + (System.currentTimeMillis()-ido) + " " + canSpawnNewRaven);
        if(System.currentTimeMillis() - ido > 5000 && canSpawnNewRaven) {
            addActor(ravenActor=new RavenActor(10, (float)(new Random().nextInt(2)+5+new Random().nextDouble()), lagrange, 3, level, getGameStage(), varActor));
            varActor.setCanSpawnNewRaven(false);

        }
    }

    public void addKatona(){
        //System.out.println("level = " + level);
        switch (level){
            case 1: {
                if(isNextLevel()){
                    level++;
                    idoKatona = System.currentTimeMillis();
                }
                addActor(new KatonaActor(0,0, lagrange, new Random().nextDouble()+3, level, getGameStage()));
                break;
            }
            case 2: {
                if(isNextLevel()){
                    level++;
                    idoKatona = System.currentTimeMillis();
                }
                addActor(new KatonaActor(0,0, lagrange, new Random().nextDouble()+2, level, getGameStage()));
                break;
            }
            case 3: {
                if(isNextLevel()){
                    level++;
                    idoKatona = System.currentTimeMillis();
                }
                addActor(new KatonaActor(0,0, lagrange, new Random().nextDouble()+1, level, getGameStage()));
                break;
            }
            case 4: {
                addActor(new KatonaActor(0, 0, lagrange, 0.5, level, getGameStage()));
            }
        }
        }


    public GameStage(final Batch batch, final FortressSiege game, int palya) {
        super(new ExtendViewport(10.24f,7.68f), batch, game);
        float satorX=0, satorY=0;
        this.palya = palya;

        switch (palya){
            case 1:
                bg = new OneSpriteStaticActor(Assets.manager.get(Assets.BACKGROUND_TEXTURE));


                satorX = 8.7f;
                satorY = 2.5f;

                lagrange = new Lagrange();
                lagrange.addpoint(0.059999943, 1.91);
                lagrange.addpoint(0.26000023, 1.9899999);
                lagrange.addpoint(0.3800001, 2.1);
                lagrange.addpoint(0.6700001, 2.2199998);
                lagrange.addpoint(1.0999999, 2.3599997);
                lagrange.addpoint(1.4300001, 2.4199996);
                lagrange.addpoint(1.72, 2.4599998);
                lagrange.addpoint(2.1699998, 2.4899998);
                lagrange.addpoint(2.34, 2.4499998);
                lagrange.addpoint(2.61, 2.3999999);
                lagrange.addpoint(2.6699998, 2.3999999);
                lagrange.addpoint(3.03, 2.4299998);
                lagrange.addpoint(3.5099998, 2.5099998);
                lagrange.addpoint(4.23, 2.5699997);
                lagrange.addpoint(4.7599998, 2.62);
                lagrange.addpoint(5.23, 2.6599998);
                lagrange.addpoint(6.0899997, 2.7499995);
                lagrange.addpoint(6.33, 2.77);
                lagrange.addpoint(6.5899997, 2.7299998);
                lagrange.addpoint(6.8599997, 2.6699996);
                lagrange.addpoint(7.06, 2.6299996);
                lagrange.addpoint(7.16, 2.6299996);
                lagrange.addpoint(7.3199997, 2.6499999);
                lagrange.addpoint(7.5299997, 2.6699996);
                lagrange.addpoint(7.72, 2.7099998);
                lagrange.addpoint(7.97, 2.7199998);
                lagrange.addpoint(8.37, 2.7199998);
                lagrange.addpoint(8.87, 2.7099998);
                lagrange.addpoint(9.379999, 2.6799998);
                lagrange.addpoint(9.94, 2.6699996);
                lagrange.addpoint(10.16, 2.6599998);
                break;
            case 2:
                bg = new OneSpriteStaticActor(Assets.manager.get(Assets.BACKGROUND2_TEXTURE));

                satorX = 8.7f;
                satorY = 2.5f;

                /*
                lagrange = new Lagrange();
                lagrange.addpoint(0.059999943, 1.91);
                lagrange.addpoint(0.26000023, 1.9899999);
                lagrange.addpoint(0.3800001, 2.1);
                lagrange.addpoint(0.6700001, 2.2199998);
                lagrange.addpoint(1.0999999, 2.3599997);
                lagrange.addpoint(1.4300001, 2.4199996);
                lagrange.addpoint(1.72, 2.4599998);
                lagrange.addpoint(2.1699998, 2.4899998);
                lagrange.addpoint(2.34, 2.4499998);
                lagrange.addpoint(2.61, 2.3999999);
                lagrange.addpoint(2.6699998, 2.3999999);
                lagrange.addpoint(3.03, 2.4299998);
                lagrange.addpoint(3.5099998, 2.5099998);
                lagrange.addpoint(4.23, 2.5699997);
                lagrange.addpoint(4.7599998, 2.62);
                lagrange.addpoint(5.23, 2.6599998);
                lagrange.addpoint(6.0899997, 2.7499995);
                lagrange.addpoint(6.33, 2.77);
                lagrange.addpoint(6.5899997, 2.7299998);
                lagrange.addpoint(6.8599997, 2.6699996);
                lagrange.addpoint(7.06, 2.6299996);
                lagrange.addpoint(7.16, 2.6299996);
                lagrange.addpoint(7.3199997, 2.6499999);
                lagrange.addpoint(7.5299997, 2.6699996);
                lagrange.addpoint(7.72, 2.7099998);
                lagrange.addpoint(7.97, 2.7199998);
                lagrange.addpoint(8.37, 2.7199998);
                lagrange.addpoint(8.87, 2.7099998);
                lagrange.addpoint(9.379999, 2.6799998);
                lagrange.addpoint(9.94, 2.6699996);
                lagrange.addpoint(10.16, 2.6599998);
                */

                lagrange = new Lagrange();
                lagrange.addpoint(10.219999, 1.5542562);

                lagrange.addpoint(7.0299997, 0.9940741);

                lagrange.addpoint(2.5, 1.8343475);
                break;
        }




        if(palya!=3){
            bg.setSize(((ExtendViewport)getViewport()).getMinWorldWidth(), ((ExtendViewport)getViewport()).getMinWorldHeight());
            addActor(bg);

        }


        addActor(new CloudActor(0.26f,((ExtendViewport) getViewport()).getMinWorldHeight()-1f,1.7f,1,Assets.manager.get(Assets.CLOUD_TEXTURE),0.004f));
        addActor(new CloudActor(7.42f,((ExtendViewport) getViewport()).getMinWorldHeight()-2f,1.7f,1,Assets.manager.get(Assets.CLOUD_TEXTURE),0.006f));
        addActor(new CloudActor(4.54f,((ExtendViewport) getViewport()).getMinWorldHeight()-3f,1.7f,1,Assets.manager.get(Assets.CLOUD_TEXTURE),0.002f));
        addKatona();

        addActor(satorActor = new SatorActor(satorX, satorY));
        addActor(satorTopActor = new SatorTopActor(satorX, satorY+1));
        addActor(cannonActor=new CannonActor(getGameStage()));
        addActor(cannonTopActor=new CannonTopActor(cannonActor));
        addActor(varTopActor = new VarTopActor(varActor,getGameStage()));
        addActor(varActor = new VarActor(getGameStage(),varTopActor, cannonActor));
        addActor(ravenActor=new RavenActor(10, 5, lagrange, 3, level, getGameStage(), varActor));
        addActor(hpActorFekete =new HPActorFekete(varActor));
        addActor(hpActorFekete1 =new HPActorFekete(satorActor));
        addActor(hpActorPiros=new HPActorPiros(varActor));
        addActor(hpActorPiros1=new HPActorPiros(satorActor));



        addListener(stageClickListener = new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);

                KatonaActor katonaActor;

                    try {
                        //InfoLabelActor infoLabelActor;
                        //controlStage.addActor(infoLabelActor = new InfoLabelActor("Távolság: " + x + " m\n Magasság: "+y+" m \n Szög (1): "+round(new Ballistics(x - getOffsetX(), y - getOffsetY(), v0).getAnglesByDeg()[0])+"°°\n Szög (2): "+round(new Ballistics(x - getOffsetX(), y - getOffsetY(), v0).getAnglesByDeg()[1])+"°\n Sebesség: " + round(v0) +" m/s", x*100+50, y*100-100, game.getLabelStyle()));
                        ido1 = System.currentTimeMillis();
                        System.out.println(ido1);
                        if (ido1 - ido2 > 2000) {
                            ballistics = new com.mygdx.game.Szamitasok.Ballistics(x - getOffsetX(), y - getOffsetY(), v0);
                            cannonTopActor.shot(ballistics.getDeg()[0]);
                            addActor(new LovedekActor(ballistics, 0, getGameStage(), varActor, satorActor, ravenActor, lagrange));
                            ido2=ido1;
                        }
                        //addActor(new LovedekActor(new Ballistics(x - getOffsetX(), y - getOffsetY(), v0), 1, getGameStage()));

                    }
                    catch (Exception e)
                    {
                        System.out.println(e.toString());
                        katonaActor = null;
                    }


            }
        });
        //setCameraResetToLeftBottomOfScreen();
        ExtendViewport v = (ExtendViewport)getViewport();

        //float f = (v.getWorldWidth() / v.getMinWorldWidth());
        //System.out.println(f);

        //setCameraMoveToXY(v.getWorldWidth()/2/f,v.getWorldHeight()/2,1/f,100000,100000);
        //setCameraZoomXY(v.getWorldWidth()/2/f,v.getWorldHeight()/2,1/f);
        fitWorldToWidth();


        addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                //System.out.println("lagrange.addpoint(" + x + ", " + y + ");");
            }
        });
        //setDebugAll(true);
    }

    public Label.LabelStyle getLabelStyle() {
        Label.LabelStyle style;
        style = new com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle();
        style.font = Assets.manager.get(Assets.ARIAL_30_FONT);
        style.fontColor = Color.WHITE;
        return style;
    }

    public void setLblCoin(){
        controlStage.setLblCoin(coin+" gold");
    }

    public void setLblPoint(){
        controlStage.setLblPoint(point+"/7500 point");
    }

    public double getLife(){
        return varActor.getLife();
    }

    @Override
    protected void resized() {
        super.resized();
        //ExtendViewport v = (ExtendViewport)getViewport();
        //float f = (v.getWorldWidth() / v.getMinWorldWidth());
        //setCameraMoveToXY(v.getWorldWidth()/2/f,v.getWorldHeight()/2,1/f,100000,100000);
        //setCameraZoomXY(v.getWorldWidth()/2/f,v.getWorldHeight()/2,1/f);
        fitWorldToWidth();

    }

    @Override
    public void init() {

    }


    @Override
    public void act(float delta) {
        super.act(delta);
        if (varActor.getLife()<=0 && tryAgaiunTextButton == null) {

            removeListener(stageClickListener);
            osszeomlas.play();
            trumpet_2.play();
            controlStage.addActor(tryAgaiunTextButton = new Button(game.btnTryAgain()));
            tryAgaiunTextButton.setSize(565,110);
            ExtendViewport ev = (ExtendViewport)controlStage.getViewport();
            tryAgaiunTextButton.setPosition(ev.getWorldWidth()/2-tryAgaiunTextButton.getWidth()/2, ev.getWorldHeight()/2-tryAgaiunTextButton.getHeight()/2);
            tryAgaiunTextButton.addListener(new ClickListener(){
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    super.clicked(event, x, y);
                    varActor.setRobbanhat(false);
                    game.setScreen(new MainScreen(game, getPalya()), false);
                }
            });
        }else{
            //7500
            if(point>=7500){
                //System.exit(0);
                if(getPalya()==2) {
                    game.setScreen(new VegeScreen(game));
                    clear();
                    dispose();
                }
                else if(getPalya()==1) {
                    game.setScreen(new MainScreen(game, getPalya()+1), false);
                    clear();
                    dispose();
                }

            }
        }
    }
}
