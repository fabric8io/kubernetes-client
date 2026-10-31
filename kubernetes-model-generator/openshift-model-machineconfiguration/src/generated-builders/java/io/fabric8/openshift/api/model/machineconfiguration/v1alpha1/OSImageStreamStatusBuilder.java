package io.fabric8.openshift.api.model.machineconfiguration.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OSImageStreamStatusBuilder extends OSImageStreamStatusFluent<OSImageStreamStatusBuilder> implements VisitableBuilder<OSImageStreamStatus,OSImageStreamStatusBuilder>{

  OSImageStreamStatusFluent<?> fluent;

  public OSImageStreamStatusBuilder() {
    this(new OSImageStreamStatus());
  }
  
  public OSImageStreamStatusBuilder(OSImageStreamStatusFluent<?> fluent) {
    this(fluent, new OSImageStreamStatus());
  }
  
  public OSImageStreamStatusBuilder(OSImageStreamStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OSImageStreamStatusBuilder(OSImageStreamStatusFluent<?> fluent,OSImageStreamStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OSImageStreamStatus build() {
    OSImageStreamStatus buildable = new OSImageStreamStatus(fluent.buildAvailableStreams(), fluent.getDefaultStream());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}