package io.fabric8.kubernetes.api.model.extensions;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NetworkPolicyIngressRuleBuilder extends NetworkPolicyIngressRuleFluent<NetworkPolicyIngressRuleBuilder> implements VisitableBuilder<NetworkPolicyIngressRule,NetworkPolicyIngressRuleBuilder>{

  NetworkPolicyIngressRuleFluent<?> fluent;

  public NetworkPolicyIngressRuleBuilder() {
    this(new NetworkPolicyIngressRule());
  }
  
  public NetworkPolicyIngressRuleBuilder(NetworkPolicyIngressRuleFluent<?> fluent) {
    this(fluent, new NetworkPolicyIngressRule());
  }
  
  public NetworkPolicyIngressRuleBuilder(NetworkPolicyIngressRule instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NetworkPolicyIngressRuleBuilder(NetworkPolicyIngressRuleFluent<?> fluent,NetworkPolicyIngressRule instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NetworkPolicyIngressRule build() {
    NetworkPolicyIngressRule buildable = new NetworkPolicyIngressRule(fluent.buildFrom(), fluent.buildPorts());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}