package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GatewayBackendTLSBuilder extends GatewayBackendTLSFluent<GatewayBackendTLSBuilder> implements VisitableBuilder<GatewayBackendTLS,GatewayBackendTLSBuilder>{

  GatewayBackendTLSFluent<?> fluent;

  public GatewayBackendTLSBuilder() {
    this(new GatewayBackendTLS());
  }
  
  public GatewayBackendTLSBuilder(GatewayBackendTLSFluent<?> fluent) {
    this(fluent, new GatewayBackendTLS());
  }
  
  public GatewayBackendTLSBuilder(GatewayBackendTLS instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GatewayBackendTLSBuilder(GatewayBackendTLSFluent<?> fluent,GatewayBackendTLS instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GatewayBackendTLS build() {
    GatewayBackendTLS buildable = new GatewayBackendTLS(fluent.buildClientCertificateRef());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}