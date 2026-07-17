package io.fabric8.openshift.api.model.machineconfiguration.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ControllerConfigBuilder extends ControllerConfigFluent<ControllerConfigBuilder> implements VisitableBuilder<ControllerConfig,ControllerConfigBuilder>{

  ControllerConfigFluent<?> fluent;

  public ControllerConfigBuilder() {
    this(new ControllerConfig());
  }
  
  public ControllerConfigBuilder(ControllerConfigFluent<?> fluent) {
    this(fluent, new ControllerConfig());
  }
  
  public ControllerConfigBuilder(ControllerConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ControllerConfigBuilder(ControllerConfigFluent<?> fluent,ControllerConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ControllerConfig build() {
    ControllerConfig buildable = new ControllerConfig(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}