package io.fabric8.openshift.api.model.machine.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BlockDeviceStorageBuilder extends BlockDeviceStorageFluent<BlockDeviceStorageBuilder> implements VisitableBuilder<BlockDeviceStorage,BlockDeviceStorageBuilder>{

  BlockDeviceStorageFluent<?> fluent;

  public BlockDeviceStorageBuilder() {
    this(new BlockDeviceStorage());
  }
  
  public BlockDeviceStorageBuilder(BlockDeviceStorageFluent<?> fluent) {
    this(fluent, new BlockDeviceStorage());
  }
  
  public BlockDeviceStorageBuilder(BlockDeviceStorage instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BlockDeviceStorageBuilder(BlockDeviceStorageFluent<?> fluent,BlockDeviceStorage instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public BlockDeviceStorage build() {
    BlockDeviceStorage buildable = new BlockDeviceStorage(fluent.getType(), fluent.buildVolume());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}