package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OpenStackPlatformSpecBuilder extends OpenStackPlatformSpecFluent<OpenStackPlatformSpecBuilder> implements VisitableBuilder<OpenStackPlatformSpec,OpenStackPlatformSpecBuilder>{

  OpenStackPlatformSpecFluent<?> fluent;

  public OpenStackPlatformSpecBuilder() {
    this(new OpenStackPlatformSpec());
  }
  
  public OpenStackPlatformSpecBuilder(OpenStackPlatformSpecFluent<?> fluent) {
    this(fluent, new OpenStackPlatformSpec());
  }
  
  public OpenStackPlatformSpecBuilder(OpenStackPlatformSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OpenStackPlatformSpecBuilder(OpenStackPlatformSpecFluent<?> fluent,OpenStackPlatformSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OpenStackPlatformSpec build() {
    OpenStackPlatformSpec buildable = new OpenStackPlatformSpec(fluent.getApiServerInternalIPs(), fluent.getIngressIPs(), fluent.getMachineNetworks());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}