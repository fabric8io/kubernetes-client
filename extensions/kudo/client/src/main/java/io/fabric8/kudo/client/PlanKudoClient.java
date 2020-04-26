package io.fabric8.kudo.client;

import io.fabric8.kubernetes.client.Config;
import io.fabric8.kudo.api.model.v1beta1.*;
import io.fabric8.kudo.api.model.v1beta1.InstanceBuilder;
import io.fabric8.kudo.api.model.v1beta1.InstanceSpecBuilder;
import io.fabric8.kudo.client.entity.Tree;

import java.util.Date;
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
        // TODO tree print the status
        /**
         * for _, p := range plans {
         * 		plan := instance.Status.PlanStatus[p]
         * 		msg := "never run" // this is for the cases when status was not yet populated
         *
         * 		if plan.LastUpdatedTimestamp != nil && !plan.LastUpdatedTimestamp.IsZero() { // plan already finished
         * 			t := plan.LastUpdatedTimestamp.Format(timeLayout)
         * 			msg = fmt.Sprintf("last finished run at %s (%s)", t, string(plan.Status))
         *                } else if plan.Status.IsRunning() {
         * 			msg = "is running"
         *        } else if plan.Status != "" {
         * 			msg = string(plan.Status)
         *        }
         * 		historyDisplay := fmt.Sprintf("%s (%s)", plan.Name, msg)
         * 		tree.AddBranch(historyDisplay)* 	}
         */

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
                /**
                 * planDisplay := fmt.Sprintf("Plan %s (%s strategy) [%s]%s", plan, ov.Spec.Plans[plan].Strategy, lastPlanStatus.Status, printMessageIfAvailable(lastPlanStatus.Message))
                 * 				if lastPlanStatus.LastUpdatedTimestamp != nil {
                 * 					planDisplay = fmt.Sprintf("%s, last updated %s", planDisplay, lastPlanStatus.LastUpdatedTimestamp.Format("2006-01-02 15:04:05"))
                 *                                }
                 * 				planBranchName := rootBranchName.AddBranch(planDisplay)
                 * 				for _, phase := range lastPlanStatus.Phases {
                 * 					phaseDisplay := fmt.Sprintf("Phase %s (%s strategy) [%s]%s", phase.Name, getPhaseStrategy(phase.Name), phase.Status, printMessageIfAvailable(phase.Message))
                 * 					phaseBranchName := planBranchName.AddBranch(phaseDisplay)
                 * 					for _, steps := range phase.Steps {
                 * 						stepsDisplay := fmt.Sprintf("Step %s [%s]%s", steps.Name, steps.Status, printMessageIfAvailable(steps.Message))
                 * 						phaseBranchName.AddBranch(stepsDisplay)
                 *                    }
                 *                }
                 */
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
                /**
                 * planDisplay := fmt.Sprintf("Plan %s (%s strategy) [NOT ACTIVE]", plan, ov.Spec.Plans[plan].Strategy)
                 * 				planBranchName := rootBranchName.AddBranch(planDisplay)
                 * 				for _, phase := range ov.Spec.Plans[plan].Phases {
                 * 					phaseDisplay := fmt.Sprintf("Phase %s (%s strategy) [NOT ACTIVE]", phase.Name, phase.Strategy)
                 * 					phaseBranchName := planBranchName.AddBranch(phaseDisplay)
                 * 					for _, steps := range phase.Steps {
                 * 						stepDisplay := fmt.Sprintf("Step %s [NOT ACTIVE]", steps.Name)
                 * 						phaseBranchName.AddBranch(stepDisplay)
                 *                                        }* 				}
                 */
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

        cmdClient.getClient()
                .instances()
                .inNamespace(ns)
                .withName(instanceName)
                .patch(new InstanceBuilder()
                        .withSpec(new InstanceSpecBuilder().withNewPlanExecution()
                                .withNewPlanName(planName)
                                .withNewUid(UUID.randomUUID().toString())
                                .endPlanExecution()
                                .build())
                        .build());

    }

    public PlanStatus lastExecutedPlanStatus(Instance instance) {
        /**
         * if i.NoPlanEverExecuted() {
         * 		return nil
         *        }
         * 	activePlan := i.GetPlanInProgress()
         * 	if activePlan != nil {
         * 		return activePlan
         *    }
         * 	var lastExecutedPlan *PlanStatus
         * 	for n := range i.Status.PlanStatus {
         * 		p := i.Status.PlanStatus[n]
         * 		if p.Status == ExecutionNeverRun {
         * 			continue // only interested in plans that run
         *        }
         * 		if lastExecutedPlan == nil {
         * 			lastExecutedPlan = &p // first plan that was run and we're iterating over
         *        } else if wasRunAfter(p, *lastExecutedPlan) {
         * 			lastExecutedPlan = &p // this plan was run after the plan we have chosen before
         *        }
         *    }
         * 	return lastExecutedPlan
         */

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
        /**
         * for _, p := range i.Status.PlanStatus {
         * 		if p.Status != ExecutionNeverRun {
         * 			return false
         *                }* 	}
         * 	return true
         */

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
        /*for _, p := range i.Status.PlanStatus {
            if p.Status.IsRunning() {
                return &p
            }
        }*/
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
