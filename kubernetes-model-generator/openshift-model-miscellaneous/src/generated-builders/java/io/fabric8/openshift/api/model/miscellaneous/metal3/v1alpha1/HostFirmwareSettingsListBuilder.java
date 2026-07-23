package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HostFirmwareSettingsListBuilder extends HostFirmwareSettingsListFluent<HostFirmwareSettingsListBuilder> implements VisitableBuilder<HostFirmwareSettingsList,HostFirmwareSettingsListBuilder>{

  HostFirmwareSettingsListFluent<?> fluent;

  public HostFirmwareSettingsListBuilder() {
    this(new HostFirmwareSettingsList());
  }
  
  public HostFirmwareSettingsListBuilder(HostFirmwareSettingsListFluent<?> fluent) {
    this(fluent, new HostFirmwareSettingsList());
  }
  
  public HostFirmwareSettingsListBuilder(HostFirmwareSettingsList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HostFirmwareSettingsListBuilder(HostFirmwareSettingsListFluent<?> fluent,HostFirmwareSettingsList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HostFirmwareSettingsList build() {
    HostFirmwareSettingsList buildable = new HostFirmwareSettingsList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}