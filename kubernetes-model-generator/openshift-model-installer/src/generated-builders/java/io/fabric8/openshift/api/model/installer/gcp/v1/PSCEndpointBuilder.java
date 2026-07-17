package io.fabric8.openshift.api.model.installer.gcp.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PSCEndpointBuilder extends PSCEndpointFluent<PSCEndpointBuilder> implements VisitableBuilder<PSCEndpoint,PSCEndpointBuilder>{

  PSCEndpointFluent<?> fluent;

  public PSCEndpointBuilder() {
    this(new PSCEndpoint());
  }
  
  public PSCEndpointBuilder(PSCEndpointFluent<?> fluent) {
    this(fluent, new PSCEndpoint());
  }
  
  public PSCEndpointBuilder(PSCEndpoint instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PSCEndpointBuilder(PSCEndpointFluent<?> fluent,PSCEndpoint instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PSCEndpoint build() {
    PSCEndpoint buildable = new PSCEndpoint(fluent.getClusterUseOnly(), fluent.getName(), fluent.getRegion());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}