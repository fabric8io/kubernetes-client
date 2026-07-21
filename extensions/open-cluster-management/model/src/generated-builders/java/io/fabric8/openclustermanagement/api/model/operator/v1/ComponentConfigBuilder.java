package io.fabric8.openclustermanagement.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ComponentConfigBuilder extends ComponentConfigFluent<ComponentConfigBuilder> implements VisitableBuilder<ComponentConfig,ComponentConfigBuilder>{

  ComponentConfigFluent<?> fluent;

  public ComponentConfigBuilder() {
    this(new ComponentConfig());
  }
  
  public ComponentConfigBuilder(ComponentConfigFluent<?> fluent) {
    this(fluent, new ComponentConfig());
  }
  
  public ComponentConfigBuilder(ComponentConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ComponentConfigBuilder(ComponentConfigFluent<?> fluent,ComponentConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ComponentConfig build() {
    ComponentConfig buildable = new ComponentConfig(fluent.buildConfigOverrides(), fluent.getEnabled(), fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}