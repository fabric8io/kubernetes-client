package io.fabric8.openshift.api.model.hive.aws.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VPCEndpointServiceBuilder extends VPCEndpointServiceFluent<VPCEndpointServiceBuilder> implements VisitableBuilder<VPCEndpointService,VPCEndpointServiceBuilder>{

  VPCEndpointServiceFluent<?> fluent;

  public VPCEndpointServiceBuilder() {
    this(new VPCEndpointService());
  }
  
  public VPCEndpointServiceBuilder(VPCEndpointServiceFluent<?> fluent) {
    this(fluent, new VPCEndpointService());
  }
  
  public VPCEndpointServiceBuilder(VPCEndpointService instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VPCEndpointServiceBuilder(VPCEndpointServiceFluent<?> fluent,VPCEndpointService instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VPCEndpointService build() {
    VPCEndpointService buildable = new VPCEndpointService(fluent.getAdditionalAllowedPrincipals(), fluent.getDefaultAllowedPrincipal(), fluent.getId(), fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}