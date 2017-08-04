package com.minedogg.seriouscraft.proxy;

public class ClientProxy extends CommonProxy 
{
	public void preInit()
	{
		System.out.println("#SC - CLIENT PROXY pre init");
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
