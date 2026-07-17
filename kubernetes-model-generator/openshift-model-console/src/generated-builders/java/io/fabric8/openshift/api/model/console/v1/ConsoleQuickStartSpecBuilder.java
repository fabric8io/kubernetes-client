package io.fabric8.openshift.api.model.console.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ConsoleQuickStartSpecBuilder extends ConsoleQuickStartSpecFluent<ConsoleQuickStartSpecBuilder> implements VisitableBuilder<ConsoleQuickStartSpec,ConsoleQuickStartSpecBuilder>{

  ConsoleQuickStartSpecFluent<?> fluent;

  public ConsoleQuickStartSpecBuilder() {
    this(new ConsoleQuickStartSpec());
  }
  
  public ConsoleQuickStartSpecBuilder(ConsoleQuickStartSpecFluent<?> fluent) {
    this(fluent, new ConsoleQuickStartSpec());
  }
  
  public ConsoleQuickStartSpecBuilder(ConsoleQuickStartSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ConsoleQuickStartSpecBuilder(ConsoleQuickStartSpecFluent<?> fluent,ConsoleQuickStartSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ConsoleQuickStartSpec build() {
    ConsoleQuickStartSpec buildable = new ConsoleQuickStartSpec(fluent.getAccessReviewResources(), fluent.getConclusion(), fluent.getDescription(), fluent.getDisplayName(), fluent.getDurationMinutes(), fluent.getIcon(), fluent.getIntroduction(), fluent.getNextQuickStart(), fluent.getPrerequisites(), fluent.getTags(), fluent.buildTasks());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}