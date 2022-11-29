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

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A factory that is creating a version instance for a given version string.
 * Returns {@link KubernetesVersion} instances for kubernetes versions (starts with 'v')
 * and {@link NonKubernetesVersion} otherwise.
 */
public class KubernetesVersionFactory {

  private KubernetesVersionFactory() {
  }

  public static Version create(String versionValue) {
    Version version = KubernetesVersion.FACTORY.create(versionValue);
    if (version == null) {
      version = NonKubernetesVersion.FACTORY.create(versionValue);
    }
    return version;
  }

  public interface VersionFactory<T extends Version> {
    T create(String version);
  }

  /**
   * A kubernetes version. This represents a version that starts with a 'v' followed by a numerical major version.
   * Optionally this may be followed by an 'alpha' or 'beta' qualifier and an also optional numeric minor version.
   */
  public static class KubernetesVersion extends Version {

    public static final VersionFactory<KubernetesVersion> FACTORY = new VersionFactory<KubernetesVersion>() {

      private final Pattern versionPattern = Pattern.compile("v([0-9]+)((alpha|beta)([0-9]+)?)*");

      @Override
      public KubernetesVersion create(String version) {
        if (version == null) {
          return null;
        }
        Matcher matcher = versionPattern.matcher(version);
        if (!matcher.matches()) {
          return null;
        }
        Integer majorValue = getInt(matcher.group(1));
        String qualifierValue = matcher.group(3);
        Integer minorValue = getInt(matcher.group(4));
        return new KubernetesVersion(majorValue, qualifierValue, minorValue, version);
      }

      private Integer getInt(String value) {
        if (value == null) {
          return null;
        }
        try {
          return Integer.parseInt(value);
        } catch (NumberFormatException e) {
          return null;
        }
      }
    };

    private final Integer major;
    private final Optional<String> qualifier;
    private final Optional<Integer> minor;

    private KubernetesVersion(Integer major, String qualifier, Integer minor, String version) {
      super(version);
      this.major = major;
      this.qualifier = Optional.ofNullable(qualifier);
      this.minor = Optional.ofNullable(minor);
    }

    public Integer getMajor() {
      return major;
    }

    public Optional<String> getQualifier() {
      return qualifier;
    }

    public Optional<Integer> getMinor() {
      return minor;
    }

    public boolean isStable() {
      return qualifier.orElse(null) == null;
    }

    @Override
    public boolean isKubernetes() {
      return true;
    }

    /**
     * Compares this version to another version and returns whether this version has a
     * higher, equal or lower priority than the version that it is being compared to.
     *
     * The kubernetes specs v1.17 at <a href=
     * "https://v1-17.docs.kubernetes.io/docs/tasks/access-kubernetes-api/custom-resources/custom-resource-definition-versioning/#version-priority">Version
     * Priority</a>
     * state the following:
     *
     * <ul>
     * <li>Entries that follow Kubernetes version patterns are sorted before those that do not.</li>
     * <li>For entries that follow Kubernetes version patterns, the numeric portions of the version string is sorted largest to
     * smallest.</li>
     * <li>If the strings beta or alpha follow the first numeric portion, they sorted in that order, after the equivalent string
     * without the beta
     * or alpha suffix (which is presumed to be the GA version).</li>
     * <li>If another number follows the beta, or alpha, those numbers are also sorted from largest to smallest.</li>
     * <li>Strings that don’t fit the above format are sorted alphabetically and the numeric portions are not treated specially.
     * Notice that in the example below, foo1 is sorted above foo10.
     * This is different from the sorting of the numeric portion of entries that do follow the Kubernetes version patterns.</li>
     * </ul>
     *
     * @param other the version to compare this version to
     * @return -1 if this version has a lower, 1 if it has a higher or 0 if the priorities are equal
     *
     */
    @Override
    public int compareTo(Version other) {
      if (other == this) {
        return 0;
      }
      if (other instanceof NonKubernetesVersion) {
        return 1;
      }
      if (!(other instanceof KubernetesVersion)) {
        return 1;
      }
      KubernetesVersion otherKube = (KubernetesVersion) other;
      if (qualifier.isPresent()) {
        if (!otherKube.qualifier.isPresent()) {
          return -1;
        }
        int qualifierComparison = qualifier.get().compareTo(otherKube.qualifier.orElse(null));
        if (qualifierComparison != 0) {
          return qualifierComparison;
        }
        int majorComparison = compareMajor(otherKube);
        if (majorComparison != 0) {
          return majorComparison;
        }
        return compareMinor(otherKube);
      } else {
        if (!otherKube.qualifier.isPresent()) {
          return compareMajor(otherKube);
        } else {
          return 1;
        }
      }
    }

    private int compareMajor(KubernetesVersion other) {
      return major.compareTo(other.major);
    }

    private int compareMinor(KubernetesVersion other) {
      if (minor.isPresent()) {
        if (!other.minor.isPresent()) {
          return 1;
        }
        return minor.get().compareTo(other.minor.orElse(null));
      } else {
        if (!other.minor.isPresent()) {
          return 0;
        }
        return -1;
      }
    }
  }

  /**
   * A non kubernetes version which is any version string that does not start with a 'v'.
   */
  public static class NonKubernetesVersion extends Version {

    public static final VersionFactory<NonKubernetesVersion> FACTORY = version -> {
      if (version == null) {
        return null;
      }
      return new NonKubernetesVersion(version);
    };

    private NonKubernetesVersion(String version) {
      super(version);
    }

    @Override
    public boolean isKubernetes() {
      return false;
    }

    /**
     * Non-Kubernetes versions have lower priority than kubernetes versions. Among them they're inverse-lexicographically
     * sorted.
     *
     * @param other the other version to compare to
     * @return -1 if this has a lower, 0 if equal or 1 if higher priority
     */
    @Override
    public int compareTo(Version other) {
      if (other == this) {
        return 0;
      }
      if (other instanceof KubernetesVersion) {
        return -1;
      } else if (other instanceof NonKubernetesVersion) {
        return full.compareTo(other.full) * -1; // inverse lexicographical order
      } else {
        return -1;
      }
    }
  }

  protected abstract static class Version implements Comparable<Version> {

    protected final String full;

    protected Version(String full) {
      this.full = full;
    }

    public abstract boolean isKubernetes();

    public String getFull() {
      return full;
    }

    @Override
    public String toString() {
      return full;
    }
  }

}
