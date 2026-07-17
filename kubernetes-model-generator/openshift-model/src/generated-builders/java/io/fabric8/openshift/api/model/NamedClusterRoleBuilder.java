package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NamedClusterRoleBuilder extends NamedClusterRoleFluent<NamedClusterRoleBuilder> implements VisitableBuilder<NamedClusterRole,NamedClusterRoleBuilder>{

  NamedClusterRoleFluent<?> fluent;

  public NamedClusterRoleBuilder() {
    this(new NamedClusterRole());
  }
  
  public NamedClusterRoleBuilder(NamedClusterRoleFluent<?> fluent) {
    this(fluent, new NamedClusterRole());
  }
  
  public NamedClusterRoleBuilder(NamedClusterRole instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NamedClusterRoleBuilder(NamedClusterRoleFluent<?> fluent,NamedClusterRole instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NamedClusterRole build() {
    NamedClusterRole buildable = new NamedClusterRole(fluent.getName(), fluent.buildRole());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}