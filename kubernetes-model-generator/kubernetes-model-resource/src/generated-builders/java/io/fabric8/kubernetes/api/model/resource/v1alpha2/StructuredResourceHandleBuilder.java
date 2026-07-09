package io.fabric8.kubernetes.api.model.resource.v1alpha2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class StructuredResourceHandleBuilder extends StructuredResourceHandleFluent<StructuredResourceHandleBuilder> implements VisitableBuilder<StructuredResourceHandle,StructuredResourceHandleBuilder>{

  StructuredResourceHandleFluent<?> fluent;

  public StructuredResourceHandleBuilder() {
    this(new StructuredResourceHandle());
  }
  
  public StructuredResourceHandleBuilder(StructuredResourceHandleFluent<?> fluent) {
    this(fluent, new StructuredResourceHandle());
  }
  
  public StructuredResourceHandleBuilder(StructuredResourceHandle instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public StructuredResourceHandleBuilder(StructuredResourceHandleFluent<?> fluent,StructuredResourceHandle instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public StructuredResourceHandle build() {
    StructuredResourceHandle buildable = new StructuredResourceHandle(fluent.getNodeName(), fluent.buildResults(), fluent.getVendorClaimParameters(), fluent.getVendorClassParameters());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}