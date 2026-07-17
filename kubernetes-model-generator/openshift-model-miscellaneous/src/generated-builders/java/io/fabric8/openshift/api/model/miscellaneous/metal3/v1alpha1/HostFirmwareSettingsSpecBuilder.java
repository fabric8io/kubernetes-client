package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HostFirmwareSettingsSpecBuilder extends HostFirmwareSettingsSpecFluent<HostFirmwareSettingsSpecBuilder> implements VisitableBuilder<HostFirmwareSettingsSpec,HostFirmwareSettingsSpecBuilder>{

  HostFirmwareSettingsSpecFluent<?> fluent;

  public HostFirmwareSettingsSpecBuilder() {
    this(new HostFirmwareSettingsSpec());
  }
  
  public HostFirmwareSettingsSpecBuilder(HostFirmwareSettingsSpecFluent<?> fluent) {
    this(fluent, new HostFirmwareSettingsSpec());
  }
  
  public HostFirmwareSettingsSpecBuilder(HostFirmwareSettingsSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HostFirmwareSettingsSpecBuilder(HostFirmwareSettingsSpecFluent<?> fluent,HostFirmwareSettingsSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HostFirmwareSettingsSpec build() {
    HostFirmwareSettingsSpec buildable = new HostFirmwareSettingsSpec(fluent.getSettings());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}