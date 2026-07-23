package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ListenerBuilder extends ListenerFluent<ListenerBuilder> implements VisitableBuilder<Listener,ListenerBuilder>{

  ListenerFluent<?> fluent;

  public ListenerBuilder() {
    this(new Listener());
  }
  
  public ListenerBuilder(ListenerFluent<?> fluent) {
    this(fluent, new Listener());
  }
  
  public ListenerBuilder(Listener instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ListenerBuilder(ListenerFluent<?> fluent,Listener instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Listener build() {
    Listener buildable = new Listener(fluent.buildAllowedRoutes(), fluent.getHostname(), fluent.getName(), fluent.getPort(), fluent.getProtocol(), fluent.buildTls());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}