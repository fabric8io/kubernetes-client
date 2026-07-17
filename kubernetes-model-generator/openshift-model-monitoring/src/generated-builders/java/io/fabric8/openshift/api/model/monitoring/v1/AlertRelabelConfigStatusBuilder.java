package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AlertRelabelConfigStatusBuilder extends AlertRelabelConfigStatusFluent<AlertRelabelConfigStatusBuilder> implements VisitableBuilder<AlertRelabelConfigStatus,AlertRelabelConfigStatusBuilder>{

  AlertRelabelConfigStatusFluent<?> fluent;

  public AlertRelabelConfigStatusBuilder() {
    this(new AlertRelabelConfigStatus());
  }
  
  public AlertRelabelConfigStatusBuilder(AlertRelabelConfigStatusFluent<?> fluent) {
    this(fluent, new AlertRelabelConfigStatus());
  }
  
  public AlertRelabelConfigStatusBuilder(AlertRelabelConfigStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AlertRelabelConfigStatusBuilder(AlertRelabelConfigStatusFluent<?> fluent,AlertRelabelConfigStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AlertRelabelConfigStatus build() {
    AlertRelabelConfigStatus buildable = new AlertRelabelConfigStatus(fluent.getConditions());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}