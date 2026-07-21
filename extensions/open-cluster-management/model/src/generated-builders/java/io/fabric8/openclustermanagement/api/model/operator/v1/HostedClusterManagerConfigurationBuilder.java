package io.fabric8.openclustermanagement.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HostedClusterManagerConfigurationBuilder extends HostedClusterManagerConfigurationFluent<HostedClusterManagerConfigurationBuilder> implements VisitableBuilder<HostedClusterManagerConfiguration,HostedClusterManagerConfigurationBuilder>{

  HostedClusterManagerConfigurationFluent<?> fluent;

  public HostedClusterManagerConfigurationBuilder() {
    this(new HostedClusterManagerConfiguration());
  }
  
  public HostedClusterManagerConfigurationBuilder(HostedClusterManagerConfigurationFluent<?> fluent) {
    this(fluent, new HostedClusterManagerConfiguration());
  }
  
  public HostedClusterManagerConfigurationBuilder(HostedClusterManagerConfiguration instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HostedClusterManagerConfigurationBuilder(HostedClusterManagerConfigurationFluent<?> fluent,HostedClusterManagerConfiguration instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HostedClusterManagerConfiguration build() {
    HostedClusterManagerConfiguration buildable = new HostedClusterManagerConfiguration(fluent.buildRegistrationWebhookConfiguration(), fluent.buildWorkWebhookConfiguration());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}