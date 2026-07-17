package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SafeTLSConfigBuilder extends SafeTLSConfigFluent<SafeTLSConfigBuilder> implements VisitableBuilder<SafeTLSConfig,SafeTLSConfigBuilder>{

  SafeTLSConfigFluent<?> fluent;

  public SafeTLSConfigBuilder() {
    this(new SafeTLSConfig());
  }
  
  public SafeTLSConfigBuilder(SafeTLSConfigFluent<?> fluent) {
    this(fluent, new SafeTLSConfig());
  }
  
  public SafeTLSConfigBuilder(SafeTLSConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SafeTLSConfigBuilder(SafeTLSConfigFluent<?> fluent,SafeTLSConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SafeTLSConfig build() {
    SafeTLSConfig buildable = new SafeTLSConfig(fluent.buildCa(), fluent.buildCert(), fluent.getInsecureSkipVerify(), fluent.getKeySecret(), fluent.getMaxVersion(), fluent.getMinVersion(), fluent.getServerName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}