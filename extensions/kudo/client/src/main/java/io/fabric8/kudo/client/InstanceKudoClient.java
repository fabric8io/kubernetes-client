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
package io.fabric8.kudo.client;

import io.fabric8.kubernetes.api.model.ObjectMetaBuilder;
import io.fabric8.kubernetes.api.model.ObjectReferenceBuilder;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.utils.Serialization;
import io.fabric8.kudo.kubectl.*;
import io.fabric8.kudo.kubectl.ResourcesBuilder;
import io.fabric8.kudo.v1beta1.*;
import io.fabric8.kudo.v1beta1.InstanceBuilder;
import io.fabric8.kudo.v1beta1.InstanceSpecBuilder;
import io.fabric8.kudo.v1beta1.OperatorBuilder;
import io.fabric8.kudo.v1beta1.OperatorSpecBuilder;
import io.fabric8.kudo.v1beta1.OperatorVersionBuilder;
import io.fabric8.kudo.v1beta1.OperatorVersionSpecBuilder;
import io.fabric8.kudo.v1beta1.ParameterBuilder;
import io.fabric8.kudo.client.exception.InstanceVersionException;
import io.fabric8.kudo.client.exception.OperatorCreateException;
import io.fabric8.kudo.client.exception.OperatorVersionException;
import io.fabric8.kudo.v1beta1.Parameter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author pangms
 * @date 2020/4/20
 */
public class InstanceKudoClient {
    private final static String KUDO_APIVERSION = "kudo.dev/v1beta1";

    private KudoClient client;

    public InstanceKudoClient(final Config config) {
        this.client = new DefaultKudoClient(config);
    }

    public InstanceKudoClient(KudoClient client) {
        this.client = client;
    }

    public Instance install(String name, String ns, String operator, String params, Map<String, String> tpls) {
        OperatorFile operatorFile = Serialization.unmarshal(operator, OperatorFile.class);
        ParamsFile paramsFile = Serialization.unmarshal(params, ParamsFile.class);
        // craete the resource
        return this.install(name, ns, operatorFile, paramsFile, tpls);
    }

    public Instance install(String name, String ns, OperatorFile operatorFile, ParamsFile paramsFile, Map<String, String> tpls) {
        Resources resources = convertToResource(name, operatorFile, paramsFile, tpls);
        // crate
        return this.install(name, ns, resources.getOperator(), resources.getInstance(), resources.getOperatorVersion());
    }

    public Instance install(String name, String ns, Operator operator, Instance instance, OperatorVersion ov) {
        Operator koperator = client.operators().inNamespace(ns)
                .withName(operator.getMetadata().getName()).get();
        if(koperator == null) {
            // the operator is in the kubernete, not need to create again
            koperator = client.operators().inNamespace(ns).create(operator);
            if(koperator == null) {
                throw new OperatorCreateException(String.format("create the Operator in the ns of %v, " +
                        "operator name is %s", ns, operator.getMetadata().getName()));
            }
        }

        OperatorVersion kov = client.operatorVersion().inNamespace(ns).withName(ov.getMetadata().getName()).get();
        if(kov == null){
            kov = client.operatorVersion().inNamespace(ns).create(ov);
            if(kov == null) {
                throw new OperatorVersionException(String.format("create the OperatorVersion in the ns of %v, " +
                        "operator name is %s", ns, ov.getMetadata().getName()));
            }
        }

        Instance kinstance = client.instances().inNamespace(ns).withName(name).get();
        if(kinstance != null) {
            throw new InstanceVersionException(String.format("the instsall(%v) is exsit in the namespace(%s), please check the instanceName",
                    instance.getMetadata().getName(), ns));
        }

        // set the name into the instance
        instance.getMetadata().setName(name);
        kinstance = client.instances().inNamespace(ns).create(instance);
        if(kinstance == null) {
            // create fails
            throw new InstanceVersionException(String.format("create the instance(ns:%s, name:%s) fails, please check the instance",
                    ns, instance.getMetadata().getName()));
        }

        return kinstance;
    }

