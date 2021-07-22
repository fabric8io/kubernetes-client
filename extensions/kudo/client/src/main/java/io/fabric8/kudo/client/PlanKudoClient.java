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

import io.fabric8.kubernetes.client.Config;
import io.fabric8.kudo.v1beta1.Plan;
import io.fabric8.kudo.v1beta1.PhaseStatus;
import io.fabric8.kudo.v1beta1.Instance;
import io.fabric8.kudo.v1beta1.StepStatus;
import io.fabric8.kudo.v1beta1.OperatorVersion;
import io.fabric8.kudo.v1beta1.PlanExecutionBuilder;
import io.fabric8.kudo.client.entity.Tree;
import io.fabric8.kudo.v1beta1.PlanStatus;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author pangms
 * @date 2020/4/24
 */
public class PlanKudoClient {
    private InstanceKudoClient cmdClient;

    public PlanKudoClient(final Config config) {
        cmdClient = new InstanceKudoClient(config);
    }

    public PlanKudoClient(InstanceKudoClient cmdClient) {
        this.cmdClient = cmdClient;
    }

    public String history(String ns, String name) {
        Instance instance = cmdClient.instance(ns, name);
        if (instance == null || instance.getStatus() == null) {
            return null;
        }
        Map<String, PlanStatus> plansStatus = historyStruct(ns, name);

        if(plansStatus == null) {
            return "";
        }

        Tree tree = Tree.craeteRoot("");
        for(Map.Entry<String, PlanStatus> ps: plansStatus.entrySet()) {
            String msg = "never run";
            if(ps.getValue().getLastUpdatedTimestamp() != null
                    && !"".equals(ps.getValue().getLastUpdatedTimestamp())) {
                msg = String.format("last finished run at %s (%s)", ps.getValue().getLastUpdatedTimestamp(),
                        ps.getKey());
            } else if(!"".equals(ps.getValue().getStatus())) {
                msg = ps.getValue().getStatus();
            }
            msg = String.format("%s (%s)", ps.getKey(), msg);
            tree.nodeNode(msg);
        }
        return tree.printTree();
    }

    /**
     * fetch the plan status from the kubernetes server and return a map is
     * the key is plan's name, the velue is the plan's status
     *
     * @param ns
     * @param name
     * @return
     */
    public Map<String, PlanStatus> historyStruct(String ns, String name) {
        Instance instance = cmdClient.instance(ns, name);
        if (instance == null || instance.getStatus() == null) {
            return null;
        }
        return instance.getStatus().getPlanStatus();
    }

    public String status(String ns, String instanceName, boolean isFirst){
        Instance instance = cmdClient.instance(ns, instanceName);
        if(instance == null) {
            return "";
        }
        OperatorVersion ov = cmdClient.getClient()
                .operatorVersion().inNamespace(ns)
                .withName(
                        instance.getSpec().getOperatorVersion()
                                .getName()
                ).get();
        if(ov == null) {
            // if the ov is null, then return ""
            return "";
        }

        PlanStatus lastPlanStatus = this.lastExecutedPlanStatus(instance);
        Tree tree = statusOne(instance, ov, lastPlanStatus, isFirst);

        return tree.printTree();
    }

