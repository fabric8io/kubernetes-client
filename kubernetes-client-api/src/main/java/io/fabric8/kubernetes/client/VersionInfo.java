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
package io.fabric8.kubernetes.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
public class VersionInfo {
  public static final class VersionKeys {
    private VersionKeys() {
    }

    public static final String BUILD_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ssX";
  }

  private String major;
  private String minor;
  private Integer emulationMajor;
  private Integer emulationMinor;
  private Integer minCompatibilityMajor;
  private Integer minCompatibilityMinor;
  private String gitCommit;
  private String gitVersion;
  private String gitTreeState;
  private Date buildDate;
  private String goVersion;
  private String compiler;
  private String platform;

  private VersionInfo() {
  }

  public static final class Builder {
    private String major;
    private String minor;
    private Integer emulationMajor;
    private Integer emulationMinor;
    private Integer minCompatibilityMajor;
    private Integer minCompatibilityMinor;
    private String gitCommit;
    private String gitVersion;
    private String gitTreeState;
    private Date buildDate;
    private String goVersion;
    private String compiler;
    private String platform;

    public Builder() {
    }

    public Builder(VersionInfo versionInfo) {
      if (versionInfo != null) {
        this.major = versionInfo.getMajor();
        this.minor = versionInfo.getMinor();
        this.emulationMajor = versionInfo.getEmulationMajor();
        this.emulationMinor = versionInfo.getEmulationMinor();
        this.minCompatibilityMajor = versionInfo.getMinCompatibilityMajor();
        this.minCompatibilityMinor = versionInfo.getMinCompatibilityMinor();
        this.gitCommit = versionInfo.getGitCommit();
        this.gitVersion = versionInfo.getGitVersion();
        this.gitTreeState = versionInfo.getGitTreeState();
        this.buildDate = versionInfo.getBuildDate();
        this.goVersion = versionInfo.getGoVersion();
        this.compiler = versionInfo.getCompiler();
        this.platform = versionInfo.getPlatform();
      }
    }

    public Builder withBuildDate(String buildDate) throws ParseException {
      if (buildDate != null) {
        this.buildDate = new SimpleDateFormat(VersionKeys.BUILD_DATE_FORMAT).parse(buildDate);
      }
      return this;
    }

    public Builder withMajor(String major) {
      this.major = major;
      return this;
    }

    public Builder withMinor(String minor) {
      this.minor = minor;
      return this;
    }

    public Builder withEmulationMajor(Integer emulationMajor) {
      this.emulationMajor = emulationMajor;
      return this;
    }

    public Builder withEmulationMinor(Integer emulationMinor) {
      this.emulationMinor = emulationMinor;
      return this;
    }

    public Builder withMinCompatibilityMajor(Integer minCompatibilityMajor) {
      this.minCompatibilityMajor = minCompatibilityMajor;
      return this;
    }

    public Builder withMinCompatibilityMinor(Integer minCompatibilityMinor) {
      this.minCompatibilityMinor = minCompatibilityMinor;
      return this;
    }

    public Builder withGitCommit(String gitCommit) {
      this.gitCommit = gitCommit;
      return this;
    }

    public Builder withGitVersion(String gitVersion) {
      this.gitVersion = gitVersion;
      return this;
    }

    public Builder withGitTreeState(String gitTreeState) {
      this.gitTreeState = gitTreeState;
      return this;
    }

    public Builder withBuildDate(Date buildDate) {
      this.buildDate = buildDate;
      return this;
    }

    public Builder withGoVersion(String goVersion) {
      this.goVersion = goVersion;
      return this;
    }

    public Builder withCompiler(String compiler) {
      this.compiler = compiler;
      return this;
    }

    public Builder withPlatform(String platform) {
      this.platform = platform;
      return this;
    }

    public VersionInfo build() {
      VersionInfo versionInfo = new VersionInfo();
      versionInfo.compiler = this.compiler;
      versionInfo.gitCommit = this.gitCommit;
      versionInfo.minCompatibilityMajor = this.minCompatibilityMajor;
      versionInfo.goVersion = this.goVersion;
      versionInfo.platform = this.platform;
      versionInfo.gitVersion = this.gitVersion;
      versionInfo.major = this.major;
      versionInfo.emulationMajor = this.emulationMajor;
      versionInfo.emulationMinor = this.emulationMinor;
      versionInfo.minor = this.minor;
      versionInfo.minCompatibilityMinor = this.minCompatibilityMinor;
      versionInfo.gitTreeState = this.gitTreeState;
      versionInfo.buildDate = this.buildDate;
      return versionInfo;
    }
  }
}
