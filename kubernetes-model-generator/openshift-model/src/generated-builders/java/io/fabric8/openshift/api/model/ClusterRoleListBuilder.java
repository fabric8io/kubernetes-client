package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterRoleListBuilder extends ClusterRoleListFluent<ClusterRoleListBuilder> implements VisitableBuilder<ClusterRoleList,ClusterRoleListBuilder>{

  ClusterRoleListFluent<?> fluent;

  public ClusterRoleListBuilder() {
    this(new ClusterRoleList());
  }
  
  public ClusterRoleListBuilder(ClusterRoleListFluent<?> fluent) {
    this(fluent, new ClusterRoleList());
  }
  
  public ClusterRoleListBuilder(ClusterRoleList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterRoleListBuilder(ClusterRoleListFluent<?> fluent,ClusterRoleList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterRoleList build() {
    ClusterRoleList buildable = new ClusterRoleList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}