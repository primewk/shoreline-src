package net.shoreline.client.impl.module.misc;

import net.minecraft.class_2596;
import net.minecraft.class_7438;
import net.shoreline.client.api.config.Config;
import net.shoreline.client.api.config.setting.BooleanConfig;
import net.shoreline.client.api.config.setting.NumberConfig;
import net.shoreline.client.api.config.setting.StringConfig;
import net.shoreline.client.api.event.listener.EventListener;
import net.shoreline.client.api.module.ModuleCategory;
import net.shoreline.client.api.module.ToggleModule;
import net.shoreline.client.impl.event.network.PacketEvent;
import net.shoreline.client.util.chat.ChatUtil;

public class AntiAFKModule extends ToggleModule {
   Config<Boolean> messageConfig = new BooleanConfig("Message", "Messages in chat to prevent AFK kick", true);
   Config<Boolean> tabCompleteConfig = new BooleanConfig("TabComplete", "Uses tab complete in chat to prevent AFK kick", true);
   Config<Boolean> rotateConfig = new BooleanConfig("Rotate", "Rotates the player to prevent AFK kick", true);
   Config<Boolean> autoReplyConfig = new BooleanConfig("AutoReply", "Replies to players messaging you in chat", true);
   Config<String> replyConfig = new StringConfig("Reply", "The reply message for AutoReply", "[Shoreline] I am currently AFK.");
   Config<Float> delayConfig = new NumberConfig("Delay", "The delay between actions", 5.0F, 60.0F, 270.0F);

   public AntiAFKModule() {
      super("AntiAFK", "Prevents the player from being kicked for AFK", ModuleCategory.MISCELLANEOUS);
   }

   @EventListener
   public void onPacketInbound(PacketEvent.Inbound event) {
      class_2596 var3 = event.getPacket();
      if (var3 instanceof class_7438) {
         class_7438 packet = (class_7438)var3;
         if ((Boolean)this.autoReplyConfig.getValue()) {
            String[] words = packet.comp_1102().comp_1090().split(" ");
            if (words[1].startsWith("whispers:")) {
               ChatUtil.serverSendMessage("/r " + (String)this.replyConfig.getValue());
            }
         }
      }

   }
}
