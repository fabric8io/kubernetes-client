package v1beta1

import (
	"encoding/json"
	"fmt"
	"log"

	"github.com/thoas/go-funk"
	metav1 "k8s.io/apimachinery/pkg/apis/meta/v1"
	"k8s.io/apimachinery/pkg/util/uuid"
)

const (
	instanceCleanupFinalizerName = "kudo.dev.instance.cleanup"
	snapshotAnnotation           = "kudo.dev/last-applied-instance-state"
)

// GetPlanInProgress returns plan status of currently active plan or nil if no plan is running
func (i *Instance) GetPlanInProgress() *PlanStatus {
	for _, p := range i.Status.PlanStatus {
		if p.Status.IsRunning() {
			return &p
		}
	}
	return nil
}

// GetLastExecutedPlanStatus returns status of plan that is currently running, if there is one running
// if no plan is running it looks for last executed plan based on timestamps
func (i *Instance) GetLastExecutedPlanStatus() *PlanStatus {
	if i.NoPlanEverExecuted() {
		return nil
	}
	activePlan := i.GetPlanInProgress()
	if activePlan != nil {
		return activePlan
	}
	var lastExecutedPlan *PlanStatus
	for n := range i.Status.PlanStatus {
		p := i.Status.PlanStatus[n]
		if p.Status == ExecutionNeverRun {
			continue // only interested in plans that run
		}
		if lastExecutedPlan == nil {
			lastExecutedPlan = &p // first plan that was run and we're iterating over
		} else if wasRunAfter(p, *lastExecutedPlan) {
			lastExecutedPlan = &p // this plan was run after the plan we have chosen before
		}
	}
	return lastExecutedPlan
}

// NoPlanEverExecuted returns true is this is new instance for which we never executed any plan
func (i *Instance) NoPlanEverExecuted() bool {
	for _, p := range i.Status.PlanStatus {
		if p.Status != ExecutionNeverRun {
			return false
		}
	}
	return true
}

// UpdateInstanceStatus updates `Status.PlanStatus` and `Status.AggregatedStatus` property based on the given plan
func (i *Instance) UpdateInstanceStatus(planStatus *PlanStatus, updatedTimestamp *metav1.Time) {
	for k, v := range i.Status.PlanStatus {
		if v.Name == planStatus.Name {
			planStatus.LastUpdatedTimestamp = updatedTimestamp
			i.Status.PlanStatus[k] = *planStatus
			i.Spec.PlanExecution.Status = planStatus.Status
			i.Status.AggregatedStatus.Status = planStatus.Status
		}
	}
}

// ResetPlanStatus method resets a PlanStatus for a passed plan name and instance. Plan/phase/step statuses
// are set to ExecutionPending meaning that the controller will restart plan execution.
func (i *Instance) ResetPlanStatus(plan string, updatedTimestamp *metav1.Time) error {
	planStatus := i.PlanStatus(plan)
	if planStatus == nil {
		return fmt.Errorf("failed to find planStatus for the plan '%s'", plan)
	}

	// reset plan's phases and steps by setting them to ExecutionPending
	planStatus.Set(ExecutionPending)
	// when using webhooks, instance admission webhook already generates an UID for current plan, otherwise, we generate a new one.
	if i.Spec.PlanExecution.UID != "" {
		planStatus.UID = i.Spec.PlanExecution.UID
	} else {
		planStatus.UID = uuid.NewUUID()
	}

	for i, ph := range planStatus.Phases {
		planStatus.Phases[i].Set(ExecutionPending)

		for j := range ph.Steps {
			planStatus.Phases[i].Steps[j].Set(ExecutionPending)
		}
	}

	// update plan status and instance aggregated status
	i.UpdateInstanceStatus(planStatus, updatedTimestamp)
	return nil
}

