package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BlockDelaySpecBuilder extends BlockDelaySpecFluent<BlockDelaySpecBuilder> implements VisitableBuilder<BlockDelaySpec,BlockDelaySpecBuilder>{

  BlockDelaySpecFluent<?> fluent;

  public BlockDelaySpecBuilder() {
    this(new BlockDelaySpec());
  }
  
  public BlockDelaySpecBuilder(BlockDelaySpecFluent<?> fluent) {
    this(fluent, new BlockDelaySpec());
  }
  
  public BlockDelaySpecBuilder(BlockDelaySpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BlockDelaySpecBuilder(BlockDelaySpecFluent<?> fluent,BlockDelaySpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public BlockDelaySpec build() {
    BlockDelaySpec buildable = new BlockDelaySpec(fluent.getCorrelation(), fluent.getJitter(), fluent.getLatency());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}