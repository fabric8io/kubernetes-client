package io.fabric8.tekton.v1beta1;

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
    Step buildable = new Step(fluent.getArgs(), fluent.getCommand(), fluent.getDisplayName(), fluent.buildEnv(), fluent.getEnvFrom(), fluent.getImage(), fluent.getImagePullPolicy(), fluent.getLifecycle(), fluent.getLivenessProbe(), fluent.getName(), fluent.getOnError(), fluent.buildParams(), fluent.buildPorts(), fluent.getReadinessProbe(), fluent.buildRef(), fluent.buildResources(), fluent.buildResults(), fluent.getScript(), fluent.getSecurityContext(), fluent.getStartupProbe(), fluent.buildStderrConfig(), fluent.getStdin(), fluent.getStdinOnce(), fluent.buildStdoutConfig(), fluent.getTerminationMessagePath(), fluent.getTerminationMessagePolicy(), fluent.getTimeout(), fluent.getTty(), fluent.getVolumeDevices(), fluent.buildVolumeMounts(), fluent.buildWhen(), fluent.getWorkingDir(), fluent.buildWorkspaces());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}