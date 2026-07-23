package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AlertmanagerWebSpecBuilder extends AlertmanagerWebSpecFluent<AlertmanagerWebSpecBuilder> implements VisitableBuilder<AlertmanagerWebSpec,AlertmanagerWebSpecBuilder>{

  AlertmanagerWebSpecFluent<?> fluent;

  public AlertmanagerWebSpecBuilder() {
    this(new AlertmanagerWebSpec());
  }
  
  public AlertmanagerWebSpecBuilder(AlertmanagerWebSpecFluent<?> fluent) {
    this(fluent, new AlertmanagerWebSpec());
  }
  
  public AlertmanagerWebSpecBuilder(AlertmanagerWebSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AlertmanagerWebSpecBuilder(AlertmanagerWebSpecFluent<?> fluent,AlertmanagerWebSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AlertmanagerWebSpec build() {
    AlertmanagerWebSpec buildable = new AlertmanagerWebSpec(fluent.getGetConcurrency(), fluent.buildHttpConfig(), fluent.getTimeout(), fluent.buildTlsConfig());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}