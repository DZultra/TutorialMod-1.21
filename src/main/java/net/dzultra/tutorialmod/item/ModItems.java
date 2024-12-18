package net.dzultra.tutorialmod.item;

import net.dzultra.tutorialmod.TutorialMod;
import net.dzultra.tutorialmod.item.custom.BlockUpMoverItem;
import net.dzultra.tutorialmod.item.custom.ChiselItem;
import net.dzultra.tutorialmod.item.custom.HoneyJarItem;
import net.dzultra.tutorialmod.item.custom.LauncherStaffItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.List;

public class ModItems {
    public static final Item PINK_GARNET = registerItem("pink_garnet", new Item(new Item.Settings()));
    public static final Item RAW_PINK_GARNET = registerItem("raw_pink_garnet", new Item(new Item.Settings()));

    public static final Item CHISEL = registerItem("chisel", new ChiselItem(new Item.Settings().maxDamage(32)));

    public static final Item CAULIFLOWER = registerItem("cauliflower", new Item(new Item.Settings().food(ModFoodComponents.CAULIFLOWER)) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.tutorialmod.cauliflower"));
        }
    });

    public static final Item HONEY_JAR = registerItem("honey_jar", new HoneyJarItem(new Item.Settings().food(ModFoodComponents.HONEY_JAR)));

    public static final Item STARLIGHT_ASHES = registerItem("starlight_ashes", new Item(new Item.Settings()));

    public static final Item LAUNCHER_STAFF = registerItem("launcher_staff", new LauncherStaffItem(new Item.Settings()));

    public static final Item BLOCKUP_MOVER = registerItem("blockup_mover", new BlockUpMoverItem(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(TutorialMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        TutorialMod.LOGGER.info("Registering Mod Items for " + TutorialMod.MOD_ID);
    }
}