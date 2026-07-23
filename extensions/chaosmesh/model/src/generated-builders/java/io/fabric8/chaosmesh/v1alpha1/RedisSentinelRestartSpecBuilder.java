package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RedisSentinelRestartSpecBuilder extends RedisSentinelRestartSpecFluent<RedisSentinelRestartSpecBuilder> implements VisitableBuilder<RedisSentinelRestartSpec,RedisSentinelRestartSpecBuilder>{

  RedisSentinelRestartSpecFluent<?> fluent;

  public RedisSentinelRestartSpecBuilder() {
    this(new RedisSentinelRestartSpec());
  }
  
  public RedisSentinelRestartSpecBuilder(RedisSentinelRestartSpecFluent<?> fluent) {
    this(fluent, new RedisSentinelRestartSpec());
  }
  
  public RedisSentinelRestartSpecBuilder(RedisSentinelRestartSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RedisSentinelRestartSpecBuilder(RedisSentinelRestartSpecFluent<?> fluent,RedisSentinelRestartSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RedisSentinelRestartSpec build() {
    RedisSentinelRestartSpec buildable = new RedisSentinelRestartSpec(fluent.getAddr(), fluent.getConf(), fluent.getFlushConfig(), fluent.getPassword(), fluent.getRedisPath());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}