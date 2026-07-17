package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NetworkDataServicev6Builder extends NetworkDataServicev6Fluent<NetworkDataServicev6Builder> implements VisitableBuilder<NetworkDataServicev6,NetworkDataServicev6Builder>{

  NetworkDataServicev6Fluent<?> fluent;

  public NetworkDataServicev6Builder() {
    this(new NetworkDataServicev6());
  }
  
  public NetworkDataServicev6Builder(NetworkDataServicev6Fluent<?> fluent) {
    this(fluent, new NetworkDataServicev6());
  }
  
  public NetworkDataServicev6Builder(NetworkDataServicev6 instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NetworkDataServicev6Builder(NetworkDataServicev6Fluent<?> fluent,NetworkDataServicev6 instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NetworkDataServicev6 build() {
    NetworkDataServicev6 buildable = new NetworkDataServicev6(fluent.getDns(), fluent.getDnsFromIPPool());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}