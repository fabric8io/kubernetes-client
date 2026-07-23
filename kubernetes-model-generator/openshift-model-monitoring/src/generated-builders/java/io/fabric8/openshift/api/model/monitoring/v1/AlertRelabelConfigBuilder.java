package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AlertRelabelConfigBuilder extends AlertRelabelConfigFluent<AlertRelabelConfigBuilder> implements VisitableBuilder<AlertRelabelConfig,AlertRelabelConfigBuilder>{

  AlertRelabelConfigFluent<?> fluent;

  public AlertRelabelConfigBuilder() {
    this(new AlertRelabelConfig());
  }
  
  public AlertRelabelConfigBuilder(AlertRelabelConfigFluent<?> fluent) {
    this(fluent, new AlertRelabelConfig());
  }
  
  public AlertRelabelConfigBuilder(AlertRelabelConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AlertRelabelConfigBuilder(AlertRelabelConfigFluent<?> fluent,AlertRelabelConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AlertRelabelConfig build() {
    AlertRelabelConfig buildable = new AlertRelabelConfig(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}