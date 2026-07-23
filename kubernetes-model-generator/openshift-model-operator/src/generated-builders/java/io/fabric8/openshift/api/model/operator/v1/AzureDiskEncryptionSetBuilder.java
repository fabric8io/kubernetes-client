package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AzureDiskEncryptionSetBuilder extends AzureDiskEncryptionSetFluent<AzureDiskEncryptionSetBuilder> implements VisitableBuilder<AzureDiskEncryptionSet,AzureDiskEncryptionSetBuilder>{

  AzureDiskEncryptionSetFluent<?> fluent;

  public AzureDiskEncryptionSetBuilder() {
    this(new AzureDiskEncryptionSet());
  }
  
  public AzureDiskEncryptionSetBuilder(AzureDiskEncryptionSetFluent<?> fluent) {
    this(fluent, new AzureDiskEncryptionSet());
  }
  
  public AzureDiskEncryptionSetBuilder(AzureDiskEncryptionSet instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AzureDiskEncryptionSetBuilder(AzureDiskEncryptionSetFluent<?> fluent,AzureDiskEncryptionSet instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AzureDiskEncryptionSet build() {
    AzureDiskEncryptionSet buildable = new AzureDiskEncryptionSet(fluent.getName(), fluent.getResourceGroup(), fluent.getSubscriptionID());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}