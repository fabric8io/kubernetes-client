package io.fabric8.kubernetes.api.model.admissionregistration.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ValidatingWebhookConfigurationListBuilder extends ValidatingWebhookConfigurationListFluent<ValidatingWebhookConfigurationListBuilder> implements VisitableBuilder<ValidatingWebhookConfigurationList,ValidatingWebhookConfigurationListBuilder>{

  ValidatingWebhookConfigurationListFluent<?> fluent;

  public ValidatingWebhookConfigurationListBuilder() {
    this(new ValidatingWebhookConfigurationList());
  }
  
  public ValidatingWebhookConfigurationListBuilder(ValidatingWebhookConfigurationListFluent<?> fluent) {
    this(fluent, new ValidatingWebhookConfigurationList());
  }
  
  public ValidatingWebhookConfigurationListBuilder(ValidatingWebhookConfigurationList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ValidatingWebhookConfigurationListBuilder(ValidatingWebhookConfigurationListFluent<?> fluent,ValidatingWebhookConfigurationList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ValidatingWebhookConfigurationList build() {
    ValidatingWebhookConfigurationList buildable = new ValidatingWebhookConfigurationList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}