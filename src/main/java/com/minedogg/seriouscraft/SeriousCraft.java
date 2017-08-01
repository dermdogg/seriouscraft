package com.minedogg.seriouscraft;


import com.minedogg.seriouscraft.proxy.CommonProxy;

//import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = SeriousCraft.MODID, name=SeriousCraft.NAME, version = SeriousCraft.VERSION)
public class SeriousCraft
{
    public static final String MODID = "seriouscraft";
    public static final String NAME = "SERiOUSCRAFT";
    public static final String VERSION = "0.0.0.1";
    public static final String CLIENT_PROXY = "com.minedogg.seriouscraft.proxy.ClientProxy";
    public static final String SERVER_PROXY = "com.minedogg.seriouscraft.proxy.CommonProxy";
        
    @SidedProxy(clientSide=SeriousCraft.CLIENT_PROXY, serverSide=SeriousCraft.SERVER_PROXY)
    public static CommonProxy proxy;
    
    
    
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) 
    {
        System.out.println("\n!!!!!!!!!!!!!!!!!!!!!!!\n<< --- --- PRE-INIT --- --->>\n!!!!!!!!!!!!!!!!!!!!!!!");
        proxy.preInit();
    }
    
    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        System.out.println("\n!!!!!!!!!!!!!!!!!!!!!!!\n<< --- --- INIT --- --->>\n!!!!!!!!!!!!!!!!!!!!!!!");
        proxy.init();    
        
    }
    
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) 
    {
        System.out.println("\n!!!!!!!!!!!!!!!!!!!!!!!\n<< --- --- POST-INIT --- --->>\n!!!!!!!!!!!!!!!!!!!!!!!");
        proxy.postInit();
    }
}
