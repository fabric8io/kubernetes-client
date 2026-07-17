package io.fabric8.openshift.api.model.installer.nutanix.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DataDiskBuilder extends DataDiskFluent<DataDiskBuilder> implements VisitableBuilder<DataDisk,DataDiskBuilder>{

  DataDiskFluent<?> fluent;

  public DataDiskBuilder() {
    this(new DataDisk());
  }
  
  public DataDiskBuilder(DataDiskFluent<?> fluent) {
    this(fluent, new DataDisk());
  }
  
  public DataDiskBuilder(DataDisk instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DataDiskBuilder(DataDiskFluent<?> fluent,DataDisk instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DataDisk build() {
    DataDisk buildable = new DataDisk(fluent.buildDataSourceImage(), fluent.getDeviceProperties(), fluent.getDiskSize(), fluent.buildStorageConfig());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}