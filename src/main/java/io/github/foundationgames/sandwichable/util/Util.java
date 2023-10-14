package io.github.foundationgames.sandwichable.util;

import com.google.common.collect.ImmutableMap;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import io.github.foundationgames.sandwichable.blocks.entity.SyncedBlockEntity;
import io.github.foundationgames.sandwichable.config.ConfigInABarrel;
import io.github.foundationgames.sandwichable.config.SandwichableConfig;
import io.github.foundationgames.sandwichable.mixin.StructurePoolAccess;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.fabricmc.fabric.api.event.registry.RegistryEntryAddedCallback;
import net.minecraft.block.Block;
import net.minecraft.client.resource.language.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.StringNbtReader;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.structure.pool.StructurePool;
import net.minecraft.structure.pool.StructurePoolElement;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Language;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.village.TradeOffers;
import net.minecraft.world.World;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Util {

    public static String MOD_ID = "sandwichable";

    public static Identifier id(String name) {
        return new Identifier(MOD_ID, name);
    }

    public static void scatterBlockDust(World world, BlockPos pos, Block block, int intensity, int density) {
        Random random = Random.create();
        for (int i = 0; i < density; i++) {
            double ox, oy, oz, vx, vy, vz;
            ox = (double)(random.nextInt(intensity * 2) - intensity) / 10;
            oy = (double)(random.nextInt(intensity * 2) - intensity) / 10;
            oz = (double)(random.nextInt(intensity * 2) - intensity) / 10;
            vx = (double)(random.nextInt(intensity * 2) - intensity) / 10;
            vy = (double)(random.nextInt(intensity * 2) - intensity) / 10;
            vz = (double)(random.nextInt(intensity * 2) - intensity) / 10;
            world.addParticle(new BlockStateParticleEffect(ParticleTypes.BLOCK, block.getDefaultState()), pos.getX()+0.5+ox, pos.getY()+0.5+oy, pos.getZ()+0.5+oz, 0.0D+vx, 0.0D+vy, 0.0D+vz);
        }
    }

    public static void scatterDroppedBlockDust(World world, BlockPos pos, Block block, int intensity, int density) {
        Random random = Random.create();
        for (int i = 0; i < density; i++) {
            double ox, oy, oz;
            ox = (double)(random.nextInt(intensity * 2) - intensity) / 10;
            oy = (double)(random.nextInt(intensity * 2) - intensity) / 10;
            oz = (double)(random.nextInt(intensity * 2) - intensity) / 10;
            world.addParticle(new BlockStateParticleEffect(ParticleTypes.BLOCK, block.getDefaultState()), pos.getX()+0.5+ox, pos.getY()+0.5+oy, pos.getZ()+0.5+oz, 0.0D, -0.3D, 0.0D);
        }
    }

    public static Int2ObjectMap<TradeOffers.Factory[]> copyToFastUtilMap(ImmutableMap<Integer, TradeOffers.Factory[]> immutableMap) {
        return new Int2ObjectOpenHashMap(immutableMap);
    }

    public static void tryAddElementToPool(String targetPool, Identifier currentPool, StructurePool pool, String elementId, StructurePool.Projection projection, int weight) {
        if (new Identifier(targetPool).equals(currentPool)) {
            StructurePoolElement element = StructurePoolElement.ofLegacySingle(elementId).apply(projection);
            for (int i = 0; i < weight; i++) {
                ((StructurePoolAccess)pool).sandwichable$getElements().add(element);
            }
        }
    }

    public static void sync(SyncedBlockEntity be) {
        be.sync();
    }

    public static int floatToIntWithBounds(float input, int bounds) {
        return (int)(input*bounds);
    }

    public static void appendInfoTooltip(List<Text> tooltip, String itemTranslationKey) {
        SandwichableConfig config = Util.getConfig();
        if(config.showInfoTooltips) {
            if (config.infoTooltipKeyBind.isPressed()) {
                tooltip.add(Text.translatable("sandwichable.tooltip.infoheader").formatted(Formatting.GREEN));
                char[] infoChars = I18n.translate(itemTranslationKey + ".info").toCharArray();
                int lineLength = I18n.translate(itemTranslationKey).length();
                if (lineLength < Math.sqrt(infoChars.length) * 1.5) {
                    lineLength = (int) Math.sqrt(infoChars.length * 1.5);
                }
                StringBuilder ln = new StringBuilder();
                for (char c : infoChars) {
                    ln.append(c);
                    if (c == ' ' && ln.toString().length() > lineLength) {
                        tooltip.add(Text.literal(ln.toString()).formatted(Formatting.GRAY));
                        ln = new StringBuilder();
                    }
                }
                if (!ln.toString().isEmpty()) {
                    tooltip.add(Text.literal(ln.toString()).formatted(Formatting.GRAY));
                }
            } else {
                tooltip.add(Text.translatable("sandwichable.tooltip."+config.infoTooltipKeyBind.getName()).formatted(Formatting.GREEN));
            }
        }
    }

    public static ItemStack itemFromString(String str, Supplier<ItemStack> orElse) {
        var nbtBegin = str.indexOf("{");
        var itemStr = str.substring(0, nbtBegin > -1 ? nbtBegin : str.length());
        var nbtStr = ((nbtBegin > -1) && str.contains("}")) ? str.substring(nbtBegin, str.lastIndexOf("}") + 1) : null;

        var itemId = Identifier.tryParse(itemStr);
        if (itemId != null) {
            var entry = Registries.ITEM.getOrEmpty(itemId);
            if (entry.isPresent()) {
                var item = entry.get();

                var stack = new ItemStack(item);
                if (nbtStr != null) {
                    try {
                        var nbt = StringNbtReader.parse(nbtStr);
                        stack.setNbt(nbt);
                    } catch (CommandSyntaxException ignored) {}
                }

                return stack;
            }
        }

        return orElse.get();
    }

    public static <T> T create(Supplier<T> creator) {
        return creator.get();
    }

    public static int getSaltyWaterColor() {
        return 0x6ce0eb;
    }

    public static String biomeName(Identifier id) {
        var key = id.toTranslationKey("biome");
        var lang = Language.getInstance();
        if (lang != null && lang.hasTranslation(key)) {
            return lang.get(key);
        }

        var path = id.getPath();
        path = path.substring(path.lastIndexOf("/") + 1);

        var words = path.split("_");
        for (int i = 0; i < words.length; i++) {
            var word = new StringBuilder(words[i]);
            if (word.length() > 0) {
                word.setCharAt(0, Character.toUpperCase(word.charAt(0)));
            }
            words[i] = word.toString();
        }

        return String.join(" ", words);
    }

    public static <V> void forEveryEntryEver(Registry<V> registry, Consumer<V> action) {
        registry.forEach(action);
        RegistryEntryAddedCallback.event(registry).register((rawId, id, object) -> action.accept(object));
    }

    public static int getRed(int color) {
        return (color >> 16) & 0xFF;
    }

    public static int getGreen(int color) {
        return (color >> 8) & 0xFF;
    }

    public static int getBlue(int color) {
        return color & 0xFF;
    }

    public static int getColor(int red, int green, int blue) {
        return (red << 16) | (green << 8) | blue;
    }

    public static SandwichableConfig getConfig() {
        return ConfigInABarrel.config(MOD_ID, SandwichableConfig.class, SandwichableConfig::new);
    }
}
