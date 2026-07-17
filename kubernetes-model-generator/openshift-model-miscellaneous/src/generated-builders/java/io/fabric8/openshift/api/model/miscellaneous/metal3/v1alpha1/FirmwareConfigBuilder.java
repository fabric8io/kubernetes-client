package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class FirmwareConfigBuilder extends FirmwareConfigFluent<FirmwareConfigBuilder> implements VisitableBuilder<FirmwareConfig,FirmwareConfigBuilder>{

  FirmwareConfigFluent<?> fluent;

  public FirmwareConfigBuilder() {
    this(new FirmwareConfig());
  }
  
  public FirmwareConfigBuilder(FirmwareConfigFluent<?> fluent) {
    this(fluent, new FirmwareConfig());
  }
  
  public FirmwareConfigBuilder(FirmwareConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public FirmwareConfigBuilder(FirmwareConfigFluent<?> fluent,FirmwareConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public FirmwareConfig build() {
    FirmwareConfig buildable = new FirmwareConfig(fluent.getSimultaneousMultithreadingEnabled(), fluent.getSriovEnabled(), fluent.getVirtualizationEnabled());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}