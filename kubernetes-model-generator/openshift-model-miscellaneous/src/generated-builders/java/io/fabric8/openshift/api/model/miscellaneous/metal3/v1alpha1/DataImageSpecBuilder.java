package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DataImageSpecBuilder extends DataImageSpecFluent<DataImageSpecBuilder> implements VisitableBuilder<DataImageSpec,DataImageSpecBuilder>{

  DataImageSpecFluent<?> fluent;

  public DataImageSpecBuilder() {
    this(new DataImageSpec());
  }
  
  public DataImageSpecBuilder(DataImageSpecFluent<?> fluent) {
    this(fluent, new DataImageSpec());
  }
  
  public DataImageSpecBuilder(DataImageSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DataImageSpecBuilder(DataImageSpecFluent<?> fluent,DataImageSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DataImageSpec build() {
    DataImageSpec buildable = new DataImageSpec(fluent.getUrl());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}