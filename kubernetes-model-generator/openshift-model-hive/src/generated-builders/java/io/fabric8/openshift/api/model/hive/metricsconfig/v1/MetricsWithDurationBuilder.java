package io.fabric8.openshift.api.model.hive.metricsconfig.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MetricsWithDurationBuilder extends MetricsWithDurationFluent<MetricsWithDurationBuilder> implements VisitableBuilder<MetricsWithDuration,MetricsWithDurationBuilder>{

  MetricsWithDurationFluent<?> fluent;

  public MetricsWithDurationBuilder() {
    this(new MetricsWithDuration());
  }
  
  public MetricsWithDurationBuilder(MetricsWithDurationFluent<?> fluent) {
    this(fluent, new MetricsWithDuration());
  }
  
  public MetricsWithDurationBuilder(MetricsWithDuration instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MetricsWithDurationBuilder(MetricsWithDurationFluent<?> fluent,MetricsWithDuration instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MetricsWithDuration build() {
    MetricsWithDuration buildable = new MetricsWithDuration(fluent.getDuration(), fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}