package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class WatchEventBuilder extends WatchEventFluent<WatchEventBuilder> implements VisitableBuilder<WatchEvent,WatchEventBuilder>{

  WatchEventFluent<?> fluent;

  public WatchEventBuilder() {
    this(new WatchEvent());
  }
  
  public WatchEventBuilder(WatchEventFluent<?> fluent) {
    this(fluent, new WatchEvent());
  }
  
  public WatchEventBuilder(WatchEvent instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public WatchEventBuilder(WatchEventFluent<?> fluent,WatchEvent instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public WatchEvent build() {
    WatchEvent buildable = new WatchEvent(fluent.getObject(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}