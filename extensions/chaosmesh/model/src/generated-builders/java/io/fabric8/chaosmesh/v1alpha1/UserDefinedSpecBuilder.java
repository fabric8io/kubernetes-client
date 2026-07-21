package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class UserDefinedSpecBuilder extends UserDefinedSpecFluent<UserDefinedSpecBuilder> implements VisitableBuilder<UserDefinedSpec,UserDefinedSpecBuilder>{

  UserDefinedSpecFluent<?> fluent;

  public UserDefinedSpecBuilder() {
    this(new UserDefinedSpec());
  }
  
  public UserDefinedSpecBuilder(UserDefinedSpecFluent<?> fluent) {
    this(fluent, new UserDefinedSpec());
  }
  
  public UserDefinedSpecBuilder(UserDefinedSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public UserDefinedSpecBuilder(UserDefinedSpecFluent<?> fluent,UserDefinedSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public UserDefinedSpec build() {
    UserDefinedSpec buildable = new UserDefinedSpec(fluent.getAttackCmd(), fluent.getRecoverCmd());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}