package io.fabric8.kubernetes.api.model.ovn.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EgressFirewallListBuilder extends EgressFirewallListFluent<EgressFirewallListBuilder> implements VisitableBuilder<EgressFirewallList,EgressFirewallListBuilder>{

  EgressFirewallListFluent<?> fluent;

  public EgressFirewallListBuilder() {
    this(new EgressFirewallList());
  }
  
  public EgressFirewallListBuilder(EgressFirewallListFluent<?> fluent) {
    this(fluent, new EgressFirewallList());
  }
  
  public EgressFirewallListBuilder(EgressFirewallList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EgressFirewallListBuilder(EgressFirewallListFluent<?> fluent,EgressFirewallList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EgressFirewallList build() {
    EgressFirewallList buildable = new EgressFirewallList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}