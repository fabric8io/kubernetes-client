package io.fabric8.knative.duck.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SourceStatusBuilder extends SourceStatusFluent<SourceStatusBuilder> implements VisitableBuilder<SourceStatus,SourceStatusBuilder>{

  SourceStatusFluent<?> fluent;

  public SourceStatusBuilder() {
    this(new SourceStatus());
  }
  
  public SourceStatusBuilder(SourceStatusFluent<?> fluent) {
    this(fluent, new SourceStatus());
  }
  
  public SourceStatusBuilder(SourceStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SourceStatusBuilder(SourceStatusFluent<?> fluent,SourceStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SourceStatus build() {
    SourceStatus buildable = new SourceStatus(fluent.getAnnotations(), fluent.buildAuth(), fluent.buildCeAttributes(), fluent.buildConditions(), fluent.getObservedGeneration(), fluent.getSinkAudience(), fluent.getSinkCACerts(), fluent.getSinkUri());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}