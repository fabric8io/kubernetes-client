package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ChunkEncodingSpecBuilder extends ChunkEncodingSpecFluent<ChunkEncodingSpecBuilder> implements VisitableBuilder<ChunkEncodingSpec,ChunkEncodingSpecBuilder>{

  ChunkEncodingSpecFluent<?> fluent;

  public ChunkEncodingSpecBuilder() {
    this(new ChunkEncodingSpec());
  }
  
  public ChunkEncodingSpecBuilder(ChunkEncodingSpecFluent<?> fluent) {
    this(fluent, new ChunkEncodingSpec());
  }
  
  public ChunkEncodingSpecBuilder(ChunkEncodingSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ChunkEncodingSpecBuilder(ChunkEncodingSpecFluent<?> fluent,ChunkEncodingSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ChunkEncodingSpec build() {
    ChunkEncodingSpec buildable = new ChunkEncodingSpec(fluent.getFloats());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}