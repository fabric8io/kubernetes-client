package io.fabric8.kubernetes.api.model.autoscaling.v2beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ExternalMetricStatusBuilder extends ExternalMetricStatusFluent<ExternalMetricStatusBuilder> implements VisitableBuilder<ExternalMetricStatus,ExternalMetricStatusBuilder>{

  ExternalMetricStatusFluent<?> fluent;

  public ExternalMetricStatusBuilder() {
    this(new ExternalMetricStatus());
  }
  
  public ExternalMetricStatusBuilder(ExternalMetricStatusFluent<?> fluent) {
    this(fluent, new ExternalMetricStatus());
  }
  
  public ExternalMetricStatusBuilder(ExternalMetricStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ExternalMetricStatusBuilder(ExternalMetricStatusFluent<?> fluent,ExternalMetricStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ExternalMetricStatus build() {
    ExternalMetricStatus buildable = new ExternalMetricStatus(fluent.getCurrentAverageValue(), fluent.getCurrentValue(), fluent.getMetricName(), fluent.buildMetricSelector());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}