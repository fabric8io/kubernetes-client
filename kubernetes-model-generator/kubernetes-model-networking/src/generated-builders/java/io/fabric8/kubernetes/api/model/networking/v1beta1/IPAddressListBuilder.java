package io.fabric8.kubernetes.api.model.networking.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IPAddressListBuilder extends IPAddressListFluent<IPAddressListBuilder> implements VisitableBuilder<IPAddressList,IPAddressListBuilder>{

  IPAddressListFluent<?> fluent;

  public IPAddressListBuilder() {
    this(new IPAddressList());
  }
  
  public IPAddressListBuilder(IPAddressListFluent<?> fluent) {
    this(fluent, new IPAddressList());
  }
  
  public IPAddressListBuilder(IPAddressList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IPAddressListBuilder(IPAddressListFluent<?> fluent,IPAddressList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IPAddressList build() {
    IPAddressList buildable = new IPAddressList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}