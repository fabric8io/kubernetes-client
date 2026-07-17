package io.fabric8.openshift.api.model.installer.nutanix.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class StorageResourceReferenceBuilder extends StorageResourceReferenceFluent<StorageResourceReferenceBuilder> implements VisitableBuilder<StorageResourceReference,StorageResourceReferenceBuilder>{

  StorageResourceReferenceFluent<?> fluent;

  public StorageResourceReferenceBuilder() {
    this(new StorageResourceReference());
  }
  
  public StorageResourceReferenceBuilder(StorageResourceReferenceFluent<?> fluent) {
    this(fluent, new StorageResourceReference());
  }
  
  public StorageResourceReferenceBuilder(StorageResourceReference instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public StorageResourceReferenceBuilder(StorageResourceReferenceFluent<?> fluent,StorageResourceReference instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public StorageResourceReference build() {
    StorageResourceReference buildable = new StorageResourceReference(fluent.getName(), fluent.getReferenceName(), fluent.getUuid());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}