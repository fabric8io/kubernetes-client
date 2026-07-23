package io.fabric8.kubernetes.api.model.autoscaling.v2beta2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ObjectMetricSourceBuilder extends ObjectMetricSourceFluent<ObjectMetricSourceBuilder> implements VisitableBuilder<ObjectMetricSource,ObjectMetricSourceBuilder>{

  ObjectMetricSourceFluent<?> fluent;

  public ObjectMetricSourceBuilder() {
    this(new ObjectMetricSource());
  }
  
  public ObjectMetricSourceBuilder(ObjectMetricSourceFluent<?> fluent) {
    this(fluent, new ObjectMetricSource());
  }
  
  public ObjectMetricSourceBuilder(ObjectMetricSource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ObjectMetricSourceBuilder(ObjectMetricSourceFluent<?> fluent,ObjectMetricSource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ObjectMetricSource build() {
    ObjectMetricSource buildable = new ObjectMetricSource(fluent.buildDescribedObject(), fluent.buildMetric(), fluent.buildTarget());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}