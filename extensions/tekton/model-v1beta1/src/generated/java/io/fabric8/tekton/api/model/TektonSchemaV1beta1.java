
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
import io.fabric8.tekton.pipeline.v1beta1.ChildStatusReference;
import io.fabric8.tekton.pipeline.v1beta1.CloudEventDelivery;
import io.fabric8.tekton.pipeline.v1beta1.CloudEventDeliveryState;
import io.fabric8.tekton.pipeline.v1beta1.ClusterTask;
import io.fabric8.tekton.pipeline.v1beta1.ClusterTaskList;
import io.fabric8.tekton.pipeline.v1beta1.ConditionCheckStatus;
import io.fabric8.tekton.pipeline.v1beta1.EmbeddedTask;
import io.fabric8.tekton.pipeline.v1beta1.Param;
import io.fabric8.tekton.pipeline.v1beta1.ParamSpec;
import io.fabric8.tekton.pipeline.v1beta1.Pipeline;
import io.fabric8.tekton.pipeline.v1beta1.PipelineDeclaredResource;
import io.fabric8.tekton.pipeline.v1beta1.PipelineList;
import io.fabric8.tekton.pipeline.v1beta1.PipelineRef;
import io.fabric8.tekton.pipeline.v1beta1.PipelineResourceBinding;
import io.fabric8.tekton.pipeline.v1beta1.PipelineResourceRef;
import io.fabric8.tekton.pipeline.v1beta1.PipelineResourceResult;
import io.fabric8.tekton.pipeline.v1beta1.PipelineResult;
import io.fabric8.tekton.pipeline.v1beta1.PipelineRun;
import io.fabric8.tekton.pipeline.v1beta1.PipelineRunChildConditionCheckStatus;
import io.fabric8.tekton.pipeline.v1beta1.PipelineRunConditionCheckStatus;
import io.fabric8.tekton.pipeline.v1beta1.PipelineRunList;
import io.fabric8.tekton.pipeline.v1beta1.PipelineRunResult;
import io.fabric8.tekton.pipeline.v1beta1.PipelineRunRunStatus;
import io.fabric8.tekton.pipeline.v1beta1.PipelineRunSpec;
import io.fabric8.tekton.pipeline.v1beta1.PipelineRunSpecServiceAccountName;
import io.fabric8.tekton.pipeline.v1beta1.PipelineRunStatus;
import io.fabric8.tekton.pipeline.v1beta1.PipelineRunTaskRunStatus;
import io.fabric8.tekton.pipeline.v1beta1.PipelineSpec;
import io.fabric8.tekton.pipeline.v1beta1.PipelineTask;
import io.fabric8.tekton.pipeline.v1beta1.PipelineTaskCondition;
import io.fabric8.tekton.pipeline.v1beta1.PipelineTaskInputResource;
import io.fabric8.tekton.pipeline.v1beta1.PipelineTaskMetadata;
import io.fabric8.tekton.pipeline.v1beta1.PipelineTaskOutputResource;
import io.fabric8.tekton.pipeline.v1beta1.PipelineTaskResources;
import io.fabric8.tekton.pipeline.v1beta1.PipelineTaskRunSpec;
import io.fabric8.tekton.pipeline.v1beta1.PipelineWorkspaceDeclaration;
import io.fabric8.tekton.pipeline.v1beta1.ResolverParam;
import io.fabric8.tekton.pipeline.v1beta1.Sidecar;
import io.fabric8.tekton.pipeline.v1beta1.SidecarState;
import io.fabric8.tekton.pipeline.v1beta1.SkippedTask;
import io.fabric8.tekton.pipeline.v1beta1.Step;
import io.fabric8.tekton.pipeline.v1beta1.StepState;
import io.fabric8.tekton.pipeline.v1beta1.Task;
import io.fabric8.tekton.pipeline.v1beta1.TaskList;
import io.fabric8.tekton.pipeline.v1beta1.TaskRef;
import io.fabric8.tekton.pipeline.v1beta1.TaskResource;
import io.fabric8.tekton.pipeline.v1beta1.TaskResourceBinding;
import io.fabric8.tekton.pipeline.v1beta1.TaskResources;
import io.fabric8.tekton.pipeline.v1beta1.TaskResult;
import io.fabric8.tekton.pipeline.v1beta1.TaskRun;
import io.fabric8.tekton.pipeline.v1beta1.TaskRunDebug;
import io.fabric8.tekton.pipeline.v1beta1.TaskRunList;
import io.fabric8.tekton.pipeline.v1beta1.TaskRunResources;
import io.fabric8.tekton.pipeline.v1beta1.TaskRunResult;
import io.fabric8.tekton.pipeline.v1beta1.TaskRunSidecarOverride;
import io.fabric8.tekton.pipeline.v1beta1.TaskRunSpec;
import io.fabric8.tekton.pipeline.v1beta1.TaskRunStatus;
import io.fabric8.tekton.pipeline.v1beta1.TaskRunStepOverride;
import io.fabric8.tekton.pipeline.v1beta1.TaskSpec;
import io.fabric8.tekton.pipeline.v1beta1.TimeoutFields;
import io.fabric8.tekton.pipeline.v1beta1.WhenExpression;
import io.fabric8.tekton.pipeline.v1beta1.WorkspaceBinding;
import io.fabric8.tekton.pipeline.v1beta1.WorkspaceDeclaration;
import io.fabric8.tekton.pipeline.v1beta1.WorkspacePipelineTaskBinding;
import io.fabric8.tekton.pipeline.v1beta1.WorkspaceUsage;
import io.fabric8.tekton.v1beta1.internal.pipeline.pkg.apis.pipeline.pod.Template;
import io.fabric8.tekton.v1beta1.internal.pipeline.pkg.apis.resource.v1alpha1.PipelineResourceSpec;
import io.fabric8.tekton.v1beta1.internal.pipeline.pkg.apis.resource.v1alpha1.ResourceParam;
import io.fabric8.tekton.v1beta1.internal.pipeline.pkg.apis.resource.v1alpha1.SecretParam;
import io.fabric8.tekton.v1beta1.internal.pipeline.pkg.apis.run.v1alpha1.RunResult;
import io.fabric8.tekton.v1beta1.internal.pipeline.pkg.apis.run.v1alpha1.RunStatus;
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
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_ChildStatusReference",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_CloudEventDelivery",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_CloudEventDeliveryState",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_ClusterTask",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_ClusterTaskList",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_ConditionCheckStatus",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_EmbeddedTask",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_Param",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_ParamSpec",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_Pipeline",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineDeclaredResource",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineList",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineRef",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineResourceBinding",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineResourceRef",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineResourceResult",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineResult",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineRun",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineRunChildConditionCheckStatus",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineRunConditionCheckStatus",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineRunList",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineRunResult",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineRunRunStatus",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineRunSpec",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineRunSpecServiceAccountName",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineRunStatus",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineRunTaskRunStatus",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineSpec",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineTask",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineTaskCondition",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineTaskInputResource",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineTaskMetadata",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineTaskOutputResource",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineTaskResources",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineTaskRunSpec",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineWorkspaceDeclaration",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_ResolverParam",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_Sidecar",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_SidecarState",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_SkippedTask",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_Step",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_StepState",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_Task",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_TaskList",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_TaskRef",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_TaskResource",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_TaskResourceBinding",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_TaskResources",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_TaskResult",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_TaskRun",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_TaskRunDebug",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_TaskRunList",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_TaskRunResources",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_TaskRunResult",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_TaskRunSidecarOverride",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_TaskRunSpec",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_TaskRunStatus",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_TaskRunStepOverride",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_TaskSpec",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_TimeoutFields",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_WhenExpression",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_WorkspaceBinding",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_WorkspaceDeclaration",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_WorkspacePipelineTaskBinding",
    "github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_WorkspaceUsage",
    "github_com_tektoncd_pipeline_pkg_apis_resource_v1alpha1_PipelineResourceSpec",
    "github_com_tektoncd_pipeline_pkg_apis_resource_v1alpha1_ResourceParam",
    "github_com_tektoncd_pipeline_pkg_apis_resource_v1alpha1_SecretParam",
    "github_com_tektoncd_pipeline_pkg_apis_run_v1alpha1_RunResult",
    "github_com_tektoncd_pipeline_pkg_apis_run_v1alpha1_RunStatus"
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
public class TektonSchemaV1beta1 {

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_pod_Template")
    private Template githubComTektoncdPipelinePkgApisPipelinePodTemplate;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_ChildStatusReference")
    private ChildStatusReference githubComTektoncdPipelinePkgApisPipelineV1beta1ChildStatusReference;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_CloudEventDelivery")
    private CloudEventDelivery githubComTektoncdPipelinePkgApisPipelineV1beta1CloudEventDelivery;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_CloudEventDeliveryState")
    private CloudEventDeliveryState githubComTektoncdPipelinePkgApisPipelineV1beta1CloudEventDeliveryState;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_ClusterTask")
    private ClusterTask githubComTektoncdPipelinePkgApisPipelineV1beta1ClusterTask;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_ClusterTaskList")
    private ClusterTaskList githubComTektoncdPipelinePkgApisPipelineV1beta1ClusterTaskList;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_ConditionCheckStatus")
    private ConditionCheckStatus githubComTektoncdPipelinePkgApisPipelineV1beta1ConditionCheckStatus;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_EmbeddedTask")
    private EmbeddedTask githubComTektoncdPipelinePkgApisPipelineV1beta1EmbeddedTask;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_Param")
    private Param githubComTektoncdPipelinePkgApisPipelineV1beta1Param;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_ParamSpec")
    private ParamSpec githubComTektoncdPipelinePkgApisPipelineV1beta1ParamSpec;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_Pipeline")
    private Pipeline githubComTektoncdPipelinePkgApisPipelineV1beta1Pipeline;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineDeclaredResource")
    private PipelineDeclaredResource githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineDeclaredResource;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineList")
    private PipelineList githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineList;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineRef")
    private PipelineRef githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRef;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineResourceBinding")
    private PipelineResourceBinding githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineResourceBinding;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineResourceRef")
    private PipelineResourceRef githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineResourceRef;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineResourceResult")
    private PipelineResourceResult githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineResourceResult;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineResult")
    private PipelineResult githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineResult;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineRun")
    private PipelineRun githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRun;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineRunChildConditionCheckStatus")
    private PipelineRunChildConditionCheckStatus githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunChildConditionCheckStatus;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineRunConditionCheckStatus")
    private PipelineRunConditionCheckStatus githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunConditionCheckStatus;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineRunList")
    private PipelineRunList githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunList;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineRunResult")
    private PipelineRunResult githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunResult;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineRunRunStatus")
    private PipelineRunRunStatus githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunRunStatus;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineRunSpec")
    private PipelineRunSpec githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunSpec;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineRunSpecServiceAccountName")
    private PipelineRunSpecServiceAccountName githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunSpecServiceAccountName;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineRunStatus")
    private PipelineRunStatus githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunStatus;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineRunTaskRunStatus")
    private PipelineRunTaskRunStatus githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunTaskRunStatus;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineSpec")
    private PipelineSpec githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineSpec;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineTask")
    private PipelineTask githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineTask;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineTaskCondition")
    private PipelineTaskCondition githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineTaskCondition;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineTaskInputResource")
    private PipelineTaskInputResource githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineTaskInputResource;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineTaskMetadata")
    private PipelineTaskMetadata githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineTaskMetadata;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineTaskOutputResource")
    private PipelineTaskOutputResource githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineTaskOutputResource;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineTaskResources")
    private PipelineTaskResources githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineTaskResources;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineTaskRunSpec")
    private PipelineTaskRunSpec githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineTaskRunSpec;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineWorkspaceDeclaration")
    private PipelineWorkspaceDeclaration githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineWorkspaceDeclaration;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_ResolverParam")
    private ResolverParam githubComTektoncdPipelinePkgApisPipelineV1beta1ResolverParam;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_Sidecar")
    private Sidecar githubComTektoncdPipelinePkgApisPipelineV1beta1Sidecar;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_SidecarState")
    private SidecarState githubComTektoncdPipelinePkgApisPipelineV1beta1SidecarState;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_SkippedTask")
    private SkippedTask githubComTektoncdPipelinePkgApisPipelineV1beta1SkippedTask;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_Step")
    private Step githubComTektoncdPipelinePkgApisPipelineV1beta1Step;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_StepState")
    private StepState githubComTektoncdPipelinePkgApisPipelineV1beta1StepState;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_Task")
    private Task githubComTektoncdPipelinePkgApisPipelineV1beta1Task;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_TaskList")
    private TaskList githubComTektoncdPipelinePkgApisPipelineV1beta1TaskList;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_TaskRef")
    private TaskRef githubComTektoncdPipelinePkgApisPipelineV1beta1TaskRef;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_TaskResource")
    private TaskResource githubComTektoncdPipelinePkgApisPipelineV1beta1TaskResource;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_TaskResourceBinding")
    private TaskResourceBinding githubComTektoncdPipelinePkgApisPipelineV1beta1TaskResourceBinding;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_TaskResources")
    private TaskResources githubComTektoncdPipelinePkgApisPipelineV1beta1TaskResources;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_TaskResult")
    private TaskResult githubComTektoncdPipelinePkgApisPipelineV1beta1TaskResult;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_TaskRun")
    private TaskRun githubComTektoncdPipelinePkgApisPipelineV1beta1TaskRun;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_TaskRunDebug")
    private TaskRunDebug githubComTektoncdPipelinePkgApisPipelineV1beta1TaskRunDebug;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_TaskRunList")
    private TaskRunList githubComTektoncdPipelinePkgApisPipelineV1beta1TaskRunList;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_TaskRunResources")
    private TaskRunResources githubComTektoncdPipelinePkgApisPipelineV1beta1TaskRunResources;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_TaskRunResult")
    private TaskRunResult githubComTektoncdPipelinePkgApisPipelineV1beta1TaskRunResult;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_TaskRunSidecarOverride")
    private TaskRunSidecarOverride githubComTektoncdPipelinePkgApisPipelineV1beta1TaskRunSidecarOverride;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_TaskRunSpec")
    private TaskRunSpec githubComTektoncdPipelinePkgApisPipelineV1beta1TaskRunSpec;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_TaskRunStatus")
    private TaskRunStatus githubComTektoncdPipelinePkgApisPipelineV1beta1TaskRunStatus;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_TaskRunStepOverride")
    private TaskRunStepOverride githubComTektoncdPipelinePkgApisPipelineV1beta1TaskRunStepOverride;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_TaskSpec")
    private TaskSpec githubComTektoncdPipelinePkgApisPipelineV1beta1TaskSpec;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_TimeoutFields")
    private TimeoutFields githubComTektoncdPipelinePkgApisPipelineV1beta1TimeoutFields;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_WhenExpression")
    private WhenExpression githubComTektoncdPipelinePkgApisPipelineV1beta1WhenExpression;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_WorkspaceBinding")
    private WorkspaceBinding githubComTektoncdPipelinePkgApisPipelineV1beta1WorkspaceBinding;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_WorkspaceDeclaration")
    private WorkspaceDeclaration githubComTektoncdPipelinePkgApisPipelineV1beta1WorkspaceDeclaration;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_WorkspacePipelineTaskBinding")
    private WorkspacePipelineTaskBinding githubComTektoncdPipelinePkgApisPipelineV1beta1WorkspacePipelineTaskBinding;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_WorkspaceUsage")
    private WorkspaceUsage githubComTektoncdPipelinePkgApisPipelineV1beta1WorkspaceUsage;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_resource_v1alpha1_PipelineResourceSpec")
    private PipelineResourceSpec githubComTektoncdPipelinePkgApisResourceV1alpha1PipelineResourceSpec;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_resource_v1alpha1_ResourceParam")
    private ResourceParam githubComTektoncdPipelinePkgApisResourceV1alpha1ResourceParam;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_resource_v1alpha1_SecretParam")
    private SecretParam githubComTektoncdPipelinePkgApisResourceV1alpha1SecretParam;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_run_v1alpha1_RunResult")
    private RunResult githubComTektoncdPipelinePkgApisRunV1alpha1RunResult;
    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_run_v1alpha1_RunStatus")
    private RunStatus githubComTektoncdPipelinePkgApisRunV1alpha1RunStatus;

