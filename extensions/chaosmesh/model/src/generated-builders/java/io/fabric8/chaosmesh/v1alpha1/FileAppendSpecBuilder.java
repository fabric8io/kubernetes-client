package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class FileAppendSpecBuilder extends FileAppendSpecFluent<FileAppendSpecBuilder> implements VisitableBuilder<FileAppendSpec,FileAppendSpecBuilder>{

  FileAppendSpecFluent<?> fluent;

  public FileAppendSpecBuilder() {
    this(new FileAppendSpec());
  }
  
  public FileAppendSpecBuilder(FileAppendSpecFluent<?> fluent) {
    this(fluent, new FileAppendSpec());
  }
  
  public FileAppendSpecBuilder(FileAppendSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public FileAppendSpecBuilder(FileAppendSpecFluent<?> fluent,FileAppendSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public FileAppendSpec build() {
    FileAppendSpec buildable = new FileAppendSpec(fluent.getCount(), fluent.getData(), fluent.getFileName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}