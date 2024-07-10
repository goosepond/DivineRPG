package divinerpg.items.base;

import divinerpg.util.LocalizeUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.neoforged.api.distmarker.*;
import java.util.List;

public class ItemModHoe extends HoeItem {
    public ItemModHoe(Tier tier, Rarity rarity) {super(tier, 0, 0, new Properties().rarity(rarity));}
    public ItemModHoe(Tier tier, float attackSpeed) {super(tier, 0, attackSpeed, new Properties());}
    public ItemModHoe(Tier tier, Properties properties) {super(tier, 0, 0, properties);}
    @SuppressWarnings("deprecation")
	@OnlyIn(Dist.CLIENT)
    @Override public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.efficiency((int)speed));
        tooltip.add(LocalizeUtils.harvestLevel(getTier().getLevel()));
        if(!canBeDepleted()) stack.getOrCreateTag().putBoolean("Unbreakable", true);
    }
}