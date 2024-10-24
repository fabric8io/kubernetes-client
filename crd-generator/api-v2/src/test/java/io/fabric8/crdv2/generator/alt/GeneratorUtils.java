package io.fabric8.crdv2.generator.alt;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceColumnDefinition;
import io.fabric8.kubernetes.client.CustomResource;

public class GeneratorUtils {

  public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

  public static <T> T convertValue(Object obj, Class<T> clazz) {
    return OBJECT_MAPPER.convertValue(obj, clazz);
  }

  public static String emptyToNull(String value) {
    return Optional.ofNullable(value).filter(s -> !s.isEmpty()).orElse(null);
  }

  public static List<CustomResourceColumnDefinition> getPrinterColumns(Class<? extends CustomResource<?, ?>> crdClass) {
    AdditionalPrinterColumn[] annotations = crdClass.getAnnotationsByType(AdditionalPrinterColumn.class);
    return Stream.of(annotations).map(ann -> {
      CustomResourceColumnDefinition ret = new CustomResourceColumnDefinition().edit()
          .withName(ann.name())
          .withJsonPath(ann.jsonPath())
          .withType(ann.type().value)
          .build();
      if (ann.format() != AdditionalPrinterColumn.Format.NONE) {
        ret.setFormat(ann.format().value);
      }
      if (!ann.description().isEmpty()) {
        ret.setDescription(ann.description());
      }
      if (ann.priority() != 0) {
        ret.setPriority(ann.priority());
      }
      return ret;
    }).collect(Collectors.toList());
  }
}
