package io.fabric8.istio.api.api.security.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PeerAuthenticationMutualTLSBuilder extends PeerAuthenticationMutualTLSFluent<PeerAuthenticationMutualTLSBuilder> implements VisitableBuilder<PeerAuthenticationMutualTLS,PeerAuthenticationMutualTLSBuilder>{

  PeerAuthenticationMutualTLSFluent<?> fluent;

  public PeerAuthenticationMutualTLSBuilder() {
    this(new PeerAuthenticationMutualTLS());
  }
  
  public PeerAuthenticationMutualTLSBuilder(PeerAuthenticationMutualTLSFluent<?> fluent) {
    this(fluent, new PeerAuthenticationMutualTLS());
  }
  
  public PeerAuthenticationMutualTLSBuilder(PeerAuthenticationMutualTLS instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PeerAuthenticationMutualTLSBuilder(PeerAuthenticationMutualTLSFluent<?> fluent,PeerAuthenticationMutualTLS instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PeerAuthenticationMutualTLS build() {
    PeerAuthenticationMutualTLS buildable = new PeerAuthenticationMutualTLS(fluent.getMode());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}