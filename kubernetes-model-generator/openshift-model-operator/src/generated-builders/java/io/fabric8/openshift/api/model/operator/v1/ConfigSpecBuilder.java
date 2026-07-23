package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ConfigSpecBuilder extends ConfigSpecFluent<ConfigSpecBuilder> implements VisitableBuilder<ConfigSpec,ConfigSpecBuilder>{

  ConfigSpecFluent<?> fluent;

  public ConfigSpecBuilder() {
    this(new ConfigSpec());
  }
  
  public ConfigSpecBuilder(ConfigSpecFluent<?> fluent) {
    this(fluent, new ConfigSpec());
  }
  
  public ConfigSpecBuilder(ConfigSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ConfigSpecBuilder(ConfigSpecFluent<?> fluent,ConfigSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ConfigSpec build() {
    ConfigSpec buildable = new ConfigSpec(fluent.getLogLevel(), fluent.getManagementState(), fluent.getObservedConfig(), fluent.getOperatorLogLevel(), fluent.getUnsupportedConfigOverrides());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}