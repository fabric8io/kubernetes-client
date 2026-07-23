package io.fabric8.knative.sinks.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IntegrationSinkStatusBuilder extends IntegrationSinkStatusFluent<IntegrationSinkStatusBuilder> implements VisitableBuilder<IntegrationSinkStatus,IntegrationSinkStatusBuilder>{

  IntegrationSinkStatusFluent<?> fluent;

  public IntegrationSinkStatusBuilder() {
    this(new IntegrationSinkStatus());
  }
  
  public IntegrationSinkStatusBuilder(IntegrationSinkStatusFluent<?> fluent) {
    this(fluent, new IntegrationSinkStatus());
  }
  
  public IntegrationSinkStatusBuilder(IntegrationSinkStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IntegrationSinkStatusBuilder(IntegrationSinkStatusFluent<?> fluent,IntegrationSinkStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IntegrationSinkStatus build() {
    IntegrationSinkStatus buildable = new IntegrationSinkStatus(fluent.buildAddress(), fluent.buildAddresses(), fluent.getAnnotations(), fluent.buildConditions(), fluent.getObservedGeneration(), fluent.buildPolicies());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}