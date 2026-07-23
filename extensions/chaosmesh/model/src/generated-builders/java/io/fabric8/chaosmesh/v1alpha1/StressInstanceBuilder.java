package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class StressInstanceBuilder extends StressInstanceFluent<StressInstanceBuilder> implements VisitableBuilder<StressInstance,StressInstanceBuilder>{

  StressInstanceFluent<?> fluent;

  public StressInstanceBuilder() {
    this(new StressInstance());
  }
  
  public StressInstanceBuilder(StressInstanceFluent<?> fluent) {
    this(fluent, new StressInstance());
  }
  
  public StressInstanceBuilder(StressInstance instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public StressInstanceBuilder(StressInstanceFluent<?> fluent,StressInstance instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public StressInstance build() {
    StressInstance buildable = new StressInstance(fluent.getMemoryStartTime(), fluent.getMemoryUid(), fluent.getStartTime(), fluent.getUid());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}