    /**
     * No args constructor for use in serialization
     * 
     */
    public TektonSchemaV1beta1() {
    }

    /**
     * 
     * @param githubComTektoncdPipelinePkgApisPipelineV1beta1TaskResource
     * @param githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunList
     * @param githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineTaskMetadata
     * @param githubComTektoncdPipelinePkgApisPipelineV1beta1ResolverParam
     * @param githubComTektoncdPipelinePkgApisPipelineV1beta1ConditionCheckStatus
     * @param githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunStatus
     * @param githubComTektoncdPipelinePkgApisPipelineV1beta1Task
     * @param githubComTektoncdPipelinePkgApisPipelineV1beta1TaskResourceBinding
     * @param githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineSpec
     * @param githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineResult
     * @param githubComTektoncdPipelinePkgApisPipelineV1beta1ParamSpec
     * @param githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunSpecServiceAccountName
     * @param githubComTektoncdPipelinePkgApisPipelineV1beta1TaskRunResult
     * @param githubComTektoncdPipelinePkgApisPipelineV1beta1WorkspacePipelineTaskBinding
     * @param githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineResourceRef
     * @param githubComTektoncdPipelinePkgApisPipelineV1beta1TaskRunSidecarOverride
     * @param githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunTaskRunStatus
     * @param githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunResult
     * @param githubComTektoncdPipelinePkgApisPipelineV1beta1SidecarState
     * @param githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineTask
     * @param githubComTektoncdPipelinePkgApisPipelineV1beta1ClusterTaskList
     * @param githubComTektoncdPipelinePkgApisPipelineV1beta1TimeoutFields
     * @param githubComTektoncdPipelinePkgApisPipelineV1beta1Step
     * @param githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunRunStatus
     * @param githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineTaskCondition
     * @param githubComTektoncdPipelinePkgApisPipelineV1beta1WorkspaceBinding
     * @param githubComTektoncdPipelinePkgApisPipelineV1beta1TaskRunStepOverride
     * @param githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunChildConditionCheckStatus
     * @param githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineDeclaredResource
     * @param githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRun
     * @param githubComTektoncdPipelinePkgApisPipelineV1beta1TaskSpec
     * @param githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineList
     * @param githubComTektoncdPipelinePkgApisPipelineV1beta1SkippedTask
     * @param githubComTektoncdPipelinePkgApisPipelineV1beta1TaskRunDebug
     * @param githubComTektoncdPipelinePkgApisPipelineV1beta1TaskRunSpec
     * @param githubComTektoncdPipelinePkgApisPipelineV1beta1TaskResources
     * @param githubComTektoncdPipelinePkgApisPipelineV1beta1ClusterTask
     * @param githubComTektoncdPipelinePkgApisPipelineV1beta1Pipeline
     * @param githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRef
     * @param githubComTektoncdPipelinePkgApisResourceV1alpha1SecretParam
     * @param githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineResourceResult
     * @param githubComTektoncdPipelinePkgApisPipelineV1beta1TaskRunList
     * @param githubComTektoncdPipelinePkgApisPipelineV1beta1TaskRef
     * @param githubComTektoncdPipelinePkgApisRunV1alpha1RunResult
     * @param githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineResourceBinding
     * @param githubComTektoncdPipelinePkgApisPipelineV1beta1TaskRunStatus
     * @param githubComTektoncdPipelinePkgApisPipelineV1beta1CloudEventDeliveryState
     * @param githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineTaskOutputResource
     * @param githubComTektoncdPipelinePkgApisPipelineV1beta1WhenExpression
     * @param githubComTektoncdPipelinePkgApisPipelineV1beta1TaskResult
     * @param githubComTektoncdPipelinePkgApisPipelineV1beta1WorkspaceDeclaration
     * @param githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineTaskInputResource
     * @param githubComTektoncdPipelinePkgApisPipelineV1beta1Sidecar
     * @param githubComTektoncdPipelinePkgApisPipelineV1beta1WorkspaceUsage
     * @param githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunConditionCheckStatus
     * @param githubComTektoncdPipelinePkgApisPipelineV1beta1TaskRunResources
     * @param githubComTektoncdPipelinePkgApisPipelineV1beta1TaskRun
     * @param githubComTektoncdPipelinePkgApisResourceV1alpha1PipelineResourceSpec
     * @param githubComTektoncdPipelinePkgApisPipelineV1beta1TaskList
     * @param githubComTektoncdPipelinePkgApisPipelineV1beta1CloudEventDelivery
     * @param githubComTektoncdPipelinePkgApisPipelinePodTemplate
     * @param githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunSpec
     * @param githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineTaskRunSpec
     * @param githubComTektoncdPipelinePkgApisPipelineV1beta1StepState
     * @param githubComTektoncdPipelinePkgApisPipelineV1beta1ChildStatusReference
     * @param githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineWorkspaceDeclaration
     * @param githubComTektoncdPipelinePkgApisResourceV1alpha1ResourceParam
     * @param githubComTektoncdPipelinePkgApisPipelineV1beta1EmbeddedTask
     * @param githubComTektoncdPipelinePkgApisPipelineV1beta1Param
     * @param githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineTaskResources
     * @param githubComTektoncdPipelinePkgApisRunV1alpha1RunStatus
     */
    public TektonSchemaV1beta1(Template githubComTektoncdPipelinePkgApisPipelinePodTemplate, ChildStatusReference githubComTektoncdPipelinePkgApisPipelineV1beta1ChildStatusReference, CloudEventDelivery githubComTektoncdPipelinePkgApisPipelineV1beta1CloudEventDelivery, CloudEventDeliveryState githubComTektoncdPipelinePkgApisPipelineV1beta1CloudEventDeliveryState, ClusterTask githubComTektoncdPipelinePkgApisPipelineV1beta1ClusterTask, ClusterTaskList githubComTektoncdPipelinePkgApisPipelineV1beta1ClusterTaskList, ConditionCheckStatus githubComTektoncdPipelinePkgApisPipelineV1beta1ConditionCheckStatus, EmbeddedTask githubComTektoncdPipelinePkgApisPipelineV1beta1EmbeddedTask, Param githubComTektoncdPipelinePkgApisPipelineV1beta1Param, ParamSpec githubComTektoncdPipelinePkgApisPipelineV1beta1ParamSpec, Pipeline githubComTektoncdPipelinePkgApisPipelineV1beta1Pipeline, PipelineDeclaredResource githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineDeclaredResource, PipelineList githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineList, PipelineRef githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRef, PipelineResourceBinding githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineResourceBinding, PipelineResourceRef githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineResourceRef, PipelineResourceResult githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineResourceResult, PipelineResult githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineResult, PipelineRun githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRun, PipelineRunChildConditionCheckStatus githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunChildConditionCheckStatus, PipelineRunConditionCheckStatus githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunConditionCheckStatus, PipelineRunList githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunList, PipelineRunResult githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunResult, PipelineRunRunStatus githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunRunStatus, PipelineRunSpec githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunSpec, PipelineRunSpecServiceAccountName githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunSpecServiceAccountName, PipelineRunStatus githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunStatus, PipelineRunTaskRunStatus githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunTaskRunStatus, PipelineSpec githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineSpec, PipelineTask githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineTask, PipelineTaskCondition githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineTaskCondition, PipelineTaskInputResource githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineTaskInputResource, PipelineTaskMetadata githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineTaskMetadata, PipelineTaskOutputResource githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineTaskOutputResource, PipelineTaskResources githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineTaskResources, PipelineTaskRunSpec githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineTaskRunSpec, PipelineWorkspaceDeclaration githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineWorkspaceDeclaration, ResolverParam githubComTektoncdPipelinePkgApisPipelineV1beta1ResolverParam, Sidecar githubComTektoncdPipelinePkgApisPipelineV1beta1Sidecar, SidecarState githubComTektoncdPipelinePkgApisPipelineV1beta1SidecarState, SkippedTask githubComTektoncdPipelinePkgApisPipelineV1beta1SkippedTask, Step githubComTektoncdPipelinePkgApisPipelineV1beta1Step, StepState githubComTektoncdPipelinePkgApisPipelineV1beta1StepState, Task githubComTektoncdPipelinePkgApisPipelineV1beta1Task, TaskList githubComTektoncdPipelinePkgApisPipelineV1beta1TaskList, TaskRef githubComTektoncdPipelinePkgApisPipelineV1beta1TaskRef, TaskResource githubComTektoncdPipelinePkgApisPipelineV1beta1TaskResource, TaskResourceBinding githubComTektoncdPipelinePkgApisPipelineV1beta1TaskResourceBinding, TaskResources githubComTektoncdPipelinePkgApisPipelineV1beta1TaskResources, TaskResult githubComTektoncdPipelinePkgApisPipelineV1beta1TaskResult, TaskRun githubComTektoncdPipelinePkgApisPipelineV1beta1TaskRun, TaskRunDebug githubComTektoncdPipelinePkgApisPipelineV1beta1TaskRunDebug, TaskRunList githubComTektoncdPipelinePkgApisPipelineV1beta1TaskRunList, TaskRunResources githubComTektoncdPipelinePkgApisPipelineV1beta1TaskRunResources, TaskRunResult githubComTektoncdPipelinePkgApisPipelineV1beta1TaskRunResult, TaskRunSidecarOverride githubComTektoncdPipelinePkgApisPipelineV1beta1TaskRunSidecarOverride, TaskRunSpec githubComTektoncdPipelinePkgApisPipelineV1beta1TaskRunSpec, TaskRunStatus githubComTektoncdPipelinePkgApisPipelineV1beta1TaskRunStatus, TaskRunStepOverride githubComTektoncdPipelinePkgApisPipelineV1beta1TaskRunStepOverride, TaskSpec githubComTektoncdPipelinePkgApisPipelineV1beta1TaskSpec, TimeoutFields githubComTektoncdPipelinePkgApisPipelineV1beta1TimeoutFields, WhenExpression githubComTektoncdPipelinePkgApisPipelineV1beta1WhenExpression, WorkspaceBinding githubComTektoncdPipelinePkgApisPipelineV1beta1WorkspaceBinding, WorkspaceDeclaration githubComTektoncdPipelinePkgApisPipelineV1beta1WorkspaceDeclaration, WorkspacePipelineTaskBinding githubComTektoncdPipelinePkgApisPipelineV1beta1WorkspacePipelineTaskBinding, WorkspaceUsage githubComTektoncdPipelinePkgApisPipelineV1beta1WorkspaceUsage, PipelineResourceSpec githubComTektoncdPipelinePkgApisResourceV1alpha1PipelineResourceSpec, ResourceParam githubComTektoncdPipelinePkgApisResourceV1alpha1ResourceParam, SecretParam githubComTektoncdPipelinePkgApisResourceV1alpha1SecretParam, RunResult githubComTektoncdPipelinePkgApisRunV1alpha1RunResult, RunStatus githubComTektoncdPipelinePkgApisRunV1alpha1RunStatus) {
        super();
        this.githubComTektoncdPipelinePkgApisPipelinePodTemplate = githubComTektoncdPipelinePkgApisPipelinePodTemplate;
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1ChildStatusReference = githubComTektoncdPipelinePkgApisPipelineV1beta1ChildStatusReference;
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1CloudEventDelivery = githubComTektoncdPipelinePkgApisPipelineV1beta1CloudEventDelivery;
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1CloudEventDeliveryState = githubComTektoncdPipelinePkgApisPipelineV1beta1CloudEventDeliveryState;
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1ClusterTask = githubComTektoncdPipelinePkgApisPipelineV1beta1ClusterTask;
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1ClusterTaskList = githubComTektoncdPipelinePkgApisPipelineV1beta1ClusterTaskList;
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1ConditionCheckStatus = githubComTektoncdPipelinePkgApisPipelineV1beta1ConditionCheckStatus;
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1EmbeddedTask = githubComTektoncdPipelinePkgApisPipelineV1beta1EmbeddedTask;
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1Param = githubComTektoncdPipelinePkgApisPipelineV1beta1Param;
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1ParamSpec = githubComTektoncdPipelinePkgApisPipelineV1beta1ParamSpec;
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1Pipeline = githubComTektoncdPipelinePkgApisPipelineV1beta1Pipeline;
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineDeclaredResource = githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineDeclaredResource;
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineList = githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineList;
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRef = githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRef;
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineResourceBinding = githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineResourceBinding;
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineResourceRef = githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineResourceRef;
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineResourceResult = githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineResourceResult;
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineResult = githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineResult;
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRun = githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRun;
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunChildConditionCheckStatus = githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunChildConditionCheckStatus;
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunConditionCheckStatus = githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunConditionCheckStatus;
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunList = githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunList;
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunResult = githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunResult;
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunRunStatus = githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunRunStatus;
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunSpec = githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunSpec;
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunSpecServiceAccountName = githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunSpecServiceAccountName;
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunStatus = githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunStatus;
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunTaskRunStatus = githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunTaskRunStatus;
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineSpec = githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineSpec;
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineTask = githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineTask;
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineTaskCondition = githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineTaskCondition;
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineTaskInputResource = githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineTaskInputResource;
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineTaskMetadata = githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineTaskMetadata;
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineTaskOutputResource = githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineTaskOutputResource;
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineTaskResources = githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineTaskResources;
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineTaskRunSpec = githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineTaskRunSpec;
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineWorkspaceDeclaration = githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineWorkspaceDeclaration;
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1ResolverParam = githubComTektoncdPipelinePkgApisPipelineV1beta1ResolverParam;
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1Sidecar = githubComTektoncdPipelinePkgApisPipelineV1beta1Sidecar;
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1SidecarState = githubComTektoncdPipelinePkgApisPipelineV1beta1SidecarState;
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1SkippedTask = githubComTektoncdPipelinePkgApisPipelineV1beta1SkippedTask;
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1Step = githubComTektoncdPipelinePkgApisPipelineV1beta1Step;
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1StepState = githubComTektoncdPipelinePkgApisPipelineV1beta1StepState;
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1Task = githubComTektoncdPipelinePkgApisPipelineV1beta1Task;
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1TaskList = githubComTektoncdPipelinePkgApisPipelineV1beta1TaskList;
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1TaskRef = githubComTektoncdPipelinePkgApisPipelineV1beta1TaskRef;
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1TaskResource = githubComTektoncdPipelinePkgApisPipelineV1beta1TaskResource;
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1TaskResourceBinding = githubComTektoncdPipelinePkgApisPipelineV1beta1TaskResourceBinding;
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1TaskResources = githubComTektoncdPipelinePkgApisPipelineV1beta1TaskResources;
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1TaskResult = githubComTektoncdPipelinePkgApisPipelineV1beta1TaskResult;
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1TaskRun = githubComTektoncdPipelinePkgApisPipelineV1beta1TaskRun;
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1TaskRunDebug = githubComTektoncdPipelinePkgApisPipelineV1beta1TaskRunDebug;
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1TaskRunList = githubComTektoncdPipelinePkgApisPipelineV1beta1TaskRunList;
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1TaskRunResources = githubComTektoncdPipelinePkgApisPipelineV1beta1TaskRunResources;
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1TaskRunResult = githubComTektoncdPipelinePkgApisPipelineV1beta1TaskRunResult;
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1TaskRunSidecarOverride = githubComTektoncdPipelinePkgApisPipelineV1beta1TaskRunSidecarOverride;
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1TaskRunSpec = githubComTektoncdPipelinePkgApisPipelineV1beta1TaskRunSpec;
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1TaskRunStatus = githubComTektoncdPipelinePkgApisPipelineV1beta1TaskRunStatus;
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1TaskRunStepOverride = githubComTektoncdPipelinePkgApisPipelineV1beta1TaskRunStepOverride;
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1TaskSpec = githubComTektoncdPipelinePkgApisPipelineV1beta1TaskSpec;
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1TimeoutFields = githubComTektoncdPipelinePkgApisPipelineV1beta1TimeoutFields;
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1WhenExpression = githubComTektoncdPipelinePkgApisPipelineV1beta1WhenExpression;
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1WorkspaceBinding = githubComTektoncdPipelinePkgApisPipelineV1beta1WorkspaceBinding;
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1WorkspaceDeclaration = githubComTektoncdPipelinePkgApisPipelineV1beta1WorkspaceDeclaration;
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1WorkspacePipelineTaskBinding = githubComTektoncdPipelinePkgApisPipelineV1beta1WorkspacePipelineTaskBinding;
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1WorkspaceUsage = githubComTektoncdPipelinePkgApisPipelineV1beta1WorkspaceUsage;
        this.githubComTektoncdPipelinePkgApisResourceV1alpha1PipelineResourceSpec = githubComTektoncdPipelinePkgApisResourceV1alpha1PipelineResourceSpec;
        this.githubComTektoncdPipelinePkgApisResourceV1alpha1ResourceParam = githubComTektoncdPipelinePkgApisResourceV1alpha1ResourceParam;
        this.githubComTektoncdPipelinePkgApisResourceV1alpha1SecretParam = githubComTektoncdPipelinePkgApisResourceV1alpha1SecretParam;
        this.githubComTektoncdPipelinePkgApisRunV1alpha1RunResult = githubComTektoncdPipelinePkgApisRunV1alpha1RunResult;
        this.githubComTektoncdPipelinePkgApisRunV1alpha1RunStatus = githubComTektoncdPipelinePkgApisRunV1alpha1RunStatus;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_pod_Template")
    public Template getGithubComTektoncdPipelinePkgApisPipelinePodTemplate() {
        return githubComTektoncdPipelinePkgApisPipelinePodTemplate;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_pod_Template")
    public void setGithubComTektoncdPipelinePkgApisPipelinePodTemplate(Template githubComTektoncdPipelinePkgApisPipelinePodTemplate) {
        this.githubComTektoncdPipelinePkgApisPipelinePodTemplate = githubComTektoncdPipelinePkgApisPipelinePodTemplate;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_ChildStatusReference")
    public ChildStatusReference getGithubComTektoncdPipelinePkgApisPipelineV1beta1ChildStatusReference() {
        return githubComTektoncdPipelinePkgApisPipelineV1beta1ChildStatusReference;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_ChildStatusReference")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1beta1ChildStatusReference(ChildStatusReference githubComTektoncdPipelinePkgApisPipelineV1beta1ChildStatusReference) {
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1ChildStatusReference = githubComTektoncdPipelinePkgApisPipelineV1beta1ChildStatusReference;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_CloudEventDelivery")
    public CloudEventDelivery getGithubComTektoncdPipelinePkgApisPipelineV1beta1CloudEventDelivery() {
        return githubComTektoncdPipelinePkgApisPipelineV1beta1CloudEventDelivery;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_CloudEventDelivery")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1beta1CloudEventDelivery(CloudEventDelivery githubComTektoncdPipelinePkgApisPipelineV1beta1CloudEventDelivery) {
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1CloudEventDelivery = githubComTektoncdPipelinePkgApisPipelineV1beta1CloudEventDelivery;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_CloudEventDeliveryState")
    public CloudEventDeliveryState getGithubComTektoncdPipelinePkgApisPipelineV1beta1CloudEventDeliveryState() {
        return githubComTektoncdPipelinePkgApisPipelineV1beta1CloudEventDeliveryState;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_CloudEventDeliveryState")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1beta1CloudEventDeliveryState(CloudEventDeliveryState githubComTektoncdPipelinePkgApisPipelineV1beta1CloudEventDeliveryState) {
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1CloudEventDeliveryState = githubComTektoncdPipelinePkgApisPipelineV1beta1CloudEventDeliveryState;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_ClusterTask")
    public ClusterTask getGithubComTektoncdPipelinePkgApisPipelineV1beta1ClusterTask() {
        return githubComTektoncdPipelinePkgApisPipelineV1beta1ClusterTask;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_ClusterTask")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1beta1ClusterTask(ClusterTask githubComTektoncdPipelinePkgApisPipelineV1beta1ClusterTask) {
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1ClusterTask = githubComTektoncdPipelinePkgApisPipelineV1beta1ClusterTask;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_ClusterTaskList")
    public ClusterTaskList getGithubComTektoncdPipelinePkgApisPipelineV1beta1ClusterTaskList() {
        return githubComTektoncdPipelinePkgApisPipelineV1beta1ClusterTaskList;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_ClusterTaskList")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1beta1ClusterTaskList(ClusterTaskList githubComTektoncdPipelinePkgApisPipelineV1beta1ClusterTaskList) {
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1ClusterTaskList = githubComTektoncdPipelinePkgApisPipelineV1beta1ClusterTaskList;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_ConditionCheckStatus")
    public ConditionCheckStatus getGithubComTektoncdPipelinePkgApisPipelineV1beta1ConditionCheckStatus() {
        return githubComTektoncdPipelinePkgApisPipelineV1beta1ConditionCheckStatus;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_ConditionCheckStatus")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1beta1ConditionCheckStatus(ConditionCheckStatus githubComTektoncdPipelinePkgApisPipelineV1beta1ConditionCheckStatus) {
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1ConditionCheckStatus = githubComTektoncdPipelinePkgApisPipelineV1beta1ConditionCheckStatus;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_EmbeddedTask")
    public EmbeddedTask getGithubComTektoncdPipelinePkgApisPipelineV1beta1EmbeddedTask() {
        return githubComTektoncdPipelinePkgApisPipelineV1beta1EmbeddedTask;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_EmbeddedTask")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1beta1EmbeddedTask(EmbeddedTask githubComTektoncdPipelinePkgApisPipelineV1beta1EmbeddedTask) {
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1EmbeddedTask = githubComTektoncdPipelinePkgApisPipelineV1beta1EmbeddedTask;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_Param")
    public Param getGithubComTektoncdPipelinePkgApisPipelineV1beta1Param() {
        return githubComTektoncdPipelinePkgApisPipelineV1beta1Param;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_Param")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1beta1Param(Param githubComTektoncdPipelinePkgApisPipelineV1beta1Param) {
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1Param = githubComTektoncdPipelinePkgApisPipelineV1beta1Param;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_ParamSpec")
    public ParamSpec getGithubComTektoncdPipelinePkgApisPipelineV1beta1ParamSpec() {
        return githubComTektoncdPipelinePkgApisPipelineV1beta1ParamSpec;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_ParamSpec")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1beta1ParamSpec(ParamSpec githubComTektoncdPipelinePkgApisPipelineV1beta1ParamSpec) {
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1ParamSpec = githubComTektoncdPipelinePkgApisPipelineV1beta1ParamSpec;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_Pipeline")
    public Pipeline getGithubComTektoncdPipelinePkgApisPipelineV1beta1Pipeline() {
        return githubComTektoncdPipelinePkgApisPipelineV1beta1Pipeline;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_Pipeline")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1beta1Pipeline(Pipeline githubComTektoncdPipelinePkgApisPipelineV1beta1Pipeline) {
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1Pipeline = githubComTektoncdPipelinePkgApisPipelineV1beta1Pipeline;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineDeclaredResource")
    public PipelineDeclaredResource getGithubComTektoncdPipelinePkgApisPipelineV1beta1PipelineDeclaredResource() {
        return githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineDeclaredResource;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineDeclaredResource")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1beta1PipelineDeclaredResource(PipelineDeclaredResource githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineDeclaredResource) {
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineDeclaredResource = githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineDeclaredResource;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineList")
    public PipelineList getGithubComTektoncdPipelinePkgApisPipelineV1beta1PipelineList() {
        return githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineList;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineList")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1beta1PipelineList(PipelineList githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineList) {
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineList = githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineList;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineRef")
    public PipelineRef getGithubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRef() {
        return githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRef;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineRef")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRef(PipelineRef githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRef) {
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRef = githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRef;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineResourceBinding")
    public PipelineResourceBinding getGithubComTektoncdPipelinePkgApisPipelineV1beta1PipelineResourceBinding() {
        return githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineResourceBinding;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineResourceBinding")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1beta1PipelineResourceBinding(PipelineResourceBinding githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineResourceBinding) {
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineResourceBinding = githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineResourceBinding;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineResourceRef")
    public PipelineResourceRef getGithubComTektoncdPipelinePkgApisPipelineV1beta1PipelineResourceRef() {
        return githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineResourceRef;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineResourceRef")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1beta1PipelineResourceRef(PipelineResourceRef githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineResourceRef) {
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineResourceRef = githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineResourceRef;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineResourceResult")
    public PipelineResourceResult getGithubComTektoncdPipelinePkgApisPipelineV1beta1PipelineResourceResult() {
        return githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineResourceResult;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineResourceResult")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1beta1PipelineResourceResult(PipelineResourceResult githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineResourceResult) {
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineResourceResult = githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineResourceResult;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineResult")
    public PipelineResult getGithubComTektoncdPipelinePkgApisPipelineV1beta1PipelineResult() {
        return githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineResult;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineResult")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1beta1PipelineResult(PipelineResult githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineResult) {
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineResult = githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineResult;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineRun")
    public PipelineRun getGithubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRun() {
        return githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRun;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineRun")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRun(PipelineRun githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRun) {
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRun = githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRun;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineRunChildConditionCheckStatus")
    public PipelineRunChildConditionCheckStatus getGithubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunChildConditionCheckStatus() {
        return githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunChildConditionCheckStatus;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineRunChildConditionCheckStatus")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunChildConditionCheckStatus(PipelineRunChildConditionCheckStatus githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunChildConditionCheckStatus) {
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunChildConditionCheckStatus = githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunChildConditionCheckStatus;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineRunConditionCheckStatus")
    public PipelineRunConditionCheckStatus getGithubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunConditionCheckStatus() {
        return githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunConditionCheckStatus;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineRunConditionCheckStatus")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunConditionCheckStatus(PipelineRunConditionCheckStatus githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunConditionCheckStatus) {
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunConditionCheckStatus = githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunConditionCheckStatus;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineRunList")
    public PipelineRunList getGithubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunList() {
        return githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunList;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineRunList")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunList(PipelineRunList githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunList) {
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunList = githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunList;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineRunResult")
    public PipelineRunResult getGithubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunResult() {
        return githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunResult;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineRunResult")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunResult(PipelineRunResult githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunResult) {
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunResult = githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunResult;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineRunRunStatus")
    public PipelineRunRunStatus getGithubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunRunStatus() {
        return githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunRunStatus;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineRunRunStatus")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunRunStatus(PipelineRunRunStatus githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunRunStatus) {
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunRunStatus = githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunRunStatus;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineRunSpec")
    public PipelineRunSpec getGithubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunSpec() {
        return githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunSpec;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineRunSpec")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunSpec(PipelineRunSpec githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunSpec) {
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunSpec = githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunSpec;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineRunSpecServiceAccountName")
    public PipelineRunSpecServiceAccountName getGithubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunSpecServiceAccountName() {
        return githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunSpecServiceAccountName;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineRunSpecServiceAccountName")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunSpecServiceAccountName(PipelineRunSpecServiceAccountName githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunSpecServiceAccountName) {
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunSpecServiceAccountName = githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunSpecServiceAccountName;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineRunStatus")
    public PipelineRunStatus getGithubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunStatus() {
        return githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunStatus;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineRunStatus")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunStatus(PipelineRunStatus githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunStatus) {
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunStatus = githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunStatus;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineRunTaskRunStatus")
    public PipelineRunTaskRunStatus getGithubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunTaskRunStatus() {
        return githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunTaskRunStatus;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineRunTaskRunStatus")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunTaskRunStatus(PipelineRunTaskRunStatus githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunTaskRunStatus) {
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunTaskRunStatus = githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineRunTaskRunStatus;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineSpec")
    public PipelineSpec getGithubComTektoncdPipelinePkgApisPipelineV1beta1PipelineSpec() {
        return githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineSpec;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineSpec")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1beta1PipelineSpec(PipelineSpec githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineSpec) {
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineSpec = githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineSpec;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineTask")
    public PipelineTask getGithubComTektoncdPipelinePkgApisPipelineV1beta1PipelineTask() {
        return githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineTask;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineTask")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1beta1PipelineTask(PipelineTask githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineTask) {
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineTask = githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineTask;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineTaskCondition")
    public PipelineTaskCondition getGithubComTektoncdPipelinePkgApisPipelineV1beta1PipelineTaskCondition() {
        return githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineTaskCondition;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineTaskCondition")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1beta1PipelineTaskCondition(PipelineTaskCondition githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineTaskCondition) {
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineTaskCondition = githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineTaskCondition;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineTaskInputResource")
    public PipelineTaskInputResource getGithubComTektoncdPipelinePkgApisPipelineV1beta1PipelineTaskInputResource() {
        return githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineTaskInputResource;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineTaskInputResource")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1beta1PipelineTaskInputResource(PipelineTaskInputResource githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineTaskInputResource) {
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineTaskInputResource = githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineTaskInputResource;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineTaskMetadata")
    public PipelineTaskMetadata getGithubComTektoncdPipelinePkgApisPipelineV1beta1PipelineTaskMetadata() {
        return githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineTaskMetadata;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineTaskMetadata")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1beta1PipelineTaskMetadata(PipelineTaskMetadata githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineTaskMetadata) {
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineTaskMetadata = githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineTaskMetadata;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineTaskOutputResource")
    public PipelineTaskOutputResource getGithubComTektoncdPipelinePkgApisPipelineV1beta1PipelineTaskOutputResource() {
        return githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineTaskOutputResource;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineTaskOutputResource")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1beta1PipelineTaskOutputResource(PipelineTaskOutputResource githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineTaskOutputResource) {
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineTaskOutputResource = githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineTaskOutputResource;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineTaskResources")
    public PipelineTaskResources getGithubComTektoncdPipelinePkgApisPipelineV1beta1PipelineTaskResources() {
        return githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineTaskResources;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineTaskResources")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1beta1PipelineTaskResources(PipelineTaskResources githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineTaskResources) {
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineTaskResources = githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineTaskResources;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineTaskRunSpec")
    public PipelineTaskRunSpec getGithubComTektoncdPipelinePkgApisPipelineV1beta1PipelineTaskRunSpec() {
        return githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineTaskRunSpec;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineTaskRunSpec")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1beta1PipelineTaskRunSpec(PipelineTaskRunSpec githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineTaskRunSpec) {
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineTaskRunSpec = githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineTaskRunSpec;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineWorkspaceDeclaration")
    public PipelineWorkspaceDeclaration getGithubComTektoncdPipelinePkgApisPipelineV1beta1PipelineWorkspaceDeclaration() {
        return githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineWorkspaceDeclaration;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_PipelineWorkspaceDeclaration")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1beta1PipelineWorkspaceDeclaration(PipelineWorkspaceDeclaration githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineWorkspaceDeclaration) {
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineWorkspaceDeclaration = githubComTektoncdPipelinePkgApisPipelineV1beta1PipelineWorkspaceDeclaration;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_ResolverParam")
    public ResolverParam getGithubComTektoncdPipelinePkgApisPipelineV1beta1ResolverParam() {
        return githubComTektoncdPipelinePkgApisPipelineV1beta1ResolverParam;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_ResolverParam")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1beta1ResolverParam(ResolverParam githubComTektoncdPipelinePkgApisPipelineV1beta1ResolverParam) {
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1ResolverParam = githubComTektoncdPipelinePkgApisPipelineV1beta1ResolverParam;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_Sidecar")
    public Sidecar getGithubComTektoncdPipelinePkgApisPipelineV1beta1Sidecar() {
        return githubComTektoncdPipelinePkgApisPipelineV1beta1Sidecar;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_Sidecar")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1beta1Sidecar(Sidecar githubComTektoncdPipelinePkgApisPipelineV1beta1Sidecar) {
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1Sidecar = githubComTektoncdPipelinePkgApisPipelineV1beta1Sidecar;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_SidecarState")
    public SidecarState getGithubComTektoncdPipelinePkgApisPipelineV1beta1SidecarState() {
        return githubComTektoncdPipelinePkgApisPipelineV1beta1SidecarState;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_SidecarState")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1beta1SidecarState(SidecarState githubComTektoncdPipelinePkgApisPipelineV1beta1SidecarState) {
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1SidecarState = githubComTektoncdPipelinePkgApisPipelineV1beta1SidecarState;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_SkippedTask")
    public SkippedTask getGithubComTektoncdPipelinePkgApisPipelineV1beta1SkippedTask() {
        return githubComTektoncdPipelinePkgApisPipelineV1beta1SkippedTask;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_SkippedTask")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1beta1SkippedTask(SkippedTask githubComTektoncdPipelinePkgApisPipelineV1beta1SkippedTask) {
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1SkippedTask = githubComTektoncdPipelinePkgApisPipelineV1beta1SkippedTask;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_Step")
    public Step getGithubComTektoncdPipelinePkgApisPipelineV1beta1Step() {
        return githubComTektoncdPipelinePkgApisPipelineV1beta1Step;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_Step")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1beta1Step(Step githubComTektoncdPipelinePkgApisPipelineV1beta1Step) {
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1Step = githubComTektoncdPipelinePkgApisPipelineV1beta1Step;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_StepState")
    public StepState getGithubComTektoncdPipelinePkgApisPipelineV1beta1StepState() {
        return githubComTektoncdPipelinePkgApisPipelineV1beta1StepState;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_StepState")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1beta1StepState(StepState githubComTektoncdPipelinePkgApisPipelineV1beta1StepState) {
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1StepState = githubComTektoncdPipelinePkgApisPipelineV1beta1StepState;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_Task")
    public Task getGithubComTektoncdPipelinePkgApisPipelineV1beta1Task() {
        return githubComTektoncdPipelinePkgApisPipelineV1beta1Task;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_Task")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1beta1Task(Task githubComTektoncdPipelinePkgApisPipelineV1beta1Task) {
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1Task = githubComTektoncdPipelinePkgApisPipelineV1beta1Task;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_TaskList")
    public TaskList getGithubComTektoncdPipelinePkgApisPipelineV1beta1TaskList() {
        return githubComTektoncdPipelinePkgApisPipelineV1beta1TaskList;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_TaskList")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1beta1TaskList(TaskList githubComTektoncdPipelinePkgApisPipelineV1beta1TaskList) {
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1TaskList = githubComTektoncdPipelinePkgApisPipelineV1beta1TaskList;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_TaskRef")
    public TaskRef getGithubComTektoncdPipelinePkgApisPipelineV1beta1TaskRef() {
        return githubComTektoncdPipelinePkgApisPipelineV1beta1TaskRef;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_TaskRef")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1beta1TaskRef(TaskRef githubComTektoncdPipelinePkgApisPipelineV1beta1TaskRef) {
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1TaskRef = githubComTektoncdPipelinePkgApisPipelineV1beta1TaskRef;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_TaskResource")
    public TaskResource getGithubComTektoncdPipelinePkgApisPipelineV1beta1TaskResource() {
        return githubComTektoncdPipelinePkgApisPipelineV1beta1TaskResource;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_TaskResource")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1beta1TaskResource(TaskResource githubComTektoncdPipelinePkgApisPipelineV1beta1TaskResource) {
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1TaskResource = githubComTektoncdPipelinePkgApisPipelineV1beta1TaskResource;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_TaskResourceBinding")
    public TaskResourceBinding getGithubComTektoncdPipelinePkgApisPipelineV1beta1TaskResourceBinding() {
        return githubComTektoncdPipelinePkgApisPipelineV1beta1TaskResourceBinding;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_TaskResourceBinding")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1beta1TaskResourceBinding(TaskResourceBinding githubComTektoncdPipelinePkgApisPipelineV1beta1TaskResourceBinding) {
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1TaskResourceBinding = githubComTektoncdPipelinePkgApisPipelineV1beta1TaskResourceBinding;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_TaskResources")
    public TaskResources getGithubComTektoncdPipelinePkgApisPipelineV1beta1TaskResources() {
        return githubComTektoncdPipelinePkgApisPipelineV1beta1TaskResources;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_TaskResources")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1beta1TaskResources(TaskResources githubComTektoncdPipelinePkgApisPipelineV1beta1TaskResources) {
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1TaskResources = githubComTektoncdPipelinePkgApisPipelineV1beta1TaskResources;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_TaskResult")
    public TaskResult getGithubComTektoncdPipelinePkgApisPipelineV1beta1TaskResult() {
        return githubComTektoncdPipelinePkgApisPipelineV1beta1TaskResult;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_TaskResult")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1beta1TaskResult(TaskResult githubComTektoncdPipelinePkgApisPipelineV1beta1TaskResult) {
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1TaskResult = githubComTektoncdPipelinePkgApisPipelineV1beta1TaskResult;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_TaskRun")
    public TaskRun getGithubComTektoncdPipelinePkgApisPipelineV1beta1TaskRun() {
        return githubComTektoncdPipelinePkgApisPipelineV1beta1TaskRun;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_TaskRun")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1beta1TaskRun(TaskRun githubComTektoncdPipelinePkgApisPipelineV1beta1TaskRun) {
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1TaskRun = githubComTektoncdPipelinePkgApisPipelineV1beta1TaskRun;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_TaskRunDebug")
    public TaskRunDebug getGithubComTektoncdPipelinePkgApisPipelineV1beta1TaskRunDebug() {
        return githubComTektoncdPipelinePkgApisPipelineV1beta1TaskRunDebug;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_TaskRunDebug")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1beta1TaskRunDebug(TaskRunDebug githubComTektoncdPipelinePkgApisPipelineV1beta1TaskRunDebug) {
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1TaskRunDebug = githubComTektoncdPipelinePkgApisPipelineV1beta1TaskRunDebug;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_TaskRunList")
    public TaskRunList getGithubComTektoncdPipelinePkgApisPipelineV1beta1TaskRunList() {
        return githubComTektoncdPipelinePkgApisPipelineV1beta1TaskRunList;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_TaskRunList")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1beta1TaskRunList(TaskRunList githubComTektoncdPipelinePkgApisPipelineV1beta1TaskRunList) {
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1TaskRunList = githubComTektoncdPipelinePkgApisPipelineV1beta1TaskRunList;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_TaskRunResources")
    public TaskRunResources getGithubComTektoncdPipelinePkgApisPipelineV1beta1TaskRunResources() {
        return githubComTektoncdPipelinePkgApisPipelineV1beta1TaskRunResources;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_TaskRunResources")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1beta1TaskRunResources(TaskRunResources githubComTektoncdPipelinePkgApisPipelineV1beta1TaskRunResources) {
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1TaskRunResources = githubComTektoncdPipelinePkgApisPipelineV1beta1TaskRunResources;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_TaskRunResult")
    public TaskRunResult getGithubComTektoncdPipelinePkgApisPipelineV1beta1TaskRunResult() {
        return githubComTektoncdPipelinePkgApisPipelineV1beta1TaskRunResult;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_TaskRunResult")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1beta1TaskRunResult(TaskRunResult githubComTektoncdPipelinePkgApisPipelineV1beta1TaskRunResult) {
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1TaskRunResult = githubComTektoncdPipelinePkgApisPipelineV1beta1TaskRunResult;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_TaskRunSidecarOverride")
    public TaskRunSidecarOverride getGithubComTektoncdPipelinePkgApisPipelineV1beta1TaskRunSidecarOverride() {
        return githubComTektoncdPipelinePkgApisPipelineV1beta1TaskRunSidecarOverride;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_TaskRunSidecarOverride")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1beta1TaskRunSidecarOverride(TaskRunSidecarOverride githubComTektoncdPipelinePkgApisPipelineV1beta1TaskRunSidecarOverride) {
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1TaskRunSidecarOverride = githubComTektoncdPipelinePkgApisPipelineV1beta1TaskRunSidecarOverride;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_TaskRunSpec")
    public TaskRunSpec getGithubComTektoncdPipelinePkgApisPipelineV1beta1TaskRunSpec() {
        return githubComTektoncdPipelinePkgApisPipelineV1beta1TaskRunSpec;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_TaskRunSpec")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1beta1TaskRunSpec(TaskRunSpec githubComTektoncdPipelinePkgApisPipelineV1beta1TaskRunSpec) {
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1TaskRunSpec = githubComTektoncdPipelinePkgApisPipelineV1beta1TaskRunSpec;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_TaskRunStatus")
    public TaskRunStatus getGithubComTektoncdPipelinePkgApisPipelineV1beta1TaskRunStatus() {
        return githubComTektoncdPipelinePkgApisPipelineV1beta1TaskRunStatus;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_TaskRunStatus")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1beta1TaskRunStatus(TaskRunStatus githubComTektoncdPipelinePkgApisPipelineV1beta1TaskRunStatus) {
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1TaskRunStatus = githubComTektoncdPipelinePkgApisPipelineV1beta1TaskRunStatus;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_TaskRunStepOverride")
    public TaskRunStepOverride getGithubComTektoncdPipelinePkgApisPipelineV1beta1TaskRunStepOverride() {
        return githubComTektoncdPipelinePkgApisPipelineV1beta1TaskRunStepOverride;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_TaskRunStepOverride")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1beta1TaskRunStepOverride(TaskRunStepOverride githubComTektoncdPipelinePkgApisPipelineV1beta1TaskRunStepOverride) {
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1TaskRunStepOverride = githubComTektoncdPipelinePkgApisPipelineV1beta1TaskRunStepOverride;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_TaskSpec")
    public TaskSpec getGithubComTektoncdPipelinePkgApisPipelineV1beta1TaskSpec() {
        return githubComTektoncdPipelinePkgApisPipelineV1beta1TaskSpec;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_TaskSpec")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1beta1TaskSpec(TaskSpec githubComTektoncdPipelinePkgApisPipelineV1beta1TaskSpec) {
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1TaskSpec = githubComTektoncdPipelinePkgApisPipelineV1beta1TaskSpec;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_TimeoutFields")
    public TimeoutFields getGithubComTektoncdPipelinePkgApisPipelineV1beta1TimeoutFields() {
        return githubComTektoncdPipelinePkgApisPipelineV1beta1TimeoutFields;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_TimeoutFields")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1beta1TimeoutFields(TimeoutFields githubComTektoncdPipelinePkgApisPipelineV1beta1TimeoutFields) {
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1TimeoutFields = githubComTektoncdPipelinePkgApisPipelineV1beta1TimeoutFields;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_WhenExpression")
    public WhenExpression getGithubComTektoncdPipelinePkgApisPipelineV1beta1WhenExpression() {
        return githubComTektoncdPipelinePkgApisPipelineV1beta1WhenExpression;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_WhenExpression")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1beta1WhenExpression(WhenExpression githubComTektoncdPipelinePkgApisPipelineV1beta1WhenExpression) {
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1WhenExpression = githubComTektoncdPipelinePkgApisPipelineV1beta1WhenExpression;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_WorkspaceBinding")
    public WorkspaceBinding getGithubComTektoncdPipelinePkgApisPipelineV1beta1WorkspaceBinding() {
        return githubComTektoncdPipelinePkgApisPipelineV1beta1WorkspaceBinding;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_WorkspaceBinding")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1beta1WorkspaceBinding(WorkspaceBinding githubComTektoncdPipelinePkgApisPipelineV1beta1WorkspaceBinding) {
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1WorkspaceBinding = githubComTektoncdPipelinePkgApisPipelineV1beta1WorkspaceBinding;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_WorkspaceDeclaration")
    public WorkspaceDeclaration getGithubComTektoncdPipelinePkgApisPipelineV1beta1WorkspaceDeclaration() {
        return githubComTektoncdPipelinePkgApisPipelineV1beta1WorkspaceDeclaration;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_WorkspaceDeclaration")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1beta1WorkspaceDeclaration(WorkspaceDeclaration githubComTektoncdPipelinePkgApisPipelineV1beta1WorkspaceDeclaration) {
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1WorkspaceDeclaration = githubComTektoncdPipelinePkgApisPipelineV1beta1WorkspaceDeclaration;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_WorkspacePipelineTaskBinding")
    public WorkspacePipelineTaskBinding getGithubComTektoncdPipelinePkgApisPipelineV1beta1WorkspacePipelineTaskBinding() {
        return githubComTektoncdPipelinePkgApisPipelineV1beta1WorkspacePipelineTaskBinding;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_WorkspacePipelineTaskBinding")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1beta1WorkspacePipelineTaskBinding(WorkspacePipelineTaskBinding githubComTektoncdPipelinePkgApisPipelineV1beta1WorkspacePipelineTaskBinding) {
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1WorkspacePipelineTaskBinding = githubComTektoncdPipelinePkgApisPipelineV1beta1WorkspacePipelineTaskBinding;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_WorkspaceUsage")
    public WorkspaceUsage getGithubComTektoncdPipelinePkgApisPipelineV1beta1WorkspaceUsage() {
        return githubComTektoncdPipelinePkgApisPipelineV1beta1WorkspaceUsage;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_pipeline_v1beta1_WorkspaceUsage")
    public void setGithubComTektoncdPipelinePkgApisPipelineV1beta1WorkspaceUsage(WorkspaceUsage githubComTektoncdPipelinePkgApisPipelineV1beta1WorkspaceUsage) {
        this.githubComTektoncdPipelinePkgApisPipelineV1beta1WorkspaceUsage = githubComTektoncdPipelinePkgApisPipelineV1beta1WorkspaceUsage;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_resource_v1alpha1_PipelineResourceSpec")
    public PipelineResourceSpec getGithubComTektoncdPipelinePkgApisResourceV1alpha1PipelineResourceSpec() {
        return githubComTektoncdPipelinePkgApisResourceV1alpha1PipelineResourceSpec;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_resource_v1alpha1_PipelineResourceSpec")
    public void setGithubComTektoncdPipelinePkgApisResourceV1alpha1PipelineResourceSpec(PipelineResourceSpec githubComTektoncdPipelinePkgApisResourceV1alpha1PipelineResourceSpec) {
        this.githubComTektoncdPipelinePkgApisResourceV1alpha1PipelineResourceSpec = githubComTektoncdPipelinePkgApisResourceV1alpha1PipelineResourceSpec;
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

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_run_v1alpha1_RunResult")
    public RunResult getGithubComTektoncdPipelinePkgApisRunV1alpha1RunResult() {
        return githubComTektoncdPipelinePkgApisRunV1alpha1RunResult;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_run_v1alpha1_RunResult")
    public void setGithubComTektoncdPipelinePkgApisRunV1alpha1RunResult(RunResult githubComTektoncdPipelinePkgApisRunV1alpha1RunResult) {
        this.githubComTektoncdPipelinePkgApisRunV1alpha1RunResult = githubComTektoncdPipelinePkgApisRunV1alpha1RunResult;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_run_v1alpha1_RunStatus")
    public RunStatus getGithubComTektoncdPipelinePkgApisRunV1alpha1RunStatus() {
        return githubComTektoncdPipelinePkgApisRunV1alpha1RunStatus;
    }

    @JsonProperty("github_com_tektoncd_pipeline_pkg_apis_run_v1alpha1_RunStatus")
    public void setGithubComTektoncdPipelinePkgApisRunV1alpha1RunStatus(RunStatus githubComTektoncdPipelinePkgApisRunV1alpha1RunStatus) {
        this.githubComTektoncdPipelinePkgApisRunV1alpha1RunStatus = githubComTektoncdPipelinePkgApisRunV1alpha1RunStatus;
    }

}
