package io.fabric8.tekton.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RunListBuilder extends RunListFluent<RunListBuilder> implements VisitableBuilder<RunList,RunListBuilder>{

  RunListFluent<?> fluent;

  public RunListBuilder() {
    this(new RunList());
  }
  
  public RunListBuilder(RunListFluent<?> fluent) {
    this(fluent, new RunList());
  }
  
  public RunListBuilder(RunList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RunListBuilder(RunListFluent<?> fluent,RunList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RunList build() {
    RunList buildable = new RunList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}