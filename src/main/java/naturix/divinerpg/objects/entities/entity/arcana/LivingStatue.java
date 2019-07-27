package naturix.divinerpg.objects.entities.entity.arcana;

import com.google.common.base.Predicate;

import naturix.divinerpg.enums.ArrowType;
import naturix.divinerpg.objects.entities.entity.EntityDivineRPGMob;
import naturix.divinerpg.objects.entities.entity.projectiles.EntityDivineArrow;
import naturix.divinerpg.registry.ModSounds;
import naturix.divinerpg.utils.Reference;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackRanged;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class LivingStatue extends EntityDivineRPGMob implements IRangedAttackMob {
    public static final ResourceLocation LOOT = new ResourceLocation(Reference.MODID, "entities/arcana/living_statue");

    public LivingStatue(World world) {
        super(world);
    }

    @Override
    protected void initEntityAI() {
        super.initEntityAI();
        this.targetTasks.addTask(1,
                new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true, false, (Predicate) null));
        this.tasks.addTask(1, new EntityAIAttackRanged(this, 0.27D, 10, 60));
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(60.0D);
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource s) {
        return ModSounds.HIGH_HIT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.HIGH_HIT;
    }

    @Override
    public void attackEntityWithRangedAttack(EntityLivingBase target, float f) {
        this.world.spawnEntity(
                new EntityDivineArrow(this.world, ArrowType.LIVING_STATUE_ARROW, this, target, 1.6F, 12.0F));
    }

    @Override
    public void setSwingingArms(boolean swingingArms) {
    }

    @Override
    protected ResourceLocation getLootTable() {
        return this.LOOT;
    }

    @Override
    public boolean getCanSpawnHere() {
        return this.posY < 40.0D && super.getCanSpawnHere();
    }
}