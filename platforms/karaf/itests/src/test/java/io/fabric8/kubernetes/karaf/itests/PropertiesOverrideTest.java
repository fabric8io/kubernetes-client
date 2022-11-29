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

import io.fabric8.kubernetes.client.NamespacedKubernetesClient;
import io.fabric8.openshift.client.NamespacedOpenShiftClient;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.Configuration;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.ProbeBuilder;
import org.ops4j.pax.exam.TestProbeBuilder;
import org.ops4j.pax.exam.junit.PaxExam;
import org.ops4j.pax.exam.spi.reactors.ExamReactorStrategy;
import org.ops4j.pax.exam.spi.reactors.PerClass;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;

import java.util.Arrays;

import javax.inject.Inject;

import static org.ops4j.pax.exam.CoreOptions.systemProperty;
import static org.ops4j.pax.exam.karaf.options.KarafDistributionOption.features;

@RunWith(PaxExam.class)
@ExamReactorStrategy(PerClass.class)
public class PropertiesOverrideTest extends TestBase {

  @Inject
  protected BundleContext bundleContext;

  @Inject
  NamespacedKubernetesClient kubernetesClient;

  @Inject
  NamespacedOpenShiftClient openShiftClient;

  //Need to check this for class loading errors
  @Test
  public void testNamespacedClients() {
    Assert.assertNotNull(kubernetesClient);
    Assert.assertNotNull(openShiftClient);

    Assert.assertEquals("my-namespace", kubernetesClient.getNamespace());
    Assert.assertEquals("my.kube.master", kubernetesClient.getMasterUrl().getHost());
    Assert.assertEquals(8443, kubernetesClient.getMasterUrl().getPort());

    Assert.assertEquals("my-namespace", openShiftClient.getNamespace());
    Assert.assertEquals("my.kube.master", openShiftClient.getMasterUrl().getHost());
    Assert.assertEquals(8443, openShiftClient.getMasterUrl().getPort());
  }

  @ProbeBuilder
  public TestProbeBuilder probeConfiguration(TestProbeBuilder probe) {
    probe.setHeader(Constants.DYNAMICIMPORT_PACKAGE, "*,org.apache.felix.service.*;status=provisional");
    return probe;
  }

  @Configuration
  public Option[] config() {
    return baseConfiguration(
        features(getFeaturesFile().toURI().toString(), "scr", "openshift-client"),
        Arrays.asList(
            systemProperty("kubernetes.namespace").value("my-namespace"),
            systemProperty("kubernetes.master").value("http://my.kube.master:8443"),
            systemProperty("kubernetes.auth.tryKubeConfig").value("false")));
  }
}
