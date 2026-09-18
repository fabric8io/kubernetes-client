
package io.fabric8.openclustermanagement.api.model.operator.v1;

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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "endpointsExposure",
    "featureGates",
    "imagePullSpec"
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
public class ServerConfiguration implements Editable<ServerConfigurationBuilder>, KubernetesResource
{

    @JsonProperty("endpointsExposure")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<EndpointExposure> endpointsExposure = new ArrayList<>();
    @JsonProperty("featureGates")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<FeatureGate> featureGates = new ArrayList<>();
    @JsonProperty("imagePullSpec")
    private String imagePullSpec;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ServerConfiguration() {
    }

    public ServerConfiguration(List<EndpointExposure> endpointsExposure, List<FeatureGate> featureGates, String imagePullSpec) {
        super();
        this.endpointsExposure = endpointsExposure;
        this.featureGates = featureGates;
        this.imagePullSpec = imagePullSpec;
    }

    /**
     * endpointsExposure represents the configuration for endpoints exposure of the server.
     */
    @JsonProperty("endpointsExposure")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<EndpointExposure> getEndpointsExposure() {
        return endpointsExposure;
    }

    /**
     * endpointsExposure represents the configuration for endpoints exposure of the server.
     */
    @JsonProperty("endpointsExposure")
    public void setEndpointsExposure(List<EndpointExposure> endpointsExposure) {
        this.endpointsExposure = endpointsExposure;
    }

    /**
     * featureGates represents the features enabled for the server
     */
    @JsonProperty("featureGates")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<FeatureGate> getFeatureGates() {
        return featureGates;
    }

    /**
     * featureGates represents the features enabled for the server
     */
    @JsonProperty("featureGates")
    public void setFeatureGates(List<FeatureGate> featureGates) {
        this.featureGates = featureGates;
    }

    /**
     * imagePullSpec is the image for the server
     */
    @JsonProperty("imagePullSpec")
    public String getImagePullSpec() {
        return imagePullSpec;
    }

    /**
     * imagePullSpec is the image for the server
     */
    @JsonProperty("imagePullSpec")
    public void setImagePullSpec(String imagePullSpec) {
        this.imagePullSpec = imagePullSpec;
    }

    @JsonIgnore
    public ServerConfigurationBuilder edit() {
        return new ServerConfigurationBuilder(this);
    }

    @JsonIgnore
    public ServerConfigurationBuilder toBuilder() {
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
        if (!(o instanceof ServerConfiguration)) {
            return false;
        }
        ServerConfiguration other = (ServerConfiguration) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$endpointsExposure = this.getEndpointsExposure();
        Object other$endpointsExposure = other.getEndpointsExposure();
        if (this$endpointsExposure == null ? other$endpointsExposure != null : !this$endpointsExposure.equals(other$endpointsExposure)) {
            return false;
        }
        Object this$featureGates = this.getFeatureGates();
        Object other$featureGates = other.getFeatureGates();
        if (this$featureGates == null ? other$featureGates != null : !this$featureGates.equals(other$featureGates)) {
            return false;
        }
        Object this$imagePullSpec = this.getImagePullSpec();
        Object other$imagePullSpec = other.getImagePullSpec();
        if (this$imagePullSpec == null ? other$imagePullSpec != null : !this$imagePullSpec.equals(other$imagePullSpec)) {
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
        return other instanceof ServerConfiguration;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $endpointsExposure = this.getEndpointsExposure();
        result = result * prime + ($endpointsExposure == null ? 43 : $endpointsExposure.hashCode());
        Object $featureGates = this.getFeatureGates();
        result = result * prime + ($featureGates == null ? 43 : $featureGates.hashCode());
        Object $imagePullSpec = this.getImagePullSpec();
        result = result * prime + ($imagePullSpec == null ? 43 : $imagePullSpec.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ServerConfiguration(" + "endpointsExposure=" + this.getEndpointsExposure() + ", featureGates=" + this.getFeatureGates() + ", imagePullSpec=" + this.getImagePullSpec() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
