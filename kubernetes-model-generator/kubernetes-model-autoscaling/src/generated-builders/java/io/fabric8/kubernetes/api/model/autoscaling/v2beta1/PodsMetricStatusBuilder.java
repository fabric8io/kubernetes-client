package io.fabric8.kubernetes.api.model.autoscaling.v2beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodsMetricStatusBuilder extends PodsMetricStatusFluent<PodsMetricStatusBuilder> implements VisitableBuilder<PodsMetricStatus,PodsMetricStatusBuilder>{

  PodsMetricStatusFluent<?> fluent;

  public PodsMetricStatusBuilder() {
    this(new PodsMetricStatus());
  }
  
  public PodsMetricStatusBuilder(PodsMetricStatusFluent<?> fluent) {
    this(fluent, new PodsMetricStatus());
  }
  
  public PodsMetricStatusBuilder(PodsMetricStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodsMetricStatusBuilder(PodsMetricStatusFluent<?> fluent,PodsMetricStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodsMetricStatus build() {
    PodsMetricStatus buildable = new PodsMetricStatus(fluent.getCurrentAverageValue(), fluent.getMetricName(), fluent.buildSelector());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}