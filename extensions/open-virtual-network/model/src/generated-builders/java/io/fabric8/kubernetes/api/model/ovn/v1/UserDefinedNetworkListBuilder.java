package io.fabric8.kubernetes.api.model.ovn.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class UserDefinedNetworkListBuilder extends UserDefinedNetworkListFluent<UserDefinedNetworkListBuilder> implements VisitableBuilder<UserDefinedNetworkList,UserDefinedNetworkListBuilder>{

  UserDefinedNetworkListFluent<?> fluent;

  public UserDefinedNetworkListBuilder() {
    this(new UserDefinedNetworkList());
  }
  
  public UserDefinedNetworkListBuilder(UserDefinedNetworkListFluent<?> fluent) {
    this(fluent, new UserDefinedNetworkList());
  }
  
  public UserDefinedNetworkListBuilder(UserDefinedNetworkList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public UserDefinedNetworkListBuilder(UserDefinedNetworkListFluent<?> fluent,UserDefinedNetworkList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public UserDefinedNetworkList build() {
    UserDefinedNetworkList buildable = new UserDefinedNetworkList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}