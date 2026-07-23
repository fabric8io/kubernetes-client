package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OIDCClientConfigBuilder extends OIDCClientConfigFluent<OIDCClientConfigBuilder> implements VisitableBuilder<OIDCClientConfig,OIDCClientConfigBuilder>{

  OIDCClientConfigFluent<?> fluent;

  public OIDCClientConfigBuilder() {
    this(new OIDCClientConfig());
  }
  
  public OIDCClientConfigBuilder(OIDCClientConfigFluent<?> fluent) {
    this(fluent, new OIDCClientConfig());
  }
  
  public OIDCClientConfigBuilder(OIDCClientConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OIDCClientConfigBuilder(OIDCClientConfigFluent<?> fluent,OIDCClientConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OIDCClientConfig build() {
    OIDCClientConfig buildable = new OIDCClientConfig(fluent.getClientID(), fluent.buildClientSecret(), fluent.getComponentName(), fluent.getComponentNamespace(), fluent.getExtraScopes());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}