// IsDeleting returns true is the instance is being deleted.
func (i *Instance) IsDeleting() bool {
	// a delete request is indicated by a non-zero 'metadata.deletionTimestamp',
	// see https://kubernetes.io/docs/tasks/access-kubernetes-api/custom-resources/custom-resource-definitions/#finalizers
	return !i.ObjectMeta.DeletionTimestamp.IsZero()
}

func (i *Instance) HasNoFinalizers() bool { return len(i.GetFinalizers()) == 0 }

// OperatorVersionNamespace returns the namespace of the OperatorVersion that the Instance references.
func (i *Instance) OperatorVersionNamespace() string {
	if i.Spec.OperatorVersion.Namespace == "" {
		return i.ObjectMeta.Namespace
	}
	return i.Spec.OperatorVersion.Namespace
}

func (i *Instance) PlanStatus(plan string) *PlanStatus {
	for _, planStatus := range i.Status.PlanStatus {
		if planStatus.Name == plan {
			return &planStatus
		}
	}

	return nil
}

// annotateSnapshot stores the current spec of Instance into the snapshot annotation
// this information is used when executing update/upgrade plans, this overrides any snapshot that existed before
func (i *Instance) AnnotateSnapshot() error {
	jsonBytes, err := json.Marshal(i.Spec)
	if err != nil {
		return err
	}
	if i.Annotations == nil {
		i.Annotations = make(map[string]string)
	}
	i.Annotations[snapshotAnnotation] = string(jsonBytes)
	return nil
}

func (i *Instance) SnapshotSpec() (*InstanceSpec, error) {
	if i.Annotations != nil {
		snapshot, ok := i.Annotations[snapshotAnnotation]
		if ok {
			var spec *InstanceSpec
			err := json.Unmarshal([]byte(snapshot), &spec)
			if err != nil {
				return nil, err
			}
			return spec, nil
		}
	}
	return nil, nil
}

func (i *Instance) HasCleanupFinalizer() bool {
	return funk.ContainsString(i.ObjectMeta.Finalizers, instanceCleanupFinalizerName)
}

// TryAddFinalizer adds the cleanup finalizer to an instance if the finalizer
// hasn't been added yet, the instance has a cleanup plan and the cleanup plan
// didn't run yet. Returns true if the cleanup finalizer has been added.
func (i *Instance) TryAddFinalizer() bool {
	if !i.HasCleanupFinalizer() {
		planStatus := i.PlanStatus(CleanupPlanName)
		// avoid adding a finalizer multiple times: we only add it if the corresponding
		// plan.Status is nil (meaning the plan never ran) or if it exists but equals ExecutionNeverRun
		if planStatus == nil || planStatus.Status == ExecutionNeverRun {
			i.ObjectMeta.Finalizers = append(i.ObjectMeta.Finalizers, instanceCleanupFinalizerName)
			return true
		}
	}

	return false
}

// TryRemoveFinalizer removes the cleanup finalizer of an instance if it has
// been added, the instance has a cleanup plan and the cleanup plan *successfully* finished.
// Returns true if the cleanup finalizer has been removed.
func (i *Instance) TryRemoveFinalizer() bool {
	if funk.ContainsString(i.ObjectMeta.Finalizers, instanceCleanupFinalizerName) {
		if planStatus := i.PlanStatus(CleanupPlanName); planStatus != nil {
			// we check IsFinished and *not* IsTerminal here so that the finalizer is not removed in the FatalError
			// case. This way a human operator has to intervene and we don't leave garbage in the cluster.
			if planStatus.Status.IsFinished() {
				log.Printf("Removing finalizer on instance %s/%s, cleanup plan is finished", i.Namespace, i.Name)
				i.ObjectMeta.Finalizers = remove(i.ObjectMeta.Finalizers, instanceCleanupFinalizerName)
				return true
			}
		} else {
			// We have a finalizer but no cleanup plan. This could be due to an updated instance.
			// Let's remove the finalizer.
			log.Printf("Removing finalizer on instance %s/%s because there is no cleanup plan", i.Namespace, i.Name)
			i.ObjectMeta.Finalizers = remove(i.ObjectMeta.Finalizers, instanceCleanupFinalizerName)
			return true
		}
	}

	return false
}

