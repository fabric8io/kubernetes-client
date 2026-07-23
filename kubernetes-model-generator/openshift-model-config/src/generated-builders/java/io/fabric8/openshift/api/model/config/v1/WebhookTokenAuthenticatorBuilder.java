package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class WebhookTokenAuthenticatorBuilder extends WebhookTokenAuthenticatorFluent<WebhookTokenAuthenticatorBuilder> implements VisitableBuilder<WebhookTokenAuthenticator,WebhookTokenAuthenticatorBuilder>{

  WebhookTokenAuthenticatorFluent<?> fluent;

  public WebhookTokenAuthenticatorBuilder() {
    this(new WebhookTokenAuthenticator());
  }
  
  public WebhookTokenAuthenticatorBuilder(WebhookTokenAuthenticatorFluent<?> fluent) {
    this(fluent, new WebhookTokenAuthenticator());
  }
  
  public WebhookTokenAuthenticatorBuilder(WebhookTokenAuthenticator instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public WebhookTokenAuthenticatorBuilder(WebhookTokenAuthenticatorFluent<?> fluent,WebhookTokenAuthenticator instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public WebhookTokenAuthenticator build() {
    WebhookTokenAuthenticator buildable = new WebhookTokenAuthenticator(fluent.buildKubeConfig());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}