package io.fabric8.kubernetes.api.model.ovn.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class UserDefinedNetworkStatusBuilder extends UserDefinedNetworkStatusFluent<UserDefinedNetworkStatusBuilder> implements VisitableBuilder<UserDefinedNetworkStatus,UserDefinedNetworkStatusBuilder>{

  UserDefinedNetworkStatusFluent<?> fluent;

  public UserDefinedNetworkStatusBuilder() {
    this(new UserDefinedNetworkStatus());
  }
  
  public UserDefinedNetworkStatusBuilder(UserDefinedNetworkStatusFluent<?> fluent) {
    this(fluent, new UserDefinedNetworkStatus());
  }
  
  public UserDefinedNetworkStatusBuilder(UserDefinedNetworkStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public UserDefinedNetworkStatusBuilder(UserDefinedNetworkStatusFluent<?> fluent,UserDefinedNetworkStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public UserDefinedNetworkStatus build() {
    UserDefinedNetworkStatus buildable = new UserDefinedNetworkStatus(fluent.getConditions());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}