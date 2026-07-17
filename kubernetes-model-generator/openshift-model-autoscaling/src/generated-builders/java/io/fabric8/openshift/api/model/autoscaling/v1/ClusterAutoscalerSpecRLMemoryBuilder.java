package io.fabric8.openshift.api.model.autoscaling.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterAutoscalerSpecRLMemoryBuilder extends ClusterAutoscalerSpecRLMemoryFluent<ClusterAutoscalerSpecRLMemoryBuilder> implements VisitableBuilder<ClusterAutoscalerSpecRLMemory,ClusterAutoscalerSpecRLMemoryBuilder>{

  ClusterAutoscalerSpecRLMemoryFluent<?> fluent;

  public ClusterAutoscalerSpecRLMemoryBuilder() {
    this(new ClusterAutoscalerSpecRLMemory());
  }
  
  public ClusterAutoscalerSpecRLMemoryBuilder(ClusterAutoscalerSpecRLMemoryFluent<?> fluent) {
    this(fluent, new ClusterAutoscalerSpecRLMemory());
  }
  
  public ClusterAutoscalerSpecRLMemoryBuilder(ClusterAutoscalerSpecRLMemory instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterAutoscalerSpecRLMemoryBuilder(ClusterAutoscalerSpecRLMemoryFluent<?> fluent,ClusterAutoscalerSpecRLMemory instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterAutoscalerSpecRLMemory build() {
    ClusterAutoscalerSpecRLMemory buildable = new ClusterAutoscalerSpecRLMemory(fluent.getMax(), fluent.getMin());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}