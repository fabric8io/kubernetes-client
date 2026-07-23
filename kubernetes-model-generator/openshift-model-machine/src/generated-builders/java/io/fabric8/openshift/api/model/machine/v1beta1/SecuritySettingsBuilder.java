package io.fabric8.openshift.api.model.machine.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SecuritySettingsBuilder extends SecuritySettingsFluent<SecuritySettingsBuilder> implements VisitableBuilder<SecuritySettings,SecuritySettingsBuilder>{

  SecuritySettingsFluent<?> fluent;

  public SecuritySettingsBuilder() {
    this(new SecuritySettings());
  }
  
  public SecuritySettingsBuilder(SecuritySettingsFluent<?> fluent) {
    this(fluent, new SecuritySettings());
  }
  
  public SecuritySettingsBuilder(SecuritySettings instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SecuritySettingsBuilder(SecuritySettingsFluent<?> fluent,SecuritySettings instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SecuritySettings build() {
    SecuritySettings buildable = new SecuritySettings(fluent.buildConfidentialVM(), fluent.getSecurityType(), fluent.buildTrustedLaunch());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}