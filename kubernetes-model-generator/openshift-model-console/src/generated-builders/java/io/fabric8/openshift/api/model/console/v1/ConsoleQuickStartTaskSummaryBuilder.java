package io.fabric8.openshift.api.model.console.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ConsoleQuickStartTaskSummaryBuilder extends ConsoleQuickStartTaskSummaryFluent<ConsoleQuickStartTaskSummaryBuilder> implements VisitableBuilder<ConsoleQuickStartTaskSummary,ConsoleQuickStartTaskSummaryBuilder>{

  ConsoleQuickStartTaskSummaryFluent<?> fluent;

  public ConsoleQuickStartTaskSummaryBuilder() {
    this(new ConsoleQuickStartTaskSummary());
  }
  
  public ConsoleQuickStartTaskSummaryBuilder(ConsoleQuickStartTaskSummaryFluent<?> fluent) {
    this(fluent, new ConsoleQuickStartTaskSummary());
  }
  
  public ConsoleQuickStartTaskSummaryBuilder(ConsoleQuickStartTaskSummary instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ConsoleQuickStartTaskSummaryBuilder(ConsoleQuickStartTaskSummaryFluent<?> fluent,ConsoleQuickStartTaskSummary instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ConsoleQuickStartTaskSummary build() {
    ConsoleQuickStartTaskSummary buildable = new ConsoleQuickStartTaskSummary(fluent.getFailed(), fluent.getSuccess());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}