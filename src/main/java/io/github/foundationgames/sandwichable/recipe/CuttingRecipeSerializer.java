package io.github.foundationgames.sandwichable.recipe;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.nhoryzon.mc.farmersdelight.recipe.CuttingBoardRecipe;
import com.nhoryzon.mc.farmersdelight.recipe.CuttingBoardRecipeSerializer;
import com.nhoryzon.mc.farmersdelight.recipe.ingredient.ChanceResult;
import com.nhoryzon.mc.farmersdelight.registry.TagsRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;

public class CuttingRecipeSerializer extends CuttingBoardRecipeSerializer {
    public static final CuttingRecipeSerializer INSTANCE = new CuttingRecipeSerializer();
    public static final Identifier ID = new Identifier("sandwichable:cutting_recipe");

    @Override
    public CuttingBoardRecipe read(Identifier id, JsonObject json) {
        CuttingRecipeJsonFormat recipeJson = new Gson().fromJson(json, CuttingRecipeJsonFormat.class);

        if(recipeJson.input == null || recipeJson.outputItem == null) { throw new JsonSyntaxException("Missing Attributes in Cutting Recipe!"); }
        Ingredient input = Ingredient.fromJson(recipeJson.getInput());
        Item outputItem = Registries.ITEM.getOrEmpty(new Identifier(recipeJson.getOutputItemId())).orElseThrow(() -> new JsonSyntaxException("The Item " + recipeJson.outputItem + " does not exist!"));
        ItemStack outputStack = new ItemStack(outputItem, recipeJson.getOutputCount());

        return new CuttingBoardRecipe(id, "", input, Ingredient.fromTag(TagsRegistry.KNIVES), DefaultedList.ofSize(1, new ChanceResult(outputStack, 1.0f)), "");
    }
}
