package io.github.foundationgames.sandwichable.config;

import com.google.common.base.Suppliers;
import com.google.gson.JsonObject;
import io.github.foundationgames.sandwichable.items.ItemsRegistry;
import io.github.foundationgames.sandwichable.util.Util;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public class SandwichableConfig extends ConfigInABarrel {
    public boolean showInfoTooltips = true;
    public TooltipKeyBind infoTooltipKeyBind = TooltipKeyBind.SHIFT;

    public boolean slowEatingLargeSandwiches = true;
    public int baseSandwichEatTime = 32;

    @Value(gui = false) public ItemOptions itemOptions = new ItemOptions();
    public SaltySandGenOptions saltySandGenOptions = new SaltySandGenOptions();
    public SaltPoolGenOptions saltPoolGenOptions = new SaltPoolGenOptions();

    public static class SaltySandGenOptions {
        public boolean saltySand = true;
    }

    public static class SaltPoolGenOptions {
        public boolean saltPools = true;
        public boolean drySaltPools = true;
    }

    public static class ItemOptions {
        @Value(gui = false) public String saltItem = "sandwichable:salt";
        @Value(gui = false) public String cucumberItem = "sandwichable:cucumber";
        @Value(gui = false) public String pickledCucumberItem = "sandwichable:pickled_cucumber";
        @Value(gui = false) public String burntFoodItem = "sandwichable:burnt_food";
        @Value(gui = false) public String burntMorselItem = "sandwichable:burnt_morsel";

        @Value(gui = false) public transient final Supplier<ItemStack> saltItemGetter = Suppliers.memoize(() ->
                Util.itemFromString(saltItem, () -> new ItemStack(ItemsRegistry.SALT)));
        @Value(gui = false) public transient final Supplier<ItemStack> cucumberItemGetter = Suppliers.memoize(() ->
                Util.itemFromString(cucumberItem, () -> new ItemStack(ItemsRegistry.CUCUMBER)));
        @Value(gui = false) public transient final Supplier<ItemStack> pickledCucumberItemGetter = Suppliers.memoize(() ->
                Util.itemFromString(pickledCucumberItem, () -> new ItemStack(ItemsRegistry.PICKLED_CUCUMBER)));
        @Value(gui = false) public transient final Supplier<ItemStack> burntFoodItemGetter = Suppliers.memoize(() ->
                Util.itemFromString(burntFoodItem, () -> new ItemStack(ItemsRegistry.BURNT_FOOD)));
        @Value(gui = false) public transient final Supplier<ItemStack> burntMorselItemGetter = Suppliers.memoize(() ->
                Util.itemFromString(burntMorselItem, () -> new ItemStack(ItemsRegistry.BURNT_MORSEL)));
    }

    @Override
    public void afterLoad() {
        super.afterLoad();
    }

    @Override
    protected void loadExtraData(JsonObject file) {
    }

    public enum TooltipKeyBind {
        SHIFT("shift"),
        CTRL("control"),
        ALT("alt");

        String name;

        TooltipKeyBind(String name) { this.name = name; }

        public boolean isPressed() {
            if(this.equals(SHIFT)) {
                return Screen.hasShiftDown();
            } else if(this.equals(CTRL)) {
                return Screen.hasControlDown();
            } else if(this.equals(ALT)) {
                return Screen.hasAltDown();
            }
            return false;
        }

        public String getName() {
            return name;
        }
    }
}
