package io.fabric8.knative.eventing.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BrokerSpecBuilder extends BrokerSpecFluent<BrokerSpecBuilder> implements VisitableBuilder<BrokerSpec,BrokerSpecBuilder>{

  BrokerSpecFluent<?> fluent;

  public BrokerSpecBuilder() {
    this(new BrokerSpec());
  }
  
  public BrokerSpecBuilder(BrokerSpecFluent<?> fluent) {
    this(fluent, new BrokerSpec());
  }
  
  public BrokerSpecBuilder(BrokerSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BrokerSpecBuilder(BrokerSpecFluent<?> fluent,BrokerSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public BrokerSpec build() {
    BrokerSpec buildable = new BrokerSpec(fluent.buildConfig(), fluent.buildDelivery());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}