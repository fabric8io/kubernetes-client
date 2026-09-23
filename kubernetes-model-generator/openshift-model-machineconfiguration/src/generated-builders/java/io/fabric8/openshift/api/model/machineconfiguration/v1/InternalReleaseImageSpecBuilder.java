package io.fabric8.openshift.api.model.machineconfiguration.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class InternalReleaseImageSpecBuilder extends InternalReleaseImageSpecFluent<InternalReleaseImageSpecBuilder> implements VisitableBuilder<InternalReleaseImageSpec,InternalReleaseImageSpecBuilder>{

  InternalReleaseImageSpecFluent<?> fluent;

  public InternalReleaseImageSpecBuilder() {
    this(new InternalReleaseImageSpec());
  }
  
  public InternalReleaseImageSpecBuilder(InternalReleaseImageSpecFluent<?> fluent) {
    this(fluent, new InternalReleaseImageSpec());
  }
  
  public InternalReleaseImageSpecBuilder(InternalReleaseImageSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public InternalReleaseImageSpecBuilder(InternalReleaseImageSpecFluent<?> fluent,InternalReleaseImageSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public InternalReleaseImageSpec build() {
    InternalReleaseImageSpec buildable = new InternalReleaseImageSpec(fluent.buildReleases());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}