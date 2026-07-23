package io.fabric8.openclustermanagement.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HostedWebhookConfigurationBuilder extends HostedWebhookConfigurationFluent<HostedWebhookConfigurationBuilder> implements VisitableBuilder<HostedWebhookConfiguration,HostedWebhookConfigurationBuilder>{

  HostedWebhookConfigurationFluent<?> fluent;

  public HostedWebhookConfigurationBuilder() {
    this(new HostedWebhookConfiguration());
  }
  
  public HostedWebhookConfigurationBuilder(HostedWebhookConfigurationFluent<?> fluent) {
    this(fluent, new HostedWebhookConfiguration());
  }
  
  public HostedWebhookConfigurationBuilder(HostedWebhookConfiguration instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HostedWebhookConfigurationBuilder(HostedWebhookConfigurationFluent<?> fluent,HostedWebhookConfiguration instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HostedWebhookConfiguration build() {
    HostedWebhookConfiguration buildable = new HostedWebhookConfiguration(fluent.getAddress(), fluent.buildBindConfiguration(), fluent.getPort());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}