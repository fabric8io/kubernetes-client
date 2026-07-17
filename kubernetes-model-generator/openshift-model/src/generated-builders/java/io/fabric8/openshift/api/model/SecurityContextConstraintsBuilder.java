package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SecurityContextConstraintsBuilder extends SecurityContextConstraintsFluent<SecurityContextConstraintsBuilder> implements VisitableBuilder<SecurityContextConstraints,SecurityContextConstraintsBuilder>{

  SecurityContextConstraintsFluent<?> fluent;

  public SecurityContextConstraintsBuilder() {
    this(new SecurityContextConstraints());
  }
  
  public SecurityContextConstraintsBuilder(SecurityContextConstraintsFluent<?> fluent) {
    this(fluent, new SecurityContextConstraints());
  }
  
  public SecurityContextConstraintsBuilder(SecurityContextConstraints instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SecurityContextConstraintsBuilder(SecurityContextConstraintsFluent<?> fluent,SecurityContextConstraints instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SecurityContextConstraints build() {
    SecurityContextConstraints buildable = new SecurityContextConstraints(fluent.getAllowHostDirVolumePlugin(), fluent.getAllowHostIPC(), fluent.getAllowHostNetwork(), fluent.getAllowHostPID(), fluent.getAllowHostPorts(), fluent.getAllowPrivilegeEscalation(), fluent.getAllowPrivilegedContainer(), fluent.getAllowedCapabilities(), fluent.buildAllowedFlexVolumes(), fluent.getAllowedUnsafeSysctls(), fluent.getApiVersion(), fluent.getDefaultAddCapabilities(), fluent.getDefaultAllowPrivilegeEscalation(), fluent.getForbiddenSysctls(), fluent.buildFsGroup(), fluent.getGroups(), fluent.getKind(), fluent.buildMetadata(), fluent.getPriority(), fluent.getReadOnlyRootFilesystem(), fluent.getRequiredDropCapabilities(), fluent.buildRunAsUser(), fluent.buildSeLinuxContext(), fluent.getSeccompProfiles(), fluent.buildSupplementalGroups(), fluent.getUserNamespaceLevel(), fluent.getUsers(), fluent.getVolumes());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}