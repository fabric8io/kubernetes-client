package io.fabric8.kubernetes.api.model.networking.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NetworkPolicyListBuilder extends NetworkPolicyListFluent<NetworkPolicyListBuilder> implements VisitableBuilder<NetworkPolicyList,NetworkPolicyListBuilder>{

  NetworkPolicyListFluent<?> fluent;

  public NetworkPolicyListBuilder() {
    this(new NetworkPolicyList());
  }
  
  public NetworkPolicyListBuilder(NetworkPolicyListFluent<?> fluent) {
    this(fluent, new NetworkPolicyList());
  }
  
  public NetworkPolicyListBuilder(NetworkPolicyList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NetworkPolicyListBuilder(NetworkPolicyListFluent<?> fluent,NetworkPolicyList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NetworkPolicyList build() {
    NetworkPolicyList buildable = new NetworkPolicyList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}