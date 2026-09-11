package io.fabric8.kubernetes.client;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RequestConfigBuilder extends RequestConfigFluent<RequestConfigBuilder> implements VisitableBuilder<RequestConfig,RequestConfigBuilder>{

  RequestConfigFluent<?> fluent;

  public RequestConfigBuilder() {
    this(new RequestConfig());
  }
  
  public RequestConfigBuilder(RequestConfigFluent<?> fluent) {
    this(fluent, new RequestConfig());
  }
  
  public RequestConfigBuilder(RequestConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RequestConfigBuilder(RequestConfigFluent<?> fluent,RequestConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RequestConfig build() {
    RequestConfig buildable = new RequestConfig(fluent.getWatchReconnectLimit(), fluent.getWatchReconnectInterval(), fluent.getRequestTimeout(), fluent.getScaleTimeout(), fluent.getLoggingInterval(), fluent.getRequestRetryBackoffLimit(), fluent.getRequestRetryBackoffInterval(), fluent.getUploadRequestTimeout());
    buildable.setImpersonateUsername(fluent.getImpersonateUsername());
    buildable.setImpersonateGroups(fluent.getImpersonateGroups());
    buildable.setImpersonateExtras(fluent.getImpersonateExtras());
    return buildable;
  }
  
}