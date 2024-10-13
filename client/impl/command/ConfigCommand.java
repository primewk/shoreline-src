package net.shoreline.client.impl.command;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import net.minecraft.class_2172;
import net.shoreline.client.Shoreline;
import net.shoreline.client.api.command.Command;
import net.shoreline.client.util.chat.ChatUtil;

public class ConfigCommand extends Command {
   public ConfigCommand() {
      super("Config", "Creates a new configuration preset", literal("config"));
   }

   public void buildCommand(LiteralArgumentBuilder<class_2172> builder) {
      ((LiteralArgumentBuilder)builder.then(((RequiredArgumentBuilder)argument("save/load", StringArgumentType.string()).suggests(suggest(new String[]{"save", "load"})).then(argument("config_name", StringArgumentType.string()).executes((c) -> {
         String action = StringArgumentType.getString(c, "save/load");
         String name = StringArgumentType.getString(c, "config_name");
         if (action.equalsIgnoreCase("save")) {
            Shoreline.CONFIG.saveModuleConfiguration(name);
            ChatUtil.clientSendMessage("Saved config: §s" + name);
         } else if (action.equalsIgnoreCase("load")) {
            Shoreline.CONFIG.loadModuleConfiguration(name);
            ChatUtil.clientSendMessage("Loaded config: §s" + name);
         }

         return 1;
      }))).executes((c) -> {
         ChatUtil.error("Must provide a config to load!");
         return 1;
      }))).executes((c) -> {
         ChatUtil.error("Invalid usage! Usage: " + this.getUsage());
         return 1;
      });
   }
}
