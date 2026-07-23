package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SecurityContextBuilder extends SecurityContextFluent<SecurityContextBuilder> implements VisitableBuilder<SecurityContext,SecurityContextBuilder>{

  SecurityContextFluent<?> fluent;

  public SecurityContextBuilder() {
    this(new SecurityContext());
  }
  
  public SecurityContextBuilder(SecurityContextFluent<?> fluent) {
    this(fluent, new SecurityContext());
  }
  
  public SecurityContextBuilder(SecurityContext instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SecurityContextBuilder(SecurityContextFluent<?> fluent,SecurityContext instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SecurityContext build() {
    SecurityContext buildable = new SecurityContext(fluent.getAllowPrivilegeEscalation(), fluent.buildAppArmorProfile(), fluent.buildCapabilities(), fluent.getPrivileged(), fluent.getProcMount(), fluent.getReadOnlyRootFilesystem(), fluent.getRunAsGroup(), fluent.getRunAsNonRoot(), fluent.getRunAsUser(), fluent.buildSeLinuxOptions(), fluent.buildSeccompProfile(), fluent.buildWindowsOptions());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}