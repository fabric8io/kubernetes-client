package io.fabric8.openshift.api.model.machineconfiguration.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class InternalReleaseImageStatusBuilder extends InternalReleaseImageStatusFluent<InternalReleaseImageStatusBuilder> implements VisitableBuilder<InternalReleaseImageStatus,InternalReleaseImageStatusBuilder>{

  InternalReleaseImageStatusFluent<?> fluent;

  public InternalReleaseImageStatusBuilder() {
    this(new InternalReleaseImageStatus());
  }
  
  public InternalReleaseImageStatusBuilder(InternalReleaseImageStatusFluent<?> fluent) {
    this(fluent, new InternalReleaseImageStatus());
  }
  
  public InternalReleaseImageStatusBuilder(InternalReleaseImageStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public InternalReleaseImageStatusBuilder(InternalReleaseImageStatusFluent<?> fluent,InternalReleaseImageStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public InternalReleaseImageStatus build() {
    InternalReleaseImageStatus buildable = new InternalReleaseImageStatus(fluent.getConditions(), fluent.buildReleases());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}