package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NetworkMigrationBuilder extends NetworkMigrationFluent<NetworkMigrationBuilder> implements VisitableBuilder<NetworkMigration,NetworkMigrationBuilder>{

  NetworkMigrationFluent<?> fluent;

  public NetworkMigrationBuilder() {
    this(new NetworkMigration());
  }
  
  public NetworkMigrationBuilder(NetworkMigrationFluent<?> fluent) {
    this(fluent, new NetworkMigration());
  }
  
  public NetworkMigrationBuilder(NetworkMigration instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NetworkMigrationBuilder(NetworkMigrationFluent<?> fluent,NetworkMigration instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NetworkMigration build() {
    NetworkMigration buildable = new NetworkMigration(fluent.buildMtu(), fluent.getNetworkType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}