package io.fabric8.openshift.api.model.miscellaneous.network.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EgressNetworkPolicyBuilder extends EgressNetworkPolicyFluent<EgressNetworkPolicyBuilder> implements VisitableBuilder<EgressNetworkPolicy,EgressNetworkPolicyBuilder>{

  EgressNetworkPolicyFluent<?> fluent;

  public EgressNetworkPolicyBuilder() {
    this(new EgressNetworkPolicy());
  }
  
  public EgressNetworkPolicyBuilder(EgressNetworkPolicyFluent<?> fluent) {
    this(fluent, new EgressNetworkPolicy());
  }
  
  public EgressNetworkPolicyBuilder(EgressNetworkPolicy instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EgressNetworkPolicyBuilder(EgressNetworkPolicyFluent<?> fluent,EgressNetworkPolicy instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EgressNetworkPolicy build() {
    EgressNetworkPolicy buildable = new EgressNetworkPolicy(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}