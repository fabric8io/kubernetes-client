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

import org.apache.karaf.features.Feature;
import org.apache.karaf.features.FeaturesService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.Configuration;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.junit.PaxExam;
import org.ops4j.pax.exam.spi.reactors.ExamReactorStrategy;
import org.ops4j.pax.exam.spi.reactors.PerClass;

import java.util.Collections;
import java.util.stream.Stream;

import javax.inject.Inject;

import static org.junit.Assert.assertTrue;
import static org.ops4j.pax.exam.karaf.options.KarafDistributionOption.editConfigurationFilePut;

@RunWith(PaxExam.class)
@ExamReactorStrategy(PerClass.class)
public class FeatureInstallationTest extends TestBase {

  @Inject
  FeaturesService featuresService;

  @Test
  public void testKubernetesClientFeature() throws Exception {
    featuresService.addRepository(getFeaturesFile().toURI());
    featuresService.installFeature("kubernetes-client");
    assertTrue(Stream.of(featuresService.listInstalledFeatures())
        .map(Feature::getName).anyMatch(name -> name.equals("kubernetes-client")));
  }

  @Test
  public void testOpenshiftClient() throws Exception {
    featuresService.addRepository(getFeaturesFile().toURI());
    featuresService.installFeature("openshift-client");
    assertTrue(Stream.of(featuresService.listInstalledFeatures())
        .map(Feature::getName).anyMatch(name -> name.equals("openshift-client")));
  }

  @Configuration
  public Option[] config() {
    return baseConfiguration(
        null,
        Collections.singletonList(
            editConfigurationFilePut("etc/system.properties", "features.xml", System.getProperty("features.xml"))));
  }
}
