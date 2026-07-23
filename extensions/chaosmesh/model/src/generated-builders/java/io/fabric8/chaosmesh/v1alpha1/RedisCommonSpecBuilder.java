package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RedisCommonSpecBuilder extends RedisCommonSpecFluent<RedisCommonSpecBuilder> implements VisitableBuilder<RedisCommonSpec,RedisCommonSpecBuilder>{

  RedisCommonSpecFluent<?> fluent;

  public RedisCommonSpecBuilder() {
    this(new RedisCommonSpec());
  }
  
  public RedisCommonSpecBuilder(RedisCommonSpecFluent<?> fluent) {
    this(fluent, new RedisCommonSpec());
  }
  
  public RedisCommonSpecBuilder(RedisCommonSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RedisCommonSpecBuilder(RedisCommonSpecFluent<?> fluent,RedisCommonSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RedisCommonSpec build() {
    RedisCommonSpec buildable = new RedisCommonSpec(fluent.getAddr(), fluent.getPassword());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}