package io.fabric8.openshift.api.model.autoscaling.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterAutoscalerSpecScaleUpBuilder extends ClusterAutoscalerSpecScaleUpFluent<ClusterAutoscalerSpecScaleUpBuilder> implements VisitableBuilder<ClusterAutoscalerSpecScaleUp,ClusterAutoscalerSpecScaleUpBuilder>{

  ClusterAutoscalerSpecScaleUpFluent<?> fluent;

  public ClusterAutoscalerSpecScaleUpBuilder() {
    this(new ClusterAutoscalerSpecScaleUp());
  }
  
  public ClusterAutoscalerSpecScaleUpBuilder(ClusterAutoscalerSpecScaleUpFluent<?> fluent) {
    this(fluent, new ClusterAutoscalerSpecScaleUp());
  }
  
  public ClusterAutoscalerSpecScaleUpBuilder(ClusterAutoscalerSpecScaleUp instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterAutoscalerSpecScaleUpBuilder(ClusterAutoscalerSpecScaleUpFluent<?> fluent,ClusterAutoscalerSpecScaleUp instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterAutoscalerSpecScaleUp build() {
    ClusterAutoscalerSpecScaleUp buildable = new ClusterAutoscalerSpecScaleUp(fluent.getNewPodScaleUpDelay());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}