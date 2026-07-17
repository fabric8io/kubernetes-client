package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterRoleBindingBuilder extends ClusterRoleBindingFluent<ClusterRoleBindingBuilder> implements VisitableBuilder<ClusterRoleBinding,ClusterRoleBindingBuilder>{

  ClusterRoleBindingFluent<?> fluent;

  public ClusterRoleBindingBuilder() {
    this(new ClusterRoleBinding());
  }
  
  public ClusterRoleBindingBuilder(ClusterRoleBindingFluent<?> fluent) {
    this(fluent, new ClusterRoleBinding());
  }
  
  public ClusterRoleBindingBuilder(ClusterRoleBinding instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterRoleBindingBuilder(ClusterRoleBindingFluent<?> fluent,ClusterRoleBinding instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterRoleBinding build() {
    ClusterRoleBinding buildable = new ClusterRoleBinding(fluent.getApiVersion(), fluent.getGroupNames(), fluent.getKind(), fluent.buildMetadata(), fluent.buildRoleRef(), fluent.buildSubjects(), fluent.getUserNames());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}