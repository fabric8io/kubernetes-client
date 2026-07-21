package io.fabric8.knative.sources.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PingSourceStatusBuilder extends PingSourceStatusFluent<PingSourceStatusBuilder> implements VisitableBuilder<PingSourceStatus,PingSourceStatusBuilder>{

  PingSourceStatusFluent<?> fluent;

  public PingSourceStatusBuilder() {
    this(new PingSourceStatus());
  }
  
  public PingSourceStatusBuilder(PingSourceStatusFluent<?> fluent) {
    this(fluent, new PingSourceStatus());
  }
  
  public PingSourceStatusBuilder(PingSourceStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PingSourceStatusBuilder(PingSourceStatusFluent<?> fluent,PingSourceStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PingSourceStatus build() {
    PingSourceStatus buildable = new PingSourceStatus(fluent.getAnnotations(), fluent.buildAuth(), fluent.buildCeAttributes(), fluent.buildConditions(), fluent.getObservedGeneration(), fluent.getSinkAudience(), fluent.getSinkCACerts(), fluent.getSinkUri());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}