package io.fabric8.knative.eventing.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BrokerBuilder extends BrokerFluent<BrokerBuilder> implements VisitableBuilder<Broker,BrokerBuilder>{

  BrokerFluent<?> fluent;

  public BrokerBuilder() {
    this(new Broker());
  }
  
  public BrokerBuilder(BrokerFluent<?> fluent) {
    this(fluent, new Broker());
  }
  
  public BrokerBuilder(Broker instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BrokerBuilder(BrokerFluent<?> fluent,Broker instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Broker build() {
    Broker buildable = new Broker(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}