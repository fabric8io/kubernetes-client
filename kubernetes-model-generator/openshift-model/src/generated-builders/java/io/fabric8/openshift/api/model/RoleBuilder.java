package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RoleBuilder extends RoleFluent<RoleBuilder> implements VisitableBuilder<Role,RoleBuilder>{

  RoleFluent<?> fluent;

  public RoleBuilder() {
    this(new Role());
  }
  
  public RoleBuilder(RoleFluent<?> fluent) {
    this(fluent, new Role());
  }
  
  public RoleBuilder(Role instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RoleBuilder(RoleFluent<?> fluent,Role instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Role build() {
    Role buildable = new Role(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildRules());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}