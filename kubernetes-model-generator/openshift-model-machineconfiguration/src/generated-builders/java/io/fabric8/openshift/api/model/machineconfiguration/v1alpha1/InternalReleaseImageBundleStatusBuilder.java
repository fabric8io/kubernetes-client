package io.fabric8.openshift.api.model.machineconfiguration.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class InternalReleaseImageBundleStatusBuilder extends InternalReleaseImageBundleStatusFluent<InternalReleaseImageBundleStatusBuilder> implements VisitableBuilder<InternalReleaseImageBundleStatus,InternalReleaseImageBundleStatusBuilder>{

  InternalReleaseImageBundleStatusFluent<?> fluent;

  public InternalReleaseImageBundleStatusBuilder() {
    this(new InternalReleaseImageBundleStatus());
  }
  
  public InternalReleaseImageBundleStatusBuilder(InternalReleaseImageBundleStatusFluent<?> fluent) {
    this(fluent, new InternalReleaseImageBundleStatus());
  }
  
  public InternalReleaseImageBundleStatusBuilder(InternalReleaseImageBundleStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public InternalReleaseImageBundleStatusBuilder(InternalReleaseImageBundleStatusFluent<?> fluent,InternalReleaseImageBundleStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public InternalReleaseImageBundleStatus build() {
    InternalReleaseImageBundleStatus buildable = new InternalReleaseImageBundleStatus(fluent.getConditions(), fluent.getImage(), fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}