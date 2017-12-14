//https://github.com/tuskeb/mester
package com.mygdx.game.GlobalClasses;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGeneratorLoader;
import com.badlogic.gdx.graphics.g2d.freetype.FreetypeFontLoader;


public class Assets {
	// https://github.com/libgdx/libgdx/wiki/Managing-your-assets
	// http://www.jacobplaster.net/using-libgdx-asset-manager
	// https://www.youtube.com/watch?v=JXThbQir2gU
	// https://github.com/Matsemann/libgdx-loading-screen/blob/master/Main/src/com/matsemann/libgdxloadingscreen/screen/LoadingScreen.java

	public static AssetManager manager;
	public static final String CHARS = "0123456789öüóqwertzuiopőúasdfghjkléáűíyxcvbnm'+!%/=()ÖÜÓQWERTZUIOPŐÚASDFGHJKLÉÁŰÍYXCVBNM?:_*<>#&@{}[],-.";


	static final FreetypeFontLoader.FreeTypeFontLoaderParameter fontParameter = new FreetypeFontLoader.FreeTypeFontLoaderParameter();
	static {
		fontParameter.fontFileName = "arial.ttf";
		fontParameter.fontParameters.size = 30;
		fontParameter.fontParameters.characters = CHARS;
		fontParameter.fontParameters.color = Color.WHITE;
	}

	static final FreetypeFontLoader.FreeTypeFontLoaderParameter fontParameter_medieval = new FreetypeFontLoader.FreeTypeFontLoaderParameter();
	static {
		fontParameter.fontFileName = "Augusta.ttf";
		fontParameter.fontParameters.size = 30;
		fontParameter.fontParameters.characters = CHARS;
		fontParameter.fontParameters.color = Color.WHITE;
	}

	//Betútípus
	public static final AssetDescriptor<BitmapFont> ARIAL_30_FONT
			= new AssetDescriptor<BitmapFont>(fontParameter.fontFileName, BitmapFont.class, fontParameter);

	public static final AssetDescriptor<BitmapFont> MEDIEVAL_30_FONT
			= new AssetDescriptor<BitmapFont>(fontParameter.fontFileName, BitmapFont.class, fontParameter_medieval);

	//Gombok
	public static final AssetDescriptor<Texture> BLUE_TEXTURE
			= new AssetDescriptor<Texture>("gombok/blue.png", Texture.class);

	public static final AssetDescriptor<Texture> GREEN_TEXTURE
			= new AssetDescriptor<Texture>("gombok/green.png", Texture.class);

	public static final AssetDescriptor<Texture> YELLOW_TEXTURE
			= new AssetDescriptor<Texture>("gombok/yellow.png", Texture.class);

	public static final AssetDescriptor<Texture> BTN_HEAL_TEXTURE
			= new AssetDescriptor<Texture>("gombok/btn_heal/btn_heal.png", Texture.class);

	public static final AssetDescriptor<Texture> BTN_HEAL_DOWN_TEXTURE
			= new AssetDescriptor<Texture>("gombok/btn_heal/btn_heal_down.png", Texture.class);

	public static final AssetDescriptor<Texture> BTN_START_DOWN_TEXTURE
			= new AssetDescriptor<Texture>("gombok/menu/start_down.png", Texture.class);

	public static final AssetDescriptor<Texture> BTN_START_TEXTURE
			= new AssetDescriptor<Texture>("gombok/menu/start.png", Texture.class);

	public static final AssetDescriptor<Texture> BTN_EXIT_TEXTURE
			= new AssetDescriptor<Texture>("gombok/menu/exit.png", Texture.class);

	public static final AssetDescriptor<Texture> BTN_EXIT_DOWN_TEXTURE
			= new AssetDescriptor<Texture>("gombok/menu/exit_down.png", Texture.class);

	public static final AssetDescriptor<Texture> BTN_TRYAGAIN_DOWN_TEXTURE
			= new AssetDescriptor<Texture>("gombok/tryagain_down.png", Texture.class);

	public static final AssetDescriptor<Texture> BTN_TRYAGAIN_TEXTURE
			= new AssetDescriptor<Texture>("gombok/tryagain.png", Texture.class);

	//Egyéb cuccok
	public static final AssetDescriptor<Texture> BACKGROUND_TEXTURE
			= new AssetDescriptor<Texture>("hatterek/background.png", Texture.class);

	public static final AssetDescriptor<Texture> BACKGROUND2_TEXTURE
			= new AssetDescriptor<Texture>("hatterek/background2.png", Texture.class);

