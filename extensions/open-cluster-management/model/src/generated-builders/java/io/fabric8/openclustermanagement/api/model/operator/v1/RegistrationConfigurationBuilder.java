package io.fabric8.openclustermanagement.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RegistrationConfigurationBuilder extends RegistrationConfigurationFluent<RegistrationConfigurationBuilder> implements VisitableBuilder<RegistrationConfiguration,RegistrationConfigurationBuilder>{

  RegistrationConfigurationFluent<?> fluent;

  public RegistrationConfigurationBuilder() {
    this(new RegistrationConfiguration());
  }
  
  public RegistrationConfigurationBuilder(RegistrationConfigurationFluent<?> fluent) {
    this(fluent, new RegistrationConfiguration());
  }
  
  public RegistrationConfigurationBuilder(RegistrationConfiguration instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RegistrationConfigurationBuilder(RegistrationConfigurationFluent<?> fluent,RegistrationConfiguration instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RegistrationConfiguration build() {
    RegistrationConfiguration buildable = new RegistrationConfiguration(fluent.buildAddOnKubeClientRegistrationDriver(), fluent.buildBootstrapKubeConfigs(), fluent.getClientCertExpirationSeconds(), fluent.getClusterAnnotations(), fluent.buildClusterClaimConfiguration(), fluent.getClusterLabels(), fluent.buildFeatureGates(), fluent.getKubeAPIBurst(), fluent.getKubeAPIQPS(), fluent.buildRegistrationDriver());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}