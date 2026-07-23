package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GCPCSIDriverConfigSpecBuilder extends GCPCSIDriverConfigSpecFluent<GCPCSIDriverConfigSpecBuilder> implements VisitableBuilder<GCPCSIDriverConfigSpec,GCPCSIDriverConfigSpecBuilder>{

  GCPCSIDriverConfigSpecFluent<?> fluent;

  public GCPCSIDriverConfigSpecBuilder() {
    this(new GCPCSIDriverConfigSpec());
  }
  
  public GCPCSIDriverConfigSpecBuilder(GCPCSIDriverConfigSpecFluent<?> fluent) {
    this(fluent, new GCPCSIDriverConfigSpec());
  }
  
  public GCPCSIDriverConfigSpecBuilder(GCPCSIDriverConfigSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GCPCSIDriverConfigSpecBuilder(GCPCSIDriverConfigSpecFluent<?> fluent,GCPCSIDriverConfigSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GCPCSIDriverConfigSpec build() {
    GCPCSIDriverConfigSpec buildable = new GCPCSIDriverConfigSpec(fluent.buildKmsKey());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}