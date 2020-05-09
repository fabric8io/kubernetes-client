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
package io.fabric8.knative.api.examples;

import io.fabric8.kudo.client.InstanceKudoClient;
import io.fabric8.kudo.client.PlanKudoClient;
import io.fabric8.kudo.v1beta1.Instance;
import io.fabric8.kudo.v1beta1.InstanceList;
import org.apache.commons.io.IOUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * this class implement flow comnand:
 * 1 kubectl kudo get instance --instance {instanceName} [-n {namespace}]
 * 2 kubectl kudo install --instance {instanceName} [-n {namespace}]
 * 3 kubectl kudo uninstall --instance {instanceName} [-n {namespace}]
 * 4 kubectl kudo plan history --instance {instanceName} [-n {namespace}]
 * 5 kubectl kudo plan status --instance {instanceName} [-n {namespace}]
 *
 * @author pangms
 * @date 2020/5/8
 */
public class InstanceCmd {

    public boolean uninstall(String ns, String instanceName) {
        try {
            boolean rs = new InstanceKudoClient(ClientFactory.newClient(null)).uninstall(instanceName, ns);
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public InstanceList listInstance(String ns) {
        InstanceKudoClient client = new InstanceKudoClient(ClientFactory.newClient(null));
        try {
            InstanceList instanceList = client.listInstance(ns);
            return instanceList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Instance getInstance(String ns, String instanceName) {
        Instance i = new InstanceKudoClient(ClientFactory.newClient(null))
                .instance(ns, instanceName);
        return i;
    }

    public String status(String ns, String instanceName) {
        return new PlanKudoClient(new InstanceKudoClient(ClientFactory.newClient(null)))
                .status(ns, instanceName, true);
    }

    public String history(String ns, String instanceName) {
        return new PlanKudoClient(new InstanceKudoClient(ClientFactory.newClient(null)))
                .history(ns, instanceName);
    }

    /**
     *
     * @param ns                namespace
     * @param instanceName      the name of instance for craete the instance
     * @param operator          this string is the file of Operator is in the package of kudo
     * @param params            this string is the file of Params is in the package of kudo
     * @param tpls              this string is the files is in the package of kudo in the foled of the template
     * @return
     */
    public Instance installInstance(String ns, String instanceName, String operator, String params, Map<String, String> tpls) {
        InstanceKudoClient client = new InstanceKudoClient(ClientFactory.newClient(null));
        Instance ki = client.install(instanceName, ns, operator.toString(), params.toString(), tpls);
        return ki;
    }
}
