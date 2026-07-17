package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NamedRoleBuilder extends NamedRoleFluent<NamedRoleBuilder> implements VisitableBuilder<NamedRole,NamedRoleBuilder>{

  NamedRoleFluent<?> fluent;

  public NamedRoleBuilder() {
    this(new NamedRole());
  }
  
  public NamedRoleBuilder(NamedRoleFluent<?> fluent) {
    this(fluent, new NamedRole());
  }
  
  public NamedRoleBuilder(NamedRole instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NamedRoleBuilder(NamedRoleFluent<?> fluent,NamedRole instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NamedRole build() {
    NamedRole buildable = new NamedRole(fluent.getName(), fluent.buildRole());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}