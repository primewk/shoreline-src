package net.shoreline.client.impl.module.misc;

import net.shoreline.client.api.module.ModuleCategory;
import net.shoreline.client.api.module.ToggleModule;

public class SpammerModule extends ToggleModule {
   public SpammerModule() {
      super("Spammer", "Spams messages in the chat", ModuleCategory.MISCELLANEOUS);
   }
}
