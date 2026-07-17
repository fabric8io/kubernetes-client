package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HTTPConfigWithProxyAndTLSFilesBuilder extends HTTPConfigWithProxyAndTLSFilesFluent<HTTPConfigWithProxyAndTLSFilesBuilder> implements VisitableBuilder<HTTPConfigWithProxyAndTLSFiles,HTTPConfigWithProxyAndTLSFilesBuilder>{

  HTTPConfigWithProxyAndTLSFilesFluent<?> fluent;

  public HTTPConfigWithProxyAndTLSFilesBuilder() {
    this(new HTTPConfigWithProxyAndTLSFiles());
  }
  
  public HTTPConfigWithProxyAndTLSFilesBuilder(HTTPConfigWithProxyAndTLSFilesFluent<?> fluent) {
    this(fluent, new HTTPConfigWithProxyAndTLSFiles());
  }
  
  public HTTPConfigWithProxyAndTLSFilesBuilder(HTTPConfigWithProxyAndTLSFiles instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HTTPConfigWithProxyAndTLSFilesBuilder(HTTPConfigWithProxyAndTLSFilesFluent<?> fluent,HTTPConfigWithProxyAndTLSFiles instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HTTPConfigWithProxyAndTLSFiles build() {
    HTTPConfigWithProxyAndTLSFiles buildable = new HTTPConfigWithProxyAndTLSFiles(fluent.buildAuthorization(), fluent.buildBasicAuth(), fluent.getBearerTokenSecret(), fluent.getEnableHttp2(), fluent.getFollowRedirects(), fluent.getNoProxy(), fluent.buildOauth2(), fluent.getProxyConnectHeader(), fluent.getProxyFromEnvironment(), fluent.getProxyUrl(), fluent.buildTlsConfig());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}