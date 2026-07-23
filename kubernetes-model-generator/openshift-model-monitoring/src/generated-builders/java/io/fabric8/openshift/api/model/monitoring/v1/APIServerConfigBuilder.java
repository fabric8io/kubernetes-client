package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class APIServerConfigBuilder extends APIServerConfigFluent<APIServerConfigBuilder> implements VisitableBuilder<APIServerConfig,APIServerConfigBuilder>{

  APIServerConfigFluent<?> fluent;

  public APIServerConfigBuilder() {
    this(new APIServerConfig());
  }
  
  public APIServerConfigBuilder(APIServerConfigFluent<?> fluent) {
    this(fluent, new APIServerConfig());
  }
  
  public APIServerConfigBuilder(APIServerConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public APIServerConfigBuilder(APIServerConfigFluent<?> fluent,APIServerConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public APIServerConfig build() {
    APIServerConfig buildable = new APIServerConfig(fluent.buildAuthorization(), fluent.buildBasicAuth(), fluent.getBearerToken(), fluent.getBearerTokenFile(), fluent.getHost(), fluent.getNoProxy(), fluent.getProxyConnectHeader(), fluent.getProxyFromEnvironment(), fluent.getProxyUrl(), fluent.buildTlsConfig());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}