package io.fabric8.openclustermanagement.api.model.discovery.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DiscoveryConfigBuilder extends DiscoveryConfigFluent<DiscoveryConfigBuilder> implements VisitableBuilder<DiscoveryConfig,DiscoveryConfigBuilder>{

  DiscoveryConfigFluent<?> fluent;

  public DiscoveryConfigBuilder() {
    this(new DiscoveryConfig());
  }
  
  public DiscoveryConfigBuilder(DiscoveryConfigFluent<?> fluent) {
    this(fluent, new DiscoveryConfig());
  }
  
  public DiscoveryConfigBuilder(DiscoveryConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DiscoveryConfigBuilder(DiscoveryConfigFluent<?> fluent,DiscoveryConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DiscoveryConfig build() {
    DiscoveryConfig buildable = new DiscoveryConfig(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}