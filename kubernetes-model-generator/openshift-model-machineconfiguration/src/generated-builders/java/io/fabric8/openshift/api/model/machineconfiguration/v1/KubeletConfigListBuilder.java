package io.fabric8.openshift.api.model.machineconfiguration.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class KubeletConfigListBuilder extends KubeletConfigListFluent<KubeletConfigListBuilder> implements VisitableBuilder<KubeletConfigList,KubeletConfigListBuilder>{

  KubeletConfigListFluent<?> fluent;

  public KubeletConfigListBuilder() {
    this(new KubeletConfigList());
  }
  
  public KubeletConfigListBuilder(KubeletConfigListFluent<?> fluent) {
    this(fluent, new KubeletConfigList());
  }
  
  public KubeletConfigListBuilder(KubeletConfigList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public KubeletConfigListBuilder(KubeletConfigListFluent<?> fluent,KubeletConfigList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public KubeletConfigList build() {
    KubeletConfigList buildable = new KubeletConfigList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}