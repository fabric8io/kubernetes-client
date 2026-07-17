package io.fabric8.openshift.api.model.miscellaneous.network.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EgressNetworkPolicyListBuilder extends EgressNetworkPolicyListFluent<EgressNetworkPolicyListBuilder> implements VisitableBuilder<EgressNetworkPolicyList,EgressNetworkPolicyListBuilder>{

  EgressNetworkPolicyListFluent<?> fluent;

  public EgressNetworkPolicyListBuilder() {
    this(new EgressNetworkPolicyList());
  }
  
  public EgressNetworkPolicyListBuilder(EgressNetworkPolicyListFluent<?> fluent) {
    this(fluent, new EgressNetworkPolicyList());
  }
  
  public EgressNetworkPolicyListBuilder(EgressNetworkPolicyList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EgressNetworkPolicyListBuilder(EgressNetworkPolicyListFluent<?> fluent,EgressNetworkPolicyList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EgressNetworkPolicyList build() {
    EgressNetworkPolicyList buildable = new EgressNetworkPolicyList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}