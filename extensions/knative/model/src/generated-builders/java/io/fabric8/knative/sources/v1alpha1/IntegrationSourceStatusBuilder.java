package io.fabric8.knative.sources.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IntegrationSourceStatusBuilder extends IntegrationSourceStatusFluent<IntegrationSourceStatusBuilder> implements VisitableBuilder<IntegrationSourceStatus,IntegrationSourceStatusBuilder>{

  IntegrationSourceStatusFluent<?> fluent;

  public IntegrationSourceStatusBuilder() {
    this(new IntegrationSourceStatus());
  }
  
  public IntegrationSourceStatusBuilder(IntegrationSourceStatusFluent<?> fluent) {
    this(fluent, new IntegrationSourceStatus());
  }
  
  public IntegrationSourceStatusBuilder(IntegrationSourceStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IntegrationSourceStatusBuilder(IntegrationSourceStatusFluent<?> fluent,IntegrationSourceStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IntegrationSourceStatus build() {
    IntegrationSourceStatus buildable = new IntegrationSourceStatus(fluent.getAnnotations(), fluent.buildAuth(), fluent.buildCeAttributes(), fluent.buildConditions(), fluent.getObservedGeneration(), fluent.getSinkAudience(), fluent.getSinkCACerts(), fluent.getSinkUri());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}