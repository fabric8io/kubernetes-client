package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TrafficPolicyProxyProtocolBuilder extends TrafficPolicyProxyProtocolFluent<TrafficPolicyProxyProtocolBuilder> implements VisitableBuilder<TrafficPolicyProxyProtocol,TrafficPolicyProxyProtocolBuilder>{

  TrafficPolicyProxyProtocolFluent<?> fluent;

  public TrafficPolicyProxyProtocolBuilder() {
    this(new TrafficPolicyProxyProtocol());
  }
  
  public TrafficPolicyProxyProtocolBuilder(TrafficPolicyProxyProtocolFluent<?> fluent) {
    this(fluent, new TrafficPolicyProxyProtocol());
  }
  
  public TrafficPolicyProxyProtocolBuilder(TrafficPolicyProxyProtocol instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TrafficPolicyProxyProtocolBuilder(TrafficPolicyProxyProtocolFluent<?> fluent,TrafficPolicyProxyProtocol instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TrafficPolicyProxyProtocol build() {
    TrafficPolicyProxyProtocol buildable = new TrafficPolicyProxyProtocol(fluent.getVersion());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}