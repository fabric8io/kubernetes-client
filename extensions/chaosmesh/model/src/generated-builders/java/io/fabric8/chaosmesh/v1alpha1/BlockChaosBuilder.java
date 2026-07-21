package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BlockChaosBuilder extends BlockChaosFluent<BlockChaosBuilder> implements VisitableBuilder<BlockChaos,BlockChaosBuilder>{

  BlockChaosFluent<?> fluent;

  public BlockChaosBuilder() {
    this(new BlockChaos());
  }
  
  public BlockChaosBuilder(BlockChaosFluent<?> fluent) {
    this(fluent, new BlockChaos());
  }
  
  public BlockChaosBuilder(BlockChaos instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BlockChaosBuilder(BlockChaosFluent<?> fluent,BlockChaos instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public BlockChaos build() {
    BlockChaos buildable = new BlockChaos(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}