	public static final AssetDescriptor<Texture> KNOB_TEXTURE
			= new AssetDescriptor<Texture>("slider/knob.png", Texture.class);

	public static final AssetDescriptor<Texture> SLIDER_TEXTURE
			= new AssetDescriptor<Texture>("slider/slider.png", Texture.class);

	public static final AssetDescriptor<Texture> ICON_TEXTURE
			= new AssetDescriptor<Texture>("icon.png", Texture.class);

	//Actorok
	public static final AssetDescriptor<Texture> CANNON_TEXTURE
            = new AssetDescriptor<Texture>("actorok/cannonS.png", Texture.class);

	public static final AssetDescriptor<Texture> CANNON_TOP_TEXTURE
			= new AssetDescriptor<Texture>("actorok/cannon.png", Texture.class);

    public static final AssetDescriptor<Texture> LOVEDEK_TEXTURE
            = new AssetDescriptor<Texture>("actorok/cannonBall.png", Texture.class);

    public static final AssetDescriptor<Texture> TENT_TEXTURE
            = new AssetDescriptor<Texture>("actorok/tentS.png", Texture.class);

	public static final AssetDescriptor<Texture> TENT_TOP_TEXTURE
			= new AssetDescriptor<Texture>("actorok/tentS_top.png", Texture.class);

	public static final AssetDescriptor<Texture> CLOUD_TEXTURE
			= new AssetDescriptor<Texture>("actorok/cloud.png", Texture.class);

	public static final AssetDescriptor<Texture> OSEMBER_TEXTURE
			= new AssetDescriptor<Texture>("actorok/Osember_01.png", Texture.class);

	public static final AssetDescriptor<Texture> FLOPPY_TEXTURE
			= new AssetDescriptor<Texture>("actorok/floppy.png", Texture.class);

	//Vár texturák
	public static final AssetDescriptor<Texture> CASTLE_TOP_TEXTURE
			= new AssetDescriptor<Texture>("var/castle_dark_top.png", Texture.class);

	public static final AssetDescriptor<Texture> CASTLE_TEXTURE
			= new AssetDescriptor<Texture>("var/castle_dark.png", Texture.class);

	public static final AssetDescriptor<Texture> VAR1_TEXTURE
			= new AssetDescriptor<Texture>("var/castle_dmg1_dark.png", Texture.class);

	public static final AssetDescriptor<Texture> VAR2_TEXTURE
			= new AssetDescriptor<Texture>("var/castle_dmg2_dark.png", Texture.class);

	public static final AssetDescriptor<Texture> VAR2_TOP_TEXTURE
			= new AssetDescriptor<Texture>("var/castle_dmg2_dark_top.png", Texture.class);

	public static final AssetDescriptor<Texture> VAR3_TEXTURE
			= new AssetDescriptor<Texture>("var/castle_dmg3_dark.png", Texture.class);

	public static final AssetDescriptor<Texture> VAR3_TOP_TEXTURE
			= new AssetDescriptor<Texture>("var/castle_dmg3_dark_top.png", Texture.class);

	public static final AssetDescriptor<Texture> HP_FEKETE_TEXTURE
			= new AssetDescriptor<Texture>("hp fekete.png", Texture.class);

	public static final AssetDescriptor<Texture> HP_PIROS_TEXTURE
			= new AssetDescriptor<Texture>("hp piros.png", Texture.class);


	//Animált actorok atlasz texturái
	public static final AssetDescriptor<TextureAtlas> WALK_TEXTURE
			= new AssetDescriptor<TextureAtlas>("animacio/walk_02.atlas", TextureAtlas.class);

	public static final AssetDescriptor<TextureAtlas> EXPLOSION_TEXTURE
			= new AssetDescriptor<TextureAtlas>("animacio/explosion.atlas", TextureAtlas.class);

	public static final AssetDescriptor<TextureAtlas> PUNCH_TEXTURE
			= new AssetDescriptor<TextureAtlas>("animacio/punch.atlas", TextureAtlas.class);


	public static final AssetDescriptor<TextureAtlas> RAVEN_TEXTURE
			= new AssetDescriptor<TextureAtlas>("animacio/hollo.atlas", TextureAtlas.class);


	//Hangok
    public static final AssetDescriptor<Music> HATTER_SOUND
            = new AssetDescriptor<Music>("hangok/zene.mp3", Music.class);

	public static final AssetDescriptor<Music> MENU_SOUND
			= new AssetDescriptor<Music>("hangok/nature.mp3", Music.class);

	public static final AssetDescriptor<Sound> BECSAPODAS_SOUND
			= new AssetDescriptor<Sound>("hangok/impact_sound.wav", Sound.class);

