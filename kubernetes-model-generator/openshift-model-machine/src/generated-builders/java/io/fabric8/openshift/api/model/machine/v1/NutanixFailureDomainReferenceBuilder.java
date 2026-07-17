package io.fabric8.openshift.api.model.machine.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NutanixFailureDomainReferenceBuilder extends NutanixFailureDomainReferenceFluent<NutanixFailureDomainReferenceBuilder> implements VisitableBuilder<NutanixFailureDomainReference,NutanixFailureDomainReferenceBuilder>{

  NutanixFailureDomainReferenceFluent<?> fluent;

  public NutanixFailureDomainReferenceBuilder() {
    this(new NutanixFailureDomainReference());
  }
  
  public NutanixFailureDomainReferenceBuilder(NutanixFailureDomainReferenceFluent<?> fluent) {
    this(fluent, new NutanixFailureDomainReference());
  }
  
  public NutanixFailureDomainReferenceBuilder(NutanixFailureDomainReference instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NutanixFailureDomainReferenceBuilder(NutanixFailureDomainReferenceFluent<?> fluent,NutanixFailureDomainReference instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NutanixFailureDomainReference build() {
    NutanixFailureDomainReference buildable = new NutanixFailureDomainReference(fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}