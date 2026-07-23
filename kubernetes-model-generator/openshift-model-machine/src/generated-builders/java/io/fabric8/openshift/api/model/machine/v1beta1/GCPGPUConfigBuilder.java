package io.fabric8.openshift.api.model.machine.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GCPGPUConfigBuilder extends GCPGPUConfigFluent<GCPGPUConfigBuilder> implements VisitableBuilder<GCPGPUConfig,GCPGPUConfigBuilder>{

  GCPGPUConfigFluent<?> fluent;

  public GCPGPUConfigBuilder() {
    this(new GCPGPUConfig());
  }
  
  public GCPGPUConfigBuilder(GCPGPUConfigFluent<?> fluent) {
    this(fluent, new GCPGPUConfig());
  }
  
  public GCPGPUConfigBuilder(GCPGPUConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GCPGPUConfigBuilder(GCPGPUConfigFluent<?> fluent,GCPGPUConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GCPGPUConfig build() {
    GCPGPUConfig buildable = new GCPGPUConfig(fluent.getCount(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}