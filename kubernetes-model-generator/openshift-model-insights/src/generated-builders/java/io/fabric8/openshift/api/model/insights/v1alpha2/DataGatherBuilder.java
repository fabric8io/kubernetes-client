package io.fabric8.openshift.api.model.insights.v1alpha2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DataGatherBuilder extends DataGatherFluent<DataGatherBuilder> implements VisitableBuilder<DataGather,DataGatherBuilder>{

  DataGatherFluent<?> fluent;

  public DataGatherBuilder() {
    this(new DataGather());
  }
  
  public DataGatherBuilder(DataGatherFluent<?> fluent) {
    this(fluent, new DataGather());
  }
  
  public DataGatherBuilder(DataGather instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DataGatherBuilder(DataGatherFluent<?> fluent,DataGather instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DataGather build() {
    DataGather buildable = new DataGather(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}