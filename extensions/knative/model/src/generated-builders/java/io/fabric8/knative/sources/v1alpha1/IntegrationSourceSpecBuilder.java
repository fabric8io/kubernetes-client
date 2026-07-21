package io.fabric8.knative.sources.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IntegrationSourceSpecBuilder extends IntegrationSourceSpecFluent<IntegrationSourceSpecBuilder> implements VisitableBuilder<IntegrationSourceSpec,IntegrationSourceSpecBuilder>{

  IntegrationSourceSpecFluent<?> fluent;

  public IntegrationSourceSpecBuilder() {
    this(new IntegrationSourceSpec());
  }
  
  public IntegrationSourceSpecBuilder(IntegrationSourceSpecFluent<?> fluent) {
    this(fluent, new IntegrationSourceSpec());
  }
  
  public IntegrationSourceSpecBuilder(IntegrationSourceSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IntegrationSourceSpecBuilder(IntegrationSourceSpecFluent<?> fluent,IntegrationSourceSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IntegrationSourceSpec build() {
    IntegrationSourceSpec buildable = new IntegrationSourceSpec(fluent.buildAws(), fluent.buildCeOverrides(), fluent.buildSink(), fluent.buildTemplate(), fluent.buildTimer());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}