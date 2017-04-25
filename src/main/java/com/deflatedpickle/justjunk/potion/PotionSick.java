package com.deflatedpickle.justjunk.potion;

import com.deflatedpickle.justjunk.Reference;
import com.deflatedpickle.justjunk.init.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;

public class PotionSick extends Potion{
    public static final ResourceLocation icon = new ResourceLocation(Reference.MOD_ID, "textures/gui/inventory.png");

    private boolean isBadEffectIn;

    public PotionSick(boolean isBadEffectIn, int liquidColorIn) {
        super(isBadEffectIn, liquidColorIn);
        this.isBadEffectIn = isBadEffectIn;
        setPotionName("effect.sick");
        setIconIndex(0, 0);
    }

    public Potion setIconIndex(int x, int y){
        super.setIconIndex(x, y);
        return (Potion) this;
    }

    public int getStatusIconIndex(){
        ITextureObject texture = Minecraft.getMinecraft().renderEngine.getTexture(icon);
        Minecraft.getMinecraft().renderEngine.bindTexture(icon);
        return super.getStatusIconIndex();
    }

    private static final Item[] loot_table = new Item[] {
        Items.ROTTEN_FLESH,
        Items.REDSTONE,
        Items.APPLE,
        Items.BONE,
        Items.DIAMOND,
        Items.EGG,
        Items.DIAMOND_HOE,
        Items.GOLDEN_APPLE,
        Items.GOLD_NUGGET,
        Items.SLIME_BALL,
        Items.SUGAR,
        Items.MAP,
        Items.FEATHER,
        Items.POISONOUS_POTATO,
        Items.GHAST_TEAR,
        Items.STICK,
        Items.DYE,
        Items.PORKCHOP,
        Items.BEEF,
        Items.RABBIT,
        Items.CHICKEN,
        Items.SPIDER_EYE,
        Items.FERMENTED_SPIDER_EYE,

        ModItems.rottingfish
    };

    @Override
    public void performEffect(EntityLivingBase entityLivingBaseIn, int p_76394_2_){
        if (!entityLivingBaseIn.world.isRemote){
            EntityItem item = new EntityItem(entityLivingBaseIn.world, entityLivingBaseIn.posX + (entityLivingBaseIn.getLookVec().xCoord * 0.2F), entityLivingBaseIn.posY + entityLivingBaseIn.getEyeHeight() - 0.7F, entityLivingBaseIn.posZ + (entityLivingBaseIn.getLookVec().zCoord), new ItemStack(loot_table[(int) (Math.random() * loot_table.length)], 1));
            item.setPickupDelay(15);
            entityLivingBaseIn.world.spawnEntity(item);
        }
    }

    @Override
    public boolean isReady(int duration, int amplifier){
        int j = 1 >> amplifier;
        return j <= 0 || duration % j == 0;
    }

    @Override
    public boolean isInstant(){
        return false;
    }
}
