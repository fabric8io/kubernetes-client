package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GlobalSMTPConfigBuilder extends GlobalSMTPConfigFluent<GlobalSMTPConfigBuilder> implements VisitableBuilder<GlobalSMTPConfig,GlobalSMTPConfigBuilder>{

  GlobalSMTPConfigFluent<?> fluent;

  public GlobalSMTPConfigBuilder() {
    this(new GlobalSMTPConfig());
  }
  
  public GlobalSMTPConfigBuilder(GlobalSMTPConfigFluent<?> fluent) {
    this(fluent, new GlobalSMTPConfig());
  }
  
  public GlobalSMTPConfigBuilder(GlobalSMTPConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GlobalSMTPConfigBuilder(GlobalSMTPConfigFluent<?> fluent,GlobalSMTPConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GlobalSMTPConfig build() {
    GlobalSMTPConfig buildable = new GlobalSMTPConfig(fluent.getAuthIdentity(), fluent.getAuthPassword(), fluent.getAuthSecret(), fluent.getAuthUsername(), fluent.getForceImplicitTLS(), fluent.getFrom(), fluent.getHello(), fluent.getRequireTLS(), fluent.buildSmartHost(), fluent.buildTlsConfig());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}