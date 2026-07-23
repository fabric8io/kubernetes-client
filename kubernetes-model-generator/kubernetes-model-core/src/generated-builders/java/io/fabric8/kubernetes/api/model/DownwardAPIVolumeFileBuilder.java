package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DownwardAPIVolumeFileBuilder extends DownwardAPIVolumeFileFluent<DownwardAPIVolumeFileBuilder> implements VisitableBuilder<DownwardAPIVolumeFile,DownwardAPIVolumeFileBuilder>{

  DownwardAPIVolumeFileFluent<?> fluent;

  public DownwardAPIVolumeFileBuilder() {
    this(new DownwardAPIVolumeFile());
  }
  
  public DownwardAPIVolumeFileBuilder(DownwardAPIVolumeFileFluent<?> fluent) {
    this(fluent, new DownwardAPIVolumeFile());
  }
  
  public DownwardAPIVolumeFileBuilder(DownwardAPIVolumeFile instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DownwardAPIVolumeFileBuilder(DownwardAPIVolumeFileFluent<?> fluent,DownwardAPIVolumeFile instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DownwardAPIVolumeFile build() {
    DownwardAPIVolumeFile buildable = new DownwardAPIVolumeFile(fluent.buildFieldRef(), fluent.getMode(), fluent.getPath(), fluent.buildResourceFieldRef());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}