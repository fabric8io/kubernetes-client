package io.fabric8.openclustermanagement.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BlockDeletionResourceBuilder extends BlockDeletionResourceFluent<BlockDeletionResourceBuilder> implements VisitableBuilder<BlockDeletionResource,BlockDeletionResourceBuilder>{

  BlockDeletionResourceFluent<?> fluent;

  public BlockDeletionResourceBuilder() {
    this(new BlockDeletionResource());
  }
  
  public BlockDeletionResourceBuilder(BlockDeletionResourceFluent<?> fluent) {
    this(fluent, new BlockDeletionResource());
  }
  
  public BlockDeletionResourceBuilder(BlockDeletionResource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BlockDeletionResourceBuilder(BlockDeletionResourceFluent<?> fluent,BlockDeletionResource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public BlockDeletionResource build() {
    BlockDeletionResource buildable = new BlockDeletionResource(fluent.getExceptionTotal(), fluent.getGVK(), fluent.getLabelExceptions(), fluent.getName(), fluent.getNameExceptions());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}