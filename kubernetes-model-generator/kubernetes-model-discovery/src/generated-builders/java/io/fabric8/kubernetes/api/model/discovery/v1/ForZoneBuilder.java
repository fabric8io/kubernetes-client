package io.fabric8.kubernetes.api.model.discovery.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ForZoneBuilder extends ForZoneFluent<ForZoneBuilder> implements VisitableBuilder<ForZone,ForZoneBuilder>{

  ForZoneFluent<?> fluent;

  public ForZoneBuilder() {
    this(new ForZone());
  }
  
  public ForZoneBuilder(ForZoneFluent<?> fluent) {
    this(fluent, new ForZone());
  }
  
  public ForZoneBuilder(ForZone instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ForZoneBuilder(ForZoneFluent<?> fluent,ForZone instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ForZone build() {
    ForZone buildable = new ForZone(fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}