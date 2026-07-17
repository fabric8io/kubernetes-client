package io.fabric8.openshift.api.model.console.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ConsoleQuickStartBuilder extends ConsoleQuickStartFluent<ConsoleQuickStartBuilder> implements VisitableBuilder<ConsoleQuickStart,ConsoleQuickStartBuilder>{

  ConsoleQuickStartFluent<?> fluent;

  public ConsoleQuickStartBuilder() {
    this(new ConsoleQuickStart());
  }
  
  public ConsoleQuickStartBuilder(ConsoleQuickStartFluent<?> fluent) {
    this(fluent, new ConsoleQuickStart());
  }
  
  public ConsoleQuickStartBuilder(ConsoleQuickStart instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ConsoleQuickStartBuilder(ConsoleQuickStartFluent<?> fluent,ConsoleQuickStart instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ConsoleQuickStart build() {
    ConsoleQuickStart buildable = new ConsoleQuickStart(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}