    public Tree statusOne(Instance instance, OperatorVersion ov, PlanStatus lastPlanStatus, boolean isFirst) {
        String rootNodeName = String.format("%s (Operator-Version: \"%s\" Active-Plan: \"%s\")",
                instance.getMetadata().getName(), instance.getSpec().getOperatorVersion().getName(),
                lastPlanStatus.getName());
        Tree tree = null;
        Tree root = null;
        if(isFirst) {
            root = Tree.craeteRoot(String.format("Plan(s) for \"%s\" in namespace \"%s\":\n",
                    instance.getMetadata().getName(), instance.getMetadata().getNamespace()));
            tree = root.nodeNode(rootNodeName);
        } else {
            tree = Tree.craeteRoot(rootNodeName);
            root = tree;
        }

        for(Map.Entry<String, Plan> pe: ov.getSpec().getPlans().entrySet()) {
            if(pe.getKey().equals(lastPlanStatus.getName())) {
                String planName = String.format("Plan %s (%s strategy) [%s]%s", pe.getKey(),
                        pe.getValue().getStrategy(), lastPlanStatus.getStatus(),
                        printMessageIfAvailable(lastPlanStatus.getMessage()));
                if(lastPlanStatus.getLastUpdatedTimestamp() != null) {
                    planName = String.format("%s, last updated %s", planName, lastPlanStatus.getLastUpdatedTimestamp());
                }
                Tree planBranch = tree.nodeNode(planName);
                for(PhaseStatus ps :lastPlanStatus.getPhases()){
                    String phaseDisplay = String.format("Phase %s (%s strategy) [%s]%s", ps.getName(),
                            findPhaseStrategy(ov.getSpec().getPlans(), ps.getName()), ps.getStatus(),
                            printMessageIfAvailable(ps.getMessage()));
                    Tree phaseBranch = planBranch.nodeNode(phaseDisplay);
                    for(StepStatus s: ps.getSteps()) {
                        String stepStatusName = String.format("Step %s [%s]%s", s.getName(), s.getStatus(),
                                printMessageIfAvailable(s.getMessage()));
                        phaseBranch.nodeNode(stepStatusName);
                    }
                }
            } else {
                String planName = String.format("Plan %s (%s strategy) [NOT ACTIVE]", pe.getKey(), ov.getSpec().getPlans().get(pe.getKey()).getStrategy());
                Tree planBranch = tree.nodeNode(planName);
                for(PhaseStatus ps :lastPlanStatus.getPhases()){
                    String phaseDisplay = String.format("Phase %s (%s strategy) [NOT ACTIVE]", ps.getName(),
                            findPhaseStrategy(ov.getSpec().getPlans(), ps.getName()));

                    Tree phaseBranch = planBranch.nodeNode(phaseDisplay);
                    for(StepStatus s: ps.getSteps()) {
                        String stepStatusName = String.format("Step %s [NOT ACTIVE]", s.getName());
                        phaseBranch.nodeNode(stepStatusName);
                    }
                }
            }
        }
        return root;
    }

    public void trigger(String ns, String instanceName, String planName){
        Instance instance = cmdClient.getClient()
                .instances()
                .inNamespace(ns)
                .withName(instanceName).get();
        if(instance == null) {
            throw new RuntimeException("Not Found the instance");
        }
        // add the executionplan into the plan
        instance.getSpec().setPlanExecution(
                new PlanExecutionBuilder()
                        .withNewPlanName(planName)
                        .withNewUid(UUID.randomUUID().toString())
                        .build());

        cmdClient.getClient()
                .instances()
                .inNamespace(ns)
                .withName(instanceName)
                .patch(instance);
    }

    public PlanStatus lastExecutedPlanStatus(Instance instance) {

        if(this.NoPlanEverExecuted(instance)) {
            // if the instance is Even excuted then return null;
            return null;
        }

        PlanStatus activePlan = this.getPlanInProgress(instance);
        if(activePlan != null) {
            return activePlan;
        }

        PlanStatus lastExecutedPlan = null;
        for(PlanStatus ps: instance.getStatus().getPlanStatus().values()) {
            if(Constance.ExecutionNeverRun.equals(ps.getStatus())) {
                continue;
            }

            if(lastExecutedPlan == null) {
                lastExecutedPlan = ps;
            } else if(this.wasRunAfter(ps, lastExecutedPlan)) {
                lastExecutedPlan = ps;
            }
        }

        return lastExecutedPlan;
    }

    // wasRunAfter returns true if p1 was run after p2
    private boolean wasRunAfter(PlanStatus p1, PlanStatus p2) {
        if (Constance.ExecutionNeverRun.equals(p1.getStatus())
                || Constance.ExecutionNeverRun.equals(p2.getStatus())
                || p1.getLastUpdatedTimestamp() == null
                || p2.getLastUpdatedTimestamp() == null) {
            return false;
        }
        return new Date(p1.getLastUpdatedTimestamp()).after(new Date(p2.getLastUpdatedTimestamp()));
    }

    private boolean NoPlanEverExecuted(Instance instance){

        if(instance == null || instance.getStatus() == null) {
            // if the install is null or the status is null, then return null
            return false;
        }

        for( PlanStatus ps : instance.getStatus().getPlanStatus().values()){
            if(!Constance.ExecutionNeverRun.equals(ps.getStatus())) {
                return false;
            }
        }
        return true;
    }

    private boolean isRunning(PlanStatus s) {
        return  Constance.ExecutionInProgress.equals(s.getStatus())
                || Constance.ExecutionPending.equals(s.getStatus())
                || Constance.ErrorStatus.equals(s.getStatus());
    }

    private PlanStatus getPlanInProgress(Instance i) {
        for(PlanStatus ps: i.getStatus().getPlanStatus().values()) {
            if(this.isRunning(ps)) {
                return ps;
            }
        }
        return null;
    }

    private String printMessageIfAvailable(String msg){
        if(!"".equals(msg) && msg != null) {
            return String.format("(%s)", msg);
        }
        return "";
    }

    private String findPhaseStrategy(Map<String, Plan> plans, String name) {
        return plans.get(name) != null? plans.get(name).getStrategy(): "";
    }
}
