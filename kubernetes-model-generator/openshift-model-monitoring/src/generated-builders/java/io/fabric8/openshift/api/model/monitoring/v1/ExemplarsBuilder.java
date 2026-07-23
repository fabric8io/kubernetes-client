package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ExemplarsBuilder extends ExemplarsFluent<ExemplarsBuilder> implements VisitableBuilder<Exemplars,ExemplarsBuilder>{

  ExemplarsFluent<?> fluent;

  public ExemplarsBuilder() {
    this(new Exemplars());
  }
  
  public ExemplarsBuilder(ExemplarsFluent<?> fluent) {
    this(fluent, new Exemplars());
  }
  
  public ExemplarsBuilder(Exemplars instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ExemplarsBuilder(ExemplarsFluent<?> fluent,Exemplars instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Exemplars build() {
    Exemplars buildable = new Exemplars(fluent.getMaxSize());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}