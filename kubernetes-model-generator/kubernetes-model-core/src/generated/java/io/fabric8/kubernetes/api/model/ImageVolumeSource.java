
package io.fabric8.kubernetes.api.model;

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
import io.sundr.builder.annotations.Buildable;

/**
 * ImageVolumeSource represents a image volume resource.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "pullPolicy",
    "reference"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ImageVolumeSource implements Editable<ImageVolumeSourceBuilder>, KubernetesResource
{

    @JsonProperty("pullPolicy")
    private String pullPolicy;
    @JsonProperty("reference")
    private String reference;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ImageVolumeSource() {
    }

    public ImageVolumeSource(String pullPolicy, String reference) {
        super();
        this.pullPolicy = pullPolicy;
        this.reference = reference;
    }

    /**
     * Policy for pulling OCI objects. Possible values are: Always: the kubelet always attempts to pull the reference. Container creation will fail If the pull fails. Never: the kubelet never pulls the reference and only uses a local image or artifact. Container creation will fail if the reference isn't present. IfNotPresent: the kubelet pulls if the reference isn't already present on disk. Container creation will fail if the reference isn't present and the pull fails. Defaults to Always if :latest tag is specified, or IfNotPresent otherwise.
     */
    @JsonProperty("pullPolicy")
    public String getPullPolicy() {
        return pullPolicy;
    }

    /**
     * Policy for pulling OCI objects. Possible values are: Always: the kubelet always attempts to pull the reference. Container creation will fail If the pull fails. Never: the kubelet never pulls the reference and only uses a local image or artifact. Container creation will fail if the reference isn't present. IfNotPresent: the kubelet pulls if the reference isn't already present on disk. Container creation will fail if the reference isn't present and the pull fails. Defaults to Always if :latest tag is specified, or IfNotPresent otherwise.
     */
    @JsonProperty("pullPolicy")
    public void setPullPolicy(String pullPolicy) {
        this.pullPolicy = pullPolicy;
    }

    /**
     * Required: Image or artifact reference to be used. Behaves in the same way as pod.spec.containers[&#42;].image. Pull secrets will be assembled in the same way as for the container image by looking up node credentials, SA image pull secrets, and pod spec image pull secrets. More info: https://kubernetes.io/docs/concepts/containers/images This field is optional to allow higher level config management to default or override container images in workload controllers like Deployments and StatefulSets.
     */
    @JsonProperty("reference")
    public String getReference() {
        return reference;
    }

    /**
     * Required: Image or artifact reference to be used. Behaves in the same way as pod.spec.containers[&#42;].image. Pull secrets will be assembled in the same way as for the container image by looking up node credentials, SA image pull secrets, and pod spec image pull secrets. More info: https://kubernetes.io/docs/concepts/containers/images This field is optional to allow higher level config management to default or override container images in workload controllers like Deployments and StatefulSets.
     */
    @JsonProperty("reference")
    public void setReference(String reference) {
        this.reference = reference;
    }

    @JsonIgnore
    public ImageVolumeSourceBuilder edit() {
        return new ImageVolumeSourceBuilder(this);
    }

    @JsonIgnore
    public ImageVolumeSourceBuilder toBuilder() {
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
        if (!(o instanceof ImageVolumeSource)) {
            return false;
        }
        ImageVolumeSource other = (ImageVolumeSource) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$pullPolicy = this.getPullPolicy();
        Object other$pullPolicy = other.getPullPolicy();
        if (this$pullPolicy == null ? other$pullPolicy != null : !this$pullPolicy.equals(other$pullPolicy)) {
            return false;
        }
        Object this$reference = this.getReference();
        Object other$reference = other.getReference();
        if (this$reference == null ? other$reference != null : !this$reference.equals(other$reference)) {
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
        return other instanceof ImageVolumeSource;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $pullPolicy = this.getPullPolicy();
        result = result * prime + ($pullPolicy == null ? 43 : $pullPolicy.hashCode());
        Object $reference = this.getReference();
        result = result * prime + ($reference == null ? 43 : $reference.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ImageVolumeSource(" + "pullPolicy=" + this.getPullPolicy() + ", reference=" + this.getReference() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
