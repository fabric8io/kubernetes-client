
package io.fabric8.openshift.api.model.miscellaneous.clusterapi.infrastructure.v1beta1;

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

/**
 * KubeletConfig defines the supported subset of kubelet configurations for nodes in pools. See also [AKS doc], [K8s doc].<br><p> <br><p> [AKS doc]: https://learn.microsoft.com/azure/aks/custom-node-configuration [K8s doc]: https://kubernetes.io/docs/reference/config-api/kubelet-config.v1beta1/
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "allowedUnsafeSysctls",
    "containerLogMaxFiles",
    "containerLogMaxSizeMB",
    "cpuCfsQuota",
    "cpuCfsQuotaPeriod",
    "cpuManagerPolicy",
    "failSwapOn",
    "imageGcHighThreshold",
    "imageGcLowThreshold",
    "podMaxPids",
    "topologyManagerPolicy"
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
public class KubeletConfig implements Editable<KubeletConfigBuilder>, KubernetesResource
{

    @JsonProperty("allowedUnsafeSysctls")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> allowedUnsafeSysctls = new ArrayList<>();
    @JsonProperty("containerLogMaxFiles")
    private Integer containerLogMaxFiles;
    @JsonProperty("containerLogMaxSizeMB")
    private Integer containerLogMaxSizeMB;
    @JsonProperty("cpuCfsQuota")
    private Boolean cpuCfsQuota;
    @JsonProperty("cpuCfsQuotaPeriod")
    private String cpuCfsQuotaPeriod;
    @JsonProperty("cpuManagerPolicy")
    private String cpuManagerPolicy;
    @JsonProperty("failSwapOn")
    private Boolean failSwapOn;
    @JsonProperty("imageGcHighThreshold")
    private Integer imageGcHighThreshold;
    @JsonProperty("imageGcLowThreshold")
    private Integer imageGcLowThreshold;
    @JsonProperty("podMaxPids")
    private Integer podMaxPids;
    @JsonProperty("topologyManagerPolicy")
    private String topologyManagerPolicy;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public KubeletConfig() {
    }

    public KubeletConfig(List<String> allowedUnsafeSysctls, Integer containerLogMaxFiles, Integer containerLogMaxSizeMB, Boolean cpuCfsQuota, String cpuCfsQuotaPeriod, String cpuManagerPolicy, Boolean failSwapOn, Integer imageGcHighThreshold, Integer imageGcLowThreshold, Integer podMaxPids, String topologyManagerPolicy) {
        super();
        this.allowedUnsafeSysctls = allowedUnsafeSysctls;
        this.containerLogMaxFiles = containerLogMaxFiles;
        this.containerLogMaxSizeMB = containerLogMaxSizeMB;
        this.cpuCfsQuota = cpuCfsQuota;
        this.cpuCfsQuotaPeriod = cpuCfsQuotaPeriod;
        this.cpuManagerPolicy = cpuManagerPolicy;
        this.failSwapOn = failSwapOn;
        this.imageGcHighThreshold = imageGcHighThreshold;
        this.imageGcLowThreshold = imageGcLowThreshold;
        this.podMaxPids = podMaxPids;
        this.topologyManagerPolicy = topologyManagerPolicy;
    }

    /**
     * AllowedUnsafeSysctls - Allowlist of unsafe sysctls or unsafe sysctl patterns (ending in `&#42;`). Valid values match `kernel.shm&#42;`, `kernel.msg&#42;`, `kernel.sem`, `fs.mqueue.&#42;`, or `net.&#42;`.
     */
    @JsonProperty("allowedUnsafeSysctls")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getAllowedUnsafeSysctls() {
        return allowedUnsafeSysctls;
    }

    /**
     * AllowedUnsafeSysctls - Allowlist of unsafe sysctls or unsafe sysctl patterns (ending in `&#42;`). Valid values match `kernel.shm&#42;`, `kernel.msg&#42;`, `kernel.sem`, `fs.mqueue.&#42;`, or `net.&#42;`.
     */
    @JsonProperty("allowedUnsafeSysctls")
    public void setAllowedUnsafeSysctls(List<String> allowedUnsafeSysctls) {
        this.allowedUnsafeSysctls = allowedUnsafeSysctls;
    }

    /**
     * ContainerLogMaxFiles - The maximum number of container log files that can be present for a container. The number must be ≥ 2.
     */
    @JsonProperty("containerLogMaxFiles")
    public Integer getContainerLogMaxFiles() {
        return containerLogMaxFiles;
    }

    /**
     * ContainerLogMaxFiles - The maximum number of container log files that can be present for a container. The number must be ≥ 2.
     */
    @JsonProperty("containerLogMaxFiles")
    public void setContainerLogMaxFiles(Integer containerLogMaxFiles) {
        this.containerLogMaxFiles = containerLogMaxFiles;
    }

    /**
     * ContainerLogMaxSizeMB - The maximum size in MB of a container log file before it is rotated.
     */
    @JsonProperty("containerLogMaxSizeMB")
    public Integer getContainerLogMaxSizeMB() {
        return containerLogMaxSizeMB;
    }

    /**
     * ContainerLogMaxSizeMB - The maximum size in MB of a container log file before it is rotated.
     */
    @JsonProperty("containerLogMaxSizeMB")
    public void setContainerLogMaxSizeMB(Integer containerLogMaxSizeMB) {
        this.containerLogMaxSizeMB = containerLogMaxSizeMB;
    }

    /**
     * CPUCfsQuota - Enable CPU CFS quota enforcement for containers that specify CPU limits.
     */
    @JsonProperty("cpuCfsQuota")
    public Boolean getCpuCfsQuota() {
        return cpuCfsQuota;
    }

    /**
     * CPUCfsQuota - Enable CPU CFS quota enforcement for containers that specify CPU limits.
     */
    @JsonProperty("cpuCfsQuota")
    public void setCpuCfsQuota(Boolean cpuCfsQuota) {
        this.cpuCfsQuota = cpuCfsQuota;
    }

    /**
     * CPUCfsQuotaPeriod - Sets CPU CFS quota period value. Must end in "ms", e.g. "100ms"
     */
    @JsonProperty("cpuCfsQuotaPeriod")
    public String getCpuCfsQuotaPeriod() {
        return cpuCfsQuotaPeriod;
    }

    /**
     * CPUCfsQuotaPeriod - Sets CPU CFS quota period value. Must end in "ms", e.g. "100ms"
     */
    @JsonProperty("cpuCfsQuotaPeriod")
    public void setCpuCfsQuotaPeriod(String cpuCfsQuotaPeriod) {
        this.cpuCfsQuotaPeriod = cpuCfsQuotaPeriod;
    }

    /**
     * CPUManagerPolicy - CPU Manager policy to use.
     */
    @JsonProperty("cpuManagerPolicy")
    public String getCpuManagerPolicy() {
        return cpuManagerPolicy;
    }

    /**
     * CPUManagerPolicy - CPU Manager policy to use.
     */
    @JsonProperty("cpuManagerPolicy")
    public void setCpuManagerPolicy(String cpuManagerPolicy) {
        this.cpuManagerPolicy = cpuManagerPolicy;
    }

    /**
     * FailSwapOn - If set to true it will make the Kubelet fail to start if swap is enabled on the node.
     */
    @JsonProperty("failSwapOn")
    public Boolean getFailSwapOn() {
        return failSwapOn;
    }

    /**
     * FailSwapOn - If set to true it will make the Kubelet fail to start if swap is enabled on the node.
     */
    @JsonProperty("failSwapOn")
    public void setFailSwapOn(Boolean failSwapOn) {
        this.failSwapOn = failSwapOn;
    }

    /**
     * ImageGcHighThreshold - The percent of disk usage after which image garbage collection is always run. Valid values are 0-100 (inclusive).
     */
    @JsonProperty("imageGcHighThreshold")
    public Integer getImageGcHighThreshold() {
        return imageGcHighThreshold;
    }

    /**
     * ImageGcHighThreshold - The percent of disk usage after which image garbage collection is always run. Valid values are 0-100 (inclusive).
     */
    @JsonProperty("imageGcHighThreshold")
    public void setImageGcHighThreshold(Integer imageGcHighThreshold) {
        this.imageGcHighThreshold = imageGcHighThreshold;
    }

    /**
     * ImageGcLowThreshold - The percent of disk usage before which image garbage collection is never run. Valid values are 0-100 (inclusive) and must be less than `imageGcHighThreshold`.
     */
    @JsonProperty("imageGcLowThreshold")
    public Integer getImageGcLowThreshold() {
        return imageGcLowThreshold;
    }

    /**
     * ImageGcLowThreshold - The percent of disk usage before which image garbage collection is never run. Valid values are 0-100 (inclusive) and must be less than `imageGcHighThreshold`.
     */
    @JsonProperty("imageGcLowThreshold")
    public void setImageGcLowThreshold(Integer imageGcLowThreshold) {
        this.imageGcLowThreshold = imageGcLowThreshold;
    }

    /**
     * PodMaxPids - The maximum number of processes per pod. Must not exceed kernel PID limit. -1 disables the limit.
     */
    @JsonProperty("podMaxPids")
    public Integer getPodMaxPids() {
        return podMaxPids;
    }

    /**
     * PodMaxPids - The maximum number of processes per pod. Must not exceed kernel PID limit. -1 disables the limit.
     */
    @JsonProperty("podMaxPids")
    public void setPodMaxPids(Integer podMaxPids) {
        this.podMaxPids = podMaxPids;
    }

    /**
     * TopologyManagerPolicy - Topology Manager policy to use.
     */
    @JsonProperty("topologyManagerPolicy")
    public String getTopologyManagerPolicy() {
        return topologyManagerPolicy;
    }

    /**
     * TopologyManagerPolicy - Topology Manager policy to use.
     */
    @JsonProperty("topologyManagerPolicy")
    public void setTopologyManagerPolicy(String topologyManagerPolicy) {
        this.topologyManagerPolicy = topologyManagerPolicy;
    }

    @JsonIgnore
    public KubeletConfigBuilder edit() {
        return new KubeletConfigBuilder(this);
    }

    @JsonIgnore
    public KubeletConfigBuilder toBuilder() {
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
