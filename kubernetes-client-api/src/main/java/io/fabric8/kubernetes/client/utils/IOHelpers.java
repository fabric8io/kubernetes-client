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
package io.fabric8.kubernetes.client.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.Charset;

/**
 */
public class IOHelpers {
  private IOHelpers() {
    throw new IllegalStateException("Utility class");
  }

  public static String readFully(InputStream in, Charset charset) throws IOException {
    Reader r = new BufferedReader(new InputStreamReader(in, charset));
    return readFully(r);
  }

  public static String readFully(InputStream in) throws IOException {
    return readFully(in, Charset.defaultCharset());
  }

  public static String readFully(Reader r) throws IOException {
    try (StringWriter w = new StringWriter()) {
      copy(r, w);
      return w.toString();
    }
  }

  private static void copy(Reader reader, Writer writer) throws IOException {
    char[] buffer = new char[8192];
    int len;
    for (;;) {
      len = reader.read(buffer);
      if (len > 0) {
        writer.write(buffer, 0, len);
      } else {
        writer.flush();
        break;
      }
    }
  }

  /**
   * @deprecated will be removed in future versions
   */
  @Deprecated
  public static boolean isJSONValid(String json) {
    try {
      ObjectMapper objectMapper = Serialization.jsonMapper();
      objectMapper.readTree(json);
    } catch (JsonProcessingException e) {
      return false;
    }
    return true;
  }

  /**
   * @deprecated will be removed in future versions
   */
  @Deprecated
  public static String convertYamlToJson(String yaml) {
    return Serialization.asJson(Serialization.unmarshal(yaml, JsonNode.class));
  }

  /**
   * @deprecated will be removed in future versions
   */
  @Deprecated
  public static String convertToJson(String jsonOrYaml) {
    if (isJSONValid(jsonOrYaml)) {
      return jsonOrYaml;
    }
    return convertYamlToJson(jsonOrYaml);
  }

}
