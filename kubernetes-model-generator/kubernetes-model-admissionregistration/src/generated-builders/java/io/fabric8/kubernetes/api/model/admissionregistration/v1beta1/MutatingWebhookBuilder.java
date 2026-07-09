package io.fabric8.kubernetes.api.model.admissionregistration.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MutatingWebhookBuilder extends MutatingWebhookFluent<MutatingWebhookBuilder> implements VisitableBuilder<MutatingWebhook,MutatingWebhookBuilder>{

  MutatingWebhookFluent<?> fluent;

  public MutatingWebhookBuilder() {
    this(new MutatingWebhook());
  }
  
  public MutatingWebhookBuilder(MutatingWebhookFluent<?> fluent) {
    this(fluent, new MutatingWebhook());
  }
  
  public MutatingWebhookBuilder(MutatingWebhook instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MutatingWebhookBuilder(MutatingWebhookFluent<?> fluent,MutatingWebhook instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MutatingWebhook build() {
    MutatingWebhook buildable = new MutatingWebhook(fluent.getAdmissionReviewVersions(), fluent.buildClientConfig(), fluent.getFailurePolicy(), fluent.getMatchPolicy(), fluent.getName(), fluent.buildNamespaceSelector(), fluent.buildObjectSelector(), fluent.getReinvocationPolicy(), fluent.buildRules(), fluent.getSideEffects(), fluent.getTimeoutSeconds());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}