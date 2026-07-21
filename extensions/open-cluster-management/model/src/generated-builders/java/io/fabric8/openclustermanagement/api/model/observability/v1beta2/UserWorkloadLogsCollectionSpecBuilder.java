package io.fabric8.openclustermanagement.api.model.observability.v1beta2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class UserWorkloadLogsCollectionSpecBuilder extends UserWorkloadLogsCollectionSpecFluent<UserWorkloadLogsCollectionSpecBuilder> implements VisitableBuilder<UserWorkloadLogsCollectionSpec,UserWorkloadLogsCollectionSpecBuilder>{

  UserWorkloadLogsCollectionSpecFluent<?> fluent;

  public UserWorkloadLogsCollectionSpecBuilder() {
    this(new UserWorkloadLogsCollectionSpec());
  }
  
  public UserWorkloadLogsCollectionSpecBuilder(UserWorkloadLogsCollectionSpecFluent<?> fluent) {
    this(fluent, new UserWorkloadLogsCollectionSpec());
  }
  
  public UserWorkloadLogsCollectionSpecBuilder(UserWorkloadLogsCollectionSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public UserWorkloadLogsCollectionSpecBuilder(UserWorkloadLogsCollectionSpecFluent<?> fluent,UserWorkloadLogsCollectionSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public UserWorkloadLogsCollectionSpec build() {
    UserWorkloadLogsCollectionSpec buildable = new UserWorkloadLogsCollectionSpec(fluent.buildClusterLogForwarder());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}