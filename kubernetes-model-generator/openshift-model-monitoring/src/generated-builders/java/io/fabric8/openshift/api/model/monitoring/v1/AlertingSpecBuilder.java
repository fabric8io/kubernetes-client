package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AlertingSpecBuilder extends AlertingSpecFluent<AlertingSpecBuilder> implements VisitableBuilder<AlertingSpec,AlertingSpecBuilder>{

  AlertingSpecFluent<?> fluent;

  public AlertingSpecBuilder() {
    this(new AlertingSpec());
  }
  
  public AlertingSpecBuilder(AlertingSpecFluent<?> fluent) {
    this(fluent, new AlertingSpec());
  }
  
  public AlertingSpecBuilder(AlertingSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AlertingSpecBuilder(AlertingSpecFluent<?> fluent,AlertingSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AlertingSpec build() {
    AlertingSpec buildable = new AlertingSpec(fluent.buildAlertmanagers());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}