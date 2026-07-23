package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BinaryBuildSourceBuilder extends BinaryBuildSourceFluent<BinaryBuildSourceBuilder> implements VisitableBuilder<BinaryBuildSource,BinaryBuildSourceBuilder>{

  BinaryBuildSourceFluent<?> fluent;

  public BinaryBuildSourceBuilder() {
    this(new BinaryBuildSource());
  }
  
  public BinaryBuildSourceBuilder(BinaryBuildSourceFluent<?> fluent) {
    this(fluent, new BinaryBuildSource());
  }
  
  public BinaryBuildSourceBuilder(BinaryBuildSource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BinaryBuildSourceBuilder(BinaryBuildSourceFluent<?> fluent,BinaryBuildSource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public BinaryBuildSource build() {
    BinaryBuildSource buildable = new BinaryBuildSource(fluent.getAsFile());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}