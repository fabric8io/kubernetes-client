package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AlertmanagerLimitsSpecBuilder extends AlertmanagerLimitsSpecFluent<AlertmanagerLimitsSpecBuilder> implements VisitableBuilder<AlertmanagerLimitsSpec,AlertmanagerLimitsSpecBuilder>{

  AlertmanagerLimitsSpecFluent<?> fluent;

  public AlertmanagerLimitsSpecBuilder() {
    this(new AlertmanagerLimitsSpec());
  }
  
  public AlertmanagerLimitsSpecBuilder(AlertmanagerLimitsSpecFluent<?> fluent) {
    this(fluent, new AlertmanagerLimitsSpec());
  }
  
  public AlertmanagerLimitsSpecBuilder(AlertmanagerLimitsSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AlertmanagerLimitsSpecBuilder(AlertmanagerLimitsSpecFluent<?> fluent,AlertmanagerLimitsSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AlertmanagerLimitsSpec build() {
    AlertmanagerLimitsSpec buildable = new AlertmanagerLimitsSpec(fluent.getMaxPerSilenceBytes(), fluent.getMaxSilences());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}