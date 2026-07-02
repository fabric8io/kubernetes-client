package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ShardInfoBuilder extends ShardInfoFluent<ShardInfoBuilder> implements VisitableBuilder<ShardInfo,ShardInfoBuilder>{

  ShardInfoFluent<?> fluent;

  public ShardInfoBuilder() {
    this(new ShardInfo());
  }
  
  public ShardInfoBuilder(ShardInfoFluent<?> fluent) {
    this(fluent, new ShardInfo());
  }
  
  public ShardInfoBuilder(ShardInfo instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ShardInfoBuilder(ShardInfoFluent<?> fluent,ShardInfo instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ShardInfo build() {
    ShardInfo buildable = new ShardInfo(fluent.getSelector());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}