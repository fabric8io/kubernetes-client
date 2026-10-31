package io.fabric8.openshift.api.model.machineconfiguration.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OSImageStreamListBuilder extends OSImageStreamListFluent<OSImageStreamListBuilder> implements VisitableBuilder<OSImageStreamList,OSImageStreamListBuilder>{

  OSImageStreamListFluent<?> fluent;

  public OSImageStreamListBuilder() {
    this(new OSImageStreamList());
  }
  
  public OSImageStreamListBuilder(OSImageStreamListFluent<?> fluent) {
    this(fluent, new OSImageStreamList());
  }
  
  public OSImageStreamListBuilder(OSImageStreamList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OSImageStreamListBuilder(OSImageStreamListFluent<?> fluent,OSImageStreamList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OSImageStreamList build() {
    OSImageStreamList buildable = new OSImageStreamList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}