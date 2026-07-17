package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NutanixPlatformStatusBuilder extends NutanixPlatformStatusFluent<NutanixPlatformStatusBuilder> implements VisitableBuilder<NutanixPlatformStatus,NutanixPlatformStatusBuilder>{

  NutanixPlatformStatusFluent<?> fluent;

  public NutanixPlatformStatusBuilder() {
    this(new NutanixPlatformStatus());
  }
  
  public NutanixPlatformStatusBuilder(NutanixPlatformStatusFluent<?> fluent) {
    this(fluent, new NutanixPlatformStatus());
  }
  
  public NutanixPlatformStatusBuilder(NutanixPlatformStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NutanixPlatformStatusBuilder(NutanixPlatformStatusFluent<?> fluent,NutanixPlatformStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NutanixPlatformStatus build() {
    NutanixPlatformStatus buildable = new NutanixPlatformStatus(fluent.getApiServerInternalIP(), fluent.getApiServerInternalIPs(), fluent.getIngressIP(), fluent.getIngressIPs(), fluent.buildLoadBalancer());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}