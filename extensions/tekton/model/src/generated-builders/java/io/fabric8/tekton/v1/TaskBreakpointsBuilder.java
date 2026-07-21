package io.fabric8.tekton.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TaskBreakpointsBuilder extends TaskBreakpointsFluent<TaskBreakpointsBuilder> implements VisitableBuilder<TaskBreakpoints,TaskBreakpointsBuilder>{

  TaskBreakpointsFluent<?> fluent;

  public TaskBreakpointsBuilder() {
    this(new TaskBreakpoints());
  }
  
  public TaskBreakpointsBuilder(TaskBreakpointsFluent<?> fluent) {
    this(fluent, new TaskBreakpoints());
  }
  
  public TaskBreakpointsBuilder(TaskBreakpoints instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TaskBreakpointsBuilder(TaskBreakpointsFluent<?> fluent,TaskBreakpoints instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TaskBreakpoints build() {
    TaskBreakpoints buildable = new TaskBreakpoints(fluent.getBeforeSteps(), fluent.getOnFailure());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}