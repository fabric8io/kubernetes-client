
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

/**
 * ChaosOnlyScheduleSpec is very similar with ScheduleSpec, but it could not schedule Workflow because we could not resolve nested CRD now
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
    "type"
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

    /**
     * ChaosOnlyScheduleSpec is very similar with ScheduleSpec, but it could not schedule Workflow because we could not resolve nested CRD now
     */
    @JsonProperty("awsChaos")
    public AWSChaosSpec getAwsChaos() {
        return awsChaos;
    }

    /**
     * ChaosOnlyScheduleSpec is very similar with ScheduleSpec, but it could not schedule Workflow because we could not resolve nested CRD now
     */
    @JsonProperty("awsChaos")
    public void setAwsChaos(AWSChaosSpec awsChaos) {
        this.awsChaos = awsChaos;
    }

    /**
     * ChaosOnlyScheduleSpec is very similar with ScheduleSpec, but it could not schedule Workflow because we could not resolve nested CRD now
     */
    @JsonProperty("azureChaos")
    public AzureChaosSpec getAzureChaos() {
        return azureChaos;
    }

    /**
     * ChaosOnlyScheduleSpec is very similar with ScheduleSpec, but it could not schedule Workflow because we could not resolve nested CRD now
     */
    @JsonProperty("azureChaos")
    public void setAzureChaos(AzureChaosSpec azureChaos) {
        this.azureChaos = azureChaos;
    }

    /**
     * ChaosOnlyScheduleSpec is very similar with ScheduleSpec, but it could not schedule Workflow because we could not resolve nested CRD now
     */
    @JsonProperty("blockChaos")
    public BlockChaosSpec getBlockChaos() {
        return blockChaos;
    }

    /**
     * ChaosOnlyScheduleSpec is very similar with ScheduleSpec, but it could not schedule Workflow because we could not resolve nested CRD now
     */
    @JsonProperty("blockChaos")
    public void setBlockChaos(BlockChaosSpec blockChaos) {
        this.blockChaos = blockChaos;
    }

    /**
     * ChaosOnlyScheduleSpec is very similar with ScheduleSpec, but it could not schedule Workflow because we could not resolve nested CRD now
     */
    @JsonProperty("concurrencyPolicy")
    public String getConcurrencyPolicy() {
        return concurrencyPolicy;
    }

    /**
     * ChaosOnlyScheduleSpec is very similar with ScheduleSpec, but it could not schedule Workflow because we could not resolve nested CRD now
     */
    @JsonProperty("concurrencyPolicy")
    public void setConcurrencyPolicy(String concurrencyPolicy) {
        this.concurrencyPolicy = concurrencyPolicy;
    }

    /**
     * ChaosOnlyScheduleSpec is very similar with ScheduleSpec, but it could not schedule Workflow because we could not resolve nested CRD now
     */
    @JsonProperty("dnsChaos")
    public DNSChaosSpec getDnsChaos() {
        return dnsChaos;
    }

    /**
     * ChaosOnlyScheduleSpec is very similar with ScheduleSpec, but it could not schedule Workflow because we could not resolve nested CRD now
     */
    @JsonProperty("dnsChaos")
    public void setDnsChaos(DNSChaosSpec dnsChaos) {
        this.dnsChaos = dnsChaos;
    }

    /**
     * ChaosOnlyScheduleSpec is very similar with ScheduleSpec, but it could not schedule Workflow because we could not resolve nested CRD now
     */
    @JsonProperty("gcpChaos")
    public GCPChaosSpec getGcpChaos() {
        return gcpChaos;
    }

    /**
     * ChaosOnlyScheduleSpec is very similar with ScheduleSpec, but it could not schedule Workflow because we could not resolve nested CRD now
     */
    @JsonProperty("gcpChaos")
    public void setGcpChaos(GCPChaosSpec gcpChaos) {
        this.gcpChaos = gcpChaos;
    }

    /**
     * ChaosOnlyScheduleSpec is very similar with ScheduleSpec, but it could not schedule Workflow because we could not resolve nested CRD now
     */
    @JsonProperty("historyLimit")
    public Integer getHistoryLimit() {
        return historyLimit;
    }

    /**
     * ChaosOnlyScheduleSpec is very similar with ScheduleSpec, but it could not schedule Workflow because we could not resolve nested CRD now
     */
    @JsonProperty("historyLimit")
    public void setHistoryLimit(Integer historyLimit) {
        this.historyLimit = historyLimit;
    }

    /**
     * ChaosOnlyScheduleSpec is very similar with ScheduleSpec, but it could not schedule Workflow because we could not resolve nested CRD now
     */
    @JsonProperty("httpChaos")
    public HTTPChaosSpec getHttpChaos() {
        return httpChaos;
    }

    /**
     * ChaosOnlyScheduleSpec is very similar with ScheduleSpec, but it could not schedule Workflow because we could not resolve nested CRD now
     */
    @JsonProperty("httpChaos")
    public void setHttpChaos(HTTPChaosSpec httpChaos) {
        this.httpChaos = httpChaos;
    }

    /**
     * ChaosOnlyScheduleSpec is very similar with ScheduleSpec, but it could not schedule Workflow because we could not resolve nested CRD now
     */
    @JsonProperty("ioChaos")
    public IOChaosSpec getIoChaos() {
        return ioChaos;
    }

    /**
     * ChaosOnlyScheduleSpec is very similar with ScheduleSpec, but it could not schedule Workflow because we could not resolve nested CRD now
     */
    @JsonProperty("ioChaos")
    public void setIoChaos(IOChaosSpec ioChaos) {
        this.ioChaos = ioChaos;
    }

    /**
     * ChaosOnlyScheduleSpec is very similar with ScheduleSpec, but it could not schedule Workflow because we could not resolve nested CRD now
     */
    @JsonProperty("jvmChaos")
    public JVMChaosSpec getJvmChaos() {
        return jvmChaos;
    }

    /**
     * ChaosOnlyScheduleSpec is very similar with ScheduleSpec, but it could not schedule Workflow because we could not resolve nested CRD now
     */
    @JsonProperty("jvmChaos")
    public void setJvmChaos(JVMChaosSpec jvmChaos) {
        this.jvmChaos = jvmChaos;
    }

    /**
     * ChaosOnlyScheduleSpec is very similar with ScheduleSpec, but it could not schedule Workflow because we could not resolve nested CRD now
     */
    @JsonProperty("kernelChaos")
    public KernelChaosSpec getKernelChaos() {
        return kernelChaos;
    }

    /**
     * ChaosOnlyScheduleSpec is very similar with ScheduleSpec, but it could not schedule Workflow because we could not resolve nested CRD now
     */
    @JsonProperty("kernelChaos")
    public void setKernelChaos(KernelChaosSpec kernelChaos) {
        this.kernelChaos = kernelChaos;
    }

    /**
     * ChaosOnlyScheduleSpec is very similar with ScheduleSpec, but it could not schedule Workflow because we could not resolve nested CRD now
     */
    @JsonProperty("networkChaos")
    public NetworkChaosSpec getNetworkChaos() {
        return networkChaos;
    }

    /**
     * ChaosOnlyScheduleSpec is very similar with ScheduleSpec, but it could not schedule Workflow because we could not resolve nested CRD now
     */
    @JsonProperty("networkChaos")
    public void setNetworkChaos(NetworkChaosSpec networkChaos) {
        this.networkChaos = networkChaos;
    }

    /**
     * ChaosOnlyScheduleSpec is very similar with ScheduleSpec, but it could not schedule Workflow because we could not resolve nested CRD now
     */
    @JsonProperty("physicalmachineChaos")
    public PhysicalMachineChaosSpec getPhysicalmachineChaos() {
        return physicalmachineChaos;
    }

    /**
     * ChaosOnlyScheduleSpec is very similar with ScheduleSpec, but it could not schedule Workflow because we could not resolve nested CRD now
     */
    @JsonProperty("physicalmachineChaos")
    public void setPhysicalmachineChaos(PhysicalMachineChaosSpec physicalmachineChaos) {
        this.physicalmachineChaos = physicalmachineChaos;
    }

    /**
     * ChaosOnlyScheduleSpec is very similar with ScheduleSpec, but it could not schedule Workflow because we could not resolve nested CRD now
     */
    @JsonProperty("podChaos")
    public PodChaosSpec getPodChaos() {
        return podChaos;
    }

    /**
     * ChaosOnlyScheduleSpec is very similar with ScheduleSpec, but it could not schedule Workflow because we could not resolve nested CRD now
     */
    @JsonProperty("podChaos")
    public void setPodChaos(PodChaosSpec podChaos) {
        this.podChaos = podChaos;
    }

    /**
     * ChaosOnlyScheduleSpec is very similar with ScheduleSpec, but it could not schedule Workflow because we could not resolve nested CRD now
     */
    @JsonProperty("schedule")
    public String getSchedule() {
        return schedule;
    }

    /**
     * ChaosOnlyScheduleSpec is very similar with ScheduleSpec, but it could not schedule Workflow because we could not resolve nested CRD now
     */
    @JsonProperty("schedule")
    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    /**
     * ChaosOnlyScheduleSpec is very similar with ScheduleSpec, but it could not schedule Workflow because we could not resolve nested CRD now
     */
    @JsonProperty("startingDeadlineSeconds")
    public Long getStartingDeadlineSeconds() {
        return startingDeadlineSeconds;
    }

    /**
     * ChaosOnlyScheduleSpec is very similar with ScheduleSpec, but it could not schedule Workflow because we could not resolve nested CRD now
     */
    @JsonProperty("startingDeadlineSeconds")
    public void setStartingDeadlineSeconds(Long startingDeadlineSeconds) {
        this.startingDeadlineSeconds = startingDeadlineSeconds;
    }

    /**
     * ChaosOnlyScheduleSpec is very similar with ScheduleSpec, but it could not schedule Workflow because we could not resolve nested CRD now
     */
    @JsonProperty("stressChaos")
    public StressChaosSpec getStressChaos() {
        return stressChaos;
    }

    /**
     * ChaosOnlyScheduleSpec is very similar with ScheduleSpec, but it could not schedule Workflow because we could not resolve nested CRD now
     */
    @JsonProperty("stressChaos")
    public void setStressChaos(StressChaosSpec stressChaos) {
        this.stressChaos = stressChaos;
    }

    /**
     * ChaosOnlyScheduleSpec is very similar with ScheduleSpec, but it could not schedule Workflow because we could not resolve nested CRD now
     */
    @JsonProperty("timeChaos")
    public TimeChaosSpec getTimeChaos() {
        return timeChaos;
    }

    /**
     * ChaosOnlyScheduleSpec is very similar with ScheduleSpec, but it could not schedule Workflow because we could not resolve nested CRD now
     */
    @JsonProperty("timeChaos")
    public void setTimeChaos(TimeChaosSpec timeChaos) {
        this.timeChaos = timeChaos;
    }

    /**
     * ChaosOnlyScheduleSpec is very similar with ScheduleSpec, but it could not schedule Workflow because we could not resolve nested CRD now
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * ChaosOnlyScheduleSpec is very similar with ScheduleSpec, but it could not schedule Workflow because we could not resolve nested CRD now
     */
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
        if (!(o instanceof ChaosOnlyScheduleSpec)) {
            return false;
        }
        ChaosOnlyScheduleSpec other = (ChaosOnlyScheduleSpec) o;
        if (!other.canEqual(this)) {
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
        Object this$concurrencyPolicy = this.getConcurrencyPolicy();
        Object other$concurrencyPolicy = other.getConcurrencyPolicy();
        if (this$concurrencyPolicy == null ? other$concurrencyPolicy != null : !this$concurrencyPolicy.equals(other$concurrencyPolicy)) {
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
        Object this$historyLimit = this.getHistoryLimit();
        Object other$historyLimit = other.getHistoryLimit();
        if (this$historyLimit == null ? other$historyLimit != null : !this$historyLimit.equals(other$historyLimit)) {
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
        Object this$startingDeadlineSeconds = this.getStartingDeadlineSeconds();
        Object other$startingDeadlineSeconds = other.getStartingDeadlineSeconds();
        if (this$startingDeadlineSeconds == null ? other$startingDeadlineSeconds != null : !this$startingDeadlineSeconds.equals(other$startingDeadlineSeconds)) {
            return false;
        }
        Object this$stressChaos = this.getStressChaos();
        Object other$stressChaos = other.getStressChaos();
        if (this$stressChaos == null ? other$stressChaos != null : !this$stressChaos.equals(other$stressChaos)) {
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
        Object this$additionalProperties = this.getAdditionalProperties();
        Object other$additionalProperties = other.getAdditionalProperties();
        if (this$additionalProperties == null ? other$additionalProperties != null : !this$additionalProperties.equals(other$additionalProperties)) {
            return false;
        }
        return true;
    }

    protected boolean canEqual(Object other) {
        return other instanceof ChaosOnlyScheduleSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $awsChaos = this.getAwsChaos();
        result = result * prime + ($awsChaos == null ? 43 : $awsChaos.hashCode());
        Object $azureChaos = this.getAzureChaos();
        result = result * prime + ($azureChaos == null ? 43 : $azureChaos.hashCode());
        Object $blockChaos = this.getBlockChaos();
        result = result * prime + ($blockChaos == null ? 43 : $blockChaos.hashCode());
        Object $concurrencyPolicy = this.getConcurrencyPolicy();
        result = result * prime + ($concurrencyPolicy == null ? 43 : $concurrencyPolicy.hashCode());
        Object $dnsChaos = this.getDnsChaos();
        result = result * prime + ($dnsChaos == null ? 43 : $dnsChaos.hashCode());
        Object $gcpChaos = this.getGcpChaos();
        result = result * prime + ($gcpChaos == null ? 43 : $gcpChaos.hashCode());
        Object $historyLimit = this.getHistoryLimit();
        result = result * prime + ($historyLimit == null ? 43 : $historyLimit.hashCode());
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
        Object $startingDeadlineSeconds = this.getStartingDeadlineSeconds();
        result = result * prime + ($startingDeadlineSeconds == null ? 43 : $startingDeadlineSeconds.hashCode());
        Object $stressChaos = this.getStressChaos();
        result = result * prime + ($stressChaos == null ? 43 : $stressChaos.hashCode());
        Object $timeChaos = this.getTimeChaos();
        result = result * prime + ($timeChaos == null ? 43 : $timeChaos.hashCode());
        Object $type = this.getType();
        result = result * prime + ($type == null ? 43 : $type.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ChaosOnlyScheduleSpec(" + "awsChaos=" + this.getAwsChaos() + ", azureChaos=" + this.getAzureChaos() + ", blockChaos=" + this.getBlockChaos() + ", concurrencyPolicy=" + this.getConcurrencyPolicy() + ", dnsChaos=" + this.getDnsChaos() + ", gcpChaos=" + this.getGcpChaos() + ", historyLimit=" + this.getHistoryLimit() + ", httpChaos=" + this.getHttpChaos() + ", ioChaos=" + this.getIoChaos() + ", jvmChaos=" + this.getJvmChaos() + ", kernelChaos=" + this.getKernelChaos() + ", networkChaos=" + this.getNetworkChaos() + ", physicalmachineChaos=" + this.getPhysicalmachineChaos() + ", podChaos=" + this.getPodChaos() + ", schedule=" + this.getSchedule() + ", startingDeadlineSeconds=" + this.getStartingDeadlineSeconds() + ", stressChaos=" + this.getStressChaos() + ", timeChaos=" + this.getTimeChaos() + ", type=" + this.getType() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
