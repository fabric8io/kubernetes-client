
package io.fabric8.openshift.api.model.machine.v1beta1;

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
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * Placement indicates where to create the instance in AWS
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "availabilityZone",
    "region",
    "tenancy"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectMeta.class),
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
public class Placement implements Editable<PlacementBuilder>, KubernetesResource
{

    @JsonProperty("availabilityZone")
    private String availabilityZone;
    @JsonProperty("region")
    private String region;
    @JsonProperty("tenancy")
    private String tenancy;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Placement() {
    }

    public Placement(String availabilityZone, String region, String tenancy) {
        super();
        this.availabilityZone = availabilityZone;
        this.region = region;
        this.tenancy = tenancy;
    }

    /**
     * availabilityZone is the availability zone of the instance
     */
    @JsonProperty("availabilityZone")
    public String getAvailabilityZone() {
        return availabilityZone;
    }

    /**
     * availabilityZone is the availability zone of the instance
     */
    @JsonProperty("availabilityZone")
    public void setAvailabilityZone(String availabilityZone) {
        this.availabilityZone = availabilityZone;
    }

    /**
     * region is the region to use to create the instance
     */
    @JsonProperty("region")
    public String getRegion() {
        return region;
    }

    /**
     * region is the region to use to create the instance
     */
    @JsonProperty("region")
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * tenancy indicates if instance should run on shared or single-tenant hardware. There are supported 3 options: default, dedicated and host.
     */
    @JsonProperty("tenancy")
    public String getTenancy() {
        return tenancy;
    }

    /**
     * tenancy indicates if instance should run on shared or single-tenant hardware. There are supported 3 options: default, dedicated and host.
     */
    @JsonProperty("tenancy")
    public void setTenancy(String tenancy) {
        this.tenancy = tenancy;
    }

    @JsonIgnore
    public PlacementBuilder edit() {
        return new PlacementBuilder(this);
    }

    @JsonIgnore
    public PlacementBuilder toBuilder() {
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
        if (!(o instanceof Placement)) {
            return false;
        }
        Placement other = (Placement) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$availabilityZone = this.getAvailabilityZone();
        Object other$availabilityZone = other.getAvailabilityZone();
        if (this$availabilityZone == null ? other$availabilityZone != null : !this$availabilityZone.equals(other$availabilityZone)) {
            return false;
        }
        Object this$region = this.getRegion();
        Object other$region = other.getRegion();
        if (this$region == null ? other$region != null : !this$region.equals(other$region)) {
            return false;
        }
        Object this$tenancy = this.getTenancy();
        Object other$tenancy = other.getTenancy();
        if (this$tenancy == null ? other$tenancy != null : !this$tenancy.equals(other$tenancy)) {
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
        return other instanceof Placement;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $availabilityZone = this.getAvailabilityZone();
        result = result * prime + ($availabilityZone == null ? 43 : $availabilityZone.hashCode());
        Object $region = this.getRegion();
        result = result * prime + ($region == null ? 43 : $region.hashCode());
        Object $tenancy = this.getTenancy();
        result = result * prime + ($tenancy == null ? 43 : $tenancy.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Placement(" + "availabilityZone=" + this.getAvailabilityZone() + ", region=" + this.getRegion() + ", tenancy=" + this.getTenancy() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
