
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

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

}
