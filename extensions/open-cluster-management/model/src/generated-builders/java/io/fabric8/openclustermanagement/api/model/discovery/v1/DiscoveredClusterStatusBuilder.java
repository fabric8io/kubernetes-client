package io.fabric8.openclustermanagement.api.model.discovery.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DiscoveredClusterStatusBuilder extends DiscoveredClusterStatusFluent<DiscoveredClusterStatusBuilder> implements VisitableBuilder<DiscoveredClusterStatus,DiscoveredClusterStatusBuilder>{

  DiscoveredClusterStatusFluent<?> fluent;

  public DiscoveredClusterStatusBuilder() {
    this(new DiscoveredClusterStatus());
  }
  
  public DiscoveredClusterStatusBuilder(DiscoveredClusterStatusFluent<?> fluent) {
    this(fluent, new DiscoveredClusterStatus());
  }
  
  public DiscoveredClusterStatusBuilder(DiscoveredClusterStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DiscoveredClusterStatusBuilder(DiscoveredClusterStatusFluent<?> fluent,DiscoveredClusterStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DiscoveredClusterStatus build() {
    DiscoveredClusterStatus buildable = new DiscoveredClusterStatus(fluent.buildConditions());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}