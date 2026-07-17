package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DataImageErrorBuilder extends DataImageErrorFluent<DataImageErrorBuilder> implements VisitableBuilder<DataImageError,DataImageErrorBuilder>{

  DataImageErrorFluent<?> fluent;

  public DataImageErrorBuilder() {
    this(new DataImageError());
  }
  
  public DataImageErrorBuilder(DataImageErrorFluent<?> fluent) {
    this(fluent, new DataImageError());
  }
  
  public DataImageErrorBuilder(DataImageError instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DataImageErrorBuilder(DataImageErrorFluent<?> fluent,DataImageError instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DataImageError build() {
    DataImageError buildable = new DataImageError(fluent.getCount(), fluent.getMessage());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}