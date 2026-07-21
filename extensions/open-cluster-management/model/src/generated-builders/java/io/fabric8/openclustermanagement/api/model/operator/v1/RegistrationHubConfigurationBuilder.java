package io.fabric8.openclustermanagement.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RegistrationHubConfigurationBuilder extends RegistrationHubConfigurationFluent<RegistrationHubConfigurationBuilder> implements VisitableBuilder<RegistrationHubConfiguration,RegistrationHubConfigurationBuilder>{

  RegistrationHubConfigurationFluent<?> fluent;

  public RegistrationHubConfigurationBuilder() {
    this(new RegistrationHubConfiguration());
  }
  
  public RegistrationHubConfigurationBuilder(RegistrationHubConfigurationFluent<?> fluent) {
    this(fluent, new RegistrationHubConfiguration());
  }
  
  public RegistrationHubConfigurationBuilder(RegistrationHubConfiguration instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RegistrationHubConfigurationBuilder(RegistrationHubConfigurationFluent<?> fluent,RegistrationHubConfiguration instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RegistrationHubConfiguration build() {
    RegistrationHubConfiguration buildable = new RegistrationHubConfiguration(fluent.getAutoApproveUsers(), fluent.buildFeatureGates(), fluent.buildImporterConfiguration(), fluent.buildRegistrationDrivers());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}