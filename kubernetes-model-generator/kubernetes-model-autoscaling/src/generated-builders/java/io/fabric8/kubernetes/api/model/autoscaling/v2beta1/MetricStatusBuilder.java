package io.fabric8.kubernetes.api.model.autoscaling.v2beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MetricStatusBuilder extends MetricStatusFluent<MetricStatusBuilder> implements VisitableBuilder<MetricStatus,MetricStatusBuilder>{

  MetricStatusFluent<?> fluent;

  public MetricStatusBuilder() {
    this(new MetricStatus());
  }
  
  public MetricStatusBuilder(MetricStatusFluent<?> fluent) {
    this(fluent, new MetricStatus());
  }
  
  public MetricStatusBuilder(MetricStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MetricStatusBuilder(MetricStatusFluent<?> fluent,MetricStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MetricStatus build() {
    MetricStatus buildable = new MetricStatus(fluent.buildContainerResource(), fluent.buildExternal(), fluent.buildObject(), fluent.buildPods(), fluent.buildResource(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}