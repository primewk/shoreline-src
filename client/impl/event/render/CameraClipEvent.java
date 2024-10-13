package net.shoreline.client.impl.event.render;

import net.shoreline.client.api.event.Cancelable;
import net.shoreline.client.api.event.Event;

@Cancelable
public class CameraClipEvent extends Event {
   private double distance;

   public CameraClipEvent(double distance) {
      this.distance = distance;
   }

   public double getDistance() {
      return this.distance;
   }

   public void setDistance(double distance) {
      this.distance = distance;
   }
}
