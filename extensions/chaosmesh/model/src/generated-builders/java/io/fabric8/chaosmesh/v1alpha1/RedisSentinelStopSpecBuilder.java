package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RedisSentinelStopSpecBuilder extends RedisSentinelStopSpecFluent<RedisSentinelStopSpecBuilder> implements VisitableBuilder<RedisSentinelStopSpec,RedisSentinelStopSpecBuilder>{

  RedisSentinelStopSpecFluent<?> fluent;

  public RedisSentinelStopSpecBuilder() {
    this(new RedisSentinelStopSpec());
  }
  
  public RedisSentinelStopSpecBuilder(RedisSentinelStopSpecFluent<?> fluent) {
    this(fluent, new RedisSentinelStopSpec());
  }
  
  public RedisSentinelStopSpecBuilder(RedisSentinelStopSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RedisSentinelStopSpecBuilder(RedisSentinelStopSpecFluent<?> fluent,RedisSentinelStopSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RedisSentinelStopSpec build() {
    RedisSentinelStopSpec buildable = new RedisSentinelStopSpec(fluent.getAddr(), fluent.getConf(), fluent.getFlushConfig(), fluent.getPassword(), fluent.getRedisPath());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}