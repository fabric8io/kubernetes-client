package io.fabric8.openshift.api.model.hive.aws.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AssumeRoleBuilder extends AssumeRoleFluent<AssumeRoleBuilder> implements VisitableBuilder<AssumeRole,AssumeRoleBuilder>{

  AssumeRoleFluent<?> fluent;

  public AssumeRoleBuilder() {
    this(new AssumeRole());
  }
  
  public AssumeRoleBuilder(AssumeRoleFluent<?> fluent) {
    this(fluent, new AssumeRole());
  }
  
  public AssumeRoleBuilder(AssumeRole instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AssumeRoleBuilder(AssumeRoleFluent<?> fluent,AssumeRole instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AssumeRole build() {
    AssumeRole buildable = new AssumeRole(fluent.getExternalID(), fluent.getRoleARN());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}