
package io.fabric8.chaosmesh.v1alpha1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.builder.Editable;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "abortWithStatusCheck",
    "awsChaos",
    "azureChaos",
    "blockChaos",
    "children",
    "conditionalBranches",
    "deadline",
    "dnsChaos",
    "gcpChaos",
    "httpChaos",
    "ioChaos",
    "jvmChaos",
    "kernelChaos",
    "networkChaos",
    "physicalmachineChaos",
    "podChaos",
    "schedule",
    "startTime",
    "statusCheck",
    "stressChaos",
    "task",
    "templateName",
    "timeChaos",
    "type",
    "workflowName"
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
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class WorkflowNodeSpec implements Editable<WorkflowNodeSpecBuilder>, KubernetesResource
{

    @JsonProperty("abortWithStatusCheck")
    private Boolean abortWithStatusCheck;
    @JsonProperty("awsChaos")
    private AWSChaosSpec awsChaos;
    @JsonProperty("azureChaos")
    private AzureChaosSpec azureChaos;
    @JsonProperty("blockChaos")
    private BlockChaosSpec blockChaos;
    @JsonProperty("children")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> children = new ArrayList<>();
    @JsonProperty("conditionalBranches")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ConditionalBranch> conditionalBranches = new ArrayList<>();
    @JsonProperty("deadline")
    private String deadline;
    @JsonProperty("dnsChaos")
    private DNSChaosSpec dnsChaos;
    @JsonProperty("gcpChaos")
    private GCPChaosSpec gcpChaos;
    @JsonProperty("httpChaos")
    private HTTPChaosSpec httpChaos;
    @JsonProperty("ioChaos")
    private IOChaosSpec ioChaos;
    @JsonProperty("jvmChaos")
    private JVMChaosSpec jvmChaos;
    @JsonProperty("kernelChaos")
    private KernelChaosSpec kernelChaos;
    @JsonProperty("networkChaos")
    private NetworkChaosSpec networkChaos;
    @JsonProperty("physicalmachineChaos")
    private PhysicalMachineChaosSpec physicalmachineChaos;
    @JsonProperty("podChaos")
    private PodChaosSpec podChaos;
    @JsonProperty("schedule")
    private ScheduleSpec schedule;
    @JsonProperty("startTime")
    private String startTime;
    @JsonProperty("statusCheck")
    private StatusCheckSpec statusCheck;
    @JsonProperty("stressChaos")
    private StressChaosSpec stressChaos;
    @JsonProperty("task")
    private Task task;
    @JsonProperty("templateName")
    private String templateName;
    @JsonProperty("timeChaos")
    private TimeChaosSpec timeChaos;
    @JsonProperty("type")
    private String type;
    @JsonProperty("workflowName")
    private String workflowName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public WorkflowNodeSpec() {
    }

    public WorkflowNodeSpec(Boolean abortWithStatusCheck, AWSChaosSpec awsChaos, AzureChaosSpec azureChaos, BlockChaosSpec blockChaos, List<String> children, List<ConditionalBranch> conditionalBranches, String deadline, DNSChaosSpec dnsChaos, GCPChaosSpec gcpChaos, HTTPChaosSpec httpChaos, IOChaosSpec ioChaos, JVMChaosSpec jvmChaos, KernelChaosSpec kernelChaos, NetworkChaosSpec networkChaos, PhysicalMachineChaosSpec physicalmachineChaos, PodChaosSpec podChaos, ScheduleSpec schedule, String startTime, StatusCheckSpec statusCheck, StressChaosSpec stressChaos, Task task, String templateName, TimeChaosSpec timeChaos, String type, String workflowName) {
        super();
        this.abortWithStatusCheck = abortWithStatusCheck;
        this.awsChaos = awsChaos;
        this.azureChaos = azureChaos;
        this.blockChaos = blockChaos;
        this.children = children;
        this.conditionalBranches = conditionalBranches;
        this.deadline = deadline;
        this.dnsChaos = dnsChaos;
        this.gcpChaos = gcpChaos;
        this.httpChaos = httpChaos;
        this.ioChaos = ioChaos;
        this.jvmChaos = jvmChaos;
        this.kernelChaos = kernelChaos;
        this.networkChaos = networkChaos;
        this.physicalmachineChaos = physicalmachineChaos;
        this.podChaos = podChaos;
        this.schedule = schedule;
        this.startTime = startTime;
        this.statusCheck = statusCheck;
        this.stressChaos = stressChaos;
        this.task = task;
        this.templateName = templateName;
        this.timeChaos = timeChaos;
        this.type = type;
        this.workflowName = workflowName;
    }

    /**
     * AbortWithStatusCheck describe whether to abort the workflow when the failure threshold of StatusCheck is exceeded. Only used when Type is TypeStatusCheck.
     */
    @JsonProperty("abortWithStatusCheck")
    public Boolean getAbortWithStatusCheck() {
        return abortWithStatusCheck;
    }

    /**
     * AbortWithStatusCheck describe whether to abort the workflow when the failure threshold of StatusCheck is exceeded. Only used when Type is TypeStatusCheck.
     */
    @JsonProperty("abortWithStatusCheck")
    public void setAbortWithStatusCheck(Boolean abortWithStatusCheck) {
        this.abortWithStatusCheck = abortWithStatusCheck;
    }

    @JsonProperty("awsChaos")
    public AWSChaosSpec getAwsChaos() {
        return awsChaos;
    }

    @JsonProperty("awsChaos")
    public void setAwsChaos(AWSChaosSpec awsChaos) {
        this.awsChaos = awsChaos;
    }

    @JsonProperty("azureChaos")
    public AzureChaosSpec getAzureChaos() {
        return azureChaos;
    }

    @JsonProperty("azureChaos")
    public void setAzureChaos(AzureChaosSpec azureChaos) {
        this.azureChaos = azureChaos;
    }

    @JsonProperty("blockChaos")
    public BlockChaosSpec getBlockChaos() {
        return blockChaos;
    }

    @JsonProperty("blockChaos")
    public void setBlockChaos(BlockChaosSpec blockChaos) {
        this.blockChaos = blockChaos;
    }

    @JsonProperty("children")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getChildren() {
        return children;
    }

    @JsonProperty("children")
    public void setChildren(List<String> children) {
        this.children = children;
    }

    @JsonProperty("conditionalBranches")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ConditionalBranch> getConditionalBranches() {
        return conditionalBranches;
    }

    @JsonProperty("conditionalBranches")
    public void setConditionalBranches(List<ConditionalBranch> conditionalBranches) {
        this.conditionalBranches = conditionalBranches;
    }

    @JsonProperty("deadline")
    public String getDeadline() {
        return deadline;
    }

    @JsonProperty("deadline")
    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    @JsonProperty("dnsChaos")
    public DNSChaosSpec getDnsChaos() {
        return dnsChaos;
    }

    @JsonProperty("dnsChaos")
    public void setDnsChaos(DNSChaosSpec dnsChaos) {
        this.dnsChaos = dnsChaos;
    }

    @JsonProperty("gcpChaos")
    public GCPChaosSpec getGcpChaos() {
        return gcpChaos;
    }

    @JsonProperty("gcpChaos")
    public void setGcpChaos(GCPChaosSpec gcpChaos) {
        this.gcpChaos = gcpChaos;
    }

    @JsonProperty("httpChaos")
    public HTTPChaosSpec getHttpChaos() {
        return httpChaos;
    }

    @JsonProperty("httpChaos")
    public void setHttpChaos(HTTPChaosSpec httpChaos) {
        this.httpChaos = httpChaos;
    }

    @JsonProperty("ioChaos")
    public IOChaosSpec getIoChaos() {
        return ioChaos;
    }

    @JsonProperty("ioChaos")
    public void setIoChaos(IOChaosSpec ioChaos) {
        this.ioChaos = ioChaos;
    }

    @JsonProperty("jvmChaos")
    public JVMChaosSpec getJvmChaos() {
        return jvmChaos;
    }

    @JsonProperty("jvmChaos")
    public void setJvmChaos(JVMChaosSpec jvmChaos) {
        this.jvmChaos = jvmChaos;
    }

    @JsonProperty("kernelChaos")
    public KernelChaosSpec getKernelChaos() {
        return kernelChaos;
    }

    @JsonProperty("kernelChaos")
    public void setKernelChaos(KernelChaosSpec kernelChaos) {
        this.kernelChaos = kernelChaos;
    }

    @JsonProperty("networkChaos")
    public NetworkChaosSpec getNetworkChaos() {
        return networkChaos;
    }

    @JsonProperty("networkChaos")
    public void setNetworkChaos(NetworkChaosSpec networkChaos) {
        this.networkChaos = networkChaos;
    }

    @JsonProperty("physicalmachineChaos")
    public PhysicalMachineChaosSpec getPhysicalmachineChaos() {
        return physicalmachineChaos;
    }

    @JsonProperty("physicalmachineChaos")
    public void setPhysicalmachineChaos(PhysicalMachineChaosSpec physicalmachineChaos) {
        this.physicalmachineChaos = physicalmachineChaos;
    }

    @JsonProperty("podChaos")
    public PodChaosSpec getPodChaos() {
        return podChaos;
    }

    @JsonProperty("podChaos")
    public void setPodChaos(PodChaosSpec podChaos) {
        this.podChaos = podChaos;
    }

    @JsonProperty("schedule")
    public ScheduleSpec getSchedule() {
        return schedule;
    }

    @JsonProperty("schedule")
    public void setSchedule(ScheduleSpec schedule) {
        this.schedule = schedule;
    }

    @JsonProperty("startTime")
    public String getStartTime() {
        return startTime;
    }

    @JsonProperty("startTime")
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    @JsonProperty("statusCheck")
    public StatusCheckSpec getStatusCheck() {
        return statusCheck;
    }

    @JsonProperty("statusCheck")
    public void setStatusCheck(StatusCheckSpec statusCheck) {
        this.statusCheck = statusCheck;
    }

    @JsonProperty("stressChaos")
    public StressChaosSpec getStressChaos() {
        return stressChaos;
    }

    @JsonProperty("stressChaos")
    public void setStressChaos(StressChaosSpec stressChaos) {
        this.stressChaos = stressChaos;
    }

    @JsonProperty("task")
    public Task getTask() {
        return task;
    }

    @JsonProperty("task")
    public void setTask(Task task) {
        this.task = task;
    }

    @JsonProperty("templateName")
    public String getTemplateName() {
        return templateName;
    }

    @JsonProperty("templateName")
    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    @JsonProperty("timeChaos")
    public TimeChaosSpec getTimeChaos() {
        return timeChaos;
    }

    @JsonProperty("timeChaos")
    public void setTimeChaos(TimeChaosSpec timeChaos) {
        this.timeChaos = timeChaos;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("workflowName")
    public String getWorkflowName() {
        return workflowName;
    }

    @JsonProperty("workflowName")
    public void setWorkflowName(String workflowName) {
        this.workflowName = workflowName;
    }

    @JsonIgnore
    public WorkflowNodeSpecBuilder edit() {
        return new WorkflowNodeSpecBuilder(this);
    }

    @JsonIgnore
    public WorkflowNodeSpecBuilder toBuilder() {
        return edit();
    }

    @JsonAnyGetter
    @JsonIgnore
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof WorkflowNodeSpec)) {
            return false;
        }
        WorkflowNodeSpec other = (WorkflowNodeSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$abortWithStatusCheck = this.getAbortWithStatusCheck();
        Object other$abortWithStatusCheck = other.getAbortWithStatusCheck();
        if (this$abortWithStatusCheck == null ? other$abortWithStatusCheck != null : !this$abortWithStatusCheck.equals(other$abortWithStatusCheck)) {
            return false;
        }
        Object this$awsChaos = this.getAwsChaos();
        Object other$awsChaos = other.getAwsChaos();
        if (this$awsChaos == null ? other$awsChaos != null : !this$awsChaos.equals(other$awsChaos)) {
            return false;
        }
        Object this$azureChaos = this.getAzureChaos();
        Object other$azureChaos = other.getAzureChaos();
        if (this$azureChaos == null ? other$azureChaos != null : !this$azureChaos.equals(other$azureChaos)) {
            return false;
        }
        Object this$blockChaos = this.getBlockChaos();
        Object other$blockChaos = other.getBlockChaos();
        if (this$blockChaos == null ? other$blockChaos != null : !this$blockChaos.equals(other$blockChaos)) {
            return false;
        }
        Object this$children = this.getChildren();
        Object other$children = other.getChildren();
        if (this$children == null ? other$children != null : !this$children.equals(other$children)) {
            return false;
        }
        Object this$conditionalBranches = this.getConditionalBranches();
        Object other$conditionalBranches = other.getConditionalBranches();
        if (this$conditionalBranches == null ? other$conditionalBranches != null : !this$conditionalBranches.equals(other$conditionalBranches)) {
            return false;
        }
        Object this$deadline = this.getDeadline();
        Object other$deadline = other.getDeadline();
        if (this$deadline == null ? other$deadline != null : !this$deadline.equals(other$deadline)) {
            return false;
        }
        Object this$dnsChaos = this.getDnsChaos();
        Object other$dnsChaos = other.getDnsChaos();
        if (this$dnsChaos == null ? other$dnsChaos != null : !this$dnsChaos.equals(other$dnsChaos)) {
            return false;
        }
        Object this$gcpChaos = this.getGcpChaos();
        Object other$gcpChaos = other.getGcpChaos();
        if (this$gcpChaos == null ? other$gcpChaos != null : !this$gcpChaos.equals(other$gcpChaos)) {
            return false;
        }
        Object this$httpChaos = this.getHttpChaos();
        Object other$httpChaos = other.getHttpChaos();
        if (this$httpChaos == null ? other$httpChaos != null : !this$httpChaos.equals(other$httpChaos)) {
            return false;
        }
        Object this$ioChaos = this.getIoChaos();
        Object other$ioChaos = other.getIoChaos();
        if (this$ioChaos == null ? other$ioChaos != null : !this$ioChaos.equals(other$ioChaos)) {
            return false;
        }
        Object this$jvmChaos = this.getJvmChaos();
        Object other$jvmChaos = other.getJvmChaos();
        if (this$jvmChaos == null ? other$jvmChaos != null : !this$jvmChaos.equals(other$jvmChaos)) {
            return false;
        }
        Object this$kernelChaos = this.getKernelChaos();
        Object other$kernelChaos = other.getKernelChaos();
        if (this$kernelChaos == null ? other$kernelChaos != null : !this$kernelChaos.equals(other$kernelChaos)) {
            return false;
        }
        Object this$networkChaos = this.getNetworkChaos();
        Object other$networkChaos = other.getNetworkChaos();
        if (this$networkChaos == null ? other$networkChaos != null : !this$networkChaos.equals(other$networkChaos)) {
            return false;
        }
        Object this$physicalmachineChaos = this.getPhysicalmachineChaos();
        Object other$physicalmachineChaos = other.getPhysicalmachineChaos();
        if (this$physicalmachineChaos == null ? other$physicalmachineChaos != null : !this$physicalmachineChaos.equals(other$physicalmachineChaos)) {
            return false;
        }
        Object this$podChaos = this.getPodChaos();
        Object other$podChaos = other.getPodChaos();
        if (this$podChaos == null ? other$podChaos != null : !this$podChaos.equals(other$podChaos)) {
            return false;
        }
        Object this$schedule = this.getSchedule();
        Object other$schedule = other.getSchedule();
        if (this$schedule == null ? other$schedule != null : !this$schedule.equals(other$schedule)) {
            return false;
        }
        Object this$startTime = this.getStartTime();
        Object other$startTime = other.getStartTime();
        if (this$startTime == null ? other$startTime != null : !this$startTime.equals(other$startTime)) {
            return false;
        }
        Object this$statusCheck = this.getStatusCheck();
        Object other$statusCheck = other.getStatusCheck();
        if (this$statusCheck == null ? other$statusCheck != null : !this$statusCheck.equals(other$statusCheck)) {
            return false;
        }
        Object this$stressChaos = this.getStressChaos();
        Object other$stressChaos = other.getStressChaos();
        if (this$stressChaos == null ? other$stressChaos != null : !this$stressChaos.equals(other$stressChaos)) {
            return false;
        }
        Object this$task = this.getTask();
        Object other$task = other.getTask();
        if (this$task == null ? other$task != null : !this$task.equals(other$task)) {
            return false;
        }
        Object this$templateName = this.getTemplateName();
        Object other$templateName = other.getTemplateName();
        if (this$templateName == null ? other$templateName != null : !this$templateName.equals(other$templateName)) {
            return false;
        }
        Object this$timeChaos = this.getTimeChaos();
        Object other$timeChaos = other.getTimeChaos();
        if (this$timeChaos == null ? other$timeChaos != null : !this$timeChaos.equals(other$timeChaos)) {
            return false;
        }
        Object this$type = this.getType();
        Object other$type = other.getType();
        if (this$type == null ? other$type != null : !this$type.equals(other$type)) {
            return false;
        }
        Object this$workflowName = this.getWorkflowName();
        Object other$workflowName = other.getWorkflowName();
        if (this$workflowName == null ? other$workflowName != null : !this$workflowName.equals(other$workflowName)) {
            return false;
        }
        Object this$additionalProperties = this.getAdditionalProperties();
        Object other$additionalProperties = other.getAdditionalProperties();
        if (this$additionalProperties == null ? other$additionalProperties != null : !this$additionalProperties.equals(other$additionalProperties)) {
            return false;
        }
        return true;
    }

    protected boolean canEqual(Object other) {
        return other instanceof WorkflowNodeSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $abortWithStatusCheck = this.getAbortWithStatusCheck();
        result = result * prime + ($abortWithStatusCheck == null ? 43 : $abortWithStatusCheck.hashCode());
        Object $awsChaos = this.getAwsChaos();
        result = result * prime + ($awsChaos == null ? 43 : $awsChaos.hashCode());
        Object $azureChaos = this.getAzureChaos();
        result = result * prime + ($azureChaos == null ? 43 : $azureChaos.hashCode());
        Object $blockChaos = this.getBlockChaos();
        result = result * prime + ($blockChaos == null ? 43 : $blockChaos.hashCode());
        Object $children = this.getChildren();
        result = result * prime + ($children == null ? 43 : $children.hashCode());
        Object $conditionalBranches = this.getConditionalBranches();
        result = result * prime + ($conditionalBranches == null ? 43 : $conditionalBranches.hashCode());
        Object $deadline = this.getDeadline();
        result = result * prime + ($deadline == null ? 43 : $deadline.hashCode());
        Object $dnsChaos = this.getDnsChaos();
        result = result * prime + ($dnsChaos == null ? 43 : $dnsChaos.hashCode());
        Object $gcpChaos = this.getGcpChaos();
        result = result * prime + ($gcpChaos == null ? 43 : $gcpChaos.hashCode());
        Object $httpChaos = this.getHttpChaos();
        result = result * prime + ($httpChaos == null ? 43 : $httpChaos.hashCode());
        Object $ioChaos = this.getIoChaos();
        result = result * prime + ($ioChaos == null ? 43 : $ioChaos.hashCode());
        Object $jvmChaos = this.getJvmChaos();
        result = result * prime + ($jvmChaos == null ? 43 : $jvmChaos.hashCode());
        Object $kernelChaos = this.getKernelChaos();
        result = result * prime + ($kernelChaos == null ? 43 : $kernelChaos.hashCode());
        Object $networkChaos = this.getNetworkChaos();
        result = result * prime + ($networkChaos == null ? 43 : $networkChaos.hashCode());
        Object $physicalmachineChaos = this.getPhysicalmachineChaos();
        result = result * prime + ($physicalmachineChaos == null ? 43 : $physicalmachineChaos.hashCode());
        Object $podChaos = this.getPodChaos();
        result = result * prime + ($podChaos == null ? 43 : $podChaos.hashCode());
        Object $schedule = this.getSchedule();
        result = result * prime + ($schedule == null ? 43 : $schedule.hashCode());
        Object $startTime = this.getStartTime();
        result = result * prime + ($startTime == null ? 43 : $startTime.hashCode());
        Object $statusCheck = this.getStatusCheck();
        result = result * prime + ($statusCheck == null ? 43 : $statusCheck.hashCode());
        Object $stressChaos = this.getStressChaos();
        result = result * prime + ($stressChaos == null ? 43 : $stressChaos.hashCode());
        Object $task = this.getTask();
        result = result * prime + ($task == null ? 43 : $task.hashCode());
        Object $templateName = this.getTemplateName();
        result = result * prime + ($templateName == null ? 43 : $templateName.hashCode());
        Object $timeChaos = this.getTimeChaos();
        result = result * prime + ($timeChaos == null ? 43 : $timeChaos.hashCode());
        Object $type = this.getType();
        result = result * prime + ($type == null ? 43 : $type.hashCode());
        Object $workflowName = this.getWorkflowName();
        result = result * prime + ($workflowName == null ? 43 : $workflowName.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "WorkflowNodeSpec(" + "abortWithStatusCheck=" + this.getAbortWithStatusCheck() + ", awsChaos=" + this.getAwsChaos() + ", azureChaos=" + this.getAzureChaos() + ", blockChaos=" + this.getBlockChaos() + ", children=" + this.getChildren() + ", conditionalBranches=" + this.getConditionalBranches() + ", deadline=" + this.getDeadline() + ", dnsChaos=" + this.getDnsChaos() + ", gcpChaos=" + this.getGcpChaos() + ", httpChaos=" + this.getHttpChaos() + ", ioChaos=" + this.getIoChaos() + ", jvmChaos=" + this.getJvmChaos() + ", kernelChaos=" + this.getKernelChaos() + ", networkChaos=" + this.getNetworkChaos() + ", physicalmachineChaos=" + this.getPhysicalmachineChaos() + ", podChaos=" + this.getPodChaos() + ", schedule=" + this.getSchedule() + ", startTime=" + this.getStartTime() + ", statusCheck=" + this.getStatusCheck() + ", stressChaos=" + this.getStressChaos() + ", task=" + this.getTask() + ", templateName=" + this.getTemplateName() + ", timeChaos=" + this.getTimeChaos() + ", type=" + this.getType() + ", workflowName=" + this.getWorkflowName() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
