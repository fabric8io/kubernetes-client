package io.fabric8.volcano.api.model.nodeinfo.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NumatopologyBuilder extends NumatopologyFluent<NumatopologyBuilder> implements VisitableBuilder<Numatopology,NumatopologyBuilder>{

  NumatopologyFluent<?> fluent;

  public NumatopologyBuilder() {
    this(new Numatopology());
  }
  
  public NumatopologyBuilder(NumatopologyFluent<?> fluent) {
    this(fluent, new Numatopology());
  }
  
  public NumatopologyBuilder(Numatopology instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NumatopologyBuilder(NumatopologyFluent<?> fluent,Numatopology instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Numatopology build() {
    Numatopology buildable = new Numatopology(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}