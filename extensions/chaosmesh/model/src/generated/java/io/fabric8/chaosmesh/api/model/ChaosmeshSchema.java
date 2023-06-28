
package io.fabric8.chaosmesh.api.model;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.chaosmesh.v1alpha1.AWSChaos;
import io.fabric8.chaosmesh.v1alpha1.AWSChaosList;
import io.fabric8.chaosmesh.v1alpha1.AWSChaosSpec;
import io.fabric8.chaosmesh.v1alpha1.AWSChaosStatus;
import io.fabric8.chaosmesh.v1alpha1.AttrOverrideSpec;
import io.fabric8.chaosmesh.v1alpha1.BandwidthSpec;
import io.fabric8.chaosmesh.v1alpha1.BlockChaos;
import io.fabric8.chaosmesh.v1alpha1.BlockChaosList;
import io.fabric8.chaosmesh.v1alpha1.BlockChaosSpec;
import io.fabric8.chaosmesh.v1alpha1.BlockChaosStatus;
import io.fabric8.chaosmesh.v1alpha1.BlockDelaySpec;
import io.fabric8.chaosmesh.v1alpha1.CPUStressor;
import io.fabric8.chaosmesh.v1alpha1.ChaosCondition;
import io.fabric8.chaosmesh.v1alpha1.ClockSpec;
import io.fabric8.chaosmesh.v1alpha1.CorruptSpec;
import io.fabric8.chaosmesh.v1alpha1.DNSChaos;
import io.fabric8.chaosmesh.v1alpha1.DNSChaosList;
import io.fabric8.chaosmesh.v1alpha1.DNSChaosSpec;
import io.fabric8.chaosmesh.v1alpha1.DNSChaosStatus;
import io.fabric8.chaosmesh.v1alpha1.DelaySpec;
import io.fabric8.chaosmesh.v1alpha1.DiskFillSpec;
import io.fabric8.chaosmesh.v1alpha1.DiskPayloadSpec;
import io.fabric8.chaosmesh.v1alpha1.DuplicateSpec;
import io.fabric8.chaosmesh.v1alpha1.ExperimentStatus;
import io.fabric8.chaosmesh.v1alpha1.FailKernRequest;
import io.fabric8.chaosmesh.v1alpha1.Frame;
import io.fabric8.chaosmesh.v1alpha1.GCPChaos;
import io.fabric8.chaosmesh.v1alpha1.GCPChaosList;
import io.fabric8.chaosmesh.v1alpha1.GCPChaosSpec;
import io.fabric8.chaosmesh.v1alpha1.GCPChaosStatus;
import io.fabric8.chaosmesh.v1alpha1.HTTPChaos;
import io.fabric8.chaosmesh.v1alpha1.HTTPChaosList;
import io.fabric8.chaosmesh.v1alpha1.HTTPChaosSpec;
import io.fabric8.chaosmesh.v1alpha1.HTTPChaosStatus;
import io.fabric8.chaosmesh.v1alpha1.IOChaos;
import io.fabric8.chaosmesh.v1alpha1.IOChaosAction;
import io.fabric8.chaosmesh.v1alpha1.IOChaosList;
import io.fabric8.chaosmesh.v1alpha1.IOChaosSpec;
import io.fabric8.chaosmesh.v1alpha1.IOChaosStatus;
import io.fabric8.chaosmesh.v1alpha1.IoFault;
import io.fabric8.chaosmesh.v1alpha1.JVMChaos;
import io.fabric8.chaosmesh.v1alpha1.JVMChaosList;
import io.fabric8.chaosmesh.v1alpha1.JVMChaosSpec;
import io.fabric8.chaosmesh.v1alpha1.JVMChaosStatus;
import io.fabric8.chaosmesh.v1alpha1.JVMExceptionSpec;
import io.fabric8.chaosmesh.v1alpha1.JVMGCSpec;
import io.fabric8.chaosmesh.v1alpha1.JVMLatencySpec;
import io.fabric8.chaosmesh.v1alpha1.JVMReturnSpec;
import io.fabric8.chaosmesh.v1alpha1.JVMRuleDataSpec;
import io.fabric8.chaosmesh.v1alpha1.JVMStressSpec;
import io.fabric8.chaosmesh.v1alpha1.KernelChaos;
import io.fabric8.chaosmesh.v1alpha1.KernelChaosList;
import io.fabric8.chaosmesh.v1alpha1.KernelChaosSpec;
import io.fabric8.chaosmesh.v1alpha1.KernelChaosStatus;
import io.fabric8.chaosmesh.v1alpha1.LossSpec;
import io.fabric8.chaosmesh.v1alpha1.MemoryStressor;
import io.fabric8.chaosmesh.v1alpha1.MistakeSpec;
import io.fabric8.chaosmesh.v1alpha1.NetworkBandwidthSpec;
import io.fabric8.chaosmesh.v1alpha1.NetworkChaos;
import io.fabric8.chaosmesh.v1alpha1.NetworkChaosList;
import io.fabric8.chaosmesh.v1alpha1.NetworkChaosSpec;
import io.fabric8.chaosmesh.v1alpha1.NetworkChaosStatus;
import io.fabric8.chaosmesh.v1alpha1.NetworkCorruptSpec;
import io.fabric8.chaosmesh.v1alpha1.NetworkDNSSpec;
import io.fabric8.chaosmesh.v1alpha1.NetworkDelaySpec;
import io.fabric8.chaosmesh.v1alpha1.NetworkDuplicateSpec;
import io.fabric8.chaosmesh.v1alpha1.NetworkLossSpec;
import io.fabric8.chaosmesh.v1alpha1.NetworkPartitionSpec;
import io.fabric8.chaosmesh.v1alpha1.PhysicalMachineChaos;
import io.fabric8.chaosmesh.v1alpha1.PhysicalMachineChaosList;
import io.fabric8.chaosmesh.v1alpha1.PhysicalMachineChaosSpec;
import io.fabric8.chaosmesh.v1alpha1.PhysicalMachineChaosStatus;
import io.fabric8.chaosmesh.v1alpha1.PhysicalMachineSelectorSpec;
import io.fabric8.chaosmesh.v1alpha1.PodChaos;
import io.fabric8.chaosmesh.v1alpha1.PodChaosList;
import io.fabric8.chaosmesh.v1alpha1.PodChaosSpec;
import io.fabric8.chaosmesh.v1alpha1.PodChaosStatus;
import io.fabric8.chaosmesh.v1alpha1.PodHttpChaos;
import io.fabric8.chaosmesh.v1alpha1.PodHttpChaosActions;
import io.fabric8.chaosmesh.v1alpha1.PodHttpChaosList;
import io.fabric8.chaosmesh.v1alpha1.PodHttpChaosPatchActions;
import io.fabric8.chaosmesh.v1alpha1.PodHttpChaosPatchBodyAction;
import io.fabric8.chaosmesh.v1alpha1.PodHttpChaosReplaceActions;
import io.fabric8.chaosmesh.v1alpha1.PodHttpChaosRule;
import io.fabric8.chaosmesh.v1alpha1.PodHttpChaosSelector;
import io.fabric8.chaosmesh.v1alpha1.PodHttpChaosSpec;
import io.fabric8.chaosmesh.v1alpha1.PodHttpChaosStatus;
import io.fabric8.chaosmesh.v1alpha1.PodIOChaos;
import io.fabric8.chaosmesh.v1alpha1.PodIOChaosList;
import io.fabric8.chaosmesh.v1alpha1.PodIOChaosSpec;
import io.fabric8.chaosmesh.v1alpha1.PodIOChaosStatus;
import io.fabric8.chaosmesh.v1alpha1.PodNetworkChaos;
import io.fabric8.chaosmesh.v1alpha1.PodNetworkChaosList;
import io.fabric8.chaosmesh.v1alpha1.PodNetworkChaosSpec;
import io.fabric8.chaosmesh.v1alpha1.PodNetworkChaosStatus;
import io.fabric8.chaosmesh.v1alpha1.PodSelector;
import io.fabric8.chaosmesh.v1alpha1.PodSelectorSpec;
import io.fabric8.chaosmesh.v1alpha1.ProcessSpec;
import io.fabric8.chaosmesh.v1alpha1.RawIPSet;
import io.fabric8.chaosmesh.v1alpha1.RawIptables;
import io.fabric8.chaosmesh.v1alpha1.RawTrafficControl;
import io.fabric8.chaosmesh.v1alpha1.Record;
import io.fabric8.chaosmesh.v1alpha1.ReorderSpec;
import io.fabric8.chaosmesh.v1alpha1.StressCPUSpec;
import io.fabric8.chaosmesh.v1alpha1.StressChaos;
import io.fabric8.chaosmesh.v1alpha1.StressChaosList;
import io.fabric8.chaosmesh.v1alpha1.StressChaosSpec;
import io.fabric8.chaosmesh.v1alpha1.StressChaosStatus;
import io.fabric8.chaosmesh.v1alpha1.StressInstance;
import io.fabric8.chaosmesh.v1alpha1.StressMemorySpec;
import io.fabric8.chaosmesh.v1alpha1.Stressors;
import io.fabric8.chaosmesh.v1alpha1.TimeChaos;
import io.fabric8.chaosmesh.v1alpha1.TimeChaosList;
import io.fabric8.chaosmesh.v1alpha1.TimeChaosSpec;
import io.fabric8.chaosmesh.v1alpha1.TimeChaosStatus;
import io.fabric8.chaosmesh.v1alpha1.Timespec;
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
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_AWSChaos",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_AWSChaosList",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_AWSChaosSpec",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_AWSChaosStatus",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_AttrOverrideSpec",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_BandwidthSpec",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_BlockChaos",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_BlockChaosList",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_BlockChaosSpec",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_BlockChaosStatus",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_BlockDelaySpec",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_CPUStressor",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_ChaosCondition",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_ClockSpec",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_CorruptSpec",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_DNSChaos",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_DNSChaosList",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_DNSChaosSpec",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_DNSChaosStatus",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_DelaySpec",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_DiskFillSpec",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_DiskPayloadSpec",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_DuplicateSpec",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_ExperimentStatus",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_FailKernRequest",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_Frame",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_GCPChaos",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_GCPChaosList",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_GCPChaosSpec",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_GCPChaosStatus",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_HTTPChaos",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_HTTPChaosList",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_HTTPChaosSpec",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_HTTPChaosStatus",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_IOChaos",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_IOChaosAction",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_IOChaosList",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_IOChaosSpec",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_IOChaosStatus",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_IoFault",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_JVMChaos",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_JVMChaosList",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_JVMChaosSpec",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_JVMChaosStatus",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_JVMExceptionSpec",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_JVMGCSpec",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_JVMLatencySpec",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_JVMReturnSpec",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_JVMRuleDataSpec",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_JVMStressSpec",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_KernelChaos",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_KernelChaosList",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_KernelChaosSpec",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_KernelChaosStatus",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_LossSpec",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_MemoryStressor",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_MistakeSpec",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_NetworkBandwidthSpec",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_NetworkChaos",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_NetworkChaosList",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_NetworkChaosSpec",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_NetworkChaosStatus",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_NetworkCorruptSpec",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_NetworkDNSSpec",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_NetworkDelaySpec",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_NetworkDuplicateSpec",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_NetworkLossSpec",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_NetworkPartitionSpec",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PhysicalMachineChaos",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PhysicalMachineChaosList",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PhysicalMachineChaosSpec",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PhysicalMachineChaosStatus",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PhysicalMachineSelectorSpec",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodChaos",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodChaosList",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodChaosSpec",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodChaosStatus",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodHttpChaos",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodHttpChaosActions",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodHttpChaosList",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodHttpChaosPatchActions",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodHttpChaosPatchBodyAction",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodHttpChaosReplaceActions",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodHttpChaosRule",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodHttpChaosSelector",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodHttpChaosSpec",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodHttpChaosStatus",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodIOChaos",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodIOChaosList",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodIOChaosSpec",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodIOChaosStatus",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodNetworkChaos",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodNetworkChaosList",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodNetworkChaosSpec",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodNetworkChaosStatus",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodSelector",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodSelectorSpec",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_ProcessSpec",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_RawIPSet",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_RawIptables",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_RawTrafficControl",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_Record",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_ReorderSpec",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_StressCPUSpec",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_StressChaos",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_StressChaosList",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_StressChaosSpec",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_StressChaosStatus",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_StressInstance",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_StressMemorySpec",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_Stressors",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_TimeChaos",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_TimeChaosList",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_TimeChaosSpec",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_TimeChaosStatus",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_Timespec"
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
@Generated("jsonschema2pojo")
public class ChaosmeshSchema {

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_AWSChaos")
    private AWSChaos githubComChaosMeshChaosMeshApiV1alpha1AWSChaos;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_AWSChaosList")
    private AWSChaosList githubComChaosMeshChaosMeshApiV1alpha1AWSChaosList;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_AWSChaosSpec")
    private AWSChaosSpec githubComChaosMeshChaosMeshApiV1alpha1AWSChaosSpec;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_AWSChaosStatus")
    private AWSChaosStatus githubComChaosMeshChaosMeshApiV1alpha1AWSChaosStatus;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_AttrOverrideSpec")
    private AttrOverrideSpec githubComChaosMeshChaosMeshApiV1alpha1AttrOverrideSpec;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_BandwidthSpec")
    private BandwidthSpec githubComChaosMeshChaosMeshApiV1alpha1BandwidthSpec;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_BlockChaos")
    private BlockChaos githubComChaosMeshChaosMeshApiV1alpha1BlockChaos;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_BlockChaosList")
    private BlockChaosList githubComChaosMeshChaosMeshApiV1alpha1BlockChaosList;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_BlockChaosSpec")
    private BlockChaosSpec githubComChaosMeshChaosMeshApiV1alpha1BlockChaosSpec;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_BlockChaosStatus")
    private BlockChaosStatus githubComChaosMeshChaosMeshApiV1alpha1BlockChaosStatus;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_BlockDelaySpec")
    private BlockDelaySpec githubComChaosMeshChaosMeshApiV1alpha1BlockDelaySpec;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_CPUStressor")
    private CPUStressor githubComChaosMeshChaosMeshApiV1alpha1CPUStressor;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_ChaosCondition")
    private ChaosCondition githubComChaosMeshChaosMeshApiV1alpha1ChaosCondition;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_ClockSpec")
    private ClockSpec githubComChaosMeshChaosMeshApiV1alpha1ClockSpec;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_CorruptSpec")
    private CorruptSpec githubComChaosMeshChaosMeshApiV1alpha1CorruptSpec;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_DNSChaos")
    private DNSChaos githubComChaosMeshChaosMeshApiV1alpha1DNSChaos;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_DNSChaosList")
    private DNSChaosList githubComChaosMeshChaosMeshApiV1alpha1DNSChaosList;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_DNSChaosSpec")
    private DNSChaosSpec githubComChaosMeshChaosMeshApiV1alpha1DNSChaosSpec;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_DNSChaosStatus")
    private DNSChaosStatus githubComChaosMeshChaosMeshApiV1alpha1DNSChaosStatus;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_DelaySpec")
    private DelaySpec githubComChaosMeshChaosMeshApiV1alpha1DelaySpec;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_DiskFillSpec")
    private DiskFillSpec githubComChaosMeshChaosMeshApiV1alpha1DiskFillSpec;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_DiskPayloadSpec")
    private DiskPayloadSpec githubComChaosMeshChaosMeshApiV1alpha1DiskPayloadSpec;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_DuplicateSpec")
    private DuplicateSpec githubComChaosMeshChaosMeshApiV1alpha1DuplicateSpec;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_ExperimentStatus")
    private ExperimentStatus githubComChaosMeshChaosMeshApiV1alpha1ExperimentStatus;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_FailKernRequest")
    private FailKernRequest githubComChaosMeshChaosMeshApiV1alpha1FailKernRequest;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_Frame")
    private Frame githubComChaosMeshChaosMeshApiV1alpha1Frame;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_GCPChaos")
    private GCPChaos githubComChaosMeshChaosMeshApiV1alpha1GCPChaos;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_GCPChaosList")
    private GCPChaosList githubComChaosMeshChaosMeshApiV1alpha1GCPChaosList;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_GCPChaosSpec")
    private GCPChaosSpec githubComChaosMeshChaosMeshApiV1alpha1GCPChaosSpec;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_GCPChaosStatus")
    private GCPChaosStatus githubComChaosMeshChaosMeshApiV1alpha1GCPChaosStatus;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_HTTPChaos")
    private HTTPChaos githubComChaosMeshChaosMeshApiV1alpha1HTTPChaos;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_HTTPChaosList")
    private HTTPChaosList githubComChaosMeshChaosMeshApiV1alpha1HTTPChaosList;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_HTTPChaosSpec")
    private HTTPChaosSpec githubComChaosMeshChaosMeshApiV1alpha1HTTPChaosSpec;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_HTTPChaosStatus")
    private HTTPChaosStatus githubComChaosMeshChaosMeshApiV1alpha1HTTPChaosStatus;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_IOChaos")
    private IOChaos githubComChaosMeshChaosMeshApiV1alpha1IOChaos;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_IOChaosAction")
    private IOChaosAction githubComChaosMeshChaosMeshApiV1alpha1IOChaosAction;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_IOChaosList")
    private IOChaosList githubComChaosMeshChaosMeshApiV1alpha1IOChaosList;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_IOChaosSpec")
    private IOChaosSpec githubComChaosMeshChaosMeshApiV1alpha1IOChaosSpec;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_IOChaosStatus")
    private IOChaosStatus githubComChaosMeshChaosMeshApiV1alpha1IOChaosStatus;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_IoFault")
    private IoFault githubComChaosMeshChaosMeshApiV1alpha1IoFault;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_JVMChaos")
    private JVMChaos githubComChaosMeshChaosMeshApiV1alpha1JVMChaos;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_JVMChaosList")
    private JVMChaosList githubComChaosMeshChaosMeshApiV1alpha1JVMChaosList;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_JVMChaosSpec")
    private JVMChaosSpec githubComChaosMeshChaosMeshApiV1alpha1JVMChaosSpec;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_JVMChaosStatus")
    private JVMChaosStatus githubComChaosMeshChaosMeshApiV1alpha1JVMChaosStatus;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_JVMExceptionSpec")
    private JVMExceptionSpec githubComChaosMeshChaosMeshApiV1alpha1JVMExceptionSpec;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_JVMGCSpec")
    private JVMGCSpec githubComChaosMeshChaosMeshApiV1alpha1JVMGCSpec;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_JVMLatencySpec")
    private JVMLatencySpec githubComChaosMeshChaosMeshApiV1alpha1JVMLatencySpec;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_JVMReturnSpec")
    private JVMReturnSpec githubComChaosMeshChaosMeshApiV1alpha1JVMReturnSpec;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_JVMRuleDataSpec")
    private JVMRuleDataSpec githubComChaosMeshChaosMeshApiV1alpha1JVMRuleDataSpec;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_JVMStressSpec")
    private JVMStressSpec githubComChaosMeshChaosMeshApiV1alpha1JVMStressSpec;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_KernelChaos")
    private KernelChaos githubComChaosMeshChaosMeshApiV1alpha1KernelChaos;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_KernelChaosList")
    private KernelChaosList githubComChaosMeshChaosMeshApiV1alpha1KernelChaosList;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_KernelChaosSpec")
    private KernelChaosSpec githubComChaosMeshChaosMeshApiV1alpha1KernelChaosSpec;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_KernelChaosStatus")
    private KernelChaosStatus githubComChaosMeshChaosMeshApiV1alpha1KernelChaosStatus;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_LossSpec")
    private LossSpec githubComChaosMeshChaosMeshApiV1alpha1LossSpec;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_MemoryStressor")
    private MemoryStressor githubComChaosMeshChaosMeshApiV1alpha1MemoryStressor;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_MistakeSpec")
    private MistakeSpec githubComChaosMeshChaosMeshApiV1alpha1MistakeSpec;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_NetworkBandwidthSpec")
    private NetworkBandwidthSpec githubComChaosMeshChaosMeshApiV1alpha1NetworkBandwidthSpec;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_NetworkChaos")
    private NetworkChaos githubComChaosMeshChaosMeshApiV1alpha1NetworkChaos;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_NetworkChaosList")
    private NetworkChaosList githubComChaosMeshChaosMeshApiV1alpha1NetworkChaosList;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_NetworkChaosSpec")
    private NetworkChaosSpec githubComChaosMeshChaosMeshApiV1alpha1NetworkChaosSpec;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_NetworkChaosStatus")
    private NetworkChaosStatus githubComChaosMeshChaosMeshApiV1alpha1NetworkChaosStatus;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_NetworkCorruptSpec")
    private NetworkCorruptSpec githubComChaosMeshChaosMeshApiV1alpha1NetworkCorruptSpec;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_NetworkDNSSpec")
    private NetworkDNSSpec githubComChaosMeshChaosMeshApiV1alpha1NetworkDNSSpec;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_NetworkDelaySpec")
    private NetworkDelaySpec githubComChaosMeshChaosMeshApiV1alpha1NetworkDelaySpec;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_NetworkDuplicateSpec")
    private NetworkDuplicateSpec githubComChaosMeshChaosMeshApiV1alpha1NetworkDuplicateSpec;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_NetworkLossSpec")
    private NetworkLossSpec githubComChaosMeshChaosMeshApiV1alpha1NetworkLossSpec;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_NetworkPartitionSpec")
    private NetworkPartitionSpec githubComChaosMeshChaosMeshApiV1alpha1NetworkPartitionSpec;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PhysicalMachineChaos")
    private PhysicalMachineChaos githubComChaosMeshChaosMeshApiV1alpha1PhysicalMachineChaos;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PhysicalMachineChaosList")
    private PhysicalMachineChaosList githubComChaosMeshChaosMeshApiV1alpha1PhysicalMachineChaosList;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PhysicalMachineChaosSpec")
    private PhysicalMachineChaosSpec githubComChaosMeshChaosMeshApiV1alpha1PhysicalMachineChaosSpec;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PhysicalMachineChaosStatus")
    private PhysicalMachineChaosStatus githubComChaosMeshChaosMeshApiV1alpha1PhysicalMachineChaosStatus;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PhysicalMachineSelectorSpec")
    private PhysicalMachineSelectorSpec githubComChaosMeshChaosMeshApiV1alpha1PhysicalMachineSelectorSpec;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodChaos")
    private PodChaos githubComChaosMeshChaosMeshApiV1alpha1PodChaos;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodChaosList")
    private PodChaosList githubComChaosMeshChaosMeshApiV1alpha1PodChaosList;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodChaosSpec")
    private PodChaosSpec githubComChaosMeshChaosMeshApiV1alpha1PodChaosSpec;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodChaosStatus")
    private PodChaosStatus githubComChaosMeshChaosMeshApiV1alpha1PodChaosStatus;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodHttpChaos")
    private PodHttpChaos githubComChaosMeshChaosMeshApiV1alpha1PodHttpChaos;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodHttpChaosActions")
    private PodHttpChaosActions githubComChaosMeshChaosMeshApiV1alpha1PodHttpChaosActions;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodHttpChaosList")
    private PodHttpChaosList githubComChaosMeshChaosMeshApiV1alpha1PodHttpChaosList;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodHttpChaosPatchActions")
    private PodHttpChaosPatchActions githubComChaosMeshChaosMeshApiV1alpha1PodHttpChaosPatchActions;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodHttpChaosPatchBodyAction")
    private PodHttpChaosPatchBodyAction githubComChaosMeshChaosMeshApiV1alpha1PodHttpChaosPatchBodyAction;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodHttpChaosReplaceActions")
    private PodHttpChaosReplaceActions githubComChaosMeshChaosMeshApiV1alpha1PodHttpChaosReplaceActions;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodHttpChaosRule")
    private PodHttpChaosRule githubComChaosMeshChaosMeshApiV1alpha1PodHttpChaosRule;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodHttpChaosSelector")
    private PodHttpChaosSelector githubComChaosMeshChaosMeshApiV1alpha1PodHttpChaosSelector;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodHttpChaosSpec")
    private PodHttpChaosSpec githubComChaosMeshChaosMeshApiV1alpha1PodHttpChaosSpec;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodHttpChaosStatus")
    private PodHttpChaosStatus githubComChaosMeshChaosMeshApiV1alpha1PodHttpChaosStatus;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodIOChaos")
    private PodIOChaos githubComChaosMeshChaosMeshApiV1alpha1PodIOChaos;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodIOChaosList")
    private PodIOChaosList githubComChaosMeshChaosMeshApiV1alpha1PodIOChaosList;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodIOChaosSpec")
    private PodIOChaosSpec githubComChaosMeshChaosMeshApiV1alpha1PodIOChaosSpec;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodIOChaosStatus")
    private PodIOChaosStatus githubComChaosMeshChaosMeshApiV1alpha1PodIOChaosStatus;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodNetworkChaos")
    private PodNetworkChaos githubComChaosMeshChaosMeshApiV1alpha1PodNetworkChaos;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodNetworkChaosList")
    private PodNetworkChaosList githubComChaosMeshChaosMeshApiV1alpha1PodNetworkChaosList;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodNetworkChaosSpec")
    private PodNetworkChaosSpec githubComChaosMeshChaosMeshApiV1alpha1PodNetworkChaosSpec;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodNetworkChaosStatus")
    private PodNetworkChaosStatus githubComChaosMeshChaosMeshApiV1alpha1PodNetworkChaosStatus;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodSelector")
    private PodSelector githubComChaosMeshChaosMeshApiV1alpha1PodSelector;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodSelectorSpec")
    private PodSelectorSpec githubComChaosMeshChaosMeshApiV1alpha1PodSelectorSpec;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_ProcessSpec")
    private ProcessSpec githubComChaosMeshChaosMeshApiV1alpha1ProcessSpec;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_RawIPSet")
    private RawIPSet githubComChaosMeshChaosMeshApiV1alpha1RawIPSet;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_RawIptables")
    private RawIptables githubComChaosMeshChaosMeshApiV1alpha1RawIptables;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_RawTrafficControl")
    private RawTrafficControl githubComChaosMeshChaosMeshApiV1alpha1RawTrafficControl;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_Record")
    private Record githubComChaosMeshChaosMeshApiV1alpha1Record;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_ReorderSpec")
    private ReorderSpec githubComChaosMeshChaosMeshApiV1alpha1ReorderSpec;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_StressCPUSpec")
    private StressCPUSpec githubComChaosMeshChaosMeshApiV1alpha1StressCPUSpec;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_StressChaos")
    private StressChaos githubComChaosMeshChaosMeshApiV1alpha1StressChaos;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_StressChaosList")
    private StressChaosList githubComChaosMeshChaosMeshApiV1alpha1StressChaosList;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_StressChaosSpec")
    private StressChaosSpec githubComChaosMeshChaosMeshApiV1alpha1StressChaosSpec;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_StressChaosStatus")
    private StressChaosStatus githubComChaosMeshChaosMeshApiV1alpha1StressChaosStatus;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_StressInstance")
    private StressInstance githubComChaosMeshChaosMeshApiV1alpha1StressInstance;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_StressMemorySpec")
    private StressMemorySpec githubComChaosMeshChaosMeshApiV1alpha1StressMemorySpec;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_Stressors")
    private Stressors githubComChaosMeshChaosMeshApiV1alpha1Stressors;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_TimeChaos")
    private TimeChaos githubComChaosMeshChaosMeshApiV1alpha1TimeChaos;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_TimeChaosList")
    private TimeChaosList githubComChaosMeshChaosMeshApiV1alpha1TimeChaosList;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_TimeChaosSpec")
    private TimeChaosSpec githubComChaosMeshChaosMeshApiV1alpha1TimeChaosSpec;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_TimeChaosStatus")
    private TimeChaosStatus githubComChaosMeshChaosMeshApiV1alpha1TimeChaosStatus;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_Timespec")
    private Timespec githubComChaosMeshChaosMeshApiV1alpha1Timespec;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ChaosmeshSchema() {
    }

