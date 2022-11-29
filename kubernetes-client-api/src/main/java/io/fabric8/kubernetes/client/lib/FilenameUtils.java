// Partial Copy of commons-io https://github.com/apache/commons-io/blob/29b70e156f9241b0c3e25896c931d1ef8725ad66/src/main/java/org/apache/commons/io/FilenameUtils.java
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

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * General file name and file path manipulation utilities.
 * <p>
 * When dealing with file names you can hit problems when moving from a Windows
 * based development machine to a Unix based production machine.
 * This class aims to help avoid those problems.
 * <p>
 * <b>NOTE</b>: You may be able to avoid using this class entirely simply by
 * using JDK {@link java.io.File File} objects and the two argument constructor
 * {@link java.io.File#File(java.io.File, java.lang.String) File(File,String)}.
 * <p>
 * Most methods on this class are designed to work the same on both Unix and Windows.
 * Those that don't include 'System', 'Unix' or 'Windows' in their name.
 * <p>
 * Most methods recognize both separators (forward and back), and both
 * sets of prefixes. See the Javadoc of each method for details.
 * <p>
 * This class defines six components within a file name
 * (example C:\dev\project\file.txt):
 * <ul>
 * <li>the prefix - C:\</li>
 * <li>the path - dev\project\</li>
 * <li>the full path - C:\dev\project\</li>
 * <li>the name - file.txt</li>
 * <li>the base name - file</li>
 * <li>the extension - txt</li>
 * </ul>
 * Note that this class works best if directory file names end with a separator.
 * If you omit the last separator, it is impossible to determine if the file name
 * corresponds to a file or a directory. As a result, we have chosen to say
 * it corresponds to a file.
 * <p>
 * This class only supports Unix and Windows style names.
 * Prefixes are matched as follows:
 * <pre>
 * Windows:
 * a\b\c.txt           --&gt; ""          --&gt; relative
 * \a\b\c.txt          --&gt; "\"         --&gt; current drive absolute
 * C:a\b\c.txt         --&gt; "C:"        --&gt; drive relative
 * C:\a\b\c.txt        --&gt; "C:\"       --&gt; absolute
 * \\server\a\b\c.txt  --&gt; "\\server\" --&gt; UNC
 *
 * Unix:
 * a/b/c.txt           --&gt; ""          --&gt; relative
 * /a/b/c.txt          --&gt; "/"         --&gt; absolute
 * ~/a/b/c.txt         --&gt; "~/"        --&gt; current user
 * ~                   --&gt; "~/"        --&gt; current user (slash added)
 * ~user/a/b/c.txt     --&gt; "~user/"    --&gt; named user
 * ~user               --&gt; "~user/"    --&gt; named user (slash added)
 * </pre>
 * Both prefix styles are matched always, irrespective of the machine that you are
 * currently running on.
 * <p>
 * Origin of code: Excalibur, Alexandria, Tomcat, Commons-Utils.
 *
 * @since 1.1
 */
public class FilenameUtils {

  private static final String[] EMPTY_STRING_ARRAY = new String[0];

  private static final String EMPTY_STRING = "";

  private static final int NOT_FOUND = -1;

  /**
   * The Unix separator character.
   */
  private static final char UNIX_SEPARATOR = '/';

  /**
   * The Windows separator character.
   */
  private static final char WINDOWS_SEPARATOR = '\\';

  /**
   * The system separator character.
   */
  private static final char SYSTEM_SEPARATOR = File.separatorChar;

  /**
   * The separator character that is the opposite of the system separator.
   */
  private static final char OTHER_SEPARATOR;
  static {
    if (isSystemWindows()) {
      OTHER_SEPARATOR = UNIX_SEPARATOR;
    } else {
      OTHER_SEPARATOR = WINDOWS_SEPARATOR;
    }
  }

  /**
   * Instances should NOT be constructed in standard programming.
   */
  private FilenameUtils() {
  }

  //-----------------------------------------------------------------------
  /**
   * Determines if Windows file system is in use.
   *
   * @return true if the system is Windows
   */
  static boolean isSystemWindows() {
    return SYSTEM_SEPARATOR == WINDOWS_SEPARATOR;
  }

  //-----------------------------------------------------------------------
  /**
   * Checks if the character is a separator.
   *
   * @param ch the character to check
   * @return true if it is a separator character
   */
  private static boolean isSeparator(final char ch) {
    return ch == UNIX_SEPARATOR || ch == WINDOWS_SEPARATOR;
  }

  //-----------------------------------------------------------------------
  /**
   * Normalizes a path, removing double and single dot path steps.
   * <p>
   * This method normalizes a path to a standard format.
   * The input may contain separators in either Unix or Windows format.
   * The output will contain separators in the format of the system.
   * <p>
   * A trailing slash will be retained.
   * A double slash will be merged to a single slash (but UNC names are handled).
   * A single dot path segment will be removed.
   * A double dot will cause that path segment and the one before to be removed.
   * If the double dot has no parent path segment to work with, {@code null}
   * is returned.
   * <p>
   * The output will be the same on both Unix and Windows except
   * for the separator character.
   * <pre>
   * /foo//               --&gt;   /foo/
   * /foo/./              --&gt;   /foo/
   * /foo/../bar          --&gt;   /bar
   * /foo/../bar/         --&gt;   /bar/
   * /foo/../bar/../baz   --&gt;   /baz
   * //foo//./bar         --&gt;   /foo/bar
   * /../                 --&gt;   null
   * ../foo               --&gt;   null
   * foo/bar/..           --&gt;   foo/
   * foo/../../bar        --&gt;   null
   * foo/../bar           --&gt;   bar
   * //server/foo/../bar  --&gt;   //server/bar
   * //server/../bar      --&gt;   null
   * C:\foo\..\bar        --&gt;   C:\bar
   * C:\..\bar            --&gt;   null
   * ~/foo/../bar/        --&gt;   ~/bar/
   * ~/../bar             --&gt;   null
   * </pre>
   * (Note the file separator returned will be correct for Windows/Unix)
   *
   * @param fileName the fileName to normalize, null returns null
   * @return the normalized fileName, or null if invalid. Null bytes inside string will be removed
   */
  public static String normalize(final String fileName) {
    return doNormalize(fileName, SYSTEM_SEPARATOR, true);
  }

  /**
   * Normalizes a path, removing double and single dot path steps,
   * and removing any final directory separator.
   * <p>
   * This method normalizes a path to a standard format.
   * The input may contain separators in either Unix or Windows format.
   * The output will contain separators in the format specified.
   * <p>
   * A trailing slash will be removed.
   * A double slash will be merged to a single slash (but UNC names are handled).
   * A single dot path segment will be removed.
   * A double dot will cause that path segment and the one before to be removed.
   * If the double dot has no parent path segment to work with, {@code null}
   * is returned.
   * <p>
   * The output will be the same on both Unix and Windows including
   * the separator character.
   * <pre>
   * /foo//               --&gt;   /foo
   * /foo/./              --&gt;   /foo
   * /foo/../bar          --&gt;   /bar
   * /foo/../bar/         --&gt;   /bar
   * /foo/../bar/../baz   --&gt;   /baz
   * //foo//./bar         --&gt;   /foo/bar
   * /../                 --&gt;   null
   * ../foo               --&gt;   null
   * foo/bar/..           --&gt;   foo
   * foo/../../bar        --&gt;   null
   * foo/../bar           --&gt;   bar
   * //server/foo/../bar  --&gt;   //server/bar
   * //server/../bar      --&gt;   null
   * C:\foo\..\bar        --&gt;   C:\bar
   * C:\..\bar            --&gt;   null
   * ~/foo/../bar/        --&gt;   ~/bar
   * ~/../bar             --&gt;   null
   * </pre>
   *
   * @param fileName the fileName to normalize, null returns null
   * @param unixSeparator {@code true} if a unix separator should
   *        be used or {@code false} if a windows separator should be used.
   * @return the normalized fileName, or null if invalid. Null bytes inside string will be removed
   * @since 2.0
   */
  public static String normalizeNoEndSeparator(final String fileName, final boolean unixSeparator) {
    final char separator = unixSeparator ? UNIX_SEPARATOR : WINDOWS_SEPARATOR;
    return doNormalize(fileName, separator, false);
  }

  /**
   * Internal method to perform the normalization.
   *
   * @param fileName the fileName
   * @param separator The separator character to use
   * @param keepSeparator true to keep the final separator
   * @return the normalized fileName. Null bytes inside string will be removed.
   */
  private static String doNormalize(final String fileName, final char separator, final boolean keepSeparator) {
    if (fileName == null) {
      return null;
    }

    requireNonNullChars(fileName);

    int size = fileName.length();
    if (size == 0) {
      return fileName;
    }
    final int prefix = getPrefixLength(fileName);
    if (prefix < 0) {
      return null;
    }

    final char[] array = new char[size + 2]; // +1 for possible extra slash, +2 for arraycopy
    fileName.getChars(0, fileName.length(), array, 0);

    // fix separators throughout
    final char otherSeparator = separator == SYSTEM_SEPARATOR ? OTHER_SEPARATOR : SYSTEM_SEPARATOR;
    for (int i = 0; i < array.length; i++) {
      if (array[i] == otherSeparator) {
        array[i] = separator;
      }
    }

    // add extra separator on the end to simplify code below
    boolean lastIsDirectory = true;
    if (array[size - 1] != separator) {
      array[size++] = separator;
      lastIsDirectory = false;
    }

    // adjoining slashes
    for (int i = prefix + 1; i < size; i++) {
      if (array[i] == separator && array[i - 1] == separator) {
        System.arraycopy(array, i, array, i - 1, size - i);
        size--;
        i--;
      }
    }

    // dot slash
    for (int i = prefix + 1; i < size; i++) {
      if (array[i] == separator && array[i - 1] == '.' &&
          (i == prefix + 1 || array[i - 2] == separator)) {
        if (i == size - 1) {
          lastIsDirectory = true;
        }
        System.arraycopy(array, i + 1, array, i - 1, size - i);
        size -= 2;
        i--;
      }
    }

    // double dot slash
    outer: for (int i = prefix + 2; i < size; i++) {
      if (array[i] == separator && array[i - 1] == '.' && array[i - 2] == '.' &&
          (i == prefix + 2 || array[i - 3] == separator)) {
        if (i == prefix + 2) {
          return null;
        }
        if (i == size - 1) {
          lastIsDirectory = true;
        }
        int j;
        for (j = i - 4; j >= prefix; j--) {
          if (array[j] == separator) {
            // remove b/../ from a/b/../c
            System.arraycopy(array, i + 1, array, j + 1, size - i);
            size -= i - j;
            i = j + 1;
            continue outer;
          }
        }
        // remove a/../ from a/../c
        System.arraycopy(array, i + 1, array, prefix, size - i);
        size -= i + 1 - prefix;
        i = prefix + 1;
      }
    }

    if (size <= 0) { // should never be less than 0
      return EMPTY_STRING;
    }
    if (size <= prefix) { // should never be less than prefix
      return new String(array, 0, size);
    }
    if (lastIsDirectory && keepSeparator) {
      return new String(array, 0, size); // keep trailing separator
    }
    return new String(array, 0, size - 1); // lose trailing separator
  }

  /**
   * Converts all separators to the Unix separator of forward slash.
   *
   * @param path the path to be changed, null ignored
   * @return the updated path
   */
  public static String separatorsToUnix(final String path) {
    if (path == null || path.indexOf(WINDOWS_SEPARATOR) == NOT_FOUND) {
      return path;
    }
    return path.replace(WINDOWS_SEPARATOR, UNIX_SEPARATOR);
  }

  /**
   * Converts all separators to the Windows separator of backslash.
   *
   * @param path the path to be changed, null ignored
   * @return the updated path
   */
  public static String separatorsToWindows(final String path) {
    if (path == null || path.indexOf(UNIX_SEPARATOR) == NOT_FOUND) {
      return path;
    }
    return path.replace(UNIX_SEPARATOR, WINDOWS_SEPARATOR);
  }

  /**
   * Converts all separators to the system separator.
   *
   * @param path the path to be changed, null ignored
   * @return the updated path
   */
  public static String separatorsToSystem(final String path) {
    if (path == null) {
      return null;
    }
    return isSystemWindows() ? separatorsToWindows(path) : separatorsToUnix(path);
  }

  /**
   * Returns the length of the fileName prefix, such as {@code C:/} or {@code ~/}.
   * <p>
   * This method will handle a file in either Unix or Windows format.
   * <p>
   * The prefix length includes the first slash in the full fileName
   * if applicable. Thus, it is possible that the length returned is greater
   * than the length of the input string.
   * <pre>
   * Windows:
   * a\b\c.txt           --&gt; 0           --&gt; relative
   * \a\b\c.txt          --&gt; 1           --&gt; current drive absolute
   * C:a\b\c.txt         --&gt; 2           --&gt; drive relative
   * C:\a\b\c.txt        --&gt; 3           --&gt; absolute
   * \\server\a\b\c.txt  --&gt; 9           --&gt; UNC
   * \\\a\b\c.txt        --&gt; -1          --&gt; error
   *
   * Unix:
   * a/b/c.txt           --&gt; 0           --&gt; relative
   * /a/b/c.txt          --&gt; 1           --&gt; absolute
   * ~/a/b/c.txt         --&gt; 2           --&gt; current user
   * ~                   --&gt; 2           --&gt; current user (slash added)
   * ~user/a/b/c.txt     --&gt; 6           --&gt; named user
   * ~user               --&gt; 6           --&gt; named user (slash added)
   * //server/a/b/c.txt  --&gt; 9
   * ///a/b/c.txt        --&gt; -1          --&gt; error
   * C:                  --&gt; 0           --&gt; valid filename as only null byte and / are reserved characters
   * </pre>
   * <p>
   * The output will be the same irrespective of the machine that the code is running on.
   * ie. both Unix and Windows prefixes are matched regardless.
   *
   * Note that a leading // (or \\) is used to indicate a UNC name on Windows.
   * These must be followed by a server name, so double-slashes are not collapsed
   * to a single slash at the start of the fileName.
   *
   * @param fileName the fileName to find the prefix in, null returns -1
   * @return the length of the prefix, -1 if invalid or null
   */
  public static int getPrefixLength(final String fileName) {
    if (fileName == null) {
      return NOT_FOUND;
    }
    final int len = fileName.length();
    if (len == 0) {
      return 0;
    }
    char ch0 = fileName.charAt(0);
    if (ch0 == ':') {
      return NOT_FOUND;
    }
    if (len == 1) {
      if (ch0 == '~') {
        return 2; // return a length greater than the input
      }
      return isSeparator(ch0) ? 1 : 0;
    }
    if (ch0 == '~') {
      int posUnix = fileName.indexOf(UNIX_SEPARATOR, 1);
      int posWin = fileName.indexOf(WINDOWS_SEPARATOR, 1);
      if (posUnix == NOT_FOUND && posWin == NOT_FOUND) {
        return len + 1; // return a length greater than the input
      }
      posUnix = posUnix == NOT_FOUND ? posWin : posUnix;
      posWin = posWin == NOT_FOUND ? posUnix : posWin;
      return Math.min(posUnix, posWin) + 1;
    }
    final char ch1 = fileName.charAt(1);
    if (ch1 == ':') {
      ch0 = Character.toUpperCase(ch0);
      if (ch0 >= 'A' && ch0 <= 'Z') {
        if (len == 2 && !FileSystem.getCurrent().supportsDriveLetter()) {
          return 0;
        }
        if (len == 2 || !isSeparator(fileName.charAt(2))) {
          return 2;
        }
        return 3;
      } else if (ch0 == UNIX_SEPARATOR) {
        return 1;
      }
      return NOT_FOUND;

    } else if (isSeparator(ch0) && isSeparator(ch1)) {
      int posUnix = fileName.indexOf(UNIX_SEPARATOR, 2);
      int posWin = fileName.indexOf(WINDOWS_SEPARATOR, 2);
      if (posUnix == NOT_FOUND && posWin == NOT_FOUND || posUnix == 2 || posWin == 2) {
        return NOT_FOUND;
      }
      posUnix = posUnix == NOT_FOUND ? posWin : posUnix;
      posWin = posWin == NOT_FOUND ? posUnix : posWin;
      final int pos = Math.min(posUnix, posWin) + 1;
      final String hostnamePart = fileName.substring(2, pos - 1);
      return isValidHostName(hostnamePart) ? pos : NOT_FOUND;
    } else {
      return isSeparator(ch0) ? 1 : 0;
    }
  }

  /**
   * Checks the input for null bytes, a sign of unsanitized data being passed to to file level functions.
   *
   * This may be used for poison byte attacks.
   *
   * @param path the path to check
   */
  private static void requireNonNullChars(final String path) {
    if (path.indexOf(0) >= 0) {
      throw new IllegalArgumentException("Null byte present in file/path name. There are no "
          + "known legitimate use cases for such data, but several injection attacks may use it");
    }
  }

  /**
   * Checks whether a given string is a valid host name according to
   * RFC 3986.
   *
   * <p>
   * Accepted are IP addresses (v4 and v6) as well as what the
   * RFC calls a "reg-name". Percent encoded names don't seem to be
   * valid names in UNC paths.
   * </p>
   *
   * @see "https://tools.ietf.org/html/rfc3986#section-3.2.2"
   * @param name the hostname to validate
   * @return true if the given name is a valid host name
   */
  private static boolean isValidHostName(final String name) {
    return isIPv6Address(name) || isRFC3986HostName(name);
  }

  private static final Pattern IPV4_PATTERN = Pattern.compile("^(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})$");
  private static final int IPV4_MAX_OCTET_VALUE = 255;

  /**
   * Checks whether a given string represents a valid IPv4 address.
   *
   * @param name the name to validate
   * @return true if the given name is a valid IPv4 address
   */
  // mostly copied from org.apache.commons.validator.routines.InetAddressValidator#isValidInet4Address
  private static boolean isIPv4Address(final String name) {
    final Matcher m = IPV4_PATTERN.matcher(name);
    if (!m.matches() || m.groupCount() != 4) {
      return false;
    }

    // verify that address subgroups are legal
    for (int i = 1; i <= 4; i++) {
      final String ipSegment = m.group(i);
      final int iIpSegment = Integer.parseInt(ipSegment);
      if (iIpSegment > IPV4_MAX_OCTET_VALUE) {
        return false;
      }

      if (ipSegment.length() > 1 && ipSegment.startsWith("0")) {
        return false;
      }

    }

    return true;
  }

  private static final int IPV6_MAX_HEX_GROUPS = 8;
  private static final int IPV6_MAX_HEX_DIGITS_PER_GROUP = 4;
  private static final int MAX_UNSIGNED_SHORT = 0xffff;
  private static final int BASE_16 = 16;

  // copied from org.apache.commons.validator.routines.InetAddressValidator#isValidInet6Address
  /**
   * Checks whether a given string represents a valid IPv6 address.
   *
   * @param inet6Address the name to validate
   * @return true if the given name is a valid IPv6 address
   */
  private static boolean isIPv6Address(final String inet6Address) {
    final boolean containsCompressedZeroes = inet6Address.contains("::");
    if (containsCompressedZeroes && (inet6Address.indexOf("::") != inet6Address.lastIndexOf("::"))) {
      return false;
    }
    if ((inet6Address.startsWith(":") && !inet6Address.startsWith("::"))
        || (inet6Address.endsWith(":") && !inet6Address.endsWith("::"))) {
      return false;
    }
    String[] octets = inet6Address.split(":");
    if (containsCompressedZeroes) {
      final List<String> octetList = new ArrayList<>(Arrays.asList(octets));
      if (inet6Address.endsWith("::")) {
        // String.split() drops ending empty segments
        octetList.add("");
      } else if (inet6Address.startsWith("::") && !octetList.isEmpty()) {
        octetList.remove(0);
      }
      octets = octetList.toArray(EMPTY_STRING_ARRAY);
    }
    if (octets.length > IPV6_MAX_HEX_GROUPS) {
      return false;
    }
    int validOctets = 0;
    int emptyOctets = 0; // consecutive empty chunks
    for (int index = 0; index < octets.length; index++) {
      final String octet = octets[index];
      if (octet.isEmpty()) {
        emptyOctets++;
        if (emptyOctets > 1) {
          return false;
        }
      } else {
        emptyOctets = 0;
        // Is last chunk an IPv4 address?
        if (index == octets.length - 1 && octet.contains(".")) {
          if (!isIPv4Address(octet)) {
            return false;
          }
          validOctets += 2;
          continue;
        }
        if (octet.length() > IPV6_MAX_HEX_DIGITS_PER_GROUP) {
          return false;
        }
        int octetInt = 0;
        try {
          octetInt = Integer.parseInt(octet, BASE_16);
        } catch (final NumberFormatException e) {
          return false;
        }
        if (octetInt < 0 || octetInt > MAX_UNSIGNED_SHORT) {
          return false;
        }
      }
      validOctets++;
    }
    return validOctets <= IPV6_MAX_HEX_GROUPS && (validOctets >= IPV6_MAX_HEX_GROUPS || containsCompressedZeroes);
  }

  private static final Pattern REG_NAME_PART_PATTERN = Pattern.compile("^[a-zA-Z0-9][a-zA-Z0-9-]*$");

  /**
   * Checks whether a given string is a valid host name according to
   * RFC 3986 - not accepting IP addresses.
   *
   * @see "https://tools.ietf.org/html/rfc3986#section-3.2.2"
   * @param name the hostname to validate
   * @return true if the given name is a valid host name
   */
  private static boolean isRFC3986HostName(final String name) {
    final String[] parts = name.split("\\.", -1);
    for (int i = 0; i < parts.length; i++) {
      if (parts[i].isEmpty()) {
        // trailing dot is legal, otherwise we've hit a .. sequence
        return i == parts.length - 1;
      }
      if (!REG_NAME_PART_PATTERN.matcher(parts[i]).matches()) {
        return false;
      }
    }
    return true;
  }
}
