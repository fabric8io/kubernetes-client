package io.fabric8.istio.api.api.extensions.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VmConfigBuilder extends VmConfigFluent<VmConfigBuilder> implements VisitableBuilder<VmConfig,VmConfigBuilder>{

  VmConfigFluent<?> fluent;

  public VmConfigBuilder() {
    this(new VmConfig());
  }
  
  public VmConfigBuilder(VmConfigFluent<?> fluent) {
    this(fluent, new VmConfig());
  }
  
  public VmConfigBuilder(VmConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VmConfigBuilder(VmConfigFluent<?> fluent,VmConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VmConfig build() {
    VmConfig buildable = new VmConfig(fluent.buildEnv());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}