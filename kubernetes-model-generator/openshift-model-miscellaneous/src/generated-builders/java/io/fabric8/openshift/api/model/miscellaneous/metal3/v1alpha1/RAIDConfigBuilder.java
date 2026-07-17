package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RAIDConfigBuilder extends RAIDConfigFluent<RAIDConfigBuilder> implements VisitableBuilder<RAIDConfig,RAIDConfigBuilder>{

  RAIDConfigFluent<?> fluent;

  public RAIDConfigBuilder() {
    this(new RAIDConfig());
  }
  
  public RAIDConfigBuilder(RAIDConfigFluent<?> fluent) {
    this(fluent, new RAIDConfig());
  }
  
  public RAIDConfigBuilder(RAIDConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RAIDConfigBuilder(RAIDConfigFluent<?> fluent,RAIDConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RAIDConfig build() {
    RAIDConfig buildable = new RAIDConfig(fluent.buildHardwareRAIDVolumes(), fluent.buildSoftwareRAIDVolumes());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}