
package io.fabric8.openshift.api.model.installer.v1;

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
 * Disk defines the type of disk (etcd, swap or user-defined) and the configuration of each disk type.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "etcd",
    "swap",
    "type",
    "userDefined"
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
public class Disk implements Editable<DiskBuilder>, KubernetesResource
{

    @JsonProperty("etcd")
    private DiskEtcd etcd;
    @JsonProperty("swap")
    private DiskSwap swap;
    @JsonProperty("type")
    private String type;
    @JsonProperty("userDefined")
    private DiskUserDefined userDefined;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Disk() {
    }

    public Disk(DiskEtcd etcd, DiskSwap swap, String type, DiskUserDefined userDefined) {
        super();
        this.etcd = etcd;
        this.swap = swap;
        this.type = type;
        this.userDefined = userDefined;
    }

    /**
     * Disk defines the type of disk (etcd, swap or user-defined) and the configuration of each disk type.
     */
    @JsonProperty("etcd")
    public DiskEtcd getEtcd() {
        return etcd;
    }

    /**
     * Disk defines the type of disk (etcd, swap or user-defined) and the configuration of each disk type.
     */
    @JsonProperty("etcd")
    public void setEtcd(DiskEtcd etcd) {
        this.etcd = etcd;
    }

    /**
     * Disk defines the type of disk (etcd, swap or user-defined) and the configuration of each disk type.
     */
    @JsonProperty("swap")
    public DiskSwap getSwap() {
        return swap;
    }

    /**
     * Disk defines the type of disk (etcd, swap or user-defined) and the configuration of each disk type.
     */
    @JsonProperty("swap")
    public void setSwap(DiskSwap swap) {
        this.swap = swap;
    }

    /**
     * Disk defines the type of disk (etcd, swap or user-defined) and the configuration of each disk type.
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * Disk defines the type of disk (etcd, swap or user-defined) and the configuration of each disk type.
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Disk defines the type of disk (etcd, swap or user-defined) and the configuration of each disk type.
     */
    @JsonProperty("userDefined")
    public DiskUserDefined getUserDefined() {
        return userDefined;
    }

    /**
     * Disk defines the type of disk (etcd, swap or user-defined) and the configuration of each disk type.
     */
    @JsonProperty("userDefined")
    public void setUserDefined(DiskUserDefined userDefined) {
        this.userDefined = userDefined;
    }

    @JsonIgnore
    public DiskBuilder edit() {
        return new DiskBuilder(this);
    }

    @JsonIgnore
    public DiskBuilder toBuilder() {
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
        if (!(o instanceof Disk)) {
            return false;
        }
        Disk other = (Disk) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$etcd = this.getEtcd();
        Object other$etcd = other.getEtcd();
        if (this$etcd == null ? other$etcd != null : !this$etcd.equals(other$etcd)) {
            return false;
        }
        Object this$swap = this.getSwap();
        Object other$swap = other.getSwap();
        if (this$swap == null ? other$swap != null : !this$swap.equals(other$swap)) {
            return false;
        }
        Object this$type = this.getType();
        Object other$type = other.getType();
        if (this$type == null ? other$type != null : !this$type.equals(other$type)) {
            return false;
        }
        Object this$userDefined = this.getUserDefined();
        Object other$userDefined = other.getUserDefined();
        if (this$userDefined == null ? other$userDefined != null : !this$userDefined.equals(other$userDefined)) {
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
        return other instanceof Disk;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $etcd = this.getEtcd();
        result = result * prime + ($etcd == null ? 43 : $etcd.hashCode());
        Object $swap = this.getSwap();
        result = result * prime + ($swap == null ? 43 : $swap.hashCode());
        Object $type = this.getType();
        result = result * prime + ($type == null ? 43 : $type.hashCode());
        Object $userDefined = this.getUserDefined();
        result = result * prime + ($userDefined == null ? 43 : $userDefined.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Disk(" + "etcd=" + this.getEtcd() + ", swap=" + this.getSwap() + ", type=" + this.getType() + ", userDefined=" + this.getUserDefined() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
