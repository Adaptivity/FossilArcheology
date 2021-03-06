package mods.fossil.client.renderer.entity;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.fossil.entity.mob.EntityGastornis;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderGastornis extends RenderLiving
{

    public RenderGastornis(ModelBase par1ModelBase, float par2)
    {
        super(par1ModelBase, par2);
    }

    public void renderGastornis(EntityGastornis par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        super.doRenderLiving(par1Entity, par2, par4, par6, par8, par9);
    }

    protected ResourceLocation func_110919_a(EntityGastornis par1Entity)
    {
        return new ResourceLocation(par1Entity.getTexture());
    }

    protected float getWingRotation(EntityGastornis par1EntityLiving, float par2)
    {
        float f1 = par1EntityLiving.field_70888_h + (par1EntityLiving.field_70886_e - par1EntityLiving.field_70888_h) * par2;
        float f2 = par1EntityLiving.field_70884_g + (par1EntityLiving.destPos - par1EntityLiving.field_70884_g) * par2;
        return (MathHelper.sin(f1) + 1.0F) * f2;
    }

    public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderGastornis((EntityGastornis)par1EntityLiving, par2, par4, par6, par8, par9);
    }

    /**
     * Defines what float the third param in setRotationAngles of ModelBase is
     */
    protected float handleRotationFloat(EntityLivingBase par1EntityLivingBase, float par2)
    {
        return this.getWingRotation((EntityGastornis)par1EntityLivingBase, par2);
    }

    protected ResourceLocation getEntityTexture(Entity par1Entity)
    {
        return this.func_110919_a((EntityGastornis)par1Entity);
    }

    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity) and this method has signature public void doRender(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
     */
    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderGastornis((EntityGastornis)par1Entity, par2, par4, par6, par8, par9);
    }
}
