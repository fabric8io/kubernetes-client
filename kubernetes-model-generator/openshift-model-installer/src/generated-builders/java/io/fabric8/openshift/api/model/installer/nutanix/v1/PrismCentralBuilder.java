package io.fabric8.openshift.api.model.installer.nutanix.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PrismCentralBuilder extends PrismCentralFluent<PrismCentralBuilder> implements VisitableBuilder<PrismCentral,PrismCentralBuilder>{

  PrismCentralFluent<?> fluent;

  public PrismCentralBuilder() {
    this(new PrismCentral());
  }
  
  public PrismCentralBuilder(PrismCentralFluent<?> fluent) {
    this(fluent, new PrismCentral());
  }
  
  public PrismCentralBuilder(PrismCentral instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PrismCentralBuilder(PrismCentralFluent<?> fluent,PrismCentral instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PrismCentral build() {
    PrismCentral buildable = new PrismCentral(fluent.buildEndpoint(), fluent.getPassword(), fluent.getUsername());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}