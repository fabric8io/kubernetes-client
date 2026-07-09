package io.fabric8.kubernetes.api.model.autoscaling.v2beta2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ObjectMetricStatusBuilder extends ObjectMetricStatusFluent<ObjectMetricStatusBuilder> implements VisitableBuilder<ObjectMetricStatus,ObjectMetricStatusBuilder>{

  ObjectMetricStatusFluent<?> fluent;

  public ObjectMetricStatusBuilder() {
    this(new ObjectMetricStatus());
  }
  
  public ObjectMetricStatusBuilder(ObjectMetricStatusFluent<?> fluent) {
    this(fluent, new ObjectMetricStatus());
  }
  
  public ObjectMetricStatusBuilder(ObjectMetricStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ObjectMetricStatusBuilder(ObjectMetricStatusFluent<?> fluent,ObjectMetricStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ObjectMetricStatus build() {
    ObjectMetricStatus buildable = new ObjectMetricStatus(fluent.buildCurrent(), fluent.buildDescribedObject(), fluent.buildMetric());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}