package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class WebHookTriggerBuilder extends WebHookTriggerFluent<WebHookTriggerBuilder> implements VisitableBuilder<WebHookTrigger,WebHookTriggerBuilder>{

  WebHookTriggerFluent<?> fluent;

  public WebHookTriggerBuilder() {
    this(new WebHookTrigger());
  }
  
  public WebHookTriggerBuilder(WebHookTriggerFluent<?> fluent) {
    this(fluent, new WebHookTrigger());
  }
  
  public WebHookTriggerBuilder(WebHookTrigger instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public WebHookTriggerBuilder(WebHookTriggerFluent<?> fluent,WebHookTrigger instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public WebHookTrigger build() {
    WebHookTrigger buildable = new WebHookTrigger(fluent.getAllowEnv(), fluent.getSecret(), fluent.buildSecretReference());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}