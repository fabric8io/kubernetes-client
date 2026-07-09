package io.fabric8.kubernetes.api.model.admissionregistration.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ValidatingWebhookConfigurationBuilder extends ValidatingWebhookConfigurationFluent<ValidatingWebhookConfigurationBuilder> implements VisitableBuilder<ValidatingWebhookConfiguration,ValidatingWebhookConfigurationBuilder>{

  ValidatingWebhookConfigurationFluent<?> fluent;

  public ValidatingWebhookConfigurationBuilder() {
    this(new ValidatingWebhookConfiguration());
  }
  
  public ValidatingWebhookConfigurationBuilder(ValidatingWebhookConfigurationFluent<?> fluent) {
    this(fluent, new ValidatingWebhookConfiguration());
  }
  
  public ValidatingWebhookConfigurationBuilder(ValidatingWebhookConfiguration instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ValidatingWebhookConfigurationBuilder(ValidatingWebhookConfigurationFluent<?> fluent,ValidatingWebhookConfiguration instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ValidatingWebhookConfiguration build() {
    ValidatingWebhookConfiguration buildable = new ValidatingWebhookConfiguration(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildWebhooks());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}