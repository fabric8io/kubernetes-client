package io.fabric8.kubernetes.api.model.ovn.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EgressFirewallStatusBuilder extends EgressFirewallStatusFluent<EgressFirewallStatusBuilder> implements VisitableBuilder<EgressFirewallStatus,EgressFirewallStatusBuilder>{

  EgressFirewallStatusFluent<?> fluent;

  public EgressFirewallStatusBuilder() {
    this(new EgressFirewallStatus());
  }
  
  public EgressFirewallStatusBuilder(EgressFirewallStatusFluent<?> fluent) {
    this(fluent, new EgressFirewallStatus());
  }
  
  public EgressFirewallStatusBuilder(EgressFirewallStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EgressFirewallStatusBuilder(EgressFirewallStatusFluent<?> fluent,EgressFirewallStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EgressFirewallStatus build() {
    EgressFirewallStatus buildable = new EgressFirewallStatus(fluent.getMessages(), fluent.getStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}