package io.fabric8.openshift.api.model.machine.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DiskSettingsBuilder extends DiskSettingsFluent<DiskSettingsBuilder> implements VisitableBuilder<DiskSettings,DiskSettingsBuilder>{

  DiskSettingsFluent<?> fluent;

  public DiskSettingsBuilder() {
    this(new DiskSettings());
  }
  
  public DiskSettingsBuilder(DiskSettingsFluent<?> fluent) {
    this(fluent, new DiskSettings());
  }
  
  public DiskSettingsBuilder(DiskSettings instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DiskSettingsBuilder(DiskSettingsFluent<?> fluent,DiskSettings instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DiskSettings build() {
    DiskSettings buildable = new DiskSettings(fluent.getEphemeralStorageLocation());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}