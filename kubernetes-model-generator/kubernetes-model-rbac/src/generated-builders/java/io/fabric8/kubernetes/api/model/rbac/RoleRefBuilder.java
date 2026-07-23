package io.fabric8.kubernetes.api.model.rbac;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RoleRefBuilder extends RoleRefFluent<RoleRefBuilder> implements VisitableBuilder<RoleRef,RoleRefBuilder>{

  RoleRefFluent<?> fluent;

  public RoleRefBuilder() {
    this(new RoleRef());
  }
  
  public RoleRefBuilder(RoleRefFluent<?> fluent) {
    this(fluent, new RoleRef());
  }
  
  public RoleRefBuilder(RoleRef instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RoleRefBuilder(RoleRefFluent<?> fluent,RoleRef instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RoleRef build() {
    RoleRef buildable = new RoleRef(fluent.getApiGroup(), fluent.getKind(), fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}