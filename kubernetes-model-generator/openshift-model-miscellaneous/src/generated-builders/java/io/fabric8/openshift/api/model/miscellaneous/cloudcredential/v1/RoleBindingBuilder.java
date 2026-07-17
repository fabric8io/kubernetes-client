package io.fabric8.openshift.api.model.miscellaneous.cloudcredential.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RoleBindingBuilder extends RoleBindingFluent<RoleBindingBuilder> implements VisitableBuilder<RoleBinding,RoleBindingBuilder>{

  RoleBindingFluent<?> fluent;

  public RoleBindingBuilder() {
    this(new RoleBinding());
  }
  
  public RoleBindingBuilder(RoleBindingFluent<?> fluent) {
    this(fluent, new RoleBinding());
  }
  
  public RoleBindingBuilder(RoleBinding instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RoleBindingBuilder(RoleBindingFluent<?> fluent,RoleBinding instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RoleBinding build() {
    RoleBinding buildable = new RoleBinding(fluent.getRole());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}