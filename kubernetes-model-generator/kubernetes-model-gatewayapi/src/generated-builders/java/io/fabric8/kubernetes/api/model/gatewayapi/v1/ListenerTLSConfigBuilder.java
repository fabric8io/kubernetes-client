package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ListenerTLSConfigBuilder extends ListenerTLSConfigFluent<ListenerTLSConfigBuilder> implements VisitableBuilder<ListenerTLSConfig,ListenerTLSConfigBuilder>{

  ListenerTLSConfigFluent<?> fluent;

  public ListenerTLSConfigBuilder() {
    this(new ListenerTLSConfig());
  }
  
  public ListenerTLSConfigBuilder(ListenerTLSConfigFluent<?> fluent) {
    this(fluent, new ListenerTLSConfig());
  }
  
  public ListenerTLSConfigBuilder(ListenerTLSConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ListenerTLSConfigBuilder(ListenerTLSConfigFluent<?> fluent,ListenerTLSConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ListenerTLSConfig build() {
    ListenerTLSConfig buildable = new ListenerTLSConfig(fluent.buildCertificateRefs(), fluent.getMode(), fluent.getOptions());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}