package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AzureDNSZoneStatusBuilder extends AzureDNSZoneStatusFluent<AzureDNSZoneStatusBuilder> implements VisitableBuilder<AzureDNSZoneStatus,AzureDNSZoneStatusBuilder>{

  AzureDNSZoneStatusFluent<?> fluent;

  public AzureDNSZoneStatusBuilder() {
    this(new AzureDNSZoneStatus());
  }
  
  public AzureDNSZoneStatusBuilder(AzureDNSZoneStatusFluent<?> fluent) {
    this(fluent, new AzureDNSZoneStatus());
  }
  
  public AzureDNSZoneStatusBuilder(AzureDNSZoneStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AzureDNSZoneStatusBuilder(AzureDNSZoneStatusFluent<?> fluent,AzureDNSZoneStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AzureDNSZoneStatus build() {
    AzureDNSZoneStatus buildable = new AzureDNSZoneStatus();
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}