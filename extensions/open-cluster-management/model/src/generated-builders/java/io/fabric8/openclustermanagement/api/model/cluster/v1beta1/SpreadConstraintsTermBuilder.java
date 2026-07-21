package io.fabric8.openclustermanagement.api.model.cluster.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SpreadConstraintsTermBuilder extends SpreadConstraintsTermFluent<SpreadConstraintsTermBuilder> implements VisitableBuilder<SpreadConstraintsTerm,SpreadConstraintsTermBuilder>{

  SpreadConstraintsTermFluent<?> fluent;

  public SpreadConstraintsTermBuilder() {
    this(new SpreadConstraintsTerm());
  }
  
  public SpreadConstraintsTermBuilder(SpreadConstraintsTermFluent<?> fluent) {
    this(fluent, new SpreadConstraintsTerm());
  }
  
  public SpreadConstraintsTermBuilder(SpreadConstraintsTerm instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SpreadConstraintsTermBuilder(SpreadConstraintsTermFluent<?> fluent,SpreadConstraintsTerm instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SpreadConstraintsTerm build() {
    SpreadConstraintsTerm buildable = new SpreadConstraintsTerm(fluent.getMaxSkew(), fluent.getTopologyKey(), fluent.getTopologyKeyType(), fluent.getWhenUnsatisfiable());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}