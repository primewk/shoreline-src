package net.shoreline.client.impl.module.misc;

import net.shoreline.client.api.event.listener.EventListener;
import net.shoreline.client.api.module.ModuleCategory;
import net.shoreline.client.api.module.ToggleModule;
import net.shoreline.client.impl.event.item.DurabilityEvent;

public class TrueDurabilityModule extends ToggleModule {
   public TrueDurabilityModule() {
      super("TrueDurability", "Displays the true durability of unbreakable items", ModuleCategory.MISCELLANEOUS);
   }

   @EventListener
   public void onDurability(DurabilityEvent event) {
      int dura = event.getItemDamage();
      if (event.getDamage() < 0) {
         dura = event.getDamage();
      }

      event.cancel();
      event.setDamage(dura);
   }
}
