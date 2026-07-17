package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EtcdStorageConfigBuilder extends EtcdStorageConfigFluent<EtcdStorageConfigBuilder> implements VisitableBuilder<EtcdStorageConfig,EtcdStorageConfigBuilder>{

  EtcdStorageConfigFluent<?> fluent;

  public EtcdStorageConfigBuilder() {
    this(new EtcdStorageConfig());
  }
  
  public EtcdStorageConfigBuilder(EtcdStorageConfigFluent<?> fluent) {
    this(fluent, new EtcdStorageConfig());
  }
  
  public EtcdStorageConfigBuilder(EtcdStorageConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EtcdStorageConfigBuilder(EtcdStorageConfigFluent<?> fluent,EtcdStorageConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EtcdStorageConfig build() {
    EtcdStorageConfig buildable = new EtcdStorageConfig(fluent.getCa(), fluent.getCertFile(), fluent.getKeyFile(), fluent.getStoragePrefix(), fluent.getUrls());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}