package io.fabric8.kubernetes.api.model.ovn.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EgressServiceListBuilder extends EgressServiceListFluent<EgressServiceListBuilder> implements VisitableBuilder<EgressServiceList,EgressServiceListBuilder>{

  EgressServiceListFluent<?> fluent;

  public EgressServiceListBuilder() {
    this(new EgressServiceList());
  }
  
  public EgressServiceListBuilder(EgressServiceListFluent<?> fluent) {
    this(fluent, new EgressServiceList());
  }
  
  public EgressServiceListBuilder(EgressServiceList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EgressServiceListBuilder(EgressServiceListFluent<?> fluent,EgressServiceList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EgressServiceList build() {
    EgressServiceList buildable = new EgressServiceList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}