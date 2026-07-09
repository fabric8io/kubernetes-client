package io.fabric8.kubernetes.api.model.autoscaling.v2beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ExternalMetricSourceBuilder extends ExternalMetricSourceFluent<ExternalMetricSourceBuilder> implements VisitableBuilder<ExternalMetricSource,ExternalMetricSourceBuilder>{

  ExternalMetricSourceFluent<?> fluent;

  public ExternalMetricSourceBuilder() {
    this(new ExternalMetricSource());
  }
  
  public ExternalMetricSourceBuilder(ExternalMetricSourceFluent<?> fluent) {
    this(fluent, new ExternalMetricSource());
  }
  
  public ExternalMetricSourceBuilder(ExternalMetricSource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ExternalMetricSourceBuilder(ExternalMetricSourceFluent<?> fluent,ExternalMetricSource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ExternalMetricSource build() {
    ExternalMetricSource buildable = new ExternalMetricSource(fluent.getMetricName(), fluent.buildMetricSelector(), fluent.getTargetAverageValue(), fluent.getTargetValue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}