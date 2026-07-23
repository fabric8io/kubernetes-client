package io.fabric8.openshift.api.model.insights.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DataGatherListBuilder extends DataGatherListFluent<DataGatherListBuilder> implements VisitableBuilder<DataGatherList,DataGatherListBuilder>{

  DataGatherListFluent<?> fluent;

  public DataGatherListBuilder() {
    this(new DataGatherList());
  }
  
  public DataGatherListBuilder(DataGatherListFluent<?> fluent) {
    this(fluent, new DataGatherList());
  }
  
  public DataGatherListBuilder(DataGatherList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DataGatherListBuilder(DataGatherListFluent<?> fluent,DataGatherList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DataGatherList build() {
    DataGatherList buildable = new DataGatherList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}