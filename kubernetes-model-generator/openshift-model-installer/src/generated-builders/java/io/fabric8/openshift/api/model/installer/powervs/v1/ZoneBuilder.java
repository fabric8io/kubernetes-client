package io.fabric8.openshift.api.model.installer.powervs.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ZoneBuilder extends ZoneFluent<ZoneBuilder> implements VisitableBuilder<Zone,ZoneBuilder>{

  ZoneFluent<?> fluent;

  public ZoneBuilder() {
    this(new Zone());
  }
  
  public ZoneBuilder(ZoneFluent<?> fluent) {
    this(fluent, new Zone());
  }
  
  public ZoneBuilder(Zone instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ZoneBuilder(ZoneFluent<?> fluent,Zone instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Zone build() {
    Zone buildable = new Zone(fluent.getSysTypes());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}