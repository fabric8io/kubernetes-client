package io.fabric8.openshift.api.model.machine.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DiskEncryptionSetParametersBuilder extends DiskEncryptionSetParametersFluent<DiskEncryptionSetParametersBuilder> implements VisitableBuilder<DiskEncryptionSetParameters,DiskEncryptionSetParametersBuilder>{

  DiskEncryptionSetParametersFluent<?> fluent;

  public DiskEncryptionSetParametersBuilder() {
    this(new DiskEncryptionSetParameters());
  }
  
  public DiskEncryptionSetParametersBuilder(DiskEncryptionSetParametersFluent<?> fluent) {
    this(fluent, new DiskEncryptionSetParameters());
  }
  
  public DiskEncryptionSetParametersBuilder(DiskEncryptionSetParameters instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DiskEncryptionSetParametersBuilder(DiskEncryptionSetParametersFluent<?> fluent,DiskEncryptionSetParameters instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DiskEncryptionSetParameters build() {
    DiskEncryptionSetParameters buildable = new DiskEncryptionSetParameters(fluent.getId());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}