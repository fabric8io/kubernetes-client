package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DeprecatedWebhookTokenAuthenticatorBuilder extends DeprecatedWebhookTokenAuthenticatorFluent<DeprecatedWebhookTokenAuthenticatorBuilder> implements VisitableBuilder<DeprecatedWebhookTokenAuthenticator,DeprecatedWebhookTokenAuthenticatorBuilder>{

  DeprecatedWebhookTokenAuthenticatorFluent<?> fluent;

  public DeprecatedWebhookTokenAuthenticatorBuilder() {
    this(new DeprecatedWebhookTokenAuthenticator());
  }
  
  public DeprecatedWebhookTokenAuthenticatorBuilder(DeprecatedWebhookTokenAuthenticatorFluent<?> fluent) {
    this(fluent, new DeprecatedWebhookTokenAuthenticator());
  }
  
  public DeprecatedWebhookTokenAuthenticatorBuilder(DeprecatedWebhookTokenAuthenticator instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DeprecatedWebhookTokenAuthenticatorBuilder(DeprecatedWebhookTokenAuthenticatorFluent<?> fluent,DeprecatedWebhookTokenAuthenticator instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DeprecatedWebhookTokenAuthenticator build() {
    DeprecatedWebhookTokenAuthenticator buildable = new DeprecatedWebhookTokenAuthenticator(fluent.buildKubeConfig());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}