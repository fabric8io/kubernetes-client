package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EphemeralContainerBuilder extends EphemeralContainerFluent<EphemeralContainerBuilder> implements VisitableBuilder<EphemeralContainer,EphemeralContainerBuilder>{

  EphemeralContainerFluent<?> fluent;

  public EphemeralContainerBuilder() {
    this(new EphemeralContainer());
  }
  
  public EphemeralContainerBuilder(EphemeralContainerFluent<?> fluent) {
    this(fluent, new EphemeralContainer());
  }
  
  public EphemeralContainerBuilder(EphemeralContainer instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EphemeralContainerBuilder(EphemeralContainerFluent<?> fluent,EphemeralContainer instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EphemeralContainer build() {
    EphemeralContainer buildable = new EphemeralContainer(fluent.getArgs(), fluent.getCommand(), fluent.buildEnv(), fluent.buildEnvFrom(), fluent.getImage(), fluent.getImagePullPolicy(), fluent.buildLifecycle(), fluent.buildLivenessProbe(), fluent.getName(), fluent.buildPorts(), fluent.buildReadinessProbe(), fluent.buildResizePolicy(), fluent.buildResources(), fluent.getRestartPolicy(), fluent.buildRestartPolicyRules(), fluent.buildSecurityContext(), fluent.buildStartupProbe(), fluent.getStdin(), fluent.getStdinOnce(), fluent.getTargetContainerName(), fluent.getTerminationMessagePath(), fluent.getTerminationMessagePolicy(), fluent.getTty(), fluent.buildVolumeDevices(), fluent.buildVolumeMounts(), fluent.getWorkingDir());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}