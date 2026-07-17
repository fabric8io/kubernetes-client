package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ConsoleBuilder extends ConsoleFluent<ConsoleBuilder> implements VisitableBuilder<Console,ConsoleBuilder>{

  ConsoleFluent<?> fluent;

  public ConsoleBuilder() {
    this(new Console());
  }
  
  public ConsoleBuilder(ConsoleFluent<?> fluent) {
    this(fluent, new Console());
  }
  
  public ConsoleBuilder(Console instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ConsoleBuilder(ConsoleFluent<?> fluent,Console instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Console build() {
    Console buildable = new Console(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}