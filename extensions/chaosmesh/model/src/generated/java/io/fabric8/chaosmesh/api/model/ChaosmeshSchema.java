
package io.fabric8.chaosmesh.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.chaosmesh.v1alpha1.AttrOverrideSpec;
import io.fabric8.chaosmesh.v1alpha1.AwsChaos;
import io.fabric8.chaosmesh.v1alpha1.AwsChaosList;
import io.fabric8.chaosmesh.v1alpha1.AwsChaosSpec;
import io.fabric8.chaosmesh.v1alpha1.AwsChaosStatus;
import io.fabric8.chaosmesh.v1alpha1.BandwidthSpec;
import io.fabric8.chaosmesh.v1alpha1.CPUStressor;
import io.fabric8.chaosmesh.v1alpha1.CorruptSpec;
import io.fabric8.chaosmesh.v1alpha1.DNSChaos;
import io.fabric8.chaosmesh.v1alpha1.DNSChaosList;
import io.fabric8.chaosmesh.v1alpha1.DNSChaosSpec;
import io.fabric8.chaosmesh.v1alpha1.DNSChaosStatus;
import io.fabric8.chaosmesh.v1alpha1.DelaySpec;
import io.fabric8.chaosmesh.v1alpha1.DuplicateSpec;
import io.fabric8.chaosmesh.v1alpha1.ExperimentStatus;
import io.fabric8.chaosmesh.v1alpha1.FailKernRequest;
import io.fabric8.chaosmesh.v1alpha1.Frame;
import io.fabric8.chaosmesh.v1alpha1.HTTPChaos;
import io.fabric8.chaosmesh.v1alpha1.HTTPChaosList;
import io.fabric8.chaosmesh.v1alpha1.HTTPChaosSpec;
import io.fabric8.chaosmesh.v1alpha1.HTTPChaosStatus;
import io.fabric8.chaosmesh.v1alpha1.IoChaos;
import io.fabric8.chaosmesh.v1alpha1.IoChaosAction;
import io.fabric8.chaosmesh.v1alpha1.IoChaosList;
import io.fabric8.chaosmesh.v1alpha1.IoChaosSpec;
import io.fabric8.chaosmesh.v1alpha1.IoChaosStatus;
import io.fabric8.chaosmesh.v1alpha1.IoFault;
import io.fabric8.chaosmesh.v1alpha1.JVMChaos;
import io.fabric8.chaosmesh.v1alpha1.JVMChaosList;
import io.fabric8.chaosmesh.v1alpha1.JVMChaosSpec;
import io.fabric8.chaosmesh.v1alpha1.JVMChaosStatus;
import io.fabric8.chaosmesh.v1alpha1.KernelChaos;
import io.fabric8.chaosmesh.v1alpha1.KernelChaosList;
import io.fabric8.chaosmesh.v1alpha1.KernelChaosSpec;
import io.fabric8.chaosmesh.v1alpha1.KernelChaosStatus;
import io.fabric8.chaosmesh.v1alpha1.LossSpec;
import io.fabric8.chaosmesh.v1alpha1.Matcher;
import io.fabric8.chaosmesh.v1alpha1.MemoryStressor;
import io.fabric8.chaosmesh.v1alpha1.MistakeSpec;
import io.fabric8.chaosmesh.v1alpha1.NetworkChaos;
import io.fabric8.chaosmesh.v1alpha1.NetworkChaosList;
import io.fabric8.chaosmesh.v1alpha1.NetworkChaosSpec;
import io.fabric8.chaosmesh.v1alpha1.NetworkChaosStatus;
import io.fabric8.chaosmesh.v1alpha1.PodChaos;
import io.fabric8.chaosmesh.v1alpha1.PodChaosList;
import io.fabric8.chaosmesh.v1alpha1.PodChaosSpec;
import io.fabric8.chaosmesh.v1alpha1.PodChaosStatus;
import io.fabric8.chaosmesh.v1alpha1.PodIoChaos;
import io.fabric8.chaosmesh.v1alpha1.PodIoChaosList;
import io.fabric8.chaosmesh.v1alpha1.PodIoChaosSpec;
import io.fabric8.chaosmesh.v1alpha1.PodNetworkChaos;
import io.fabric8.chaosmesh.v1alpha1.PodNetworkChaosList;
import io.fabric8.chaosmesh.v1alpha1.PodNetworkChaosSpec;
import io.fabric8.chaosmesh.v1alpha1.PodNetworkChaosStatus;
import io.fabric8.chaosmesh.v1alpha1.PodStatus;
import io.fabric8.chaosmesh.v1alpha1.RawIPSet;
import io.fabric8.chaosmesh.v1alpha1.RawIptables;
import io.fabric8.chaosmesh.v1alpha1.RawTrafficControl;
import io.fabric8.chaosmesh.v1alpha1.ReorderSpec;
import io.fabric8.chaosmesh.v1alpha1.ScheduleStatus;
import io.fabric8.chaosmesh.v1alpha1.SchedulerSpec;
import io.fabric8.chaosmesh.v1alpha1.SelectorSpec;
import io.fabric8.chaosmesh.v1alpha1.StressChaos;
import io.fabric8.chaosmesh.v1alpha1.StressChaosList;
import io.fabric8.chaosmesh.v1alpha1.StressChaosSpec;
import io.fabric8.chaosmesh.v1alpha1.StressChaosStatus;
import io.fabric8.chaosmesh.v1alpha1.StressInstance;
import io.fabric8.chaosmesh.v1alpha1.Stressors;
import io.fabric8.chaosmesh.v1alpha1.Target;
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
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_AttrOverrideSpec",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_AwsChaos",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_AwsChaosList",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_AwsChaosSpec",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_AwsChaosStatus",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_BandwidthSpec",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_CPUStressor",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_CorruptSpec",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_DNSChaos",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_DNSChaosList",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_DNSChaosSpec",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_DNSChaosStatus",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_DelaySpec",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_DuplicateSpec",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_ExperimentStatus",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_FailKernRequest",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_Frame",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_HTTPChaos",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_HTTPChaosList",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_HTTPChaosSpec",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_HTTPChaosStatus",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_IoChaos",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_IoChaosAction",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_IoChaosList",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_IoChaosSpec",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_IoChaosStatus",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_IoFault",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_JVMChaos",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_JVMChaosList",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_JVMChaosSpec",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_JVMChaosStatus",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_KernelChaos",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_KernelChaosList",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_KernelChaosSpec",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_KernelChaosStatus",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_LossSpec",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_Matcher",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_MemoryStressor",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_MistakeSpec",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_NetworkChaos",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_NetworkChaosList",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_NetworkChaosSpec",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_NetworkChaosStatus",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodChaos",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodChaosList",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodChaosSpec",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodChaosStatus",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodIoChaos",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodIoChaosList",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodIoChaosSpec",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodNetworkChaos",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodNetworkChaosList",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodNetworkChaosSpec",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodNetworkChaosStatus",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodStatus",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_RawIPSet",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_RawIptables",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_RawTrafficControl",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_ReorderSpec",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_ScheduleStatus",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_SchedulerSpec",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_SelectorSpec",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_StressChaos",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_StressChaosList",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_StressChaosSpec",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_StressChaosStatus",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_StressInstance",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_Stressors",
    "github_com_chaos-mesh_chaos-mesh_api_v1alpha1_Target",
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
public class ChaosmeshSchema {

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_AttrOverrideSpec")
    private AttrOverrideSpec githubComChaosMeshChaosMeshApiV1alpha1AttrOverrideSpec;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_AwsChaos")
    private AwsChaos githubComChaosMeshChaosMeshApiV1alpha1AwsChaos;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_AwsChaosList")
    private AwsChaosList githubComChaosMeshChaosMeshApiV1alpha1AwsChaosList;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_AwsChaosSpec")
    private AwsChaosSpec githubComChaosMeshChaosMeshApiV1alpha1AwsChaosSpec;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_AwsChaosStatus")
    private AwsChaosStatus githubComChaosMeshChaosMeshApiV1alpha1AwsChaosStatus;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_BandwidthSpec")
    private BandwidthSpec githubComChaosMeshChaosMeshApiV1alpha1BandwidthSpec;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_CPUStressor")
    private CPUStressor githubComChaosMeshChaosMeshApiV1alpha1CPUStressor;
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
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_DuplicateSpec")
    private DuplicateSpec githubComChaosMeshChaosMeshApiV1alpha1DuplicateSpec;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_ExperimentStatus")
    private ExperimentStatus githubComChaosMeshChaosMeshApiV1alpha1ExperimentStatus;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_FailKernRequest")
    private FailKernRequest githubComChaosMeshChaosMeshApiV1alpha1FailKernRequest;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_Frame")
    private Frame githubComChaosMeshChaosMeshApiV1alpha1Frame;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_HTTPChaos")
    private HTTPChaos githubComChaosMeshChaosMeshApiV1alpha1HTTPChaos;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_HTTPChaosList")
    private HTTPChaosList githubComChaosMeshChaosMeshApiV1alpha1HTTPChaosList;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_HTTPChaosSpec")
    private HTTPChaosSpec githubComChaosMeshChaosMeshApiV1alpha1HTTPChaosSpec;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_HTTPChaosStatus")
    private HTTPChaosStatus githubComChaosMeshChaosMeshApiV1alpha1HTTPChaosStatus;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_IoChaos")
    private IoChaos githubComChaosMeshChaosMeshApiV1alpha1IoChaos;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_IoChaosAction")
    private IoChaosAction githubComChaosMeshChaosMeshApiV1alpha1IoChaosAction;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_IoChaosList")
    private IoChaosList githubComChaosMeshChaosMeshApiV1alpha1IoChaosList;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_IoChaosSpec")
    private IoChaosSpec githubComChaosMeshChaosMeshApiV1alpha1IoChaosSpec;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_IoChaosStatus")
    private IoChaosStatus githubComChaosMeshChaosMeshApiV1alpha1IoChaosStatus;
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
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_Matcher")
    private Matcher githubComChaosMeshChaosMeshApiV1alpha1Matcher;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_MemoryStressor")
    private MemoryStressor githubComChaosMeshChaosMeshApiV1alpha1MemoryStressor;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_MistakeSpec")
    private MistakeSpec githubComChaosMeshChaosMeshApiV1alpha1MistakeSpec;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_NetworkChaos")
    private NetworkChaos githubComChaosMeshChaosMeshApiV1alpha1NetworkChaos;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_NetworkChaosList")
    private NetworkChaosList githubComChaosMeshChaosMeshApiV1alpha1NetworkChaosList;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_NetworkChaosSpec")
    private NetworkChaosSpec githubComChaosMeshChaosMeshApiV1alpha1NetworkChaosSpec;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_NetworkChaosStatus")
    private NetworkChaosStatus githubComChaosMeshChaosMeshApiV1alpha1NetworkChaosStatus;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodChaos")
    private PodChaos githubComChaosMeshChaosMeshApiV1alpha1PodChaos;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodChaosList")
    private PodChaosList githubComChaosMeshChaosMeshApiV1alpha1PodChaosList;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodChaosSpec")
    private PodChaosSpec githubComChaosMeshChaosMeshApiV1alpha1PodChaosSpec;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodChaosStatus")
    private PodChaosStatus githubComChaosMeshChaosMeshApiV1alpha1PodChaosStatus;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodIoChaos")
    private PodIoChaos githubComChaosMeshChaosMeshApiV1alpha1PodIoChaos;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodIoChaosList")
    private PodIoChaosList githubComChaosMeshChaosMeshApiV1alpha1PodIoChaosList;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodIoChaosSpec")
    private PodIoChaosSpec githubComChaosMeshChaosMeshApiV1alpha1PodIoChaosSpec;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodNetworkChaos")
    private PodNetworkChaos githubComChaosMeshChaosMeshApiV1alpha1PodNetworkChaos;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodNetworkChaosList")
    private PodNetworkChaosList githubComChaosMeshChaosMeshApiV1alpha1PodNetworkChaosList;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodNetworkChaosSpec")
    private PodNetworkChaosSpec githubComChaosMeshChaosMeshApiV1alpha1PodNetworkChaosSpec;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodNetworkChaosStatus")
    private PodNetworkChaosStatus githubComChaosMeshChaosMeshApiV1alpha1PodNetworkChaosStatus;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodStatus")
    private PodStatus githubComChaosMeshChaosMeshApiV1alpha1PodStatus;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_RawIPSet")
    private RawIPSet githubComChaosMeshChaosMeshApiV1alpha1RawIPSet;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_RawIptables")
    private RawIptables githubComChaosMeshChaosMeshApiV1alpha1RawIptables;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_RawTrafficControl")
    private RawTrafficControl githubComChaosMeshChaosMeshApiV1alpha1RawTrafficControl;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_ReorderSpec")
    private ReorderSpec githubComChaosMeshChaosMeshApiV1alpha1ReorderSpec;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_ScheduleStatus")
    private ScheduleStatus githubComChaosMeshChaosMeshApiV1alpha1ScheduleStatus;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_SchedulerSpec")
    private SchedulerSpec githubComChaosMeshChaosMeshApiV1alpha1SchedulerSpec;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_SelectorSpec")
    private SelectorSpec githubComChaosMeshChaosMeshApiV1alpha1SelectorSpec;
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
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_Stressors")
    private Stressors githubComChaosMeshChaosMeshApiV1alpha1Stressors;
    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_Target")
    private Target githubComChaosMeshChaosMeshApiV1alpha1Target;
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

