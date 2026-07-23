package io.fabric8.openshift.api.model.machine.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DataDiskPropertiesBuilder extends DataDiskPropertiesFluent<DataDiskPropertiesBuilder> implements VisitableBuilder<DataDiskProperties,DataDiskPropertiesBuilder>{

  DataDiskPropertiesFluent<?> fluent;

  public DataDiskPropertiesBuilder() {
    this(new DataDiskProperties());
  }
  
  public DataDiskPropertiesBuilder(DataDiskPropertiesFluent<?> fluent) {
    this(fluent, new DataDiskProperties());
  }
  
  public DataDiskPropertiesBuilder(DataDiskProperties instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DataDiskPropertiesBuilder(DataDiskPropertiesFluent<?> fluent,DataDiskProperties instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DataDiskProperties build() {
    DataDiskProperties buildable = new DataDiskProperties(fluent.getCategory(), fluent.getDiskEncryption(), fluent.getDiskPreservation(), fluent.getKMSKeyID(), fluent.getName(), fluent.getPerformanceLevel(), fluent.getSize(), fluent.getSnapshotID());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}