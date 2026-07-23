package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GroupVersionForDiscoveryBuilder extends GroupVersionForDiscoveryFluent<GroupVersionForDiscoveryBuilder> implements VisitableBuilder<GroupVersionForDiscovery,GroupVersionForDiscoveryBuilder>{

  GroupVersionForDiscoveryFluent<?> fluent;

  public GroupVersionForDiscoveryBuilder() {
    this(new GroupVersionForDiscovery());
  }
  
  public GroupVersionForDiscoveryBuilder(GroupVersionForDiscoveryFluent<?> fluent) {
    this(fluent, new GroupVersionForDiscovery());
  }
  
  public GroupVersionForDiscoveryBuilder(GroupVersionForDiscovery instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GroupVersionForDiscoveryBuilder(GroupVersionForDiscoveryFluent<?> fluent,GroupVersionForDiscovery instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GroupVersionForDiscovery build() {
    GroupVersionForDiscovery buildable = new GroupVersionForDiscovery(fluent.getGroupVersion(), fluent.getVersion());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}