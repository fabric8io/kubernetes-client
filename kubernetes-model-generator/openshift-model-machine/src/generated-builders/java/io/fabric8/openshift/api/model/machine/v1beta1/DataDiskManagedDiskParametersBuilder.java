package io.fabric8.openshift.api.model.machine.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DataDiskManagedDiskParametersBuilder extends DataDiskManagedDiskParametersFluent<DataDiskManagedDiskParametersBuilder> implements VisitableBuilder<DataDiskManagedDiskParameters,DataDiskManagedDiskParametersBuilder>{

  DataDiskManagedDiskParametersFluent<?> fluent;

  public DataDiskManagedDiskParametersBuilder() {
    this(new DataDiskManagedDiskParameters());
  }
  
  public DataDiskManagedDiskParametersBuilder(DataDiskManagedDiskParametersFluent<?> fluent) {
    this(fluent, new DataDiskManagedDiskParameters());
  }
  
  public DataDiskManagedDiskParametersBuilder(DataDiskManagedDiskParameters instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DataDiskManagedDiskParametersBuilder(DataDiskManagedDiskParametersFluent<?> fluent,DataDiskManagedDiskParameters instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DataDiskManagedDiskParameters build() {
    DataDiskManagedDiskParameters buildable = new DataDiskManagedDiskParameters(fluent.buildDiskEncryptionSet(), fluent.getStorageAccountType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}