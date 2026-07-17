package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ShardRetentionPolicyBuilder extends ShardRetentionPolicyFluent<ShardRetentionPolicyBuilder> implements VisitableBuilder<ShardRetentionPolicy,ShardRetentionPolicyBuilder>{

  ShardRetentionPolicyFluent<?> fluent;

  public ShardRetentionPolicyBuilder() {
    this(new ShardRetentionPolicy());
  }
  
  public ShardRetentionPolicyBuilder(ShardRetentionPolicyFluent<?> fluent) {
    this(fluent, new ShardRetentionPolicy());
  }
  
  public ShardRetentionPolicyBuilder(ShardRetentionPolicy instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ShardRetentionPolicyBuilder(ShardRetentionPolicyFluent<?> fluent,ShardRetentionPolicy instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ShardRetentionPolicy build() {
    ShardRetentionPolicy buildable = new ShardRetentionPolicy(fluent.buildRetain(), fluent.getWhenScaled());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}