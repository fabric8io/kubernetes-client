package io.fabric8.kubernetes.api.model.ovn.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class UserDefinedNetworkSpecBuilder extends UserDefinedNetworkSpecFluent<UserDefinedNetworkSpecBuilder> implements VisitableBuilder<UserDefinedNetworkSpec,UserDefinedNetworkSpecBuilder>{

  UserDefinedNetworkSpecFluent<?> fluent;

  public UserDefinedNetworkSpecBuilder() {
    this(new UserDefinedNetworkSpec());
  }
  
  public UserDefinedNetworkSpecBuilder(UserDefinedNetworkSpecFluent<?> fluent) {
    this(fluent, new UserDefinedNetworkSpec());
  }
  
  public UserDefinedNetworkSpecBuilder(UserDefinedNetworkSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public UserDefinedNetworkSpecBuilder(UserDefinedNetworkSpecFluent<?> fluent,UserDefinedNetworkSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public UserDefinedNetworkSpec build() {
    UserDefinedNetworkSpec buildable = new UserDefinedNetworkSpec(fluent.buildLayer2(), fluent.buildLayer3(), fluent.getTopology());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}