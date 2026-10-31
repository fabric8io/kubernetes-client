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
package io.fabric8.crdv2.generator;

import io.fabric8.crd.generator.annotation.PrinterColumn;
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceColumnDefinition;
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinition;
import io.fabric8.kubernetes.client.CustomResource;
import io.fabric8.kubernetes.client.utils.KubernetesSerialization;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Instant;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

class PrinterColumnTypeTest {

  @TempDir
  File tempDir;

  @Test
  @DisplayName("@PrinterColumn on a date or date-time property is a string column, the API server renders a date column as the age of an RFC 3339 timestamp")
  void temporalPropertiesAreStringColumns() throws IOException {
    final String crdName = CustomResourceInfo.fromClass(TemporalColumns.class).crdName();
    final CRDGenerationInfo info = new CRDGenerator()
        .inOutputDir(tempDir)
        .customResourceClasses(TemporalColumns.class)
        .forCRDVersions("v1")
        .detailedGenerate();

    final CustomResourceDefinition crd;
    try (InputStream is = Files.newInputStream(Path.of(info.getCRDInfos(crdName).get("v1").getFilePath()))) {
      crd = new KubernetesSerialization().unmarshal(is, CustomResourceDefinition.class);
    }

    assertThat(crd.getSpec().getVersions().get(0).getAdditionalPrinterColumns())
        .extracting(CustomResourceColumnDefinition::getJsonPath, CustomResourceColumnDefinition::getType)
        .containsExactly(
            tuple(".spec.instant", "string"),
            tuple(".spec.localDate", "string"),
            tuple(".spec.sqlDate", "string"));
  }

  @Group("sample.fabric8.io")
  @Version("v1")
  public static class TemporalColumns extends CustomResource<TemporalColumnsSpec, Void> {
  }

  public static class TemporalColumnsSpec {
    @PrinterColumn
    public Instant instant;
    @PrinterColumn
    public LocalDate localDate;
    @PrinterColumn
    public java.sql.Date sqlDate;
  }
}
