package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AlertmanagerEndpointsBuilder extends AlertmanagerEndpointsFluent<AlertmanagerEndpointsBuilder> implements VisitableBuilder<AlertmanagerEndpoints,AlertmanagerEndpointsBuilder>{

  AlertmanagerEndpointsFluent<?> fluent;

  public AlertmanagerEndpointsBuilder() {
    this(new AlertmanagerEndpoints());
  }
  
  public AlertmanagerEndpointsBuilder(AlertmanagerEndpointsFluent<?> fluent) {
    this(fluent, new AlertmanagerEndpoints());
  }
  
  public AlertmanagerEndpointsBuilder(AlertmanagerEndpoints instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AlertmanagerEndpointsBuilder(AlertmanagerEndpointsFluent<?> fluent,AlertmanagerEndpoints instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AlertmanagerEndpoints build() {
    AlertmanagerEndpoints buildable = new AlertmanagerEndpoints(fluent.buildAlertRelabelings(), fluent.getApiVersion(), fluent.buildAuthorization(), fluent.buildBasicAuth(), fluent.getBearerTokenFile(), fluent.getEnableHttp2(), fluent.getName(), fluent.getNamespace(), fluent.getNoProxy(), fluent.getPathPrefix(), fluent.buildPort(), fluent.getProxyConnectHeader(), fluent.getProxyFromEnvironment(), fluent.getProxyUrl(), fluent.buildRelabelings(), fluent.getScheme(), fluent.buildSigv4(), fluent.getTimeout(), fluent.buildTlsConfig());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}