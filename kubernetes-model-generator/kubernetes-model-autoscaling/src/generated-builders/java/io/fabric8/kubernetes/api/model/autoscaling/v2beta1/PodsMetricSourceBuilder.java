package io.fabric8.kubernetes.api.model.autoscaling.v2beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodsMetricSourceBuilder extends PodsMetricSourceFluent<PodsMetricSourceBuilder> implements VisitableBuilder<PodsMetricSource,PodsMetricSourceBuilder>{

  PodsMetricSourceFluent<?> fluent;

  public PodsMetricSourceBuilder() {
    this(new PodsMetricSource());
  }
  
  public PodsMetricSourceBuilder(PodsMetricSourceFluent<?> fluent) {
    this(fluent, new PodsMetricSource());
  }
  
  public PodsMetricSourceBuilder(PodsMetricSource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodsMetricSourceBuilder(PodsMetricSourceFluent<?> fluent,PodsMetricSource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodsMetricSource build() {
    PodsMetricSource buildable = new PodsMetricSource(fluent.getMetricName(), fluent.buildSelector(), fluent.getTargetAverageValue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}