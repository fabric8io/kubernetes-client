package io.fabric8.openshift.api.model.autoscaling.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterAutoscalerSpecRLGpusBuilder extends ClusterAutoscalerSpecRLGpusFluent<ClusterAutoscalerSpecRLGpusBuilder> implements VisitableBuilder<ClusterAutoscalerSpecRLGpus,ClusterAutoscalerSpecRLGpusBuilder>{

  ClusterAutoscalerSpecRLGpusFluent<?> fluent;

  public ClusterAutoscalerSpecRLGpusBuilder() {
    this(new ClusterAutoscalerSpecRLGpus());
  }
  
  public ClusterAutoscalerSpecRLGpusBuilder(ClusterAutoscalerSpecRLGpusFluent<?> fluent) {
    this(fluent, new ClusterAutoscalerSpecRLGpus());
  }
  
  public ClusterAutoscalerSpecRLGpusBuilder(ClusterAutoscalerSpecRLGpus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterAutoscalerSpecRLGpusBuilder(ClusterAutoscalerSpecRLGpusFluent<?> fluent,ClusterAutoscalerSpecRLGpus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterAutoscalerSpecRLGpus build() {
    ClusterAutoscalerSpecRLGpus buildable = new ClusterAutoscalerSpecRLGpus(fluent.getMax(), fluent.getMin(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}