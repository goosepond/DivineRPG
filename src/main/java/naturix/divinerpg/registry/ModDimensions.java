package naturix.divinerpg.registry;

import naturix.divinerpg.Config;
import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.dimensions.WorldProviderEden;
import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;

public class ModDimensions {
	 public static DimensionType edenDimension;

	    public static void init() {
	        registerDimensionTypes();
	        registerDimensions();
	    }

	    private static void registerDimensionTypes() {
	        edenDimension = DimensionType.register(DivineRPG.modId + ":eden", "_eden", Config.edenDimensionId, WorldProviderEden.class, false);
	    }

	    private static void registerDimensions() {
	        DimensionManager.registerDimension(Config.edenDimensionId, edenDimension);
	    }
	}