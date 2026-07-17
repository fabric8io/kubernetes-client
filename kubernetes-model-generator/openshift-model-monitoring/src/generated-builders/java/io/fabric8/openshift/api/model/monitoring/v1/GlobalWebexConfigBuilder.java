package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GlobalWebexConfigBuilder extends GlobalWebexConfigFluent<GlobalWebexConfigBuilder> implements VisitableBuilder<GlobalWebexConfig,GlobalWebexConfigBuilder>{

  GlobalWebexConfigFluent<?> fluent;

  public GlobalWebexConfigBuilder() {
    this(new GlobalWebexConfig());
  }
  
  public GlobalWebexConfigBuilder(GlobalWebexConfigFluent<?> fluent) {
    this(fluent, new GlobalWebexConfig());
  }
  
  public GlobalWebexConfigBuilder(GlobalWebexConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GlobalWebexConfigBuilder(GlobalWebexConfigFluent<?> fluent,GlobalWebexConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GlobalWebexConfig build() {
    GlobalWebexConfig buildable = new GlobalWebexConfig(fluent.getApiURL());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}