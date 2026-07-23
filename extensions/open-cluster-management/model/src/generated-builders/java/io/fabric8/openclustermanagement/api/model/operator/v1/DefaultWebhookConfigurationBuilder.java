package io.fabric8.openclustermanagement.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DefaultWebhookConfigurationBuilder extends DefaultWebhookConfigurationFluent<DefaultWebhookConfigurationBuilder> implements VisitableBuilder<DefaultWebhookConfiguration,DefaultWebhookConfigurationBuilder>{

  DefaultWebhookConfigurationFluent<?> fluent;

  public DefaultWebhookConfigurationBuilder() {
    this(new DefaultWebhookConfiguration());
  }
  
  public DefaultWebhookConfigurationBuilder(DefaultWebhookConfigurationFluent<?> fluent) {
    this(fluent, new DefaultWebhookConfiguration());
  }
  
  public DefaultWebhookConfigurationBuilder(DefaultWebhookConfiguration instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DefaultWebhookConfigurationBuilder(DefaultWebhookConfigurationFluent<?> fluent,DefaultWebhookConfiguration instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DefaultWebhookConfiguration build() {
    DefaultWebhookConfiguration buildable = new DefaultWebhookConfiguration(fluent.buildBindConfiguration());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}