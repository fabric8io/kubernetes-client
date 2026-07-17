package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ServiceCAStatusBuilder extends ServiceCAStatusFluent<ServiceCAStatusBuilder> implements VisitableBuilder<ServiceCAStatus,ServiceCAStatusBuilder>{

  ServiceCAStatusFluent<?> fluent;

  public ServiceCAStatusBuilder() {
    this(new ServiceCAStatus());
  }
  
  public ServiceCAStatusBuilder(ServiceCAStatusFluent<?> fluent) {
    this(fluent, new ServiceCAStatus());
  }
  
  public ServiceCAStatusBuilder(ServiceCAStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ServiceCAStatusBuilder(ServiceCAStatusFluent<?> fluent,ServiceCAStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ServiceCAStatus build() {
    ServiceCAStatus buildable = new ServiceCAStatus(fluent.buildConditions(), fluent.buildGenerations(), fluent.getLatestAvailableRevision(), fluent.getObservedGeneration(), fluent.getReadyReplicas(), fluent.getVersion());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}