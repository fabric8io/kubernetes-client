package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OperationMetricBuilder extends OperationMetricFluent<OperationMetricBuilder> implements VisitableBuilder<OperationMetric,OperationMetricBuilder>{

  OperationMetricFluent<?> fluent;

  public OperationMetricBuilder() {
    this(new OperationMetric());
  }
  
  public OperationMetricBuilder(OperationMetricFluent<?> fluent) {
    this(fluent, new OperationMetric());
  }
  
  public OperationMetricBuilder(OperationMetric instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OperationMetricBuilder(OperationMetricFluent<?> fluent,OperationMetric instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OperationMetric build() {
    OperationMetric buildable = new OperationMetric(fluent.getEnd(), fluent.getStart());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}