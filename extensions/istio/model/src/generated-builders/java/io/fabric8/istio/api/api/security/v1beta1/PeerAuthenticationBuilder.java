package io.fabric8.istio.api.api.security.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PeerAuthenticationBuilder extends PeerAuthenticationFluent<PeerAuthenticationBuilder> implements VisitableBuilder<PeerAuthentication,PeerAuthenticationBuilder>{

  PeerAuthenticationFluent<?> fluent;

  public PeerAuthenticationBuilder() {
    this(new PeerAuthentication());
  }
  
  public PeerAuthenticationBuilder(PeerAuthenticationFluent<?> fluent) {
    this(fluent, new PeerAuthentication());
  }
  
  public PeerAuthenticationBuilder(PeerAuthentication instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PeerAuthenticationBuilder(PeerAuthenticationFluent<?> fluent,PeerAuthentication instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PeerAuthentication build() {
    PeerAuthentication buildable = new PeerAuthentication(fluent.buildMtls(), fluent.getPortLevelMtls(), fluent.buildSelector());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}