package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class WebhookDescriptionBuilder extends WebhookDescriptionFluent<WebhookDescriptionBuilder> implements VisitableBuilder<WebhookDescription,WebhookDescriptionBuilder>{

  WebhookDescriptionFluent<?> fluent;

  public WebhookDescriptionBuilder() {
    this(new WebhookDescription());
  }
  
  public WebhookDescriptionBuilder(WebhookDescriptionFluent<?> fluent) {
    this(fluent, new WebhookDescription());
  }
  
  public WebhookDescriptionBuilder(WebhookDescription instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public WebhookDescriptionBuilder(WebhookDescriptionFluent<?> fluent,WebhookDescription instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public WebhookDescription build() {
    WebhookDescription buildable = new WebhookDescription(fluent.getAdmissionReviewVersions(), fluent.getContainerPort(), fluent.getConversionCRDs(), fluent.getDeploymentName(), fluent.getFailurePolicy(), fluent.getGenerateName(), fluent.getMatchPolicy(), fluent.buildObjectSelector(), fluent.getReinvocationPolicy(), fluent.getRules(), fluent.getSideEffects(), fluent.buildTargetPort(), fluent.getTimeoutSeconds(), fluent.getType(), fluent.getWebhookPath());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}