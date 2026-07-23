package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RouterShardBuilder extends RouterShardFluent<RouterShardBuilder> implements VisitableBuilder<RouterShard,RouterShardBuilder>{

  RouterShardFluent<?> fluent;

  public RouterShardBuilder() {
    this(new RouterShard());
  }
  
  public RouterShardBuilder(RouterShardFluent<?> fluent) {
    this(fluent, new RouterShard());
  }
  
  public RouterShardBuilder(RouterShard instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RouterShardBuilder(RouterShardFluent<?> fluent,RouterShard instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RouterShard build() {
    RouterShard buildable = new RouterShard(fluent.getDnsSuffix(), fluent.getShardName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}