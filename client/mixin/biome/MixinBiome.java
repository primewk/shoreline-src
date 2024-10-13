package net.shoreline.client.mixin.biome;

import net.minecraft.class_1959;
import net.shoreline.client.Shoreline;
import net.shoreline.client.impl.event.world.SkyboxEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({class_1959.class})
public class MixinBiome {
   @Inject(
      method = {"getFogColor"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void hookGetFogColor(CallbackInfoReturnable<Integer> cir) {
      SkyboxEvent.Fog skyboxEvent = new SkyboxEvent.Fog(0.0F);
      Shoreline.EVENT_HANDLER.dispatch(skyboxEvent);
      if (skyboxEvent.isCanceled()) {
         cir.cancel();
         cir.setReturnValue(skyboxEvent.getRGB());
      }

   }
}
