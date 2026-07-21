package io.fabric8.openclustermanagement.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DefaultClusterManagerConfigurationBuilder extends DefaultClusterManagerConfigurationFluent<DefaultClusterManagerConfigurationBuilder> implements VisitableBuilder<DefaultClusterManagerConfiguration,DefaultClusterManagerConfigurationBuilder>{

  DefaultClusterManagerConfigurationFluent<?> fluent;

  public DefaultClusterManagerConfigurationBuilder() {
    this(new DefaultClusterManagerConfiguration());
  }
  
  public DefaultClusterManagerConfigurationBuilder(DefaultClusterManagerConfigurationFluent<?> fluent) {
    this(fluent, new DefaultClusterManagerConfiguration());
  }
  
  public DefaultClusterManagerConfigurationBuilder(DefaultClusterManagerConfiguration instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DefaultClusterManagerConfigurationBuilder(DefaultClusterManagerConfigurationFluent<?> fluent,DefaultClusterManagerConfiguration instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DefaultClusterManagerConfiguration build() {
    DefaultClusterManagerConfiguration buildable = new DefaultClusterManagerConfiguration(fluent.buildAddonWebhookConfiguration(), fluent.buildRegistrationWebhookConfiguration(), fluent.buildWorkWebhookConfiguration());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}