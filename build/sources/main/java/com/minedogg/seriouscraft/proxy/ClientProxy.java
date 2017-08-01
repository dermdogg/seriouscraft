package com.minedogg.seriouscraft.proxy;

import com.minedogg.seriouscraft.handlers.ItemHandler;

public class ClientProxy extends CommonProxy 
{
	public void init()
	{
		ItemHandler.registerRenders();
	}
}
