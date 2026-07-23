package io.fabric8.kubernetes.api.model.networking.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NetworkPolicyEgressRuleBuilder extends NetworkPolicyEgressRuleFluent<NetworkPolicyEgressRuleBuilder> implements VisitableBuilder<NetworkPolicyEgressRule,NetworkPolicyEgressRuleBuilder>{

  NetworkPolicyEgressRuleFluent<?> fluent;

  public NetworkPolicyEgressRuleBuilder() {
    this(new NetworkPolicyEgressRule());
  }
  
  public NetworkPolicyEgressRuleBuilder(NetworkPolicyEgressRuleFluent<?> fluent) {
    this(fluent, new NetworkPolicyEgressRule());
  }
  
  public NetworkPolicyEgressRuleBuilder(NetworkPolicyEgressRule instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NetworkPolicyEgressRuleBuilder(NetworkPolicyEgressRuleFluent<?> fluent,NetworkPolicyEgressRule instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NetworkPolicyEgressRule build() {
    NetworkPolicyEgressRule buildable = new NetworkPolicyEgressRule(fluent.buildPorts(), fluent.buildTo());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}