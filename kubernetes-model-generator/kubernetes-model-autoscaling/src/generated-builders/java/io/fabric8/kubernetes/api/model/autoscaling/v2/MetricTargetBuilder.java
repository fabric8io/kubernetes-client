package io.fabric8.kubernetes.api.model.autoscaling.v2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MetricTargetBuilder extends MetricTargetFluent<MetricTargetBuilder> implements VisitableBuilder<MetricTarget,MetricTargetBuilder>{

  MetricTargetFluent<?> fluent;

  public MetricTargetBuilder() {
    this(new MetricTarget());
  }
  
  public MetricTargetBuilder(MetricTargetFluent<?> fluent) {
    this(fluent, new MetricTarget());
  }
  
  public MetricTargetBuilder(MetricTarget instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MetricTargetBuilder(MetricTargetFluent<?> fluent,MetricTarget instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MetricTarget build() {
    MetricTarget buildable = new MetricTarget(fluent.getAverageUtilization(), fluent.getAverageValue(), fluent.getType(), fluent.getValue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}