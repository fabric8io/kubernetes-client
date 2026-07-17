package io.fabric8.openshift.api.model.autoscaling.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterAutoscalerSpecRLCoresBuilder extends ClusterAutoscalerSpecRLCoresFluent<ClusterAutoscalerSpecRLCoresBuilder> implements VisitableBuilder<ClusterAutoscalerSpecRLCores,ClusterAutoscalerSpecRLCoresBuilder>{

  ClusterAutoscalerSpecRLCoresFluent<?> fluent;

  public ClusterAutoscalerSpecRLCoresBuilder() {
    this(new ClusterAutoscalerSpecRLCores());
  }
  
  public ClusterAutoscalerSpecRLCoresBuilder(ClusterAutoscalerSpecRLCoresFluent<?> fluent) {
    this(fluent, new ClusterAutoscalerSpecRLCores());
  }
  
  public ClusterAutoscalerSpecRLCoresBuilder(ClusterAutoscalerSpecRLCores instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterAutoscalerSpecRLCoresBuilder(ClusterAutoscalerSpecRLCoresFluent<?> fluent,ClusterAutoscalerSpecRLCores instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterAutoscalerSpecRLCores build() {
    ClusterAutoscalerSpecRLCores buildable = new ClusterAutoscalerSpecRLCores(fluent.getMax(), fluent.getMin());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}