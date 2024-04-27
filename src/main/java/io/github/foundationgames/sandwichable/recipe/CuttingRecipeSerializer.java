package io.github.foundationgames.sandwichable.recipe;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import vectorwing.farmersdelight.common.crafting.CuttingBoardRecipe;
import vectorwing.farmersdelight.common.crafting.ingredient.ChanceResult;
import vectorwing.farmersdelight.common.tag.ModTags;

public class CuttingRecipeSerializer extends CuttingBoardRecipe.Serializer {
    public static final CuttingRecipeSerializer INSTANCE = new CuttingRecipeSerializer();
    public static final Identifier ID = new Identifier("sandwichable:cutting_recipe");

    @Override
    public CuttingBoardRecipe read(Identifier id, JsonObject json) {
        CuttingRecipeJsonFormat recipeJson = new Gson().fromJson(json, CuttingRecipeJsonFormat.class);

        if(recipeJson.input == null || recipeJson.outputItem == null) { throw new JsonSyntaxException("Missing Attributes in Cutting Recipe!"); }
        Ingredient input = Ingredient.fromJson(recipeJson.getInput());
        Item outputItem = Registries.ITEM.getOrEmpty(new Identifier(recipeJson.getOutputItemId())).orElseThrow(() -> new JsonSyntaxException("The Item " + recipeJson.outputItem + " does not exist!"));
        ItemStack outputStack = new ItemStack(outputItem, recipeJson.getOutputCount());

        return new CuttingBoardRecipe(id, "", input, Ingredient.fromTag(ModTags.KNIVES), DefaultedList.ofSize(1, new ChanceResult(outputStack, 1.0f)), "");
    }
}
