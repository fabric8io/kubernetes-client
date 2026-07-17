package io.fabric8.openshift.api.model.autoscaling.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterAutoscalerSpecScaleDownBuilder extends ClusterAutoscalerSpecScaleDownFluent<ClusterAutoscalerSpecScaleDownBuilder> implements VisitableBuilder<ClusterAutoscalerSpecScaleDown,ClusterAutoscalerSpecScaleDownBuilder>{

  ClusterAutoscalerSpecScaleDownFluent<?> fluent;

  public ClusterAutoscalerSpecScaleDownBuilder() {
    this(new ClusterAutoscalerSpecScaleDown());
  }
  
  public ClusterAutoscalerSpecScaleDownBuilder(ClusterAutoscalerSpecScaleDownFluent<?> fluent) {
    this(fluent, new ClusterAutoscalerSpecScaleDown());
  }
  
  public ClusterAutoscalerSpecScaleDownBuilder(ClusterAutoscalerSpecScaleDown instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterAutoscalerSpecScaleDownBuilder(ClusterAutoscalerSpecScaleDownFluent<?> fluent,ClusterAutoscalerSpecScaleDown instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterAutoscalerSpecScaleDown build() {
    ClusterAutoscalerSpecScaleDown buildable = new ClusterAutoscalerSpecScaleDown(fluent.getDelayAfterAdd(), fluent.getDelayAfterDelete(), fluent.getDelayAfterFailure(), fluent.getEnabled(), fluent.getUnneededTime(), fluent.getUtilizationThreshold());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}