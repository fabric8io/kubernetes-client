package io.fabric8.kubernetes.api.model.rbac;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterRoleBindingListBuilder extends ClusterRoleBindingListFluent<ClusterRoleBindingListBuilder> implements VisitableBuilder<ClusterRoleBindingList,ClusterRoleBindingListBuilder>{

  ClusterRoleBindingListFluent<?> fluent;

  public ClusterRoleBindingListBuilder() {
    this(new ClusterRoleBindingList());
  }
  
  public ClusterRoleBindingListBuilder(ClusterRoleBindingListFluent<?> fluent) {
    this(fluent, new ClusterRoleBindingList());
  }
  
  public ClusterRoleBindingListBuilder(ClusterRoleBindingList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterRoleBindingListBuilder(ClusterRoleBindingListFluent<?> fluent,ClusterRoleBindingList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterRoleBindingList build() {
    ClusterRoleBindingList buildable = new ClusterRoleBindingList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}