package io.fabric8.knative.eventing.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BrokerListBuilder extends BrokerListFluent<BrokerListBuilder> implements VisitableBuilder<BrokerList,BrokerListBuilder>{

  BrokerListFluent<?> fluent;

  public BrokerListBuilder() {
    this(new BrokerList());
  }
  
  public BrokerListBuilder(BrokerListFluent<?> fluent) {
    this(fluent, new BrokerList());
  }
  
  public BrokerListBuilder(BrokerList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BrokerListBuilder(BrokerListFluent<?> fluent,BrokerList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public BrokerList build() {
    BrokerList buildable = new BrokerList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}