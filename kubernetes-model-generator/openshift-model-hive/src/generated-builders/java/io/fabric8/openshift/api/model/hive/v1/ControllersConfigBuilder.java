package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ControllersConfigBuilder extends ControllersConfigFluent<ControllersConfigBuilder> implements VisitableBuilder<ControllersConfig,ControllersConfigBuilder>{

  ControllersConfigFluent<?> fluent;

  public ControllersConfigBuilder() {
    this(new ControllersConfig());
  }
  
  public ControllersConfigBuilder(ControllersConfigFluent<?> fluent) {
    this(fluent, new ControllersConfig());
  }
  
  public ControllersConfigBuilder(ControllersConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ControllersConfigBuilder(ControllersConfigFluent<?> fluent,ControllersConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ControllersConfig build() {
    ControllersConfig buildable = new ControllersConfig(fluent.buildControllers(), fluent.buildDefault());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}