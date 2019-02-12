package io.ap4k.crd.util;

import io.ap4k.deps.kubernetes.api.model.apiextensions.JSONSchemaProps;
import io.ap4k.utils.Serialization;
import io.sundr.codegen.functions.ClassTo;
import io.sundr.codegen.model.TypeDef;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JsonSchemaTest {

  @Test
  void shouldCreateJsonSchemaFromClass() {
    TypeDef person = ClassTo.TYPEDEF.apply(Person.class);
    JSONSchemaProps schema = JsonSchema.from(person);
    System.out.println(Serialization.asJson(schema));
    assertNotNull(schema);
  }

}
