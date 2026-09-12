
package io.fabric8.openshift.api.model.hive.v1;

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
 * GCPPrivateServiceConnectSubnet defines subnet and the corresponding GCP region.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "region",
    "subnet"
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
public class GCPPrivateServiceConnectSubnet implements Editable<GCPPrivateServiceConnectSubnetBuilder>, KubernetesResource
{

    @JsonProperty("region")
    private String region;
    @JsonProperty("subnet")
    private String subnet;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public GCPPrivateServiceConnectSubnet() {
    }

    public GCPPrivateServiceConnectSubnet(String region, String subnet) {
        super();
        this.region = region;
        this.subnet = subnet;
    }

    /**
     * GCPPrivateServiceConnectSubnet defines subnet and the corresponding GCP region.
     */
    @JsonProperty("region")
    public String getRegion() {
        return region;
    }

    /**
     * GCPPrivateServiceConnectSubnet defines subnet and the corresponding GCP region.
     */
    @JsonProperty("region")
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * GCPPrivateServiceConnectSubnet defines subnet and the corresponding GCP region.
     */
    @JsonProperty("subnet")
    public String getSubnet() {
        return subnet;
    }

    /**
     * GCPPrivateServiceConnectSubnet defines subnet and the corresponding GCP region.
     */
    @JsonProperty("subnet")
    public void setSubnet(String subnet) {
        this.subnet = subnet;
    }

    @JsonIgnore
    public GCPPrivateServiceConnectSubnetBuilder edit() {
        return new GCPPrivateServiceConnectSubnetBuilder(this);
    }

    @JsonIgnore
    public GCPPrivateServiceConnectSubnetBuilder toBuilder() {
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
        if (!(o instanceof GCPPrivateServiceConnectSubnet)) {
            return false;
        }
        GCPPrivateServiceConnectSubnet other = (GCPPrivateServiceConnectSubnet) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$region = this.getRegion();
        Object other$region = other.getRegion();
        if (this$region == null ? other$region != null : !this$region.equals(other$region)) {
            return false;
        }
        Object this$subnet = this.getSubnet();
        Object other$subnet = other.getSubnet();
        if (this$subnet == null ? other$subnet != null : !this$subnet.equals(other$subnet)) {
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
        return other instanceof GCPPrivateServiceConnectSubnet;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $region = this.getRegion();
        result = result * prime + ($region == null ? 43 : $region.hashCode());
        Object $subnet = this.getSubnet();
        result = result * prime + ($subnet == null ? 43 : $subnet.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "GCPPrivateServiceConnectSubnet(" + "region=" + this.getRegion() + ", subnet=" + this.getSubnet() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
