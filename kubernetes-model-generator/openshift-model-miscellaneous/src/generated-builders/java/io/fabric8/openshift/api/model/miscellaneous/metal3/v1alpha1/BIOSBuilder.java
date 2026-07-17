package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BIOSBuilder extends BIOSFluent<BIOSBuilder> implements VisitableBuilder<BIOS,BIOSBuilder>{

  BIOSFluent<?> fluent;

  public BIOSBuilder() {
    this(new BIOS());
  }
  
  public BIOSBuilder(BIOSFluent<?> fluent) {
    this(fluent, new BIOS());
  }
  
  public BIOSBuilder(BIOS instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BIOSBuilder(BIOSFluent<?> fluent,BIOS instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public BIOS build() {
    BIOS buildable = new BIOS(fluent.getDate(), fluent.getVendor(), fluent.getVersion());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}