package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PowerVSPlatformStatusBuilder extends PowerVSPlatformStatusFluent<PowerVSPlatformStatusBuilder> implements VisitableBuilder<PowerVSPlatformStatus,PowerVSPlatformStatusBuilder>{

  PowerVSPlatformStatusFluent<?> fluent;

  public PowerVSPlatformStatusBuilder() {
    this(new PowerVSPlatformStatus());
  }
  
  public PowerVSPlatformStatusBuilder(PowerVSPlatformStatusFluent<?> fluent) {
    this(fluent, new PowerVSPlatformStatus());
  }
  
  public PowerVSPlatformStatusBuilder(PowerVSPlatformStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PowerVSPlatformStatusBuilder(PowerVSPlatformStatusFluent<?> fluent,PowerVSPlatformStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PowerVSPlatformStatus build() {
    PowerVSPlatformStatus buildable = new PowerVSPlatformStatus(fluent.getCisInstanceCRN(), fluent.getDnsInstanceCRN(), fluent.getRegion(), fluent.getResourceGroup(), fluent.buildServiceEndpoints(), fluent.getZone());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}