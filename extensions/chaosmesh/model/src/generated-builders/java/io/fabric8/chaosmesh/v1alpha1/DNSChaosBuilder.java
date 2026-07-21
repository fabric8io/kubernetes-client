package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DNSChaosBuilder extends DNSChaosFluent<DNSChaosBuilder> implements VisitableBuilder<DNSChaos,DNSChaosBuilder>{

  DNSChaosFluent<?> fluent;

  public DNSChaosBuilder() {
    this(new DNSChaos());
  }
  
  public DNSChaosBuilder(DNSChaosFluent<?> fluent) {
    this(fluent, new DNSChaos());
  }
  
  public DNSChaosBuilder(DNSChaos instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DNSChaosBuilder(DNSChaosFluent<?> fluent,DNSChaos instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DNSChaos build() {
    DNSChaos buildable = new DNSChaos(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}