package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HostFirmwareSettingsStatusBuilder extends HostFirmwareSettingsStatusFluent<HostFirmwareSettingsStatusBuilder> implements VisitableBuilder<HostFirmwareSettingsStatus,HostFirmwareSettingsStatusBuilder>{

  HostFirmwareSettingsStatusFluent<?> fluent;

  public HostFirmwareSettingsStatusBuilder() {
    this(new HostFirmwareSettingsStatus());
  }
  
  public HostFirmwareSettingsStatusBuilder(HostFirmwareSettingsStatusFluent<?> fluent) {
    this(fluent, new HostFirmwareSettingsStatus());
  }
  
  public HostFirmwareSettingsStatusBuilder(HostFirmwareSettingsStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HostFirmwareSettingsStatusBuilder(HostFirmwareSettingsStatusFluent<?> fluent,HostFirmwareSettingsStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HostFirmwareSettingsStatus build() {
    HostFirmwareSettingsStatus buildable = new HostFirmwareSettingsStatus(fluent.getConditions(), fluent.getLastUpdated(), fluent.buildSchema(), fluent.getSettings());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}