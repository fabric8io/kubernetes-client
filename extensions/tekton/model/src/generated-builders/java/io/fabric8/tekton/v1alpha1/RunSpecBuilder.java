package io.fabric8.tekton.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RunSpecBuilder extends RunSpecFluent<RunSpecBuilder> implements VisitableBuilder<RunSpec,RunSpecBuilder>{

  RunSpecFluent<?> fluent;

  public RunSpecBuilder() {
    this(new RunSpec());
  }
  
  public RunSpecBuilder(RunSpecFluent<?> fluent) {
    this(fluent, new RunSpec());
  }
  
  public RunSpecBuilder(RunSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RunSpecBuilder(RunSpecFluent<?> fluent,RunSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RunSpec build() {
    RunSpec buildable = new RunSpec(fluent.buildParams(), fluent.buildPodTemplate(), fluent.buildRef(), fluent.getRetries(), fluent.getServiceAccountName(), fluent.buildSpec(), fluent.getStatus(), fluent.getStatusMessage(), fluent.getTimeout(), fluent.buildWorkspaces());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}