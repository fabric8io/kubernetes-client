package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class StorageBuilder extends StorageFluent<StorageBuilder> implements VisitableBuilder<Storage,StorageBuilder>{

  StorageFluent<?> fluent;

  public StorageBuilder() {
    this(new Storage());
  }
  
  public StorageBuilder(StorageFluent<?> fluent) {
    this(fluent, new Storage());
  }
  
  public StorageBuilder(Storage instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public StorageBuilder(StorageFluent<?> fluent,Storage instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Storage build() {
    Storage buildable = new Storage(fluent.getAlternateNames(), fluent.getHctl(), fluent.getModel(), fluent.getName(), fluent.getRotational(), fluent.getSerialNumber(), fluent.getSizeBytes(), fluent.getType(), fluent.getVendor(), fluent.getWwn(), fluent.getWwnVendorExtension(), fluent.getWwnWithExtension());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}