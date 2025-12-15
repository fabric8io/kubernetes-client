
package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

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
 * LinuxOSConfig specifies the custom Linux OS settings and configurations. See also [AKS doc].<br><p> <br><p> [AKS doc]: https://learn.microsoft.com/azure/aks/custom-node-configuration#linux-os-custom-configuration
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "swapFileSizeMB",
    "sysctls",
    "transparentHugePageDefrag",
    "transparentHugePageEnabled"
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
public class LinuxOSConfig implements Editable<LinuxOSConfigBuilder>, KubernetesResource
{

    @JsonProperty("swapFileSizeMB")
    private Integer swapFileSizeMB;
    @JsonProperty("sysctls")
    private SysctlConfig sysctls;
    @JsonProperty("transparentHugePageDefrag")
    private String transparentHugePageDefrag;
    @JsonProperty("transparentHugePageEnabled")
    private String transparentHugePageEnabled;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public LinuxOSConfig() {
    }

    public LinuxOSConfig(Integer swapFileSizeMB, SysctlConfig sysctls, String transparentHugePageDefrag, String transparentHugePageEnabled) {
        super();
        this.swapFileSizeMB = swapFileSizeMB;
        this.sysctls = sysctls;
        this.transparentHugePageDefrag = transparentHugePageDefrag;
        this.transparentHugePageEnabled = transparentHugePageEnabled;
    }

    /**
     * SwapFileSizeMB specifies size in MB of a swap file will be created on the agent nodes from this node pool. Max value of SwapFileSizeMB should be the size of temporary disk(/dev/sdb). Must be at least 1. See also [AKS doc].<br><p> <br><p> [AKS doc]: https://learn.microsoft.com/azure/virtual-machines/managed-disks-overview#temporary-disk
     */
    @JsonProperty("swapFileSizeMB")
    public Integer getSwapFileSizeMB() {
        return swapFileSizeMB;
    }

    /**
     * SwapFileSizeMB specifies size in MB of a swap file will be created on the agent nodes from this node pool. Max value of SwapFileSizeMB should be the size of temporary disk(/dev/sdb). Must be at least 1. See also [AKS doc].<br><p> <br><p> [AKS doc]: https://learn.microsoft.com/azure/virtual-machines/managed-disks-overview#temporary-disk
     */
    @JsonProperty("swapFileSizeMB")
    public void setSwapFileSizeMB(Integer swapFileSizeMB) {
        this.swapFileSizeMB = swapFileSizeMB;
    }

    /**
     * LinuxOSConfig specifies the custom Linux OS settings and configurations. See also [AKS doc].<br><p> <br><p> [AKS doc]: https://learn.microsoft.com/azure/aks/custom-node-configuration#linux-os-custom-configuration
     */
    @JsonProperty("sysctls")
    public SysctlConfig getSysctls() {
        return sysctls;
    }

    /**
     * LinuxOSConfig specifies the custom Linux OS settings and configurations. See also [AKS doc].<br><p> <br><p> [AKS doc]: https://learn.microsoft.com/azure/aks/custom-node-configuration#linux-os-custom-configuration
     */
    @JsonProperty("sysctls")
    public void setSysctls(SysctlConfig sysctls) {
        this.sysctls = sysctls;
    }

    /**
     * TransparentHugePageDefrag specifies whether the kernel should make aggressive use of memory compaction to make more hugepages available. See also [Linux doc].<br><p> <br><p> [Linux doc]: https://www.kernel.org/doc/html/latest/admin-guide/mm/transhuge.html#admin-guide-transhuge for more details.
     */
    @JsonProperty("transparentHugePageDefrag")
    public String getTransparentHugePageDefrag() {
        return transparentHugePageDefrag;
    }

    /**
     * TransparentHugePageDefrag specifies whether the kernel should make aggressive use of memory compaction to make more hugepages available. See also [Linux doc].<br><p> <br><p> [Linux doc]: https://www.kernel.org/doc/html/latest/admin-guide/mm/transhuge.html#admin-guide-transhuge for more details.
     */
    @JsonProperty("transparentHugePageDefrag")
    public void setTransparentHugePageDefrag(String transparentHugePageDefrag) {
        this.transparentHugePageDefrag = transparentHugePageDefrag;
    }

    /**
     * TransparentHugePageEnabled specifies various modes of Transparent Hugepages. See also [Linux doc].<br><p> <br><p> [Linux doc]: https://www.kernel.org/doc/html/latest/admin-guide/mm/transhuge.html#admin-guide-transhuge for more details.
     */
    @JsonProperty("transparentHugePageEnabled")
    public String getTransparentHugePageEnabled() {
        return transparentHugePageEnabled;
    }

    /**
     * TransparentHugePageEnabled specifies various modes of Transparent Hugepages. See also [Linux doc].<br><p> <br><p> [Linux doc]: https://www.kernel.org/doc/html/latest/admin-guide/mm/transhuge.html#admin-guide-transhuge for more details.
     */
    @JsonProperty("transparentHugePageEnabled")
    public void setTransparentHugePageEnabled(String transparentHugePageEnabled) {
        this.transparentHugePageEnabled = transparentHugePageEnabled;
    }

    @JsonIgnore
    public LinuxOSConfigBuilder edit() {
        return new LinuxOSConfigBuilder(this);
    }

    @JsonIgnore
    public LinuxOSConfigBuilder toBuilder() {
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
