package io.fabric8.tekton.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SidecarBuilder extends SidecarFluent<SidecarBuilder> implements VisitableBuilder<Sidecar,SidecarBuilder>{

  SidecarFluent<?> fluent;

  public SidecarBuilder() {
    this(new Sidecar());
  }
  
  public SidecarBuilder(SidecarFluent<?> fluent) {
    this(fluent, new Sidecar());
  }
  
  public SidecarBuilder(Sidecar instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SidecarBuilder(SidecarFluent<?> fluent,Sidecar instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Sidecar build() {
    Sidecar buildable = new Sidecar(fluent.getArgs(), fluent.getCommand(), fluent.buildComputeResources(), fluent.buildEnv(), fluent.getEnvFrom(), fluent.getImage(), fluent.getImagePullPolicy(), fluent.getLifecycle(), fluent.getLivenessProbe(), fluent.getName(), fluent.buildPorts(), fluent.getReadinessProbe(), fluent.getRestartPolicy(), fluent.getScript(), fluent.getSecurityContext(), fluent.getStartupProbe(), fluent.getStdin(), fluent.getStdinOnce(), fluent.getTerminationMessagePath(), fluent.getTerminationMessagePolicy(), fluent.getTty(), fluent.getVolumeDevices(), fluent.buildVolumeMounts(), fluent.getWorkingDir(), fluent.buildWorkspaces());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}