package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class WebHTTPHeadersBuilder extends WebHTTPHeadersFluent<WebHTTPHeadersBuilder> implements VisitableBuilder<WebHTTPHeaders,WebHTTPHeadersBuilder>{

  WebHTTPHeadersFluent<?> fluent;

  public WebHTTPHeadersBuilder() {
    this(new WebHTTPHeaders());
  }
  
  public WebHTTPHeadersBuilder(WebHTTPHeadersFluent<?> fluent) {
    this(fluent, new WebHTTPHeaders());
  }
  
  public WebHTTPHeadersBuilder(WebHTTPHeaders instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public WebHTTPHeadersBuilder(WebHTTPHeadersFluent<?> fluent,WebHTTPHeaders instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public WebHTTPHeaders build() {
    WebHTTPHeaders buildable = new WebHTTPHeaders(fluent.getContentSecurityPolicy(), fluent.getStrictTransportSecurity(), fluent.getXContentTypeOptions(), fluent.getXFrameOptions(), fluent.getXXSSProtection());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}