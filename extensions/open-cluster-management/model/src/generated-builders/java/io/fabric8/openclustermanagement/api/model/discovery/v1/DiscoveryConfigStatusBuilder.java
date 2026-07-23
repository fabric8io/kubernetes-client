package io.fabric8.openclustermanagement.api.model.discovery.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DiscoveryConfigStatusBuilder extends DiscoveryConfigStatusFluent<DiscoveryConfigStatusBuilder> implements VisitableBuilder<DiscoveryConfigStatus,DiscoveryConfigStatusBuilder>{

  DiscoveryConfigStatusFluent<?> fluent;

  public DiscoveryConfigStatusBuilder() {
    this(new DiscoveryConfigStatus());
  }
  
  public DiscoveryConfigStatusBuilder(DiscoveryConfigStatusFluent<?> fluent) {
    this(fluent, new DiscoveryConfigStatus());
  }
  
  public DiscoveryConfigStatusBuilder(DiscoveryConfigStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DiscoveryConfigStatusBuilder(DiscoveryConfigStatusFluent<?> fluent,DiscoveryConfigStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DiscoveryConfigStatus build() {
    DiscoveryConfigStatus buildable = new DiscoveryConfigStatus();
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}