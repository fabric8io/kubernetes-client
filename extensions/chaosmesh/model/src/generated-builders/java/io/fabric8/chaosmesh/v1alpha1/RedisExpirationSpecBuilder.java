package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RedisExpirationSpecBuilder extends RedisExpirationSpecFluent<RedisExpirationSpecBuilder> implements VisitableBuilder<RedisExpirationSpec,RedisExpirationSpecBuilder>{

  RedisExpirationSpecFluent<?> fluent;

  public RedisExpirationSpecBuilder() {
    this(new RedisExpirationSpec());
  }
  
  public RedisExpirationSpecBuilder(RedisExpirationSpecFluent<?> fluent) {
    this(fluent, new RedisExpirationSpec());
  }
  
  public RedisExpirationSpecBuilder(RedisExpirationSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RedisExpirationSpecBuilder(RedisExpirationSpecFluent<?> fluent,RedisExpirationSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RedisExpirationSpec build() {
    RedisExpirationSpec buildable = new RedisExpirationSpec(fluent.getAddr(), fluent.getExpiration(), fluent.getKey(), fluent.getOption(), fluent.getPassword());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}