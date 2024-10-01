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
package io.fabric8.kubernetes.schema.generator.schema;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.media.Schema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CrdParserTest {

  @Nested
  class SingleDocument {

    private OpenAPI singleDocument;

    @BeforeEach
    void parse() throws Exception {
      final URI uri = Objects.requireNonNull(CrdParserTest.class.getResource("/crd-parser/single-document.yaml"))
          .toURI();
      singleDocument = CrdParser.crdToOpenApi(uri);
    }

    @Test
    void parsesSingleDocument() {
      assertNotNull(singleDocument);
      // 1 list and 1 resource
      assertEquals(2, singleDocument.getComponents().getSchemas().size());
    }

    @Test
    void createsResourceNamespacedPath() {
      assertNotNull(singleDocument.getPaths().get("/apis/example.com/v1/namespaces/{namespace}/resources/{name}"));
    }

    @Test
    void createsResourceNamespacedListPath() {
      assertNotNull(singleDocument.getPaths().get("/apis/example.com/v1/namespaces/{namespace}/resources"));
    }

    @Test
    void createsResourceComponent() {
      assertNotNull(singleDocument.getComponents().getSchemas().get("com.example.resources.v1.Resource"));
    }

    @Test
    void createsListComponent() {
      assertNotNull(singleDocument.getComponents().getSchemas().get("com.example.resources.v1.ResourceList"));
    }

    @Test
    void setsReferenceToObjectMeta() {
      assertEquals("#/components/schemas/io.k8s.apimachinery.pkg.apis.meta.v1.ObjectMeta",
          ((Schema<?>) singleDocument.getComponents().getSchemas().get("com.example.resources.v1.Resource")
              .getProperties().get("metadata")).get$ref());
    }

  }

  @Nested
  class MultipleDocuments {

    private OpenAPI multipleDocuments;

    @BeforeEach
    void parse() throws Exception {
      final URI uri = Objects.requireNonNull(CrdParserTest.class.getResource("/crd-parser/multiple-documents.yaml"))
          .toURI();
      multipleDocuments = CrdParser.crdToOpenApi(uri);
    }

    @Test
    void parsesMultipleDocuments() {
      assertNotNull(multipleDocuments);
      // 1 list and 1 resource
      assertEquals(4, multipleDocuments.getComponents().getSchemas().size());
    }

    @Test
    void createsResourceNamespacedPaths() {
      assertNotNull(multipleDocuments.getPaths().get("/apis/example.com/v1/namespaces/{namespace}/resources/{name}"));
      assertNotNull(multipleDocuments.getPaths().get("/apis/example.com/v1/additional-resources/{name}"));
    }

    @Test
    void createsResourceNamespacedListPaths() {
      assertNotNull(multipleDocuments.getPaths().get("/apis/example.com/v1/namespaces/{namespace}/resources"));
      assertNotNull(multipleDocuments.getPaths().get("/apis/example.com/v1/additional-resources"));
    }

    @Test
    void createsResourceComponents() {
      assertNotNull(multipleDocuments.getComponents().getSchemas().get("com.example.resources.v1.Resource"));
      assertNotNull(
          multipleDocuments.getComponents().getSchemas().get("com.example.additional-resources.v1.AdditionalResource"));
    }

    @Test
    void createsListComponents() {
      assertNotNull(multipleDocuments.getComponents().getSchemas().get("com.example.resources.v1.ResourceList"));
      assertNotNull(
          multipleDocuments.getComponents().getSchemas().get("com.example.additional-resources.v1.AdditionalResourceList"));
    }
  }
}
