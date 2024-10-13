package net.shoreline.client.impl.module.misc;

import net.shoreline.client.api.event.listener.EventListener;
import net.shoreline.client.api.module.ModuleCategory;
import net.shoreline.client.api.module.ToggleModule;
import net.shoreline.client.impl.event.network.DecodePacketEvent;

public class NoPacketKickModule extends ToggleModule {
   public NoPacketKickModule() {
      super("NoPacketKick", "Prevents getting kicked by packets", ModuleCategory.MISCELLANEOUS);
   }

   @EventListener
   public void onDecodePacket(DecodePacketEvent event) {
      event.cancel();
   }
}
