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
package io.fabric8.kubernetes.karaf.itests;

import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.karaf.container.internal.JavaVersionUtil;
import org.ops4j.pax.exam.karaf.options.LogLevelOption;
import org.ops4j.pax.exam.options.MavenArtifactUrlReference;
import org.ops4j.pax.exam.options.extra.VMOption;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.ops4j.pax.exam.CoreOptions.maven;
import static org.ops4j.pax.exam.karaf.options.KarafDistributionOption.configureSecurity;
import static org.ops4j.pax.exam.karaf.options.KarafDistributionOption.editConfigurationFileExtend;
import static org.ops4j.pax.exam.karaf.options.KarafDistributionOption.karafDistributionConfiguration;
import static org.ops4j.pax.exam.karaf.options.KarafDistributionOption.keepRuntimeFolder;
import static org.ops4j.pax.exam.karaf.options.KarafDistributionOption.logLevel;

public class TestBase {

  private static final String FEATURES_XML = "features.xml";

  Option[] baseConfiguration(Option features) {
    return baseConfiguration(features, Collections.emptyList());
  }

  Option[] baseConfiguration(Option features, List<Option> extraOptions) {
    MavenArtifactUrlReference karafUrl = maven().groupId("org.apache.karaf").artifactId("apache-karaf-minimal")
        .versionAsInProject().type("tar.gz");
    final List<Option> ret = new ArrayList<>();
    if (JavaVersionUtil.getMajorVersion() >= 9) {
      ret.addAll(Arrays.asList(
          karafDistributionConfiguration().frameworkUrl(karafUrl).name("Apache Karaf").unpackDirectory(new File("target/exam")),
          configureSecurity().disableKarafMBeanServerBuilder(),
          features,
          editConfigurationFileExtend(
              "etc/io.fabric8.kubernetes.client.cfg", "junit", "ignored"),
          editConfigurationFileExtend(
              "etc/io.fabric8.openshift.client.cfg", "junit", "ignored"),
          editConfigurationFileExtend(
              "etc/org.ops4j.pax.url.mvn.cfg",
              "org.ops4j.pax.url.mvn.repositories",
              "https://repo1.maven.org/maven2/"),
          keepRuntimeFolder(),
          logLevel(LogLevelOption.LogLevel.INFO),
          new VMOption("--add-exports=java.base/"
              + "org.apache.karaf.specs.locator=java.xml,ALL-UNNAMED"),
          new VMOption("--patch-module"),
          new VMOption("java.base=lib/endorsed/org.apache.karaf.specs.locator-"
              + System.getProperty("karaf.version", "4.4.1") + ".jar"),
          new VMOption("--patch-module"),
          new VMOption("java.xml=lib/endorsed/org.apache.karaf.specs.java.xml-"
              + System.getProperty("karaf.version", "4.4.1") + ".jar"),
          new VMOption("--add-opens"),
          new VMOption("java.base/java.security=ALL-UNNAMED"),
          new VMOption("--add-opens"),
          new VMOption("java.base/java.net=ALL-UNNAMED"),
          new VMOption("--add-opens"),
          new VMOption("java.base/java.lang=ALL-UNNAMED"),
          new VMOption("--add-opens"),
          new VMOption("java.base/java.util=ALL-UNNAMED"),
          new VMOption("--add-opens"),
          new VMOption("java.naming/javax.naming.spi=ALL-UNNAMED"),
          new VMOption("--add-opens"),
          new VMOption("java.rmi/sun.rmi.transport.tcp=ALL-UNNAMED"),
          new VMOption("--add-exports=java.base/sun.net.www.protocol.http=ALL-UNNAMED"),
          new VMOption("--add-exports=java.base/sun.net.www.protocol.https=ALL-UNNAMED"),
          new VMOption("--add-exports=java.base/sun.net.www.protocol.jar=ALL-UNNAMED"),
          new VMOption("--add-exports=jdk.naming.rmi/com.sun.jndi.url.rmi=ALL-UNNAMED"),
          new VMOption("-classpath"),
          new VMOption("lib/jdk9plus/*" + File.pathSeparator + "lib/boot/*")));
    } else {
      ret.addAll(Arrays.asList(
          karafDistributionConfiguration().frameworkUrl(karafUrl).name("Apache Karaf").unpackDirectory(new File("target/exam")),
          configureSecurity().disableKarafMBeanServerBuilder(),
          features,
          editConfigurationFileExtend(
              "etc/io.fabric8.kubernetes.client.cfg", "junit", "ignored"),
          editConfigurationFileExtend(
              "etc/io.fabric8.openshift.client.cfg", "junit", "ignored"),
          editConfigurationFileExtend(
              "etc/org.ops4j.pax.url.mvn.cfg",
              "org.ops4j.pax.url.mvn.repositories",
              "https://repo1.maven.org/maven2/"),
          keepRuntimeFolder(),
          logLevel(LogLevelOption.LogLevel.INFO)));
    }
    ret.addAll(extraOptions);
    return ret.toArray(new Option[0]);
  }

  static File getFeaturesFile() {
    String featuresXml = System.getProperty(FEATURES_XML);
    assertNotNull(featuresXml);
    File featuresFile = new File(featuresXml);
    assertTrue(featuresFile.exists());
    return featuresFile;
  }
}
