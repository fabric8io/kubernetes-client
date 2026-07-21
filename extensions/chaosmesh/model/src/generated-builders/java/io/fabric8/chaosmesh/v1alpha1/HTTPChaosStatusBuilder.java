package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HTTPChaosStatusBuilder extends HTTPChaosStatusFluent<HTTPChaosStatusBuilder> implements VisitableBuilder<HTTPChaosStatus,HTTPChaosStatusBuilder>{

  HTTPChaosStatusFluent<?> fluent;

  public HTTPChaosStatusBuilder() {
    this(new HTTPChaosStatus());
  }
  
  public HTTPChaosStatusBuilder(HTTPChaosStatusFluent<?> fluent) {
    this(fluent, new HTTPChaosStatus());
  }
  
  public HTTPChaosStatusBuilder(HTTPChaosStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HTTPChaosStatusBuilder(HTTPChaosStatusFluent<?> fluent,HTTPChaosStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HTTPChaosStatus build() {
    HTTPChaosStatus buildable = new HTTPChaosStatus(fluent.buildConditions(), fluent.buildExperiment(), fluent.getInstances());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}