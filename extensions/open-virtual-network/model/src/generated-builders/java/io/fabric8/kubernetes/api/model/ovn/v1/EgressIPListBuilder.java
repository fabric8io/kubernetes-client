package io.fabric8.kubernetes.api.model.ovn.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EgressIPListBuilder extends EgressIPListFluent<EgressIPListBuilder> implements VisitableBuilder<EgressIPList,EgressIPListBuilder>{

  EgressIPListFluent<?> fluent;

  public EgressIPListBuilder() {
    this(new EgressIPList());
  }
  
  public EgressIPListBuilder(EgressIPListFluent<?> fluent) {
    this(fluent, new EgressIPList());
  }
  
  public EgressIPListBuilder(EgressIPList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EgressIPListBuilder(EgressIPListFluent<?> fluent,EgressIPList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EgressIPList build() {
    EgressIPList buildable = new EgressIPList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}