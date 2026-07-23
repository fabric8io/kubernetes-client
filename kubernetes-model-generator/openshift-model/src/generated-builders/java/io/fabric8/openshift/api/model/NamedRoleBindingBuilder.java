package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NamedRoleBindingBuilder extends NamedRoleBindingFluent<NamedRoleBindingBuilder> implements VisitableBuilder<NamedRoleBinding,NamedRoleBindingBuilder>{

  NamedRoleBindingFluent<?> fluent;

  public NamedRoleBindingBuilder() {
    this(new NamedRoleBinding());
  }
  
  public NamedRoleBindingBuilder(NamedRoleBindingFluent<?> fluent) {
    this(fluent, new NamedRoleBinding());
  }
  
  public NamedRoleBindingBuilder(NamedRoleBinding instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NamedRoleBindingBuilder(NamedRoleBindingFluent<?> fluent,NamedRoleBinding instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NamedRoleBinding build() {
    NamedRoleBinding buildable = new NamedRoleBinding(fluent.getName(), fluent.buildRoleBinding());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}