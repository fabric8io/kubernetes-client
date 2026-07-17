package io.fabric8.openshift.api.model.operator.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OLMBuilder extends OLMFluent<OLMBuilder> implements VisitableBuilder<OLM,OLMBuilder>{

  OLMFluent<?> fluent;

  public OLMBuilder() {
    this(new OLM());
  }
  
  public OLMBuilder(OLMFluent<?> fluent) {
    this(fluent, new OLM());
  }
  
  public OLMBuilder(OLM instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OLMBuilder(OLMFluent<?> fluent,OLM instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OLM build() {
    OLM buildable = new OLM(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}