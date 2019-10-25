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
import java.util.Map;

public class VersionInfo {
  private Map<String, String> data;
  private final class VERSION_KEYS {
    public static final String BUILD_DATE = "buildDate";
    public static final String GIT_COMMIT = "gitCommit";
    public static final String GIT_VERSION = "gitVersion";
    public static final String MAJOR = "major";
    public static final String MINOR = "minor";
    public static final String GIT_TREE_STATE = "gitTreeState";
    public static final String PLATFORM = "platform";
    public static final String GO_VERSION = "goVersion";
    public static final String COMPILER = "compiler";
    public static final String BUILD_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'";
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

  public VersionInfo(Map<String, String> jsonData) throws ParseException {
      this.data = jsonData;
      this.buildDate = new SimpleDateFormat(VERSION_KEYS.BUILD_DATE_FORMAT).parse(jsonData.get(VERSION_KEYS.BUILD_DATE));
      this.gitCommit = jsonData.get(VERSION_KEYS.GIT_COMMIT);
      this.gitVersion = jsonData.get(VERSION_KEYS.GIT_VERSION);
      this.major = jsonData.get(VERSION_KEYS.MAJOR);
      this.minor = jsonData.get(VERSION_KEYS.MINOR);
      this.gitTreeState = jsonData.get(VERSION_KEYS.GIT_TREE_STATE);
      this.platform = jsonData.get(VERSION_KEYS.PLATFORM);
      this.goVersion = jsonData.get(VERSION_KEYS.GO_VERSION);
      this.compiler = jsonData.get(VERSION_KEYS.COMPILER);
  }

  public Map<String, String> getData() { return data; }
}
