
package io.fabric8.openshift.api.model.installer.gcp.v1;

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
 * PSCEndpoint contains the information to describe a Private Service Connect endpoint.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "clusterUseOnly",
    "name",
    "region"
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
public class PSCEndpoint implements Editable<PSCEndpointBuilder>, KubernetesResource
{

    @JsonProperty("clusterUseOnly")
    private Boolean clusterUseOnly;
    @JsonProperty("name")
    private String name;
    @JsonProperty("region")
    private String region;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PSCEndpoint() {
    }

    public PSCEndpoint(Boolean clusterUseOnly, String name, String region) {
        super();
        this.clusterUseOnly = clusterUseOnly;
        this.name = name;
        this.region = region;
    }

    /**
     * ClusterUseOnly should be set to true when the installer should use the public api endpoints and all cluster operators should use the api endpoint overrides. The value should be false when the installer and cluster operators should use the api endpoint overrides; that is, the installer is being run in the same network as the cluster.
     */
    @JsonProperty("clusterUseOnly")
    public Boolean getClusterUseOnly() {
        return clusterUseOnly;
    }

    /**
     * ClusterUseOnly should be set to true when the installer should use the public api endpoints and all cluster operators should use the api endpoint overrides. The value should be false when the installer and cluster operators should use the api endpoint overrides; that is, the installer is being run in the same network as the cluster.
     */
    @JsonProperty("clusterUseOnly")
    public void setClusterUseOnly(Boolean clusterUseOnly) {
        this.clusterUseOnly = clusterUseOnly;
    }

    /**
     * Name contains the name of the private service connect endpoint.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Name contains the name of the private service connect endpoint.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Region is the region where the endpoint resides. When the region is empty, the location is assumed to be global.
     */
    @JsonProperty("region")
    public String getRegion() {
        return region;
    }

    /**
     * Region is the region where the endpoint resides. When the region is empty, the location is assumed to be global.
     */
    @JsonProperty("region")
    public void setRegion(String region) {
        this.region = region;
    }

    @JsonIgnore
    public PSCEndpointBuilder edit() {
        return new PSCEndpointBuilder(this);
    }

    @JsonIgnore
    public PSCEndpointBuilder toBuilder() {
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
        if (!(o instanceof PSCEndpoint)) {
            return false;
        }
        PSCEndpoint other = (PSCEndpoint) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$clusterUseOnly = this.getClusterUseOnly();
        Object other$clusterUseOnly = other.getClusterUseOnly();
        if (this$clusterUseOnly == null ? other$clusterUseOnly != null : !this$clusterUseOnly.equals(other$clusterUseOnly)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
            return false;
        }
        Object this$region = this.getRegion();
        Object other$region = other.getRegion();
        if (this$region == null ? other$region != null : !this$region.equals(other$region)) {
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
        return other instanceof PSCEndpoint;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $clusterUseOnly = this.getClusterUseOnly();
        result = result * prime + ($clusterUseOnly == null ? 43 : $clusterUseOnly.hashCode());
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $region = this.getRegion();
        result = result * prime + ($region == null ? 43 : $region.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "PSCEndpoint(" + "clusterUseOnly=" + this.getClusterUseOnly() + ", name=" + this.getName() + ", region=" + this.getRegion() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
