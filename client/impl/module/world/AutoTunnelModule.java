package net.shoreline.client.impl.module.world;

import net.shoreline.client.api.module.ModuleCategory;
import net.shoreline.client.api.module.ToggleModule;

public class AutoTunnelModule extends ToggleModule {
   public AutoTunnelModule() {
      super("AutoTunnel", "Automatically mines a tunnel", ModuleCategory.WORLD);
   }
}
