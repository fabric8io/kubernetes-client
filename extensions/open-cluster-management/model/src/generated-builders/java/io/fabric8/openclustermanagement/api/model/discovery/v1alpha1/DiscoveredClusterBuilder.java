package io.fabric8.openclustermanagement.api.model.discovery.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DiscoveredClusterBuilder extends DiscoveredClusterFluent<DiscoveredClusterBuilder> implements VisitableBuilder<DiscoveredCluster,DiscoveredClusterBuilder>{

  DiscoveredClusterFluent<?> fluent;

  public DiscoveredClusterBuilder() {
    this(new DiscoveredCluster());
  }
  
  public DiscoveredClusterBuilder(DiscoveredClusterFluent<?> fluent) {
    this(fluent, new DiscoveredCluster());
  }
  
  public DiscoveredClusterBuilder(DiscoveredCluster instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DiscoveredClusterBuilder(DiscoveredClusterFluent<?> fluent,DiscoveredCluster instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DiscoveredCluster build() {
    DiscoveredCluster buildable = new DiscoveredCluster(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}