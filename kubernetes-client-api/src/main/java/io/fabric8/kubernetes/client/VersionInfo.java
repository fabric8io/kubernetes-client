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

package io.fabric8.kubernetes.client;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class VersionInfo {
  public static final class VersionKeys {
    private VersionKeys() {
    }

    public static final String BUILD_DATE = "buildDate";
    public static final String GIT_COMMIT = "gitCommit";
    public static final String GIT_VERSION = "gitVersion";
    public static final String MAJOR = "major";
    public static final String MINOR = "minor";
    public static final String GIT_TREE_STATE = "gitTreeState";
    public static final String PLATFORM = "platform";
    public static final String GO_VERSION = "goVersion";
    public static final String COMPILER = "compiler";
    public static final String BUILD_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ssX";
  }

  private Date buildDate;
  private String gitCommit;
  private String gitVersion;
  private String major;
  private String minor;
  private String gitTreeState;
  private String platform;
  private String goVersion;
  private String compiler;

  public Date getBuildDate() {
    return buildDate;
  }

  public String getGitCommit() {
    return gitCommit;
  }

  public String getGitVersion() {
    return gitVersion;
  }

  public String getMajor() {
    return major;
  }

  public String getMinor() {
    return minor;
  }

  public String getGitTreeState() {
    return gitTreeState;
  }

  public String getPlatform() {
    return platform;
  }

  public String getGoVersion() {
    return goVersion;
  }

  public String getCompiler() {
    return compiler;
  }

  private VersionInfo() {
  }

  public static class Builder {
    private VersionInfo versionInfo = new VersionInfo();

    public Builder() {
    }

    public Builder(VersionInfo versionInfo) {
      if (versionInfo != null) {
        this.versionInfo.buildDate = versionInfo.getBuildDate();
        this.versionInfo.gitCommit = versionInfo.getGitCommit();
        this.versionInfo.gitVersion = versionInfo.getGitVersion();
        this.versionInfo.major = versionInfo.getMajor();
        this.versionInfo.minor = versionInfo.getMinor();
        this.versionInfo.gitTreeState = versionInfo.getGitTreeState();
        this.versionInfo.platform = versionInfo.getPlatform();
        this.versionInfo.goVersion = versionInfo.getGoVersion();
        this.versionInfo.compiler = versionInfo.getCompiler();
      }
    }

    public Builder withBuildDate(String buildDate) throws ParseException {
      if (buildDate != null) {
        this.versionInfo.buildDate = new SimpleDateFormat(VersionKeys.BUILD_DATE_FORMAT).parse(buildDate);
      }
      return this;
    }

    public Builder withGitCommit(String gitCommit) {
      this.versionInfo.gitCommit = gitCommit;
      return this;
    }

    public Builder withGitVersion(String gitVersion) {
      this.versionInfo.gitVersion = gitVersion;
      return this;
    }

    public Builder withMajor(String major) {
      this.versionInfo.major = major;
      return this;
    }

    public Builder withMinor(String minor) {
      this.versionInfo.minor = minor;
      return this;
    }

    public Builder withGitTreeState(String gitTreeState) {
      this.versionInfo.gitTreeState = gitTreeState;
      return this;
    }

    public Builder withPlatform(String platform) {
      this.versionInfo.platform = platform;
      return this;
    }

    public Builder withGoVersion(String goVersion) {
      this.versionInfo.goVersion = goVersion;
      return this;
    }

    public Builder withCompiler(String compiler) {
      this.versionInfo.compiler = compiler;
      return this;
    }

    public VersionInfo build() {
      return versionInfo;
    }
  }
}
