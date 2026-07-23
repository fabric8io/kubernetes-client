package io.fabric8.kubernetes.api.model.apiextensions.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class WebhookConversionBuilder extends WebhookConversionFluent<WebhookConversionBuilder> implements VisitableBuilder<WebhookConversion,WebhookConversionBuilder>{

  WebhookConversionFluent<?> fluent;

  public WebhookConversionBuilder() {
    this(new WebhookConversion());
  }
  
  public WebhookConversionBuilder(WebhookConversionFluent<?> fluent) {
    this(fluent, new WebhookConversion());
  }
  
  public WebhookConversionBuilder(WebhookConversion instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public WebhookConversionBuilder(WebhookConversionFluent<?> fluent,WebhookConversion instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public WebhookConversion build() {
    WebhookConversion buildable = new WebhookConversion(fluent.buildClientConfig(), fluent.getConversionReviewVersions());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}