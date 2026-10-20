package io.fabric8.kubernetes.api.model.ovn.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MACSecurityConfigBuilder extends MACSecurityConfigFluent<MACSecurityConfigBuilder> implements VisitableBuilder<MACSecurityConfig,MACSecurityConfigBuilder>{

  MACSecurityConfigFluent<?> fluent;

  public MACSecurityConfigBuilder() {
    this(new MACSecurityConfig());
  }
  
  public MACSecurityConfigBuilder(MACSecurityConfigFluent<?> fluent) {
    this(fluent, new MACSecurityConfig());
  }
  
  public MACSecurityConfigBuilder(MACSecurityConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MACSecurityConfigBuilder(MACSecurityConfigFluent<?> fluent,MACSecurityConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MACSecurityConfig build() {
    MACSecurityConfig buildable = new MACSecurityConfig(fluent.getMode());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}