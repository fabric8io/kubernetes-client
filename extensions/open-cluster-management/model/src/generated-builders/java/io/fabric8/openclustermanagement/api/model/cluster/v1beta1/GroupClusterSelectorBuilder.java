package io.fabric8.openclustermanagement.api.model.cluster.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GroupClusterSelectorBuilder extends GroupClusterSelectorFluent<GroupClusterSelectorBuilder> implements VisitableBuilder<GroupClusterSelector,GroupClusterSelectorBuilder>{

  GroupClusterSelectorFluent<?> fluent;

  public GroupClusterSelectorBuilder() {
    this(new GroupClusterSelector());
  }
  
  public GroupClusterSelectorBuilder(GroupClusterSelectorFluent<?> fluent) {
    this(fluent, new GroupClusterSelector());
  }
  
  public GroupClusterSelectorBuilder(GroupClusterSelector instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GroupClusterSelectorBuilder(GroupClusterSelectorFluent<?> fluent,GroupClusterSelector instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GroupClusterSelector build() {
    GroupClusterSelector buildable = new GroupClusterSelector(fluent.buildClaimSelector(), fluent.buildLabelSelector());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}