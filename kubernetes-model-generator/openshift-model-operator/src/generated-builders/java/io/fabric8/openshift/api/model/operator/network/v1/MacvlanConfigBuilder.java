package io.fabric8.openshift.api.model.operator.network.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MacvlanConfigBuilder extends MacvlanConfigFluent<MacvlanConfigBuilder> implements VisitableBuilder<MacvlanConfig,MacvlanConfigBuilder>{

  MacvlanConfigFluent<?> fluent;

  public MacvlanConfigBuilder() {
    this(new MacvlanConfig());
  }
  
  public MacvlanConfigBuilder(MacvlanConfigFluent<?> fluent) {
    this(fluent, new MacvlanConfig());
  }
  
  public MacvlanConfigBuilder(MacvlanConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MacvlanConfigBuilder(MacvlanConfigFluent<?> fluent,MacvlanConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MacvlanConfig build() {
    MacvlanConfig buildable = new MacvlanConfig(fluent.getMaster(), fluent.getMode());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}