package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TrafficPolicyBuilder extends TrafficPolicyFluent<TrafficPolicyBuilder> implements VisitableBuilder<TrafficPolicy,TrafficPolicyBuilder>{

  TrafficPolicyFluent<?> fluent;

  public TrafficPolicyBuilder() {
    this(new TrafficPolicy());
  }
  
  public TrafficPolicyBuilder(TrafficPolicyFluent<?> fluent) {
    this(fluent, new TrafficPolicy());
  }
  
  public TrafficPolicyBuilder(TrafficPolicy instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TrafficPolicyBuilder(TrafficPolicyFluent<?> fluent,TrafficPolicy instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TrafficPolicy build() {
    TrafficPolicy buildable = new TrafficPolicy(fluent.buildConnectionPool(), fluent.buildLoadBalancer(), fluent.buildOutlierDetection(), fluent.buildPortLevelSettings(), fluent.buildProxyProtocol(), fluent.buildRetryBudget(), fluent.buildTls(), fluent.buildTunnel());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}