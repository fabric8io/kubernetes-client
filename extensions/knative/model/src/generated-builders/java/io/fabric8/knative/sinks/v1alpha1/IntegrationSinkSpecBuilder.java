package io.fabric8.knative.sinks.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IntegrationSinkSpecBuilder extends IntegrationSinkSpecFluent<IntegrationSinkSpecBuilder> implements VisitableBuilder<IntegrationSinkSpec,IntegrationSinkSpecBuilder>{

  IntegrationSinkSpecFluent<?> fluent;

  public IntegrationSinkSpecBuilder() {
    this(new IntegrationSinkSpec());
  }
  
  public IntegrationSinkSpecBuilder(IntegrationSinkSpecFluent<?> fluent) {
    this(fluent, new IntegrationSinkSpec());
  }
  
  public IntegrationSinkSpecBuilder(IntegrationSinkSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IntegrationSinkSpecBuilder(IntegrationSinkSpecFluent<?> fluent,IntegrationSinkSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IntegrationSinkSpec build() {
    IntegrationSinkSpec buildable = new IntegrationSinkSpec(fluent.buildAws(), fluent.buildLog());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}