package io.github.foundationgames.parry;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.item.SwordItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ParryClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        Registries.ITEM.forEach((item) -> {
            if(item instanceof SwordItem) {
                ModelPredicateProviderRegistry.register(item, new Identifier("parrying"), (stack, world, entity, i) -> entity != null && entity.isUsingItem() && entity.getActiveItem() == stack ? 1.0F : 0.0F);
            }
        });
    }
}
