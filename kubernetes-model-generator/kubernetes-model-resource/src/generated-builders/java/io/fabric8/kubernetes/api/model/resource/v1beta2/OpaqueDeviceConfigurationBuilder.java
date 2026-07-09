package io.fabric8.kubernetes.api.model.resource.v1beta2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OpaqueDeviceConfigurationBuilder extends OpaqueDeviceConfigurationFluent<OpaqueDeviceConfigurationBuilder> implements VisitableBuilder<OpaqueDeviceConfiguration,OpaqueDeviceConfigurationBuilder>{

  OpaqueDeviceConfigurationFluent<?> fluent;

  public OpaqueDeviceConfigurationBuilder() {
    this(new OpaqueDeviceConfiguration());
  }
  
  public OpaqueDeviceConfigurationBuilder(OpaqueDeviceConfigurationFluent<?> fluent) {
    this(fluent, new OpaqueDeviceConfiguration());
  }
  
  public OpaqueDeviceConfigurationBuilder(OpaqueDeviceConfiguration instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OpaqueDeviceConfigurationBuilder(OpaqueDeviceConfigurationFluent<?> fluent,OpaqueDeviceConfiguration instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OpaqueDeviceConfiguration build() {
    OpaqueDeviceConfiguration buildable = new OpaqueDeviceConfiguration(fluent.getDriver(), fluent.getParameters());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}