package io.fabric8.openclustermanagement.api.model.discovery.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DiscoveryConfigListBuilder extends DiscoveryConfigListFluent<DiscoveryConfigListBuilder> implements VisitableBuilder<DiscoveryConfigList,DiscoveryConfigListBuilder>{

  DiscoveryConfigListFluent<?> fluent;

  public DiscoveryConfigListBuilder() {
    this(new DiscoveryConfigList());
  }
  
  public DiscoveryConfigListBuilder(DiscoveryConfigListFluent<?> fluent) {
    this(fluent, new DiscoveryConfigList());
  }
  
  public DiscoveryConfigListBuilder(DiscoveryConfigList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DiscoveryConfigListBuilder(DiscoveryConfigListFluent<?> fluent,DiscoveryConfigList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DiscoveryConfigList build() {
    DiscoveryConfigList buildable = new DiscoveryConfigList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}