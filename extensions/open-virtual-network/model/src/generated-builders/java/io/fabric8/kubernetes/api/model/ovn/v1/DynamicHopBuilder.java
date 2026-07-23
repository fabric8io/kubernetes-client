package io.fabric8.kubernetes.api.model.ovn.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DynamicHopBuilder extends DynamicHopFluent<DynamicHopBuilder> implements VisitableBuilder<DynamicHop,DynamicHopBuilder>{

  DynamicHopFluent<?> fluent;

  public DynamicHopBuilder() {
    this(new DynamicHop());
  }
  
  public DynamicHopBuilder(DynamicHopFluent<?> fluent) {
    this(fluent, new DynamicHop());
  }
  
  public DynamicHopBuilder(DynamicHop instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DynamicHopBuilder(DynamicHopFluent<?> fluent,DynamicHop instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DynamicHop build() {
    DynamicHop buildable = new DynamicHop(fluent.getBfdEnabled(), fluent.buildNamespaceSelector(), fluent.getNetworkAttachmentName(), fluent.buildPodSelector());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}