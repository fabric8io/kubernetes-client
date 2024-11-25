
package io.fabric8.chaosmesh.v1alpha1;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
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
    "type"
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
public class ChaosOnlyScheduleSpec implements Editable<ChaosOnlyScheduleSpecBuilder>, KubernetesResource
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
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ChaosOnlyScheduleSpec() {
    }

    public ChaosOnlyScheduleSpec(AWSChaosSpec awsChaos, AzureChaosSpec azureChaos, BlockChaosSpec blockChaos, String concurrencyPolicy, DNSChaosSpec dnsChaos, GCPChaosSpec gcpChaos, Integer historyLimit, HTTPChaosSpec httpChaos, IOChaosSpec ioChaos, JVMChaosSpec jvmChaos, KernelChaosSpec kernelChaos, NetworkChaosSpec networkChaos, PhysicalMachineChaosSpec physicalmachineChaos, PodChaosSpec podChaos, String schedule, Long startingDeadlineSeconds, StressChaosSpec stressChaos, TimeChaosSpec timeChaos, String type) {
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

    @JsonProperty("concurrencyPolicy")
    public String getConcurrencyPolicy() {
        return concurrencyPolicy;
    }

    @JsonProperty("concurrencyPolicy")
    public void setConcurrencyPolicy(String concurrencyPolicy) {
        this.concurrencyPolicy = concurrencyPolicy;
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

    @JsonProperty("historyLimit")
    public Integer getHistoryLimit() {
        return historyLimit;
    }

    @JsonProperty("historyLimit")
    public void setHistoryLimit(Integer historyLimit) {
        this.historyLimit = historyLimit;
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
    public String getSchedule() {
        return schedule;
    }

    @JsonProperty("schedule")
    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    @JsonProperty("startingDeadlineSeconds")
    public Long getStartingDeadlineSeconds() {
        return startingDeadlineSeconds;
    }

    @JsonProperty("startingDeadlineSeconds")
    public void setStartingDeadlineSeconds(Long startingDeadlineSeconds) {
        this.startingDeadlineSeconds = startingDeadlineSeconds;
    }

    @JsonProperty("stressChaos")
    public StressChaosSpec getStressChaos() {
        return stressChaos;
    }

    @JsonProperty("stressChaos")
    public void setStressChaos(StressChaosSpec stressChaos) {
        this.stressChaos = stressChaos;
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

    @JsonIgnore
    public ChaosOnlyScheduleSpecBuilder edit() {
        return new ChaosOnlyScheduleSpecBuilder(this);
    }

    @JsonIgnore
    public ChaosOnlyScheduleSpecBuilder toBuilder() {
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
