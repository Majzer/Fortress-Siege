package com.mygdx.game.Vege;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Actor.CloudActor;
import com.mygdx.game.Actor.FloppyActor;
import com.mygdx.game.Actor.OsemberActor;
import com.mygdx.game.FortressSiege;
import com.mygdx.game.GlobalClasses.Assets;
import com.mygdx.game.MyBaseClasses.Scene2D.MyStage;
import com.mygdx.game.UI.MyButton;

/**
 * Created by tanulo on 2017. 12. 04..
 */

public class VegeStage extends MyStage {

    public static Label lbl;
    CloudActor cloudActor;
    OsemberActor osemberActor;
    FloppyActor floppyActor;

    public VegeStage(Viewport viewport, Batch batch, FortressSiege game) {
        super(viewport, batch, game);
    }

    public Label.LabelStyle getLabelStyle() {
        Label.LabelStyle style;
        style = new com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle();
        style.font = Assets.manager.get(Assets.MEDIEVAL_30_FONT);
        style.fontColor = Color.WHITE;
        return style;
    }

    @Override
    public void init() {
        addActor(cloudActor = new CloudActor(0, getHeight()-Assets.manager.get(Assets.CLOUD_TEXTURE).getHeight()-120,170f*1.3f, 100f*1.3f,Assets.manager.get(Assets.CLOUD_TEXTURE),0.5f));
        addActor(cloudActor = new CloudActor(getWidth()-Assets.manager.get(Assets.CLOUD_TEXTURE).getWidth(), getHeight()-460,170f*1.3f, 100f*1.3f,Assets.manager.get(Assets.CLOUD_TEXTURE),0.5f));
        addActor(cloudActor = new CloudActor(0, getHeight()-660,170f*1.3f, 100f*1.3f,Assets.manager.get(Assets.CLOUD_TEXTURE),0.5f));
        addActor(cloudActor = new CloudActor(getWidth()-Assets.manager.get(Assets.CLOUD_TEXTURE).getWidth(), getHeight()-910,170f*1.3f, 100f*1.3f,Assets.manager.get(Assets.CLOUD_TEXTURE),0.5f));
        addActor(osemberActor = new OsemberActor(getWidth()/2-100,getHeight()/2));
        addActor(floppyActor = new FloppyActor(getWidth()/2+100, getHeight()/2));
        //lbl = new Label("Köszönet szüleinknek akik nélkül ez nem jöhetett volna létre", getLabelStyle());
        lbl = new Label("You won", getLabelStyle());
        lbl.setPosition(getWidth()/2,getHeight()/2);
        addActor(lbl);
    }

    @Override
    protected void resized() {

    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
