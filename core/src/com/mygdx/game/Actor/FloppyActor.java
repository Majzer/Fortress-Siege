package com.mygdx.game.Actor;

import com.mygdx.game.GlobalClasses.Assets;
import com.mygdx.game.MyBaseClasses.Scene2D.OneSpriteStaticActor;

/**
 * Created by tanulo on 2017. 12. 14..
 */

public class FloppyActor extends OneSpriteStaticActor {

    public FloppyActor(float x, float y){
        super(Assets.manager.get(Assets.FLOPPY_TEXTURE));
        setPosition(x,y);
        setSize(getWidth()/2.5f, getHeight()/2.5f);
    }
}
