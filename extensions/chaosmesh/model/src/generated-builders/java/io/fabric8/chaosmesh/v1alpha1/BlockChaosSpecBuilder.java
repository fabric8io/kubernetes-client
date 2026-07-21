package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BlockChaosSpecBuilder extends BlockChaosSpecFluent<BlockChaosSpecBuilder> implements VisitableBuilder<BlockChaosSpec,BlockChaosSpecBuilder>{

  BlockChaosSpecFluent<?> fluent;

  public BlockChaosSpecBuilder() {
    this(new BlockChaosSpec());
  }
  
  public BlockChaosSpecBuilder(BlockChaosSpecFluent<?> fluent) {
    this(fluent, new BlockChaosSpec());
  }
  
  public BlockChaosSpecBuilder(BlockChaosSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BlockChaosSpecBuilder(BlockChaosSpecFluent<?> fluent,BlockChaosSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public BlockChaosSpec build() {
    BlockChaosSpec buildable = new BlockChaosSpec(fluent.getAction(), fluent.getContainerNames(), fluent.buildDelay(), fluent.getDuration(), fluent.getMode(), fluent.getRemoteCluster(), fluent.buildSelector(), fluent.getValue(), fluent.getVolumeName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}