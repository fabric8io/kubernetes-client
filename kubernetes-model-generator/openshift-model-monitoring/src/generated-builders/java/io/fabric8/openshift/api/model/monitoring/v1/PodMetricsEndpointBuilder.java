package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodMetricsEndpointBuilder extends PodMetricsEndpointFluent<PodMetricsEndpointBuilder> implements VisitableBuilder<PodMetricsEndpoint,PodMetricsEndpointBuilder>{

  PodMetricsEndpointFluent<?> fluent;

  public PodMetricsEndpointBuilder() {
    this(new PodMetricsEndpoint());
  }
  
  public PodMetricsEndpointBuilder(PodMetricsEndpointFluent<?> fluent) {
    this(fluent, new PodMetricsEndpoint());
  }
  
  public PodMetricsEndpointBuilder(PodMetricsEndpoint instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodMetricsEndpointBuilder(PodMetricsEndpointFluent<?> fluent,PodMetricsEndpoint instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodMetricsEndpoint build() {
    PodMetricsEndpoint buildable = new PodMetricsEndpoint(fluent.buildAuthorization(), fluent.buildBasicAuth(), fluent.getBearerTokenSecret(), fluent.getEnableHttp2(), fluent.getFilterRunning(), fluent.getFollowRedirects(), fluent.getHonorLabels(), fluent.getHonorTimestamps(), fluent.getInterval(), fluent.buildMetricRelabelings(), fluent.getNoProxy(), fluent.buildOauth2(), fluent.getParams(), fluent.getPath(), fluent.getPort(), fluent.getPortNumber(), fluent.getProxyConnectHeader(), fluent.getProxyFromEnvironment(), fluent.getProxyUrl(), fluent.buildRelabelings(), fluent.getScheme(), fluent.getScrapeTimeout(), fluent.buildTargetPort(), fluent.buildTlsConfig(), fluent.getTrackTimestampsStaleness());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}