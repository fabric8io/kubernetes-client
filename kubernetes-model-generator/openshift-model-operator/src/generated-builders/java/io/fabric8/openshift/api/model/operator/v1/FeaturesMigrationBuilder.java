package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class FeaturesMigrationBuilder extends FeaturesMigrationFluent<FeaturesMigrationBuilder> implements VisitableBuilder<FeaturesMigration,FeaturesMigrationBuilder>{

  FeaturesMigrationFluent<?> fluent;

  public FeaturesMigrationBuilder() {
    this(new FeaturesMigration());
  }
  
  public FeaturesMigrationBuilder(FeaturesMigrationFluent<?> fluent) {
    this(fluent, new FeaturesMigration());
  }
  
  public FeaturesMigrationBuilder(FeaturesMigration instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public FeaturesMigrationBuilder(FeaturesMigrationFluent<?> fluent,FeaturesMigration instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public FeaturesMigration build() {
    FeaturesMigration buildable = new FeaturesMigration(fluent.getEgressFirewall(), fluent.getEgressIP(), fluent.getMulticast());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}