package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NetworkDataServiceBuilder extends NetworkDataServiceFluent<NetworkDataServiceBuilder> implements VisitableBuilder<NetworkDataService,NetworkDataServiceBuilder>{

  NetworkDataServiceFluent<?> fluent;

  public NetworkDataServiceBuilder() {
    this(new NetworkDataService());
  }
  
  public NetworkDataServiceBuilder(NetworkDataServiceFluent<?> fluent) {
    this(fluent, new NetworkDataService());
  }
  
  public NetworkDataServiceBuilder(NetworkDataService instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NetworkDataServiceBuilder(NetworkDataServiceFluent<?> fluent,NetworkDataService instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NetworkDataService build() {
    NetworkDataService buildable = new NetworkDataService(fluent.getDns(), fluent.getDnsFromIPPool());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}