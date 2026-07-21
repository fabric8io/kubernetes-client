package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RedisCacheLimitSpecBuilder extends RedisCacheLimitSpecFluent<RedisCacheLimitSpecBuilder> implements VisitableBuilder<RedisCacheLimitSpec,RedisCacheLimitSpecBuilder>{

  RedisCacheLimitSpecFluent<?> fluent;

  public RedisCacheLimitSpecBuilder() {
    this(new RedisCacheLimitSpec());
  }
  
  public RedisCacheLimitSpecBuilder(RedisCacheLimitSpecFluent<?> fluent) {
    this(fluent, new RedisCacheLimitSpec());
  }
  
  public RedisCacheLimitSpecBuilder(RedisCacheLimitSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RedisCacheLimitSpecBuilder(RedisCacheLimitSpecFluent<?> fluent,RedisCacheLimitSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RedisCacheLimitSpec build() {
    RedisCacheLimitSpec buildable = new RedisCacheLimitSpec(fluent.getAddr(), fluent.getCacheSize(), fluent.getPassword(), fluent.getPercent());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}