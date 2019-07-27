package naturix.divinerpg.objects.items.vanilla;

import java.util.List;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.entities.entity.vanilla.BrownGrizzle;
import naturix.divinerpg.objects.entities.entity.vanilla.Ehu;
import naturix.divinerpg.objects.entities.entity.vanilla.Husk;
import naturix.divinerpg.objects.entities.entity.vanilla.Smelter;
import naturix.divinerpg.objects.entities.entity.vanilla.Snapper;
import naturix.divinerpg.objects.entities.entity.vanilla.StoneGolem;
import naturix.divinerpg.objects.entities.entity.vanilla.WhiteGrizzle;
import naturix.divinerpg.objects.items.base.ItemMod;
import naturix.divinerpg.registry.DivineRPGTabs;
import naturix.divinerpg.registry.ModItems;
import naturix.divinerpg.utils.TooltipHelper;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemLivestockSpawnEgg extends ItemMod {

    public ItemLivestockSpawnEgg(String name) {
        super(name, DivineRPGTabs.spawner);
        setMaxStackSize(1);
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing,
            float hitX, float hitY, float hitZ) {
        ItemStack stack = new ItemStack(player.getHeldItem(hand).getItem());
        Item item = stack.getItem();
        int x = pos.getX(), y = pos.getY(), z = pos.getZ();

        Ehu ehu = new Ehu(world, player);
        Husk husk = new Husk(world, player);
        StoneGolem stoneGolem = new StoneGolem(world, player);
        Smelter smelter = new Smelter(world, player);
        Snapper snapper = new Snapper(world, player);
        WhiteGrizzle whiteGrizzle = new WhiteGrizzle(world, player);
        BrownGrizzle brownGrizzle = new BrownGrizzle(world, player);
        if (!world.isRemote) {
            if (item == ModItems.ehuSpawner) {
                ehu.setLocationAndAngles(x, y + 1, z, 0.0F, 0.0F);
                world.spawnEntity(ehu);
            } else if (item == ModItems.huskSpawner) {
                husk.setLocationAndAngles(x, y + 1, z, 0.0F, 0.0F);
                world.spawnEntity(husk);
            } else if (item == ModItems.stoneGolemSpawner) {
                stoneGolem.setLocationAndAngles(x, y + 1, z, 0.0F, 0.0F);
                world.spawnEntity(stoneGolem);
            } else if (item == ModItems.smelterSpawner) {
                smelter.setLocationAndAngles(x, y + 1, z, 0.0F, 0.0F);
                world.spawnEntity(smelter);
            } else if (item == ModItems.snapperSpawner) {
                snapper.setLocationAndAngles(x, y + 1, z, 0.0F, 0.0F);
                world.spawnEntity(snapper);
            } else if (item == ModItems.whiteGrizzleSpawner) {
                whiteGrizzle.setLocationAndAngles(x, y + 1, z, 0.0F, 0.0F);
                world.spawnEntity(whiteGrizzle);
            } else if (item == ModItems.brownGrizzleSpawner) {
                brownGrizzle.setLocationAndAngles(x, y + 1, z, 0.0F, 0.0F);
                world.spawnEntity(brownGrizzle);
            }
            //			player.triggerAchievement(DivineRPGAchievements.littleCreature);
            stack.shrink(1);
            return EnumActionResult.PASS;
        }
        return EnumActionResult.FAIL;
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> list, ITooltipFlag flagIn) {
        Item item = stack.getItem();
        if (item == ModItems.ehuSpawner) {
            list.add(TooltipHelper.getInfoText("tooltip.ehu_egg"));
        } else if (item == ModItems.huskSpawner) {
            list.add(TooltipHelper.getInfoText("tooltip.husk_egg"));
        } else if (item == ModItems.stoneGolemSpawner) {
            list.add(TooltipHelper.getInfoText("tooltip.stone_golem_egg"));
        } else if (item == ModItems.smelterSpawner) {
            list.add(TooltipHelper.getInfoText("tooltip.smelter_egg"));
        } else if (item == ModItems.snapperSpawner) {
            list.add(TooltipHelper.getInfoText("tooltip.snapper_egg"));
        } else if (item == ModItems.whiteGrizzleSpawner) {
            list.add(TooltipHelper.getInfoText("tooltip.white_grizzle_egg"));
        } else if (item == ModItems.brownGrizzleSpawner) {
            list.add(TooltipHelper.getInfoText("tooltip.brown_grizzle_egg"));
        }
    }
}