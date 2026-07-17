package io.fabric8.openshift.api.model.autoscaling.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterAutoscalerSpecBuilder extends ClusterAutoscalerSpecFluent<ClusterAutoscalerSpecBuilder> implements VisitableBuilder<ClusterAutoscalerSpec,ClusterAutoscalerSpecBuilder>{

  ClusterAutoscalerSpecFluent<?> fluent;

  public ClusterAutoscalerSpecBuilder() {
    this(new ClusterAutoscalerSpec());
  }
  
  public ClusterAutoscalerSpecBuilder(ClusterAutoscalerSpecFluent<?> fluent) {
    this(fluent, new ClusterAutoscalerSpec());
  }
  
  public ClusterAutoscalerSpecBuilder(ClusterAutoscalerSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterAutoscalerSpecBuilder(ClusterAutoscalerSpecFluent<?> fluent,ClusterAutoscalerSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterAutoscalerSpec build() {
    ClusterAutoscalerSpec buildable = new ClusterAutoscalerSpec(fluent.getBalanceSimilarNodeGroups(), fluent.getBalancingIgnoredLabels(), fluent.getExpanders(), fluent.getIgnoreDaemonsetsUtilization(), fluent.getLogVerbosity(), fluent.getMaxNodeProvisionTime(), fluent.getMaxPodGracePeriod(), fluent.getPodPriorityThreshold(), fluent.buildResourceLimits(), fluent.buildScaleDown(), fluent.buildScaleUp(), fluent.getSkipNodesWithLocalStorage());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}