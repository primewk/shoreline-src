package net.shoreline.client.impl.module.client;

import net.shoreline.client.api.config.Config;
import net.shoreline.client.api.config.setting.BooleanConfig;
import net.shoreline.client.api.module.ModuleCategory;
import net.shoreline.client.api.module.ToggleModule;

public final class CapesModule extends ToggleModule {
   Config<Boolean> optifineConfig = new BooleanConfig("Optifine", "If to show optifine capes", true);

   public CapesModule() {
      super("Capes", "Shows player capes", ModuleCategory.CLIENT);
      this.enable();
   }

   public Config<Boolean> getOptifineConfig() {
      return this.optifineConfig;
   }
}
