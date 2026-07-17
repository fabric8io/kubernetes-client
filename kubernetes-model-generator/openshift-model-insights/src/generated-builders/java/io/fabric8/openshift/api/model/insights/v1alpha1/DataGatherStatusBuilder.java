package io.fabric8.openshift.api.model.insights.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DataGatherStatusBuilder extends DataGatherStatusFluent<DataGatherStatusBuilder> implements VisitableBuilder<DataGatherStatus,DataGatherStatusBuilder>{

  DataGatherStatusFluent<?> fluent;

  public DataGatherStatusBuilder() {
    this(new DataGatherStatus());
  }
  
  public DataGatherStatusBuilder(DataGatherStatusFluent<?> fluent) {
    this(fluent, new DataGatherStatus());
  }
  
  public DataGatherStatusBuilder(DataGatherStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DataGatherStatusBuilder(DataGatherStatusFluent<?> fluent,DataGatherStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DataGatherStatus build() {
    DataGatherStatus buildable = new DataGatherStatus(fluent.getConditions(), fluent.getDataGatherState(), fluent.getFinishTime(), fluent.buildGatherers(), fluent.buildInsightsReport(), fluent.getInsightsRequestID(), fluent.buildRelatedObjects(), fluent.getStartTime());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}