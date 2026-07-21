package io.fabric8.kubernetes.api.model.ovn.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EgressIPStatusItemBuilder extends EgressIPStatusItemFluent<EgressIPStatusItemBuilder> implements VisitableBuilder<EgressIPStatusItem,EgressIPStatusItemBuilder>{

  EgressIPStatusItemFluent<?> fluent;

  public EgressIPStatusItemBuilder() {
    this(new EgressIPStatusItem());
  }
  
  public EgressIPStatusItemBuilder(EgressIPStatusItemFluent<?> fluent) {
    this(fluent, new EgressIPStatusItem());
  }
  
  public EgressIPStatusItemBuilder(EgressIPStatusItem instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EgressIPStatusItemBuilder(EgressIPStatusItemFluent<?> fluent,EgressIPStatusItem instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EgressIPStatusItem build() {
    EgressIPStatusItem buildable = new EgressIPStatusItem(fluent.getEgressIP(), fluent.getNode());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}