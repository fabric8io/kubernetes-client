package io.fabric8.openclustermanagement.api.model.discovery.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DiscoveredClusterSpecBuilder extends DiscoveredClusterSpecFluent<DiscoveredClusterSpecBuilder> implements VisitableBuilder<DiscoveredClusterSpec,DiscoveredClusterSpecBuilder>{

  DiscoveredClusterSpecFluent<?> fluent;

  public DiscoveredClusterSpecBuilder() {
    this(new DiscoveredClusterSpec());
  }
  
  public DiscoveredClusterSpecBuilder(DiscoveredClusterSpecFluent<?> fluent) {
    this(fluent, new DiscoveredClusterSpec());
  }
  
  public DiscoveredClusterSpecBuilder(DiscoveredClusterSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DiscoveredClusterSpecBuilder(DiscoveredClusterSpecFluent<?> fluent,DiscoveredClusterSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DiscoveredClusterSpec build() {
    DiscoveredClusterSpec buildable = new DiscoveredClusterSpec(fluent.getActivityTimestamp(), fluent.getApiUrl(), fluent.getCloudProvider(), fluent.getConsole(), fluent.getCreationTimestamp(), fluent.buildCredential(), fluent.getDisplayName(), fluent.getIsManagedCluster(), fluent.getName(), fluent.getOpenshiftVersion(), fluent.getStatus(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}