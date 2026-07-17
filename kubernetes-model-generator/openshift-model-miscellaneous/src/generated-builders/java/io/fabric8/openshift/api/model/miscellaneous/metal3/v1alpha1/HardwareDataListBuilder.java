package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HardwareDataListBuilder extends HardwareDataListFluent<HardwareDataListBuilder> implements VisitableBuilder<HardwareDataList,HardwareDataListBuilder>{

  HardwareDataListFluent<?> fluent;

  public HardwareDataListBuilder() {
    this(new HardwareDataList());
  }
  
  public HardwareDataListBuilder(HardwareDataListFluent<?> fluent) {
    this(fluent, new HardwareDataList());
  }
  
  public HardwareDataListBuilder(HardwareDataList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HardwareDataListBuilder(HardwareDataListFluent<?> fluent,HardwareDataList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HardwareDataList build() {
    HardwareDataList buildable = new HardwareDataList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}