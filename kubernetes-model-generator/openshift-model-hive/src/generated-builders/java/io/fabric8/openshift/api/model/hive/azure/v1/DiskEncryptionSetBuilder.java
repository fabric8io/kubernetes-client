package io.fabric8.openshift.api.model.hive.azure.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DiskEncryptionSetBuilder extends DiskEncryptionSetFluent<DiskEncryptionSetBuilder> implements VisitableBuilder<DiskEncryptionSet,DiskEncryptionSetBuilder>{

  DiskEncryptionSetFluent<?> fluent;

  public DiskEncryptionSetBuilder() {
    this(new DiskEncryptionSet());
  }
  
  public DiskEncryptionSetBuilder(DiskEncryptionSetFluent<?> fluent) {
    this(fluent, new DiskEncryptionSet());
  }
  
  public DiskEncryptionSetBuilder(DiskEncryptionSet instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DiskEncryptionSetBuilder(DiskEncryptionSetFluent<?> fluent,DiskEncryptionSet instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DiskEncryptionSet build() {
    DiskEncryptionSet buildable = new DiskEncryptionSet(fluent.getName(), fluent.getResourceGroup(), fluent.getSubscriptionId());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}