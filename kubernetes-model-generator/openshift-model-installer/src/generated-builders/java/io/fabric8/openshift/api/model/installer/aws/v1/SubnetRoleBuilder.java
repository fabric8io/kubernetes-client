package io.fabric8.openshift.api.model.installer.aws.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SubnetRoleBuilder extends SubnetRoleFluent<SubnetRoleBuilder> implements VisitableBuilder<SubnetRole,SubnetRoleBuilder>{

  SubnetRoleFluent<?> fluent;

  public SubnetRoleBuilder() {
    this(new SubnetRole());
  }
  
  public SubnetRoleBuilder(SubnetRoleFluent<?> fluent) {
    this(fluent, new SubnetRole());
  }
  
  public SubnetRoleBuilder(SubnetRole instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SubnetRoleBuilder(SubnetRoleFluent<?> fluent,SubnetRole instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SubnetRole build() {
    SubnetRole buildable = new SubnetRole(fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}