
package io.fabric8.chaosmesh.v1alpha1;

import java.util.LinkedHashMap;
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

/**
 * ScheduleSpec is the specification of a schedule object
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "awsChaos",
    "azureChaos",
    "blockChaos",
    "concurrencyPolicy",
    "dnsChaos",
    "gcpChaos",
    "historyLimit",
    "httpChaos",
    "ioChaos",
    "jvmChaos",
    "kernelChaos",
    "networkChaos",
    "physicalmachineChaos",
    "podChaos",
    "schedule",
    "startingDeadlineSeconds",
    "stressChaos",
    "timeChaos",
    "type",
    "workflow"
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
public class ScheduleSpec implements Editable<ScheduleSpecBuilder>, KubernetesResource
{

    @JsonProperty("awsChaos")
    private AWSChaosSpec awsChaos;
    @JsonProperty("azureChaos")
    private AzureChaosSpec azureChaos;
    @JsonProperty("blockChaos")
    private BlockChaosSpec blockChaos;
    @JsonProperty("concurrencyPolicy")
    private String concurrencyPolicy;
    @JsonProperty("dnsChaos")
    private DNSChaosSpec dnsChaos;
    @JsonProperty("gcpChaos")
    private GCPChaosSpec gcpChaos;
    @JsonProperty("historyLimit")
    private Integer historyLimit;
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
    private String schedule;
    @JsonProperty("startingDeadlineSeconds")
    private Long startingDeadlineSeconds;
    @JsonProperty("stressChaos")
    private StressChaosSpec stressChaos;
    @JsonProperty("timeChaos")
    private TimeChaosSpec timeChaos;
    @JsonProperty("type")
    private String type;
    @JsonProperty("workflow")
    private WorkflowSpec workflow;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ScheduleSpec() {
    }

    public ScheduleSpec(AWSChaosSpec awsChaos, AzureChaosSpec azureChaos, BlockChaosSpec blockChaos, String concurrencyPolicy, DNSChaosSpec dnsChaos, GCPChaosSpec gcpChaos, Integer historyLimit, HTTPChaosSpec httpChaos, IOChaosSpec ioChaos, JVMChaosSpec jvmChaos, KernelChaosSpec kernelChaos, NetworkChaosSpec networkChaos, PhysicalMachineChaosSpec physicalmachineChaos, PodChaosSpec podChaos, String schedule, Long startingDeadlineSeconds, StressChaosSpec stressChaos, TimeChaosSpec timeChaos, String type, WorkflowSpec workflow) {
        super();
        this.awsChaos = awsChaos;
        this.azureChaos = azureChaos;
        this.blockChaos = blockChaos;
        this.concurrencyPolicy = concurrencyPolicy;
        this.dnsChaos = dnsChaos;
        this.gcpChaos = gcpChaos;
        this.historyLimit = historyLimit;
        this.httpChaos = httpChaos;
        this.ioChaos = ioChaos;
        this.jvmChaos = jvmChaos;
        this.kernelChaos = kernelChaos;
        this.networkChaos = networkChaos;
        this.physicalmachineChaos = physicalmachineChaos;
        this.podChaos = podChaos;
        this.schedule = schedule;
        this.startingDeadlineSeconds = startingDeadlineSeconds;
        this.stressChaos = stressChaos;
        this.timeChaos = timeChaos;
        this.type = type;
        this.workflow = workflow;
    }

    /**
     * ScheduleSpec is the specification of a schedule object
     */
    @JsonProperty("awsChaos")
    public AWSChaosSpec getAwsChaos() {
        return awsChaos;
    }

    /**
     * ScheduleSpec is the specification of a schedule object
     */
    @JsonProperty("awsChaos")
    public void setAwsChaos(AWSChaosSpec awsChaos) {
        this.awsChaos = awsChaos;
    }

    /**
     * ScheduleSpec is the specification of a schedule object
     */
    @JsonProperty("azureChaos")
    public AzureChaosSpec getAzureChaos() {
        return azureChaos;
    }

    /**
     * ScheduleSpec is the specification of a schedule object
     */
    @JsonProperty("azureChaos")
    public void setAzureChaos(AzureChaosSpec azureChaos) {
        this.azureChaos = azureChaos;
    }

    /**
     * ScheduleSpec is the specification of a schedule object
     */
    @JsonProperty("blockChaos")
    public BlockChaosSpec getBlockChaos() {
        return blockChaos;
    }

    /**
     * ScheduleSpec is the specification of a schedule object
     */
    @JsonProperty("blockChaos")
    public void setBlockChaos(BlockChaosSpec blockChaos) {
        this.blockChaos = blockChaos;
    }

    /**
     * ScheduleSpec is the specification of a schedule object
     */
    @JsonProperty("concurrencyPolicy")
    public String getConcurrencyPolicy() {
        return concurrencyPolicy;
    }

    /**
     * ScheduleSpec is the specification of a schedule object
     */
    @JsonProperty("concurrencyPolicy")
    public void setConcurrencyPolicy(String concurrencyPolicy) {
        this.concurrencyPolicy = concurrencyPolicy;
    }

    /**
     * ScheduleSpec is the specification of a schedule object
     */
    @JsonProperty("dnsChaos")
    public DNSChaosSpec getDnsChaos() {
        return dnsChaos;
    }

    /**
     * ScheduleSpec is the specification of a schedule object
     */
    @JsonProperty("dnsChaos")
    public void setDnsChaos(DNSChaosSpec dnsChaos) {
        this.dnsChaos = dnsChaos;
    }

    /**
     * ScheduleSpec is the specification of a schedule object
     */
    @JsonProperty("gcpChaos")
    public GCPChaosSpec getGcpChaos() {
        return gcpChaos;
    }

    /**
     * ScheduleSpec is the specification of a schedule object
     */
    @JsonProperty("gcpChaos")
    public void setGcpChaos(GCPChaosSpec gcpChaos) {
        this.gcpChaos = gcpChaos;
    }

    /**
     * ScheduleSpec is the specification of a schedule object
     */
    @JsonProperty("historyLimit")
    public Integer getHistoryLimit() {
        return historyLimit;
    }

    /**
     * ScheduleSpec is the specification of a schedule object
     */
    @JsonProperty("historyLimit")
    public void setHistoryLimit(Integer historyLimit) {
        this.historyLimit = historyLimit;
    }

    /**
     * ScheduleSpec is the specification of a schedule object
     */
    @JsonProperty("httpChaos")
    public HTTPChaosSpec getHttpChaos() {
        return httpChaos;
    }

    /**
     * ScheduleSpec is the specification of a schedule object
     */
    @JsonProperty("httpChaos")
    public void setHttpChaos(HTTPChaosSpec httpChaos) {
        this.httpChaos = httpChaos;
    }

    /**
     * ScheduleSpec is the specification of a schedule object
     */
    @JsonProperty("ioChaos")
    public IOChaosSpec getIoChaos() {
        return ioChaos;
    }

    /**
     * ScheduleSpec is the specification of a schedule object
     */
    @JsonProperty("ioChaos")
    public void setIoChaos(IOChaosSpec ioChaos) {
        this.ioChaos = ioChaos;
    }

    /**
     * ScheduleSpec is the specification of a schedule object
     */
    @JsonProperty("jvmChaos")
    public JVMChaosSpec getJvmChaos() {
        return jvmChaos;
    }

    /**
     * ScheduleSpec is the specification of a schedule object
     */
    @JsonProperty("jvmChaos")
    public void setJvmChaos(JVMChaosSpec jvmChaos) {
        this.jvmChaos = jvmChaos;
    }

    /**
     * ScheduleSpec is the specification of a schedule object
     */
    @JsonProperty("kernelChaos")
    public KernelChaosSpec getKernelChaos() {
        return kernelChaos;
    }

    /**
     * ScheduleSpec is the specification of a schedule object
     */
    @JsonProperty("kernelChaos")
    public void setKernelChaos(KernelChaosSpec kernelChaos) {
        this.kernelChaos = kernelChaos;
    }

    /**
     * ScheduleSpec is the specification of a schedule object
     */
    @JsonProperty("networkChaos")
    public NetworkChaosSpec getNetworkChaos() {
        return networkChaos;
    }

    /**
     * ScheduleSpec is the specification of a schedule object
     */
    @JsonProperty("networkChaos")
    public void setNetworkChaos(NetworkChaosSpec networkChaos) {
        this.networkChaos = networkChaos;
    }

    /**
     * ScheduleSpec is the specification of a schedule object
     */
    @JsonProperty("physicalmachineChaos")
    public PhysicalMachineChaosSpec getPhysicalmachineChaos() {
        return physicalmachineChaos;
    }

    /**
     * ScheduleSpec is the specification of a schedule object
     */
    @JsonProperty("physicalmachineChaos")
    public void setPhysicalmachineChaos(PhysicalMachineChaosSpec physicalmachineChaos) {
        this.physicalmachineChaos = physicalmachineChaos;
    }

    /**
     * ScheduleSpec is the specification of a schedule object
     */
    @JsonProperty("podChaos")
    public PodChaosSpec getPodChaos() {
        return podChaos;
    }

    /**
     * ScheduleSpec is the specification of a schedule object
     */
    @JsonProperty("podChaos")
    public void setPodChaos(PodChaosSpec podChaos) {
        this.podChaos = podChaos;
    }

    /**
     * ScheduleSpec is the specification of a schedule object
     */
    @JsonProperty("schedule")
    public String getSchedule() {
        return schedule;
    }

    /**
     * ScheduleSpec is the specification of a schedule object
     */
    @JsonProperty("schedule")
    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    /**
     * ScheduleSpec is the specification of a schedule object
     */
    @JsonProperty("startingDeadlineSeconds")
    public Long getStartingDeadlineSeconds() {
        return startingDeadlineSeconds;
    }

    /**
     * ScheduleSpec is the specification of a schedule object
     */
    @JsonProperty("startingDeadlineSeconds")
    public void setStartingDeadlineSeconds(Long startingDeadlineSeconds) {
        this.startingDeadlineSeconds = startingDeadlineSeconds;
    }

    /**
     * ScheduleSpec is the specification of a schedule object
     */
    @JsonProperty("stressChaos")
    public StressChaosSpec getStressChaos() {
        return stressChaos;
    }

    /**
     * ScheduleSpec is the specification of a schedule object
     */
    @JsonProperty("stressChaos")
    public void setStressChaos(StressChaosSpec stressChaos) {
        this.stressChaos = stressChaos;
    }

    /**
     * ScheduleSpec is the specification of a schedule object
     */
    @JsonProperty("timeChaos")
    public TimeChaosSpec getTimeChaos() {
        return timeChaos;
    }

    /**
     * ScheduleSpec is the specification of a schedule object
     */
    @JsonProperty("timeChaos")
    public void setTimeChaos(TimeChaosSpec timeChaos) {
        this.timeChaos = timeChaos;
    }

    /**
     * ScheduleSpec is the specification of a schedule object
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * ScheduleSpec is the specification of a schedule object
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    /**
     * ScheduleSpec is the specification of a schedule object
     */
    @JsonProperty("workflow")
    public WorkflowSpec getWorkflow() {
        return workflow;
    }

    /**
     * ScheduleSpec is the specification of a schedule object
     */
    @JsonProperty("workflow")
    public void setWorkflow(WorkflowSpec workflow) {
        this.workflow = workflow;
    }

    @JsonIgnore
    public ScheduleSpecBuilder edit() {
        return new ScheduleSpecBuilder(this);
    }

    @JsonIgnore
    public ScheduleSpecBuilder toBuilder() {
        return edit();
    }

    @JsonAnyGetter
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
