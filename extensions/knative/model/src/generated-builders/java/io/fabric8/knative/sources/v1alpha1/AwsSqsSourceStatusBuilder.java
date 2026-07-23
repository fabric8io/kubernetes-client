package io.fabric8.knative.sources.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AwsSqsSourceStatusBuilder extends AwsSqsSourceStatusFluent<AwsSqsSourceStatusBuilder> implements VisitableBuilder<AwsSqsSourceStatus,AwsSqsSourceStatusBuilder>{

  AwsSqsSourceStatusFluent<?> fluent;

  public AwsSqsSourceStatusBuilder() {
    this(new AwsSqsSourceStatus());
  }
  
  public AwsSqsSourceStatusBuilder(AwsSqsSourceStatusFluent<?> fluent) {
    this(fluent, new AwsSqsSourceStatus());
  }
  
  public AwsSqsSourceStatusBuilder(AwsSqsSourceStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AwsSqsSourceStatusBuilder(AwsSqsSourceStatusFluent<?> fluent,AwsSqsSourceStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AwsSqsSourceStatus build() {
    AwsSqsSourceStatus buildable = new AwsSqsSourceStatus(fluent.getAnnotations(), fluent.buildAuth(), fluent.buildCeAttributes(), fluent.buildConditions(), fluent.getObservedGeneration(), fluent.getSinkAudience(), fluent.getSinkCACerts(), fluent.getSinkUri());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}