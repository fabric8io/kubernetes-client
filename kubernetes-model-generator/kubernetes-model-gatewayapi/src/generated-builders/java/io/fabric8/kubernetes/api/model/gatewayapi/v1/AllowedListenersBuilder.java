package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AllowedListenersBuilder extends AllowedListenersFluent<AllowedListenersBuilder> implements VisitableBuilder<AllowedListeners,AllowedListenersBuilder>{

  AllowedListenersFluent<?> fluent;

  public AllowedListenersBuilder() {
    this(new AllowedListeners());
  }
  
  public AllowedListenersBuilder(AllowedListenersFluent<?> fluent) {
    this(fluent, new AllowedListeners());
  }
  
  public AllowedListenersBuilder(AllowedListeners instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AllowedListenersBuilder(AllowedListenersFluent<?> fluent,AllowedListeners instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AllowedListeners build() {
    AllowedListeners buildable = new AllowedListeners(fluent.buildNamespaces());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}