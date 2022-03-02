/**
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
package io.fabric8.java.generator.testing;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import com.github.difflib.text.DiffRow;
import com.github.difflib.text.DiffRowGenerator;
import io.fabric8.zjsonpatch.JsonDiff;
import io.fabric8.zjsonpatch.JsonPatch;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class KubernetesResourceDiff {

  // ANSI colors for the shell
  private static final String ANSI_RESET = "\u001B[0m";
  private static final String ANSI_RED = "\u001B[31m";
  private static final String ANSI_GREEN = "\u001B[32m";

  private final String source1;
  private final String source2;

  private ObjectMapper yamlMapper = new ObjectMapper(
      new YAMLFactory().disable(YAMLGenerator.Feature.WRITE_DOC_START_MARKER));

  public KubernetesResourceDiff(String source1, String source2) {
    this.source1 = source1;
    this.source2 = source2;
  }

  public List<JsonNode> getListOfDiffs() {
    try {
      JsonNode source1Json = yamlMapper.readTree(this.source1);
      JsonNode source2Json = yamlMapper.readTree(this.source2);
      JsonNode diff = JsonDiff.asJson(source1Json, source2Json);
      List<JsonNode> aggregatedDiffs = StreamSupport.stream(diff.spliterator(), false).collect(Collectors.toList());

      if (!aggregatedDiffs.isEmpty()) {
        JsonNode generatedDiff = JsonPatch.apply(diff, source1Json);

        DiffRowGenerator generator = DiffRowGenerator.create()
            .showInlineDiffs(true)
            .inlineDiffByWord(true)
            .oldTag(b -> Boolean.TRUE.equals(b) ? ANSI_RED : ANSI_RESET)
            .newTag(b -> Boolean.TRUE.equals(b) ? ANSI_GREEN : ANSI_RESET)
            .build();

        List<DiffRow> rows = generator.generateDiffRows(
            Arrays.asList(
                yamlMapper.writeValueAsString(source1Json).split("\n")),
            Arrays.asList(
                yamlMapper.writeValueAsString(generatedDiff).split("\n")));

        int maxWidth = 0;
        for (DiffRow row : rows) {
          maxWidth = Math.max(
              maxWidth,
              Math.max(
                  row.getOldLine()
                      .getBytes(StandardCharsets.UTF_8).length,
                  row.getNewLine()
                      .getBytes(StandardCharsets.UTF_8).length));
        }

        // Result should looks similar to: https://www.yamldiff.com/
        for (DiffRow row : rows) {
          System.err.printf(
              "%-" + maxWidth + "s %-" + maxWidth + "s\n",
              row.getOldLine(),
              row.getNewLine());
        }
      }

      return aggregatedDiffs;
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
