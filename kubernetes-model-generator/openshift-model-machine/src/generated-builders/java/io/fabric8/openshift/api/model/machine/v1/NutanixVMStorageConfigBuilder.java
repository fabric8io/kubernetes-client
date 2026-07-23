package io.fabric8.openshift.api.model.machine.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NutanixVMStorageConfigBuilder extends NutanixVMStorageConfigFluent<NutanixVMStorageConfigBuilder> implements VisitableBuilder<NutanixVMStorageConfig,NutanixVMStorageConfigBuilder>{

  NutanixVMStorageConfigFluent<?> fluent;

  public NutanixVMStorageConfigBuilder() {
    this(new NutanixVMStorageConfig());
  }
  
  public NutanixVMStorageConfigBuilder(NutanixVMStorageConfigFluent<?> fluent) {
    this(fluent, new NutanixVMStorageConfig());
  }
  
  public NutanixVMStorageConfigBuilder(NutanixVMStorageConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NutanixVMStorageConfigBuilder(NutanixVMStorageConfigFluent<?> fluent,NutanixVMStorageConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NutanixVMStorageConfig build() {
    NutanixVMStorageConfig buildable = new NutanixVMStorageConfig(fluent.getDiskMode(), fluent.buildStorageContainer());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}