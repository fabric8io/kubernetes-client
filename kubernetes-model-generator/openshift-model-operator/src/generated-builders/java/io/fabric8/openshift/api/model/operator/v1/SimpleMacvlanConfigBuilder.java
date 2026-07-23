package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SimpleMacvlanConfigBuilder extends SimpleMacvlanConfigFluent<SimpleMacvlanConfigBuilder> implements VisitableBuilder<SimpleMacvlanConfig,SimpleMacvlanConfigBuilder>{

  SimpleMacvlanConfigFluent<?> fluent;

  public SimpleMacvlanConfigBuilder() {
    this(new SimpleMacvlanConfig());
  }
  
  public SimpleMacvlanConfigBuilder(SimpleMacvlanConfigFluent<?> fluent) {
    this(fluent, new SimpleMacvlanConfig());
  }
  
  public SimpleMacvlanConfigBuilder(SimpleMacvlanConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SimpleMacvlanConfigBuilder(SimpleMacvlanConfigFluent<?> fluent,SimpleMacvlanConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SimpleMacvlanConfig build() {
    SimpleMacvlanConfig buildable = new SimpleMacvlanConfig(fluent.buildIpamConfig(), fluent.getMaster(), fluent.getMode(), fluent.getMtu());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}