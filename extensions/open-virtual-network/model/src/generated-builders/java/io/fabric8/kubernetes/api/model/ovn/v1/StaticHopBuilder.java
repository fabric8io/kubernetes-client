package io.fabric8.kubernetes.api.model.ovn.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class StaticHopBuilder extends StaticHopFluent<StaticHopBuilder> implements VisitableBuilder<StaticHop,StaticHopBuilder>{

  StaticHopFluent<?> fluent;

  public StaticHopBuilder() {
    this(new StaticHop());
  }
  
  public StaticHopBuilder(StaticHopFluent<?> fluent) {
    this(fluent, new StaticHop());
  }
  
  public StaticHopBuilder(StaticHop instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public StaticHopBuilder(StaticHopFluent<?> fluent,StaticHop instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public StaticHop build() {
    StaticHop buildable = new StaticHop(fluent.getBfdEnabled(), fluent.getIp());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}