package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DNSChaosListBuilder extends DNSChaosListFluent<DNSChaosListBuilder> implements VisitableBuilder<DNSChaosList,DNSChaosListBuilder>{

  DNSChaosListFluent<?> fluent;

  public DNSChaosListBuilder() {
    this(new DNSChaosList());
  }
  
  public DNSChaosListBuilder(DNSChaosListFluent<?> fluent) {
    this(fluent, new DNSChaosList());
  }
  
  public DNSChaosListBuilder(DNSChaosList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DNSChaosListBuilder(DNSChaosListFluent<?> fluent,DNSChaosList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DNSChaosList build() {
    DNSChaosList buildable = new DNSChaosList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}