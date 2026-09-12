
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

/**
 * NetworkData represents a networkData object.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "links",
    "networks",
    "services"
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
public class NetworkData implements Editable<NetworkDataBuilder>, KubernetesResource
{

    @JsonProperty("links")
    private NetworkDataLink links;
    @JsonProperty("networks")
    private NetworkDataNetwork networks;
    @JsonProperty("services")
    private NetworkDataService services;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public NetworkData() {
    }

    public NetworkData(NetworkDataLink links, NetworkDataNetwork networks, NetworkDataService services) {
        super();
        this.links = links;
        this.networks = networks;
        this.services = services;
    }

    /**
     * NetworkData represents a networkData object.
     */
    @JsonProperty("links")
    public NetworkDataLink getLinks() {
        return links;
    }

    /**
     * NetworkData represents a networkData object.
     */
    @JsonProperty("links")
    public void setLinks(NetworkDataLink links) {
        this.links = links;
    }

    /**
     * NetworkData represents a networkData object.
     */
    @JsonProperty("networks")
    public NetworkDataNetwork getNetworks() {
        return networks;
    }

    /**
     * NetworkData represents a networkData object.
     */
    @JsonProperty("networks")
    public void setNetworks(NetworkDataNetwork networks) {
        this.networks = networks;
    }

    /**
     * NetworkData represents a networkData object.
     */
    @JsonProperty("services")
    public NetworkDataService getServices() {
        return services;
    }

    /**
     * NetworkData represents a networkData object.
     */
    @JsonProperty("services")
    public void setServices(NetworkDataService services) {
        this.services = services;
    }

    @JsonIgnore
    public NetworkDataBuilder edit() {
        return new NetworkDataBuilder(this);
    }

    @JsonIgnore
    public NetworkDataBuilder toBuilder() {
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
        if (!(o instanceof NetworkData)) {
            return false;
        }
        NetworkData other = (NetworkData) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$links = this.getLinks();
        Object other$links = other.getLinks();
        if (this$links == null ? other$links != null : !this$links.equals(other$links)) {
            return false;
        }
        Object this$networks = this.getNetworks();
        Object other$networks = other.getNetworks();
        if (this$networks == null ? other$networks != null : !this$networks.equals(other$networks)) {
            return false;
        }
        Object this$services = this.getServices();
        Object other$services = other.getServices();
        if (this$services == null ? other$services != null : !this$services.equals(other$services)) {
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
        return other instanceof NetworkData;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $links = this.getLinks();
        result = result * prime + ($links == null ? 43 : $links.hashCode());
        Object $networks = this.getNetworks();
        result = result * prime + ($networks == null ? 43 : $networks.hashCode());
        Object $services = this.getServices();
        result = result * prime + ($services == null ? 43 : $services.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "NetworkData(" + "links=" + this.getLinks() + ", networks=" + this.getNetworks() + ", services=" + this.getServices() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
