package io.fabric8.tekton.pipeline.v1alpha1;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArrayOrStringTest {

  @Test
  public void testArrayOrStringJson() throws IOException {
    ArrayOrString is = new ArrayOrString("string-value");
    ObjectMapper mapper = new ObjectMapper();
    String json = mapper.writeValueAsString(is);
    ArrayOrString is2 = mapper.readValue(json, ArrayOrString.class);
    assertEquals(is, is2);

    is = new ArrayOrString(Arrays.asList("a", "b"));
    json = mapper.writeValueAsString(is);
    is2 = mapper.readValue(json, ArrayOrString.class);
    assertEquals(is, is2);
  }

}
