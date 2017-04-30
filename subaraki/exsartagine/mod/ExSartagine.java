package subaraki.exsartagine.mod;

import java.util.Arrays;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.ModMetadata;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import subaraki.exsartagine.block.ExSartagineBlock;
import subaraki.exsartagine.item.ExSartagineItems;
import subaraki.exsartagine.proxy.ServerProxy;

@Mod(name = ExSartagine.NAME, modid = ExSartagine.MODID, version = ExSartagine.VERSION, dependencies = ExSartagine.DEPENDENCY)
public class ExSartagine {

	public static final String MODID = "exsartagine";
	public static final String NAME = "exsartagine mod";
	public static final String VERSION = "1.11 0.0.0.1";
	public static final String DEPENDENCY = "required-after:subcommonlib";
	
	@SidedProxy(serverSide = "subaraki.exsartagine.proxy.ServerProxy" , clientSide = "subaraki.exsartagine.proxy.ClientProxy")
	public static ServerProxy proxy;
	
	@EventHandler
	public static void preInit(FMLPreInitializationEvent event){
		ModMetadata modMeta = event.getModMetadata();
		modMeta.authorList = Arrays.asList(new String[] { "Subaraki" });
		modMeta.autogenerated = false;
		modMeta.credits = "";
		modMeta.description = "Thermo Efficient Pan";
		modMeta.url = "";
		
		ExSartagineBlock.load();
		ExSartagineItems.load();
		
		proxy.registerTileEntityAndRenderer();
		proxy.registerRenders();
	}
}
