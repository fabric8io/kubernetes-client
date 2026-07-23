package io.fabric8.openclustermanagement.api.model.observability.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class StorageConfigObjectBuilder extends StorageConfigObjectFluent<StorageConfigObjectBuilder> implements VisitableBuilder<StorageConfigObject,StorageConfigObjectBuilder>{

  StorageConfigObjectFluent<?> fluent;

  public StorageConfigObjectBuilder() {
    this(new StorageConfigObject());
  }
  
  public StorageConfigObjectBuilder(StorageConfigObjectFluent<?> fluent) {
    this(fluent, new StorageConfigObject());
  }
  
  public StorageConfigObjectBuilder(StorageConfigObject instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public StorageConfigObjectBuilder(StorageConfigObjectFluent<?> fluent,StorageConfigObject instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public StorageConfigObject build() {
    StorageConfigObject buildable = new StorageConfigObject(fluent.buildMetricObjectStorage(), fluent.getStatefulSetSize(), fluent.getStatefulSetStorageClass());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}