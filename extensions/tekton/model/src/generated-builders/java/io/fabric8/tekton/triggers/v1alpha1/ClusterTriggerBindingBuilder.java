package io.fabric8.tekton.triggers.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterTriggerBindingBuilder extends ClusterTriggerBindingFluent<ClusterTriggerBindingBuilder> implements VisitableBuilder<ClusterTriggerBinding,ClusterTriggerBindingBuilder>{

  ClusterTriggerBindingFluent<?> fluent;

  public ClusterTriggerBindingBuilder() {
    this(new ClusterTriggerBinding());
  }
  
  public ClusterTriggerBindingBuilder(ClusterTriggerBindingFluent<?> fluent) {
    this(fluent, new ClusterTriggerBinding());
  }
  
  public ClusterTriggerBindingBuilder(ClusterTriggerBinding instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterTriggerBindingBuilder(ClusterTriggerBindingFluent<?> fluent,ClusterTriggerBinding instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterTriggerBinding build() {
    ClusterTriggerBinding buildable = new ClusterTriggerBinding(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}