package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ContainerBuilder extends ContainerFluent<ContainerBuilder> implements VisitableBuilder<Container,ContainerBuilder>{

  ContainerFluent<?> fluent;

  public ContainerBuilder() {
    this(new Container());
  }
  
  public ContainerBuilder(ContainerFluent<?> fluent) {
    this(fluent, new Container());
  }
  
  public ContainerBuilder(Container instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ContainerBuilder(ContainerFluent<?> fluent,Container instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Container build() {
    Container buildable = new Container(fluent.getArgs(), fluent.getCommand(), fluent.buildEnv(), fluent.buildEnvFrom(), fluent.getImage(), fluent.getImagePullPolicy(), fluent.buildLifecycle(), fluent.buildLivenessProbe(), fluent.getName(), fluent.buildPorts(), fluent.buildReadinessProbe(), fluent.buildResizePolicy(), fluent.buildResources(), fluent.getRestartPolicy(), fluent.buildRestartPolicyRules(), fluent.buildSecurityContext(), fluent.buildStartupProbe(), fluent.getStdin(), fluent.getStdinOnce(), fluent.getTerminationMessagePath(), fluent.getTerminationMessagePolicy(), fluent.getTty(), fluent.buildVolumeDevices(), fluent.buildVolumeMounts(), fluent.getWorkingDir());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}