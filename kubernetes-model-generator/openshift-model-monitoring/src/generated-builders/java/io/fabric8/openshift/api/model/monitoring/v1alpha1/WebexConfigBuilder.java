package io.fabric8.openshift.api.model.monitoring.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class WebexConfigBuilder extends WebexConfigFluent<WebexConfigBuilder> implements VisitableBuilder<WebexConfig,WebexConfigBuilder>{

  WebexConfigFluent<?> fluent;

  public WebexConfigBuilder() {
    this(new WebexConfig());
  }
  
  public WebexConfigBuilder(WebexConfigFluent<?> fluent) {
    this(fluent, new WebexConfig());
  }
  
  public WebexConfigBuilder(WebexConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public WebexConfigBuilder(WebexConfigFluent<?> fluent,WebexConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public WebexConfig build() {
    WebexConfig buildable = new WebexConfig(fluent.getApiURL(), fluent.buildHttpConfig(), fluent.getMessage(), fluent.getRoomID(), fluent.getSendResolved());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}