package io.fabric8.openshift.api.model.monitoring.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AlertmanagerConfigBuilder extends AlertmanagerConfigFluent<AlertmanagerConfigBuilder> implements VisitableBuilder<AlertmanagerConfig,AlertmanagerConfigBuilder>{

  AlertmanagerConfigFluent<?> fluent;

  public AlertmanagerConfigBuilder() {
    this(new AlertmanagerConfig());
  }
  
  public AlertmanagerConfigBuilder(AlertmanagerConfigFluent<?> fluent) {
    this(fluent, new AlertmanagerConfig());
  }
  
  public AlertmanagerConfigBuilder(AlertmanagerConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AlertmanagerConfigBuilder(AlertmanagerConfigFluent<?> fluent,AlertmanagerConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AlertmanagerConfig build() {
    AlertmanagerConfig buildable = new AlertmanagerConfig(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}