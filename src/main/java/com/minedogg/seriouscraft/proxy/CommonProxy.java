package com.minedogg.seriouscraft.proxy;

import com.minedogg.seriouscraft.handlers.ItemHandler;

public class CommonProxy implements IProxy {

	public void preInit()
	{
		System.out.println("#SC - COMMON PROXY pre init");
		
		System.out.println("#SC - COMMON PROXY pre init done");
	}
	
	public void init() 
	{
		System.out.println("#SC - COMMON PROXY init");
		ItemHandler.init();
		System.out.println("#SC - COMMON PROXY init done");
	}
	
	public void postInit() 
	{
		System.out.println("#SC - COMMON PROXY post init");
		System.out.println("#SC - COMMON PROXY post init done");		
	}
}
