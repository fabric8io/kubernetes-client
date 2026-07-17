package io.fabric8.openshift.api.model.machine.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VMDiskSecurityProfileBuilder extends VMDiskSecurityProfileFluent<VMDiskSecurityProfileBuilder> implements VisitableBuilder<VMDiskSecurityProfile,VMDiskSecurityProfileBuilder>{

  VMDiskSecurityProfileFluent<?> fluent;

  public VMDiskSecurityProfileBuilder() {
    this(new VMDiskSecurityProfile());
  }
  
  public VMDiskSecurityProfileBuilder(VMDiskSecurityProfileFluent<?> fluent) {
    this(fluent, new VMDiskSecurityProfile());
  }
  
  public VMDiskSecurityProfileBuilder(VMDiskSecurityProfile instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VMDiskSecurityProfileBuilder(VMDiskSecurityProfileFluent<?> fluent,VMDiskSecurityProfile instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VMDiskSecurityProfile build() {
    VMDiskSecurityProfile buildable = new VMDiskSecurityProfile(fluent.buildDiskEncryptionSet(), fluent.getSecurityEncryptionType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}