package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SpecificControllerConfigBuilder extends SpecificControllerConfigFluent<SpecificControllerConfigBuilder> implements VisitableBuilder<SpecificControllerConfig,SpecificControllerConfigBuilder>{

  SpecificControllerConfigFluent<?> fluent;

  public SpecificControllerConfigBuilder() {
    this(new SpecificControllerConfig());
  }
  
  public SpecificControllerConfigBuilder(SpecificControllerConfigFluent<?> fluent) {
    this(fluent, new SpecificControllerConfig());
  }
  
  public SpecificControllerConfigBuilder(SpecificControllerConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SpecificControllerConfigBuilder(SpecificControllerConfigFluent<?> fluent,SpecificControllerConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SpecificControllerConfig build() {
    SpecificControllerConfig buildable = new SpecificControllerConfig(fluent.buildConfig(), fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}