package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TLSFilesConfigBuilder extends TLSFilesConfigFluent<TLSFilesConfigBuilder> implements VisitableBuilder<TLSFilesConfig,TLSFilesConfigBuilder>{

  TLSFilesConfigFluent<?> fluent;

  public TLSFilesConfigBuilder() {
    this(new TLSFilesConfig());
  }
  
  public TLSFilesConfigBuilder(TLSFilesConfigFluent<?> fluent) {
    this(fluent, new TLSFilesConfig());
  }
  
  public TLSFilesConfigBuilder(TLSFilesConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TLSFilesConfigBuilder(TLSFilesConfigFluent<?> fluent,TLSFilesConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TLSFilesConfig build() {
    TLSFilesConfig buildable = new TLSFilesConfig(fluent.getCaFile(), fluent.getCertFile(), fluent.getKeyFile());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}