func remove(values []string, s string) []string {
	return funk.FilterString(values, func(str string) bool {
		return str != s
	})
}

// wasRunAfter returns true if p1 was run after p2
func wasRunAfter(p1 PlanStatus, p2 PlanStatus) bool {
	if p1.Status == ExecutionNeverRun || p2.Status == ExecutionNeverRun || p1.LastUpdatedTimestamp == nil || p2.LastUpdatedTimestamp == nil {
		return false
	}
	return p1.LastUpdatedTimestamp.Time.After(p2.LastUpdatedTimestamp.Time)
}

// GetExistingParamDefinitions retrieves parameter metadata from OperatorVersion
func GetExistingParamDefinitions(params map[string]string, ov *OperatorVersion) []Parameter {
	defs := []Parameter{}
	for p1 := range params {
		for _, p2 := range ov.Spec.Parameters {
			if p2.Name == p1 {
				defs = append(defs, p2)
			}
		}
	}
	return defs
}

// GetParamDefinitions retrieves parameter metadata from OperatorVersion but returns an error if any parameter is missing
func GetParamDefinitions(params map[string]string, ov *OperatorVersion) ([]Parameter, error) {
	defs := []Parameter{}
	for p1 := range params {
		p1 := p1
		p2 := funk.Find(ov.Spec.Parameters, func(e Parameter) bool {
			return e.Name == p1
		})

		if p2 == nil {
			return nil, fmt.Errorf("failed to find parameter %q in the OperatorVersion", p1)
		}

		defs = append(defs, p2.(Parameter))
	}
	return defs, nil
}

// ParameterDiff returns map containing all parameters that were removed or changed between old and new
func ParameterDiff(old, new map[string]string) map[string]string {
	diff := make(map[string]string)

	for key, val := range old {
		// If a parameter was removed in the new spec
		if _, ok := new[key]; !ok {
			diff[key] = val
		}
	}

	for key, val := range new {
		// If new spec parameter was added or changed
		if v, ok := old[key]; !ok || v != val {
			diff[key] = val
		}
	}

	return diff
}

// RichParameterDiff compares new and old map and returns two maps: first containing all changed/added
// and second all removed parameters.
func RichParameterDiff(old, new map[string]string) (changed, removed map[string]string) {
	changed, removed = make(map[string]string), make(map[string]string)

	for key, val := range old {
		// If a parameter was removed in the new spec
		if _, ok := new[key]; !ok {
			removed[key] = val
		}
	}

	for key, val := range new {
		// If new spec parameter was added or changed
		if v, ok := old[key]; !ok || v != val {
			changed[key] = val
		}
	}
	return
}

func CleanupPlanExists(ov *OperatorVersion) bool { return PlanExists(CleanupPlanName, ov) }

func PlanExists(plan string, ov *OperatorVersion) bool {
	_, ok := ov.Spec.Plans[plan]
	return ok
}

// SelectPlan returns nil if none of the plan exists, otherwise the first one in list that exists
func SelectPlan(possiblePlans []string, ov *OperatorVersion) *string {
	for _, plan := range possiblePlans {
		if _, ok := ov.Spec.Plans[plan]; ok {
			return &plan
		}
	}
	return nil
}

func GetStepStatus(stepName string, phaseStatus *PhaseStatus) *StepStatus {
	for i, p := range phaseStatus.Steps {
		if p.Name == stepName {
			return &phaseStatus.Steps[i]
		}
	}

	return nil
}

func GetPhaseStatus(phaseName string, planStatus *PlanStatus) *PhaseStatus {
	for i, p := range planStatus.Phases {
		if p.Name == phaseName {
			return &planStatus.Phases[i]
		}
	}

	return nil
}
