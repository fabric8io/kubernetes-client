package io.fabric8.tekton.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RunBuilder extends RunFluent<RunBuilder> implements VisitableBuilder<Run,RunBuilder>{

  RunFluent<?> fluent;

  public RunBuilder() {
    this(new Run());
  }
  
  public RunBuilder(RunFluent<?> fluent) {
    this(fluent, new Run());
  }
  
  public RunBuilder(Run instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RunBuilder(RunFluent<?> fluent,Run instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Run build() {
    Run buildable = new Run(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}