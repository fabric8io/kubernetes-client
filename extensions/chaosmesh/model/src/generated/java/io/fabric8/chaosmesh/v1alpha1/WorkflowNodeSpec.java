
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

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
@ToString
@EqualsAndHashCode
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

}
