package io.fabric8.knative.duck.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SubscribableStatusBuilder extends SubscribableStatusFluent<SubscribableStatusBuilder> implements VisitableBuilder<SubscribableStatus,SubscribableStatusBuilder>{

  SubscribableStatusFluent<?> fluent;

  public SubscribableStatusBuilder() {
    this(new SubscribableStatus());
  }
  
  public SubscribableStatusBuilder(SubscribableStatusFluent<?> fluent) {
    this(fluent, new SubscribableStatus());
  }
  
  public SubscribableStatusBuilder(SubscribableStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SubscribableStatusBuilder(SubscribableStatusFluent<?> fluent,SubscribableStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SubscribableStatus build() {
    SubscribableStatus buildable = new SubscribableStatus(fluent.buildSubscribers());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}