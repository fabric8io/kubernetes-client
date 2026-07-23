package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ArgoCDConfigBuilder extends ArgoCDConfigFluent<ArgoCDConfigBuilder> implements VisitableBuilder<ArgoCDConfig,ArgoCDConfigBuilder>{

  ArgoCDConfigFluent<?> fluent;

  public ArgoCDConfigBuilder() {
    this(new ArgoCDConfig());
  }
  
  public ArgoCDConfigBuilder(ArgoCDConfigFluent<?> fluent) {
    this(fluent, new ArgoCDConfig());
  }
  
  public ArgoCDConfigBuilder(ArgoCDConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ArgoCDConfigBuilder(ArgoCDConfigFluent<?> fluent,ArgoCDConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ArgoCDConfig build() {
    ArgoCDConfig buildable = new ArgoCDConfig(fluent.getEnabled(), fluent.getNamespace());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}