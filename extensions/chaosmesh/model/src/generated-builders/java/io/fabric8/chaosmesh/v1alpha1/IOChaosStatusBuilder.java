package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IOChaosStatusBuilder extends IOChaosStatusFluent<IOChaosStatusBuilder> implements VisitableBuilder<IOChaosStatus,IOChaosStatusBuilder>{

  IOChaosStatusFluent<?> fluent;

  public IOChaosStatusBuilder() {
    this(new IOChaosStatus());
  }
  
  public IOChaosStatusBuilder(IOChaosStatusFluent<?> fluent) {
    this(fluent, new IOChaosStatus());
  }
  
  public IOChaosStatusBuilder(IOChaosStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IOChaosStatusBuilder(IOChaosStatusFluent<?> fluent,IOChaosStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IOChaosStatus build() {
    IOChaosStatus buildable = new IOChaosStatus(fluent.buildConditions(), fluent.buildExperiment(), fluent.getInstances());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}