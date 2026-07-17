package io.fabric8.openshift.api.model.autoscaling.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterAutoscalerBuilder extends ClusterAutoscalerFluent<ClusterAutoscalerBuilder> implements VisitableBuilder<ClusterAutoscaler,ClusterAutoscalerBuilder>{

  ClusterAutoscalerFluent<?> fluent;

  public ClusterAutoscalerBuilder() {
    this(new ClusterAutoscaler());
  }
  
  public ClusterAutoscalerBuilder(ClusterAutoscalerFluent<?> fluent) {
    this(fluent, new ClusterAutoscaler());
  }
  
  public ClusterAutoscalerBuilder(ClusterAutoscaler instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterAutoscalerBuilder(ClusterAutoscalerFluent<?> fluent,ClusterAutoscaler instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterAutoscaler build() {
    ClusterAutoscaler buildable = new ClusterAutoscaler(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.getStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}