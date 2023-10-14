package io.github.foundationgames.sandwichable.items;

import io.github.foundationgames.sandwichable.Sandwichable;
import io.github.foundationgames.sandwichable.blocks.BlocksRegistry;
import io.github.foundationgames.sandwichable.entity.EntitiesRegistry;
import io.github.foundationgames.sandwichable.fluids.FluidsRegistry;
import io.github.foundationgames.sandwichable.util.Util;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Rarity;

public final class ItemsRegistry {
    public static final FoodComponent BREADSLICE = (new FoodComponent.Builder()).hunger(2).saturationModifier(0.5F).build();
    public static final FoodComponent TOASTEDBREADSLICE = (new FoodComponent.Builder()).hunger(3).saturationModifier(0.6F).build();
    public static final FoodComponent ANCIENTGRAINBREAD = (new FoodComponent.Builder()).build();
    public static final FoodComponent LETTUCEHEAD = (new FoodComponent.Builder()).hunger(5).saturationModifier(0.8F).snack().build();
    public static final FoodComponent LETTUCELEAF = (new FoodComponent.Builder()).hunger(1).saturationModifier(0.3F).snack().build();
    public static final FoodComponent TOMATOSLICE = (new FoodComponent.Builder()).hunger(2).saturationModifier(0.7F).snack().build();
    public static final FoodComponent COOKEDTOMATOSLICE = (new FoodComponent.Builder()).hunger(3).saturationModifier(0.7F).snack().build();
    public static final FoodComponent CUCUMBER_FOOD = (new FoodComponent.Builder()).hunger(3).saturationModifier(0.6F).build();
    public static final FoodComponent PICKLEDCUCUMBER = (new FoodComponent.Builder()).hunger(4).saturationModifier(0.6F).build();
    public static final FoodComponent PICKLECHIPS = (new FoodComponent.Builder()).hunger(2).saturationModifier(0.5F).snack().build();
    public static final FoodComponent CHOPPEDONION = (new FoodComponent.Builder()).hunger(2).saturationModifier(0.6F).snack().build();
    public static final FoodComponent COOKEDCHOPPEDONION = (new FoodComponent.Builder()).hunger(3).saturationModifier(0.6F).snack().build();
    public static final FoodComponent CRIMSONFUNGUS = (new FoodComponent.Builder()).hunger(4).saturationModifier(0.5F).build();
    public static final FoodComponent SLICEDCRIMSONFUNGUS = (new FoodComponent.Builder()).hunger(2).saturationModifier(0.6F).snack().build();
    public static final FoodComponent WARPEDFUNGUS = (new FoodComponent.Builder()).hunger(5).saturationModifier(0.4F).build();
    public static final FoodComponent SLICEDWARPEDFUNGUS = (new FoodComponent.Builder()).hunger(3).saturationModifier(0.5F).snack().build();
    public static final FoodComponent CHOPPEDCARROT = (new FoodComponent.Builder()).hunger(2).saturationModifier(0.5F).snack().build();
    public static final FoodComponent COOKEDCHOPPEDCARROT = (new FoodComponent.Builder()).hunger(3).saturationModifier(0.6F).snack().build();
    public static final FoodComponent CHOPPEDGOLDCARROT = (new FoodComponent.Builder()).hunger(3).saturationModifier(0.8F).snack().build();
    public static final FoodComponent CHOPPEDBEETROOT = (new FoodComponent.Builder()).hunger(3).saturationModifier(0.6F).snack().build();
    public static final FoodComponent COOKEDCHOPPEDBEETROOT = (new FoodComponent.Builder()).hunger(4).saturationModifier(0.7F).snack().build();
    public static final FoodComponent SWEETBERRYJAM = (new FoodComponent.Builder()).hunger(5).saturationModifier(0.5F).build();
    public static final FoodComponent GLOWBERRYJAM = (new FoodComponent.Builder()).hunger(5).saturationModifier(0.5F).build();
    public static final FoodComponent MAYONNAISE_FOOD = (new FoodComponent.Builder()).hunger(4).saturationModifier(0.6F).build();
    public static final FoodComponent APPLESLICES = (new FoodComponent.Builder()).hunger(2).saturationModifier(0.5F).snack().build();
    public static final FoodComponent GOLDAPPLESLICES = (new FoodComponent.Builder()).hunger(3).saturationModifier(0.7F).snack().statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 50, 1), 1.0F).statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 1200, 0), 1.0F).alwaysEdible().build();
    public static final FoodComponent ENCHANTEDGOLDAPPLESLICES = (new FoodComponent.Builder()).hunger(4).saturationModifier(0.8F).snack().statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 200, 1), 1.0F).statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 3000, 0), 1.0F).statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 3000, 0), 1.0F).statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 1200, 3), 1.0F).alwaysEdible().build();
    public static final FoodComponent BURNTFOOD = (new FoodComponent.Builder()).hunger(1).saturationModifier(0.1F).build();
    public static final FoodComponent BURNTMORSEL = (new FoodComponent.Builder()).hunger(1).saturationModifier(0F).build();

    public static final Item SANDWICH = new SandwichBlockItem(BlocksRegistry.SANDWICH);

    public static final Item BREAD_SLICE = new InfoTooltipItem(new Item.Settings().food(BREADSLICE));
    public static final Item TOASTED_BREAD_SLICE = new InfoTooltipItem(new Item.Settings().food(TOASTEDBREADSLICE));
    public static final Item LETTUCE_HEAD = new InfoTooltipItem(new Item.Settings().food(LETTUCEHEAD));
    public static final Item LETTUCE_LEAF = new InfoTooltipItem(new Item.Settings().food(LETTUCELEAF));
    public static final Item CHEESE_WHEEL_REGULAR = new CheeseItem(CheeseType.REGULAR, false);
    public static final Item CHEESE_SLICE_REGULAR = new CheeseItem(CheeseType.REGULAR, true);
    public static final Item CHEESE_WHEEL_CREAMY = new CheeseItem(CheeseType.CREAMY, false);
    public static final Item CHEESE_SLICE_CREAMY = new CheeseItem(CheeseType.CREAMY, true);
    public static final Item CHEESE_WHEEL_INTOXICATING = new CheeseItem(CheeseType.INTOXICATING, false);
    public static final Item CHEESE_SLICE_INTOXICATING = new CheeseItem(CheeseType.INTOXICATING, true);
    public static final Item CHEESE_WHEEL_SOUR = new CheeseItem(CheeseType.SOUR, false);
    public static final Item CHEESE_SLICE_SOUR = new CheeseItem(CheeseType.SOUR, true);
    public static final Item CHEESE_WHEEL_CANDESCENT = new CheeseItem(CheeseType.CANDESCENT, false);
    public static final Item CHEESE_SLICE_CANDESCENT = new CheeseItem(CheeseType.CANDESCENT, true);
    public static final Item CHEESE_WHEEL_WARPED_BLEU = new CheeseItem(CheeseType.WARPED_BLEU, false);
    public static final Item CHEESE_SLICE_WARPED_BLEU = new CheeseItem(CheeseType.WARPED_BLEU, true);
    public static final Item CHEESE_CULTURE_REGULAR = new CheeseCultureItem(CheeseType.REGULAR, 4, 0.9f, new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE).maxCount(1));
    public static final Item CHEESE_CULTURE_CREAMY = new CheeseCultureItem(CheeseType.CREAMY, 8, 1f, new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE).maxCount(1));
    public static final Item CHEESE_CULTURE_INTOXICATING = new CheeseCultureItem(CheeseType.INTOXICATING, 4, 0.9f, new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE).maxCount(1));
    public static final Item CHEESE_CULTURE_SOUR = new CheeseCultureItem(CheeseType.SOUR, 6, 0.77f, new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE).maxCount(1));
    public static final Item CHEESE_CULTURE_CANDESCENT = new CheeseCultureItem(CheeseType.CANDESCENT, 5, 0.63f, new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE).maxCount(1));
    public static final Item CHEESE_CULTURE_WARPED_BLEU = new CheeseCultureItem(CheeseType.WARPED_BLEU, 5, 0.6f, new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE).maxCount(1));
    public static final Item TOMATO_SLICE = new InfoTooltipItem(new Item.Settings().food(TOMATOSLICE));
    public static final Item COOKED_TOMATO_SLICE = new InfoTooltipItem(new Item.Settings().food(COOKEDTOMATOSLICE));
    public static final Item CUCUMBER = new InfoTooltipItem(new Item.Settings().food(CUCUMBER_FOOD));
    public static final Item PICKLED_CUCUMBER = new InfoTooltipItem(new Item.Settings().food(PICKLEDCUCUMBER));
    public static final Item PICKLE_CHIPS = new InfoTooltipItem(new Item.Settings().food(PICKLECHIPS));
    public static final Item SALT_ROCK = new InfoTooltipItem(new Item.Settings());
    public static final Item SALT = new InfoTooltipItem(new Item.Settings());
    public static final Item CHOPPED_ONION = new InfoTooltipItem(new Item.Settings().food(CHOPPEDONION));
    public static final Item COOKED_CHOPPED_ONION = new InfoTooltipItem(new Item.Settings().food(COOKEDCHOPPEDONION));
    public static final Item ANCIENT_GRAIN = new AncientGrainItem(new Item.Settings());
    public static final Item ANCIENT_GRAIN_BREAD = new AncientGrainBreadItem(new Item.Settings().food(ANCIENTGRAINBREAD), 1, false);
    public static final Item ANCIENT_GRAIN_BREAD_SLICE = new AncientGrainBreadItem(new Item.Settings().food(ANCIENTGRAINBREAD), 0.4f, true);
    public static final Item TOASTED_ANCIENT_GRAIN_BREAD_SLICE = new AncientGrainBreadItem(new Item.Settings().food(ANCIENTGRAINBREAD), 0.6f, true);
    public static final Item CHOPPED_CARROT = new InfoTooltipItem(new Item.Settings().food(CHOPPEDCARROT));
    public static final Item COOKED_CHOPPED_CARROT = new InfoTooltipItem(new Item.Settings().food(COOKEDCHOPPEDCARROT));
    public static final Item CHOPPED_GOLDEN_CARROT = new InfoTooltipItem(new Item.Settings().food(CHOPPEDGOLDCARROT));
    public static final Item CHOPPED_BEETROOT = new InfoTooltipItem(new Item.Settings().food(CHOPPEDBEETROOT));
    public static final Item COOKED_CHOPPED_BEETROOT = new InfoTooltipItem(new Item.Settings().food(COOKEDCHOPPEDBEETROOT));
    public static final Item SWEET_BERRY_JAM = new BottledFoodItem(true, new Item.Settings().food(SWEETBERRYJAM).maxCount(16));
    public static final Item GLOW_BERRY_JAM = new BottledFoodItem(true, new Item.Settings().food(GLOWBERRYJAM).maxCount(16));
    public static final Item MAYONNAISE = new BottledFoodItem(true, new Item.Settings().food(MAYONNAISE_FOOD).maxCount(16));
    public static final Item APPLE_SLICES = new InfoTooltipItem(new Item.Settings().food(APPLESLICES));
    public static final Item GOLDEN_APPLE_SLICES = new InfoTooltipItem(new Item.Settings().food(GOLDAPPLESLICES).rarity(Rarity.RARE));
    public static final Item ENCHANTED_GOLDEN_APPLE_SLICES = new EnchantedGlintItem(new Item.Settings().food(ENCHANTEDGOLDAPPLESLICES).rarity(Rarity.EPIC));
    public static final Item TOASTED_CRIMSON_FUNGUS = new InfoTooltipItem(new Item.Settings().food(CRIMSONFUNGUS));
    public static final Item TOASTED_WARPED_FUNGUS = new InfoTooltipItem(new Item.Settings().food(WARPEDFUNGUS));
    public static final Item SLICED_TOASTED_CRIMSON_FUNGUS = new InfoTooltipItem(new Item.Settings().food(SLICEDCRIMSONFUNGUS));
    public static final Item SLICED_TOASTED_WARPED_FUNGUS = new InfoTooltipItem(new Item.Settings().food(SLICEDWARPEDFUNGUS));
    public static final Item BURNT_FOOD = new InfoTooltipItem(new Item.Settings().food(BURNTFOOD));
    public static final Item BURNT_MORSEL = new InfoTooltipItem(new Item.Settings().food(BURNTMORSEL));
    public static final Item CHARRED_MORSEL = new InfoTooltipItem(new Item.Settings());

    public static final Item SANDWICH_TABLE_MINECART = new CustomMinecartItem(EntitiesRegistry.SANDWICH_TABLE_MINECART, new Item.Settings().maxCount(1));
    public static final Item FERMENTING_MILK_BUCKET = new FermentingMilkBucketItem(new Item.Settings().maxCount(1));
    public static final Item PICKLE_BRINE_BUCKET = new CustomBucketItem(FluidsRegistry.PICKLE_BRINE, new Item.Settings().maxCount(1), world -> false);

    public static final Item LETTUCE_SEEDS = new InfoTooltipAliasedBlockItem(BlocksRegistry.LETTUCE, new Item.Settings());
    public static final Item CUCUMBER_SEEDS = new InfoTooltipAliasedBlockItem(BlocksRegistry.CUCUMBERS, new Item.Settings());
    public static final Item ANCIENT_GRAIN_SEEDS = new InfoTooltipAliasedBlockItem(BlocksRegistry.ANCIENT_GRAIN, new Item.Settings());

    public static final Item EMPTY_PICKLE_JAR = new PickleJarBlockItem("pickle_jar.content.air", true, new Item.Settings());
    public static final Item WATER_FILLED_PICKLE_JAR = new PickleJarBlockItem("pickle_jar.content.water", false, new Item.Settings().maxCount(1));
    public static final Item CUCUMBER_FILLED_PICKLE_JAR = new PickleJarBlockItem("pickle_jar.content.water", false, new Item.Settings().maxCount(1));
    public static final Item PICKLING_PICKLE_JAR = new PickleJarBlockItem("pickle_jar.content.brine", false, new Item.Settings().maxCount(1));
    public static final Item PICKLE_FILLED_PICKLE_JAR = new PickleJarBlockItem("pickle_jar.content.brine", false, new Item.Settings().maxCount(1));

    public static final Item SPREAD = new SpreadItem();

    private static void addCompostable(float chance, Item item) {
        CompostingChanceRegistry.INSTANCE.add(item, chance);
    }

    public static void init() {
        registerInternalItem(SANDWICH, "sandwich");
        registerItem(BREAD_SLICE, "bread_slice");
        registerItem(TOASTED_BREAD_SLICE, "toasted_bread_slice");
        registerItem(LETTUCE_HEAD, "lettuce_head");
        addCompostable(0.65f, LETTUCE_HEAD);
        registerItem(LETTUCE_LEAF, "lettuce_leaf");
        addCompostable(0.3f, LETTUCE_LEAF);
        registerItem(TOMATO_SLICE, "tomato_slice");
        addCompostable(0.3f, TOMATO_SLICE);
        registerItem(COOKED_TOMATO_SLICE, "cooked_tomato_slice");
        registerItem(CUCUMBER, "cucumber");
        addCompostable(0.65f, CUCUMBER);
        registerItem(PICKLED_CUCUMBER, "pickled_cucumber");
        registerItem(PICKLE_CHIPS, "pickle_chips");
        registerItem(SALT_ROCK, "salt_rock");
        registerItem(SALT, "salt");
        registerInternalItem(WATER_FILLED_PICKLE_JAR, "water_filled_pickle_jar");
        registerInternalItem(CUCUMBER_FILLED_PICKLE_JAR, "cucumber_filled_pickle_jar");
        registerInternalItem(PICKLING_PICKLE_JAR, "pickling_pickle_jar");
        registerInternalItem(PICKLE_FILLED_PICKLE_JAR, "pickle_filled_pickle_jar");
        registerItem(EMPTY_PICKLE_JAR, "empty_pickle_jar");
        registerItem(CHOPPED_ONION, "chopped_onion");
        addCompostable(0.3f, CHOPPED_ONION);
        registerItem(COOKED_CHOPPED_ONION, "cooked_chopped_onion");
        registerItem(ANCIENT_GRAIN, "ancient_grain");
        registerItem(ANCIENT_GRAIN_BREAD, "ancient_grain_bread");
        registerItem(ANCIENT_GRAIN_BREAD_SLICE, "ancient_grain_bread_slice");
        registerItem(TOASTED_ANCIENT_GRAIN_BREAD_SLICE, "toasted_ancient_grain_bread_slice");
        registerItem(CHOPPED_CARROT, "chopped_carrot");
        addCompostable(0.3f, CHOPPED_CARROT);
        registerItem(COOKED_CHOPPED_CARROT, "cooked_chopped_carrot");
        registerItem(CHOPPED_GOLDEN_CARROT, "chopped_golden_carrot");
        registerItem(CHOPPED_BEETROOT, "chopped_beetroot");
        addCompostable(0.3f, CHOPPED_BEETROOT);
        registerItem(COOKED_CHOPPED_BEETROOT, "cooked_chopped_beetroot");
        registerItem(SWEET_BERRY_JAM, "sweet_berry_jam_bottle");
        registerItem(GLOW_BERRY_JAM, "glow_berry_jam_bottle");
        registerItem(MAYONNAISE, "mayonnaise_bottle");
        registerItem(APPLE_SLICES, "apple_slices");
        addCompostable(0.3f, APPLE_SLICES);
        registerItem(GOLDEN_APPLE_SLICES, "golden_apple_slices");
        registerItem(ENCHANTED_GOLDEN_APPLE_SLICES, "enchanted_golden_apple_slices");
        registerItem(CHEESE_CULTURE_REGULAR, "regular_cheese_culture_bottle");
        registerItem(CHEESE_CULTURE_CREAMY, "creamy_cheese_culture_bottle");
        registerItem(CHEESE_CULTURE_INTOXICATING, "intoxicating_cheese_culture_bottle");
        registerItem(CHEESE_CULTURE_SOUR, "sour_cheese_culture_bottle");
        registerItem(CHEESE_CULTURE_CANDESCENT, "candescent_cheese_culture_bottle");
        registerItem(CHEESE_CULTURE_WARPED_BLEU, "warped_bleu_cheese_culture_bottle");
        registerItem(CHEESE_WHEEL_REGULAR, "cheese_wheel");
        registerItem(CHEESE_SLICE_REGULAR, "cheese_slice");
        registerItem(CHEESE_WHEEL_CREAMY, "creamy_cheese_wheel");
        registerItem(CHEESE_SLICE_CREAMY, "creamy_cheese_slice");
        registerItem(CHEESE_WHEEL_INTOXICATING, "intoxicating_cheese_wheel");
        registerItem(CHEESE_SLICE_INTOXICATING, "intoxicating_cheese_slice");
        registerItem(CHEESE_WHEEL_SOUR, "sour_cheese_wheel");
        registerItem(CHEESE_SLICE_SOUR, "sour_cheese_slice");
        registerItem(CHEESE_WHEEL_CANDESCENT, "candescent_cheese_wheel");
        registerItem(CHEESE_SLICE_CANDESCENT, "candescent_cheese_slice");
        registerItem(CHEESE_WHEEL_WARPED_BLEU, "warped_bleu_cheese_wheel");
        registerItem(CHEESE_SLICE_WARPED_BLEU, "warped_bleu_cheese_slice");
        registerItem(TOASTED_CRIMSON_FUNGUS, "toasted_crimson_fungus");
        registerItem(TOASTED_WARPED_FUNGUS, "toasted_warped_fungus");
        registerItem(SLICED_TOASTED_CRIMSON_FUNGUS, "sliced_toasted_crimson_fungus");
        registerItem(SLICED_TOASTED_WARPED_FUNGUS, "sliced_toasted_warped_fungus");
        registerItem(LETTUCE_SEEDS, "lettuce_seeds");
        addCompostable(0.3f, LETTUCE_SEEDS);
        registerItem(CUCUMBER_SEEDS, "cucumber_seeds");
        addCompostable(0.3f, CUCUMBER_SEEDS);
        registerItem(ANCIENT_GRAIN_SEEDS, "ancient_grain_seeds");
        addCompostable(0.4f, ANCIENT_GRAIN_SEEDS);
        registerItem(BURNT_FOOD, "burnt_food");
        registerItem(BURNT_MORSEL, "burnt_morsel");
        registerItem(CHARRED_MORSEL, "charred_morsel");
        FuelRegistry.INSTANCE.add(CHARRED_MORSEL, 360);
        registerItem(SANDWICH_TABLE_MINECART, "sandwich_table_minecart");
        registerItem(FERMENTING_MILK_BUCKET, "fermenting_milk_bucket");
        registerItem(PICKLE_BRINE_BUCKET, "pickle_brine_bucket");
        registerInternalItem(SPREAD, "spread");
    }

    private static void registerItem(Item item, String name) {
        registerInternalItem(item, name);
        Sandwichable.SANDWICHABLE_ITEMS.queue(item);
    }

    private static void registerInternalItem(Item item, String name) {
        Registry.register(Registries.ITEM, Util.id(name), item);
    }
}
