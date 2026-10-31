package io.fabric8.certmanager.api.model.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ACMERenewalWindowBuilder extends ACMERenewalWindowFluent<ACMERenewalWindowBuilder> implements VisitableBuilder<ACMERenewalWindow,ACMERenewalWindowBuilder>{

  ACMERenewalWindowFluent<?> fluent;

  public ACMERenewalWindowBuilder() {
    this(new ACMERenewalWindow());
  }
  
  public ACMERenewalWindowBuilder(ACMERenewalWindowFluent<?> fluent) {
    this(fluent, new ACMERenewalWindow());
  }
  
  public ACMERenewalWindowBuilder(ACMERenewalWindow instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ACMERenewalWindowBuilder(ACMERenewalWindowFluent<?> fluent,ACMERenewalWindow instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ACMERenewalWindow build() {
    ACMERenewalWindow buildable = new ACMERenewalWindow(fluent.getEnd(), fluent.getStart());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}