package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AlertmanagerStatusBuilder extends AlertmanagerStatusFluent<AlertmanagerStatusBuilder> implements VisitableBuilder<AlertmanagerStatus,AlertmanagerStatusBuilder>{

  AlertmanagerStatusFluent<?> fluent;

  public AlertmanagerStatusBuilder() {
    this(new AlertmanagerStatus());
  }
  
  public AlertmanagerStatusBuilder(AlertmanagerStatusFluent<?> fluent) {
    this(fluent, new AlertmanagerStatus());
  }
  
  public AlertmanagerStatusBuilder(AlertmanagerStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AlertmanagerStatusBuilder(AlertmanagerStatusFluent<?> fluent,AlertmanagerStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AlertmanagerStatus build() {
    AlertmanagerStatus buildable = new AlertmanagerStatus(fluent.getAvailableReplicas(), fluent.buildConditions(), fluent.getPaused(), fluent.getReplicas(), fluent.getSelector(), fluent.getUnavailableReplicas(), fluent.getUpdatedReplicas());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}