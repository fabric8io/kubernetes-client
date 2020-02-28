/**
 * Copyright (C) 2015 Fabric8 Authors.
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
import org.ops4j.pax.exam.karaf.container.internal.JavaVersionUtil;
import org.ops4j.pax.exam.karaf.options.LogLevelOption;
import org.ops4j.pax.exam.options.MavenArtifactUrlReference;
import org.ops4j.pax.exam.options.extra.VMOption;
import org.ops4j.pax.exam.spi.reactors.ExamReactorStrategy;
import org.ops4j.pax.exam.spi.reactors.PerClass;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;

import static org.ops4j.pax.exam.CoreOptions.maven;
import static org.ops4j.pax.exam.CoreOptions.systemProperty;
import static org.ops4j.pax.exam.karaf.options.KarafDistributionOption.configureSecurity;
import static org.ops4j.pax.exam.karaf.options.KarafDistributionOption.editConfigurationFileExtend;
import static org.ops4j.pax.exam.karaf.options.KarafDistributionOption.features;
import static org.ops4j.pax.exam.karaf.options.KarafDistributionOption.karafDistributionConfiguration;
import static org.ops4j.pax.exam.karaf.options.KarafDistributionOption.keepRuntimeFolder;
import static org.ops4j.pax.exam.karaf.options.KarafDistributionOption.logLevel;

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
    public void testNamspacedClients() throws Exception {
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
    public Option[] config() throws URISyntaxException, MalformedURLException {
        MavenArtifactUrlReference karafUrl = maven().groupId("org.apache.karaf").artifactId("apache-karaf-minimal").versionAsInProject().type("tar.gz");
        if (JavaVersionUtil.getMajorVersion() >= 9) {
            return new Option[]{
                                karafDistributionConfiguration().frameworkUrl(karafUrl).name("Apache Karaf").unpackDirectory(new File("target/exam")),
                                configureSecurity().disableKarafMBeanServerBuilder(),
                                features(getFeaturesFile().toURI().toURL().toString(), "scr", "openshift-client"),
                                editConfigurationFileExtend(
                                    "etc/org.ops4j.pax.url.mvn.cfg",
                                    "org.ops4j.pax.url.mvn.repositories",
                                  "https://repo1.maven.org/maven2/"),
                                keepRuntimeFolder(),
                                systemProperty("kubernetes.namespace").value("my-namespace"),
                                systemProperty("kubernetes.master").value("http://my.kube.master:8443"),
                                systemProperty("kubernetes.auth.tryKubeConfig").value("false"),
                                logLevel(LogLevelOption.LogLevel.DEBUG),
                                new VMOption("--add-exports=java.base/"
                                    + "org.apache.karaf.specs.locator=java.xml,ALL-UNNAMED"),
                                new VMOption("--patch-module"),
                                new VMOption("java.base=lib/endorsed/org.apache.karaf.specs.locator-" 
                                + System.getProperty("karaf.version", "4.2.2-SNAPSHOT") + ".jar"),
                                new VMOption("--patch-module"),
                                new VMOption("java.xml=lib/endorsed/org.apache.karaf.specs.java.xml-" 
                                + System.getProperty("karaf.version", "4.2.2-SNAPSHOT") + ".jar"),
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
                                new VMOption("lib/jdk9plus/*" + File.pathSeparator + "lib/boot/*")
            };
            
        } else {
            return new Option[]{
                karafDistributionConfiguration().frameworkUrl(karafUrl).name("Apache Karaf").unpackDirectory(new File("target/exam")),
                configureSecurity().disableKarafMBeanServerBuilder(),
                features(getFeaturesFile().toURI().toURL().toString(), "scr", "openshift-client"),
                editConfigurationFileExtend(
                    "etc/org.ops4j.pax.url.mvn.cfg",
                    "org.ops4j.pax.url.mvn.repositories",
                  "https://repo1.maven.org/maven2/"),
                keepRuntimeFolder(),
                systemProperty("kubernetes.namespace").value("my-namespace"),
                systemProperty("kubernetes.master").value("http://my.kube.master:8443"),
                systemProperty("kubernetes.auth.tryKubeConfig").value("false"),
                logLevel(LogLevelOption.LogLevel.DEBUG),
            };
        }
    }
}
