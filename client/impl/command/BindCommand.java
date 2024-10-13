package net.shoreline.client.impl.command;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import net.minecraft.class_2172;
import net.shoreline.client.api.command.Command;
import net.shoreline.client.api.command.ModuleArgumentType;
import net.shoreline.client.api.module.Module;
import net.shoreline.client.api.module.ToggleModule;
import net.shoreline.client.util.KeyboardUtil;
import net.shoreline.client.util.chat.ChatUtil;

public class BindCommand extends Command {
   public BindCommand() {
      super("Bind", "Keybinds a module", literal("bind"));
   }

   public void buildCommand(LiteralArgumentBuilder<class_2172> builder) {
      ((LiteralArgumentBuilder)builder.then(((RequiredArgumentBuilder)argument("module", ModuleArgumentType.module()).then(argument("key", StringArgumentType.string()).executes((c) -> {
         Module module = ModuleArgumentType.getModule(c, "module");
         if (module instanceof ToggleModule) {
            ToggleModule t = (ToggleModule)module;
            String key = StringArgumentType.getString(c, "key");
            if (key == null) {
               ChatUtil.error("Invalid key!");
               return 0;
            }

            int keycode = KeyboardUtil.getKeyCode(key);
            if (keycode == -1) {
               ChatUtil.error("Failed to parse key!");
               return 0;
            }

            t.keybind(keycode);
            ChatUtil.clientSendMessage("§7%s§f is now bound to §s%s", module.getName(), key.toUpperCase());
         }

         return 1;
      }))).executes((c) -> {
         ChatUtil.error("Must provide a module to keybind!");
         return 1;
      }))).executes((c) -> {
         ChatUtil.error("Invalid usage! Usage: " + this.getUsage());
         return 1;
      });
   }
}
