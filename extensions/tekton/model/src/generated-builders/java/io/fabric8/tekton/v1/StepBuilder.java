package io.fabric8.tekton.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class StepBuilder extends StepFluent<StepBuilder> implements VisitableBuilder<Step,StepBuilder>{

  StepFluent<?> fluent;

  public StepBuilder() {
    this(new Step());
  }
  
  public StepBuilder(StepFluent<?> fluent) {
    this(fluent, new Step());
  }
  
  public StepBuilder(Step instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public StepBuilder(StepFluent<?> fluent,Step instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Step build() {
    Step buildable = new Step(fluent.getArgs(), fluent.getCommand(), fluent.buildComputeResources(), fluent.getDisplayName(), fluent.buildEnv(), fluent.getEnvFrom(), fluent.getImage(), fluent.getImagePullPolicy(), fluent.getName(), fluent.getOnError(), fluent.buildParams(), fluent.buildRef(), fluent.buildResults(), fluent.getScript(), fluent.getSecurityContext(), fluent.buildStderrConfig(), fluent.buildStdoutConfig(), fluent.getTimeout(), fluent.getVolumeDevices(), fluent.buildVolumeMounts(), fluent.buildWhen(), fluent.getWorkingDir(), fluent.buildWorkspaces());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}