    public ChaosmeshSchema(AWSChaos githubComChaosMeshChaosMeshApiV1alpha1AWSChaos, AWSChaosList githubComChaosMeshChaosMeshApiV1alpha1AWSChaosList, AWSChaosSpec githubComChaosMeshChaosMeshApiV1alpha1AWSChaosSpec, AWSChaosStatus githubComChaosMeshChaosMeshApiV1alpha1AWSChaosStatus, AttrOverrideSpec githubComChaosMeshChaosMeshApiV1alpha1AttrOverrideSpec, BandwidthSpec githubComChaosMeshChaosMeshApiV1alpha1BandwidthSpec, BlockChaos githubComChaosMeshChaosMeshApiV1alpha1BlockChaos, BlockChaosList githubComChaosMeshChaosMeshApiV1alpha1BlockChaosList, BlockChaosSpec githubComChaosMeshChaosMeshApiV1alpha1BlockChaosSpec, BlockChaosStatus githubComChaosMeshChaosMeshApiV1alpha1BlockChaosStatus, BlockDelaySpec githubComChaosMeshChaosMeshApiV1alpha1BlockDelaySpec, CPUStressor githubComChaosMeshChaosMeshApiV1alpha1CPUStressor, ChaosCondition githubComChaosMeshChaosMeshApiV1alpha1ChaosCondition, ClockSpec githubComChaosMeshChaosMeshApiV1alpha1ClockSpec, CorruptSpec githubComChaosMeshChaosMeshApiV1alpha1CorruptSpec, DNSChaos githubComChaosMeshChaosMeshApiV1alpha1DNSChaos, DNSChaosList githubComChaosMeshChaosMeshApiV1alpha1DNSChaosList, DNSChaosSpec githubComChaosMeshChaosMeshApiV1alpha1DNSChaosSpec, DNSChaosStatus githubComChaosMeshChaosMeshApiV1alpha1DNSChaosStatus, DelaySpec githubComChaosMeshChaosMeshApiV1alpha1DelaySpec, DiskFillSpec githubComChaosMeshChaosMeshApiV1alpha1DiskFillSpec, DiskPayloadSpec githubComChaosMeshChaosMeshApiV1alpha1DiskPayloadSpec, DuplicateSpec githubComChaosMeshChaosMeshApiV1alpha1DuplicateSpec, ExperimentStatus githubComChaosMeshChaosMeshApiV1alpha1ExperimentStatus, FailKernRequest githubComChaosMeshChaosMeshApiV1alpha1FailKernRequest, Frame githubComChaosMeshChaosMeshApiV1alpha1Frame, GCPChaos githubComChaosMeshChaosMeshApiV1alpha1GCPChaos, GCPChaosList githubComChaosMeshChaosMeshApiV1alpha1GCPChaosList, GCPChaosSpec githubComChaosMeshChaosMeshApiV1alpha1GCPChaosSpec, GCPChaosStatus githubComChaosMeshChaosMeshApiV1alpha1GCPChaosStatus, HTTPChaos githubComChaosMeshChaosMeshApiV1alpha1HTTPChaos, HTTPChaosList githubComChaosMeshChaosMeshApiV1alpha1HTTPChaosList, HTTPChaosSpec githubComChaosMeshChaosMeshApiV1alpha1HTTPChaosSpec, HTTPChaosStatus githubComChaosMeshChaosMeshApiV1alpha1HTTPChaosStatus, IOChaos githubComChaosMeshChaosMeshApiV1alpha1IOChaos, IOChaosAction githubComChaosMeshChaosMeshApiV1alpha1IOChaosAction, IOChaosList githubComChaosMeshChaosMeshApiV1alpha1IOChaosList, IOChaosSpec githubComChaosMeshChaosMeshApiV1alpha1IOChaosSpec, IOChaosStatus githubComChaosMeshChaosMeshApiV1alpha1IOChaosStatus, IoFault githubComChaosMeshChaosMeshApiV1alpha1IoFault, JVMChaos githubComChaosMeshChaosMeshApiV1alpha1JVMChaos, JVMChaosList githubComChaosMeshChaosMeshApiV1alpha1JVMChaosList, JVMChaosSpec githubComChaosMeshChaosMeshApiV1alpha1JVMChaosSpec, JVMChaosStatus githubComChaosMeshChaosMeshApiV1alpha1JVMChaosStatus, JVMExceptionSpec githubComChaosMeshChaosMeshApiV1alpha1JVMExceptionSpec, JVMGCSpec githubComChaosMeshChaosMeshApiV1alpha1JVMGCSpec, JVMLatencySpec githubComChaosMeshChaosMeshApiV1alpha1JVMLatencySpec, JVMReturnSpec githubComChaosMeshChaosMeshApiV1alpha1JVMReturnSpec, JVMRuleDataSpec githubComChaosMeshChaosMeshApiV1alpha1JVMRuleDataSpec, JVMStressSpec githubComChaosMeshChaosMeshApiV1alpha1JVMStressSpec, KernelChaos githubComChaosMeshChaosMeshApiV1alpha1KernelChaos, KernelChaosList githubComChaosMeshChaosMeshApiV1alpha1KernelChaosList, KernelChaosSpec githubComChaosMeshChaosMeshApiV1alpha1KernelChaosSpec, KernelChaosStatus githubComChaosMeshChaosMeshApiV1alpha1KernelChaosStatus, LossSpec githubComChaosMeshChaosMeshApiV1alpha1LossSpec, MemoryStressor githubComChaosMeshChaosMeshApiV1alpha1MemoryStressor, MistakeSpec githubComChaosMeshChaosMeshApiV1alpha1MistakeSpec, NetworkBandwidthSpec githubComChaosMeshChaosMeshApiV1alpha1NetworkBandwidthSpec, NetworkChaos githubComChaosMeshChaosMeshApiV1alpha1NetworkChaos, NetworkChaosList githubComChaosMeshChaosMeshApiV1alpha1NetworkChaosList, NetworkChaosSpec githubComChaosMeshChaosMeshApiV1alpha1NetworkChaosSpec, NetworkChaosStatus githubComChaosMeshChaosMeshApiV1alpha1NetworkChaosStatus, NetworkCorruptSpec githubComChaosMeshChaosMeshApiV1alpha1NetworkCorruptSpec, NetworkDNSSpec githubComChaosMeshChaosMeshApiV1alpha1NetworkDNSSpec, NetworkDelaySpec githubComChaosMeshChaosMeshApiV1alpha1NetworkDelaySpec, NetworkDuplicateSpec githubComChaosMeshChaosMeshApiV1alpha1NetworkDuplicateSpec, NetworkLossSpec githubComChaosMeshChaosMeshApiV1alpha1NetworkLossSpec, NetworkPartitionSpec githubComChaosMeshChaosMeshApiV1alpha1NetworkPartitionSpec, PhysicalMachineChaos githubComChaosMeshChaosMeshApiV1alpha1PhysicalMachineChaos, PhysicalMachineChaosList githubComChaosMeshChaosMeshApiV1alpha1PhysicalMachineChaosList, PhysicalMachineChaosSpec githubComChaosMeshChaosMeshApiV1alpha1PhysicalMachineChaosSpec, PhysicalMachineChaosStatus githubComChaosMeshChaosMeshApiV1alpha1PhysicalMachineChaosStatus, PhysicalMachineSelectorSpec githubComChaosMeshChaosMeshApiV1alpha1PhysicalMachineSelectorSpec, PodChaos githubComChaosMeshChaosMeshApiV1alpha1PodChaos, PodChaosList githubComChaosMeshChaosMeshApiV1alpha1PodChaosList, PodChaosSpec githubComChaosMeshChaosMeshApiV1alpha1PodChaosSpec, PodChaosStatus githubComChaosMeshChaosMeshApiV1alpha1PodChaosStatus, PodHttpChaos githubComChaosMeshChaosMeshApiV1alpha1PodHttpChaos, PodHttpChaosActions githubComChaosMeshChaosMeshApiV1alpha1PodHttpChaosActions, PodHttpChaosList githubComChaosMeshChaosMeshApiV1alpha1PodHttpChaosList, PodHttpChaosPatchActions githubComChaosMeshChaosMeshApiV1alpha1PodHttpChaosPatchActions, PodHttpChaosPatchBodyAction githubComChaosMeshChaosMeshApiV1alpha1PodHttpChaosPatchBodyAction, PodHttpChaosReplaceActions githubComChaosMeshChaosMeshApiV1alpha1PodHttpChaosReplaceActions, PodHttpChaosRule githubComChaosMeshChaosMeshApiV1alpha1PodHttpChaosRule, PodHttpChaosSelector githubComChaosMeshChaosMeshApiV1alpha1PodHttpChaosSelector, PodHttpChaosSpec githubComChaosMeshChaosMeshApiV1alpha1PodHttpChaosSpec, PodHttpChaosStatus githubComChaosMeshChaosMeshApiV1alpha1PodHttpChaosStatus, PodIOChaos githubComChaosMeshChaosMeshApiV1alpha1PodIOChaos, PodIOChaosList githubComChaosMeshChaosMeshApiV1alpha1PodIOChaosList, PodIOChaosSpec githubComChaosMeshChaosMeshApiV1alpha1PodIOChaosSpec, PodIOChaosStatus githubComChaosMeshChaosMeshApiV1alpha1PodIOChaosStatus, PodNetworkChaos githubComChaosMeshChaosMeshApiV1alpha1PodNetworkChaos, PodNetworkChaosList githubComChaosMeshChaosMeshApiV1alpha1PodNetworkChaosList, PodNetworkChaosSpec githubComChaosMeshChaosMeshApiV1alpha1PodNetworkChaosSpec, PodNetworkChaosStatus githubComChaosMeshChaosMeshApiV1alpha1PodNetworkChaosStatus, PodSelector githubComChaosMeshChaosMeshApiV1alpha1PodSelector, PodSelectorSpec githubComChaosMeshChaosMeshApiV1alpha1PodSelectorSpec, ProcessSpec githubComChaosMeshChaosMeshApiV1alpha1ProcessSpec, RawIPSet githubComChaosMeshChaosMeshApiV1alpha1RawIPSet, RawIptables githubComChaosMeshChaosMeshApiV1alpha1RawIptables, RawTrafficControl githubComChaosMeshChaosMeshApiV1alpha1RawTrafficControl, Record githubComChaosMeshChaosMeshApiV1alpha1Record, ReorderSpec githubComChaosMeshChaosMeshApiV1alpha1ReorderSpec, StressCPUSpec githubComChaosMeshChaosMeshApiV1alpha1StressCPUSpec, StressChaos githubComChaosMeshChaosMeshApiV1alpha1StressChaos, StressChaosList githubComChaosMeshChaosMeshApiV1alpha1StressChaosList, StressChaosSpec githubComChaosMeshChaosMeshApiV1alpha1StressChaosSpec, StressChaosStatus githubComChaosMeshChaosMeshApiV1alpha1StressChaosStatus, StressInstance githubComChaosMeshChaosMeshApiV1alpha1StressInstance, StressMemorySpec githubComChaosMeshChaosMeshApiV1alpha1StressMemorySpec, Stressors githubComChaosMeshChaosMeshApiV1alpha1Stressors, TimeChaos githubComChaosMeshChaosMeshApiV1alpha1TimeChaos, TimeChaosList githubComChaosMeshChaosMeshApiV1alpha1TimeChaosList, TimeChaosSpec githubComChaosMeshChaosMeshApiV1alpha1TimeChaosSpec, TimeChaosStatus githubComChaosMeshChaosMeshApiV1alpha1TimeChaosStatus, Timespec githubComChaosMeshChaosMeshApiV1alpha1Timespec) {
        super();
        this.githubComChaosMeshChaosMeshApiV1alpha1AWSChaos = githubComChaosMeshChaosMeshApiV1alpha1AWSChaos;
        this.githubComChaosMeshChaosMeshApiV1alpha1AWSChaosList = githubComChaosMeshChaosMeshApiV1alpha1AWSChaosList;
        this.githubComChaosMeshChaosMeshApiV1alpha1AWSChaosSpec = githubComChaosMeshChaosMeshApiV1alpha1AWSChaosSpec;
        this.githubComChaosMeshChaosMeshApiV1alpha1AWSChaosStatus = githubComChaosMeshChaosMeshApiV1alpha1AWSChaosStatus;
        this.githubComChaosMeshChaosMeshApiV1alpha1AttrOverrideSpec = githubComChaosMeshChaosMeshApiV1alpha1AttrOverrideSpec;
        this.githubComChaosMeshChaosMeshApiV1alpha1BandwidthSpec = githubComChaosMeshChaosMeshApiV1alpha1BandwidthSpec;
        this.githubComChaosMeshChaosMeshApiV1alpha1BlockChaos = githubComChaosMeshChaosMeshApiV1alpha1BlockChaos;
        this.githubComChaosMeshChaosMeshApiV1alpha1BlockChaosList = githubComChaosMeshChaosMeshApiV1alpha1BlockChaosList;
        this.githubComChaosMeshChaosMeshApiV1alpha1BlockChaosSpec = githubComChaosMeshChaosMeshApiV1alpha1BlockChaosSpec;
        this.githubComChaosMeshChaosMeshApiV1alpha1BlockChaosStatus = githubComChaosMeshChaosMeshApiV1alpha1BlockChaosStatus;
        this.githubComChaosMeshChaosMeshApiV1alpha1BlockDelaySpec = githubComChaosMeshChaosMeshApiV1alpha1BlockDelaySpec;
        this.githubComChaosMeshChaosMeshApiV1alpha1CPUStressor = githubComChaosMeshChaosMeshApiV1alpha1CPUStressor;
        this.githubComChaosMeshChaosMeshApiV1alpha1ChaosCondition = githubComChaosMeshChaosMeshApiV1alpha1ChaosCondition;
        this.githubComChaosMeshChaosMeshApiV1alpha1ClockSpec = githubComChaosMeshChaosMeshApiV1alpha1ClockSpec;
        this.githubComChaosMeshChaosMeshApiV1alpha1CorruptSpec = githubComChaosMeshChaosMeshApiV1alpha1CorruptSpec;
        this.githubComChaosMeshChaosMeshApiV1alpha1DNSChaos = githubComChaosMeshChaosMeshApiV1alpha1DNSChaos;
        this.githubComChaosMeshChaosMeshApiV1alpha1DNSChaosList = githubComChaosMeshChaosMeshApiV1alpha1DNSChaosList;
        this.githubComChaosMeshChaosMeshApiV1alpha1DNSChaosSpec = githubComChaosMeshChaosMeshApiV1alpha1DNSChaosSpec;
        this.githubComChaosMeshChaosMeshApiV1alpha1DNSChaosStatus = githubComChaosMeshChaosMeshApiV1alpha1DNSChaosStatus;
        this.githubComChaosMeshChaosMeshApiV1alpha1DelaySpec = githubComChaosMeshChaosMeshApiV1alpha1DelaySpec;
        this.githubComChaosMeshChaosMeshApiV1alpha1DiskFillSpec = githubComChaosMeshChaosMeshApiV1alpha1DiskFillSpec;
        this.githubComChaosMeshChaosMeshApiV1alpha1DiskPayloadSpec = githubComChaosMeshChaosMeshApiV1alpha1DiskPayloadSpec;
        this.githubComChaosMeshChaosMeshApiV1alpha1DuplicateSpec = githubComChaosMeshChaosMeshApiV1alpha1DuplicateSpec;
        this.githubComChaosMeshChaosMeshApiV1alpha1ExperimentStatus = githubComChaosMeshChaosMeshApiV1alpha1ExperimentStatus;
        this.githubComChaosMeshChaosMeshApiV1alpha1FailKernRequest = githubComChaosMeshChaosMeshApiV1alpha1FailKernRequest;
        this.githubComChaosMeshChaosMeshApiV1alpha1Frame = githubComChaosMeshChaosMeshApiV1alpha1Frame;
        this.githubComChaosMeshChaosMeshApiV1alpha1GCPChaos = githubComChaosMeshChaosMeshApiV1alpha1GCPChaos;
        this.githubComChaosMeshChaosMeshApiV1alpha1GCPChaosList = githubComChaosMeshChaosMeshApiV1alpha1GCPChaosList;
        this.githubComChaosMeshChaosMeshApiV1alpha1GCPChaosSpec = githubComChaosMeshChaosMeshApiV1alpha1GCPChaosSpec;
        this.githubComChaosMeshChaosMeshApiV1alpha1GCPChaosStatus = githubComChaosMeshChaosMeshApiV1alpha1GCPChaosStatus;
        this.githubComChaosMeshChaosMeshApiV1alpha1HTTPChaos = githubComChaosMeshChaosMeshApiV1alpha1HTTPChaos;
        this.githubComChaosMeshChaosMeshApiV1alpha1HTTPChaosList = githubComChaosMeshChaosMeshApiV1alpha1HTTPChaosList;
        this.githubComChaosMeshChaosMeshApiV1alpha1HTTPChaosSpec = githubComChaosMeshChaosMeshApiV1alpha1HTTPChaosSpec;
        this.githubComChaosMeshChaosMeshApiV1alpha1HTTPChaosStatus = githubComChaosMeshChaosMeshApiV1alpha1HTTPChaosStatus;
        this.githubComChaosMeshChaosMeshApiV1alpha1IOChaos = githubComChaosMeshChaosMeshApiV1alpha1IOChaos;
        this.githubComChaosMeshChaosMeshApiV1alpha1IOChaosAction = githubComChaosMeshChaosMeshApiV1alpha1IOChaosAction;
        this.githubComChaosMeshChaosMeshApiV1alpha1IOChaosList = githubComChaosMeshChaosMeshApiV1alpha1IOChaosList;
        this.githubComChaosMeshChaosMeshApiV1alpha1IOChaosSpec = githubComChaosMeshChaosMeshApiV1alpha1IOChaosSpec;
        this.githubComChaosMeshChaosMeshApiV1alpha1IOChaosStatus = githubComChaosMeshChaosMeshApiV1alpha1IOChaosStatus;
        this.githubComChaosMeshChaosMeshApiV1alpha1IoFault = githubComChaosMeshChaosMeshApiV1alpha1IoFault;
        this.githubComChaosMeshChaosMeshApiV1alpha1JVMChaos = githubComChaosMeshChaosMeshApiV1alpha1JVMChaos;
        this.githubComChaosMeshChaosMeshApiV1alpha1JVMChaosList = githubComChaosMeshChaosMeshApiV1alpha1JVMChaosList;
        this.githubComChaosMeshChaosMeshApiV1alpha1JVMChaosSpec = githubComChaosMeshChaosMeshApiV1alpha1JVMChaosSpec;
        this.githubComChaosMeshChaosMeshApiV1alpha1JVMChaosStatus = githubComChaosMeshChaosMeshApiV1alpha1JVMChaosStatus;
        this.githubComChaosMeshChaosMeshApiV1alpha1JVMExceptionSpec = githubComChaosMeshChaosMeshApiV1alpha1JVMExceptionSpec;
        this.githubComChaosMeshChaosMeshApiV1alpha1JVMGCSpec = githubComChaosMeshChaosMeshApiV1alpha1JVMGCSpec;
        this.githubComChaosMeshChaosMeshApiV1alpha1JVMLatencySpec = githubComChaosMeshChaosMeshApiV1alpha1JVMLatencySpec;
        this.githubComChaosMeshChaosMeshApiV1alpha1JVMReturnSpec = githubComChaosMeshChaosMeshApiV1alpha1JVMReturnSpec;
        this.githubComChaosMeshChaosMeshApiV1alpha1JVMRuleDataSpec = githubComChaosMeshChaosMeshApiV1alpha1JVMRuleDataSpec;
        this.githubComChaosMeshChaosMeshApiV1alpha1JVMStressSpec = githubComChaosMeshChaosMeshApiV1alpha1JVMStressSpec;
        this.githubComChaosMeshChaosMeshApiV1alpha1KernelChaos = githubComChaosMeshChaosMeshApiV1alpha1KernelChaos;
        this.githubComChaosMeshChaosMeshApiV1alpha1KernelChaosList = githubComChaosMeshChaosMeshApiV1alpha1KernelChaosList;
        this.githubComChaosMeshChaosMeshApiV1alpha1KernelChaosSpec = githubComChaosMeshChaosMeshApiV1alpha1KernelChaosSpec;
        this.githubComChaosMeshChaosMeshApiV1alpha1KernelChaosStatus = githubComChaosMeshChaosMeshApiV1alpha1KernelChaosStatus;
        this.githubComChaosMeshChaosMeshApiV1alpha1LossSpec = githubComChaosMeshChaosMeshApiV1alpha1LossSpec;
        this.githubComChaosMeshChaosMeshApiV1alpha1MemoryStressor = githubComChaosMeshChaosMeshApiV1alpha1MemoryStressor;
        this.githubComChaosMeshChaosMeshApiV1alpha1MistakeSpec = githubComChaosMeshChaosMeshApiV1alpha1MistakeSpec;
        this.githubComChaosMeshChaosMeshApiV1alpha1NetworkBandwidthSpec = githubComChaosMeshChaosMeshApiV1alpha1NetworkBandwidthSpec;
        this.githubComChaosMeshChaosMeshApiV1alpha1NetworkChaos = githubComChaosMeshChaosMeshApiV1alpha1NetworkChaos;
        this.githubComChaosMeshChaosMeshApiV1alpha1NetworkChaosList = githubComChaosMeshChaosMeshApiV1alpha1NetworkChaosList;
        this.githubComChaosMeshChaosMeshApiV1alpha1NetworkChaosSpec = githubComChaosMeshChaosMeshApiV1alpha1NetworkChaosSpec;
        this.githubComChaosMeshChaosMeshApiV1alpha1NetworkChaosStatus = githubComChaosMeshChaosMeshApiV1alpha1NetworkChaosStatus;
        this.githubComChaosMeshChaosMeshApiV1alpha1NetworkCorruptSpec = githubComChaosMeshChaosMeshApiV1alpha1NetworkCorruptSpec;
        this.githubComChaosMeshChaosMeshApiV1alpha1NetworkDNSSpec = githubComChaosMeshChaosMeshApiV1alpha1NetworkDNSSpec;
        this.githubComChaosMeshChaosMeshApiV1alpha1NetworkDelaySpec = githubComChaosMeshChaosMeshApiV1alpha1NetworkDelaySpec;
        this.githubComChaosMeshChaosMeshApiV1alpha1NetworkDuplicateSpec = githubComChaosMeshChaosMeshApiV1alpha1NetworkDuplicateSpec;
        this.githubComChaosMeshChaosMeshApiV1alpha1NetworkLossSpec = githubComChaosMeshChaosMeshApiV1alpha1NetworkLossSpec;
        this.githubComChaosMeshChaosMeshApiV1alpha1NetworkPartitionSpec = githubComChaosMeshChaosMeshApiV1alpha1NetworkPartitionSpec;
        this.githubComChaosMeshChaosMeshApiV1alpha1PhysicalMachineChaos = githubComChaosMeshChaosMeshApiV1alpha1PhysicalMachineChaos;
        this.githubComChaosMeshChaosMeshApiV1alpha1PhysicalMachineChaosList = githubComChaosMeshChaosMeshApiV1alpha1PhysicalMachineChaosList;
        this.githubComChaosMeshChaosMeshApiV1alpha1PhysicalMachineChaosSpec = githubComChaosMeshChaosMeshApiV1alpha1PhysicalMachineChaosSpec;
        this.githubComChaosMeshChaosMeshApiV1alpha1PhysicalMachineChaosStatus = githubComChaosMeshChaosMeshApiV1alpha1PhysicalMachineChaosStatus;
        this.githubComChaosMeshChaosMeshApiV1alpha1PhysicalMachineSelectorSpec = githubComChaosMeshChaosMeshApiV1alpha1PhysicalMachineSelectorSpec;
        this.githubComChaosMeshChaosMeshApiV1alpha1PodChaos = githubComChaosMeshChaosMeshApiV1alpha1PodChaos;
        this.githubComChaosMeshChaosMeshApiV1alpha1PodChaosList = githubComChaosMeshChaosMeshApiV1alpha1PodChaosList;
        this.githubComChaosMeshChaosMeshApiV1alpha1PodChaosSpec = githubComChaosMeshChaosMeshApiV1alpha1PodChaosSpec;
        this.githubComChaosMeshChaosMeshApiV1alpha1PodChaosStatus = githubComChaosMeshChaosMeshApiV1alpha1PodChaosStatus;
        this.githubComChaosMeshChaosMeshApiV1alpha1PodHttpChaos = githubComChaosMeshChaosMeshApiV1alpha1PodHttpChaos;
        this.githubComChaosMeshChaosMeshApiV1alpha1PodHttpChaosActions = githubComChaosMeshChaosMeshApiV1alpha1PodHttpChaosActions;
        this.githubComChaosMeshChaosMeshApiV1alpha1PodHttpChaosList = githubComChaosMeshChaosMeshApiV1alpha1PodHttpChaosList;
        this.githubComChaosMeshChaosMeshApiV1alpha1PodHttpChaosPatchActions = githubComChaosMeshChaosMeshApiV1alpha1PodHttpChaosPatchActions;
        this.githubComChaosMeshChaosMeshApiV1alpha1PodHttpChaosPatchBodyAction = githubComChaosMeshChaosMeshApiV1alpha1PodHttpChaosPatchBodyAction;
        this.githubComChaosMeshChaosMeshApiV1alpha1PodHttpChaosReplaceActions = githubComChaosMeshChaosMeshApiV1alpha1PodHttpChaosReplaceActions;
        this.githubComChaosMeshChaosMeshApiV1alpha1PodHttpChaosRule = githubComChaosMeshChaosMeshApiV1alpha1PodHttpChaosRule;
        this.githubComChaosMeshChaosMeshApiV1alpha1PodHttpChaosSelector = githubComChaosMeshChaosMeshApiV1alpha1PodHttpChaosSelector;
        this.githubComChaosMeshChaosMeshApiV1alpha1PodHttpChaosSpec = githubComChaosMeshChaosMeshApiV1alpha1PodHttpChaosSpec;
        this.githubComChaosMeshChaosMeshApiV1alpha1PodHttpChaosStatus = githubComChaosMeshChaosMeshApiV1alpha1PodHttpChaosStatus;
        this.githubComChaosMeshChaosMeshApiV1alpha1PodIOChaos = githubComChaosMeshChaosMeshApiV1alpha1PodIOChaos;
        this.githubComChaosMeshChaosMeshApiV1alpha1PodIOChaosList = githubComChaosMeshChaosMeshApiV1alpha1PodIOChaosList;
        this.githubComChaosMeshChaosMeshApiV1alpha1PodIOChaosSpec = githubComChaosMeshChaosMeshApiV1alpha1PodIOChaosSpec;
        this.githubComChaosMeshChaosMeshApiV1alpha1PodIOChaosStatus = githubComChaosMeshChaosMeshApiV1alpha1PodIOChaosStatus;
        this.githubComChaosMeshChaosMeshApiV1alpha1PodNetworkChaos = githubComChaosMeshChaosMeshApiV1alpha1PodNetworkChaos;
        this.githubComChaosMeshChaosMeshApiV1alpha1PodNetworkChaosList = githubComChaosMeshChaosMeshApiV1alpha1PodNetworkChaosList;
        this.githubComChaosMeshChaosMeshApiV1alpha1PodNetworkChaosSpec = githubComChaosMeshChaosMeshApiV1alpha1PodNetworkChaosSpec;
        this.githubComChaosMeshChaosMeshApiV1alpha1PodNetworkChaosStatus = githubComChaosMeshChaosMeshApiV1alpha1PodNetworkChaosStatus;
        this.githubComChaosMeshChaosMeshApiV1alpha1PodSelector = githubComChaosMeshChaosMeshApiV1alpha1PodSelector;
        this.githubComChaosMeshChaosMeshApiV1alpha1PodSelectorSpec = githubComChaosMeshChaosMeshApiV1alpha1PodSelectorSpec;
        this.githubComChaosMeshChaosMeshApiV1alpha1ProcessSpec = githubComChaosMeshChaosMeshApiV1alpha1ProcessSpec;
        this.githubComChaosMeshChaosMeshApiV1alpha1RawIPSet = githubComChaosMeshChaosMeshApiV1alpha1RawIPSet;
        this.githubComChaosMeshChaosMeshApiV1alpha1RawIptables = githubComChaosMeshChaosMeshApiV1alpha1RawIptables;
        this.githubComChaosMeshChaosMeshApiV1alpha1RawTrafficControl = githubComChaosMeshChaosMeshApiV1alpha1RawTrafficControl;
        this.githubComChaosMeshChaosMeshApiV1alpha1Record = githubComChaosMeshChaosMeshApiV1alpha1Record;
        this.githubComChaosMeshChaosMeshApiV1alpha1ReorderSpec = githubComChaosMeshChaosMeshApiV1alpha1ReorderSpec;
        this.githubComChaosMeshChaosMeshApiV1alpha1StressCPUSpec = githubComChaosMeshChaosMeshApiV1alpha1StressCPUSpec;
        this.githubComChaosMeshChaosMeshApiV1alpha1StressChaos = githubComChaosMeshChaosMeshApiV1alpha1StressChaos;
        this.githubComChaosMeshChaosMeshApiV1alpha1StressChaosList = githubComChaosMeshChaosMeshApiV1alpha1StressChaosList;
        this.githubComChaosMeshChaosMeshApiV1alpha1StressChaosSpec = githubComChaosMeshChaosMeshApiV1alpha1StressChaosSpec;
        this.githubComChaosMeshChaosMeshApiV1alpha1StressChaosStatus = githubComChaosMeshChaosMeshApiV1alpha1StressChaosStatus;
        this.githubComChaosMeshChaosMeshApiV1alpha1StressInstance = githubComChaosMeshChaosMeshApiV1alpha1StressInstance;
        this.githubComChaosMeshChaosMeshApiV1alpha1StressMemorySpec = githubComChaosMeshChaosMeshApiV1alpha1StressMemorySpec;
        this.githubComChaosMeshChaosMeshApiV1alpha1Stressors = githubComChaosMeshChaosMeshApiV1alpha1Stressors;
        this.githubComChaosMeshChaosMeshApiV1alpha1TimeChaos = githubComChaosMeshChaosMeshApiV1alpha1TimeChaos;
        this.githubComChaosMeshChaosMeshApiV1alpha1TimeChaosList = githubComChaosMeshChaosMeshApiV1alpha1TimeChaosList;
        this.githubComChaosMeshChaosMeshApiV1alpha1TimeChaosSpec = githubComChaosMeshChaosMeshApiV1alpha1TimeChaosSpec;
        this.githubComChaosMeshChaosMeshApiV1alpha1TimeChaosStatus = githubComChaosMeshChaosMeshApiV1alpha1TimeChaosStatus;
        this.githubComChaosMeshChaosMeshApiV1alpha1Timespec = githubComChaosMeshChaosMeshApiV1alpha1Timespec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_AWSChaos")
    public AWSChaos getGithubComChaosMeshChaosMeshApiV1alpha1AWSChaos() {
        return githubComChaosMeshChaosMeshApiV1alpha1AWSChaos;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_AWSChaos")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1AWSChaos(AWSChaos githubComChaosMeshChaosMeshApiV1alpha1AWSChaos) {
        this.githubComChaosMeshChaosMeshApiV1alpha1AWSChaos = githubComChaosMeshChaosMeshApiV1alpha1AWSChaos;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_AWSChaosList")
    public AWSChaosList getGithubComChaosMeshChaosMeshApiV1alpha1AWSChaosList() {
        return githubComChaosMeshChaosMeshApiV1alpha1AWSChaosList;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_AWSChaosList")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1AWSChaosList(AWSChaosList githubComChaosMeshChaosMeshApiV1alpha1AWSChaosList) {
        this.githubComChaosMeshChaosMeshApiV1alpha1AWSChaosList = githubComChaosMeshChaosMeshApiV1alpha1AWSChaosList;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_AWSChaosSpec")
    public AWSChaosSpec getGithubComChaosMeshChaosMeshApiV1alpha1AWSChaosSpec() {
        return githubComChaosMeshChaosMeshApiV1alpha1AWSChaosSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_AWSChaosSpec")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1AWSChaosSpec(AWSChaosSpec githubComChaosMeshChaosMeshApiV1alpha1AWSChaosSpec) {
        this.githubComChaosMeshChaosMeshApiV1alpha1AWSChaosSpec = githubComChaosMeshChaosMeshApiV1alpha1AWSChaosSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_AWSChaosStatus")
    public AWSChaosStatus getGithubComChaosMeshChaosMeshApiV1alpha1AWSChaosStatus() {
        return githubComChaosMeshChaosMeshApiV1alpha1AWSChaosStatus;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_AWSChaosStatus")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1AWSChaosStatus(AWSChaosStatus githubComChaosMeshChaosMeshApiV1alpha1AWSChaosStatus) {
        this.githubComChaosMeshChaosMeshApiV1alpha1AWSChaosStatus = githubComChaosMeshChaosMeshApiV1alpha1AWSChaosStatus;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_AttrOverrideSpec")
    public AttrOverrideSpec getGithubComChaosMeshChaosMeshApiV1alpha1AttrOverrideSpec() {
        return githubComChaosMeshChaosMeshApiV1alpha1AttrOverrideSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_AttrOverrideSpec")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1AttrOverrideSpec(AttrOverrideSpec githubComChaosMeshChaosMeshApiV1alpha1AttrOverrideSpec) {
        this.githubComChaosMeshChaosMeshApiV1alpha1AttrOverrideSpec = githubComChaosMeshChaosMeshApiV1alpha1AttrOverrideSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_BandwidthSpec")
    public BandwidthSpec getGithubComChaosMeshChaosMeshApiV1alpha1BandwidthSpec() {
        return githubComChaosMeshChaosMeshApiV1alpha1BandwidthSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_BandwidthSpec")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1BandwidthSpec(BandwidthSpec githubComChaosMeshChaosMeshApiV1alpha1BandwidthSpec) {
        this.githubComChaosMeshChaosMeshApiV1alpha1BandwidthSpec = githubComChaosMeshChaosMeshApiV1alpha1BandwidthSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_BlockChaos")
    public BlockChaos getGithubComChaosMeshChaosMeshApiV1alpha1BlockChaos() {
        return githubComChaosMeshChaosMeshApiV1alpha1BlockChaos;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_BlockChaos")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1BlockChaos(BlockChaos githubComChaosMeshChaosMeshApiV1alpha1BlockChaos) {
        this.githubComChaosMeshChaosMeshApiV1alpha1BlockChaos = githubComChaosMeshChaosMeshApiV1alpha1BlockChaos;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_BlockChaosList")
    public BlockChaosList getGithubComChaosMeshChaosMeshApiV1alpha1BlockChaosList() {
        return githubComChaosMeshChaosMeshApiV1alpha1BlockChaosList;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_BlockChaosList")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1BlockChaosList(BlockChaosList githubComChaosMeshChaosMeshApiV1alpha1BlockChaosList) {
        this.githubComChaosMeshChaosMeshApiV1alpha1BlockChaosList = githubComChaosMeshChaosMeshApiV1alpha1BlockChaosList;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_BlockChaosSpec")
    public BlockChaosSpec getGithubComChaosMeshChaosMeshApiV1alpha1BlockChaosSpec() {
        return githubComChaosMeshChaosMeshApiV1alpha1BlockChaosSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_BlockChaosSpec")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1BlockChaosSpec(BlockChaosSpec githubComChaosMeshChaosMeshApiV1alpha1BlockChaosSpec) {
        this.githubComChaosMeshChaosMeshApiV1alpha1BlockChaosSpec = githubComChaosMeshChaosMeshApiV1alpha1BlockChaosSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_BlockChaosStatus")
    public BlockChaosStatus getGithubComChaosMeshChaosMeshApiV1alpha1BlockChaosStatus() {
        return githubComChaosMeshChaosMeshApiV1alpha1BlockChaosStatus;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_BlockChaosStatus")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1BlockChaosStatus(BlockChaosStatus githubComChaosMeshChaosMeshApiV1alpha1BlockChaosStatus) {
        this.githubComChaosMeshChaosMeshApiV1alpha1BlockChaosStatus = githubComChaosMeshChaosMeshApiV1alpha1BlockChaosStatus;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_BlockDelaySpec")
    public BlockDelaySpec getGithubComChaosMeshChaosMeshApiV1alpha1BlockDelaySpec() {
        return githubComChaosMeshChaosMeshApiV1alpha1BlockDelaySpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_BlockDelaySpec")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1BlockDelaySpec(BlockDelaySpec githubComChaosMeshChaosMeshApiV1alpha1BlockDelaySpec) {
        this.githubComChaosMeshChaosMeshApiV1alpha1BlockDelaySpec = githubComChaosMeshChaosMeshApiV1alpha1BlockDelaySpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_CPUStressor")
    public CPUStressor getGithubComChaosMeshChaosMeshApiV1alpha1CPUStressor() {
        return githubComChaosMeshChaosMeshApiV1alpha1CPUStressor;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_CPUStressor")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1CPUStressor(CPUStressor githubComChaosMeshChaosMeshApiV1alpha1CPUStressor) {
        this.githubComChaosMeshChaosMeshApiV1alpha1CPUStressor = githubComChaosMeshChaosMeshApiV1alpha1CPUStressor;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_ChaosCondition")
    public ChaosCondition getGithubComChaosMeshChaosMeshApiV1alpha1ChaosCondition() {
        return githubComChaosMeshChaosMeshApiV1alpha1ChaosCondition;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_ChaosCondition")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1ChaosCondition(ChaosCondition githubComChaosMeshChaosMeshApiV1alpha1ChaosCondition) {
        this.githubComChaosMeshChaosMeshApiV1alpha1ChaosCondition = githubComChaosMeshChaosMeshApiV1alpha1ChaosCondition;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_ClockSpec")
    public ClockSpec getGithubComChaosMeshChaosMeshApiV1alpha1ClockSpec() {
        return githubComChaosMeshChaosMeshApiV1alpha1ClockSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_ClockSpec")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1ClockSpec(ClockSpec githubComChaosMeshChaosMeshApiV1alpha1ClockSpec) {
        this.githubComChaosMeshChaosMeshApiV1alpha1ClockSpec = githubComChaosMeshChaosMeshApiV1alpha1ClockSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_CorruptSpec")
    public CorruptSpec getGithubComChaosMeshChaosMeshApiV1alpha1CorruptSpec() {
        return githubComChaosMeshChaosMeshApiV1alpha1CorruptSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_CorruptSpec")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1CorruptSpec(CorruptSpec githubComChaosMeshChaosMeshApiV1alpha1CorruptSpec) {
        this.githubComChaosMeshChaosMeshApiV1alpha1CorruptSpec = githubComChaosMeshChaosMeshApiV1alpha1CorruptSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_DNSChaos")
    public DNSChaos getGithubComChaosMeshChaosMeshApiV1alpha1DNSChaos() {
        return githubComChaosMeshChaosMeshApiV1alpha1DNSChaos;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_DNSChaos")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1DNSChaos(DNSChaos githubComChaosMeshChaosMeshApiV1alpha1DNSChaos) {
        this.githubComChaosMeshChaosMeshApiV1alpha1DNSChaos = githubComChaosMeshChaosMeshApiV1alpha1DNSChaos;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_DNSChaosList")
    public DNSChaosList getGithubComChaosMeshChaosMeshApiV1alpha1DNSChaosList() {
        return githubComChaosMeshChaosMeshApiV1alpha1DNSChaosList;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_DNSChaosList")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1DNSChaosList(DNSChaosList githubComChaosMeshChaosMeshApiV1alpha1DNSChaosList) {
        this.githubComChaosMeshChaosMeshApiV1alpha1DNSChaosList = githubComChaosMeshChaosMeshApiV1alpha1DNSChaosList;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_DNSChaosSpec")
    public DNSChaosSpec getGithubComChaosMeshChaosMeshApiV1alpha1DNSChaosSpec() {
        return githubComChaosMeshChaosMeshApiV1alpha1DNSChaosSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_DNSChaosSpec")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1DNSChaosSpec(DNSChaosSpec githubComChaosMeshChaosMeshApiV1alpha1DNSChaosSpec) {
        this.githubComChaosMeshChaosMeshApiV1alpha1DNSChaosSpec = githubComChaosMeshChaosMeshApiV1alpha1DNSChaosSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_DNSChaosStatus")
    public DNSChaosStatus getGithubComChaosMeshChaosMeshApiV1alpha1DNSChaosStatus() {
        return githubComChaosMeshChaosMeshApiV1alpha1DNSChaosStatus;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_DNSChaosStatus")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1DNSChaosStatus(DNSChaosStatus githubComChaosMeshChaosMeshApiV1alpha1DNSChaosStatus) {
        this.githubComChaosMeshChaosMeshApiV1alpha1DNSChaosStatus = githubComChaosMeshChaosMeshApiV1alpha1DNSChaosStatus;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_DelaySpec")
    public DelaySpec getGithubComChaosMeshChaosMeshApiV1alpha1DelaySpec() {
        return githubComChaosMeshChaosMeshApiV1alpha1DelaySpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_DelaySpec")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1DelaySpec(DelaySpec githubComChaosMeshChaosMeshApiV1alpha1DelaySpec) {
        this.githubComChaosMeshChaosMeshApiV1alpha1DelaySpec = githubComChaosMeshChaosMeshApiV1alpha1DelaySpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_DiskFillSpec")
    public DiskFillSpec getGithubComChaosMeshChaosMeshApiV1alpha1DiskFillSpec() {
        return githubComChaosMeshChaosMeshApiV1alpha1DiskFillSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_DiskFillSpec")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1DiskFillSpec(DiskFillSpec githubComChaosMeshChaosMeshApiV1alpha1DiskFillSpec) {
        this.githubComChaosMeshChaosMeshApiV1alpha1DiskFillSpec = githubComChaosMeshChaosMeshApiV1alpha1DiskFillSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_DiskPayloadSpec")
    public DiskPayloadSpec getGithubComChaosMeshChaosMeshApiV1alpha1DiskPayloadSpec() {
        return githubComChaosMeshChaosMeshApiV1alpha1DiskPayloadSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_DiskPayloadSpec")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1DiskPayloadSpec(DiskPayloadSpec githubComChaosMeshChaosMeshApiV1alpha1DiskPayloadSpec) {
        this.githubComChaosMeshChaosMeshApiV1alpha1DiskPayloadSpec = githubComChaosMeshChaosMeshApiV1alpha1DiskPayloadSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_DuplicateSpec")
    public DuplicateSpec getGithubComChaosMeshChaosMeshApiV1alpha1DuplicateSpec() {
        return githubComChaosMeshChaosMeshApiV1alpha1DuplicateSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_DuplicateSpec")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1DuplicateSpec(DuplicateSpec githubComChaosMeshChaosMeshApiV1alpha1DuplicateSpec) {
        this.githubComChaosMeshChaosMeshApiV1alpha1DuplicateSpec = githubComChaosMeshChaosMeshApiV1alpha1DuplicateSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_ExperimentStatus")
    public ExperimentStatus getGithubComChaosMeshChaosMeshApiV1alpha1ExperimentStatus() {
        return githubComChaosMeshChaosMeshApiV1alpha1ExperimentStatus;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_ExperimentStatus")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1ExperimentStatus(ExperimentStatus githubComChaosMeshChaosMeshApiV1alpha1ExperimentStatus) {
        this.githubComChaosMeshChaosMeshApiV1alpha1ExperimentStatus = githubComChaosMeshChaosMeshApiV1alpha1ExperimentStatus;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_FailKernRequest")
    public FailKernRequest getGithubComChaosMeshChaosMeshApiV1alpha1FailKernRequest() {
        return githubComChaosMeshChaosMeshApiV1alpha1FailKernRequest;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_FailKernRequest")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1FailKernRequest(FailKernRequest githubComChaosMeshChaosMeshApiV1alpha1FailKernRequest) {
        this.githubComChaosMeshChaosMeshApiV1alpha1FailKernRequest = githubComChaosMeshChaosMeshApiV1alpha1FailKernRequest;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_Frame")
    public Frame getGithubComChaosMeshChaosMeshApiV1alpha1Frame() {
        return githubComChaosMeshChaosMeshApiV1alpha1Frame;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_Frame")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1Frame(Frame githubComChaosMeshChaosMeshApiV1alpha1Frame) {
        this.githubComChaosMeshChaosMeshApiV1alpha1Frame = githubComChaosMeshChaosMeshApiV1alpha1Frame;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_GCPChaos")
    public GCPChaos getGithubComChaosMeshChaosMeshApiV1alpha1GCPChaos() {
        return githubComChaosMeshChaosMeshApiV1alpha1GCPChaos;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_GCPChaos")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1GCPChaos(GCPChaos githubComChaosMeshChaosMeshApiV1alpha1GCPChaos) {
        this.githubComChaosMeshChaosMeshApiV1alpha1GCPChaos = githubComChaosMeshChaosMeshApiV1alpha1GCPChaos;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_GCPChaosList")
    public GCPChaosList getGithubComChaosMeshChaosMeshApiV1alpha1GCPChaosList() {
        return githubComChaosMeshChaosMeshApiV1alpha1GCPChaosList;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_GCPChaosList")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1GCPChaosList(GCPChaosList githubComChaosMeshChaosMeshApiV1alpha1GCPChaosList) {
        this.githubComChaosMeshChaosMeshApiV1alpha1GCPChaosList = githubComChaosMeshChaosMeshApiV1alpha1GCPChaosList;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_GCPChaosSpec")
    public GCPChaosSpec getGithubComChaosMeshChaosMeshApiV1alpha1GCPChaosSpec() {
        return githubComChaosMeshChaosMeshApiV1alpha1GCPChaosSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_GCPChaosSpec")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1GCPChaosSpec(GCPChaosSpec githubComChaosMeshChaosMeshApiV1alpha1GCPChaosSpec) {
        this.githubComChaosMeshChaosMeshApiV1alpha1GCPChaosSpec = githubComChaosMeshChaosMeshApiV1alpha1GCPChaosSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_GCPChaosStatus")
    public GCPChaosStatus getGithubComChaosMeshChaosMeshApiV1alpha1GCPChaosStatus() {
        return githubComChaosMeshChaosMeshApiV1alpha1GCPChaosStatus;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_GCPChaosStatus")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1GCPChaosStatus(GCPChaosStatus githubComChaosMeshChaosMeshApiV1alpha1GCPChaosStatus) {
        this.githubComChaosMeshChaosMeshApiV1alpha1GCPChaosStatus = githubComChaosMeshChaosMeshApiV1alpha1GCPChaosStatus;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_HTTPChaos")
    public HTTPChaos getGithubComChaosMeshChaosMeshApiV1alpha1HTTPChaos() {
        return githubComChaosMeshChaosMeshApiV1alpha1HTTPChaos;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_HTTPChaos")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1HTTPChaos(HTTPChaos githubComChaosMeshChaosMeshApiV1alpha1HTTPChaos) {
        this.githubComChaosMeshChaosMeshApiV1alpha1HTTPChaos = githubComChaosMeshChaosMeshApiV1alpha1HTTPChaos;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_HTTPChaosList")
    public HTTPChaosList getGithubComChaosMeshChaosMeshApiV1alpha1HTTPChaosList() {
        return githubComChaosMeshChaosMeshApiV1alpha1HTTPChaosList;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_HTTPChaosList")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1HTTPChaosList(HTTPChaosList githubComChaosMeshChaosMeshApiV1alpha1HTTPChaosList) {
        this.githubComChaosMeshChaosMeshApiV1alpha1HTTPChaosList = githubComChaosMeshChaosMeshApiV1alpha1HTTPChaosList;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_HTTPChaosSpec")
    public HTTPChaosSpec getGithubComChaosMeshChaosMeshApiV1alpha1HTTPChaosSpec() {
        return githubComChaosMeshChaosMeshApiV1alpha1HTTPChaosSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_HTTPChaosSpec")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1HTTPChaosSpec(HTTPChaosSpec githubComChaosMeshChaosMeshApiV1alpha1HTTPChaosSpec) {
        this.githubComChaosMeshChaosMeshApiV1alpha1HTTPChaosSpec = githubComChaosMeshChaosMeshApiV1alpha1HTTPChaosSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_HTTPChaosStatus")
    public HTTPChaosStatus getGithubComChaosMeshChaosMeshApiV1alpha1HTTPChaosStatus() {
        return githubComChaosMeshChaosMeshApiV1alpha1HTTPChaosStatus;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_HTTPChaosStatus")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1HTTPChaosStatus(HTTPChaosStatus githubComChaosMeshChaosMeshApiV1alpha1HTTPChaosStatus) {
        this.githubComChaosMeshChaosMeshApiV1alpha1HTTPChaosStatus = githubComChaosMeshChaosMeshApiV1alpha1HTTPChaosStatus;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_IOChaos")
    public IOChaos getGithubComChaosMeshChaosMeshApiV1alpha1IOChaos() {
        return githubComChaosMeshChaosMeshApiV1alpha1IOChaos;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_IOChaos")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1IOChaos(IOChaos githubComChaosMeshChaosMeshApiV1alpha1IOChaos) {
        this.githubComChaosMeshChaosMeshApiV1alpha1IOChaos = githubComChaosMeshChaosMeshApiV1alpha1IOChaos;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_IOChaosAction")
    public IOChaosAction getGithubComChaosMeshChaosMeshApiV1alpha1IOChaosAction() {
        return githubComChaosMeshChaosMeshApiV1alpha1IOChaosAction;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_IOChaosAction")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1IOChaosAction(IOChaosAction githubComChaosMeshChaosMeshApiV1alpha1IOChaosAction) {
        this.githubComChaosMeshChaosMeshApiV1alpha1IOChaosAction = githubComChaosMeshChaosMeshApiV1alpha1IOChaosAction;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_IOChaosList")
    public IOChaosList getGithubComChaosMeshChaosMeshApiV1alpha1IOChaosList() {
        return githubComChaosMeshChaosMeshApiV1alpha1IOChaosList;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_IOChaosList")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1IOChaosList(IOChaosList githubComChaosMeshChaosMeshApiV1alpha1IOChaosList) {
        this.githubComChaosMeshChaosMeshApiV1alpha1IOChaosList = githubComChaosMeshChaosMeshApiV1alpha1IOChaosList;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_IOChaosSpec")
    public IOChaosSpec getGithubComChaosMeshChaosMeshApiV1alpha1IOChaosSpec() {
        return githubComChaosMeshChaosMeshApiV1alpha1IOChaosSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_IOChaosSpec")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1IOChaosSpec(IOChaosSpec githubComChaosMeshChaosMeshApiV1alpha1IOChaosSpec) {
        this.githubComChaosMeshChaosMeshApiV1alpha1IOChaosSpec = githubComChaosMeshChaosMeshApiV1alpha1IOChaosSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_IOChaosStatus")
    public IOChaosStatus getGithubComChaosMeshChaosMeshApiV1alpha1IOChaosStatus() {
        return githubComChaosMeshChaosMeshApiV1alpha1IOChaosStatus;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_IOChaosStatus")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1IOChaosStatus(IOChaosStatus githubComChaosMeshChaosMeshApiV1alpha1IOChaosStatus) {
        this.githubComChaosMeshChaosMeshApiV1alpha1IOChaosStatus = githubComChaosMeshChaosMeshApiV1alpha1IOChaosStatus;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_IoFault")
    public IoFault getGithubComChaosMeshChaosMeshApiV1alpha1IoFault() {
        return githubComChaosMeshChaosMeshApiV1alpha1IoFault;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_IoFault")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1IoFault(IoFault githubComChaosMeshChaosMeshApiV1alpha1IoFault) {
        this.githubComChaosMeshChaosMeshApiV1alpha1IoFault = githubComChaosMeshChaosMeshApiV1alpha1IoFault;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_JVMChaos")
    public JVMChaos getGithubComChaosMeshChaosMeshApiV1alpha1JVMChaos() {
        return githubComChaosMeshChaosMeshApiV1alpha1JVMChaos;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_JVMChaos")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1JVMChaos(JVMChaos githubComChaosMeshChaosMeshApiV1alpha1JVMChaos) {
        this.githubComChaosMeshChaosMeshApiV1alpha1JVMChaos = githubComChaosMeshChaosMeshApiV1alpha1JVMChaos;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_JVMChaosList")
    public JVMChaosList getGithubComChaosMeshChaosMeshApiV1alpha1JVMChaosList() {
        return githubComChaosMeshChaosMeshApiV1alpha1JVMChaosList;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_JVMChaosList")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1JVMChaosList(JVMChaosList githubComChaosMeshChaosMeshApiV1alpha1JVMChaosList) {
        this.githubComChaosMeshChaosMeshApiV1alpha1JVMChaosList = githubComChaosMeshChaosMeshApiV1alpha1JVMChaosList;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_JVMChaosSpec")
    public JVMChaosSpec getGithubComChaosMeshChaosMeshApiV1alpha1JVMChaosSpec() {
        return githubComChaosMeshChaosMeshApiV1alpha1JVMChaosSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_JVMChaosSpec")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1JVMChaosSpec(JVMChaosSpec githubComChaosMeshChaosMeshApiV1alpha1JVMChaosSpec) {
        this.githubComChaosMeshChaosMeshApiV1alpha1JVMChaosSpec = githubComChaosMeshChaosMeshApiV1alpha1JVMChaosSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_JVMChaosStatus")
    public JVMChaosStatus getGithubComChaosMeshChaosMeshApiV1alpha1JVMChaosStatus() {
        return githubComChaosMeshChaosMeshApiV1alpha1JVMChaosStatus;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_JVMChaosStatus")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1JVMChaosStatus(JVMChaosStatus githubComChaosMeshChaosMeshApiV1alpha1JVMChaosStatus) {
        this.githubComChaosMeshChaosMeshApiV1alpha1JVMChaosStatus = githubComChaosMeshChaosMeshApiV1alpha1JVMChaosStatus;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_JVMExceptionSpec")
    public JVMExceptionSpec getGithubComChaosMeshChaosMeshApiV1alpha1JVMExceptionSpec() {
        return githubComChaosMeshChaosMeshApiV1alpha1JVMExceptionSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_JVMExceptionSpec")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1JVMExceptionSpec(JVMExceptionSpec githubComChaosMeshChaosMeshApiV1alpha1JVMExceptionSpec) {
        this.githubComChaosMeshChaosMeshApiV1alpha1JVMExceptionSpec = githubComChaosMeshChaosMeshApiV1alpha1JVMExceptionSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_JVMGCSpec")
    public JVMGCSpec getGithubComChaosMeshChaosMeshApiV1alpha1JVMGCSpec() {
        return githubComChaosMeshChaosMeshApiV1alpha1JVMGCSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_JVMGCSpec")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1JVMGCSpec(JVMGCSpec githubComChaosMeshChaosMeshApiV1alpha1JVMGCSpec) {
        this.githubComChaosMeshChaosMeshApiV1alpha1JVMGCSpec = githubComChaosMeshChaosMeshApiV1alpha1JVMGCSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_JVMLatencySpec")
    public JVMLatencySpec getGithubComChaosMeshChaosMeshApiV1alpha1JVMLatencySpec() {
        return githubComChaosMeshChaosMeshApiV1alpha1JVMLatencySpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_JVMLatencySpec")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1JVMLatencySpec(JVMLatencySpec githubComChaosMeshChaosMeshApiV1alpha1JVMLatencySpec) {
        this.githubComChaosMeshChaosMeshApiV1alpha1JVMLatencySpec = githubComChaosMeshChaosMeshApiV1alpha1JVMLatencySpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_JVMReturnSpec")
    public JVMReturnSpec getGithubComChaosMeshChaosMeshApiV1alpha1JVMReturnSpec() {
        return githubComChaosMeshChaosMeshApiV1alpha1JVMReturnSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_JVMReturnSpec")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1JVMReturnSpec(JVMReturnSpec githubComChaosMeshChaosMeshApiV1alpha1JVMReturnSpec) {
        this.githubComChaosMeshChaosMeshApiV1alpha1JVMReturnSpec = githubComChaosMeshChaosMeshApiV1alpha1JVMReturnSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_JVMRuleDataSpec")
    public JVMRuleDataSpec getGithubComChaosMeshChaosMeshApiV1alpha1JVMRuleDataSpec() {
        return githubComChaosMeshChaosMeshApiV1alpha1JVMRuleDataSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_JVMRuleDataSpec")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1JVMRuleDataSpec(JVMRuleDataSpec githubComChaosMeshChaosMeshApiV1alpha1JVMRuleDataSpec) {
        this.githubComChaosMeshChaosMeshApiV1alpha1JVMRuleDataSpec = githubComChaosMeshChaosMeshApiV1alpha1JVMRuleDataSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_JVMStressSpec")
    public JVMStressSpec getGithubComChaosMeshChaosMeshApiV1alpha1JVMStressSpec() {
        return githubComChaosMeshChaosMeshApiV1alpha1JVMStressSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_JVMStressSpec")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1JVMStressSpec(JVMStressSpec githubComChaosMeshChaosMeshApiV1alpha1JVMStressSpec) {
        this.githubComChaosMeshChaosMeshApiV1alpha1JVMStressSpec = githubComChaosMeshChaosMeshApiV1alpha1JVMStressSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_KernelChaos")
    public KernelChaos getGithubComChaosMeshChaosMeshApiV1alpha1KernelChaos() {
        return githubComChaosMeshChaosMeshApiV1alpha1KernelChaos;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_KernelChaos")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1KernelChaos(KernelChaos githubComChaosMeshChaosMeshApiV1alpha1KernelChaos) {
        this.githubComChaosMeshChaosMeshApiV1alpha1KernelChaos = githubComChaosMeshChaosMeshApiV1alpha1KernelChaos;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_KernelChaosList")
    public KernelChaosList getGithubComChaosMeshChaosMeshApiV1alpha1KernelChaosList() {
        return githubComChaosMeshChaosMeshApiV1alpha1KernelChaosList;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_KernelChaosList")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1KernelChaosList(KernelChaosList githubComChaosMeshChaosMeshApiV1alpha1KernelChaosList) {
        this.githubComChaosMeshChaosMeshApiV1alpha1KernelChaosList = githubComChaosMeshChaosMeshApiV1alpha1KernelChaosList;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_KernelChaosSpec")
    public KernelChaosSpec getGithubComChaosMeshChaosMeshApiV1alpha1KernelChaosSpec() {
        return githubComChaosMeshChaosMeshApiV1alpha1KernelChaosSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_KernelChaosSpec")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1KernelChaosSpec(KernelChaosSpec githubComChaosMeshChaosMeshApiV1alpha1KernelChaosSpec) {
        this.githubComChaosMeshChaosMeshApiV1alpha1KernelChaosSpec = githubComChaosMeshChaosMeshApiV1alpha1KernelChaosSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_KernelChaosStatus")
    public KernelChaosStatus getGithubComChaosMeshChaosMeshApiV1alpha1KernelChaosStatus() {
        return githubComChaosMeshChaosMeshApiV1alpha1KernelChaosStatus;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_KernelChaosStatus")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1KernelChaosStatus(KernelChaosStatus githubComChaosMeshChaosMeshApiV1alpha1KernelChaosStatus) {
        this.githubComChaosMeshChaosMeshApiV1alpha1KernelChaosStatus = githubComChaosMeshChaosMeshApiV1alpha1KernelChaosStatus;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_LossSpec")
    public LossSpec getGithubComChaosMeshChaosMeshApiV1alpha1LossSpec() {
        return githubComChaosMeshChaosMeshApiV1alpha1LossSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_LossSpec")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1LossSpec(LossSpec githubComChaosMeshChaosMeshApiV1alpha1LossSpec) {
        this.githubComChaosMeshChaosMeshApiV1alpha1LossSpec = githubComChaosMeshChaosMeshApiV1alpha1LossSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_MemoryStressor")
    public MemoryStressor getGithubComChaosMeshChaosMeshApiV1alpha1MemoryStressor() {
        return githubComChaosMeshChaosMeshApiV1alpha1MemoryStressor;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_MemoryStressor")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1MemoryStressor(MemoryStressor githubComChaosMeshChaosMeshApiV1alpha1MemoryStressor) {
        this.githubComChaosMeshChaosMeshApiV1alpha1MemoryStressor = githubComChaosMeshChaosMeshApiV1alpha1MemoryStressor;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_MistakeSpec")
    public MistakeSpec getGithubComChaosMeshChaosMeshApiV1alpha1MistakeSpec() {
        return githubComChaosMeshChaosMeshApiV1alpha1MistakeSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_MistakeSpec")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1MistakeSpec(MistakeSpec githubComChaosMeshChaosMeshApiV1alpha1MistakeSpec) {
        this.githubComChaosMeshChaosMeshApiV1alpha1MistakeSpec = githubComChaosMeshChaosMeshApiV1alpha1MistakeSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_NetworkBandwidthSpec")
    public NetworkBandwidthSpec getGithubComChaosMeshChaosMeshApiV1alpha1NetworkBandwidthSpec() {
        return githubComChaosMeshChaosMeshApiV1alpha1NetworkBandwidthSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_NetworkBandwidthSpec")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1NetworkBandwidthSpec(NetworkBandwidthSpec githubComChaosMeshChaosMeshApiV1alpha1NetworkBandwidthSpec) {
        this.githubComChaosMeshChaosMeshApiV1alpha1NetworkBandwidthSpec = githubComChaosMeshChaosMeshApiV1alpha1NetworkBandwidthSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_NetworkChaos")
    public NetworkChaos getGithubComChaosMeshChaosMeshApiV1alpha1NetworkChaos() {
        return githubComChaosMeshChaosMeshApiV1alpha1NetworkChaos;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_NetworkChaos")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1NetworkChaos(NetworkChaos githubComChaosMeshChaosMeshApiV1alpha1NetworkChaos) {
        this.githubComChaosMeshChaosMeshApiV1alpha1NetworkChaos = githubComChaosMeshChaosMeshApiV1alpha1NetworkChaos;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_NetworkChaosList")
    public NetworkChaosList getGithubComChaosMeshChaosMeshApiV1alpha1NetworkChaosList() {
        return githubComChaosMeshChaosMeshApiV1alpha1NetworkChaosList;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_NetworkChaosList")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1NetworkChaosList(NetworkChaosList githubComChaosMeshChaosMeshApiV1alpha1NetworkChaosList) {
        this.githubComChaosMeshChaosMeshApiV1alpha1NetworkChaosList = githubComChaosMeshChaosMeshApiV1alpha1NetworkChaosList;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_NetworkChaosSpec")
    public NetworkChaosSpec getGithubComChaosMeshChaosMeshApiV1alpha1NetworkChaosSpec() {
        return githubComChaosMeshChaosMeshApiV1alpha1NetworkChaosSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_NetworkChaosSpec")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1NetworkChaosSpec(NetworkChaosSpec githubComChaosMeshChaosMeshApiV1alpha1NetworkChaosSpec) {
        this.githubComChaosMeshChaosMeshApiV1alpha1NetworkChaosSpec = githubComChaosMeshChaosMeshApiV1alpha1NetworkChaosSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_NetworkChaosStatus")
    public NetworkChaosStatus getGithubComChaosMeshChaosMeshApiV1alpha1NetworkChaosStatus() {
        return githubComChaosMeshChaosMeshApiV1alpha1NetworkChaosStatus;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_NetworkChaosStatus")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1NetworkChaosStatus(NetworkChaosStatus githubComChaosMeshChaosMeshApiV1alpha1NetworkChaosStatus) {
        this.githubComChaosMeshChaosMeshApiV1alpha1NetworkChaosStatus = githubComChaosMeshChaosMeshApiV1alpha1NetworkChaosStatus;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_NetworkCorruptSpec")
    public NetworkCorruptSpec getGithubComChaosMeshChaosMeshApiV1alpha1NetworkCorruptSpec() {
        return githubComChaosMeshChaosMeshApiV1alpha1NetworkCorruptSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_NetworkCorruptSpec")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1NetworkCorruptSpec(NetworkCorruptSpec githubComChaosMeshChaosMeshApiV1alpha1NetworkCorruptSpec) {
        this.githubComChaosMeshChaosMeshApiV1alpha1NetworkCorruptSpec = githubComChaosMeshChaosMeshApiV1alpha1NetworkCorruptSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_NetworkDNSSpec")
    public NetworkDNSSpec getGithubComChaosMeshChaosMeshApiV1alpha1NetworkDNSSpec() {
        return githubComChaosMeshChaosMeshApiV1alpha1NetworkDNSSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_NetworkDNSSpec")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1NetworkDNSSpec(NetworkDNSSpec githubComChaosMeshChaosMeshApiV1alpha1NetworkDNSSpec) {
        this.githubComChaosMeshChaosMeshApiV1alpha1NetworkDNSSpec = githubComChaosMeshChaosMeshApiV1alpha1NetworkDNSSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_NetworkDelaySpec")
    public NetworkDelaySpec getGithubComChaosMeshChaosMeshApiV1alpha1NetworkDelaySpec() {
        return githubComChaosMeshChaosMeshApiV1alpha1NetworkDelaySpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_NetworkDelaySpec")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1NetworkDelaySpec(NetworkDelaySpec githubComChaosMeshChaosMeshApiV1alpha1NetworkDelaySpec) {
        this.githubComChaosMeshChaosMeshApiV1alpha1NetworkDelaySpec = githubComChaosMeshChaosMeshApiV1alpha1NetworkDelaySpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_NetworkDuplicateSpec")
    public NetworkDuplicateSpec getGithubComChaosMeshChaosMeshApiV1alpha1NetworkDuplicateSpec() {
        return githubComChaosMeshChaosMeshApiV1alpha1NetworkDuplicateSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_NetworkDuplicateSpec")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1NetworkDuplicateSpec(NetworkDuplicateSpec githubComChaosMeshChaosMeshApiV1alpha1NetworkDuplicateSpec) {
        this.githubComChaosMeshChaosMeshApiV1alpha1NetworkDuplicateSpec = githubComChaosMeshChaosMeshApiV1alpha1NetworkDuplicateSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_NetworkLossSpec")
    public NetworkLossSpec getGithubComChaosMeshChaosMeshApiV1alpha1NetworkLossSpec() {
        return githubComChaosMeshChaosMeshApiV1alpha1NetworkLossSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_NetworkLossSpec")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1NetworkLossSpec(NetworkLossSpec githubComChaosMeshChaosMeshApiV1alpha1NetworkLossSpec) {
        this.githubComChaosMeshChaosMeshApiV1alpha1NetworkLossSpec = githubComChaosMeshChaosMeshApiV1alpha1NetworkLossSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_NetworkPartitionSpec")
    public NetworkPartitionSpec getGithubComChaosMeshChaosMeshApiV1alpha1NetworkPartitionSpec() {
        return githubComChaosMeshChaosMeshApiV1alpha1NetworkPartitionSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_NetworkPartitionSpec")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1NetworkPartitionSpec(NetworkPartitionSpec githubComChaosMeshChaosMeshApiV1alpha1NetworkPartitionSpec) {
        this.githubComChaosMeshChaosMeshApiV1alpha1NetworkPartitionSpec = githubComChaosMeshChaosMeshApiV1alpha1NetworkPartitionSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PhysicalMachineChaos")
    public PhysicalMachineChaos getGithubComChaosMeshChaosMeshApiV1alpha1PhysicalMachineChaos() {
        return githubComChaosMeshChaosMeshApiV1alpha1PhysicalMachineChaos;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PhysicalMachineChaos")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1PhysicalMachineChaos(PhysicalMachineChaos githubComChaosMeshChaosMeshApiV1alpha1PhysicalMachineChaos) {
        this.githubComChaosMeshChaosMeshApiV1alpha1PhysicalMachineChaos = githubComChaosMeshChaosMeshApiV1alpha1PhysicalMachineChaos;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PhysicalMachineChaosList")
    public PhysicalMachineChaosList getGithubComChaosMeshChaosMeshApiV1alpha1PhysicalMachineChaosList() {
        return githubComChaosMeshChaosMeshApiV1alpha1PhysicalMachineChaosList;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PhysicalMachineChaosList")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1PhysicalMachineChaosList(PhysicalMachineChaosList githubComChaosMeshChaosMeshApiV1alpha1PhysicalMachineChaosList) {
        this.githubComChaosMeshChaosMeshApiV1alpha1PhysicalMachineChaosList = githubComChaosMeshChaosMeshApiV1alpha1PhysicalMachineChaosList;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PhysicalMachineChaosSpec")
    public PhysicalMachineChaosSpec getGithubComChaosMeshChaosMeshApiV1alpha1PhysicalMachineChaosSpec() {
        return githubComChaosMeshChaosMeshApiV1alpha1PhysicalMachineChaosSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PhysicalMachineChaosSpec")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1PhysicalMachineChaosSpec(PhysicalMachineChaosSpec githubComChaosMeshChaosMeshApiV1alpha1PhysicalMachineChaosSpec) {
        this.githubComChaosMeshChaosMeshApiV1alpha1PhysicalMachineChaosSpec = githubComChaosMeshChaosMeshApiV1alpha1PhysicalMachineChaosSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PhysicalMachineChaosStatus")
    public PhysicalMachineChaosStatus getGithubComChaosMeshChaosMeshApiV1alpha1PhysicalMachineChaosStatus() {
        return githubComChaosMeshChaosMeshApiV1alpha1PhysicalMachineChaosStatus;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PhysicalMachineChaosStatus")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1PhysicalMachineChaosStatus(PhysicalMachineChaosStatus githubComChaosMeshChaosMeshApiV1alpha1PhysicalMachineChaosStatus) {
        this.githubComChaosMeshChaosMeshApiV1alpha1PhysicalMachineChaosStatus = githubComChaosMeshChaosMeshApiV1alpha1PhysicalMachineChaosStatus;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PhysicalMachineSelectorSpec")
    public PhysicalMachineSelectorSpec getGithubComChaosMeshChaosMeshApiV1alpha1PhysicalMachineSelectorSpec() {
        return githubComChaosMeshChaosMeshApiV1alpha1PhysicalMachineSelectorSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PhysicalMachineSelectorSpec")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1PhysicalMachineSelectorSpec(PhysicalMachineSelectorSpec githubComChaosMeshChaosMeshApiV1alpha1PhysicalMachineSelectorSpec) {
        this.githubComChaosMeshChaosMeshApiV1alpha1PhysicalMachineSelectorSpec = githubComChaosMeshChaosMeshApiV1alpha1PhysicalMachineSelectorSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodChaos")
    public PodChaos getGithubComChaosMeshChaosMeshApiV1alpha1PodChaos() {
        return githubComChaosMeshChaosMeshApiV1alpha1PodChaos;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodChaos")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1PodChaos(PodChaos githubComChaosMeshChaosMeshApiV1alpha1PodChaos) {
        this.githubComChaosMeshChaosMeshApiV1alpha1PodChaos = githubComChaosMeshChaosMeshApiV1alpha1PodChaos;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodChaosList")
    public PodChaosList getGithubComChaosMeshChaosMeshApiV1alpha1PodChaosList() {
        return githubComChaosMeshChaosMeshApiV1alpha1PodChaosList;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodChaosList")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1PodChaosList(PodChaosList githubComChaosMeshChaosMeshApiV1alpha1PodChaosList) {
        this.githubComChaosMeshChaosMeshApiV1alpha1PodChaosList = githubComChaosMeshChaosMeshApiV1alpha1PodChaosList;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodChaosSpec")
    public PodChaosSpec getGithubComChaosMeshChaosMeshApiV1alpha1PodChaosSpec() {
        return githubComChaosMeshChaosMeshApiV1alpha1PodChaosSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodChaosSpec")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1PodChaosSpec(PodChaosSpec githubComChaosMeshChaosMeshApiV1alpha1PodChaosSpec) {
        this.githubComChaosMeshChaosMeshApiV1alpha1PodChaosSpec = githubComChaosMeshChaosMeshApiV1alpha1PodChaosSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodChaosStatus")
    public PodChaosStatus getGithubComChaosMeshChaosMeshApiV1alpha1PodChaosStatus() {
        return githubComChaosMeshChaosMeshApiV1alpha1PodChaosStatus;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodChaosStatus")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1PodChaosStatus(PodChaosStatus githubComChaosMeshChaosMeshApiV1alpha1PodChaosStatus) {
        this.githubComChaosMeshChaosMeshApiV1alpha1PodChaosStatus = githubComChaosMeshChaosMeshApiV1alpha1PodChaosStatus;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodHttpChaos")
    public PodHttpChaos getGithubComChaosMeshChaosMeshApiV1alpha1PodHttpChaos() {
        return githubComChaosMeshChaosMeshApiV1alpha1PodHttpChaos;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodHttpChaos")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1PodHttpChaos(PodHttpChaos githubComChaosMeshChaosMeshApiV1alpha1PodHttpChaos) {
        this.githubComChaosMeshChaosMeshApiV1alpha1PodHttpChaos = githubComChaosMeshChaosMeshApiV1alpha1PodHttpChaos;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodHttpChaosActions")
    public PodHttpChaosActions getGithubComChaosMeshChaosMeshApiV1alpha1PodHttpChaosActions() {
        return githubComChaosMeshChaosMeshApiV1alpha1PodHttpChaosActions;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodHttpChaosActions")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1PodHttpChaosActions(PodHttpChaosActions githubComChaosMeshChaosMeshApiV1alpha1PodHttpChaosActions) {
        this.githubComChaosMeshChaosMeshApiV1alpha1PodHttpChaosActions = githubComChaosMeshChaosMeshApiV1alpha1PodHttpChaosActions;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodHttpChaosList")
    public PodHttpChaosList getGithubComChaosMeshChaosMeshApiV1alpha1PodHttpChaosList() {
        return githubComChaosMeshChaosMeshApiV1alpha1PodHttpChaosList;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodHttpChaosList")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1PodHttpChaosList(PodHttpChaosList githubComChaosMeshChaosMeshApiV1alpha1PodHttpChaosList) {
        this.githubComChaosMeshChaosMeshApiV1alpha1PodHttpChaosList = githubComChaosMeshChaosMeshApiV1alpha1PodHttpChaosList;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodHttpChaosPatchActions")
    public PodHttpChaosPatchActions getGithubComChaosMeshChaosMeshApiV1alpha1PodHttpChaosPatchActions() {
        return githubComChaosMeshChaosMeshApiV1alpha1PodHttpChaosPatchActions;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodHttpChaosPatchActions")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1PodHttpChaosPatchActions(PodHttpChaosPatchActions githubComChaosMeshChaosMeshApiV1alpha1PodHttpChaosPatchActions) {
        this.githubComChaosMeshChaosMeshApiV1alpha1PodHttpChaosPatchActions = githubComChaosMeshChaosMeshApiV1alpha1PodHttpChaosPatchActions;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodHttpChaosPatchBodyAction")
    public PodHttpChaosPatchBodyAction getGithubComChaosMeshChaosMeshApiV1alpha1PodHttpChaosPatchBodyAction() {
        return githubComChaosMeshChaosMeshApiV1alpha1PodHttpChaosPatchBodyAction;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodHttpChaosPatchBodyAction")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1PodHttpChaosPatchBodyAction(PodHttpChaosPatchBodyAction githubComChaosMeshChaosMeshApiV1alpha1PodHttpChaosPatchBodyAction) {
        this.githubComChaosMeshChaosMeshApiV1alpha1PodHttpChaosPatchBodyAction = githubComChaosMeshChaosMeshApiV1alpha1PodHttpChaosPatchBodyAction;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodHttpChaosReplaceActions")
    public PodHttpChaosReplaceActions getGithubComChaosMeshChaosMeshApiV1alpha1PodHttpChaosReplaceActions() {
        return githubComChaosMeshChaosMeshApiV1alpha1PodHttpChaosReplaceActions;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodHttpChaosReplaceActions")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1PodHttpChaosReplaceActions(PodHttpChaosReplaceActions githubComChaosMeshChaosMeshApiV1alpha1PodHttpChaosReplaceActions) {
        this.githubComChaosMeshChaosMeshApiV1alpha1PodHttpChaosReplaceActions = githubComChaosMeshChaosMeshApiV1alpha1PodHttpChaosReplaceActions;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodHttpChaosRule")
    public PodHttpChaosRule getGithubComChaosMeshChaosMeshApiV1alpha1PodHttpChaosRule() {
        return githubComChaosMeshChaosMeshApiV1alpha1PodHttpChaosRule;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodHttpChaosRule")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1PodHttpChaosRule(PodHttpChaosRule githubComChaosMeshChaosMeshApiV1alpha1PodHttpChaosRule) {
        this.githubComChaosMeshChaosMeshApiV1alpha1PodHttpChaosRule = githubComChaosMeshChaosMeshApiV1alpha1PodHttpChaosRule;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodHttpChaosSelector")
    public PodHttpChaosSelector getGithubComChaosMeshChaosMeshApiV1alpha1PodHttpChaosSelector() {
        return githubComChaosMeshChaosMeshApiV1alpha1PodHttpChaosSelector;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodHttpChaosSelector")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1PodHttpChaosSelector(PodHttpChaosSelector githubComChaosMeshChaosMeshApiV1alpha1PodHttpChaosSelector) {
        this.githubComChaosMeshChaosMeshApiV1alpha1PodHttpChaosSelector = githubComChaosMeshChaosMeshApiV1alpha1PodHttpChaosSelector;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodHttpChaosSpec")
    public PodHttpChaosSpec getGithubComChaosMeshChaosMeshApiV1alpha1PodHttpChaosSpec() {
        return githubComChaosMeshChaosMeshApiV1alpha1PodHttpChaosSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodHttpChaosSpec")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1PodHttpChaosSpec(PodHttpChaosSpec githubComChaosMeshChaosMeshApiV1alpha1PodHttpChaosSpec) {
        this.githubComChaosMeshChaosMeshApiV1alpha1PodHttpChaosSpec = githubComChaosMeshChaosMeshApiV1alpha1PodHttpChaosSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodHttpChaosStatus")
    public PodHttpChaosStatus getGithubComChaosMeshChaosMeshApiV1alpha1PodHttpChaosStatus() {
        return githubComChaosMeshChaosMeshApiV1alpha1PodHttpChaosStatus;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodHttpChaosStatus")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1PodHttpChaosStatus(PodHttpChaosStatus githubComChaosMeshChaosMeshApiV1alpha1PodHttpChaosStatus) {
        this.githubComChaosMeshChaosMeshApiV1alpha1PodHttpChaosStatus = githubComChaosMeshChaosMeshApiV1alpha1PodHttpChaosStatus;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodIOChaos")
    public PodIOChaos getGithubComChaosMeshChaosMeshApiV1alpha1PodIOChaos() {
        return githubComChaosMeshChaosMeshApiV1alpha1PodIOChaos;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodIOChaos")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1PodIOChaos(PodIOChaos githubComChaosMeshChaosMeshApiV1alpha1PodIOChaos) {
        this.githubComChaosMeshChaosMeshApiV1alpha1PodIOChaos = githubComChaosMeshChaosMeshApiV1alpha1PodIOChaos;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodIOChaosList")
    public PodIOChaosList getGithubComChaosMeshChaosMeshApiV1alpha1PodIOChaosList() {
        return githubComChaosMeshChaosMeshApiV1alpha1PodIOChaosList;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodIOChaosList")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1PodIOChaosList(PodIOChaosList githubComChaosMeshChaosMeshApiV1alpha1PodIOChaosList) {
        this.githubComChaosMeshChaosMeshApiV1alpha1PodIOChaosList = githubComChaosMeshChaosMeshApiV1alpha1PodIOChaosList;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodIOChaosSpec")
    public PodIOChaosSpec getGithubComChaosMeshChaosMeshApiV1alpha1PodIOChaosSpec() {
        return githubComChaosMeshChaosMeshApiV1alpha1PodIOChaosSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodIOChaosSpec")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1PodIOChaosSpec(PodIOChaosSpec githubComChaosMeshChaosMeshApiV1alpha1PodIOChaosSpec) {
        this.githubComChaosMeshChaosMeshApiV1alpha1PodIOChaosSpec = githubComChaosMeshChaosMeshApiV1alpha1PodIOChaosSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodIOChaosStatus")
    public PodIOChaosStatus getGithubComChaosMeshChaosMeshApiV1alpha1PodIOChaosStatus() {
        return githubComChaosMeshChaosMeshApiV1alpha1PodIOChaosStatus;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodIOChaosStatus")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1PodIOChaosStatus(PodIOChaosStatus githubComChaosMeshChaosMeshApiV1alpha1PodIOChaosStatus) {
        this.githubComChaosMeshChaosMeshApiV1alpha1PodIOChaosStatus = githubComChaosMeshChaosMeshApiV1alpha1PodIOChaosStatus;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodNetworkChaos")
    public PodNetworkChaos getGithubComChaosMeshChaosMeshApiV1alpha1PodNetworkChaos() {
        return githubComChaosMeshChaosMeshApiV1alpha1PodNetworkChaos;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodNetworkChaos")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1PodNetworkChaos(PodNetworkChaos githubComChaosMeshChaosMeshApiV1alpha1PodNetworkChaos) {
        this.githubComChaosMeshChaosMeshApiV1alpha1PodNetworkChaos = githubComChaosMeshChaosMeshApiV1alpha1PodNetworkChaos;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodNetworkChaosList")
    public PodNetworkChaosList getGithubComChaosMeshChaosMeshApiV1alpha1PodNetworkChaosList() {
        return githubComChaosMeshChaosMeshApiV1alpha1PodNetworkChaosList;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodNetworkChaosList")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1PodNetworkChaosList(PodNetworkChaosList githubComChaosMeshChaosMeshApiV1alpha1PodNetworkChaosList) {
        this.githubComChaosMeshChaosMeshApiV1alpha1PodNetworkChaosList = githubComChaosMeshChaosMeshApiV1alpha1PodNetworkChaosList;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodNetworkChaosSpec")
    public PodNetworkChaosSpec getGithubComChaosMeshChaosMeshApiV1alpha1PodNetworkChaosSpec() {
        return githubComChaosMeshChaosMeshApiV1alpha1PodNetworkChaosSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodNetworkChaosSpec")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1PodNetworkChaosSpec(PodNetworkChaosSpec githubComChaosMeshChaosMeshApiV1alpha1PodNetworkChaosSpec) {
        this.githubComChaosMeshChaosMeshApiV1alpha1PodNetworkChaosSpec = githubComChaosMeshChaosMeshApiV1alpha1PodNetworkChaosSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodNetworkChaosStatus")
    public PodNetworkChaosStatus getGithubComChaosMeshChaosMeshApiV1alpha1PodNetworkChaosStatus() {
        return githubComChaosMeshChaosMeshApiV1alpha1PodNetworkChaosStatus;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodNetworkChaosStatus")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1PodNetworkChaosStatus(PodNetworkChaosStatus githubComChaosMeshChaosMeshApiV1alpha1PodNetworkChaosStatus) {
        this.githubComChaosMeshChaosMeshApiV1alpha1PodNetworkChaosStatus = githubComChaosMeshChaosMeshApiV1alpha1PodNetworkChaosStatus;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodSelector")
    public PodSelector getGithubComChaosMeshChaosMeshApiV1alpha1PodSelector() {
        return githubComChaosMeshChaosMeshApiV1alpha1PodSelector;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodSelector")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1PodSelector(PodSelector githubComChaosMeshChaosMeshApiV1alpha1PodSelector) {
        this.githubComChaosMeshChaosMeshApiV1alpha1PodSelector = githubComChaosMeshChaosMeshApiV1alpha1PodSelector;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodSelectorSpec")
    public PodSelectorSpec getGithubComChaosMeshChaosMeshApiV1alpha1PodSelectorSpec() {
        return githubComChaosMeshChaosMeshApiV1alpha1PodSelectorSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodSelectorSpec")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1PodSelectorSpec(PodSelectorSpec githubComChaosMeshChaosMeshApiV1alpha1PodSelectorSpec) {
        this.githubComChaosMeshChaosMeshApiV1alpha1PodSelectorSpec = githubComChaosMeshChaosMeshApiV1alpha1PodSelectorSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_ProcessSpec")
    public ProcessSpec getGithubComChaosMeshChaosMeshApiV1alpha1ProcessSpec() {
        return githubComChaosMeshChaosMeshApiV1alpha1ProcessSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_ProcessSpec")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1ProcessSpec(ProcessSpec githubComChaosMeshChaosMeshApiV1alpha1ProcessSpec) {
        this.githubComChaosMeshChaosMeshApiV1alpha1ProcessSpec = githubComChaosMeshChaosMeshApiV1alpha1ProcessSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_RawIPSet")
    public RawIPSet getGithubComChaosMeshChaosMeshApiV1alpha1RawIPSet() {
        return githubComChaosMeshChaosMeshApiV1alpha1RawIPSet;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_RawIPSet")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1RawIPSet(RawIPSet githubComChaosMeshChaosMeshApiV1alpha1RawIPSet) {
        this.githubComChaosMeshChaosMeshApiV1alpha1RawIPSet = githubComChaosMeshChaosMeshApiV1alpha1RawIPSet;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_RawIptables")
    public RawIptables getGithubComChaosMeshChaosMeshApiV1alpha1RawIptables() {
        return githubComChaosMeshChaosMeshApiV1alpha1RawIptables;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_RawIptables")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1RawIptables(RawIptables githubComChaosMeshChaosMeshApiV1alpha1RawIptables) {
        this.githubComChaosMeshChaosMeshApiV1alpha1RawIptables = githubComChaosMeshChaosMeshApiV1alpha1RawIptables;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_RawTrafficControl")
    public RawTrafficControl getGithubComChaosMeshChaosMeshApiV1alpha1RawTrafficControl() {
        return githubComChaosMeshChaosMeshApiV1alpha1RawTrafficControl;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_RawTrafficControl")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1RawTrafficControl(RawTrafficControl githubComChaosMeshChaosMeshApiV1alpha1RawTrafficControl) {
        this.githubComChaosMeshChaosMeshApiV1alpha1RawTrafficControl = githubComChaosMeshChaosMeshApiV1alpha1RawTrafficControl;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_Record")
    public Record getGithubComChaosMeshChaosMeshApiV1alpha1Record() {
        return githubComChaosMeshChaosMeshApiV1alpha1Record;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_Record")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1Record(Record githubComChaosMeshChaosMeshApiV1alpha1Record) {
        this.githubComChaosMeshChaosMeshApiV1alpha1Record = githubComChaosMeshChaosMeshApiV1alpha1Record;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_ReorderSpec")
    public ReorderSpec getGithubComChaosMeshChaosMeshApiV1alpha1ReorderSpec() {
        return githubComChaosMeshChaosMeshApiV1alpha1ReorderSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_ReorderSpec")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1ReorderSpec(ReorderSpec githubComChaosMeshChaosMeshApiV1alpha1ReorderSpec) {
        this.githubComChaosMeshChaosMeshApiV1alpha1ReorderSpec = githubComChaosMeshChaosMeshApiV1alpha1ReorderSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_StressCPUSpec")
    public StressCPUSpec getGithubComChaosMeshChaosMeshApiV1alpha1StressCPUSpec() {
        return githubComChaosMeshChaosMeshApiV1alpha1StressCPUSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_StressCPUSpec")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1StressCPUSpec(StressCPUSpec githubComChaosMeshChaosMeshApiV1alpha1StressCPUSpec) {
        this.githubComChaosMeshChaosMeshApiV1alpha1StressCPUSpec = githubComChaosMeshChaosMeshApiV1alpha1StressCPUSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_StressChaos")
    public StressChaos getGithubComChaosMeshChaosMeshApiV1alpha1StressChaos() {
        return githubComChaosMeshChaosMeshApiV1alpha1StressChaos;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_StressChaos")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1StressChaos(StressChaos githubComChaosMeshChaosMeshApiV1alpha1StressChaos) {
        this.githubComChaosMeshChaosMeshApiV1alpha1StressChaos = githubComChaosMeshChaosMeshApiV1alpha1StressChaos;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_StressChaosList")
    public StressChaosList getGithubComChaosMeshChaosMeshApiV1alpha1StressChaosList() {
        return githubComChaosMeshChaosMeshApiV1alpha1StressChaosList;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_StressChaosList")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1StressChaosList(StressChaosList githubComChaosMeshChaosMeshApiV1alpha1StressChaosList) {
        this.githubComChaosMeshChaosMeshApiV1alpha1StressChaosList = githubComChaosMeshChaosMeshApiV1alpha1StressChaosList;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_StressChaosSpec")
    public StressChaosSpec getGithubComChaosMeshChaosMeshApiV1alpha1StressChaosSpec() {
        return githubComChaosMeshChaosMeshApiV1alpha1StressChaosSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_StressChaosSpec")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1StressChaosSpec(StressChaosSpec githubComChaosMeshChaosMeshApiV1alpha1StressChaosSpec) {
        this.githubComChaosMeshChaosMeshApiV1alpha1StressChaosSpec = githubComChaosMeshChaosMeshApiV1alpha1StressChaosSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_StressChaosStatus")
    public StressChaosStatus getGithubComChaosMeshChaosMeshApiV1alpha1StressChaosStatus() {
        return githubComChaosMeshChaosMeshApiV1alpha1StressChaosStatus;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_StressChaosStatus")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1StressChaosStatus(StressChaosStatus githubComChaosMeshChaosMeshApiV1alpha1StressChaosStatus) {
        this.githubComChaosMeshChaosMeshApiV1alpha1StressChaosStatus = githubComChaosMeshChaosMeshApiV1alpha1StressChaosStatus;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_StressInstance")
    public StressInstance getGithubComChaosMeshChaosMeshApiV1alpha1StressInstance() {
        return githubComChaosMeshChaosMeshApiV1alpha1StressInstance;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_StressInstance")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1StressInstance(StressInstance githubComChaosMeshChaosMeshApiV1alpha1StressInstance) {
        this.githubComChaosMeshChaosMeshApiV1alpha1StressInstance = githubComChaosMeshChaosMeshApiV1alpha1StressInstance;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_StressMemorySpec")
    public StressMemorySpec getGithubComChaosMeshChaosMeshApiV1alpha1StressMemorySpec() {
        return githubComChaosMeshChaosMeshApiV1alpha1StressMemorySpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_StressMemorySpec")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1StressMemorySpec(StressMemorySpec githubComChaosMeshChaosMeshApiV1alpha1StressMemorySpec) {
        this.githubComChaosMeshChaosMeshApiV1alpha1StressMemorySpec = githubComChaosMeshChaosMeshApiV1alpha1StressMemorySpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_Stressors")
    public Stressors getGithubComChaosMeshChaosMeshApiV1alpha1Stressors() {
        return githubComChaosMeshChaosMeshApiV1alpha1Stressors;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_Stressors")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1Stressors(Stressors githubComChaosMeshChaosMeshApiV1alpha1Stressors) {
        this.githubComChaosMeshChaosMeshApiV1alpha1Stressors = githubComChaosMeshChaosMeshApiV1alpha1Stressors;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_TimeChaos")
    public TimeChaos getGithubComChaosMeshChaosMeshApiV1alpha1TimeChaos() {
        return githubComChaosMeshChaosMeshApiV1alpha1TimeChaos;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_TimeChaos")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1TimeChaos(TimeChaos githubComChaosMeshChaosMeshApiV1alpha1TimeChaos) {
        this.githubComChaosMeshChaosMeshApiV1alpha1TimeChaos = githubComChaosMeshChaosMeshApiV1alpha1TimeChaos;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_TimeChaosList")
    public TimeChaosList getGithubComChaosMeshChaosMeshApiV1alpha1TimeChaosList() {
        return githubComChaosMeshChaosMeshApiV1alpha1TimeChaosList;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_TimeChaosList")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1TimeChaosList(TimeChaosList githubComChaosMeshChaosMeshApiV1alpha1TimeChaosList) {
        this.githubComChaosMeshChaosMeshApiV1alpha1TimeChaosList = githubComChaosMeshChaosMeshApiV1alpha1TimeChaosList;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_TimeChaosSpec")
    public TimeChaosSpec getGithubComChaosMeshChaosMeshApiV1alpha1TimeChaosSpec() {
        return githubComChaosMeshChaosMeshApiV1alpha1TimeChaosSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_TimeChaosSpec")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1TimeChaosSpec(TimeChaosSpec githubComChaosMeshChaosMeshApiV1alpha1TimeChaosSpec) {
        this.githubComChaosMeshChaosMeshApiV1alpha1TimeChaosSpec = githubComChaosMeshChaosMeshApiV1alpha1TimeChaosSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_TimeChaosStatus")
    public TimeChaosStatus getGithubComChaosMeshChaosMeshApiV1alpha1TimeChaosStatus() {
        return githubComChaosMeshChaosMeshApiV1alpha1TimeChaosStatus;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_TimeChaosStatus")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1TimeChaosStatus(TimeChaosStatus githubComChaosMeshChaosMeshApiV1alpha1TimeChaosStatus) {
        this.githubComChaosMeshChaosMeshApiV1alpha1TimeChaosStatus = githubComChaosMeshChaosMeshApiV1alpha1TimeChaosStatus;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_Timespec")
    public Timespec getGithubComChaosMeshChaosMeshApiV1alpha1Timespec() {
        return githubComChaosMeshChaosMeshApiV1alpha1Timespec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_Timespec")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1Timespec(Timespec githubComChaosMeshChaosMeshApiV1alpha1Timespec) {
        this.githubComChaosMeshChaosMeshApiV1alpha1Timespec = githubComChaosMeshChaosMeshApiV1alpha1Timespec;
    }

}
