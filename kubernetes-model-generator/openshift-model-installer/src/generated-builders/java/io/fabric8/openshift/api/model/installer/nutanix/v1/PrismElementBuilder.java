package io.fabric8.openshift.api.model.installer.nutanix.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PrismElementBuilder extends PrismElementFluent<PrismElementBuilder> implements VisitableBuilder<PrismElement,PrismElementBuilder>{

  PrismElementFluent<?> fluent;

  public PrismElementBuilder() {
    this(new PrismElement());
  }
  
  public PrismElementBuilder(PrismElementFluent<?> fluent) {
    this(fluent, new PrismElement());
  }
  
  public PrismElementBuilder(PrismElement instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PrismElementBuilder(PrismElementFluent<?> fluent,PrismElement instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PrismElement build() {
    PrismElement buildable = new PrismElement(fluent.buildEndpoint(), fluent.getName(), fluent.getUuid());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}