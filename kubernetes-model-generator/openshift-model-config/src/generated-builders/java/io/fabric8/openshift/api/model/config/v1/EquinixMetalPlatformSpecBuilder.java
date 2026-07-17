package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EquinixMetalPlatformSpecBuilder extends EquinixMetalPlatformSpecFluent<EquinixMetalPlatformSpecBuilder> implements VisitableBuilder<EquinixMetalPlatformSpec,EquinixMetalPlatformSpecBuilder>{

  EquinixMetalPlatformSpecFluent<?> fluent;

  public EquinixMetalPlatformSpecBuilder() {
    this(new EquinixMetalPlatformSpec());
  }
  
  public EquinixMetalPlatformSpecBuilder(EquinixMetalPlatformSpecFluent<?> fluent) {
    this(fluent, new EquinixMetalPlatformSpec());
  }
  
  public EquinixMetalPlatformSpecBuilder(EquinixMetalPlatformSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EquinixMetalPlatformSpecBuilder(EquinixMetalPlatformSpecFluent<?> fluent,EquinixMetalPlatformSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EquinixMetalPlatformSpec build() {
    EquinixMetalPlatformSpec buildable = new EquinixMetalPlatformSpec();
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}