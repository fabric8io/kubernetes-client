package io.fabric8.kubernetes.api.model.extensions;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodSecurityPolicySpecBuilder extends PodSecurityPolicySpecFluent<PodSecurityPolicySpecBuilder> implements VisitableBuilder<PodSecurityPolicySpec,PodSecurityPolicySpecBuilder>{

  PodSecurityPolicySpecFluent<?> fluent;

  public PodSecurityPolicySpecBuilder() {
    this(new PodSecurityPolicySpec());
  }
  
  public PodSecurityPolicySpecBuilder(PodSecurityPolicySpecFluent<?> fluent) {
    this(fluent, new PodSecurityPolicySpec());
  }
  
  public PodSecurityPolicySpecBuilder(PodSecurityPolicySpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodSecurityPolicySpecBuilder(PodSecurityPolicySpecFluent<?> fluent,PodSecurityPolicySpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodSecurityPolicySpec build() {
    PodSecurityPolicySpec buildable = new PodSecurityPolicySpec(fluent.getAllowPrivilegeEscalation(), fluent.buildAllowedCSIDrivers(), fluent.getAllowedCapabilities(), fluent.buildAllowedFlexVolumes(), fluent.buildAllowedHostPaths(), fluent.getAllowedProcMountTypes(), fluent.getAllowedUnsafeSysctls(), fluent.getDefaultAddCapabilities(), fluent.getDefaultAllowPrivilegeEscalation(), fluent.getForbiddenSysctls(), fluent.buildFsGroup(), fluent.getHostIPC(), fluent.getHostNetwork(), fluent.getHostPID(), fluent.buildHostPorts(), fluent.getPrivileged(), fluent.getReadOnlyRootFilesystem(), fluent.getRequiredDropCapabilities(), fluent.buildRunAsGroup(), fluent.buildRunAsUser(), fluent.buildRuntimeClass(), fluent.buildSeLinux(), fluent.buildSupplementalGroups(), fluent.getVolumes());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}