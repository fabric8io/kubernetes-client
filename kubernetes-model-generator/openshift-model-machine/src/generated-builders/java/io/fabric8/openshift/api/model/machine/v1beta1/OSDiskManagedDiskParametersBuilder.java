package io.fabric8.openshift.api.model.machine.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OSDiskManagedDiskParametersBuilder extends OSDiskManagedDiskParametersFluent<OSDiskManagedDiskParametersBuilder> implements VisitableBuilder<OSDiskManagedDiskParameters,OSDiskManagedDiskParametersBuilder>{

  OSDiskManagedDiskParametersFluent<?> fluent;

  public OSDiskManagedDiskParametersBuilder() {
    this(new OSDiskManagedDiskParameters());
  }
  
  public OSDiskManagedDiskParametersBuilder(OSDiskManagedDiskParametersFluent<?> fluent) {
    this(fluent, new OSDiskManagedDiskParameters());
  }
  
  public OSDiskManagedDiskParametersBuilder(OSDiskManagedDiskParameters instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OSDiskManagedDiskParametersBuilder(OSDiskManagedDiskParametersFluent<?> fluent,OSDiskManagedDiskParameters instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OSDiskManagedDiskParameters build() {
    OSDiskManagedDiskParameters buildable = new OSDiskManagedDiskParameters(fluent.buildDiskEncryptionSet(), fluent.buildSecurityProfile(), fluent.getStorageAccountType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}