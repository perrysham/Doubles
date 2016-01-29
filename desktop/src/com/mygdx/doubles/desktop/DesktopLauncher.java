package com.mygdx.doubles.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;
import com.badlogic.gdx.tools.texturepacker.TexturePacker.Settings;
import com.mygdx.doubles.DoublesMain;

public class DesktopLauncher {
	
	private static boolean	rebuildAtlas		= false;
	private static boolean	drawDebugOutline	= false;
	
	public static void main (String[] arg) {
		
		if (rebuildAtlas) {
			
			Settings settings = new Settings();
			settings.maxWidth = 1024;
			settings.maxHeight = 1024;
			settings.debug = drawDebugOutline;
			TexturePacker.process(settings, "assets-raw/images", "../android/assets/images", "doubles8.pack");
		}
		
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new DoublesMain(), config);
		
	}
}
