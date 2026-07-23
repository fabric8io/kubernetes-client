package io.fabric8.openshift.api.model.operatorhub.packages.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IconBuilder extends IconFluent<IconBuilder> implements VisitableBuilder<Icon,IconBuilder>{

  IconFluent<?> fluent;

  public IconBuilder() {
    this(new Icon());
  }
  
  public IconBuilder(IconFluent<?> fluent) {
    this(fluent, new Icon());
  }
  
  public IconBuilder(Icon instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IconBuilder(IconFluent<?> fluent,Icon instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Icon build() {
    Icon buildable = new Icon(fluent.getBase64data(), fluent.getMediatype());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}