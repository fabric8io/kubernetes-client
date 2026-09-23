package io.fabric8.openshift.api.model.machineconfiguration.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class InternalReleaseImageRefBuilder extends InternalReleaseImageRefFluent<InternalReleaseImageRefBuilder> implements VisitableBuilder<InternalReleaseImageRef,InternalReleaseImageRefBuilder>{

  InternalReleaseImageRefFluent<?> fluent;

  public InternalReleaseImageRefBuilder() {
    this(new InternalReleaseImageRef());
  }
  
  public InternalReleaseImageRefBuilder(InternalReleaseImageRefFluent<?> fluent) {
    this(fluent, new InternalReleaseImageRef());
  }
  
  public InternalReleaseImageRefBuilder(InternalReleaseImageRef instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public InternalReleaseImageRefBuilder(InternalReleaseImageRefFluent<?> fluent,InternalReleaseImageRef instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public InternalReleaseImageRef build() {
    InternalReleaseImageRef buildable = new InternalReleaseImageRef(fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}