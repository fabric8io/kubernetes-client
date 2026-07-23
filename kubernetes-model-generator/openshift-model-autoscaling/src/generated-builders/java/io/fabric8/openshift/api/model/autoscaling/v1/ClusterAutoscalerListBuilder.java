package io.fabric8.openshift.api.model.autoscaling.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterAutoscalerListBuilder extends ClusterAutoscalerListFluent<ClusterAutoscalerListBuilder> implements VisitableBuilder<ClusterAutoscalerList,ClusterAutoscalerListBuilder>{

  ClusterAutoscalerListFluent<?> fluent;

  public ClusterAutoscalerListBuilder() {
    this(new ClusterAutoscalerList());
  }
  
  public ClusterAutoscalerListBuilder(ClusterAutoscalerListFluent<?> fluent) {
    this(fluent, new ClusterAutoscalerList());
  }
  
  public ClusterAutoscalerListBuilder(ClusterAutoscalerList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterAutoscalerListBuilder(ClusterAutoscalerListFluent<?> fluent,ClusterAutoscalerList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterAutoscalerList build() {
    ClusterAutoscalerList buildable = new ClusterAutoscalerList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}