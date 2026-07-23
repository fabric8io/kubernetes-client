package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterRoleBuilder extends ClusterRoleFluent<ClusterRoleBuilder> implements VisitableBuilder<ClusterRole,ClusterRoleBuilder>{

  ClusterRoleFluent<?> fluent;

  public ClusterRoleBuilder() {
    this(new ClusterRole());
  }
  
  public ClusterRoleBuilder(ClusterRoleFluent<?> fluent) {
    this(fluent, new ClusterRole());
  }
  
  public ClusterRoleBuilder(ClusterRole instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterRoleBuilder(ClusterRoleFluent<?> fluent,ClusterRole instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterRole build() {
    ClusterRole buildable = new ClusterRole(fluent.getAggregationRule(), fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildRules());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}