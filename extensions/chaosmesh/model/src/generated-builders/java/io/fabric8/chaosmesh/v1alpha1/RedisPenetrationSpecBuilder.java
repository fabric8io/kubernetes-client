package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RedisPenetrationSpecBuilder extends RedisPenetrationSpecFluent<RedisPenetrationSpecBuilder> implements VisitableBuilder<RedisPenetrationSpec,RedisPenetrationSpecBuilder>{

  RedisPenetrationSpecFluent<?> fluent;

  public RedisPenetrationSpecBuilder() {
    this(new RedisPenetrationSpec());
  }
  
  public RedisPenetrationSpecBuilder(RedisPenetrationSpecFluent<?> fluent) {
    this(fluent, new RedisPenetrationSpec());
  }
  
  public RedisPenetrationSpecBuilder(RedisPenetrationSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RedisPenetrationSpecBuilder(RedisPenetrationSpecFluent<?> fluent,RedisPenetrationSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RedisPenetrationSpec build() {
    RedisPenetrationSpec buildable = new RedisPenetrationSpec(fluent.getAddr(), fluent.getPassword(), fluent.getRequestNum());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}