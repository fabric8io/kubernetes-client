package io.fabric8.tekton.triggers.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class WebhookInterceptorBuilder extends WebhookInterceptorFluent<WebhookInterceptorBuilder> implements VisitableBuilder<WebhookInterceptor,WebhookInterceptorBuilder>{

  WebhookInterceptorFluent<?> fluent;

  public WebhookInterceptorBuilder() {
    this(new WebhookInterceptor());
  }
  
  public WebhookInterceptorBuilder(WebhookInterceptorFluent<?> fluent) {
    this(fluent, new WebhookInterceptor());
  }
  
  public WebhookInterceptorBuilder(WebhookInterceptor instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public WebhookInterceptorBuilder(WebhookInterceptorFluent<?> fluent,WebhookInterceptor instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public WebhookInterceptor build() {
    WebhookInterceptor buildable = new WebhookInterceptor(fluent.buildHeader(), fluent.buildObjectRef(), fluent.getUrl());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}