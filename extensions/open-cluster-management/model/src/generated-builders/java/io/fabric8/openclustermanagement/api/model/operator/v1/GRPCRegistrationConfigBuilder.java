package io.fabric8.openclustermanagement.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GRPCRegistrationConfigBuilder extends GRPCRegistrationConfigFluent<GRPCRegistrationConfigBuilder> implements VisitableBuilder<GRPCRegistrationConfig,GRPCRegistrationConfigBuilder>{

  GRPCRegistrationConfigFluent<?> fluent;

  public GRPCRegistrationConfigBuilder() {
    this(new GRPCRegistrationConfig());
  }
  
  public GRPCRegistrationConfigBuilder(GRPCRegistrationConfigFluent<?> fluent) {
    this(fluent, new GRPCRegistrationConfig());
  }
  
  public GRPCRegistrationConfigBuilder(GRPCRegistrationConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GRPCRegistrationConfigBuilder(GRPCRegistrationConfigFluent<?> fluent,GRPCRegistrationConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GRPCRegistrationConfig build() {
    GRPCRegistrationConfig buildable = new GRPCRegistrationConfig(fluent.getAutoApprovedIdentities());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}