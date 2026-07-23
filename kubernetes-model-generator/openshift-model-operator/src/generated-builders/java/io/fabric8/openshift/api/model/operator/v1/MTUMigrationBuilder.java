package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MTUMigrationBuilder extends MTUMigrationFluent<MTUMigrationBuilder> implements VisitableBuilder<MTUMigration,MTUMigrationBuilder>{

  MTUMigrationFluent<?> fluent;

  public MTUMigrationBuilder() {
    this(new MTUMigration());
  }
  
  public MTUMigrationBuilder(MTUMigrationFluent<?> fluent) {
    this(fluent, new MTUMigration());
  }
  
  public MTUMigrationBuilder(MTUMigration instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MTUMigrationBuilder(MTUMigrationFluent<?> fluent,MTUMigration instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MTUMigration build() {
    MTUMigration buildable = new MTUMigration(fluent.buildMachine(), fluent.buildNetwork());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}