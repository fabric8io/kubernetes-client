package io.fabric8.openshift.api.model.console.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ConsoleQuickStartTaskReviewBuilder extends ConsoleQuickStartTaskReviewFluent<ConsoleQuickStartTaskReviewBuilder> implements VisitableBuilder<ConsoleQuickStartTaskReview,ConsoleQuickStartTaskReviewBuilder>{

  ConsoleQuickStartTaskReviewFluent<?> fluent;

  public ConsoleQuickStartTaskReviewBuilder() {
    this(new ConsoleQuickStartTaskReview());
  }
  
  public ConsoleQuickStartTaskReviewBuilder(ConsoleQuickStartTaskReviewFluent<?> fluent) {
    this(fluent, new ConsoleQuickStartTaskReview());
  }
  
  public ConsoleQuickStartTaskReviewBuilder(ConsoleQuickStartTaskReview instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ConsoleQuickStartTaskReviewBuilder(ConsoleQuickStartTaskReviewFluent<?> fluent,ConsoleQuickStartTaskReview instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ConsoleQuickStartTaskReview build() {
    ConsoleQuickStartTaskReview buildable = new ConsoleQuickStartTaskReview(fluent.getFailedTaskHelp(), fluent.getInstructions());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}