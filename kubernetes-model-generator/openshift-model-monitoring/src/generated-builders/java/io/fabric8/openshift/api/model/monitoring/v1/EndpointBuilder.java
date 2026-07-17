package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EndpointBuilder extends EndpointFluent<EndpointBuilder> implements VisitableBuilder<Endpoint,EndpointBuilder>{

  EndpointFluent<?> fluent;

  public EndpointBuilder() {
    this(new Endpoint());
  }
  
  public EndpointBuilder(EndpointFluent<?> fluent) {
    this(fluent, new Endpoint());
  }
  
  public EndpointBuilder(Endpoint instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EndpointBuilder(EndpointFluent<?> fluent,Endpoint instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Endpoint build() {
    Endpoint buildable = new Endpoint(fluent.buildAuthorization(), fluent.buildBasicAuth(), fluent.getBearerTokenFile(), fluent.getBearerTokenSecret(), fluent.getEnableHttp2(), fluent.getFilterRunning(), fluent.getFollowRedirects(), fluent.getHonorLabels(), fluent.getHonorTimestamps(), fluent.getInterval(), fluent.buildMetricRelabelings(), fluent.getNoProxy(), fluent.buildOauth2(), fluent.getParams(), fluent.getPath(), fluent.getPort(), fluent.getProxyConnectHeader(), fluent.getProxyFromEnvironment(), fluent.getProxyUrl(), fluent.buildRelabelings(), fluent.getScheme(), fluent.getScrapeTimeout(), fluent.buildTargetPort(), fluent.buildTlsConfig(), fluent.getTrackTimestampsStaleness());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}