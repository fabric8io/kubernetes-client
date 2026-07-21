package io.fabric8.tekton.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SkippedTaskBuilder extends SkippedTaskFluent<SkippedTaskBuilder> implements VisitableBuilder<SkippedTask,SkippedTaskBuilder>{

  SkippedTaskFluent<?> fluent;

  public SkippedTaskBuilder() {
    this(new SkippedTask());
  }
  
  public SkippedTaskBuilder(SkippedTaskFluent<?> fluent) {
    this(fluent, new SkippedTask());
  }
  
  public SkippedTaskBuilder(SkippedTask instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SkippedTaskBuilder(SkippedTaskFluent<?> fluent,SkippedTask instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SkippedTask build() {
    SkippedTask buildable = new SkippedTask(fluent.getName(), fluent.getReason(), fluent.buildWhenExpressions());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}