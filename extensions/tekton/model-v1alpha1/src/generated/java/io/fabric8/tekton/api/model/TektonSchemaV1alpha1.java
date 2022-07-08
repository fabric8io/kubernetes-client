
package io.fabric8.tekton.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.fabric8.tekton.pipeline.v1alpha1.CloudEventDelivery;
import io.fabric8.tekton.pipeline.v1alpha1.CloudEventDeliveryState;
import io.fabric8.tekton.pipeline.v1alpha1.ClusterTask;
import io.fabric8.tekton.pipeline.v1alpha1.ClusterTaskList;
import io.fabric8.tekton.pipeline.v1alpha1.Condition;
import io.fabric8.tekton.pipeline.v1alpha1.ConditionCheckStatus;
import io.fabric8.tekton.pipeline.v1alpha1.ConditionList;
import io.fabric8.tekton.pipeline.v1alpha1.ConditionSpec;
import io.fabric8.tekton.pipeline.v1alpha1.Inputs;
import io.fabric8.tekton.pipeline.v1alpha1.Outputs;
import io.fabric8.tekton.pipeline.v1alpha1.Pipeline;
import io.fabric8.tekton.pipeline.v1alpha1.PipelineList;
import io.fabric8.tekton.pipeline.v1alpha1.PipelineRef;
import io.fabric8.tekton.pipeline.v1alpha1.PipelineResourceBinding;
import io.fabric8.tekton.pipeline.v1alpha1.PipelineResourceRef;
import io.fabric8.tekton.pipeline.v1alpha1.PipelineResourceResult;
import io.fabric8.tekton.pipeline.v1alpha1.PipelineRun;
import io.fabric8.tekton.pipeline.v1alpha1.PipelineRunConditionCheckStatus;
import io.fabric8.tekton.pipeline.v1alpha1.PipelineRunList;
import io.fabric8.tekton.pipeline.v1alpha1.PipelineRunSpec;
import io.fabric8.tekton.pipeline.v1alpha1.PipelineRunSpecServiceAccountName;
import io.fabric8.tekton.pipeline.v1alpha1.PipelineRunStatus;
import io.fabric8.tekton.pipeline.v1alpha1.PipelineRunTaskRunStatus;
import io.fabric8.tekton.pipeline.v1alpha1.PipelineSpec;
import io.fabric8.tekton.pipeline.v1alpha1.PipelineStatus;
import io.fabric8.tekton.pipeline.v1alpha1.PipelineTask;
import io.fabric8.tekton.pipeline.v1alpha1.SidecarState;
import io.fabric8.tekton.pipeline.v1alpha1.StepState;
import io.fabric8.tekton.pipeline.v1alpha1.Task;
import io.fabric8.tekton.pipeline.v1alpha1.TaskList;
import io.fabric8.tekton.pipeline.v1alpha1.TaskResource;
import io.fabric8.tekton.pipeline.v1alpha1.TaskResourceBinding;
import io.fabric8.tekton.pipeline.v1alpha1.TaskResult;
import io.fabric8.tekton.pipeline.v1alpha1.TaskRun;
import io.fabric8.tekton.pipeline.v1alpha1.TaskRunInputs;
import io.fabric8.tekton.pipeline.v1alpha1.TaskRunList;
import io.fabric8.tekton.pipeline.v1alpha1.TaskRunOutputs;
import io.fabric8.tekton.pipeline.v1alpha1.TaskRunSpec;
import io.fabric8.tekton.pipeline.v1alpha1.TaskRunStatus;
import io.fabric8.tekton.pipeline.v1alpha1.TaskSpec;
import io.fabric8.tekton.pipeline.v1alpha1.TestResult;
import io.fabric8.tekton.resource.v1alpha1.PipelineResource;
import io.fabric8.tekton.resource.v1alpha1.PipelineResourceList;
import io.fabric8.tekton.resource.v1alpha1.PipelineResourceSpec;
import io.fabric8.tekton.resource.v1alpha1.PipelineResourceStatus;
import io.fabric8.tekton.resource.v1alpha1.ResourceDeclaration;
import io.fabric8.tekton.resource.v1alpha1.ResourceParam;
import io.fabric8.tekton.resource.v1alpha1.SecretParam;
import io.fabric8.tekton.v1alpha1.internal.pipeline.pkg.apis.pipeline.pod.Template;
import io.fabric8.tekton.v1alpha1.internal.pipeline.pkg.apis.pipeline.v1alpha2.Param;
import io.fabric8.tekton.v1alpha1.internal.pipeline.pkg.apis.pipeline.v1alpha2.ParamSpec;
import io.fabric8.tekton.v1alpha1.internal.pipeline.pkg.apis.pipeline.v1alpha2.PipelineDeclaredResource;
import io.fabric8.tekton.v1alpha1.internal.pipeline.pkg.apis.pipeline.v1alpha2.PipelineTaskCondition;
import io.fabric8.tekton.v1alpha1.internal.pipeline.pkg.apis.pipeline.v1alpha2.PipelineTaskInputResource;
import io.fabric8.tekton.v1alpha1.internal.pipeline.pkg.apis.pipeline.v1alpha2.PipelineTaskOutputResource;
import io.fabric8.tekton.v1alpha1.internal.pipeline.pkg.apis.pipeline.v1alpha2.PipelineTaskResources;
import io.fabric8.tekton.v1alpha1.internal.pipeline.pkg.apis.pipeline.v1alpha2.Step;
import io.fabric8.tekton.v1alpha1.internal.pipeline.pkg.apis.pipeline.v1alpha2.TaskRef;
import io.fabric8.tekton.v1alpha1.internal.pipeline.pkg.apis.pipeline.v1alpha2.WorkspaceBinding;
import io.fabric8.tekton.v1alpha1.internal.pipeline.pkg.apis.pipeline.v1alpha2.WorkspaceDeclaration;
import io.fabric8.tekton.v1alpha1.internal.pipeline.pkg.apis.pipeline.v1alpha2.WorkspacePipelineDeclaration;
import io.fabric8.tekton.v1alpha1.internal.pipeline.pkg.apis.pipeline.v1alpha2.WorkspacePipelineTaskBinding;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_pod_Template",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_CloudEventDelivery",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_CloudEventDeliveryState",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_ClusterTask",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_ClusterTaskList",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_Condition",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_ConditionCheckStatus",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_ConditionList",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_ConditionSpec",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_Inputs",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_Outputs",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_Pipeline",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_PipelineList",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_PipelineRef",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_PipelineResourceBinding",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_PipelineResourceRef",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_PipelineResourceResult",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_PipelineRun",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_PipelineRunConditionCheckStatus",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_PipelineRunList",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_PipelineRunSpec",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_PipelineRunSpecServiceAccountName",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_PipelineRunStatus",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_PipelineRunTaskRunStatus",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_PipelineSpec",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_PipelineStatus",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_PipelineTask",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_SidecarState",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_StepState",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_Task",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_TaskList",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_TaskResource",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_TaskResourceBinding",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_TaskResult",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_TaskRun",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_TaskRunInputs",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_TaskRunList",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_TaskRunOutputs",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_TaskRunSpec",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_TaskRunStatus",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_TaskSpec",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_TestResult",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha2_Param",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha2_ParamSpec",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha2_PipelineDeclaredResource",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha2_PipelineTaskCondition",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha2_PipelineTaskInputResource",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha2_PipelineTaskOutputResource",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha2_PipelineTaskResources",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha2_Step",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha2_TaskRef",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha2_WorkspaceBinding",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha2_WorkspaceDeclaration",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha2_WorkspacePipelineDeclaration",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha2_WorkspacePipelineTaskBinding",
    "github_com_tektoncd_pipeline_pkg_apis_resource_v1alpha1_PipelineResource",
    "github_com_tektoncd_pipeline_pkg_apis_resource_v1alpha1_PipelineResourceList",
    "github_com_tektoncd_pipeline_pkg_apis_resource_v1alpha1_PipelineResourceSpec",
    "github_com_tektoncd_pipeline_pkg_apis_resource_v1alpha1_PipelineResourceStatus",
    "github_com_tektoncd_pipeline_pkg_apis_resource_v1alpha1_ResourceDeclaration",
    "github_com_tektoncd_pipeline_pkg_apis_resource_v1alpha1_ResourceParam",
    "github_com_tektoncd_pipeline_pkg_apis_resource_v1alpha1_SecretParam"
})
@ToString
@EqualsAndHashCode
@Setter
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
public class TektonSchemaV1alpha1 {

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_pod_Template")
    private Template githubComTektoncdPipelinePkgApisPipelinePodTemplate;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_CloudEventDelivery")
    private CloudEventDelivery githubComTektoncdPipelinePkgApisPipelineV1alpha1CloudEventDelivery;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_CloudEventDeliveryState")
    private CloudEventDeliveryState githubComTektoncdPipelinePkgApisPipelineV1alpha1CloudEventDeliveryState;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_ClusterTask")
    private ClusterTask githubComTektoncdPipelinePkgApisPipelineV1alpha1ClusterTask;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_ClusterTaskList")
    private ClusterTaskList githubComTektoncdPipelinePkgApisPipelineV1alpha1ClusterTaskList;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_Condition")
    private Condition githubComTektoncdPipelinePkgApisPipelineV1alpha1Condition;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_ConditionCheckStatus")
    private ConditionCheckStatus githubComTektoncdPipelinePkgApisPipelineV1alpha1ConditionCheckStatus;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_ConditionList")
    private ConditionList githubComTektoncdPipelinePkgApisPipelineV1alpha1ConditionList;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_ConditionSpec")
    private ConditionSpec githubComTektoncdPipelinePkgApisPipelineV1alpha1ConditionSpec;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_Inputs")
    private Inputs githubComTektoncdPipelinePkgApisPipelineV1alpha1Inputs;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_Outputs")
    private Outputs githubComTektoncdPipelinePkgApisPipelineV1alpha1Outputs;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_Pipeline")
    private Pipeline githubComTektoncdPipelinePkgApisPipelineV1alpha1Pipeline;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_PipelineList")
    private PipelineList githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineList;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_PipelineRef")
    private PipelineRef githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineRef;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_PipelineResourceBinding")
    private PipelineResourceBinding githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineResourceBinding;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_PipelineResourceRef")
    private PipelineResourceRef githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineResourceRef;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_PipelineResourceResult")
    private PipelineResourceResult githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineResourceResult;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_PipelineRun")
    private PipelineRun githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineRun;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_PipelineRunConditionCheckStatus")
    private PipelineRunConditionCheckStatus githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineRunConditionCheckStatus;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_PipelineRunList")
    private PipelineRunList githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineRunList;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_PipelineRunSpec")
    private PipelineRunSpec githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineRunSpec;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_PipelineRunSpecServiceAccountName")
    private PipelineRunSpecServiceAccountName githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineRunSpecServiceAccountName;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_PipelineRunStatus")
    private PipelineRunStatus githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineRunStatus;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_PipelineRunTaskRunStatus")
    private PipelineRunTaskRunStatus githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineRunTaskRunStatus;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_PipelineSpec")
    private PipelineSpec githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineSpec;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_PipelineStatus")
    private PipelineStatus githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineStatus;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_PipelineTask")
    private PipelineTask githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineTask;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_SidecarState")
    private SidecarState githubComTektoncdPipelinePkgApisPipelineV1alpha1SidecarState;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_StepState")
    private StepState githubComTektoncdPipelinePkgApisPipelineV1alpha1StepState;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_Task")
    private Task githubComTektoncdPipelinePkgApisPipelineV1alpha1Task;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_TaskList")
    private TaskList githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskList;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_TaskResource")
    private TaskResource githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskResource;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_TaskResourceBinding")
    private TaskResourceBinding githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskResourceBinding;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_TaskResult")
    private TaskResult githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskResult;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_TaskRun")
    private TaskRun githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskRun;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_TaskRunInputs")
    private TaskRunInputs githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskRunInputs;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_TaskRunList")
    private TaskRunList githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskRunList;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_TaskRunOutputs")
    private TaskRunOutputs githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskRunOutputs;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_TaskRunSpec")
    private TaskRunSpec githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskRunSpec;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_TaskRunStatus")
    private TaskRunStatus githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskRunStatus;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_TaskSpec")
    private TaskSpec githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskSpec;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_TestResult")
    private TestResult githubComTektoncdPipelinePkgApisPipelineV1alpha1TestResult;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha2_Param")
    private Param githubComTektoncdPipelinePkgApisPipelineV1alpha2Param;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha2_ParamSpec")
    private ParamSpec githubComTektoncdPipelinePkgApisPipelineV1alpha2ParamSpec;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha2_PipelineDeclaredResource")
    private PipelineDeclaredResource githubComTektoncdPipelinePkgApisPipelineV1alpha2PipelineDeclaredResource;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha2_PipelineTaskCondition")
    private PipelineTaskCondition githubComTektoncdPipelinePkgApisPipelineV1alpha2PipelineTaskCondition;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha2_PipelineTaskInputResource")
    private PipelineTaskInputResource githubComTektoncdPipelinePkgApisPipelineV1alpha2PipelineTaskInputResource;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha2_PipelineTaskOutputResource")
    private PipelineTaskOutputResource githubComTektoncdPipelinePkgApisPipelineV1alpha2PipelineTaskOutputResource;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha2_PipelineTaskResources")
    private PipelineTaskResources githubComTektoncdPipelinePkgApisPipelineV1alpha2PipelineTaskResources;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha2_Step")
    private Step githubComTektoncdPipelinePkgApisPipelineV1alpha2Step;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha2_TaskRef")
    private TaskRef githubComTektoncdPipelinePkgApisPipelineV1alpha2TaskRef;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha2_WorkspaceBinding")
    private WorkspaceBinding githubComTektoncdPipelinePkgApisPipelineV1alpha2WorkspaceBinding;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha2_WorkspaceDeclaration")
    private WorkspaceDeclaration githubComTektoncdPipelinePkgApisPipelineV1alpha2WorkspaceDeclaration;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha2_WorkspacePipelineDeclaration")
    private WorkspacePipelineDeclaration githubComTektoncdPipelinePkgApisPipelineV1alpha2WorkspacePipelineDeclaration;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha2_WorkspacePipelineTaskBinding")
    private WorkspacePipelineTaskBinding githubComTektoncdPipelinePkgApisPipelineV1alpha2WorkspacePipelineTaskBinding;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_resource_v1alpha1_PipelineResource")
    private PipelineResource githubComTektoncdPipelinePkgApisResourceV1alpha1PipelineResource;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_resource_v1alpha1_PipelineResourceList")
    private PipelineResourceList githubComTektoncdPipelinePkgApisResourceV1alpha1PipelineResourceList;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_resource_v1alpha1_PipelineResourceSpec")
    private PipelineResourceSpec githubComTektoncdPipelinePkgApisResourceV1alpha1PipelineResourceSpec;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_resource_v1alpha1_PipelineResourceStatus")
    private PipelineResourceStatus githubComTektoncdPipelinePkgApisResourceV1alpha1PipelineResourceStatus;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_resource_v1alpha1_ResourceDeclaration")
    private ResourceDeclaration githubComTektoncdPipelinePkgApisResourceV1alpha1ResourceDeclaration;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_resource_v1alpha1_ResourceParam")
    private ResourceParam githubComTektoncdPipelinePkgApisResourceV1alpha1ResourceParam;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_resource_v1alpha1_SecretParam")
    private SecretParam githubComTektoncdPipelinePkgApisResourceV1alpha1SecretParam;

