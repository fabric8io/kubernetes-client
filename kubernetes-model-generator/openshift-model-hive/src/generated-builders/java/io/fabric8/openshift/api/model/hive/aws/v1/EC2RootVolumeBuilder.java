package io.fabric8.openshift.api.model.hive.aws.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EC2RootVolumeBuilder extends EC2RootVolumeFluent<EC2RootVolumeBuilder> implements VisitableBuilder<EC2RootVolume,EC2RootVolumeBuilder>{

  EC2RootVolumeFluent<?> fluent;

  public EC2RootVolumeBuilder() {
    this(new EC2RootVolume());
  }
  
  public EC2RootVolumeBuilder(EC2RootVolumeFluent<?> fluent) {
    this(fluent, new EC2RootVolume());
  }
  
  public EC2RootVolumeBuilder(EC2RootVolume instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EC2RootVolumeBuilder(EC2RootVolumeFluent<?> fluent,EC2RootVolume instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EC2RootVolume build() {
    EC2RootVolume buildable = new EC2RootVolume(fluent.getIops(), fluent.getKmsKeyARN(), fluent.getSize(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}