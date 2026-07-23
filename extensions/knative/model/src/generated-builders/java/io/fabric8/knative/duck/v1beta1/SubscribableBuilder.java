package io.fabric8.knative.duck.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SubscribableBuilder extends SubscribableFluent<SubscribableBuilder> implements VisitableBuilder<Subscribable,SubscribableBuilder>{

  SubscribableFluent<?> fluent;

  public SubscribableBuilder() {
    this(new Subscribable());
  }
  
  public SubscribableBuilder(SubscribableFluent<?> fluent) {
    this(fluent, new Subscribable());
  }
  
  public SubscribableBuilder(Subscribable instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SubscribableBuilder(SubscribableFluent<?> fluent,Subscribable instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Subscribable build() {
    Subscribable buildable = new Subscribable(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}