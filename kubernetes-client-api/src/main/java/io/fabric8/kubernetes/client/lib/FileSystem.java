// Copy of https://github.com/apache/commons-io/blob/29b70e156f9241b0c3e25896c931d1ef8725ad66/src/main/java/org/apache/commons/io/FileSystem.java#
/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.fabric8.kubernetes.client.lib;

import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;

/**
 * Abstracts an OS' file system details, currently supporting the single use case of converting a file name String to a
 * legal file name with {@link #toLegalFileName(String, char)}.
 * <p>
 * The starting point of any operation is {@link #getCurrent()} which gets you the enum for the file system that matches
 * the OS hosting the running JVM.
 * </p>
 *
 * @since 2.7
 */
public enum FileSystem {

  /**
   * Generic file system.
   */
  GENERIC(false, false, Integer.MAX_VALUE, Integer.MAX_VALUE, new char[] { 0 }, new String[] {}, false),

  /**
   * Linux file system.
   */
  LINUX(true, true, 255, 4096, new char[] {
      // KEEP THIS ARRAY SORTED!
      // @formatter:off
    // ASCII NUL
    0,
    '/'
    // @formatter:on
  }, new String[] {}, false),

  /**
   * MacOS file system.
   */
  MAC_OSX(true, true, 255, 1024, new char[] {
      // KEEP THIS ARRAY SORTED!
      // @formatter:off
    // ASCII NUL
    0,
    '/',
    ':'
    // @formatter:on
  }, new String[] {}, false),

  /**
   * Windows file system.
   */
  WINDOWS(false, true, 255,
      32000, new char[] {
          // KEEP THIS ARRAY SORTED!
          // @formatter:off
    // ASCII NUL
    0,
    // 1-31 may be allowed in file streams
    1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28,
    29, 30, 31,
    '"', '*', '/', ':', '<', '>', '?', '\\', '|'
    // @formatter:on
      }, // KEEP THIS ARRAY SORTED!
      new String[] { "AUX", "COM1", "COM2", "COM3", "COM4", "COM5", "COM6", "COM7", "COM8", "COM9", "CON", "LPT1",
          "LPT2", "LPT3", "LPT4", "LPT5", "LPT6", "LPT7", "LPT8", "LPT9", "NUL", "PRN" },
      true);

  /**
   * <p>
   * Is {@code true} if this is Linux.
   * </p>
   * <p>
   * The field will return {@code false} if {@code OS_NAME} is {@code null}.
   * </p>
   */
  private static final boolean IS_OS_LINUX = getOsMatchesName("Linux");

  /**
   * <p>
   * Is {@code true} if this is Mac.
   * </p>
   * <p>
   * The field will return {@code false} if {@code OS_NAME} is {@code null}.
   * </p>
   */
  private static final boolean IS_OS_MAC = getOsMatchesName("Mac");

  /**
   * The prefix String for all Windows OS.
   */
  private static final String OS_NAME_WINDOWS_PREFIX = "Windows";

  /**
   * <p>
   * Is {@code true} if this is Windows.
   * </p>
   * <p>
   * The field will return {@code false} if {@code OS_NAME} is {@code null}.
   * </p>
   */
  private static final boolean IS_OS_WINDOWS = getOsMatchesName(OS_NAME_WINDOWS_PREFIX);

  /**
   * Gets the current file system.
   *
   * @return the current file system
   */
  public static FileSystem getCurrent() {
    if (IS_OS_LINUX) {
      return LINUX;
    }
    if (IS_OS_MAC) {
      return FileSystem.MAC_OSX;
    }
    if (IS_OS_WINDOWS) {
      return FileSystem.WINDOWS;
    }
    return GENERIC;
  }

  /**
   * Decides if the operating system matches.
   *
   * @param osNamePrefix
   *        the prefix for the os name
   * @return true if matches, or false if not or can't determine
   */
  private static boolean getOsMatchesName(final String osNamePrefix) {
    return isOsNameMatch(getSystemProperty("os.name"), osNamePrefix);
  }

  /**
   * <p>
   * Gets a System property, defaulting to {@code null} if the property cannot be read.
   * </p>
   * <p>
   * If a {@code SecurityException} is caught, the return value is {@code null} and a message is written to
   * {@code System.err}.
   * </p>
   *
   * @param property
   *        the system property name
   * @return the system property value or {@code null} if a security problem occurs
   */
  private static String getSystemProperty(final String property) {
    try {
      return System.getProperty(property);
    } catch (final SecurityException ex) {
      // we are not allowed to look at this property
      System.err.println("Caught a SecurityException reading the system property '" + property
          + "'; the SystemUtils property value will default to null.");
      return null;
    }
  }

  /**
   * Decides if the operating system matches.
   * <p>
   * This method is package private instead of private to support unit test invocation.
   * </p>
   *
   * @param osName
   *        the actual OS name
   * @param osNamePrefix
   *        the prefix for the expected OS name
   * @return true if matches, or false if not or can't determine
   */
  private static boolean isOsNameMatch(final String osName, final String osNamePrefix) {
    if (osName == null) {
      return false;
    }
    return osName.toUpperCase(Locale.ROOT).startsWith(osNamePrefix.toUpperCase(Locale.ROOT));
  }

  private final boolean casePreserving;
  private final boolean caseSensitive;
  private final char[] illegalFileNameChars;
  private final int maxFileNameLength;
  private final int maxPathLength;
  private final String[] reservedFileNames;
  private final boolean supportsDriveLetter;

