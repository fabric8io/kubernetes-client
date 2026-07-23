package io.fabric8.kubernetes.api.model.ovn.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EgressFirewallBuilder extends EgressFirewallFluent<EgressFirewallBuilder> implements VisitableBuilder<EgressFirewall,EgressFirewallBuilder>{

  EgressFirewallFluent<?> fluent;

  public EgressFirewallBuilder() {
    this(new EgressFirewall());
  }
  
  public EgressFirewallBuilder(EgressFirewallFluent<?> fluent) {
    this(fluent, new EgressFirewall());
  }
  
  public EgressFirewallBuilder(EgressFirewall instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EgressFirewallBuilder(EgressFirewallFluent<?> fluent,EgressFirewall instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EgressFirewall build() {
    EgressFirewall buildable = new EgressFirewall(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}