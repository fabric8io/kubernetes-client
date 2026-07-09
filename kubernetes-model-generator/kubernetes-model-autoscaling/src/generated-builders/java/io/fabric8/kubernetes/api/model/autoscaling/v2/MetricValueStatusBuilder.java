package io.fabric8.kubernetes.api.model.autoscaling.v2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MetricValueStatusBuilder extends MetricValueStatusFluent<MetricValueStatusBuilder> implements VisitableBuilder<MetricValueStatus,MetricValueStatusBuilder>{

  MetricValueStatusFluent<?> fluent;

  public MetricValueStatusBuilder() {
    this(new MetricValueStatus());
  }
  
  public MetricValueStatusBuilder(MetricValueStatusFluent<?> fluent) {
    this(fluent, new MetricValueStatus());
  }
  
  public MetricValueStatusBuilder(MetricValueStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MetricValueStatusBuilder(MetricValueStatusFluent<?> fluent,MetricValueStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MetricValueStatus build() {
    MetricValueStatus buildable = new MetricValueStatus(fluent.getAverageUtilization(), fluent.getAverageValue(), fluent.getValue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}