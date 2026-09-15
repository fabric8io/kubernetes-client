
package io.fabric8.openshift.api.model.whereabouts.v1alpha1;

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
 * OverlappingRangeIPReservationSpec defines the desired state of OverlappingRangeIPReservation
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "containerid",
    "ifname",
    "podref"
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
public class OverlappingRangeIPReservationSpec implements Editable<OverlappingRangeIPReservationSpecBuilder>, KubernetesResource
{

    @JsonProperty("containerid")
    private String containerid;
    @JsonProperty("ifname")
    private String ifname;
    @JsonProperty("podref")
    private String podref;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public OverlappingRangeIPReservationSpec() {
    }

    public OverlappingRangeIPReservationSpec(String containerid, String ifname, String podref) {
        super();
        this.containerid = containerid;
        this.ifname = ifname;
        this.podref = podref;
    }

    /**
     * OverlappingRangeIPReservationSpec defines the desired state of OverlappingRangeIPReservation
     */
    @JsonProperty("containerid")
    public String getContainerid() {
        return containerid;
    }

    /**
     * OverlappingRangeIPReservationSpec defines the desired state of OverlappingRangeIPReservation
     */
    @JsonProperty("containerid")
    public void setContainerid(String containerid) {
        this.containerid = containerid;
    }

    /**
     * OverlappingRangeIPReservationSpec defines the desired state of OverlappingRangeIPReservation
     */
    @JsonProperty("ifname")
    public String getIfname() {
        return ifname;
    }

    /**
     * OverlappingRangeIPReservationSpec defines the desired state of OverlappingRangeIPReservation
     */
    @JsonProperty("ifname")
    public void setIfname(String ifname) {
        this.ifname = ifname;
    }

    /**
     * OverlappingRangeIPReservationSpec defines the desired state of OverlappingRangeIPReservation
     */
    @JsonProperty("podref")
    public String getPodref() {
        return podref;
    }

    /**
     * OverlappingRangeIPReservationSpec defines the desired state of OverlappingRangeIPReservation
     */
    @JsonProperty("podref")
    public void setPodref(String podref) {
        this.podref = podref;
    }

    @JsonIgnore
    public OverlappingRangeIPReservationSpecBuilder edit() {
        return new OverlappingRangeIPReservationSpecBuilder(this);
    }

    @JsonIgnore
    public OverlappingRangeIPReservationSpecBuilder toBuilder() {
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
        if (!(o instanceof OverlappingRangeIPReservationSpec)) {
            return false;
        }
        OverlappingRangeIPReservationSpec other = (OverlappingRangeIPReservationSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$containerid = this.getContainerid();
        Object other$containerid = other.getContainerid();
        if (this$containerid == null ? other$containerid != null : !this$containerid.equals(other$containerid)) {
            return false;
        }
        Object this$ifname = this.getIfname();
        Object other$ifname = other.getIfname();
        if (this$ifname == null ? other$ifname != null : !this$ifname.equals(other$ifname)) {
            return false;
        }
        Object this$podref = this.getPodref();
        Object other$podref = other.getPodref();
        if (this$podref == null ? other$podref != null : !this$podref.equals(other$podref)) {
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
        return other instanceof OverlappingRangeIPReservationSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $containerid = this.getContainerid();
        result = result * prime + ($containerid == null ? 43 : $containerid.hashCode());
        Object $ifname = this.getIfname();
        result = result * prime + ($ifname == null ? 43 : $ifname.hashCode());
        Object $podref = this.getPodref();
        result = result * prime + ($podref == null ? 43 : $podref.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "OverlappingRangeIPReservationSpec(" + "containerid=" + this.getContainerid() + ", ifname=" + this.getIfname() + ", podref=" + this.getPodref() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
