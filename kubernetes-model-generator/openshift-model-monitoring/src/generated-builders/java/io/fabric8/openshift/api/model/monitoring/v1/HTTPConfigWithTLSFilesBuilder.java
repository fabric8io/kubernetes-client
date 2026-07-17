package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HTTPConfigWithTLSFilesBuilder extends HTTPConfigWithTLSFilesFluent<HTTPConfigWithTLSFilesBuilder> implements VisitableBuilder<HTTPConfigWithTLSFiles,HTTPConfigWithTLSFilesBuilder>{

  HTTPConfigWithTLSFilesFluent<?> fluent;

  public HTTPConfigWithTLSFilesBuilder() {
    this(new HTTPConfigWithTLSFiles());
  }
  
  public HTTPConfigWithTLSFilesBuilder(HTTPConfigWithTLSFilesFluent<?> fluent) {
    this(fluent, new HTTPConfigWithTLSFiles());
  }
  
  public HTTPConfigWithTLSFilesBuilder(HTTPConfigWithTLSFiles instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HTTPConfigWithTLSFilesBuilder(HTTPConfigWithTLSFilesFluent<?> fluent,HTTPConfigWithTLSFiles instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HTTPConfigWithTLSFiles build() {
    HTTPConfigWithTLSFiles buildable = new HTTPConfigWithTLSFiles(fluent.buildAuthorization(), fluent.buildBasicAuth(), fluent.getBearerTokenSecret(), fluent.getEnableHttp2(), fluent.getFollowRedirects(), fluent.buildOauth2(), fluent.buildTlsConfig());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}