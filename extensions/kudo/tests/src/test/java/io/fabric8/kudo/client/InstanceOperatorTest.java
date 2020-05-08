/**
 * Copyright (C) 2015 Red Hat, Inc.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.fabric8.kudo.client;

import io.fabric8.knative.mock.KudoServer;
import io.fabric8.kudo.v1beta1.Instance;
import io.fabric8.kudo.v1beta1.InstanceList;
import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * @author pangms
 * @date 2020/4/21
 */
public class InstanceOperatorTest {

    @Rule
    public KudoServer mock = new KudoServer(true, true);

    @Test
    public void TestUninstall() {
        String instanceName = "redis-instance-n1";
        String ns = "default";
        InstanceKudoClient client = new InstanceKudoClient(mock.getKudoClient());
        try {
            Instance ki = this.installInstance(ns, instanceName);
            Assert.assertNotNull(ki);
            boolean rs = client.uninstall(instanceName, ns);
            Assert.assertTrue(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void TestListInstances() {
        String ns = "test";
        String name = "lioneltest";
        InstanceKudoClient client = new InstanceKudoClient(mock.getKudoClient());
        try {
            Instance ki = this.installInstance(ns, name);
            Assert.assertNotNull(ki);
            InstanceList instanceList = client.listInstance(ns);
            Assert.assertTrue(instanceList.getItems().size() > 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void TestInstanceGet() {
        String ns = "default";
        String instanceName = "redis-instance-n1";
        try {
            Instance instance = this.installInstance(ns, instanceName);
            Assert.assertNotNull(instance);
            Instance i = getCmdClient().instance(ns, instanceName);
            Assert.assertEquals(i.getMetadata().getName(), instanceName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * this version not support, this testcase for the kudo v1.0
     */
    public void TestInstanceTriggerPlan() {
        String ns = "default";
        String instance = "n1";
        String plan = "backup";
        // String plan = "deploy-redis";
        try {
            new PlanKudoClient(getCmdClient()).trigger(ns, instance, plan);
            // System.out.println(i);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void TestInstall() {
        String ns = "default";
        String instanceName = "redis-instance-n1";
        Instance ki = this.installInstance(ns, instanceName);
        Assert.assertNotNull(ki);
    }

    private Instance installInstance(String ns, String instanceName) {
        ByteArrayOutputStream operator = new ByteArrayOutputStream();
        ByteArrayOutputStream params = new ByteArrayOutputStream();
        ByteArrayOutputStream config = new ByteArrayOutputStream();
        ByteArrayOutputStream init = new ByteArrayOutputStream();
        ByteArrayOutputStream pdb = new ByteArrayOutputStream();
        ByteArrayOutputStream service = new ByteArrayOutputStream();
        ByteArrayOutputStream statefulset = new ByteArrayOutputStream();
        try {
            ClassLoader loader = getClass().getClassLoader();

            IOUtils.copy(loader.getResourceAsStream("redis/operator/operator.yaml"), operator);
            IOUtils.copy(loader.getResourceAsStream("redis/operator/params.yaml"), params);
            IOUtils.copy(loader.getResourceAsStream("redis/operator/templates/configmap.yaml"), config);
            IOUtils.copy(loader.getResourceAsStream("redis/operator/templates/init.yaml"), init);
            IOUtils.copy(loader.getResourceAsStream("redis/operator/templates/pdb.yaml"), pdb);
            IOUtils.copy(loader.getResourceAsStream("redis/operator/templates/service.yaml"), service);
            IOUtils.copy(loader.getResourceAsStream("redis/operator/templates/statefulset.yaml"), statefulset);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        Map<String, String> tpls = new HashMap<>();
        tpls.put("configmap.yaml", config.toString());
        tpls.put("init.yaml", init.toString());
        tpls.put("pdb.yaml", pdb.toString());
        tpls.put("service.yaml", service.toString());
        tpls.put("statefulset.yaml", statefulset.toString());

        try {
            InstanceKudoClient client = getCmdClient();
            Instance ki = client.install(instanceName, ns, operator.toString(), params.toString(), tpls);
            return ki;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private InstanceKudoClient getCmdClient() throws IOException {
        // Kudo
        InstanceKudoClient client = new InstanceKudoClient(mock.getKudoClient());
        return client;
    }
}
