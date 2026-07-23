package io.fabric8.openshift.api.model.machine.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BandwidthPropertiesBuilder extends BandwidthPropertiesFluent<BandwidthPropertiesBuilder> implements VisitableBuilder<BandwidthProperties,BandwidthPropertiesBuilder>{

  BandwidthPropertiesFluent<?> fluent;

  public BandwidthPropertiesBuilder() {
    this(new BandwidthProperties());
  }
  
  public BandwidthPropertiesBuilder(BandwidthPropertiesFluent<?> fluent) {
    this(fluent, new BandwidthProperties());
  }
  
  public BandwidthPropertiesBuilder(BandwidthProperties instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BandwidthPropertiesBuilder(BandwidthPropertiesFluent<?> fluent,BandwidthProperties instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public BandwidthProperties build() {
    BandwidthProperties buildable = new BandwidthProperties(fluent.getInternetMaxBandwidthIn(), fluent.getInternetMaxBandwidthOut());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}