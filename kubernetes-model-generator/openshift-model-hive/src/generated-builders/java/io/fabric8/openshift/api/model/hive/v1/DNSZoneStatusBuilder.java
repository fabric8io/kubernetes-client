package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DNSZoneStatusBuilder extends DNSZoneStatusFluent<DNSZoneStatusBuilder> implements VisitableBuilder<DNSZoneStatus,DNSZoneStatusBuilder>{

  DNSZoneStatusFluent<?> fluent;

  public DNSZoneStatusBuilder() {
    this(new DNSZoneStatus());
  }
  
  public DNSZoneStatusBuilder(DNSZoneStatusFluent<?> fluent) {
    this(fluent, new DNSZoneStatus());
  }
  
  public DNSZoneStatusBuilder(DNSZoneStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DNSZoneStatusBuilder(DNSZoneStatusFluent<?> fluent,DNSZoneStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DNSZoneStatus build() {
    DNSZoneStatus buildable = new DNSZoneStatus(fluent.buildAws(), fluent.buildAzure(), fluent.buildConditions(), fluent.buildGcp(), fluent.getLastSyncGeneration(), fluent.getLastSyncTimestamp(), fluent.getNameServers());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}