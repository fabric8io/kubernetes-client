package io.fabric8.kubernetes.api.model.ovn.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class UserDefinedNetworkBuilder extends UserDefinedNetworkFluent<UserDefinedNetworkBuilder> implements VisitableBuilder<UserDefinedNetwork,UserDefinedNetworkBuilder>{

  UserDefinedNetworkFluent<?> fluent;

  public UserDefinedNetworkBuilder() {
    this(new UserDefinedNetwork());
  }
  
  public UserDefinedNetworkBuilder(UserDefinedNetworkFluent<?> fluent) {
    this(fluent, new UserDefinedNetwork());
  }
  
  public UserDefinedNetworkBuilder(UserDefinedNetwork instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public UserDefinedNetworkBuilder(UserDefinedNetworkFluent<?> fluent,UserDefinedNetwork instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public UserDefinedNetwork build() {
    UserDefinedNetwork buildable = new UserDefinedNetwork(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}