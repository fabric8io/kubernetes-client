/*
 * Copyright (C) 2015 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.fabric8.kubernetes.schema.validator;

import com.atlassian.oai.validator.report.MessageResolver;
import com.atlassian.oai.validator.schema.SchemaValidator;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.parser.OpenAPIV3Parser;
import io.swagger.v3.parser.core.models.ParseOptions;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.Locale;
import java.util.Objects;

/**
 * A validator for Kubernetes resources.
 * <p>
 * The validator uses an OpenAPI schema to validate the resources.
 * <p>
 * In order to validate a resource you can use the following code snippet:
 * <pre>{@code
 *   Validator validator = Validator.newInstance();
 *   ValidationReport report = validator.validate($resource);
 *   if (report.hasErrors()) {
 *     report.getMessages().stream().map(ValidationMessage::getMessage).forEach(System.out::println);
 *   }
 * }</pre>
 */
public class Validator {

  private static final String OPENAPI_SCHEMA = "/openshift-generated.json";

  private final OpenAPI api;
  private final ObjectMapper objectMapper;
  private final SchemaValidator validator;

  private Validator(OpenAPI api) {
    this.api = api;
    objectMapper = new ObjectMapper(new YAMLFactory().disable(YAMLGenerator.Feature.USE_NATIVE_TYPE_ID));
    validator = new SchemaValidator(api, new MessageResolver());
  }

  public ValidationReport validate(String content) throws IOException {
    if (content == null) {
      return ValidationReport.EMPTY;
    }
    return validate(objectMapper.readTree(content));
  }

  public ValidationReport validate(InputStream is) throws IOException {
    if (is == null) {
      return ValidationReport.EMPTY;
    }
    return validate(objectMapper.readTree(is));
  }

  /**
   * Validates the given JSON node against the OpenAPI schema.
   *
   * @param node the JSON node to validate.
   * @return a {@link ValidationReport} containing the validation messages.
   */
  public ValidationReport validate(JsonNode node) {
    if (node == null) {
      return ValidationReport.EMPTY;
    }
    final var kind = node.path("kind");
    if (kind.isMissingNode()) {
      return ValidationReport.MISSING_KIND;
    }
    final var prefix = findPrefix(node);
    if (prefix == null) {
      return ValidationReport.MISSING_API_VERSION;
    }
    final var componentName = prefix.toLowerCase(Locale.ROOT) + "." + kind.asText().toLowerCase(Locale.ROOT);
    Schema<?> s = null;
    for (var e : api.getComponents().getSchemas().entrySet()) {
      if (Objects.equals(e.getKey().toLowerCase(Locale.ROOT), componentName)) {
        s = e.getValue();
        break;
      }
    }
    if (s == null) {
      return ValidationReport.EMPTY;
    }
    var report = validator.validate(() -> node, s, "root");
    return ValidationReport.from(report.getMessages());
  }

  private static String findPrefix(JsonNode rootNode) {
    final var apiVersion = rootNode.path("apiVersion");
    if (apiVersion.isMissingNode() || apiVersion.asText().isBlank()) {
      return null;
    }
    if (apiVersion.asText().toLowerCase(Locale.ROOT).equals("v1")) {
      return "io.k8s.api.core.v1";
    }
    final var apiVersionParts = apiVersion.asText().split("/");
    if (apiVersionParts.length != 2) {
      return null;
    }
    final var path = Arrays.asList(apiVersionParts[0].split("\\."));
    if (path.size() == 1) {
      return "io.k8s.api." + path.iterator().next() + "." + apiVersionParts[1];
    }
    Collections.reverse(path);
    return String.join(".", path) + "." + apiVersionParts[1];

  }

  /**
   * Creates a new instance of the validator.
   * <p>
   * The OpenAPI schema used for validation includes all the Kubernetes resources and the OpenShift resources.
   *
   * @return a new instance of the validator.
   */
  public static Validator newInstance() {
    try {
      final var openApiSchema = new String(Objects.requireNonNull(Validator.class.getResourceAsStream(OPENAPI_SCHEMA),
          OPENAPI_SCHEMA + " resource not found").readAllBytes(), StandardCharsets.UTF_8);
      final var options = new ParseOptions();
      for (var extension : OpenAPIV3Parser.getExtensions()) {
        var result = extension.readContents(openApiSchema, null, options);
        if (result.getOpenAPI() != null) {
          return new Validator(result.getOpenAPI());
        }
      }
    } catch (IOException ex) {
      // NO OP
    }
    throw new IllegalStateException("Failed to parse the OpenAPI schema: " + OPENAPI_SCHEMA);
  }
}
