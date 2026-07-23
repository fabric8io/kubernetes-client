package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodSecurityContextBuilder extends PodSecurityContextFluent<PodSecurityContextBuilder> implements VisitableBuilder<PodSecurityContext,PodSecurityContextBuilder>{

  PodSecurityContextFluent<?> fluent;

  public PodSecurityContextBuilder() {
    this(new PodSecurityContext());
  }
  
  public PodSecurityContextBuilder(PodSecurityContextFluent<?> fluent) {
    this(fluent, new PodSecurityContext());
  }
  
  public PodSecurityContextBuilder(PodSecurityContext instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodSecurityContextBuilder(PodSecurityContextFluent<?> fluent,PodSecurityContext instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodSecurityContext build() {
    PodSecurityContext buildable = new PodSecurityContext(fluent.buildAppArmorProfile(), fluent.getFsGroup(), fluent.getFsGroupChangePolicy(), fluent.getRunAsGroup(), fluent.getRunAsNonRoot(), fluent.getRunAsUser(), fluent.getSeLinuxChangePolicy(), fluent.buildSeLinuxOptions(), fluent.buildSeccompProfile(), fluent.getSupplementalGroups(), fluent.getSupplementalGroupsPolicy(), fluent.buildSysctls(), fluent.buildWindowsOptions());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}