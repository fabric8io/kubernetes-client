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

import java.io.File;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import javax.inject.Inject;

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
import org.ops4j.pax.exam.karaf.options.LogLevelOption;
import org.ops4j.pax.exam.options.MavenArtifactUrlReference;
import org.ops4j.pax.exam.spi.reactors.ExamReactorStrategy;
import org.ops4j.pax.exam.spi.reactors.PerClass;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;

import static org.ops4j.pax.exam.CoreOptions.maven;
import static org.ops4j.pax.exam.karaf.options.KarafDistributionOption.configureSecurity;
import static org.ops4j.pax.exam.karaf.options.KarafDistributionOption.editConfigurationFileExtend;
import static org.ops4j.pax.exam.karaf.options.KarafDistributionOption.features;
import static org.ops4j.pax.exam.karaf.options.KarafDistributionOption.karafDistributionConfiguration;
import static org.ops4j.pax.exam.karaf.options.KarafDistributionOption.keepRuntimeFolder;
import static org.ops4j.pax.exam.karaf.options.KarafDistributionOption.logLevel;

@RunWith(PaxExam.class)
@ExamReactorStrategy(PerClass.class)
public class ServiceTest extends TestBase {

    @Inject
    protected BundleContext bundleContext;

    @Inject
    NamespacedKubernetesClient kubernetesClient;

    @Inject
    NamespacedOpenShiftClient openShiftClient;

    @Test
    public void testServiceAvailability() throws Exception {
        Assert.assertNotNull(kubernetesClient);
        Assert.assertNotNull(openShiftClient);
    }

    //Need to check this for class loading errors
    @Test
    public void testNamspacedClients() throws Exception {
        Assert.assertNotNull(kubernetesClient);
        Assert.assertNotNull(openShiftClient);

        NamespacedKubernetesClient knc = kubernetesClient.inNamespace("mytest1");
        Assert.assertEquals("mytest1", knc.getNamespace());

        NamespacedOpenShiftClient onc = openShiftClient.inNamespace("mytest2");
        Assert.assertEquals("mytest2", onc.getNamespace());
    }

    @ProbeBuilder
    public TestProbeBuilder probeConfiguration(TestProbeBuilder probe) {
        probe.setHeader(Constants.DYNAMICIMPORT_PACKAGE, "*,org.apache.felix.service.*;status=provisional");
        return probe;
    }

    @Configuration
    public Option[] config() throws URISyntaxException, MalformedURLException {
        MavenArtifactUrlReference karafUrl = maven().groupId("org.apache.karaf").artifactId("apache-karaf-minimal").versionAsInProject().type("tar.gz");
        return new Option[]{
                karafDistributionConfiguration().frameworkUrl(karafUrl).name("Apache Karaf").unpackDirectory(new File("target/exam")),
                configureSecurity().disableKarafMBeanServerBuilder(),
                features(getFeaturesFile().toURI().toString(), "scr", "openshift-client"),
                editConfigurationFileExtend(
                    "etc/org.ops4j.pax.url.mvn.cfg",
                    "org.ops4j.pax.url.mvn.repositories",
                    "file:"+System.getProperty("features.repo")+"@id=local@snapshots@releases"),
                keepRuntimeFolder(),
                logLevel(LogLevelOption.LogLevel.INFO),
        };
    }
}
