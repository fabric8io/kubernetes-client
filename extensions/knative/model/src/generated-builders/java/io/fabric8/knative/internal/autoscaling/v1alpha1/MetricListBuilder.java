package io.fabric8.knative.internal.autoscaling.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MetricListBuilder extends MetricListFluent<MetricListBuilder> implements VisitableBuilder<MetricList,MetricListBuilder>{

  MetricListFluent<?> fluent;

  public MetricListBuilder() {
    this(new MetricList());
  }
  
  public MetricListBuilder(MetricListFluent<?> fluent) {
    this(fluent, new MetricList());
  }
  
  public MetricListBuilder(MetricList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MetricListBuilder(MetricListFluent<?> fluent,MetricList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MetricList build() {
    MetricList buildable = new MetricList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}