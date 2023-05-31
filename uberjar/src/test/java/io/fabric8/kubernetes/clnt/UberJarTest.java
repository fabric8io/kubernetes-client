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
package io.fabric8.kubernetes.clnt;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.w3c.dom.Document;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UberJarTest {
  private static final String OUTPUT_DIR = System.getProperty("user.dir") + File.separator + "target";
  private static final File pomFile = new File(System.getProperty("user.dir") + File.separator + "pom.xml");
  private static final String JAR_NAME_SEPARATOR = "-";
  private static final String JAR_SUFFIX = ".jar";
  private static final String ARTIFACT_ID = "kubernetes-openshift-uberjar";

  @TempDir
  public File tempDir;

  @Test
  @DisplayName("UberJar should be generated and should contain necessary files")
  void testUberJar() throws Exception {
    // Given
    String projectVersion = getProjectVersion();
    assertNotNull(projectVersion);
    String uberJarFilePath = OUTPUT_DIR + File.separator + ARTIFACT_ID + JAR_NAME_SEPARATOR + projectVersion + JAR_SUFFIX;

    // When
    File uberJar = new File(uberJarFilePath);
    File jarExtractedDir = new File(tempDir, "extractedJar");
    unzip(uberJar.getAbsolutePath(), jarExtractedDir.getAbsolutePath());

    // Then
    assertTrue(uberJar.exists());
    assertTrue(getFileInDirectory(jarExtractedDir, "io/fabric8/kubernetes/api/builder/Builder.class").exists());
    assertTrue(getFileInDirectory(jarExtractedDir, "io/fabric8/kubernetes/api/builder/Visitor.class").exists());
    assertTrue(getFileInDirectory(jarExtractedDir, "io/fabric8/kubernetes/api/model/admission").exists());
    assertTrue(getFileInDirectory(jarExtractedDir, "io/fabric8/kubernetes/api/model/apps").exists());
    assertTrue(getFileInDirectory(jarExtractedDir, "io/fabric8/kubernetes/api/model/autoscaling").exists());
    assertTrue(getFileInDirectory(jarExtractedDir, "io/fabric8/kubernetes/api/model/coordination").exists());
    assertTrue(getFileInDirectory(jarExtractedDir, "io/fabric8/kubernetes/api/model/extensions").exists());
    assertTrue(getFileInDirectory(jarExtractedDir, "io/fabric8/kubernetes/api/model/policy").exists());
    assertTrue(getFileInDirectory(jarExtractedDir, "io/fabric8/kubernetes/api/model/admissionregistration").exists());
    assertTrue(getFileInDirectory(jarExtractedDir, "io/fabric8/kubernetes/api/model/authentication").exists());
    assertTrue(getFileInDirectory(jarExtractedDir, "io/fabric8/kubernetes/api/model/batch").exists());
    assertTrue(getFileInDirectory(jarExtractedDir, "io/fabric8/kubernetes/api/model/discovery").exists());
    assertTrue(getFileInDirectory(jarExtractedDir, "io/fabric8/kubernetes/api/model/metrics").exists());
    assertTrue(getFileInDirectory(jarExtractedDir, "io/fabric8/kubernetes/api/model/rbac").exists());
    assertTrue(getFileInDirectory(jarExtractedDir, "io/fabric8/kubernetes/api/model/storage").exists());
    assertTrue(getFileInDirectory(jarExtractedDir, "io/fabric8/kubernetes/api/model/authorization").exists());
    assertTrue(getFileInDirectory(jarExtractedDir, "io/fabric8/kubernetes/client/dsl").exists());
    assertTrue(getFileInDirectory(jarExtractedDir, "META-INF/services/io.fabric8.kubernetes.client.extension.ExtensionAdapter")
        .exists());
    assertTrue(
        getFileInDirectory(jarExtractedDir, "META-INF/services/io.fabric8.kubernetes.client.ServiceToURLProvider").exists());
  }

  @Test
  void testUberJarVersioned() throws Exception {
    // Given
    String projectVersion = getProjectVersion();
    assertNotNull(projectVersion);
    String majorVersion = getMajorVersion(projectVersion);
    String minorVersion = getMinorVersion(projectVersion);
    String versionedJarFilePath = OUTPUT_DIR + File.separator + ARTIFACT_ID + JAR_NAME_SEPARATOR + projectVersion
        + JAR_NAME_SEPARATOR + "versioned" + JAR_SUFFIX;

    // When
    File uberJarVersioned = new File(versionedJarFilePath);
    File jarExtractedDir = new File(tempDir, "extractedJar");
    unzip(uberJarVersioned.getAbsolutePath(), jarExtractedDir.getAbsolutePath());

    // Then
    assertTrue(uberJarVersioned.exists());
    assertTrue(getFileInDirectory(jarExtractedDir,
        "io/fabric8/kubernetes/api/builder/v" + majorVersion + "_" + minorVersion + "/Builder.class").exists());
    assertTrue(getFileInDirectory(jarExtractedDir,
        "io/fabric8/kubernetes/api/builder/v" + majorVersion + "_" + minorVersion + "/Visitor.class").exists());
    assertTrue(getFileInDirectory(jarExtractedDir,
        "io/fabric8/kubernetes/api/model/v" + majorVersion + "_" + minorVersion + "/admission").exists());
    assertTrue(
        getFileInDirectory(jarExtractedDir, "io/fabric8/kubernetes/api/model/v" + majorVersion + "_" + minorVersion + "/apps")
            .exists());
    assertTrue(getFileInDirectory(jarExtractedDir,
        "io/fabric8/kubernetes/api/model/v" + majorVersion + "_" + minorVersion + "/autoscaling").exists());
    assertTrue(getFileInDirectory(jarExtractedDir,
        "io/fabric8/kubernetes/api/model/v" + majorVersion + "_" + minorVersion + "/coordination").exists());
    assertTrue(getFileInDirectory(jarExtractedDir,
        "io/fabric8/kubernetes/api/model/v" + majorVersion + "_" + minorVersion + "/extensions").exists());
    assertTrue(
        getFileInDirectory(jarExtractedDir, "io/fabric8/kubernetes/api/model/v" + majorVersion + "_" + minorVersion + "/policy")
            .exists());
    assertTrue(getFileInDirectory(jarExtractedDir,
        "io/fabric8/kubernetes/api/model/v" + majorVersion + "_" + minorVersion + "/admissionregistration").exists());
    assertTrue(getFileInDirectory(jarExtractedDir,
        "io/fabric8/kubernetes/api/model/v" + majorVersion + "_" + minorVersion + "/authentication").exists());
    assertTrue(
        getFileInDirectory(jarExtractedDir, "io/fabric8/kubernetes/api/model/v" + majorVersion + "_" + minorVersion + "/batch")
            .exists());
    assertTrue(getFileInDirectory(jarExtractedDir,
        "io/fabric8/kubernetes/api/model/v" + majorVersion + "_" + minorVersion + "/discovery").exists());
    assertTrue(getFileInDirectory(jarExtractedDir,
        "io/fabric8/kubernetes/api/model/v" + majorVersion + "_" + minorVersion + "/metrics").exists());
    assertTrue(
        getFileInDirectory(jarExtractedDir, "io/fabric8/kubernetes/api/model/v" + majorVersion + "_" + minorVersion + "/rbac")
            .exists());
    assertTrue(getFileInDirectory(jarExtractedDir,
        "io/fabric8/kubernetes/api/model/v" + majorVersion + "_" + minorVersion + "/storage").exists());
    assertTrue(getFileInDirectory(jarExtractedDir,
        "io/fabric8/kubernetes/api/model/v" + majorVersion + "_" + minorVersion + "/authorization").exists());
    assertTrue(getFileInDirectory(jarExtractedDir, "io/fabric8/kubernetes/clnt/v" + majorVersion + "_" + minorVersion + "/dsl")
        .exists());
    assertTrue(getFileInDirectory(jarExtractedDir,
        "META-INF/services/io.fabric8.kubernetes.clnt.v" + majorVersion + "_" + minorVersion + ".extension.ExtensionAdapter")
        .exists());
    assertTrue(getFileInDirectory(jarExtractedDir,
        "META-INF/services/io.fabric8.kubernetes.clnt.v" + majorVersion + "_" + minorVersion + ".ServiceToURLProvider")
        .exists());
  }

  private String getMajorVersion(String projectVersion) {
    return projectVersion.split("\\.")[0];
  }

  private String getMinorVersion(String projectVersion) {
    String[] versionParts = projectVersion.split("\\.");
    String minorPatchVersion = projectVersion.substring(versionParts[0].length() + 1);
    if (minorPatchVersion.contains("-SNAPSHOT")) { // SNAPSHOT VERSION
      return minorPatchVersion.split("-")[0];
    } else { // RELEASE VERSION
      return versionParts[1];
    }
  }

  private File getFileInDirectory(File parentFile, String pathToFile) {
    pathToFile = pathToFile.replace('/', File.separatorChar);
    return new File(parentFile, pathToFile);
  }

  private String getProjectVersion() throws Exception {
    final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    final DocumentBuilder builder = factory.newDocumentBuilder();
    try (final FileInputStream fis = new FileInputStream(pomFile)) {
      final Document pom = builder.parse(fis);
      final XPath xPath = XPathFactory.newInstance().newXPath();
      return xPath.compile("/project/parent/version").evaluate(pom);
    }
  }

  void unzip(String zipFilePath, String destDirectory) throws IOException {
    File destDir = new File(destDirectory);
    if (!destDir.exists()) {
      destDir.mkdir();
    }
    ZipInputStream zipIn = new ZipInputStream(new FileInputStream(zipFilePath));
    ZipEntry entry = zipIn.getNextEntry();
    while (entry != null) {
      String filePath = destDirectory + File.separator + entry.getName();
      if (!entry.isDirectory()) {
        extractFile(zipIn, filePath);
      } else {
        File dir = new File(filePath);
        dir.mkdir();
      }
      zipIn.closeEntry();
      entry = zipIn.getNextEntry();
    }
    zipIn.close();
  }

  private void extractFile(ZipInputStream zipIn, String filePath) throws IOException {
    BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
    byte[] bytesIn = new byte[4096];
    int read = 0;
    while ((read = zipIn.read(bytesIn)) != -1) {
      bos.write(bytesIn, 0, read);
    }
    bos.close();
  }
}
