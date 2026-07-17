package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MetaDataIPAddressBuilder extends MetaDataIPAddressFluent<MetaDataIPAddressBuilder> implements VisitableBuilder<MetaDataIPAddress,MetaDataIPAddressBuilder>{

  MetaDataIPAddressFluent<?> fluent;

  public MetaDataIPAddressBuilder() {
    this(new MetaDataIPAddress());
  }
  
  public MetaDataIPAddressBuilder(MetaDataIPAddressFluent<?> fluent) {
    this(fluent, new MetaDataIPAddress());
  }
  
  public MetaDataIPAddressBuilder(MetaDataIPAddress instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MetaDataIPAddressBuilder(MetaDataIPAddressFluent<?> fluent,MetaDataIPAddress instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MetaDataIPAddress build() {
    MetaDataIPAddress buildable = new MetaDataIPAddress(fluent.getEnd(), fluent.getKey(), fluent.getStart(), fluent.getStep(), fluent.getSubnet());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}