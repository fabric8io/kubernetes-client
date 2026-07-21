package io.fabric8.openclustermanagement.api.model.observability.v1beta2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AlertmanagerSpecBuilder extends AlertmanagerSpecFluent<AlertmanagerSpecBuilder> implements VisitableBuilder<AlertmanagerSpec,AlertmanagerSpecBuilder>{

  AlertmanagerSpecFluent<?> fluent;

  public AlertmanagerSpecBuilder() {
    this(new AlertmanagerSpec());
  }
  
  public AlertmanagerSpecBuilder(AlertmanagerSpecFluent<?> fluent) {
    this(fluent, new AlertmanagerSpec());
  }
  
  public AlertmanagerSpecBuilder(AlertmanagerSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AlertmanagerSpecBuilder(AlertmanagerSpecFluent<?> fluent,AlertmanagerSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AlertmanagerSpec build() {
    AlertmanagerSpec buildable = new AlertmanagerSpec(fluent.getReplicas(), fluent.buildResources(), fluent.getSecrets());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}