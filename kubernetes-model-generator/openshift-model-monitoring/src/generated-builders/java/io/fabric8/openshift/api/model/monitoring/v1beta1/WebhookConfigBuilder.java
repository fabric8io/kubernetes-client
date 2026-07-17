package io.fabric8.openshift.api.model.monitoring.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class WebhookConfigBuilder extends WebhookConfigFluent<WebhookConfigBuilder> implements VisitableBuilder<WebhookConfig,WebhookConfigBuilder>{

  WebhookConfigFluent<?> fluent;

  public WebhookConfigBuilder() {
    this(new WebhookConfig());
  }
  
  public WebhookConfigBuilder(WebhookConfigFluent<?> fluent) {
    this(fluent, new WebhookConfig());
  }
  
  public WebhookConfigBuilder(WebhookConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public WebhookConfigBuilder(WebhookConfigFluent<?> fluent,WebhookConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public WebhookConfig build() {
    WebhookConfig buildable = new WebhookConfig(fluent.buildHttpConfig(), fluent.getMaxAlerts(), fluent.getSendResolved(), fluent.getTimeout(), fluent.getUrl(), fluent.buildUrlSecret());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}