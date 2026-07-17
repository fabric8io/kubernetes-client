package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class WebHTTPConfigBuilder extends WebHTTPConfigFluent<WebHTTPConfigBuilder> implements VisitableBuilder<WebHTTPConfig,WebHTTPConfigBuilder>{

  WebHTTPConfigFluent<?> fluent;

  public WebHTTPConfigBuilder() {
    this(new WebHTTPConfig());
  }
  
  public WebHTTPConfigBuilder(WebHTTPConfigFluent<?> fluent) {
    this(fluent, new WebHTTPConfig());
  }
  
  public WebHTTPConfigBuilder(WebHTTPConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public WebHTTPConfigBuilder(WebHTTPConfigFluent<?> fluent,WebHTTPConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public WebHTTPConfig build() {
    WebHTTPConfig buildable = new WebHTTPConfig(fluent.buildHeaders(), fluent.getHttp2());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}