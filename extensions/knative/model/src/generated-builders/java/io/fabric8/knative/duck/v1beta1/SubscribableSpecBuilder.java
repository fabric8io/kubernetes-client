package io.fabric8.knative.duck.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SubscribableSpecBuilder extends SubscribableSpecFluent<SubscribableSpecBuilder> implements VisitableBuilder<SubscribableSpec,SubscribableSpecBuilder>{

  SubscribableSpecFluent<?> fluent;

  public SubscribableSpecBuilder() {
    this(new SubscribableSpec());
  }
  
  public SubscribableSpecBuilder(SubscribableSpecFluent<?> fluent) {
    this(fluent, new SubscribableSpec());
  }
  
  public SubscribableSpecBuilder(SubscribableSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SubscribableSpecBuilder(SubscribableSpecFluent<?> fluent,SubscribableSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SubscribableSpec build() {
    SubscribableSpec buildable = new SubscribableSpec(fluent.buildSubscribers());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}