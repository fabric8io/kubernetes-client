package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PlatformSpecBuilder extends PlatformSpecFluent<PlatformSpecBuilder> implements VisitableBuilder<PlatformSpec,PlatformSpecBuilder>{

  PlatformSpecFluent<?> fluent;

  public PlatformSpecBuilder() {
    this(new PlatformSpec());
  }
  
  public PlatformSpecBuilder(PlatformSpecFluent<?> fluent) {
    this(fluent, new PlatformSpec());
  }
  
  public PlatformSpecBuilder(PlatformSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PlatformSpecBuilder(PlatformSpecFluent<?> fluent,PlatformSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PlatformSpec build() {
    PlatformSpec buildable = new PlatformSpec(fluent.buildAlibabaCloud(), fluent.buildAws(), fluent.buildAzure(), fluent.buildBaremetal(), fluent.buildEquinixMetal(), fluent.buildExternal(), fluent.buildGcp(), fluent.buildIbmcloud(), fluent.buildKubevirt(), fluent.buildNutanix(), fluent.buildOpenstack(), fluent.buildOvirt(), fluent.buildPowervs(), fluent.getType(), fluent.buildVsphere());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}