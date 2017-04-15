package com.deflatedpickle.justjunk.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModCrafting {
    public static void register(){
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.emptytincan), ModItems.tiningot, ModItems.tiningot);
        GameRegistry.addSmelting(ModItems.emptytincan, new ItemStack(ModItems.tiningot), 0.5F);
        GameRegistry.addSmelting(ModBlocks.tinore, new ItemStack(ModItems.tiningot), 1.0F);
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.tinblock), "TTT", "TTT", "TTT", 'T', ModItems.tiningot);
    }
}
