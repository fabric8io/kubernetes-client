package io.fabric8.openshift.api.model.machine.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BlockDeviceMappingSpecBuilder extends BlockDeviceMappingSpecFluent<BlockDeviceMappingSpecBuilder> implements VisitableBuilder<BlockDeviceMappingSpec,BlockDeviceMappingSpecBuilder>{

  BlockDeviceMappingSpecFluent<?> fluent;

  public BlockDeviceMappingSpecBuilder() {
    this(new BlockDeviceMappingSpec());
  }
  
  public BlockDeviceMappingSpecBuilder(BlockDeviceMappingSpecFluent<?> fluent) {
    this(fluent, new BlockDeviceMappingSpec());
  }
  
  public BlockDeviceMappingSpecBuilder(BlockDeviceMappingSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BlockDeviceMappingSpecBuilder(BlockDeviceMappingSpecFluent<?> fluent,BlockDeviceMappingSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public BlockDeviceMappingSpec build() {
    BlockDeviceMappingSpec buildable = new BlockDeviceMappingSpec(fluent.getDeviceName(), fluent.buildEbs(), fluent.getNoDevice(), fluent.getVirtualName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}