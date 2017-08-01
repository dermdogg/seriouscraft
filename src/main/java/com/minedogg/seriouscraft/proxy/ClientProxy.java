package com.minedogg.seriouscraft.proxy;

import com.minedogg.seriouscraft.handlers.ItemHandler;

public class ClientProxy extends CommonProxy 
{
	public void preInit()
	{
		System.out.println("#SC - CLIENT PROXY pre init");
		ItemHandler.registerRenders();
		System.out.println("#SC - CLIENT PROXY pre init done");
	}
	
	public void init()
	{
		System.out.println("#SC - CLIENT PROXY init");
		
		System.out.println("#SC - CLIENT PROXY init done");
	}
	
	public void postInit()
	{
		System.out.println("#SC - CLIENT PROXY post init");

		System.out.println("#SC - CLIENT PROXY post init done");
	}
}
