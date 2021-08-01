package io.fabric8.kubernetes.api.model.apiextensions.v1;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.fabric8.kubernetes.model.util.Helper;
import org.junit.jupiter.api.Test;

import static net.javacrumbs.jsonunit.core.Option.IGNORING_ARRAY_ORDER;
import static net.javacrumbs.jsonunit.core.Option.IGNORING_EXTRA_FIELDS;
import static net.javacrumbs.jsonunit.core.Option.TREATING_NULL_AS_ABSENT;
import static net.javacrumbs.jsonunit.fluent.JsonFluentAssert.assertThatJson;

public class ConversionReviewTest {

  private final ObjectMapper objectMapper = new ObjectMapper();

  @Test
  public void conversionReviewTest() throws Exception {
    // Given
    final String originalJson = Helper.loadJson("/valid-ConversionReview.json");

    // when
    final ConversionReview conversionReview = objectMapper.readValue(originalJson, ConversionReview.class);
    final String serializedJson = objectMapper.writeValueAsString(conversionReview);

    // then
    assertThatJson(serializedJson).when(IGNORING_ARRAY_ORDER, TREATING_NULL_AS_ABSENT, IGNORING_EXTRA_FIELDS)
      .isEqualTo(originalJson);
  }
};
