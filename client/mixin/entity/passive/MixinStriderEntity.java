package net.shoreline.client.mixin.entity.passive;

import net.minecraft.class_4985;
import net.shoreline.client.Shoreline;
import net.shoreline.client.impl.event.entity.passive.EntitySteerEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({class_4985.class})
public class MixinStriderEntity {
   @Inject(
      method = {"isSaddled"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void hookIsSaddled(CallbackInfoReturnable<Boolean> cir) {
      EntitySteerEvent entitySteerEvent = new EntitySteerEvent();
      Shoreline.EVENT_HANDLER.dispatch(entitySteerEvent);
      if (entitySteerEvent.isCanceled()) {
         cir.cancel();
         cir.setReturnValue(true);
      }

   }
}
