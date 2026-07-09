package io.fabric8.kubernetes.api.model.admissionregistration.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ValidatingWebhookBuilder extends ValidatingWebhookFluent<ValidatingWebhookBuilder> implements VisitableBuilder<ValidatingWebhook,ValidatingWebhookBuilder>{

  ValidatingWebhookFluent<?> fluent;

  public ValidatingWebhookBuilder() {
    this(new ValidatingWebhook());
  }
  
  public ValidatingWebhookBuilder(ValidatingWebhookFluent<?> fluent) {
    this(fluent, new ValidatingWebhook());
  }
  
  public ValidatingWebhookBuilder(ValidatingWebhook instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ValidatingWebhookBuilder(ValidatingWebhookFluent<?> fluent,ValidatingWebhook instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ValidatingWebhook build() {
    ValidatingWebhook buildable = new ValidatingWebhook(fluent.getAdmissionReviewVersions(), fluent.buildClientConfig(), fluent.getFailurePolicy(), fluent.getMatchPolicy(), fluent.getName(), fluent.buildNamespaceSelector(), fluent.buildObjectSelector(), fluent.buildRules(), fluent.getSideEffects(), fluent.getTimeoutSeconds());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}