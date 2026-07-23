package io.fabric8.openshift.api.model.machine.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AlibabaCloudMachineProviderConfigListBuilder extends AlibabaCloudMachineProviderConfigListFluent<AlibabaCloudMachineProviderConfigListBuilder> implements VisitableBuilder<AlibabaCloudMachineProviderConfigList,AlibabaCloudMachineProviderConfigListBuilder>{

  AlibabaCloudMachineProviderConfigListFluent<?> fluent;

  public AlibabaCloudMachineProviderConfigListBuilder() {
    this(new AlibabaCloudMachineProviderConfigList());
  }
  
  public AlibabaCloudMachineProviderConfigListBuilder(AlibabaCloudMachineProviderConfigListFluent<?> fluent) {
    this(fluent, new AlibabaCloudMachineProviderConfigList());
  }
  
  public AlibabaCloudMachineProviderConfigListBuilder(AlibabaCloudMachineProviderConfigList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AlibabaCloudMachineProviderConfigListBuilder(AlibabaCloudMachineProviderConfigListFluent<?> fluent,AlibabaCloudMachineProviderConfigList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AlibabaCloudMachineProviderConfigList build() {
    AlibabaCloudMachineProviderConfigList buildable = new AlibabaCloudMachineProviderConfigList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}