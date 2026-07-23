package io.fabric8.openshift.api.model.autoscaling.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterAutoscalerSpecResourceLimitsBuilder extends ClusterAutoscalerSpecResourceLimitsFluent<ClusterAutoscalerSpecResourceLimitsBuilder> implements VisitableBuilder<ClusterAutoscalerSpecResourceLimits,ClusterAutoscalerSpecResourceLimitsBuilder>{

  ClusterAutoscalerSpecResourceLimitsFluent<?> fluent;

  public ClusterAutoscalerSpecResourceLimitsBuilder() {
    this(new ClusterAutoscalerSpecResourceLimits());
  }
  
  public ClusterAutoscalerSpecResourceLimitsBuilder(ClusterAutoscalerSpecResourceLimitsFluent<?> fluent) {
    this(fluent, new ClusterAutoscalerSpecResourceLimits());
  }
  
  public ClusterAutoscalerSpecResourceLimitsBuilder(ClusterAutoscalerSpecResourceLimits instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterAutoscalerSpecResourceLimitsBuilder(ClusterAutoscalerSpecResourceLimitsFluent<?> fluent,ClusterAutoscalerSpecResourceLimits instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterAutoscalerSpecResourceLimits build() {
    ClusterAutoscalerSpecResourceLimits buildable = new ClusterAutoscalerSpecResourceLimits(fluent.buildCores(), fluent.buildGpus(), fluent.getMaxNodesTotal(), fluent.buildMemory());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}