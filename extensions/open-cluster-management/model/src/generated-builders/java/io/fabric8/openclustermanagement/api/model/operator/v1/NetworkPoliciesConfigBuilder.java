package io.fabric8.openclustermanagement.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NetworkPoliciesConfigBuilder extends NetworkPoliciesConfigFluent<NetworkPoliciesConfigBuilder> implements VisitableBuilder<NetworkPoliciesConfig,NetworkPoliciesConfigBuilder>{

  NetworkPoliciesConfigFluent<?> fluent;

  public NetworkPoliciesConfigBuilder() {
    this(new NetworkPoliciesConfig());
  }
  
  public NetworkPoliciesConfigBuilder(NetworkPoliciesConfigFluent<?> fluent) {
    this(fluent, new NetworkPoliciesConfig());
  }
  
  public NetworkPoliciesConfigBuilder(NetworkPoliciesConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NetworkPoliciesConfigBuilder(NetworkPoliciesConfigFluent<?> fluent,NetworkPoliciesConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NetworkPoliciesConfig build() {
    NetworkPoliciesConfig buildable = new NetworkPoliciesConfig(fluent.getEnabled());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}