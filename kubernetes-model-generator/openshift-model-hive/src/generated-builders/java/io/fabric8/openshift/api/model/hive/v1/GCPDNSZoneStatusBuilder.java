package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GCPDNSZoneStatusBuilder extends GCPDNSZoneStatusFluent<GCPDNSZoneStatusBuilder> implements VisitableBuilder<GCPDNSZoneStatus,GCPDNSZoneStatusBuilder>{

  GCPDNSZoneStatusFluent<?> fluent;

  public GCPDNSZoneStatusBuilder() {
    this(new GCPDNSZoneStatus());
  }
  
  public GCPDNSZoneStatusBuilder(GCPDNSZoneStatusFluent<?> fluent) {
    this(fluent, new GCPDNSZoneStatus());
  }
  
  public GCPDNSZoneStatusBuilder(GCPDNSZoneStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GCPDNSZoneStatusBuilder(GCPDNSZoneStatusFluent<?> fluent,GCPDNSZoneStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GCPDNSZoneStatus build() {
    GCPDNSZoneStatus buildable = new GCPDNSZoneStatus(fluent.getZoneName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}