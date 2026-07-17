package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HostFirmwareSettingsBuilder extends HostFirmwareSettingsFluent<HostFirmwareSettingsBuilder> implements VisitableBuilder<HostFirmwareSettings,HostFirmwareSettingsBuilder>{

  HostFirmwareSettingsFluent<?> fluent;

  public HostFirmwareSettingsBuilder() {
    this(new HostFirmwareSettings());
  }
  
  public HostFirmwareSettingsBuilder(HostFirmwareSettingsFluent<?> fluent) {
    this(fluent, new HostFirmwareSettings());
  }
  
  public HostFirmwareSettingsBuilder(HostFirmwareSettings instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HostFirmwareSettingsBuilder(HostFirmwareSettingsFluent<?> fluent,HostFirmwareSettings instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HostFirmwareSettings build() {
    HostFirmwareSettings buildable = new HostFirmwareSettings(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}