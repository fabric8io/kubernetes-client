package io.fabric8.openshift.api.model.machineconfiguration.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OSImageStreamSetBuilder extends OSImageStreamSetFluent<OSImageStreamSetBuilder> implements VisitableBuilder<OSImageStreamSet,OSImageStreamSetBuilder>{

  OSImageStreamSetFluent<?> fluent;

  public OSImageStreamSetBuilder() {
    this(new OSImageStreamSet());
  }
  
  public OSImageStreamSetBuilder(OSImageStreamSetFluent<?> fluent) {
    this(fluent, new OSImageStreamSet());
  }
  
  public OSImageStreamSetBuilder(OSImageStreamSet instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OSImageStreamSetBuilder(OSImageStreamSetFluent<?> fluent,OSImageStreamSet instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OSImageStreamSet build() {
    OSImageStreamSet buildable = new OSImageStreamSet(fluent.getName(), fluent.getOsExtensionsImage(), fluent.getOsImage());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}