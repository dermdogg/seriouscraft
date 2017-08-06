package com.minedogg.seriouscraft.items;

import net.minecraft.block.IGrowable;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ScFertilizer extends Item
{    
	public ScFertilizer(String name, CreativeTabs tab) 
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(tab);
	}
	
	
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
		ItemStack itemstack = player.getHeldItem(hand);

        if (!player.canPlayerEdit(pos.offset(facing), facing, itemstack))
        {
            return EnumActionResult.FAIL;
        }
        else
        {
            if (applyBonemeal(itemstack, worldIn, pos.add(1, 0, -1), player, hand)) //+x-z
            {
                 if (!worldIn.isRemote)
                 {
                    worldIn.playEvent(2005, pos.add(1, 0, -1), 0);
                 }
            }
            if (applyBonemeal(itemstack, worldIn, pos.add(1, 0, 0), player, hand))//+x
            {
                 if (!worldIn.isRemote)
                 {
                    worldIn.playEvent(2005, pos.add(1, 0, 0), 0);
                 }
            }
            if (applyBonemeal(itemstack, worldIn, pos.add(1, 0, 1), player, hand))//+x+z
            {
                 if (!worldIn.isRemote)
                 {
                    worldIn.playEvent(2005, pos.add(1, 0, 1), 0);
                 }
            }
            if (applyBonemeal(itemstack, worldIn, pos.add(0, 0, -1), player, hand))//-z
            {
                 if (!worldIn.isRemote)
                 {
                    worldIn.playEvent(2005, pos.add(0, 0, -1), 0);
                 }
            }
            if (applyBonemeal(itemstack, worldIn, pos, player, hand))//p
            {
                 if (!worldIn.isRemote)
                 {
                    worldIn.playEvent(2005, pos, 0);
                 }
            }
            if (applyBonemeal(itemstack, worldIn, pos.add(0, 0, 1), player, hand))//+z
            {
                 if (!worldIn.isRemote)
                 {
                    worldIn.playEvent(2005, pos.add(0, 0, 1), 0);
                 }
            }
            if (applyBonemeal(itemstack, worldIn, pos.add(-1, 0, -1), player, hand))//-x-z
            {
                 if (!worldIn.isRemote)
                 {
                    worldIn.playEvent(2005, pos.add(-1, 0, -1), 0);
                 }
            }
            if (applyBonemeal(itemstack, worldIn, pos.add(-1, 0, 0), player, hand))//-x
            {
                 if (!worldIn.isRemote)
                 {
                    worldIn.playEvent(2005, pos.add(-1, 0, 0), 0);
                 }
            }
            if (applyBonemeal(itemstack, worldIn, pos.add(-1, 0, 1), player, hand))//-x+z
            {
                 if (!worldIn.isRemote)
                 {
                    worldIn.playEvent(2005, pos.add(-1, 0, 1), 0);
                 }
            }            
                
            return EnumActionResult.PASS;
        }
    }
	
	
	public static boolean applyBonemeal(ItemStack stack, World worldIn, BlockPos target)
    {
        if (worldIn instanceof net.minecraft.world.WorldServer)
            return applyBonemeal(stack, worldIn, target, net.minecraftforge.common.util.FakePlayerFactory.getMinecraft((net.minecraft.world.WorldServer)worldIn), null);
        return false;
    }

	
    public static boolean applyBonemeal(ItemStack stack, World worldIn, BlockPos target, EntityPlayer player, @javax.annotation.Nullable EnumHand hand)
    {
        IBlockState iblockstate = worldIn.getBlockState(target);

        int hook = net.minecraftforge.event.ForgeEventFactory.onApplyBonemeal(player, worldIn, target, iblockstate, stack, hand);
        if (hook != 0) return hook > 0;

        if (iblockstate.getBlock() instanceof IGrowable)
        {
            IGrowable igrowable = (IGrowable)iblockstate.getBlock();

            if (igrowable.canGrow(worldIn, target, iblockstate, worldIn.isRemote))
            {
                if (!worldIn.isRemote)
                {
                    if (igrowable.canUseBonemeal(worldIn, worldIn.rand, target, iblockstate))
                    {
                        igrowable.grow(worldIn, worldIn.rand, target, iblockstate);
                    }

                    stack.shrink(1);
                }

                return true;
            }
        }

        return false;
    }	
	
}
