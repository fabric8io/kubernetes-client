/*

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

package v1beta1

import (
	"fmt"
	"time"

	corev1 "k8s.io/api/core/v1"
	metav1 "k8s.io/apimachinery/pkg/apis/meta/v1"
	apimachinerytypes "k8s.io/apimachinery/pkg/types"
)

// InstanceSpec defines the desired state of Instance.
type InstanceSpec struct {
	// OperatorVersion specifies a reference to a specific OperatorVersion object.
	OperatorVersion corev1.ObjectReference `json:"operatorVersion,omitempty"`

	Parameters map[string]string `json:"parameters,omitempty"`

	PlanExecution PlanExecution `json:"planExecution,omitempty"`
}

// There are two ways a plan execution can be triggered:
//  1) indirectly through update of a corresponding parameter in the InstanceSpec.Parameters map
//  2) directly through setting of the InstanceSpec.PlanExecution.PlanName field
// While indirect (1) triggers happens every time a user changes a parameter, a directly (2) triggered
// plan is reserved for the situations when parameters doesn't change e.g. a periodic backup is triggered
// overriding the existing backup file. Additionally, this opens room for canceling and overriding
// currently running plans in the future.
// Note: PlanExecution field defines plan name and corresponding parameters that IS CURRENTLY executed.
// Once the instance controller (IC) is done with the execution, this field will be cleared.
// Each plan execution has a unique UID so should the same plan be re-triggered it will have a new UID
type PlanExecution struct {
	PlanName string                `json:"planName,omitempty"`
	UID      apimachinerytypes.UID `json:"uid,omitempty"`
	Status   ExecutionStatus       `json:"status,omitempty"`

	// Future PE options like Force: bool. Not needed for now
}

// InstanceStatus defines the observed state of Instance
type InstanceStatus struct {
	// slice would be enough here but we cannot use slice because order of sequence in yaml is considered significant while here it's not
	PlanStatus       map[string]PlanStatus `json:"planStatus,omitempty"`
	AggregatedStatus AggregatedStatus      `json:"aggregatedStatus,omitempty"`
}

// AggregatedStatus is overview of an instance status derived from the plan status
type AggregatedStatus struct {
	Status         ExecutionStatus `json:"status,omitempty"`
	ActivePlanName string          `json:"activePlanName,omitempty"`
}

// PlanStatus is representing status of a plan
//
// These are valid states and transitions
//
//                       +----------------+
//                       | Never executed |
//                       +-------+--------+
//                               |
//                               v
//+-------------+        +-------+--------+
//|    Error    |<------>|    Pending     |
//+------+------+        +-------+--------+
//       ^                       |
//       |                       v
//       |               +-------+--------+
//       +-------------->|  In progress   |
//       |               +-------+--------+
//       |                       |
//       v                       v
//+------+------+        +-------+--------+
//| Fatal error |        |    Complete    |
//+-------------+        +----------------+
//
type PlanStatus struct {
	Name    string          `json:"name,omitempty"`
	Status  ExecutionStatus `json:"status,omitempty"`
	Message string          `json:"message,omitempty"` // more verbose explanation of the status, e.g. a detailed error message
	// +nullable
	LastUpdatedTimestamp *metav1.Time          `json:"lastUpdatedTimestamp,omitempty"`
	Phases               []PhaseStatus         `json:"phases,omitempty"`
	UID                  apimachinerytypes.UID `json:"uid,omitempty"`
}

// PhaseStatus is representing status of a phase
type PhaseStatus struct {
	Name    string          `json:"name,omitempty"`
	Status  ExecutionStatus `json:"status,omitempty"`
	Message string          `json:"message,omitempty"` // more verbose explanation of the status, e.g. a detailed error message
	Steps   []StepStatus    `json:"steps,omitempty"`
}

// StepStatus is representing status of a step
type StepStatus struct {
	Name    string          `json:"name,omitempty"`
	Message string          `json:"message,omitempty"` // more verbose explanation of the status, e.g. a detailed error message
	Status  ExecutionStatus `json:"status,omitempty"`
}

func (s *StepStatus) Set(status ExecutionStatus) {
	s.Status = status
	s.Message = ""
}

func (s *StepStatus) SetWithMessage(status ExecutionStatus, message string) {
	s.Status = status
	s.Message = message
}

func (s *PhaseStatus) Set(status ExecutionStatus) {
	s.Status = status
	s.Message = ""
}

func (s *PhaseStatus) SetWithMessage(status ExecutionStatus, message string) {
	s.Status = status
	s.Message = message
}

func (s *PlanStatus) Set(status ExecutionStatus) {
	s.LastUpdatedTimestamp = &metav1.Time{Time: time.Now()}
	s.Status = status
	s.Message = ""
}

func (s *PlanStatus) SetWithMessage(status ExecutionStatus, message string) {
	s.LastUpdatedTimestamp = &metav1.Time{Time: time.Now()}
	s.Status = status
	s.Message = message
}

// ExecutionStatus captures the state of the rollout.
type ExecutionStatus string

const (
	// ExecutionInProgress actively deploying, but not yet healthy.
	ExecutionInProgress ExecutionStatus = "IN_PROGRESS"

	// ExecutionPending Not ready to deploy because dependent phases/steps not healthy.
	ExecutionPending ExecutionStatus = "PENDING"

	// ExecutionComplete deployed and healthy.
	ExecutionComplete ExecutionStatus = "COMPLETE"

	// ErrorStatus there was an error deploying the application.
	ErrorStatus ExecutionStatus = "ERROR"

	// ExecutionFatalError there was an error deploying the application.
	ExecutionFatalError ExecutionStatus = "FATAL_ERROR"

	// ExecutionNeverRun is used when this plan/phase/step was never run so far
	ExecutionNeverRun ExecutionStatus = "NEVER_RUN"

	// DeployPlanName is the name of the deployment plan
	DeployPlanName = "deploy"

	// UpgradePlanName is the name of the upgrade plan
	UpgradePlanName = "upgrade"

	// UpdatePlanName is the name of the update plan
	UpdatePlanName = "update"

	// CleanupPlanName is the name of the cleanup plan
	CleanupPlanName = "cleanup"
)

var (
	SpecialPlanNames = []string{
		DeployPlanName,
		UpgradePlanName,
		UpdatePlanName,
		CleanupPlanName,
	}
)

// IsTerminal returns true if the status is terminal (either complete, or in a nonrecoverable error)
func (s ExecutionStatus) IsTerminal() bool {
	return s == ExecutionComplete || s == ExecutionFatalError
}

// IsFinished returns true if the status is complete regardless of errors
func (s ExecutionStatus) IsFinished() bool {
	return s == ExecutionComplete
}

// IsRunning returns true if the plan is currently being executed
func (s ExecutionStatus) IsRunning() bool {
	return s == ExecutionInProgress || s == ExecutionPending || s == ErrorStatus
}

// +genclient
// +k8s:deepcopy-gen:interfaces=k8s.io/apimachinery/pkg/runtime.Object

// Instance is the Schema for the instances API.
// +k8s:openapi-gen=true
// +kubebuilder:subresource:status
type Instance struct {
	metav1.TypeMeta   `json:",inline"`
	metav1.ObjectMeta `json:"metadata,omitempty"`

	Spec   InstanceSpec   `json:"spec,omitempty"`
	Status InstanceStatus `json:"status,omitempty"`
}

// +k8s:deepcopy-gen:interfaces=k8s.io/apimachinery/pkg/runtime.Object
// InstanceList contains a list of Instance.
type InstanceList struct {
	metav1.TypeMeta `json:",inline"`
	metav1.ListMeta `json:"metadata,omitempty"`
	Items           []Instance `json:"items"`
}

func init() {
	SchemeBuilder.Register(&Instance{}, &InstanceList{})
}

// InstanceError indicates error on that can also emit a kubernetes warn event
// +k8s:deepcopy-gen=false
type InstanceError struct {
	Err       error
	EventName *string // nil if no warn event should be created
}

func (e *InstanceError) Error() string {
	return fmt.Sprintf("Error during execution: %v", e.Err)
}
