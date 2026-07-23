package io.fabric8.openshift.api.model.monitoring.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AlertmanagerConfigSpecBuilder extends AlertmanagerConfigSpecFluent<AlertmanagerConfigSpecBuilder> implements VisitableBuilder<AlertmanagerConfigSpec,AlertmanagerConfigSpecBuilder>{

  AlertmanagerConfigSpecFluent<?> fluent;

  public AlertmanagerConfigSpecBuilder() {
    this(new AlertmanagerConfigSpec());
  }
  
  public AlertmanagerConfigSpecBuilder(AlertmanagerConfigSpecFluent<?> fluent) {
    this(fluent, new AlertmanagerConfigSpec());
  }
  
  public AlertmanagerConfigSpecBuilder(AlertmanagerConfigSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AlertmanagerConfigSpecBuilder(AlertmanagerConfigSpecFluent<?> fluent,AlertmanagerConfigSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AlertmanagerConfigSpec build() {
    AlertmanagerConfigSpec buildable = new AlertmanagerConfigSpec(fluent.buildInhibitRules(), fluent.buildReceivers(), fluent.buildRoute(), fluent.buildTimeIntervals());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}