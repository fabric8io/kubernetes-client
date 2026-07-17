package io.fabric8.openshift.api.model.machineconfiguration.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MCOObjectReferenceBuilder extends MCOObjectReferenceFluent<MCOObjectReferenceBuilder> implements VisitableBuilder<MCOObjectReference,MCOObjectReferenceBuilder>{

  MCOObjectReferenceFluent<?> fluent;

  public MCOObjectReferenceBuilder() {
    this(new MCOObjectReference());
  }
  
  public MCOObjectReferenceBuilder(MCOObjectReferenceFluent<?> fluent) {
    this(fluent, new MCOObjectReference());
  }
  
  public MCOObjectReferenceBuilder(MCOObjectReference instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MCOObjectReferenceBuilder(MCOObjectReferenceFluent<?> fluent,MCOObjectReference instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MCOObjectReference build() {
    MCOObjectReference buildable = new MCOObjectReference(fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}