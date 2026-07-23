package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PowerVSPlatformSpecBuilder extends PowerVSPlatformSpecFluent<PowerVSPlatformSpecBuilder> implements VisitableBuilder<PowerVSPlatformSpec,PowerVSPlatformSpecBuilder>{

  PowerVSPlatformSpecFluent<?> fluent;

  public PowerVSPlatformSpecBuilder() {
    this(new PowerVSPlatformSpec());
  }
  
  public PowerVSPlatformSpecBuilder(PowerVSPlatformSpecFluent<?> fluent) {
    this(fluent, new PowerVSPlatformSpec());
  }
  
  public PowerVSPlatformSpecBuilder(PowerVSPlatformSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PowerVSPlatformSpecBuilder(PowerVSPlatformSpecFluent<?> fluent,PowerVSPlatformSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PowerVSPlatformSpec build() {
    PowerVSPlatformSpec buildable = new PowerVSPlatformSpec(fluent.buildServiceEndpoints());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}