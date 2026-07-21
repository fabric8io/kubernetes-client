package io.fabric8.knative.duck.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SubscriberStatusBuilder extends SubscriberStatusFluent<SubscriberStatusBuilder> implements VisitableBuilder<SubscriberStatus,SubscriberStatusBuilder>{

  SubscriberStatusFluent<?> fluent;

  public SubscriberStatusBuilder() {
    this(new SubscriberStatus());
  }
  
  public SubscriberStatusBuilder(SubscriberStatusFluent<?> fluent) {
    this(fluent, new SubscriberStatus());
  }
  
  public SubscriberStatusBuilder(SubscriberStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SubscriberStatusBuilder(SubscriberStatusFluent<?> fluent,SubscriberStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SubscriberStatus build() {
    SubscriberStatus buildable = new SubscriberStatus(fluent.buildAuth(), fluent.getMessage(), fluent.getObservedGeneration(), fluent.getReady(), fluent.getUid());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}