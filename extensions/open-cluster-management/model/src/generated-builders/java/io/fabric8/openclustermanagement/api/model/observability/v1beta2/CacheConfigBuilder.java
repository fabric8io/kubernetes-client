package io.fabric8.openclustermanagement.api.model.observability.v1beta2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CacheConfigBuilder extends CacheConfigFluent<CacheConfigBuilder> implements VisitableBuilder<CacheConfig,CacheConfigBuilder>{

  CacheConfigFluent<?> fluent;

  public CacheConfigBuilder() {
    this(new CacheConfig());
  }
  
  public CacheConfigBuilder(CacheConfigFluent<?> fluent) {
    this(fluent, new CacheConfig());
  }
  
  public CacheConfigBuilder(CacheConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CacheConfigBuilder(CacheConfigFluent<?> fluent,CacheConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CacheConfig build() {
    CacheConfig buildable = new CacheConfig(fluent.getConnectionLimit(), fluent.getMaxItemSize(), fluent.getMemoryLimitMb(), fluent.getReplicas(), fluent.buildResources());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}