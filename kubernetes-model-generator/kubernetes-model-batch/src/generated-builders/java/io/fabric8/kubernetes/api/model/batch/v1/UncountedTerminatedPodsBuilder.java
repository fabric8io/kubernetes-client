package io.fabric8.kubernetes.api.model.batch.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class UncountedTerminatedPodsBuilder extends UncountedTerminatedPodsFluent<UncountedTerminatedPodsBuilder> implements VisitableBuilder<UncountedTerminatedPods,UncountedTerminatedPodsBuilder>{

  UncountedTerminatedPodsFluent<?> fluent;

  public UncountedTerminatedPodsBuilder() {
    this(new UncountedTerminatedPods());
  }
  
  public UncountedTerminatedPodsBuilder(UncountedTerminatedPodsFluent<?> fluent) {
    this(fluent, new UncountedTerminatedPods());
  }
  
  public UncountedTerminatedPodsBuilder(UncountedTerminatedPods instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public UncountedTerminatedPodsBuilder(UncountedTerminatedPodsFluent<?> fluent,UncountedTerminatedPods instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public UncountedTerminatedPods build() {
    UncountedTerminatedPods buildable = new UncountedTerminatedPods(fluent.getFailed(), fluent.getSucceeded());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}