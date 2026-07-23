package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DataImageStatusBuilder extends DataImageStatusFluent<DataImageStatusBuilder> implements VisitableBuilder<DataImageStatus,DataImageStatusBuilder>{

  DataImageStatusFluent<?> fluent;

  public DataImageStatusBuilder() {
    this(new DataImageStatus());
  }
  
  public DataImageStatusBuilder(DataImageStatusFluent<?> fluent) {
    this(fluent, new DataImageStatus());
  }
  
  public DataImageStatusBuilder(DataImageStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DataImageStatusBuilder(DataImageStatusFluent<?> fluent,DataImageStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DataImageStatus build() {
    DataImageStatus buildable = new DataImageStatus(fluent.buildAttachedImage(), fluent.buildError(), fluent.getLastReconciled());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}