package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NetworkDataServicev4Builder extends NetworkDataServicev4Fluent<NetworkDataServicev4Builder> implements VisitableBuilder<NetworkDataServicev4,NetworkDataServicev4Builder>{

  NetworkDataServicev4Fluent<?> fluent;

  public NetworkDataServicev4Builder() {
    this(new NetworkDataServicev4());
  }
  
  public NetworkDataServicev4Builder(NetworkDataServicev4Fluent<?> fluent) {
    this(fluent, new NetworkDataServicev4());
  }
  
  public NetworkDataServicev4Builder(NetworkDataServicev4 instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NetworkDataServicev4Builder(NetworkDataServicev4Fluent<?> fluent,NetworkDataServicev4 instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NetworkDataServicev4 build() {
    NetworkDataServicev4 buildable = new NetworkDataServicev4(fluent.getDns(), fluent.getDnsFromIPPool());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}