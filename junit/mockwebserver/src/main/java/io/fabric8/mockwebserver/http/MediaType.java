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
package io.fabric8.mockwebserver.http;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Compatibility layer for OkHttp.
 *
 * @deprecated should not be needed anymore
 */
@Deprecated
public class MediaType {
  private static final String TOKEN = "([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)";
  private static final String QUOTED = "\"([^\"]*)\"";
  private static final Pattern TYPE_SUBTYPE = Pattern.compile(TOKEN + "/" + TOKEN);
  private static final Pattern PARAMETER = Pattern.compile(
      ";\\s*(?:" + TOKEN + "=(?:" + TOKEN + "|" + QUOTED + "))?");

  private final String mediaType;
  private final String type;
  private final String subtype;
  private final String charset;

  public MediaType(String mediaType, String type, String subtype, String charset) {
    this.mediaType = mediaType;
    this.type = type;
    this.subtype = subtype;
    this.charset = charset;
  }

  /**
   * Returns a media type for {@code string}.
   *
   * @throws IllegalArgumentException if {@code string} is not a well-formed media type.
   */
  public static MediaType get(String mediaType) {
    Matcher typeSubtype = TYPE_SUBTYPE.matcher(mediaType);
    if (!typeSubtype.lookingAt()) {
      throw new IllegalArgumentException("No subtype found for: \"" + mediaType + '"');
    }
    final String type = typeSubtype.group(1).toLowerCase(Locale.US);
    final String subtype = typeSubtype.group(2).toLowerCase(Locale.US);

    String charset = null;
    Matcher parameter = PARAMETER.matcher(mediaType);
    for (int s = typeSubtype.end(); s < mediaType.length(); s = parameter.end()) {
      parameter.region(s, mediaType.length());
      if (!parameter.lookingAt()) {
        throw new IllegalArgumentException("Parameter is not formatted correctly: \""
            + mediaType.substring(s)
            + "\" for: \""
            + mediaType
            + '"');
      }

      final String name = parameter.group(1);
      if (name == null || !name.equalsIgnoreCase("charset")) {
        continue;
      }
      final String currentCharset = extractCharset(parameter.group(2), parameter.group(3));
      if (charset != null && !currentCharset.equalsIgnoreCase(charset)) {
        throw new IllegalArgumentException("Multiple charsets defined: \""
            + charset
            + "\" and: \""
            + currentCharset
            + "\" for: \""
            + mediaType
            + '"');
      }
      charset = currentCharset;
    }
    return new MediaType(mediaType, type, subtype, charset);
  }

  private static String extractCharset(String token, String quoted) {
    final String charsetParameter;
    if (token != null) {
      // If the token is 'single-quoted' it's invalid! But we're lenient and strip the quotes.
      charsetParameter = (token.startsWith("'") && token.endsWith("'") && token.length() > 2)
          ? token.substring(1, token.length() - 1)
          : token;
    } else {
      // Value is "double-quoted". That's valid and our regex group already strips the quotes.
      charsetParameter = quoted;
    }
    return charsetParameter;
  }

  /**
   * Returns a media type for {@code string}, or null if {@code string} is not a well-formed media
   * type.
   */
  public static MediaType parse(String string) {
    try {
      return get(string);
    } catch (Exception ex) {
      return null;
    }
  }

  /**
   * Returns the high-level media type, such as "text", "image", "audio", "video", or
   * "application".
   */
  public final String type() {
    return type;
  }

  /**
   * Returns a specific media subtype, such as "plain" or "png", "mpeg", "mp4" or "xml".
   */
  public final String subtype() {
    return subtype;
  }

  /**
   * Returns the charset of this media type, or null if this media type doesn't specify a charset.
   */
  public final String charset() {
    return charset;
  }

  @Override
  public final String toString() {
    return mediaType;
  }
}
