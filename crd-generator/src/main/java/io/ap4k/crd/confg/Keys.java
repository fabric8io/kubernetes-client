package io.ap4k.crd.confg;

import io.ap4k.kubernetes.config.ConfigKey;
import io.sundr.codegen.model.TypeDef;

public class Keys {

  public static final ConfigKey<TypeDef> TYPE_DEFINITION = new ConfigKey<>("TYPE_DEFINITION", TypeDef.class);
}