    /**
     * 
     * @param githubComChaosMeshChaosMeshApiV1alpha1DNSChaos
     * @param githubComChaosMeshChaosMeshApiV1alpha1KernelChaos
     * @param githubComChaosMeshChaosMeshApiV1alpha1TimeChaosSpec
     * @param githubComChaosMeshChaosMeshApiV1alpha1TimeChaosStatus
     * @param githubComChaosMeshChaosMeshApiV1alpha1StressChaosStatus
     * @param githubComChaosMeshChaosMeshApiV1alpha1PodIoChaosList
     * @param githubComChaosMeshChaosMeshApiV1alpha1CorruptSpec
     * @param githubComChaosMeshChaosMeshApiV1alpha1StressInstance
     * @param githubComChaosMeshChaosMeshApiV1alpha1PodChaosList
     * @param githubComChaosMeshChaosMeshApiV1alpha1ReorderSpec
     * @param githubComChaosMeshChaosMeshApiV1alpha1Timespec
     * @param githubComChaosMeshChaosMeshApiV1alpha1HTTPChaosStatus
     * @param githubComChaosMeshChaosMeshApiV1alpha1Stressors
     * @param githubComChaosMeshChaosMeshApiV1alpha1RawIPSet
     * @param githubComChaosMeshChaosMeshApiV1alpha1PodNetworkChaosList
     * @param githubComChaosMeshChaosMeshApiV1alpha1IoChaosStatus
     * @param githubComChaosMeshChaosMeshApiV1alpha1MistakeSpec
     * @param githubComChaosMeshChaosMeshApiV1alpha1KernelChaosList
     * @param githubComChaosMeshChaosMeshApiV1alpha1AwsChaosStatus
     * @param githubComChaosMeshChaosMeshApiV1alpha1IoChaosList
     * @param githubComChaosMeshChaosMeshApiV1alpha1ExperimentStatus
     * @param githubComChaosMeshChaosMeshApiV1alpha1NetworkChaosList
     * @param githubComChaosMeshChaosMeshApiV1alpha1PodStatus
     * @param githubComChaosMeshChaosMeshApiV1alpha1DelaySpec
     * @param githubComChaosMeshChaosMeshApiV1alpha1KernelChaosStatus
     * @param githubComChaosMeshChaosMeshApiV1alpha1AwsChaos
     * @param githubComChaosMeshChaosMeshApiV1alpha1Matcher
     * @param githubComChaosMeshChaosMeshApiV1alpha1JVMChaosStatus
     * @param githubComChaosMeshChaosMeshApiV1alpha1DuplicateSpec
     * @param githubComChaosMeshChaosMeshApiV1alpha1HTTPChaosSpec
     * @param githubComChaosMeshChaosMeshApiV1alpha1PodChaosSpec
     * @param githubComChaosMeshChaosMeshApiV1alpha1JVMChaosSpec
     * @param githubComChaosMeshChaosMeshApiV1alpha1NetworkChaos
     * @param githubComChaosMeshChaosMeshApiV1alpha1MemoryStressor
     * @param githubComChaosMeshChaosMeshApiV1alpha1FailKernRequest
     * @param githubComChaosMeshChaosMeshApiV1alpha1IoChaosAction
     * @param githubComChaosMeshChaosMeshApiV1alpha1TimeChaos
     * @param githubComChaosMeshChaosMeshApiV1alpha1PodNetworkChaosSpec
     * @param githubComChaosMeshChaosMeshApiV1alpha1RawTrafficControl
     * @param githubComChaosMeshChaosMeshApiV1alpha1IoChaos
     * @param githubComChaosMeshChaosMeshApiV1alpha1Frame
     * @param githubComChaosMeshChaosMeshApiV1alpha1JVMChaos
     * @param githubComChaosMeshChaosMeshApiV1alpha1BandwidthSpec
     * @param githubComChaosMeshChaosMeshApiV1alpha1RawIptables
     * @param githubComChaosMeshChaosMeshApiV1alpha1IoFault
     * @param githubComChaosMeshChaosMeshApiV1alpha1DNSChaosStatus
     * @param githubComChaosMeshChaosMeshApiV1alpha1HTTPChaosList
     * @param githubComChaosMeshChaosMeshApiV1alpha1AwsChaosList
     * @param githubComChaosMeshChaosMeshApiV1alpha1DNSChaosSpec
     * @param githubComChaosMeshChaosMeshApiV1alpha1NetworkChaosStatus
     * @param githubComChaosMeshChaosMeshApiV1alpha1Target
     * @param githubComChaosMeshChaosMeshApiV1alpha1IoChaosSpec
     * @param githubComChaosMeshChaosMeshApiV1alpha1LossSpec
     * @param githubComChaosMeshChaosMeshApiV1alpha1JVMChaosList
     * @param githubComChaosMeshChaosMeshApiV1alpha1PodChaos
     * @param githubComChaosMeshChaosMeshApiV1alpha1StressChaos
     * @param githubComChaosMeshChaosMeshApiV1alpha1PodIoChaos
     * @param githubComChaosMeshChaosMeshApiV1alpha1ScheduleStatus
     * @param githubComChaosMeshChaosMeshApiV1alpha1StressChaosList
     * @param githubComChaosMeshChaosMeshApiV1alpha1PodIoChaosSpec
     * @param githubComChaosMeshChaosMeshApiV1alpha1PodChaosStatus
     * @param githubComChaosMeshChaosMeshApiV1alpha1TimeChaosList
     * @param githubComChaosMeshChaosMeshApiV1alpha1AttrOverrideSpec
     * @param githubComChaosMeshChaosMeshApiV1alpha1CPUStressor
     * @param githubComChaosMeshChaosMeshApiV1alpha1NetworkChaosSpec
     * @param githubComChaosMeshChaosMeshApiV1alpha1AwsChaosSpec
     * @param githubComChaosMeshChaosMeshApiV1alpha1StressChaosSpec
     * @param githubComChaosMeshChaosMeshApiV1alpha1PodNetworkChaos
     * @param githubComChaosMeshChaosMeshApiV1alpha1HTTPChaos
     * @param githubComChaosMeshChaosMeshApiV1alpha1PodNetworkChaosStatus
     * @param githubComChaosMeshChaosMeshApiV1alpha1SelectorSpec
     * @param githubComChaosMeshChaosMeshApiV1alpha1DNSChaosList
     * @param githubComChaosMeshChaosMeshApiV1alpha1SchedulerSpec
     * @param githubComChaosMeshChaosMeshApiV1alpha1KernelChaosSpec
     */
    public ChaosmeshSchema(AttrOverrideSpec githubComChaosMeshChaosMeshApiV1alpha1AttrOverrideSpec, AwsChaos githubComChaosMeshChaosMeshApiV1alpha1AwsChaos, AwsChaosList githubComChaosMeshChaosMeshApiV1alpha1AwsChaosList, AwsChaosSpec githubComChaosMeshChaosMeshApiV1alpha1AwsChaosSpec, AwsChaosStatus githubComChaosMeshChaosMeshApiV1alpha1AwsChaosStatus, BandwidthSpec githubComChaosMeshChaosMeshApiV1alpha1BandwidthSpec, CPUStressor githubComChaosMeshChaosMeshApiV1alpha1CPUStressor, CorruptSpec githubComChaosMeshChaosMeshApiV1alpha1CorruptSpec, DNSChaos githubComChaosMeshChaosMeshApiV1alpha1DNSChaos, DNSChaosList githubComChaosMeshChaosMeshApiV1alpha1DNSChaosList, DNSChaosSpec githubComChaosMeshChaosMeshApiV1alpha1DNSChaosSpec, DNSChaosStatus githubComChaosMeshChaosMeshApiV1alpha1DNSChaosStatus, DelaySpec githubComChaosMeshChaosMeshApiV1alpha1DelaySpec, DuplicateSpec githubComChaosMeshChaosMeshApiV1alpha1DuplicateSpec, ExperimentStatus githubComChaosMeshChaosMeshApiV1alpha1ExperimentStatus, FailKernRequest githubComChaosMeshChaosMeshApiV1alpha1FailKernRequest, Frame githubComChaosMeshChaosMeshApiV1alpha1Frame, HTTPChaos githubComChaosMeshChaosMeshApiV1alpha1HTTPChaos, HTTPChaosList githubComChaosMeshChaosMeshApiV1alpha1HTTPChaosList, HTTPChaosSpec githubComChaosMeshChaosMeshApiV1alpha1HTTPChaosSpec, HTTPChaosStatus githubComChaosMeshChaosMeshApiV1alpha1HTTPChaosStatus, IoChaos githubComChaosMeshChaosMeshApiV1alpha1IoChaos, IoChaosAction githubComChaosMeshChaosMeshApiV1alpha1IoChaosAction, IoChaosList githubComChaosMeshChaosMeshApiV1alpha1IoChaosList, IoChaosSpec githubComChaosMeshChaosMeshApiV1alpha1IoChaosSpec, IoChaosStatus githubComChaosMeshChaosMeshApiV1alpha1IoChaosStatus, IoFault githubComChaosMeshChaosMeshApiV1alpha1IoFault, JVMChaos githubComChaosMeshChaosMeshApiV1alpha1JVMChaos, JVMChaosList githubComChaosMeshChaosMeshApiV1alpha1JVMChaosList, JVMChaosSpec githubComChaosMeshChaosMeshApiV1alpha1JVMChaosSpec, JVMChaosStatus githubComChaosMeshChaosMeshApiV1alpha1JVMChaosStatus, KernelChaos githubComChaosMeshChaosMeshApiV1alpha1KernelChaos, KernelChaosList githubComChaosMeshChaosMeshApiV1alpha1KernelChaosList, KernelChaosSpec githubComChaosMeshChaosMeshApiV1alpha1KernelChaosSpec, KernelChaosStatus githubComChaosMeshChaosMeshApiV1alpha1KernelChaosStatus, LossSpec githubComChaosMeshChaosMeshApiV1alpha1LossSpec, Matcher githubComChaosMeshChaosMeshApiV1alpha1Matcher, MemoryStressor githubComChaosMeshChaosMeshApiV1alpha1MemoryStressor, MistakeSpec githubComChaosMeshChaosMeshApiV1alpha1MistakeSpec, NetworkChaos githubComChaosMeshChaosMeshApiV1alpha1NetworkChaos, NetworkChaosList githubComChaosMeshChaosMeshApiV1alpha1NetworkChaosList, NetworkChaosSpec githubComChaosMeshChaosMeshApiV1alpha1NetworkChaosSpec, NetworkChaosStatus githubComChaosMeshChaosMeshApiV1alpha1NetworkChaosStatus, PodChaos githubComChaosMeshChaosMeshApiV1alpha1PodChaos, PodChaosList githubComChaosMeshChaosMeshApiV1alpha1PodChaosList, PodChaosSpec githubComChaosMeshChaosMeshApiV1alpha1PodChaosSpec, PodChaosStatus githubComChaosMeshChaosMeshApiV1alpha1PodChaosStatus, PodIoChaos githubComChaosMeshChaosMeshApiV1alpha1PodIoChaos, PodIoChaosList githubComChaosMeshChaosMeshApiV1alpha1PodIoChaosList, PodIoChaosSpec githubComChaosMeshChaosMeshApiV1alpha1PodIoChaosSpec, PodNetworkChaos githubComChaosMeshChaosMeshApiV1alpha1PodNetworkChaos, PodNetworkChaosList githubComChaosMeshChaosMeshApiV1alpha1PodNetworkChaosList, PodNetworkChaosSpec githubComChaosMeshChaosMeshApiV1alpha1PodNetworkChaosSpec, PodNetworkChaosStatus githubComChaosMeshChaosMeshApiV1alpha1PodNetworkChaosStatus, PodStatus githubComChaosMeshChaosMeshApiV1alpha1PodStatus, RawIPSet githubComChaosMeshChaosMeshApiV1alpha1RawIPSet, RawIptables githubComChaosMeshChaosMeshApiV1alpha1RawIptables, RawTrafficControl githubComChaosMeshChaosMeshApiV1alpha1RawTrafficControl, ReorderSpec githubComChaosMeshChaosMeshApiV1alpha1ReorderSpec, ScheduleStatus githubComChaosMeshChaosMeshApiV1alpha1ScheduleStatus, SchedulerSpec githubComChaosMeshChaosMeshApiV1alpha1SchedulerSpec, SelectorSpec githubComChaosMeshChaosMeshApiV1alpha1SelectorSpec, StressChaos githubComChaosMeshChaosMeshApiV1alpha1StressChaos, StressChaosList githubComChaosMeshChaosMeshApiV1alpha1StressChaosList, StressChaosSpec githubComChaosMeshChaosMeshApiV1alpha1StressChaosSpec, StressChaosStatus githubComChaosMeshChaosMeshApiV1alpha1StressChaosStatus, StressInstance githubComChaosMeshChaosMeshApiV1alpha1StressInstance, Stressors githubComChaosMeshChaosMeshApiV1alpha1Stressors, Target githubComChaosMeshChaosMeshApiV1alpha1Target, TimeChaos githubComChaosMeshChaosMeshApiV1alpha1TimeChaos, TimeChaosList githubComChaosMeshChaosMeshApiV1alpha1TimeChaosList, TimeChaosSpec githubComChaosMeshChaosMeshApiV1alpha1TimeChaosSpec, TimeChaosStatus githubComChaosMeshChaosMeshApiV1alpha1TimeChaosStatus, Timespec githubComChaosMeshChaosMeshApiV1alpha1Timespec) {
        super();
        this.githubComChaosMeshChaosMeshApiV1alpha1AttrOverrideSpec = githubComChaosMeshChaosMeshApiV1alpha1AttrOverrideSpec;
        this.githubComChaosMeshChaosMeshApiV1alpha1AwsChaos = githubComChaosMeshChaosMeshApiV1alpha1AwsChaos;
        this.githubComChaosMeshChaosMeshApiV1alpha1AwsChaosList = githubComChaosMeshChaosMeshApiV1alpha1AwsChaosList;
        this.githubComChaosMeshChaosMeshApiV1alpha1AwsChaosSpec = githubComChaosMeshChaosMeshApiV1alpha1AwsChaosSpec;
        this.githubComChaosMeshChaosMeshApiV1alpha1AwsChaosStatus = githubComChaosMeshChaosMeshApiV1alpha1AwsChaosStatus;
        this.githubComChaosMeshChaosMeshApiV1alpha1BandwidthSpec = githubComChaosMeshChaosMeshApiV1alpha1BandwidthSpec;
        this.githubComChaosMeshChaosMeshApiV1alpha1CPUStressor = githubComChaosMeshChaosMeshApiV1alpha1CPUStressor;
        this.githubComChaosMeshChaosMeshApiV1alpha1CorruptSpec = githubComChaosMeshChaosMeshApiV1alpha1CorruptSpec;
        this.githubComChaosMeshChaosMeshApiV1alpha1DNSChaos = githubComChaosMeshChaosMeshApiV1alpha1DNSChaos;
        this.githubComChaosMeshChaosMeshApiV1alpha1DNSChaosList = githubComChaosMeshChaosMeshApiV1alpha1DNSChaosList;
        this.githubComChaosMeshChaosMeshApiV1alpha1DNSChaosSpec = githubComChaosMeshChaosMeshApiV1alpha1DNSChaosSpec;
        this.githubComChaosMeshChaosMeshApiV1alpha1DNSChaosStatus = githubComChaosMeshChaosMeshApiV1alpha1DNSChaosStatus;
        this.githubComChaosMeshChaosMeshApiV1alpha1DelaySpec = githubComChaosMeshChaosMeshApiV1alpha1DelaySpec;
        this.githubComChaosMeshChaosMeshApiV1alpha1DuplicateSpec = githubComChaosMeshChaosMeshApiV1alpha1DuplicateSpec;
        this.githubComChaosMeshChaosMeshApiV1alpha1ExperimentStatus = githubComChaosMeshChaosMeshApiV1alpha1ExperimentStatus;
        this.githubComChaosMeshChaosMeshApiV1alpha1FailKernRequest = githubComChaosMeshChaosMeshApiV1alpha1FailKernRequest;
        this.githubComChaosMeshChaosMeshApiV1alpha1Frame = githubComChaosMeshChaosMeshApiV1alpha1Frame;
        this.githubComChaosMeshChaosMeshApiV1alpha1HTTPChaos = githubComChaosMeshChaosMeshApiV1alpha1HTTPChaos;
        this.githubComChaosMeshChaosMeshApiV1alpha1HTTPChaosList = githubComChaosMeshChaosMeshApiV1alpha1HTTPChaosList;
        this.githubComChaosMeshChaosMeshApiV1alpha1HTTPChaosSpec = githubComChaosMeshChaosMeshApiV1alpha1HTTPChaosSpec;
        this.githubComChaosMeshChaosMeshApiV1alpha1HTTPChaosStatus = githubComChaosMeshChaosMeshApiV1alpha1HTTPChaosStatus;
        this.githubComChaosMeshChaosMeshApiV1alpha1IoChaos = githubComChaosMeshChaosMeshApiV1alpha1IoChaos;
        this.githubComChaosMeshChaosMeshApiV1alpha1IoChaosAction = githubComChaosMeshChaosMeshApiV1alpha1IoChaosAction;
        this.githubComChaosMeshChaosMeshApiV1alpha1IoChaosList = githubComChaosMeshChaosMeshApiV1alpha1IoChaosList;
        this.githubComChaosMeshChaosMeshApiV1alpha1IoChaosSpec = githubComChaosMeshChaosMeshApiV1alpha1IoChaosSpec;
        this.githubComChaosMeshChaosMeshApiV1alpha1IoChaosStatus = githubComChaosMeshChaosMeshApiV1alpha1IoChaosStatus;
        this.githubComChaosMeshChaosMeshApiV1alpha1IoFault = githubComChaosMeshChaosMeshApiV1alpha1IoFault;
        this.githubComChaosMeshChaosMeshApiV1alpha1JVMChaos = githubComChaosMeshChaosMeshApiV1alpha1JVMChaos;
        this.githubComChaosMeshChaosMeshApiV1alpha1JVMChaosList = githubComChaosMeshChaosMeshApiV1alpha1JVMChaosList;
        this.githubComChaosMeshChaosMeshApiV1alpha1JVMChaosSpec = githubComChaosMeshChaosMeshApiV1alpha1JVMChaosSpec;
        this.githubComChaosMeshChaosMeshApiV1alpha1JVMChaosStatus = githubComChaosMeshChaosMeshApiV1alpha1JVMChaosStatus;
        this.githubComChaosMeshChaosMeshApiV1alpha1KernelChaos = githubComChaosMeshChaosMeshApiV1alpha1KernelChaos;
        this.githubComChaosMeshChaosMeshApiV1alpha1KernelChaosList = githubComChaosMeshChaosMeshApiV1alpha1KernelChaosList;
        this.githubComChaosMeshChaosMeshApiV1alpha1KernelChaosSpec = githubComChaosMeshChaosMeshApiV1alpha1KernelChaosSpec;
        this.githubComChaosMeshChaosMeshApiV1alpha1KernelChaosStatus = githubComChaosMeshChaosMeshApiV1alpha1KernelChaosStatus;
        this.githubComChaosMeshChaosMeshApiV1alpha1LossSpec = githubComChaosMeshChaosMeshApiV1alpha1LossSpec;
        this.githubComChaosMeshChaosMeshApiV1alpha1Matcher = githubComChaosMeshChaosMeshApiV1alpha1Matcher;
        this.githubComChaosMeshChaosMeshApiV1alpha1MemoryStressor = githubComChaosMeshChaosMeshApiV1alpha1MemoryStressor;
        this.githubComChaosMeshChaosMeshApiV1alpha1MistakeSpec = githubComChaosMeshChaosMeshApiV1alpha1MistakeSpec;
        this.githubComChaosMeshChaosMeshApiV1alpha1NetworkChaos = githubComChaosMeshChaosMeshApiV1alpha1NetworkChaos;
        this.githubComChaosMeshChaosMeshApiV1alpha1NetworkChaosList = githubComChaosMeshChaosMeshApiV1alpha1NetworkChaosList;
        this.githubComChaosMeshChaosMeshApiV1alpha1NetworkChaosSpec = githubComChaosMeshChaosMeshApiV1alpha1NetworkChaosSpec;
        this.githubComChaosMeshChaosMeshApiV1alpha1NetworkChaosStatus = githubComChaosMeshChaosMeshApiV1alpha1NetworkChaosStatus;
        this.githubComChaosMeshChaosMeshApiV1alpha1PodChaos = githubComChaosMeshChaosMeshApiV1alpha1PodChaos;
        this.githubComChaosMeshChaosMeshApiV1alpha1PodChaosList = githubComChaosMeshChaosMeshApiV1alpha1PodChaosList;
        this.githubComChaosMeshChaosMeshApiV1alpha1PodChaosSpec = githubComChaosMeshChaosMeshApiV1alpha1PodChaosSpec;
        this.githubComChaosMeshChaosMeshApiV1alpha1PodChaosStatus = githubComChaosMeshChaosMeshApiV1alpha1PodChaosStatus;
        this.githubComChaosMeshChaosMeshApiV1alpha1PodIoChaos = githubComChaosMeshChaosMeshApiV1alpha1PodIoChaos;
        this.githubComChaosMeshChaosMeshApiV1alpha1PodIoChaosList = githubComChaosMeshChaosMeshApiV1alpha1PodIoChaosList;
        this.githubComChaosMeshChaosMeshApiV1alpha1PodIoChaosSpec = githubComChaosMeshChaosMeshApiV1alpha1PodIoChaosSpec;
        this.githubComChaosMeshChaosMeshApiV1alpha1PodNetworkChaos = githubComChaosMeshChaosMeshApiV1alpha1PodNetworkChaos;
        this.githubComChaosMeshChaosMeshApiV1alpha1PodNetworkChaosList = githubComChaosMeshChaosMeshApiV1alpha1PodNetworkChaosList;
        this.githubComChaosMeshChaosMeshApiV1alpha1PodNetworkChaosSpec = githubComChaosMeshChaosMeshApiV1alpha1PodNetworkChaosSpec;
        this.githubComChaosMeshChaosMeshApiV1alpha1PodNetworkChaosStatus = githubComChaosMeshChaosMeshApiV1alpha1PodNetworkChaosStatus;
        this.githubComChaosMeshChaosMeshApiV1alpha1PodStatus = githubComChaosMeshChaosMeshApiV1alpha1PodStatus;
        this.githubComChaosMeshChaosMeshApiV1alpha1RawIPSet = githubComChaosMeshChaosMeshApiV1alpha1RawIPSet;
        this.githubComChaosMeshChaosMeshApiV1alpha1RawIptables = githubComChaosMeshChaosMeshApiV1alpha1RawIptables;
        this.githubComChaosMeshChaosMeshApiV1alpha1RawTrafficControl = githubComChaosMeshChaosMeshApiV1alpha1RawTrafficControl;
        this.githubComChaosMeshChaosMeshApiV1alpha1ReorderSpec = githubComChaosMeshChaosMeshApiV1alpha1ReorderSpec;
        this.githubComChaosMeshChaosMeshApiV1alpha1ScheduleStatus = githubComChaosMeshChaosMeshApiV1alpha1ScheduleStatus;
        this.githubComChaosMeshChaosMeshApiV1alpha1SchedulerSpec = githubComChaosMeshChaosMeshApiV1alpha1SchedulerSpec;
        this.githubComChaosMeshChaosMeshApiV1alpha1SelectorSpec = githubComChaosMeshChaosMeshApiV1alpha1SelectorSpec;
        this.githubComChaosMeshChaosMeshApiV1alpha1StressChaos = githubComChaosMeshChaosMeshApiV1alpha1StressChaos;
        this.githubComChaosMeshChaosMeshApiV1alpha1StressChaosList = githubComChaosMeshChaosMeshApiV1alpha1StressChaosList;
        this.githubComChaosMeshChaosMeshApiV1alpha1StressChaosSpec = githubComChaosMeshChaosMeshApiV1alpha1StressChaosSpec;
        this.githubComChaosMeshChaosMeshApiV1alpha1StressChaosStatus = githubComChaosMeshChaosMeshApiV1alpha1StressChaosStatus;
        this.githubComChaosMeshChaosMeshApiV1alpha1StressInstance = githubComChaosMeshChaosMeshApiV1alpha1StressInstance;
        this.githubComChaosMeshChaosMeshApiV1alpha1Stressors = githubComChaosMeshChaosMeshApiV1alpha1Stressors;
        this.githubComChaosMeshChaosMeshApiV1alpha1Target = githubComChaosMeshChaosMeshApiV1alpha1Target;
        this.githubComChaosMeshChaosMeshApiV1alpha1TimeChaos = githubComChaosMeshChaosMeshApiV1alpha1TimeChaos;
        this.githubComChaosMeshChaosMeshApiV1alpha1TimeChaosList = githubComChaosMeshChaosMeshApiV1alpha1TimeChaosList;
        this.githubComChaosMeshChaosMeshApiV1alpha1TimeChaosSpec = githubComChaosMeshChaosMeshApiV1alpha1TimeChaosSpec;
        this.githubComChaosMeshChaosMeshApiV1alpha1TimeChaosStatus = githubComChaosMeshChaosMeshApiV1alpha1TimeChaosStatus;
        this.githubComChaosMeshChaosMeshApiV1alpha1Timespec = githubComChaosMeshChaosMeshApiV1alpha1Timespec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_AttrOverrideSpec")
    public AttrOverrideSpec getGithubComChaosMeshChaosMeshApiV1alpha1AttrOverrideSpec() {
        return githubComChaosMeshChaosMeshApiV1alpha1AttrOverrideSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_AttrOverrideSpec")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1AttrOverrideSpec(AttrOverrideSpec githubComChaosMeshChaosMeshApiV1alpha1AttrOverrideSpec) {
        this.githubComChaosMeshChaosMeshApiV1alpha1AttrOverrideSpec = githubComChaosMeshChaosMeshApiV1alpha1AttrOverrideSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_AwsChaos")
    public AwsChaos getGithubComChaosMeshChaosMeshApiV1alpha1AwsChaos() {
        return githubComChaosMeshChaosMeshApiV1alpha1AwsChaos;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_AwsChaos")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1AwsChaos(AwsChaos githubComChaosMeshChaosMeshApiV1alpha1AwsChaos) {
        this.githubComChaosMeshChaosMeshApiV1alpha1AwsChaos = githubComChaosMeshChaosMeshApiV1alpha1AwsChaos;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_AwsChaosList")
    public AwsChaosList getGithubComChaosMeshChaosMeshApiV1alpha1AwsChaosList() {
        return githubComChaosMeshChaosMeshApiV1alpha1AwsChaosList;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_AwsChaosList")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1AwsChaosList(AwsChaosList githubComChaosMeshChaosMeshApiV1alpha1AwsChaosList) {
        this.githubComChaosMeshChaosMeshApiV1alpha1AwsChaosList = githubComChaosMeshChaosMeshApiV1alpha1AwsChaosList;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_AwsChaosSpec")
    public AwsChaosSpec getGithubComChaosMeshChaosMeshApiV1alpha1AwsChaosSpec() {
        return githubComChaosMeshChaosMeshApiV1alpha1AwsChaosSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_AwsChaosSpec")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1AwsChaosSpec(AwsChaosSpec githubComChaosMeshChaosMeshApiV1alpha1AwsChaosSpec) {
        this.githubComChaosMeshChaosMeshApiV1alpha1AwsChaosSpec = githubComChaosMeshChaosMeshApiV1alpha1AwsChaosSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_AwsChaosStatus")
    public AwsChaosStatus getGithubComChaosMeshChaosMeshApiV1alpha1AwsChaosStatus() {
        return githubComChaosMeshChaosMeshApiV1alpha1AwsChaosStatus;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_AwsChaosStatus")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1AwsChaosStatus(AwsChaosStatus githubComChaosMeshChaosMeshApiV1alpha1AwsChaosStatus) {
        this.githubComChaosMeshChaosMeshApiV1alpha1AwsChaosStatus = githubComChaosMeshChaosMeshApiV1alpha1AwsChaosStatus;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_BandwidthSpec")
    public BandwidthSpec getGithubComChaosMeshChaosMeshApiV1alpha1BandwidthSpec() {
        return githubComChaosMeshChaosMeshApiV1alpha1BandwidthSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_BandwidthSpec")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1BandwidthSpec(BandwidthSpec githubComChaosMeshChaosMeshApiV1alpha1BandwidthSpec) {
        this.githubComChaosMeshChaosMeshApiV1alpha1BandwidthSpec = githubComChaosMeshChaosMeshApiV1alpha1BandwidthSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_CPUStressor")
    public CPUStressor getGithubComChaosMeshChaosMeshApiV1alpha1CPUStressor() {
        return githubComChaosMeshChaosMeshApiV1alpha1CPUStressor;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_CPUStressor")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1CPUStressor(CPUStressor githubComChaosMeshChaosMeshApiV1alpha1CPUStressor) {
        this.githubComChaosMeshChaosMeshApiV1alpha1CPUStressor = githubComChaosMeshChaosMeshApiV1alpha1CPUStressor;
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

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_IoChaos")
    public IoChaos getGithubComChaosMeshChaosMeshApiV1alpha1IoChaos() {
        return githubComChaosMeshChaosMeshApiV1alpha1IoChaos;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_IoChaos")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1IoChaos(IoChaos githubComChaosMeshChaosMeshApiV1alpha1IoChaos) {
        this.githubComChaosMeshChaosMeshApiV1alpha1IoChaos = githubComChaosMeshChaosMeshApiV1alpha1IoChaos;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_IoChaosAction")
    public IoChaosAction getGithubComChaosMeshChaosMeshApiV1alpha1IoChaosAction() {
        return githubComChaosMeshChaosMeshApiV1alpha1IoChaosAction;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_IoChaosAction")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1IoChaosAction(IoChaosAction githubComChaosMeshChaosMeshApiV1alpha1IoChaosAction) {
        this.githubComChaosMeshChaosMeshApiV1alpha1IoChaosAction = githubComChaosMeshChaosMeshApiV1alpha1IoChaosAction;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_IoChaosList")
    public IoChaosList getGithubComChaosMeshChaosMeshApiV1alpha1IoChaosList() {
        return githubComChaosMeshChaosMeshApiV1alpha1IoChaosList;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_IoChaosList")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1IoChaosList(IoChaosList githubComChaosMeshChaosMeshApiV1alpha1IoChaosList) {
        this.githubComChaosMeshChaosMeshApiV1alpha1IoChaosList = githubComChaosMeshChaosMeshApiV1alpha1IoChaosList;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_IoChaosSpec")
    public IoChaosSpec getGithubComChaosMeshChaosMeshApiV1alpha1IoChaosSpec() {
        return githubComChaosMeshChaosMeshApiV1alpha1IoChaosSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_IoChaosSpec")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1IoChaosSpec(IoChaosSpec githubComChaosMeshChaosMeshApiV1alpha1IoChaosSpec) {
        this.githubComChaosMeshChaosMeshApiV1alpha1IoChaosSpec = githubComChaosMeshChaosMeshApiV1alpha1IoChaosSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_IoChaosStatus")
    public IoChaosStatus getGithubComChaosMeshChaosMeshApiV1alpha1IoChaosStatus() {
        return githubComChaosMeshChaosMeshApiV1alpha1IoChaosStatus;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_IoChaosStatus")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1IoChaosStatus(IoChaosStatus githubComChaosMeshChaosMeshApiV1alpha1IoChaosStatus) {
        this.githubComChaosMeshChaosMeshApiV1alpha1IoChaosStatus = githubComChaosMeshChaosMeshApiV1alpha1IoChaosStatus;
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

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_Matcher")
    public Matcher getGithubComChaosMeshChaosMeshApiV1alpha1Matcher() {
        return githubComChaosMeshChaosMeshApiV1alpha1Matcher;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_Matcher")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1Matcher(Matcher githubComChaosMeshChaosMeshApiV1alpha1Matcher) {
        this.githubComChaosMeshChaosMeshApiV1alpha1Matcher = githubComChaosMeshChaosMeshApiV1alpha1Matcher;
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

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodIoChaos")
    public PodIoChaos getGithubComChaosMeshChaosMeshApiV1alpha1PodIoChaos() {
        return githubComChaosMeshChaosMeshApiV1alpha1PodIoChaos;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodIoChaos")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1PodIoChaos(PodIoChaos githubComChaosMeshChaosMeshApiV1alpha1PodIoChaos) {
        this.githubComChaosMeshChaosMeshApiV1alpha1PodIoChaos = githubComChaosMeshChaosMeshApiV1alpha1PodIoChaos;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodIoChaosList")
    public PodIoChaosList getGithubComChaosMeshChaosMeshApiV1alpha1PodIoChaosList() {
        return githubComChaosMeshChaosMeshApiV1alpha1PodIoChaosList;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodIoChaosList")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1PodIoChaosList(PodIoChaosList githubComChaosMeshChaosMeshApiV1alpha1PodIoChaosList) {
        this.githubComChaosMeshChaosMeshApiV1alpha1PodIoChaosList = githubComChaosMeshChaosMeshApiV1alpha1PodIoChaosList;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodIoChaosSpec")
    public PodIoChaosSpec getGithubComChaosMeshChaosMeshApiV1alpha1PodIoChaosSpec() {
        return githubComChaosMeshChaosMeshApiV1alpha1PodIoChaosSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodIoChaosSpec")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1PodIoChaosSpec(PodIoChaosSpec githubComChaosMeshChaosMeshApiV1alpha1PodIoChaosSpec) {
        this.githubComChaosMeshChaosMeshApiV1alpha1PodIoChaosSpec = githubComChaosMeshChaosMeshApiV1alpha1PodIoChaosSpec;
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

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodStatus")
    public PodStatus getGithubComChaosMeshChaosMeshApiV1alpha1PodStatus() {
        return githubComChaosMeshChaosMeshApiV1alpha1PodStatus;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_PodStatus")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1PodStatus(PodStatus githubComChaosMeshChaosMeshApiV1alpha1PodStatus) {
        this.githubComChaosMeshChaosMeshApiV1alpha1PodStatus = githubComChaosMeshChaosMeshApiV1alpha1PodStatus;
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

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_ReorderSpec")
    public ReorderSpec getGithubComChaosMeshChaosMeshApiV1alpha1ReorderSpec() {
        return githubComChaosMeshChaosMeshApiV1alpha1ReorderSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_ReorderSpec")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1ReorderSpec(ReorderSpec githubComChaosMeshChaosMeshApiV1alpha1ReorderSpec) {
        this.githubComChaosMeshChaosMeshApiV1alpha1ReorderSpec = githubComChaosMeshChaosMeshApiV1alpha1ReorderSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_ScheduleStatus")
    public ScheduleStatus getGithubComChaosMeshChaosMeshApiV1alpha1ScheduleStatus() {
        return githubComChaosMeshChaosMeshApiV1alpha1ScheduleStatus;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_ScheduleStatus")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1ScheduleStatus(ScheduleStatus githubComChaosMeshChaosMeshApiV1alpha1ScheduleStatus) {
        this.githubComChaosMeshChaosMeshApiV1alpha1ScheduleStatus = githubComChaosMeshChaosMeshApiV1alpha1ScheduleStatus;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_SchedulerSpec")
    public SchedulerSpec getGithubComChaosMeshChaosMeshApiV1alpha1SchedulerSpec() {
        return githubComChaosMeshChaosMeshApiV1alpha1SchedulerSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_SchedulerSpec")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1SchedulerSpec(SchedulerSpec githubComChaosMeshChaosMeshApiV1alpha1SchedulerSpec) {
        this.githubComChaosMeshChaosMeshApiV1alpha1SchedulerSpec = githubComChaosMeshChaosMeshApiV1alpha1SchedulerSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_SelectorSpec")
    public SelectorSpec getGithubComChaosMeshChaosMeshApiV1alpha1SelectorSpec() {
        return githubComChaosMeshChaosMeshApiV1alpha1SelectorSpec;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_SelectorSpec")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1SelectorSpec(SelectorSpec githubComChaosMeshChaosMeshApiV1alpha1SelectorSpec) {
        this.githubComChaosMeshChaosMeshApiV1alpha1SelectorSpec = githubComChaosMeshChaosMeshApiV1alpha1SelectorSpec;
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

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_Stressors")
    public Stressors getGithubComChaosMeshChaosMeshApiV1alpha1Stressors() {
        return githubComChaosMeshChaosMeshApiV1alpha1Stressors;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_Stressors")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1Stressors(Stressors githubComChaosMeshChaosMeshApiV1alpha1Stressors) {
        this.githubComChaosMeshChaosMeshApiV1alpha1Stressors = githubComChaosMeshChaosMeshApiV1alpha1Stressors;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_Target")
    public Target getGithubComChaosMeshChaosMeshApiV1alpha1Target() {
        return githubComChaosMeshChaosMeshApiV1alpha1Target;
    }

    @JsonProperty("github_com_chaos-mesh_chaos-mesh_api_v1alpha1_Target")
    public void setGithubComChaosMeshChaosMeshApiV1alpha1Target(Target githubComChaosMeshChaosMeshApiV1alpha1Target) {
        this.githubComChaosMeshChaosMeshApiV1alpha1Target = githubComChaosMeshChaosMeshApiV1alpha1Target;
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
