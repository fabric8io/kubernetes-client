package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GCPPlatformSpecBuilder extends GCPPlatformSpecFluent<GCPPlatformSpecBuilder> implements VisitableBuilder<GCPPlatformSpec,GCPPlatformSpecBuilder>{

  GCPPlatformSpecFluent<?> fluent;

  public GCPPlatformSpecBuilder() {
    this(new GCPPlatformSpec());
  }
  
  public GCPPlatformSpecBuilder(GCPPlatformSpecFluent<?> fluent) {
    this(fluent, new GCPPlatformSpec());
  }
  
  public GCPPlatformSpecBuilder(GCPPlatformSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GCPPlatformSpecBuilder(GCPPlatformSpecFluent<?> fluent,GCPPlatformSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GCPPlatformSpec build() {
    GCPPlatformSpec buildable = new GCPPlatformSpec();
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}