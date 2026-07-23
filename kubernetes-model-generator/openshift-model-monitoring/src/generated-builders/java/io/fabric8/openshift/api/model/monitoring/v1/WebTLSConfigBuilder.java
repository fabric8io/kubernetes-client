package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class WebTLSConfigBuilder extends WebTLSConfigFluent<WebTLSConfigBuilder> implements VisitableBuilder<WebTLSConfig,WebTLSConfigBuilder>{

  WebTLSConfigFluent<?> fluent;

  public WebTLSConfigBuilder() {
    this(new WebTLSConfig());
  }
  
  public WebTLSConfigBuilder(WebTLSConfigFluent<?> fluent) {
    this(fluent, new WebTLSConfig());
  }
  
  public WebTLSConfigBuilder(WebTLSConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public WebTLSConfigBuilder(WebTLSConfigFluent<?> fluent,WebTLSConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public WebTLSConfig build() {
    WebTLSConfig buildable = new WebTLSConfig(fluent.buildCert(), fluent.getCertFile(), fluent.getCipherSuites(), fluent.getClientAuthType(), fluent.getClientCAFile(), fluent.buildClientCa(), fluent.getCurvePreferences(), fluent.getKeyFile(), fluent.getKeySecret(), fluent.getMaxVersion(), fluent.getMinVersion(), fluent.getPreferServerCipherSuites());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}