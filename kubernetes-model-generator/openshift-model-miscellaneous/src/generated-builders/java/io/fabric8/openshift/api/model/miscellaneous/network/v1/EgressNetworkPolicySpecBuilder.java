package io.fabric8.openshift.api.model.miscellaneous.network.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EgressNetworkPolicySpecBuilder extends EgressNetworkPolicySpecFluent<EgressNetworkPolicySpecBuilder> implements VisitableBuilder<EgressNetworkPolicySpec,EgressNetworkPolicySpecBuilder>{

  EgressNetworkPolicySpecFluent<?> fluent;

  public EgressNetworkPolicySpecBuilder() {
    this(new EgressNetworkPolicySpec());
  }
  
  public EgressNetworkPolicySpecBuilder(EgressNetworkPolicySpecFluent<?> fluent) {
    this(fluent, new EgressNetworkPolicySpec());
  }
  
  public EgressNetworkPolicySpecBuilder(EgressNetworkPolicySpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EgressNetworkPolicySpecBuilder(EgressNetworkPolicySpecFluent<?> fluent,EgressNetworkPolicySpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EgressNetworkPolicySpec build() {
    EgressNetworkPolicySpec buildable = new EgressNetworkPolicySpec(fluent.buildEgress());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}