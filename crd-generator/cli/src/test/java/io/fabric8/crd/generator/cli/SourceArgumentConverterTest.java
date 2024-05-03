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
package io.fabric8.crd.generator.cli;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SourceArgumentConverterTest {

  @Test
  void givenValidCustomResourceClassArgument_thenConvertToCustomResourceClassArgument() {
    SourceParameterTypeConverter converter = new SourceParameterTypeConverter();
    SourceParameter sourceParameter = converter.convert("com.example.MyValidClassName");
    assertInstanceOf(SourceParameter.CustomResourceClass.class, sourceParameter);
    SourceParameter.CustomResourceClass customResourceClassArg = (SourceParameter.CustomResourceClass) sourceParameter;
    assertEquals("com.example.MyValidClassName", customResourceClassArg.getCustomResourceClass());
  }

  @Test
  void givenExistingFile_thenConvertToFileToScanArgument(@TempDir File tempDir) throws IOException {
    File exampleFile = new File(tempDir, "example-file.txt");
    Files.write(exampleFile.toPath(), Collections.singletonList("some-content"));

    SourceParameterTypeConverter converter = new SourceParameterTypeConverter();
    SourceParameter sourceParameter = converter.convert(exampleFile.getAbsolutePath());
    assertInstanceOf(SourceParameter.FileToScan.class, sourceParameter);
    SourceParameter.FileToScan fileToScanArg = (SourceParameter.FileToScan) sourceParameter;
    assertEquals(exampleFile, fileToScanArg.getFileToScan());
  }

  @Test
  void givenNotExistingFileAndInvalidCustomResourceClass_thenFail() {
    SourceParameterTypeConverter converter = new SourceParameterTypeConverter();

    assertThrows(IllegalArgumentException.class, () -> {
      converter.convert("Not-Existing.txt");
    });
  }

  @Test
  void givenValidClassName_whenCheckFQCN_thenTrue() {
    assertTrue(SourceParameterTypeConverter.isFQCN("MyClass"));
    assertTrue(SourceParameterTypeConverter.isFQCN("com.MyClass"));
    assertTrue(SourceParameterTypeConverter.isFQCN("com.example.MyClass"));
  }

  @Test
  void givenInvalidClassName_whenCheckFQCN_thenFalse() {
    assertFalse(SourceParameterTypeConverter.isFQCN("com.my-example.MyClass"));
    assertFalse(SourceParameterTypeConverter.isFQCN("com.example.My-Class"));
  }
}
