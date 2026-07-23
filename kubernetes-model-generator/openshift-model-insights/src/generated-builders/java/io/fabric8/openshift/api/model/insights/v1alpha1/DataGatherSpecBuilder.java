package io.fabric8.openshift.api.model.insights.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DataGatherSpecBuilder extends DataGatherSpecFluent<DataGatherSpecBuilder> implements VisitableBuilder<DataGatherSpec,DataGatherSpecBuilder>{

  DataGatherSpecFluent<?> fluent;

  public DataGatherSpecBuilder() {
    this(new DataGatherSpec());
  }
  
  public DataGatherSpecBuilder(DataGatherSpecFluent<?> fluent) {
    this(fluent, new DataGatherSpec());
  }
  
  public DataGatherSpecBuilder(DataGatherSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DataGatherSpecBuilder(DataGatherSpecFluent<?> fluent,DataGatherSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DataGatherSpec build() {
    DataGatherSpec buildable = new DataGatherSpec(fluent.getDataPolicy(), fluent.buildGatherers(), fluent.buildStorage());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}