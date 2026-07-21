package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TrafficPolicyPortTrafficPolicyBuilder extends TrafficPolicyPortTrafficPolicyFluent<TrafficPolicyPortTrafficPolicyBuilder> implements VisitableBuilder<TrafficPolicyPortTrafficPolicy,TrafficPolicyPortTrafficPolicyBuilder>{

  TrafficPolicyPortTrafficPolicyFluent<?> fluent;

  public TrafficPolicyPortTrafficPolicyBuilder() {
    this(new TrafficPolicyPortTrafficPolicy());
  }
  
  public TrafficPolicyPortTrafficPolicyBuilder(TrafficPolicyPortTrafficPolicyFluent<?> fluent) {
    this(fluent, new TrafficPolicyPortTrafficPolicy());
  }
  
  public TrafficPolicyPortTrafficPolicyBuilder(TrafficPolicyPortTrafficPolicy instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TrafficPolicyPortTrafficPolicyBuilder(TrafficPolicyPortTrafficPolicyFluent<?> fluent,TrafficPolicyPortTrafficPolicy instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TrafficPolicyPortTrafficPolicy build() {
    TrafficPolicyPortTrafficPolicy buildable = new TrafficPolicyPortTrafficPolicy(fluent.buildConnectionPool(), fluent.buildLoadBalancer(), fluent.buildOutlierDetection(), fluent.buildPort(), fluent.buildTls());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}