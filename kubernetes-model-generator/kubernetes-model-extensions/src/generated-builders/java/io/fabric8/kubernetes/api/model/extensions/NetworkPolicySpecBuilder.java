package io.fabric8.kubernetes.api.model.extensions;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NetworkPolicySpecBuilder extends NetworkPolicySpecFluent<NetworkPolicySpecBuilder> implements VisitableBuilder<NetworkPolicySpec,NetworkPolicySpecBuilder>{

  NetworkPolicySpecFluent<?> fluent;

  public NetworkPolicySpecBuilder() {
    this(new NetworkPolicySpec());
  }
  
  public NetworkPolicySpecBuilder(NetworkPolicySpecFluent<?> fluent) {
    this(fluent, new NetworkPolicySpec());
  }
  
  public NetworkPolicySpecBuilder(NetworkPolicySpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NetworkPolicySpecBuilder(NetworkPolicySpecFluent<?> fluent,NetworkPolicySpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NetworkPolicySpec build() {
    NetworkPolicySpec buildable = new NetworkPolicySpec(fluent.buildEgress(), fluent.buildIngress(), fluent.buildPodSelector(), fluent.getPolicyTypes());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}