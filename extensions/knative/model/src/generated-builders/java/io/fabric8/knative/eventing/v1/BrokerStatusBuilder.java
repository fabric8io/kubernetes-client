package io.fabric8.knative.eventing.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BrokerStatusBuilder extends BrokerStatusFluent<BrokerStatusBuilder> implements VisitableBuilder<BrokerStatus,BrokerStatusBuilder>{

  BrokerStatusFluent<?> fluent;

  public BrokerStatusBuilder() {
    this(new BrokerStatus());
  }
  
  public BrokerStatusBuilder(BrokerStatusFluent<?> fluent) {
    this(fluent, new BrokerStatus());
  }
  
  public BrokerStatusBuilder(BrokerStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BrokerStatusBuilder(BrokerStatusFluent<?> fluent,BrokerStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public BrokerStatus build() {
    BrokerStatus buildable = new BrokerStatus(fluent.buildAddress(), fluent.buildAddresses(), fluent.getAnnotations(), fluent.buildConditions(), fluent.getDeadLetterSinkAudience(), fluent.getDeadLetterSinkCACerts(), fluent.getDeadLetterSinkUri(), fluent.getObservedGeneration(), fluent.buildPolicies());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}