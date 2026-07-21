package io.fabric8.openclustermanagement.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EnvConfigBuilder extends EnvConfigFluent<EnvConfigBuilder> implements VisitableBuilder<EnvConfig,EnvConfigBuilder>{

  EnvConfigFluent<?> fluent;

  public EnvConfigBuilder() {
    this(new EnvConfig());
  }
  
  public EnvConfigBuilder(EnvConfigFluent<?> fluent) {
    this(fluent, new EnvConfig());
  }
  
  public EnvConfigBuilder(EnvConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EnvConfigBuilder(EnvConfigFluent<?> fluent,EnvConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EnvConfig build() {
    EnvConfig buildable = new EnvConfig(fluent.getName(), fluent.getValue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}