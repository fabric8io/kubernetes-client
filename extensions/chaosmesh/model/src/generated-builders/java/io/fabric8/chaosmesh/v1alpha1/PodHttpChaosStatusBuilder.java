package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodHttpChaosStatusBuilder extends PodHttpChaosStatusFluent<PodHttpChaosStatusBuilder> implements VisitableBuilder<PodHttpChaosStatus,PodHttpChaosStatusBuilder>{

  PodHttpChaosStatusFluent<?> fluent;

  public PodHttpChaosStatusBuilder() {
    this(new PodHttpChaosStatus());
  }
  
  public PodHttpChaosStatusBuilder(PodHttpChaosStatusFluent<?> fluent) {
    this(fluent, new PodHttpChaosStatus());
  }
  
  public PodHttpChaosStatusBuilder(PodHttpChaosStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodHttpChaosStatusBuilder(PodHttpChaosStatusFluent<?> fluent,PodHttpChaosStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodHttpChaosStatus build() {
    PodHttpChaosStatus buildable = new PodHttpChaosStatus(fluent.getFailedMessage(), fluent.getObservedGeneration(), fluent.getPid(), fluent.getStartTime());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}