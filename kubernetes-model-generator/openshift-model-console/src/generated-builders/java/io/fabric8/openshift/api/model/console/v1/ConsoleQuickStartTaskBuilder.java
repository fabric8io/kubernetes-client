package io.fabric8.openshift.api.model.console.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ConsoleQuickStartTaskBuilder extends ConsoleQuickStartTaskFluent<ConsoleQuickStartTaskBuilder> implements VisitableBuilder<ConsoleQuickStartTask,ConsoleQuickStartTaskBuilder>{

  ConsoleQuickStartTaskFluent<?> fluent;

  public ConsoleQuickStartTaskBuilder() {
    this(new ConsoleQuickStartTask());
  }
  
  public ConsoleQuickStartTaskBuilder(ConsoleQuickStartTaskFluent<?> fluent) {
    this(fluent, new ConsoleQuickStartTask());
  }
  
  public ConsoleQuickStartTaskBuilder(ConsoleQuickStartTask instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ConsoleQuickStartTaskBuilder(ConsoleQuickStartTaskFluent<?> fluent,ConsoleQuickStartTask instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ConsoleQuickStartTask build() {
    ConsoleQuickStartTask buildable = new ConsoleQuickStartTask(fluent.getDescription(), fluent.buildReview(), fluent.buildSummary(), fluent.getTitle());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}