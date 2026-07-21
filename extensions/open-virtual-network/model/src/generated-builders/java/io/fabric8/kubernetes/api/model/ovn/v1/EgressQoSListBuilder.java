package io.fabric8.kubernetes.api.model.ovn.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EgressQoSListBuilder extends EgressQoSListFluent<EgressQoSListBuilder> implements VisitableBuilder<EgressQoSList,EgressQoSListBuilder>{

  EgressQoSListFluent<?> fluent;

  public EgressQoSListBuilder() {
    this(new EgressQoSList());
  }
  
  public EgressQoSListBuilder(EgressQoSListFluent<?> fluent) {
    this(fluent, new EgressQoSList());
  }
  
  public EgressQoSListBuilder(EgressQoSList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EgressQoSListBuilder(EgressQoSListFluent<?> fluent,EgressQoSList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EgressQoSList build() {
    EgressQoSList buildable = new EgressQoSList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}