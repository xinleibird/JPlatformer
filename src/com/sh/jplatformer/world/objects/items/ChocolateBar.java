package com.sh.jplatformer.world.objects.items;

import com.sh.jplatformer.world.WorldController;
import com.sh.jplatformer.world.map.MapObject;

/**
 * A {@code MapObject} item.
 * @author Stefan H�semann
 */

public class ChocolateBar extends MapObject
{
	// Serial version
	//===============
	private static final long serialVersionUID = 1L;
	
	// Constructor
	//============
	public ChocolateBar( WorldController worldController )
	{
		// Super constructor
		//==================
		super( worldController );
		
		// Properties
		//===========
		name            = "Chocolate Bar";
		score           = 100;
		bounds.width    = 46f;
		bounds.height   = 48f;
		isBlockingSpace = false;
		ignoreGravity   = true;
		
		// Alignment
		//==========
		horizontalAlignment = ALIGN_CENTER;
		verticalAlignment = ALIGN_CENTER;
		
		// Init frames
		//============
		this.initFrames();
	}
	
	// onPlayerCollision
	//==================
	@Override
	public void onPlayerCollision()
	{
		// Set alive + add score
		//======================
		this.setAlive( false );
		worldController.addScore( score );
		worldController.addPopup( score + "",
		                          bounds.x + bounds.width  / 2f,
		                          bounds.y + bounds.height / 2f );
		
		// Play sound
		//===========
		worldController.getWorldAudio().addCollectSound();
	}
}