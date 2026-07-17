package io.fabric8.openshift.api.model.machine.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class UEFISettingsBuilder extends UEFISettingsFluent<UEFISettingsBuilder> implements VisitableBuilder<UEFISettings,UEFISettingsBuilder>{

  UEFISettingsFluent<?> fluent;

  public UEFISettingsBuilder() {
    this(new UEFISettings());
  }
  
  public UEFISettingsBuilder(UEFISettingsFluent<?> fluent) {
    this(fluent, new UEFISettings());
  }
  
  public UEFISettingsBuilder(UEFISettings instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public UEFISettingsBuilder(UEFISettingsFluent<?> fluent,UEFISettings instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public UEFISettings build() {
    UEFISettings buildable = new UEFISettings(fluent.getSecureBoot(), fluent.getVirtualizedTrustedPlatformModule());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}