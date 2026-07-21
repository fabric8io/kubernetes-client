package io.fabric8.openclustermanagement.api.model.discovery.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DiscoveredClusterListBuilder extends DiscoveredClusterListFluent<DiscoveredClusterListBuilder> implements VisitableBuilder<DiscoveredClusterList,DiscoveredClusterListBuilder>{

  DiscoveredClusterListFluent<?> fluent;

  public DiscoveredClusterListBuilder() {
    this(new DiscoveredClusterList());
  }
  
  public DiscoveredClusterListBuilder(DiscoveredClusterListFluent<?> fluent) {
    this(fluent, new DiscoveredClusterList());
  }
  
  public DiscoveredClusterListBuilder(DiscoveredClusterList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DiscoveredClusterListBuilder(DiscoveredClusterListFluent<?> fluent,DiscoveredClusterList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DiscoveredClusterList build() {
    DiscoveredClusterList buildable = new DiscoveredClusterList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}