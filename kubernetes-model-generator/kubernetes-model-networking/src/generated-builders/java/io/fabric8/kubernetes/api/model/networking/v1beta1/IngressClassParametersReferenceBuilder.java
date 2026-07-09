package io.fabric8.kubernetes.api.model.networking.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IngressClassParametersReferenceBuilder extends IngressClassParametersReferenceFluent<IngressClassParametersReferenceBuilder> implements VisitableBuilder<IngressClassParametersReference,IngressClassParametersReferenceBuilder>{

  IngressClassParametersReferenceFluent<?> fluent;

  public IngressClassParametersReferenceBuilder() {
    this(new IngressClassParametersReference());
  }
  
  public IngressClassParametersReferenceBuilder(IngressClassParametersReferenceFluent<?> fluent) {
    this(fluent, new IngressClassParametersReference());
  }
  
  public IngressClassParametersReferenceBuilder(IngressClassParametersReference instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IngressClassParametersReferenceBuilder(IngressClassParametersReferenceFluent<?> fluent,IngressClassParametersReference instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IngressClassParametersReference build() {
    IngressClassParametersReference buildable = new IngressClassParametersReference(fluent.getApiGroup(), fluent.getKind(), fluent.getName(), fluent.getNamespace(), fluent.getScope());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}