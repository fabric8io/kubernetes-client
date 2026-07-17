package io.fabric8.openshift.api.model.storageversionmigrator.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class StorageStateSpecResourceBuilder extends StorageStateSpecResourceFluent<StorageStateSpecResourceBuilder> implements VisitableBuilder<StorageStateSpecResource,StorageStateSpecResourceBuilder>{

  StorageStateSpecResourceFluent<?> fluent;

  public StorageStateSpecResourceBuilder() {
    this(new StorageStateSpecResource());
  }
  
  public StorageStateSpecResourceBuilder(StorageStateSpecResourceFluent<?> fluent) {
    this(fluent, new StorageStateSpecResource());
  }
  
  public StorageStateSpecResourceBuilder(StorageStateSpecResource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public StorageStateSpecResourceBuilder(StorageStateSpecResourceFluent<?> fluent,StorageStateSpecResource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public StorageStateSpecResource build() {
    StorageStateSpecResource buildable = new StorageStateSpecResource(fluent.getGroup(), fluent.getResource());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}