	public static final AssetDescriptor<Sound> KILOVES_SOUND
			= new AssetDescriptor<Sound>("hangok/cannon_sound.wav", Sound.class);

	public static final AssetDescriptor<Sound> HOLLO_SOUND
			= new AssetDescriptor<Sound>("hangok/Raven_sound_.wav", Sound.class);

	public static final AssetDescriptor<Sound> HALAL_SOUND
			= new AssetDescriptor<Sound>("hangok/halal.wav", Sound.class);

	public static final AssetDescriptor<Sound> OSSZEOMLAS_SOUND
			= new AssetDescriptor<Sound>("hangok/osszeomlas.wav", Sound.class);

	public static final AssetDescriptor<Sound> SEBESULES_SOUND
			= new AssetDescriptor<Sound>("hangok/sebesules.wav", Sound.class);

	public static final AssetDescriptor<Sound> TROMBITA_2_SOUND
			= new AssetDescriptor<Sound>("hangok/Trumpet_1.wav", Sound.class);

	public static final AssetDescriptor<Sound> WINNER_SOUND
			=new AssetDescriptor<Sound>("hangok/Winner.wav", Sound.class);

	public static void prepare() {
		manager = new AssetManager();
		Texture.setAssetManager(manager);
	}



	public static void load() {
		FileHandleResolver resolver = new InternalFileHandleResolver();
		manager.setLoader(FreeTypeFontGenerator.class, new FreeTypeFontGeneratorLoader(resolver));
		manager.setLoader(BitmapFont.class, ".ttf", new FreetypeFontLoader(resolver));
		manager.setLoader(BitmapFont.class, ".otf", new FreetypeFontLoader(resolver));


		manager.load(ARIAL_30_FONT);
		manager.load(MEDIEVAL_30_FONT);
		manager.load(BACKGROUND_TEXTURE);
		manager.load(BACKGROUND2_TEXTURE);
		manager.load(KNOB_TEXTURE);
		manager.load(SLIDER_TEXTURE);
		manager.load(HP_FEKETE_TEXTURE);
		manager.load(HP_PIROS_TEXTURE);
		manager.load(ICON_TEXTURE);

		//Actorok
        manager.load(CANNON_TEXTURE);
        manager.load(LOVEDEK_TEXTURE);
        manager.load(TENT_TEXTURE);
		manager.load(TENT_TOP_TEXTURE);
		manager.load(CLOUD_TEXTURE);
		manager.load(CANNON_TOP_TEXTURE);
		manager.load(OSEMBER_TEXTURE);
		manager.load(FLOPPY_TEXTURE);

		//Vár texturái
		manager.load(CASTLE_TOP_TEXTURE);
		manager.load(CASTLE_TEXTURE);
		manager.load(VAR1_TEXTURE);
		manager.load(VAR2_TOP_TEXTURE);
		manager.load(VAR2_TEXTURE);
		manager.load(VAR3_TOP_TEXTURE);
		manager.load(VAR3_TEXTURE);

		//Animált texturák atlaszai
		manager.load(WALK_TEXTURE);
		manager.load(PUNCH_TEXTURE);
		manager.load(RAVEN_TEXTURE);
		manager.load(EXPLOSION_TEXTURE);

		//Hangok
		manager.load(HATTER_SOUND);
		manager.load(MENU_SOUND);
		manager.load(KILOVES_SOUND);
		manager.load(BECSAPODAS_SOUND);
		manager.load(HOLLO_SOUND);
		manager.load(HALAL_SOUND);
		manager.load(OSSZEOMLAS_SOUND);
		manager.load(SEBESULES_SOUND);
		manager.load(TROMBITA_2_SOUND);
		manager.load(WINNER_SOUND);

        //Gomb texturák
		manager.load(BLUE_TEXTURE);
		manager.load(GREEN_TEXTURE);
		manager.load(YELLOW_TEXTURE);
		manager.load(BTN_HEAL_TEXTURE);
		manager.load(BTN_HEAL_DOWN_TEXTURE);
		manager.load(BTN_START_TEXTURE);
		manager.load(BTN_START_DOWN_TEXTURE);
		manager.load(BTN_EXIT_TEXTURE);
		manager.load(BTN_EXIT_DOWN_TEXTURE);
		manager.load(BTN_TRYAGAIN_TEXTURE);
		manager.load(BTN_TRYAGAIN_DOWN_TEXTURE);

	}

    public static void afterLoaded() {
        //manager.get(MUSIC).setLooping(true);
    }

	public static void unload() {
		manager.dispose();
	}

}
