package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OutboundTrafficPolicyBuilder extends OutboundTrafficPolicyFluent<OutboundTrafficPolicyBuilder> implements VisitableBuilder<OutboundTrafficPolicy,OutboundTrafficPolicyBuilder>{

  OutboundTrafficPolicyFluent<?> fluent;

  public OutboundTrafficPolicyBuilder() {
    this(new OutboundTrafficPolicy());
  }
  
  public OutboundTrafficPolicyBuilder(OutboundTrafficPolicyFluent<?> fluent) {
    this(fluent, new OutboundTrafficPolicy());
  }
  
  public OutboundTrafficPolicyBuilder(OutboundTrafficPolicy instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OutboundTrafficPolicyBuilder(OutboundTrafficPolicyFluent<?> fluent,OutboundTrafficPolicy instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OutboundTrafficPolicy build() {
    OutboundTrafficPolicy buildable = new OutboundTrafficPolicy(fluent.buildEgressProxy(), fluent.getMode());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}