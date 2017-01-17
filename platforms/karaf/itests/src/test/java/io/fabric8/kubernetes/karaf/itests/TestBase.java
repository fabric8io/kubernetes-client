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

import org.junit.Assert;
import org.ops4j.pax.exam.options.MavenArtifactUrlReference;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Properties;

import static org.ops4j.pax.exam.CoreOptions.maven;

public class TestBase {

    private static final String FEATURES_XML = "features.xml";
    private static final String VERSION_PROPERTIES = "versions.properties";
    private static final String KARAF_VERSION_PROPERTY = "karaf.version";
    private static String KARAF_VERSION = "";


    static File getFeaturesFile() throws URISyntaxException {
        String featuresXml = System.getProperty(FEATURES_XML);
        Assert.assertNotNull(featuresXml);
        File featuresFile = new File(featuresXml);
        Assert.assertNotNull(featuresFile.exists());
        return featuresFile;
    }

    protected MavenArtifactUrlReference getKarafDistributionUrlReference() {
        return maven()
            .groupId("org.apache.karaf")
            .artifactId("apache-karaf")
            .versionAsInProject()
            .classifier("minimal")
            .type("tar.gz");
    }

    protected String getKarafVersion() {
      if (KARAF_VERSION.isEmpty()) {
        Properties properties = new Properties();
        try {
          properties.load(TestBase.class.getResourceAsStream(VERSION_PROPERTIES));
          if (!properties.containsKey(KARAF_VERSION_PROPERTY)) {
            throw new IllegalStateException(KARAF_VERSION_PROPERTY + " is not configured in " + VERSION_PROPERTIES);
          }
          KARAF_VERSION = properties.getProperty(KARAF_VERSION_PROPERTY);
        } catch (IOException e) {
          throw new IllegalStateException("Unable to load " + VERSION_PROPERTIES, e);
        }
      }
      return KARAF_VERSION;
    }
}
