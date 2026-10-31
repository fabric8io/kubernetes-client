package io.fabric8.openshift.api.model.machineconfiguration.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OSImageStreamSpecBuilder extends OSImageStreamSpecFluent<OSImageStreamSpecBuilder> implements VisitableBuilder<OSImageStreamSpec,OSImageStreamSpecBuilder>{

  OSImageStreamSpecFluent<?> fluent;

  public OSImageStreamSpecBuilder() {
    this(new OSImageStreamSpec());
  }
  
  public OSImageStreamSpecBuilder(OSImageStreamSpecFluent<?> fluent) {
    this(fluent, new OSImageStreamSpec());
  }
  
  public OSImageStreamSpecBuilder(OSImageStreamSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OSImageStreamSpecBuilder(OSImageStreamSpecFluent<?> fluent,OSImageStreamSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OSImageStreamSpec build() {
    OSImageStreamSpec buildable = new OSImageStreamSpec(fluent.getDefaultStream());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}