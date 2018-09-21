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
package io.fabric8.kubernetes.api.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.fabric8.kubernetes.api.builder.Visitor;
import io.fabric8.openshift.api.model.Template;
import io.fabric8.openshift.api.model.TemplateBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.assertEquals;

public class UnmarshallTest {

    @Test
    public void testUnmarshallInt64ToLong() throws Exception {
        ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
        Pod pod = (Pod) mapper.readValue(getClass().getResourceAsStream("/valid-pod.json"), KubernetesResource.class);
        assertEquals(pod.getSpec().getContainers().get(0).getResources().getLimits().get("memory"), new Quantity("5Mi"));
        assertEquals(pod.getSpec().getContainers().get(0).getResources().getLimits().get("cpu"), new Quantity("1"));
    }

    @Test
    public void testUnmarshallWithVisitors() throws Exception {
        ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
        KubernetesList list = (KubernetesList) mapper.readValue(getClass().getResourceAsStream("/simple-list.json"), KubernetesResource.class);
        final AtomicInteger integer = new AtomicInteger();
        new io.fabric8.kubernetes.api.model.KubernetesListBuilder(list).accept(new Visitor() {
            public void visit(Object o) {
                integer.incrementAndGet();
            }
        });

        //We just want to make sure that it visits nested objects when deserialization from json is used.
        // The exact number is volatile so we just care about the minimum number of objects (list, pod and service).
        Assert.assertTrue(integer.intValue() >= 3);


        Template template = (Template) mapper.readValue(getClass().getResourceAsStream("/simple-template.json"), KubernetesResource.class);
        integer.set(0);
        new TemplateBuilder(template).accept(new Visitor() {
            public void visit(Object o) {
                integer.incrementAndGet();
            }
        });

        //We just want to make sure that it visits nested objects when deserialization from json is used.
        // The exact number is volatile so we just care about the minimum number of objects (list, pod and service).
        Assert.assertTrue(integer.intValue() >= 2);


        ServiceList serviceList = (ServiceList) mapper.readValue(getClass().getResourceAsStream("/service-list.json"), KubernetesResource.class);
        integer.set(0);
        new io.fabric8.kubernetes.api.model.ServiceListBuilder(serviceList).accept(new Visitor() {
            public void visit(Object o) {
                integer.incrementAndGet();
            }
        });

        //We just want to make sure that it visits nested objects when deserialization from json is used.
        // The exact number is volatile so we just care about the minimum number of objects (list, pod and service).
        Assert.assertTrue(integer.intValue() >= 2);
    }
}