    /**
     * uninstall the instance by the instanceName
     *
     * @param instanceName instancName
     * @param ns           the install in the namespaces
     * @return True indicates deletion succeeded
     */
    public boolean uninstall(String instanceName, String ns) {
        return client.instances().inNamespace(ns).withName(instanceName).delete();
    }

    public InstanceList listInstance(String ns) {
        return client.instances().inNamespace(ns).list();
    }

    public Instance instance(String ns, String instance) {
        return client.instances().inNamespace(ns).withName(instance).get();
    }

    private Resources convertToResource(String name, OperatorFile operatorFile, ParamsFile paramsFile, Map<String, String> tpls) {
        // 1. convert the Operator
        Operator operator = new OperatorBuilder()
                .withKind("Operator")
                .withApiVersion(KUDO_APIVERSION)
                .withMetadata(
                        new ObjectMetaBuilder()
                                .withName(operatorFile.getName())
                                .build()
                )
                .withSpec(new OperatorSpecBuilder()
                        .withDescription(operatorFile.getDescription())
                        .withKudoVersion(operatorFile.getKudoVersion())
                        .withKubernetesVersion(operatorFile.getKubernetesVersion())
                        .withMaintainers(operatorFile.getMaintainers())
                        .withUrl(operatorFile.getUrl())
                        .build()
                )
                .build();
        // 2. convert the OperatorVersion
        OperatorVersion ov = new OperatorVersionBuilder()
                .withApiVersion(KUDO_APIVERSION)
                .withKind("OperatorVersion")
                .withMetadata(new ObjectMetaBuilder()
                        .withName(String.format("%s-%s", operatorFile.getName(), operatorFile.getOperatorVersion()))
                        .build())
                .withSpec(new OperatorVersionSpecBuilder()
                        .withOperator(
                                new ObjectReferenceBuilder()
                                        .withName(operatorFile.getName())
                                        .withKind("Operator")
                                        .build()
                        )
                        .withAppVersion(operatorFile.getAppVersion())
                        .withVersion(operatorFile.getOperatorVersion())
                        .withTemplates(tpls)
                        .withTasks(operatorFile.getTasks())
                        .withParameters(convertToParameter(paramsFile.getParameters()))
                        .withPlans(operatorFile.getPlans())
                        .build())
                .build();

        // 3. convert the instance
        Map<String, String> lables = new HashMap<>();
        lables.put(operatorFile.getName(), operatorFile.getOperatorVersion());
        String operatorName = operatorFile.getName();
        if ("".equals(name)) {
            // if the user setting the instanceName
            operatorName = name;
        }
        Instance instance = new InstanceBuilder()
                .withApiVersion(KUDO_APIVERSION)
                .withKind("Instance")
                .withMetadata(
                        new ObjectMetaBuilder()
                                .withName(operatorName)
                                .withLabels(lables)
                                .build()
                )
                .withSpec(new InstanceSpecBuilder()
                        .withOperatorVersion(
                                new ObjectReferenceBuilder()
                                        .withName(String.format("%s-%s", operatorFile.getName(), operatorFile.getOperatorVersion()))
                                        .build()
                        ).build())
                .build();
        return new ResourcesBuilder()
                .withInstance(instance)
                .withOperator(operator)
                .withOperatorVersion(ov)
                .build();
    }

    private List<Parameter> convertToParameter(List<FileParameter> parameters) {
        List<Parameter> rs = new ArrayList<>();
        for (FileParameter fp : parameters) {
            rs.add(new ParameterBuilder()
                    .withDisplayName(fp.getDisplayName())
                    .withName(fp.getName())
                    .withRequired(fp.getRequired())
                    .withDefault(fp.getDefault().toString())
                    .withTrigger(fp.getTrigger())
                    .withValueType(fp.getType())
                    .build());
        }
        return rs;
    }

    public KudoClient getClient(){
        return this.client;
    }
}
