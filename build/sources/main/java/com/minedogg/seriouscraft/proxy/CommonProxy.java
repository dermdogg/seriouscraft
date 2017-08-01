package com.minedogg.seriouscraft.proxy;

import com.minedogg.seriouscraft.handlers.ItemHandler;

public class CommonProxy implements IProxy {

	public void preInit()
	{
		ItemHandler.init();
	}
	
	public void init() {
		
	}
	
	public void postInit() {
		
	}
}
