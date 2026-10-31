package io.fabric8.openshift.api.model.machineconfiguration.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OSImageStreamBuilder extends OSImageStreamFluent<OSImageStreamBuilder> implements VisitableBuilder<OSImageStream,OSImageStreamBuilder>{

  OSImageStreamFluent<?> fluent;

  public OSImageStreamBuilder() {
    this(new OSImageStream());
  }
  
  public OSImageStreamBuilder(OSImageStreamFluent<?> fluent) {
    this(fluent, new OSImageStream());
  }
  
  public OSImageStreamBuilder(OSImageStream instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OSImageStreamBuilder(OSImageStreamFluent<?> fluent,OSImageStream instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OSImageStream build() {
    OSImageStream buildable = new OSImageStream(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}