package io.fabric8.istio.api.security.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PeerAuthenticationListBuilder extends PeerAuthenticationListFluent<PeerAuthenticationListBuilder> implements VisitableBuilder<PeerAuthenticationList,PeerAuthenticationListBuilder>{

  PeerAuthenticationListFluent<?> fluent;

  public PeerAuthenticationListBuilder() {
    this(new PeerAuthenticationList());
  }
  
  public PeerAuthenticationListBuilder(PeerAuthenticationListFluent<?> fluent) {
    this(fluent, new PeerAuthenticationList());
  }
  
  public PeerAuthenticationListBuilder(PeerAuthenticationList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PeerAuthenticationListBuilder(PeerAuthenticationListFluent<?> fluent,PeerAuthenticationList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PeerAuthenticationList build() {
    PeerAuthenticationList buildable = new PeerAuthenticationList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}