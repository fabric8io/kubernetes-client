package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BlockChaosListBuilder extends BlockChaosListFluent<BlockChaosListBuilder> implements VisitableBuilder<BlockChaosList,BlockChaosListBuilder>{

  BlockChaosListFluent<?> fluent;

  public BlockChaosListBuilder() {
    this(new BlockChaosList());
  }
  
  public BlockChaosListBuilder(BlockChaosListFluent<?> fluent) {
    this(fluent, new BlockChaosList());
  }
  
  public BlockChaosListBuilder(BlockChaosList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BlockChaosListBuilder(BlockChaosListFluent<?> fluent,BlockChaosList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public BlockChaosList build() {
    BlockChaosList buildable = new BlockChaosList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}