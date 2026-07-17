package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AlertmanagerConfigurationBuilder extends AlertmanagerConfigurationFluent<AlertmanagerConfigurationBuilder> implements VisitableBuilder<AlertmanagerConfiguration,AlertmanagerConfigurationBuilder>{

  AlertmanagerConfigurationFluent<?> fluent;

  public AlertmanagerConfigurationBuilder() {
    this(new AlertmanagerConfiguration());
  }
  
  public AlertmanagerConfigurationBuilder(AlertmanagerConfigurationFluent<?> fluent) {
    this(fluent, new AlertmanagerConfiguration());
  }
  
  public AlertmanagerConfigurationBuilder(AlertmanagerConfiguration instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AlertmanagerConfigurationBuilder(AlertmanagerConfigurationFluent<?> fluent,AlertmanagerConfiguration instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AlertmanagerConfiguration build() {
    AlertmanagerConfiguration buildable = new AlertmanagerConfiguration(fluent.buildGlobal(), fluent.getName(), fluent.buildTemplates());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}