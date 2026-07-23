package io.fabric8.kubernetes.api.model.apiextensions.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class WebhookClientConfigBuilder extends WebhookClientConfigFluent<WebhookClientConfigBuilder> implements VisitableBuilder<WebhookClientConfig,WebhookClientConfigBuilder>{

  WebhookClientConfigFluent<?> fluent;

  public WebhookClientConfigBuilder() {
    this(new WebhookClientConfig());
  }
  
  public WebhookClientConfigBuilder(WebhookClientConfigFluent<?> fluent) {
    this(fluent, new WebhookClientConfig());
  }
  
  public WebhookClientConfigBuilder(WebhookClientConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public WebhookClientConfigBuilder(WebhookClientConfigFluent<?> fluent,WebhookClientConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public WebhookClientConfig build() {
    WebhookClientConfig buildable = new WebhookClientConfig(fluent.getCaBundle(), fluent.buildService(), fluent.getUrl());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}