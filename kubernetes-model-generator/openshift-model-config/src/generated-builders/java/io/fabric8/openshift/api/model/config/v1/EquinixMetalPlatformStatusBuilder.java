package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EquinixMetalPlatformStatusBuilder extends EquinixMetalPlatformStatusFluent<EquinixMetalPlatformStatusBuilder> implements VisitableBuilder<EquinixMetalPlatformStatus,EquinixMetalPlatformStatusBuilder>{

  EquinixMetalPlatformStatusFluent<?> fluent;

  public EquinixMetalPlatformStatusBuilder() {
    this(new EquinixMetalPlatformStatus());
  }
  
  public EquinixMetalPlatformStatusBuilder(EquinixMetalPlatformStatusFluent<?> fluent) {
    this(fluent, new EquinixMetalPlatformStatus());
  }
  
  public EquinixMetalPlatformStatusBuilder(EquinixMetalPlatformStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EquinixMetalPlatformStatusBuilder(EquinixMetalPlatformStatusFluent<?> fluent,EquinixMetalPlatformStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EquinixMetalPlatformStatus build() {
    EquinixMetalPlatformStatus buildable = new EquinixMetalPlatformStatus(fluent.getApiServerInternalIP(), fluent.getIngressIP());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}