  /**
   * Constructs a new instance.
   *
   * @param caseSensitive Whether this file system is case sensitive.
   * @param casePreserving Whether this file system is case preserving.
   * @param maxFileLength The maximum length for file names. The file name does not include folders.
   * @param maxPathLength The maximum length of the path to a file. This can include folders.
   * @param illegalFileNameChars Illegal characters for this file system.
   * @param reservedFileNames The reserved file names.
   * @param supportsDriveLetter Whether this file system support driver letters.
   */
  FileSystem(final boolean caseSensitive, final boolean casePreserving, final int maxFileLength,
      final int maxPathLength, final char[] illegalFileNameChars, final String[] reservedFileNames,
      final boolean supportsDriveLetter) {
    this.maxFileNameLength = maxFileLength;
    this.maxPathLength = maxPathLength;
    this.illegalFileNameChars = Objects.requireNonNull(illegalFileNameChars, "illegalFileNameChars");
    this.reservedFileNames = Objects.requireNonNull(reservedFileNames, "reservedFileNames");
    this.caseSensitive = caseSensitive;
    this.casePreserving = casePreserving;
    this.supportsDriveLetter = supportsDriveLetter;
  }

  /**
   * Gets a cloned copy of the illegal characters for this file system.
   *
   * @return the illegal characters for this file system.
   */
  public char[] getIllegalFileNameChars() {
    return this.illegalFileNameChars.clone();
  }

  /**
   * Gets the maximum length for file names. The file name does not include folders.
   *
   * @return the maximum length for file names.
   */
  public int getMaxFileNameLength() {
    return maxFileNameLength;
  }

  /**
   * Gets the maximum length of the path to a file. This can include folders.
   *
   * @return the maximum length of the path to a file.
   */
  public int getMaxPathLength() {
    return maxPathLength;
  }

  /**
   * Gets a cloned copy of the reserved file names.
   *
   * @return the reserved file names.
   */
  public String[] getReservedFileNames() {
    return reservedFileNames.clone();
  }

  /**
   * Whether this file system preserves case.
   *
   * @return Whether this file system preserves case.
   */
  public boolean isCasePreserving() {
    return casePreserving;
  }

  /**
   * Whether this file system is case-sensitive.
   *
   * @return Whether this file system is case-sensitive.
   */
  public boolean isCaseSensitive() {
    return caseSensitive;
  }

  /**
   * Returns {@code true} if the given character is illegal in a file name, {@code false} otherwise.
   *
   * @param c
   *        the character to test
   * @return {@code true} if the given character is illegal in a file name, {@code false} otherwise.
   */
  private boolean isIllegalFileNameChar(final char c) {
    return Arrays.binarySearch(illegalFileNameChars, c) >= 0;
  }

  /**
   * Checks if a candidate file name (without a path) such as {@code "filename.ext"} or {@code "filename"} is a
   * potentially legal file name. If the file name length exceeds {@link #getMaxFileNameLength()}, or if it contains
   * an illegal character then the check fails.
   *
   * @param candidate
   *        a candidate file name (without a path) like {@code "filename.ext"} or {@code "filename"}
   * @return {@code true} if the candidate name is legal
   */
  public boolean isLegalFileName(final CharSequence candidate) {
    if (candidate == null || candidate.length() == 0 || candidate.length() > maxFileNameLength) {
      return false;
    }
    if (isReservedFileName(candidate)) {
      return false;
    }
    for (int i = 0; i < candidate.length(); i++) {
      if (isIllegalFileNameChar(candidate.charAt(i))) {
        return false;
      }
    }
    return true;
  }

  /**
   * Returns whether the given string is a reserved file name.
   *
   * @param candidate
   *        the string to test
   * @return {@code true} if the given string is a reserved file name.
   */
  public boolean isReservedFileName(final CharSequence candidate) {
    return Arrays.binarySearch(reservedFileNames, candidate) >= 0;
  }

  /**
   * Tests whether this file system support driver letters.
   * <p>
   * Windows supports driver letters as do other operating systems. Whether these other OS's still support Java like
   * OS/2, is a different matter.
   * </p>
   *
   * @return whether this file system support driver letters.
   * @since 2.9.0
   * @see <a href="https://en.wikipedia.org/wiki/Drive_letter_assignment">Operating systems that use drive letter
   *      assignment</a>
   */
  public boolean supportsDriveLetter() {
    return supportsDriveLetter;
  }

  /**
   * Converts a candidate file name (without a path) like {@code "filename.ext"} or {@code "filename"} to a legal file
   * name. Illegal characters in the candidate name are replaced by the {@code replacement} character. If the file
   * name length exceeds {@link #getMaxFileNameLength()}, then the name is truncated to
   * {@link #getMaxFileNameLength()}.
   *
   * @param candidate
   *        a candidate file name (without a path) like {@code "filename.ext"} or {@code "filename"}
   * @param replacement
   *        Illegal characters in the candidate name are replaced by this character
   * @return a String without illegal characters
   */
  public String toLegalFileName(final String candidate, final char replacement) {
    if (isIllegalFileNameChar(replacement)) {
      throw new IllegalArgumentException(
          String.format("The replacement character '%s' cannot be one of the %s illegal characters: %s",
              // %s does not work properly with NUL
              replacement == '\0' ? "\\0" : replacement, name(), Arrays.toString(illegalFileNameChars)));
    }
    final String truncated = candidate.length() > maxFileNameLength ? candidate.substring(0, maxFileNameLength)
        : candidate;
    boolean changed = false;
    final char[] charArray = truncated.toCharArray();
    for (int i = 0; i < charArray.length; i++) {
      if (isIllegalFileNameChar(charArray[i])) {
        charArray[i] = replacement;
        changed = true;
      }
    }
    return changed ? String.valueOf(charArray) : truncated;
  }
}
