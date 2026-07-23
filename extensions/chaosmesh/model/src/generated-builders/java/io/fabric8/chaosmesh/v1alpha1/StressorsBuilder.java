package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class StressorsBuilder extends StressorsFluent<StressorsBuilder> implements VisitableBuilder<Stressors,StressorsBuilder>{

  StressorsFluent<?> fluent;

  public StressorsBuilder() {
    this(new Stressors());
  }
  
  public StressorsBuilder(StressorsFluent<?> fluent) {
    this(fluent, new Stressors());
  }
  
  public StressorsBuilder(Stressors instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public StressorsBuilder(StressorsFluent<?> fluent,Stressors instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Stressors build() {
    Stressors buildable = new Stressors(fluent.buildCpu(), fluent.buildMemory());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}