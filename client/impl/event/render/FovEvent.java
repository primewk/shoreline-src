package net.shoreline.client.impl.event.render;

import net.shoreline.client.api.event.Cancelable;
import net.shoreline.client.api.event.Event;

@Cancelable
public class FovEvent extends Event {
   private double fov;

   public double getFov() {
      return this.fov;
   }

   public void setFov(double fov) {
      this.fov = fov;
   }
}
