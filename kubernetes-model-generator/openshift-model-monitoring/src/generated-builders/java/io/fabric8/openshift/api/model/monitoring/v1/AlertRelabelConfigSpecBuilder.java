package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AlertRelabelConfigSpecBuilder extends AlertRelabelConfigSpecFluent<AlertRelabelConfigSpecBuilder> implements VisitableBuilder<AlertRelabelConfigSpec,AlertRelabelConfigSpecBuilder>{

  AlertRelabelConfigSpecFluent<?> fluent;

  public AlertRelabelConfigSpecBuilder() {
    this(new AlertRelabelConfigSpec());
  }
  
  public AlertRelabelConfigSpecBuilder(AlertRelabelConfigSpecFluent<?> fluent) {
    this(fluent, new AlertRelabelConfigSpec());
  }
  
  public AlertRelabelConfigSpecBuilder(AlertRelabelConfigSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AlertRelabelConfigSpecBuilder(AlertRelabelConfigSpecFluent<?> fluent,AlertRelabelConfigSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AlertRelabelConfigSpec build() {
    AlertRelabelConfigSpec buildable = new AlertRelabelConfigSpec(fluent.buildConfigs());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}