package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MTUMigrationValuesBuilder extends MTUMigrationValuesFluent<MTUMigrationValuesBuilder> implements VisitableBuilder<MTUMigrationValues,MTUMigrationValuesBuilder>{

  MTUMigrationValuesFluent<?> fluent;

  public MTUMigrationValuesBuilder() {
    this(new MTUMigrationValues());
  }
  
  public MTUMigrationValuesBuilder(MTUMigrationValuesFluent<?> fluent) {
    this(fluent, new MTUMigrationValues());
  }
  
  public MTUMigrationValuesBuilder(MTUMigrationValues instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MTUMigrationValuesBuilder(MTUMigrationValuesFluent<?> fluent,MTUMigrationValues instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MTUMigrationValues build() {
    MTUMigrationValues buildable = new MTUMigrationValues(fluent.getFrom(), fluent.getTo());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}