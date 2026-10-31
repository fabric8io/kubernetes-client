package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BootImageSkewEnforcementConfigBuilder extends BootImageSkewEnforcementConfigFluent<BootImageSkewEnforcementConfigBuilder> implements VisitableBuilder<BootImageSkewEnforcementConfig,BootImageSkewEnforcementConfigBuilder>{

  BootImageSkewEnforcementConfigFluent<?> fluent;

  public BootImageSkewEnforcementConfigBuilder() {
    this(new BootImageSkewEnforcementConfig());
  }
  
  public BootImageSkewEnforcementConfigBuilder(BootImageSkewEnforcementConfigFluent<?> fluent) {
    this(fluent, new BootImageSkewEnforcementConfig());
  }
  
  public BootImageSkewEnforcementConfigBuilder(BootImageSkewEnforcementConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BootImageSkewEnforcementConfigBuilder(BootImageSkewEnforcementConfigFluent<?> fluent,BootImageSkewEnforcementConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public BootImageSkewEnforcementConfig build() {
    BootImageSkewEnforcementConfig buildable = new BootImageSkewEnforcementConfig(fluent.buildManual(), fluent.getMode());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}