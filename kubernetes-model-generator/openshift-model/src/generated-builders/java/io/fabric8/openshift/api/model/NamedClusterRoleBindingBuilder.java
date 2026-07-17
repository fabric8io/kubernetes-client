package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NamedClusterRoleBindingBuilder extends NamedClusterRoleBindingFluent<NamedClusterRoleBindingBuilder> implements VisitableBuilder<NamedClusterRoleBinding,NamedClusterRoleBindingBuilder>{

  NamedClusterRoleBindingFluent<?> fluent;

  public NamedClusterRoleBindingBuilder() {
    this(new NamedClusterRoleBinding());
  }
  
  public NamedClusterRoleBindingBuilder(NamedClusterRoleBindingFluent<?> fluent) {
    this(fluent, new NamedClusterRoleBinding());
  }
  
  public NamedClusterRoleBindingBuilder(NamedClusterRoleBinding instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NamedClusterRoleBindingBuilder(NamedClusterRoleBindingFluent<?> fluent,NamedClusterRoleBinding instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NamedClusterRoleBinding build() {
    NamedClusterRoleBinding buildable = new NamedClusterRoleBinding(fluent.getName(), fluent.buildRoleBinding());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}