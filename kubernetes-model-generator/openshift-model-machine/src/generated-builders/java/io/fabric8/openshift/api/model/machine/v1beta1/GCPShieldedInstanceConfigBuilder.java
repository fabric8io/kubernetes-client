package io.fabric8.openshift.api.model.machine.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GCPShieldedInstanceConfigBuilder extends GCPShieldedInstanceConfigFluent<GCPShieldedInstanceConfigBuilder> implements VisitableBuilder<GCPShieldedInstanceConfig,GCPShieldedInstanceConfigBuilder>{

  GCPShieldedInstanceConfigFluent<?> fluent;

  public GCPShieldedInstanceConfigBuilder() {
    this(new GCPShieldedInstanceConfig());
  }
  
  public GCPShieldedInstanceConfigBuilder(GCPShieldedInstanceConfigFluent<?> fluent) {
    this(fluent, new GCPShieldedInstanceConfig());
  }
  
  public GCPShieldedInstanceConfigBuilder(GCPShieldedInstanceConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GCPShieldedInstanceConfigBuilder(GCPShieldedInstanceConfigFluent<?> fluent,GCPShieldedInstanceConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GCPShieldedInstanceConfig build() {
    GCPShieldedInstanceConfig buildable = new GCPShieldedInstanceConfig(fluent.getIntegrityMonitoring(), fluent.getSecureBoot(), fluent.getVirtualizedTrustedPlatformModule());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}