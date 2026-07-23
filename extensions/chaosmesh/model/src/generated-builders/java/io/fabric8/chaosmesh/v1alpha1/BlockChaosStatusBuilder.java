package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BlockChaosStatusBuilder extends BlockChaosStatusFluent<BlockChaosStatusBuilder> implements VisitableBuilder<BlockChaosStatus,BlockChaosStatusBuilder>{

  BlockChaosStatusFluent<?> fluent;

  public BlockChaosStatusBuilder() {
    this(new BlockChaosStatus());
  }
  
  public BlockChaosStatusBuilder(BlockChaosStatusFluent<?> fluent) {
    this(fluent, new BlockChaosStatus());
  }
  
  public BlockChaosStatusBuilder(BlockChaosStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BlockChaosStatusBuilder(BlockChaosStatusFluent<?> fluent,BlockChaosStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public BlockChaosStatus build() {
    BlockChaosStatus buildable = new BlockChaosStatus(fluent.buildConditions(), fluent.buildExperiment(), fluent.getIds());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}