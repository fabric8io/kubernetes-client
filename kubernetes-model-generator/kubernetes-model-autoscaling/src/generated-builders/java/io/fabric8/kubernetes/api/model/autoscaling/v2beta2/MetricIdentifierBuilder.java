package io.fabric8.kubernetes.api.model.autoscaling.v2beta2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MetricIdentifierBuilder extends MetricIdentifierFluent<MetricIdentifierBuilder> implements VisitableBuilder<MetricIdentifier,MetricIdentifierBuilder>{

  MetricIdentifierFluent<?> fluent;

  public MetricIdentifierBuilder() {
    this(new MetricIdentifier());
  }
  
  public MetricIdentifierBuilder(MetricIdentifierFluent<?> fluent) {
    this(fluent, new MetricIdentifier());
  }
  
  public MetricIdentifierBuilder(MetricIdentifier instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MetricIdentifierBuilder(MetricIdentifierFluent<?> fluent,MetricIdentifier instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MetricIdentifier build() {
    MetricIdentifier buildable = new MetricIdentifier(fluent.getName(), fluent.buildSelector());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}