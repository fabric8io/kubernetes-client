package io.fabric8.openclustermanagement.api.model.cluster.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ScoreCoordinateBuilder extends ScoreCoordinateFluent<ScoreCoordinateBuilder> implements VisitableBuilder<ScoreCoordinate,ScoreCoordinateBuilder>{

  ScoreCoordinateFluent<?> fluent;

  public ScoreCoordinateBuilder() {
    this(new ScoreCoordinate());
  }
  
  public ScoreCoordinateBuilder(ScoreCoordinateFluent<?> fluent) {
    this(fluent, new ScoreCoordinate());
  }
  
  public ScoreCoordinateBuilder(ScoreCoordinate instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ScoreCoordinateBuilder(ScoreCoordinateFluent<?> fluent,ScoreCoordinate instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ScoreCoordinate build() {
    ScoreCoordinate buildable = new ScoreCoordinate(fluent.buildAddOn(), fluent.getBuiltIn(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}