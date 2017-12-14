package com.mygdx.game.Actor;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.GlobalClasses.Assets;
import com.mygdx.game.MyBaseClasses.Scene2D.OneSpriteStaticActor;

/**
 * Created by tanulo on 2017. 12. 14..
 */

public class OsemberActor extends OneSpriteStaticActor{

    public OsemberActor(float x, float y) {
        super(Assets.manager.get(Assets.OSEMBER_TEXTURE));
        setPosition(x,y);
        setSize(getWidth()*8, getHeight()*8);
    }
}