    /**
     * No args constructor for use in serialization
     * 
     */
    public TektonSchemaV1alpha1() {
    }

    /**
     * 
     * @param githubComTektoncdPipelinePkgApisPipelineV1alpha2PipelineTaskInputResource
     * @param githubComTektoncdPipelinePkgApisResourceV1alpha1PipelineResource
     * @param githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineRun
     * @param githubComTektoncdPipelinePkgApisResourceV1alpha1PipelineResourceStatus
     * @param githubComTektoncdPipelinePkgApisPipelineV1alpha1Inputs
     * @param githubComTektoncdPipelinePkgApisPipelineV1alpha2PipelineTaskResources
     * @param githubComTektoncdPipelinePkgApisPipelineV1alpha1CloudEventDeliveryState
     * @param githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineResourceBinding
     * @param githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskRun
     * @param githubComTektoncdPipelinePkgApisPipelineV1alpha2Step
     * @param githubComTektoncdPipelinePkgApisPipelineV1alpha2PipelineTaskCondition
     * @param githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineRunList
     * @param githubComTektoncdPipelinePkgApisPipelineV1alpha2TaskRef
     * @param githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineRef
     * @param githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineTask
     * @param githubComTektoncdPipelinePkgApisPipelineV1alpha1SidecarState
     * @param githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskResourceBinding
     * @param githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineRunSpec
     * @param githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskRunStatus
     * @param githubComTektoncdPipelinePkgApisPipelineV1alpha2PipelineTaskOutputResource
     * @param githubComTektoncdPipelinePkgApisPipelineV1alpha1ConditionCheckStatus
     * @param githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineResourceResult
     * @param githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineRunTaskRunStatus
     * @param githubComTektoncdPipelinePkgApisPipelineV1alpha2WorkspacePipelineTaskBinding
     * @param githubComTektoncdPipelinePkgApisPipelineV1alpha1Condition
     * @param githubComTektoncdPipelinePkgApisPipelineV1alpha2ParamSpec
     * @param githubComTektoncdPipelinePkgApisResourceV1alpha1SecretParam
     * @param githubComTektoncdPipelinePkgApisPipelineV1alpha1CloudEventDelivery
     * @param githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineList
     * @param githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskResult
     * @param githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineRunSpecServiceAccountName
     * @param githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskResource
     * @param githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineResourceRef
     * @param githubComTektoncdPipelinePkgApisPipelineV1alpha1Pipeline
     * @param githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskRunSpec
     * @param githubComTektoncdPipelinePkgApisPipelineV1alpha2WorkspaceBinding
     * @param githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineStatus
     * @param githubComTektoncdPipelinePkgApisResourceV1alpha1ResourceDeclaration
     * @param githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineSpec
     * @param githubComTektoncdPipelinePkgApisPipelineV1alpha2WorkspaceDeclaration
     * @param githubComTektoncdPipelinePkgApisPipelineV1alpha1ClusterTask
     * @param githubComTektoncdPipelinePkgApisPipelineV1alpha1StepState
     * @param githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskSpec
     * @param githubComTektoncdPipelinePkgApisPipelineV1alpha1ConditionSpec
     * @param githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineRunStatus
     * @param githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskRunInputs
     * @param githubComTektoncdPipelinePkgApisResourceV1alpha1PipelineResourceSpec
     * @param githubComTektoncdPipelinePkgApisPipelinePodTemplate
     * @param githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineRunConditionCheckStatus
     * @param githubComTektoncdPipelinePkgApisPipelineV1alpha1TestResult
     * @param githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskRunOutputs
     * @param githubComTektoncdPipelinePkgApisPipelineV1alpha1Outputs
     * @param githubComTektoncdPipelinePkgApisResourceV1alpha1ResourceParam
     * @param githubComTektoncdPipelinePkgApisPipelineV1alpha2Param
     * @param githubComTektoncdPipelinePkgApisPipelineV1alpha1Task
     * @param githubComTektoncdPipelinePkgApisPipelineV1alpha2PipelineDeclaredResource
     * @param githubComTektoncdPipelinePkgApisPipelineV1alpha1ClusterTaskList
     * @param githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskList
     * @param githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskRunList
     * @param githubComTektoncdPipelinePkgApisPipelineV1alpha1ConditionList
     * @param githubComTektoncdPipelinePkgApisPipelineV1alpha2WorkspacePipelineDeclaration
     * @param githubComTektoncdPipelinePkgApisResourceV1alpha1PipelineResourceList
     */
    public TektonSchemaV1alpha1(Template githubComTektoncdPipelinePkgApisPipelinePodTemplate, CloudEventDelivery githubComTektoncdPipelinePkgApisPipelineV1alpha1CloudEventDelivery, CloudEventDeliveryState githubComTektoncdPipelinePkgApisPipelineV1alpha1CloudEventDeliveryState, ClusterTask githubComTektoncdPipelinePkgApisPipelineV1alpha1ClusterTask, ClusterTaskList githubComTektoncdPipelinePkgApisPipelineV1alpha1ClusterTaskList, Condition githubComTektoncdPipelinePkgApisPipelineV1alpha1Condition, ConditionCheckStatus githubComTektoncdPipelinePkgApisPipelineV1alpha1ConditionCheckStatus, ConditionList githubComTektoncdPipelinePkgApisPipelineV1alpha1ConditionList, ConditionSpec githubComTektoncdPipelinePkgApisPipelineV1alpha1ConditionSpec, Inputs githubComTektoncdPipelinePkgApisPipelineV1alpha1Inputs, Outputs githubComTektoncdPipelinePkgApisPipelineV1alpha1Outputs, Pipeline githubComTektoncdPipelinePkgApisPipelineV1alpha1Pipeline, PipelineList githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineList, PipelineRef githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineRef, PipelineResourceBinding githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineResourceBinding, PipelineResourceRef githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineResourceRef, PipelineResourceResult githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineResourceResult, PipelineRun githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineRun, PipelineRunConditionCheckStatus githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineRunConditionCheckStatus, PipelineRunList githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineRunList, PipelineRunSpec githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineRunSpec, PipelineRunSpecServiceAccountName githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineRunSpecServiceAccountName, PipelineRunStatus githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineRunStatus, PipelineRunTaskRunStatus githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineRunTaskRunStatus, PipelineSpec githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineSpec, PipelineStatus githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineStatus, PipelineTask githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineTask, SidecarState githubComTektoncdPipelinePkgApisPipelineV1alpha1SidecarState, StepState githubComTektoncdPipelinePkgApisPipelineV1alpha1StepState, Task githubComTektoncdPipelinePkgApisPipelineV1alpha1Task, TaskList githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskList, TaskResource githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskResource, TaskResourceBinding githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskResourceBinding, TaskResult githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskResult, TaskRun githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskRun, TaskRunInputs githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskRunInputs, TaskRunList githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskRunList, TaskRunOutputs githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskRunOutputs, TaskRunSpec githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskRunSpec, TaskRunStatus githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskRunStatus, TaskSpec githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskSpec, TestResult githubComTektoncdPipelinePkgApisPipelineV1alpha1TestResult, Param githubComTektoncdPipelinePkgApisPipelineV1alpha2Param, ParamSpec githubComTektoncdPipelinePkgApisPipelineV1alpha2ParamSpec, PipelineDeclaredResource githubComTektoncdPipelinePkgApisPipelineV1alpha2PipelineDeclaredResource, PipelineTaskCondition githubComTektoncdPipelinePkgApisPipelineV1alpha2PipelineTaskCondition, PipelineTaskInputResource githubComTektoncdPipelinePkgApisPipelineV1alpha2PipelineTaskInputResource, PipelineTaskOutputResource githubComTektoncdPipelinePkgApisPipelineV1alpha2PipelineTaskOutputResource, PipelineTaskResources githubComTektoncdPipelinePkgApisPipelineV1alpha2PipelineTaskResources, Step githubComTektoncdPipelinePkgApisPipelineV1alpha2Step, TaskRef githubComTektoncdPipelinePkgApisPipelineV1alpha2TaskRef, WorkspaceBinding githubComTektoncdPipelinePkgApisPipelineV1alpha2WorkspaceBinding, WorkspaceDeclaration githubComTektoncdPipelinePkgApisPipelineV1alpha2WorkspaceDeclaration, WorkspacePipelineDeclaration githubComTektoncdPipelinePkgApisPipelineV1alpha2WorkspacePipelineDeclaration, WorkspacePipelineTaskBinding githubComTektoncdPipelinePkgApisPipelineV1alpha2WorkspacePipelineTaskBinding, PipelineResource githubComTektoncdPipelinePkgApisResourceV1alpha1PipelineResource, PipelineResourceList githubComTektoncdPipelinePkgApisResourceV1alpha1PipelineResourceList, PipelineResourceSpec githubComTektoncdPipelinePkgApisResourceV1alpha1PipelineResourceSpec, PipelineResourceStatus githubComTektoncdPipelinePkgApisResourceV1alpha1PipelineResourceStatus, ResourceDeclaration githubComTektoncdPipelinePkgApisResourceV1alpha1ResourceDeclaration, ResourceParam githubComTektoncdPipelinePkgApisResourceV1alpha1ResourceParam, SecretParam githubComTektoncdPipelinePkgApisResourceV1alpha1SecretParam) {
        super();
        this.githubComTektoncdPipelinePkgApisPipelinePodTemplate = githubComTektoncdPipelinePkgApisPipelinePodTemplate;
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha1CloudEventDelivery = githubComTektoncdPipelinePkgApisPipelineV1alpha1CloudEventDelivery;
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha1CloudEventDeliveryState = githubComTektoncdPipelinePkgApisPipelineV1alpha1CloudEventDeliveryState;
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha1ClusterTask = githubComTektoncdPipelinePkgApisPipelineV1alpha1ClusterTask;
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha1ClusterTaskList = githubComTektoncdPipelinePkgApisPipelineV1alpha1ClusterTaskList;
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha1Condition = githubComTektoncdPipelinePkgApisPipelineV1alpha1Condition;
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha1ConditionCheckStatus = githubComTektoncdPipelinePkgApisPipelineV1alpha1ConditionCheckStatus;
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha1ConditionList = githubComTektoncdPipelinePkgApisPipelineV1alpha1ConditionList;
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha1ConditionSpec = githubComTektoncdPipelinePkgApisPipelineV1alpha1ConditionSpec;
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha1Inputs = githubComTektoncdPipelinePkgApisPipelineV1alpha1Inputs;
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha1Outputs = githubComTektoncdPipelinePkgApisPipelineV1alpha1Outputs;
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha1Pipeline = githubComTektoncdPipelinePkgApisPipelineV1alpha1Pipeline;
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineList = githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineList;
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineRef = githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineRef;
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineResourceBinding = githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineResourceBinding;
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineResourceRef = githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineResourceRef;
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineResourceResult = githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineResourceResult;
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineRun = githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineRun;
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineRunConditionCheckStatus = githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineRunConditionCheckStatus;
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineRunList = githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineRunList;
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineRunSpec = githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineRunSpec;
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineRunSpecServiceAccountName = githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineRunSpecServiceAccountName;
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineRunStatus = githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineRunStatus;
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineRunTaskRunStatus = githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineRunTaskRunStatus;
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineSpec = githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineSpec;
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineStatus = githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineStatus;
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineTask = githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineTask;
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha1SidecarState = githubComTektoncdPipelinePkgApisPipelineV1alpha1SidecarState;
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha1StepState = githubComTektoncdPipelinePkgApisPipelineV1alpha1StepState;
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha1Task = githubComTektoncdPipelinePkgApisPipelineV1alpha1Task;
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskList = githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskList;
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskResource = githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskResource;
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskResourceBinding = githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskResourceBinding;
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskResult = githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskResult;
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskRun = githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskRun;
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskRunInputs = githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskRunInputs;
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskRunList = githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskRunList;
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskRunOutputs = githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskRunOutputs;
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskRunSpec = githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskRunSpec;
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskRunStatus = githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskRunStatus;
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskSpec = githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskSpec;
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha1TestResult = githubComTektoncdPipelinePkgApisPipelineV1alpha1TestResult;
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha2Param = githubComTektoncdPipelinePkgApisPipelineV1alpha2Param;
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha2ParamSpec = githubComTektoncdPipelinePkgApisPipelineV1alpha2ParamSpec;
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha2PipelineDeclaredResource = githubComTektoncdPipelinePkgApisPipelineV1alpha2PipelineDeclaredResource;
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha2PipelineTaskCondition = githubComTektoncdPipelinePkgApisPipelineV1alpha2PipelineTaskCondition;
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha2PipelineTaskInputResource = githubComTektoncdPipelinePkgApisPipelineV1alpha2PipelineTaskInputResource;
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha2PipelineTaskOutputResource = githubComTektoncdPipelinePkgApisPipelineV1alpha2PipelineTaskOutputResource;
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha2PipelineTaskResources = githubComTektoncdPipelinePkgApisPipelineV1alpha2PipelineTaskResources;
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha2Step = githubComTektoncdPipelinePkgApisPipelineV1alpha2Step;
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha2TaskRef = githubComTektoncdPipelinePkgApisPipelineV1alpha2TaskRef;
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha2WorkspaceBinding = githubComTektoncdPipelinePkgApisPipelineV1alpha2WorkspaceBinding;
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha2WorkspaceDeclaration = githubComTektoncdPipelinePkgApisPipelineV1alpha2WorkspaceDeclaration;
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha2WorkspacePipelineDeclaration = githubComTektoncdPipelinePkgApisPipelineV1alpha2WorkspacePipelineDeclaration;
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha2WorkspacePipelineTaskBinding = githubComTektoncdPipelinePkgApisPipelineV1alpha2WorkspacePipelineTaskBinding;
        this.githubComTektoncdPipelinePkgApisResourceV1alpha1PipelineResource = githubComTektoncdPipelinePkgApisResourceV1alpha1PipelineResource;
        this.githubComTektoncdPipelinePkgApisResourceV1alpha1PipelineResourceList = githubComTektoncdPipelinePkgApisResourceV1alpha1PipelineResourceList;
        this.githubComTektoncdPipelinePkgApisResourceV1alpha1PipelineResourceSpec = githubComTektoncdPipelinePkgApisResourceV1alpha1PipelineResourceSpec;
        this.githubComTektoncdPipelinePkgApisResourceV1alpha1PipelineResourceStatus = githubComTektoncdPipelinePkgApisResourceV1alpha1PipelineResourceStatus;
        this.githubComTektoncdPipelinePkgApisResourceV1alpha1ResourceDeclaration = githubComTektoncdPipelinePkgApisResourceV1alpha1ResourceDeclaration;
        this.githubComTektoncdPipelinePkgApisResourceV1alpha1ResourceParam = githubComTektoncdPipelinePkgApisResourceV1alpha1ResourceParam;
        this.githubComTektoncdPipelinePkgApisResourceV1alpha1SecretParam = githubComTektoncdPipelinePkgApisResourceV1alpha1SecretParam;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_pod_Template")
    public Template getGithubComTektoncdPipelinePkgApisPipelinePodTemplate() {
        return githubComTektoncdPipelinePkgApisPipelinePodTemplate;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_pod_Template")
    public void setGithubComTektoncdPipelinePkgApisPipelinePodTemplate(Template githubComTektoncdPipelinePkgApisPipelinePodTemplate) {
        this.githubComTektoncdPipelinePkgApisPipelinePodTemplate = githubComTektoncdPipelinePkgApisPipelinePodTemplate;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_CloudEventDelivery")
    public CloudEventDelivery getGithubComTektoncdPipelinePkgApisPipelineV1alpha1CloudEventDelivery() {
        return githubComTektoncdPipelinePkgApisPipelineV1alpha1CloudEventDelivery;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_CloudEventDelivery")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1alpha1CloudEventDelivery(CloudEventDelivery githubComTektoncdPipelinePkgApisPipelineV1alpha1CloudEventDelivery) {
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha1CloudEventDelivery = githubComTektoncdPipelinePkgApisPipelineV1alpha1CloudEventDelivery;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_CloudEventDeliveryState")
    public CloudEventDeliveryState getGithubComTektoncdPipelinePkgApisPipelineV1alpha1CloudEventDeliveryState() {
        return githubComTektoncdPipelinePkgApisPipelineV1alpha1CloudEventDeliveryState;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_CloudEventDeliveryState")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1alpha1CloudEventDeliveryState(CloudEventDeliveryState githubComTektoncdPipelinePkgApisPipelineV1alpha1CloudEventDeliveryState) {
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha1CloudEventDeliveryState = githubComTektoncdPipelinePkgApisPipelineV1alpha1CloudEventDeliveryState;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_ClusterTask")
    public ClusterTask getGithubComTektoncdPipelinePkgApisPipelineV1alpha1ClusterTask() {
        return githubComTektoncdPipelinePkgApisPipelineV1alpha1ClusterTask;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_ClusterTask")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1alpha1ClusterTask(ClusterTask githubComTektoncdPipelinePkgApisPipelineV1alpha1ClusterTask) {
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha1ClusterTask = githubComTektoncdPipelinePkgApisPipelineV1alpha1ClusterTask;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_ClusterTaskList")
    public ClusterTaskList getGithubComTektoncdPipelinePkgApisPipelineV1alpha1ClusterTaskList() {
        return githubComTektoncdPipelinePkgApisPipelineV1alpha1ClusterTaskList;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_ClusterTaskList")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1alpha1ClusterTaskList(ClusterTaskList githubComTektoncdPipelinePkgApisPipelineV1alpha1ClusterTaskList) {
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha1ClusterTaskList = githubComTektoncdPipelinePkgApisPipelineV1alpha1ClusterTaskList;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_Condition")
    public Condition getGithubComTektoncdPipelinePkgApisPipelineV1alpha1Condition() {
        return githubComTektoncdPipelinePkgApisPipelineV1alpha1Condition;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_Condition")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1alpha1Condition(Condition githubComTektoncdPipelinePkgApisPipelineV1alpha1Condition) {
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha1Condition = githubComTektoncdPipelinePkgApisPipelineV1alpha1Condition;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_ConditionCheckStatus")
    public ConditionCheckStatus getGithubComTektoncdPipelinePkgApisPipelineV1alpha1ConditionCheckStatus() {
        return githubComTektoncdPipelinePkgApisPipelineV1alpha1ConditionCheckStatus;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_ConditionCheckStatus")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1alpha1ConditionCheckStatus(ConditionCheckStatus githubComTektoncdPipelinePkgApisPipelineV1alpha1ConditionCheckStatus) {
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha1ConditionCheckStatus = githubComTektoncdPipelinePkgApisPipelineV1alpha1ConditionCheckStatus;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_ConditionList")
    public ConditionList getGithubComTektoncdPipelinePkgApisPipelineV1alpha1ConditionList() {
        return githubComTektoncdPipelinePkgApisPipelineV1alpha1ConditionList;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_ConditionList")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1alpha1ConditionList(ConditionList githubComTektoncdPipelinePkgApisPipelineV1alpha1ConditionList) {
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha1ConditionList = githubComTektoncdPipelinePkgApisPipelineV1alpha1ConditionList;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_ConditionSpec")
    public ConditionSpec getGithubComTektoncdPipelinePkgApisPipelineV1alpha1ConditionSpec() {
        return githubComTektoncdPipelinePkgApisPipelineV1alpha1ConditionSpec;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_ConditionSpec")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1alpha1ConditionSpec(ConditionSpec githubComTektoncdPipelinePkgApisPipelineV1alpha1ConditionSpec) {
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha1ConditionSpec = githubComTektoncdPipelinePkgApisPipelineV1alpha1ConditionSpec;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_Inputs")
    public Inputs getGithubComTektoncdPipelinePkgApisPipelineV1alpha1Inputs() {
        return githubComTektoncdPipelinePkgApisPipelineV1alpha1Inputs;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_Inputs")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1alpha1Inputs(Inputs githubComTektoncdPipelinePkgApisPipelineV1alpha1Inputs) {
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha1Inputs = githubComTektoncdPipelinePkgApisPipelineV1alpha1Inputs;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_Outputs")
    public Outputs getGithubComTektoncdPipelinePkgApisPipelineV1alpha1Outputs() {
        return githubComTektoncdPipelinePkgApisPipelineV1alpha1Outputs;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_Outputs")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1alpha1Outputs(Outputs githubComTektoncdPipelinePkgApisPipelineV1alpha1Outputs) {
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha1Outputs = githubComTektoncdPipelinePkgApisPipelineV1alpha1Outputs;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_Pipeline")
    public Pipeline getGithubComTektoncdPipelinePkgApisPipelineV1alpha1Pipeline() {
        return githubComTektoncdPipelinePkgApisPipelineV1alpha1Pipeline;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_Pipeline")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1alpha1Pipeline(Pipeline githubComTektoncdPipelinePkgApisPipelineV1alpha1Pipeline) {
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha1Pipeline = githubComTektoncdPipelinePkgApisPipelineV1alpha1Pipeline;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_PipelineList")
    public PipelineList getGithubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineList() {
        return githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineList;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_PipelineList")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineList(PipelineList githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineList) {
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineList = githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineList;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_PipelineRef")
    public PipelineRef getGithubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineRef() {
        return githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineRef;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_PipelineRef")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineRef(PipelineRef githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineRef) {
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineRef = githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineRef;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_PipelineResourceBinding")
    public PipelineResourceBinding getGithubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineResourceBinding() {
        return githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineResourceBinding;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_PipelineResourceBinding")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineResourceBinding(PipelineResourceBinding githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineResourceBinding) {
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineResourceBinding = githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineResourceBinding;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_PipelineResourceRef")
    public PipelineResourceRef getGithubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineResourceRef() {
        return githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineResourceRef;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_PipelineResourceRef")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineResourceRef(PipelineResourceRef githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineResourceRef) {
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineResourceRef = githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineResourceRef;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_PipelineResourceResult")
    public PipelineResourceResult getGithubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineResourceResult() {
        return githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineResourceResult;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_PipelineResourceResult")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineResourceResult(PipelineResourceResult githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineResourceResult) {
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineResourceResult = githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineResourceResult;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_PipelineRun")
    public PipelineRun getGithubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineRun() {
        return githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineRun;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_PipelineRun")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineRun(PipelineRun githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineRun) {
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineRun = githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineRun;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_PipelineRunConditionCheckStatus")
    public PipelineRunConditionCheckStatus getGithubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineRunConditionCheckStatus() {
        return githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineRunConditionCheckStatus;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_PipelineRunConditionCheckStatus")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineRunConditionCheckStatus(PipelineRunConditionCheckStatus githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineRunConditionCheckStatus) {
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineRunConditionCheckStatus = githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineRunConditionCheckStatus;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_PipelineRunList")
    public PipelineRunList getGithubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineRunList() {
        return githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineRunList;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_PipelineRunList")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineRunList(PipelineRunList githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineRunList) {
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineRunList = githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineRunList;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_PipelineRunSpec")
    public PipelineRunSpec getGithubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineRunSpec() {
        return githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineRunSpec;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_PipelineRunSpec")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineRunSpec(PipelineRunSpec githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineRunSpec) {
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineRunSpec = githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineRunSpec;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_PipelineRunSpecServiceAccountName")
    public PipelineRunSpecServiceAccountName getGithubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineRunSpecServiceAccountName() {
        return githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineRunSpecServiceAccountName;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_PipelineRunSpecServiceAccountName")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineRunSpecServiceAccountName(PipelineRunSpecServiceAccountName githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineRunSpecServiceAccountName) {
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineRunSpecServiceAccountName = githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineRunSpecServiceAccountName;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_PipelineRunStatus")
    public PipelineRunStatus getGithubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineRunStatus() {
        return githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineRunStatus;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_PipelineRunStatus")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineRunStatus(PipelineRunStatus githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineRunStatus) {
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineRunStatus = githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineRunStatus;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_PipelineRunTaskRunStatus")
    public PipelineRunTaskRunStatus getGithubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineRunTaskRunStatus() {
        return githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineRunTaskRunStatus;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_PipelineRunTaskRunStatus")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineRunTaskRunStatus(PipelineRunTaskRunStatus githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineRunTaskRunStatus) {
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineRunTaskRunStatus = githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineRunTaskRunStatus;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_PipelineSpec")
    public PipelineSpec getGithubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineSpec() {
        return githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineSpec;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_PipelineSpec")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineSpec(PipelineSpec githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineSpec) {
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineSpec = githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineSpec;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_PipelineStatus")
    public PipelineStatus getGithubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineStatus() {
        return githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineStatus;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_PipelineStatus")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineStatus(PipelineStatus githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineStatus) {
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineStatus = githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineStatus;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_PipelineTask")
    public PipelineTask getGithubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineTask() {
        return githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineTask;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_PipelineTask")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineTask(PipelineTask githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineTask) {
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineTask = githubComTektoncdPipelinePkgApisPipelineV1alpha1PipelineTask;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_SidecarState")
    public SidecarState getGithubComTektoncdPipelinePkgApisPipelineV1alpha1SidecarState() {
        return githubComTektoncdPipelinePkgApisPipelineV1alpha1SidecarState;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_SidecarState")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1alpha1SidecarState(SidecarState githubComTektoncdPipelinePkgApisPipelineV1alpha1SidecarState) {
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha1SidecarState = githubComTektoncdPipelinePkgApisPipelineV1alpha1SidecarState;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_StepState")
    public StepState getGithubComTektoncdPipelinePkgApisPipelineV1alpha1StepState() {
        return githubComTektoncdPipelinePkgApisPipelineV1alpha1StepState;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_StepState")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1alpha1StepState(StepState githubComTektoncdPipelinePkgApisPipelineV1alpha1StepState) {
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha1StepState = githubComTektoncdPipelinePkgApisPipelineV1alpha1StepState;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_Task")
    public Task getGithubComTektoncdPipelinePkgApisPipelineV1alpha1Task() {
        return githubComTektoncdPipelinePkgApisPipelineV1alpha1Task;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_Task")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1alpha1Task(Task githubComTektoncdPipelinePkgApisPipelineV1alpha1Task) {
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha1Task = githubComTektoncdPipelinePkgApisPipelineV1alpha1Task;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_TaskList")
    public TaskList getGithubComTektoncdPipelinePkgApisPipelineV1alpha1TaskList() {
        return githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskList;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_TaskList")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1alpha1TaskList(TaskList githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskList) {
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskList = githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskList;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_TaskResource")
    public TaskResource getGithubComTektoncdPipelinePkgApisPipelineV1alpha1TaskResource() {
        return githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskResource;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_TaskResource")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1alpha1TaskResource(TaskResource githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskResource) {
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskResource = githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskResource;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_TaskResourceBinding")
    public TaskResourceBinding getGithubComTektoncdPipelinePkgApisPipelineV1alpha1TaskResourceBinding() {
        return githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskResourceBinding;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_TaskResourceBinding")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1alpha1TaskResourceBinding(TaskResourceBinding githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskResourceBinding) {
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskResourceBinding = githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskResourceBinding;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_TaskResult")
    public TaskResult getGithubComTektoncdPipelinePkgApisPipelineV1alpha1TaskResult() {
        return githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskResult;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_TaskResult")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1alpha1TaskResult(TaskResult githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskResult) {
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskResult = githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskResult;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_TaskRun")
    public TaskRun getGithubComTektoncdPipelinePkgApisPipelineV1alpha1TaskRun() {
        return githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskRun;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_TaskRun")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1alpha1TaskRun(TaskRun githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskRun) {
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskRun = githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskRun;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_TaskRunInputs")
    public TaskRunInputs getGithubComTektoncdPipelinePkgApisPipelineV1alpha1TaskRunInputs() {
        return githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskRunInputs;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_TaskRunInputs")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1alpha1TaskRunInputs(TaskRunInputs githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskRunInputs) {
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskRunInputs = githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskRunInputs;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_TaskRunList")
    public TaskRunList getGithubComTektoncdPipelinePkgApisPipelineV1alpha1TaskRunList() {
        return githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskRunList;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_TaskRunList")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1alpha1TaskRunList(TaskRunList githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskRunList) {
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskRunList = githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskRunList;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_TaskRunOutputs")
    public TaskRunOutputs getGithubComTektoncdPipelinePkgApisPipelineV1alpha1TaskRunOutputs() {
        return githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskRunOutputs;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_TaskRunOutputs")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1alpha1TaskRunOutputs(TaskRunOutputs githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskRunOutputs) {
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskRunOutputs = githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskRunOutputs;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_TaskRunSpec")
    public TaskRunSpec getGithubComTektoncdPipelinePkgApisPipelineV1alpha1TaskRunSpec() {
        return githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskRunSpec;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_TaskRunSpec")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1alpha1TaskRunSpec(TaskRunSpec githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskRunSpec) {
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskRunSpec = githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskRunSpec;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_TaskRunStatus")
    public TaskRunStatus getGithubComTektoncdPipelinePkgApisPipelineV1alpha1TaskRunStatus() {
        return githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskRunStatus;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_TaskRunStatus")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1alpha1TaskRunStatus(TaskRunStatus githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskRunStatus) {
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskRunStatus = githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskRunStatus;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_TaskSpec")
    public TaskSpec getGithubComTektoncdPipelinePkgApisPipelineV1alpha1TaskSpec() {
        return githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskSpec;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_TaskSpec")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1alpha1TaskSpec(TaskSpec githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskSpec) {
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskSpec = githubComTektoncdPipelinePkgApisPipelineV1alpha1TaskSpec;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_TestResult")
    public TestResult getGithubComTektoncdPipelinePkgApisPipelineV1alpha1TestResult() {
        return githubComTektoncdPipelinePkgApisPipelineV1alpha1TestResult;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha1_TestResult")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1alpha1TestResult(TestResult githubComTektoncdPipelinePkgApisPipelineV1alpha1TestResult) {
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha1TestResult = githubComTektoncdPipelinePkgApisPipelineV1alpha1TestResult;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha2_Param")
    public Param getGithubComTektoncdPipelinePkgApisPipelineV1alpha2Param() {
        return githubComTektoncdPipelinePkgApisPipelineV1alpha2Param;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha2_Param")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1alpha2Param(Param githubComTektoncdPipelinePkgApisPipelineV1alpha2Param) {
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha2Param = githubComTektoncdPipelinePkgApisPipelineV1alpha2Param;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha2_ParamSpec")
    public ParamSpec getGithubComTektoncdPipelinePkgApisPipelineV1alpha2ParamSpec() {
        return githubComTektoncdPipelinePkgApisPipelineV1alpha2ParamSpec;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha2_ParamSpec")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1alpha2ParamSpec(ParamSpec githubComTektoncdPipelinePkgApisPipelineV1alpha2ParamSpec) {
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha2ParamSpec = githubComTektoncdPipelinePkgApisPipelineV1alpha2ParamSpec;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha2_PipelineDeclaredResource")
    public PipelineDeclaredResource getGithubComTektoncdPipelinePkgApisPipelineV1alpha2PipelineDeclaredResource() {
        return githubComTektoncdPipelinePkgApisPipelineV1alpha2PipelineDeclaredResource;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha2_PipelineDeclaredResource")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1alpha2PipelineDeclaredResource(PipelineDeclaredResource githubComTektoncdPipelinePkgApisPipelineV1alpha2PipelineDeclaredResource) {
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha2PipelineDeclaredResource = githubComTektoncdPipelinePkgApisPipelineV1alpha2PipelineDeclaredResource;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha2_PipelineTaskCondition")
    public PipelineTaskCondition getGithubComTektoncdPipelinePkgApisPipelineV1alpha2PipelineTaskCondition() {
        return githubComTektoncdPipelinePkgApisPipelineV1alpha2PipelineTaskCondition;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha2_PipelineTaskCondition")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1alpha2PipelineTaskCondition(PipelineTaskCondition githubComTektoncdPipelinePkgApisPipelineV1alpha2PipelineTaskCondition) {
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha2PipelineTaskCondition = githubComTektoncdPipelinePkgApisPipelineV1alpha2PipelineTaskCondition;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha2_PipelineTaskInputResource")
    public PipelineTaskInputResource getGithubComTektoncdPipelinePkgApisPipelineV1alpha2PipelineTaskInputResource() {
        return githubComTektoncdPipelinePkgApisPipelineV1alpha2PipelineTaskInputResource;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha2_PipelineTaskInputResource")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1alpha2PipelineTaskInputResource(PipelineTaskInputResource githubComTektoncdPipelinePkgApisPipelineV1alpha2PipelineTaskInputResource) {
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha2PipelineTaskInputResource = githubComTektoncdPipelinePkgApisPipelineV1alpha2PipelineTaskInputResource;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha2_PipelineTaskOutputResource")
    public PipelineTaskOutputResource getGithubComTektoncdPipelinePkgApisPipelineV1alpha2PipelineTaskOutputResource() {
        return githubComTektoncdPipelinePkgApisPipelineV1alpha2PipelineTaskOutputResource;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha2_PipelineTaskOutputResource")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1alpha2PipelineTaskOutputResource(PipelineTaskOutputResource githubComTektoncdPipelinePkgApisPipelineV1alpha2PipelineTaskOutputResource) {
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha2PipelineTaskOutputResource = githubComTektoncdPipelinePkgApisPipelineV1alpha2PipelineTaskOutputResource;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha2_PipelineTaskResources")
    public PipelineTaskResources getGithubComTektoncdPipelinePkgApisPipelineV1alpha2PipelineTaskResources() {
        return githubComTektoncdPipelinePkgApisPipelineV1alpha2PipelineTaskResources;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha2_PipelineTaskResources")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1alpha2PipelineTaskResources(PipelineTaskResources githubComTektoncdPipelinePkgApisPipelineV1alpha2PipelineTaskResources) {
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha2PipelineTaskResources = githubComTektoncdPipelinePkgApisPipelineV1alpha2PipelineTaskResources;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha2_Step")
    public Step getGithubComTektoncdPipelinePkgApisPipelineV1alpha2Step() {
        return githubComTektoncdPipelinePkgApisPipelineV1alpha2Step;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha2_Step")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1alpha2Step(Step githubComTektoncdPipelinePkgApisPipelineV1alpha2Step) {
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha2Step = githubComTektoncdPipelinePkgApisPipelineV1alpha2Step;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha2_TaskRef")
    public TaskRef getGithubComTektoncdPipelinePkgApisPipelineV1alpha2TaskRef() {
        return githubComTektoncdPipelinePkgApisPipelineV1alpha2TaskRef;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha2_TaskRef")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1alpha2TaskRef(TaskRef githubComTektoncdPipelinePkgApisPipelineV1alpha2TaskRef) {
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha2TaskRef = githubComTektoncdPipelinePkgApisPipelineV1alpha2TaskRef;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha2_WorkspaceBinding")
    public WorkspaceBinding getGithubComTektoncdPipelinePkgApisPipelineV1alpha2WorkspaceBinding() {
        return githubComTektoncdPipelinePkgApisPipelineV1alpha2WorkspaceBinding;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha2_WorkspaceBinding")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1alpha2WorkspaceBinding(WorkspaceBinding githubComTektoncdPipelinePkgApisPipelineV1alpha2WorkspaceBinding) {
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha2WorkspaceBinding = githubComTektoncdPipelinePkgApisPipelineV1alpha2WorkspaceBinding;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha2_WorkspaceDeclaration")
    public WorkspaceDeclaration getGithubComTektoncdPipelinePkgApisPipelineV1alpha2WorkspaceDeclaration() {
        return githubComTektoncdPipelinePkgApisPipelineV1alpha2WorkspaceDeclaration;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha2_WorkspaceDeclaration")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1alpha2WorkspaceDeclaration(WorkspaceDeclaration githubComTektoncdPipelinePkgApisPipelineV1alpha2WorkspaceDeclaration) {
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha2WorkspaceDeclaration = githubComTektoncdPipelinePkgApisPipelineV1alpha2WorkspaceDeclaration;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha2_WorkspacePipelineDeclaration")
    public WorkspacePipelineDeclaration getGithubComTektoncdPipelinePkgApisPipelineV1alpha2WorkspacePipelineDeclaration() {
        return githubComTektoncdPipelinePkgApisPipelineV1alpha2WorkspacePipelineDeclaration;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha2_WorkspacePipelineDeclaration")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1alpha2WorkspacePipelineDeclaration(WorkspacePipelineDeclaration githubComTektoncdPipelinePkgApisPipelineV1alpha2WorkspacePipelineDeclaration) {
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha2WorkspacePipelineDeclaration = githubComTektoncdPipelinePkgApisPipelineV1alpha2WorkspacePipelineDeclaration;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha2_WorkspacePipelineTaskBinding")
    public WorkspacePipelineTaskBinding getGithubComTektoncdPipelinePkgApisPipelineV1alpha2WorkspacePipelineTaskBinding() {
        return githubComTektoncdPipelinePkgApisPipelineV1alpha2WorkspacePipelineTaskBinding;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1alpha2_WorkspacePipelineTaskBinding")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1alpha2WorkspacePipelineTaskBinding(WorkspacePipelineTaskBinding githubComTektoncdPipelinePkgApisPipelineV1alpha2WorkspacePipelineTaskBinding) {
        this.githubComTektoncdPipelinePkgApisPipelineV1alpha2WorkspacePipelineTaskBinding = githubComTektoncdPipelinePkgApisPipelineV1alpha2WorkspacePipelineTaskBinding;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_resource_v1alpha1_PipelineResource")
    public PipelineResource getGithubComTektoncdPipelinePkgApisResourceV1alpha1PipelineResource() {
        return githubComTektoncdPipelinePkgApisResourceV1alpha1PipelineResource;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_resource_v1alpha1_PipelineResource")
    public void setGithubComTektoncdPipelinePkgApisResourceV1alpha1PipelineResource(PipelineResource githubComTektoncdPipelinePkgApisResourceV1alpha1PipelineResource) {
        this.githubComTektoncdPipelinePkgApisResourceV1alpha1PipelineResource = githubComTektoncdPipelinePkgApisResourceV1alpha1PipelineResource;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_resource_v1alpha1_PipelineResourceList")
    public PipelineResourceList getGithubComTektoncdPipelinePkgApisResourceV1alpha1PipelineResourceList() {
        return githubComTektoncdPipelinePkgApisResourceV1alpha1PipelineResourceList;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_resource_v1alpha1_PipelineResourceList")
    public void setGithubComTektoncdPipelinePkgApisResourceV1alpha1PipelineResourceList(PipelineResourceList githubComTektoncdPipelinePkgApisResourceV1alpha1PipelineResourceList) {
        this.githubComTektoncdPipelinePkgApisResourceV1alpha1PipelineResourceList = githubComTektoncdPipelinePkgApisResourceV1alpha1PipelineResourceList;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_resource_v1alpha1_PipelineResourceSpec")
    public PipelineResourceSpec getGithubComTektoncdPipelinePkgApisResourceV1alpha1PipelineResourceSpec() {
        return githubComTektoncdPipelinePkgApisResourceV1alpha1PipelineResourceSpec;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_resource_v1alpha1_PipelineResourceSpec")
    public void setGithubComTektoncdPipelinePkgApisResourceV1alpha1PipelineResourceSpec(PipelineResourceSpec githubComTektoncdPipelinePkgApisResourceV1alpha1PipelineResourceSpec) {
        this.githubComTektoncdPipelinePkgApisResourceV1alpha1PipelineResourceSpec = githubComTektoncdPipelinePkgApisResourceV1alpha1PipelineResourceSpec;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_resource_v1alpha1_PipelineResourceStatus")
    public PipelineResourceStatus getGithubComTektoncdPipelinePkgApisResourceV1alpha1PipelineResourceStatus() {
        return githubComTektoncdPipelinePkgApisResourceV1alpha1PipelineResourceStatus;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_resource_v1alpha1_PipelineResourceStatus")
    public void setGithubComTektoncdPipelinePkgApisResourceV1alpha1PipelineResourceStatus(PipelineResourceStatus githubComTektoncdPipelinePkgApisResourceV1alpha1PipelineResourceStatus) {
        this.githubComTektoncdPipelinePkgApisResourceV1alpha1PipelineResourceStatus = githubComTektoncdPipelinePkgApisResourceV1alpha1PipelineResourceStatus;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_resource_v1alpha1_ResourceDeclaration")
    public ResourceDeclaration getGithubComTektoncdPipelinePkgApisResourceV1alpha1ResourceDeclaration() {
        return githubComTektoncdPipelinePkgApisResourceV1alpha1ResourceDeclaration;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_resource_v1alpha1_ResourceDeclaration")
    public void setGithubComTektoncdPipelinePkgApisResourceV1alpha1ResourceDeclaration(ResourceDeclaration githubComTektoncdPipelinePkgApisResourceV1alpha1ResourceDeclaration) {
        this.githubComTektoncdPipelinePkgApisResourceV1alpha1ResourceDeclaration = githubComTektoncdPipelinePkgApisResourceV1alpha1ResourceDeclaration;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_resource_v1alpha1_ResourceParam")
    public ResourceParam getGithubComTektoncdPipelinePkgApisResourceV1alpha1ResourceParam() {
        return githubComTektoncdPipelinePkgApisResourceV1alpha1ResourceParam;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_resource_v1alpha1_ResourceParam")
    public void setGithubComTektoncdPipelinePkgApisResourceV1alpha1ResourceParam(ResourceParam githubComTektoncdPipelinePkgApisResourceV1alpha1ResourceParam) {
        this.githubComTektoncdPipelinePkgApisResourceV1alpha1ResourceParam = githubComTektoncdPipelinePkgApisResourceV1alpha1ResourceParam;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_resource_v1alpha1_SecretParam")
    public SecretParam getGithubComTektoncdPipelinePkgApisResourceV1alpha1SecretParam() {
        return githubComTektoncdPipelinePkgApisResourceV1alpha1SecretParam;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_resource_v1alpha1_SecretParam")
    public void setGithubComTektoncdPipelinePkgApisResourceV1alpha1SecretParam(SecretParam githubComTektoncdPipelinePkgApisResourceV1alpha1SecretParam) {
        this.githubComTektoncdPipelinePkgApisResourceV1alpha1SecretParam = githubComTektoncdPipelinePkgApisResourceV1alpha1SecretParam;
    }

}
