package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RootDeviceHintsBuilder extends RootDeviceHintsFluent<RootDeviceHintsBuilder> implements VisitableBuilder<RootDeviceHints,RootDeviceHintsBuilder>{

  RootDeviceHintsFluent<?> fluent;

  public RootDeviceHintsBuilder() {
    this(new RootDeviceHints());
  }
  
  public RootDeviceHintsBuilder(RootDeviceHintsFluent<?> fluent) {
    this(fluent, new RootDeviceHints());
  }
  
  public RootDeviceHintsBuilder(RootDeviceHints instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RootDeviceHintsBuilder(RootDeviceHintsFluent<?> fluent,RootDeviceHints instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RootDeviceHints build() {
    RootDeviceHints buildable = new RootDeviceHints(fluent.getDeviceName(), fluent.getHctl(), fluent.getMinSizeGigabytes(), fluent.getModel(), fluent.getRotational(), fluent.getSerialNumber(), fluent.getVendor(), fluent.getWwn(), fluent.getWwnVendorExtension(), fluent.getWwnWithExtension());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}