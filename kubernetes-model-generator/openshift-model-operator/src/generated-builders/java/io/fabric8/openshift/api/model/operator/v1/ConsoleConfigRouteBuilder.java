package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ConsoleConfigRouteBuilder extends ConsoleConfigRouteFluent<ConsoleConfigRouteBuilder> implements VisitableBuilder<ConsoleConfigRoute,ConsoleConfigRouteBuilder>{

  ConsoleConfigRouteFluent<?> fluent;

  public ConsoleConfigRouteBuilder() {
    this(new ConsoleConfigRoute());
  }
  
  public ConsoleConfigRouteBuilder(ConsoleConfigRouteFluent<?> fluent) {
    this(fluent, new ConsoleConfigRoute());
  }
  
  public ConsoleConfigRouteBuilder(ConsoleConfigRoute instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ConsoleConfigRouteBuilder(ConsoleConfigRouteFluent<?> fluent,ConsoleConfigRoute instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ConsoleConfigRoute build() {
    ConsoleConfigRoute buildable = new ConsoleConfigRoute(fluent.getHostname(), fluent.getSecret());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}