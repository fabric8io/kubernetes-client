package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ConsoleStatusBuilder extends ConsoleStatusFluent<ConsoleStatusBuilder> implements VisitableBuilder<ConsoleStatus,ConsoleStatusBuilder>{

  ConsoleStatusFluent<?> fluent;

  public ConsoleStatusBuilder() {
    this(new ConsoleStatus());
  }
  
  public ConsoleStatusBuilder(ConsoleStatusFluent<?> fluent) {
    this(fluent, new ConsoleStatus());
  }
  
  public ConsoleStatusBuilder(ConsoleStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ConsoleStatusBuilder(ConsoleStatusFluent<?> fluent,ConsoleStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ConsoleStatus build() {
    ConsoleStatus buildable = new ConsoleStatus(fluent.getConsoleURL());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}