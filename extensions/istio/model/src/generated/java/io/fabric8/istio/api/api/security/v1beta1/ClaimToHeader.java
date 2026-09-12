
package io.fabric8.istio.api.api.security.v1beta1;

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
 * This message specifies the detail for copying claim to header.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "claim",
    "header"
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
public class ClaimToHeader implements Editable<ClaimToHeaderBuilder>, KubernetesResource
{

    @JsonProperty("claim")
    private String claim;
    @JsonProperty("header")
    private String header;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ClaimToHeader() {
    }

    public ClaimToHeader(String claim, String header) {
        super();
        this.claim = claim;
        this.header = header;
    }

    /**
     * The name of the claim to be copied from. Only claim of type string/int/bool is supported. The header will not be there if the claim does not exist or the type of the claim is not supported.
     */
    @JsonProperty("claim")
    public String getClaim() {
        return claim;
    }

    /**
     * The name of the claim to be copied from. Only claim of type string/int/bool is supported. The header will not be there if the claim does not exist or the type of the claim is not supported.
     */
    @JsonProperty("claim")
    public void setClaim(String claim) {
        this.claim = claim;
    }

    /**
     * The name of the header to be created. The header will be overridden if it already exists in the request.
     */
    @JsonProperty("header")
    public String getHeader() {
        return header;
    }

    /**
     * The name of the header to be created. The header will be overridden if it already exists in the request.
     */
    @JsonProperty("header")
    public void setHeader(String header) {
        this.header = header;
    }

    @JsonIgnore
    public ClaimToHeaderBuilder edit() {
        return new ClaimToHeaderBuilder(this);
    }

    @JsonIgnore
    public ClaimToHeaderBuilder toBuilder() {
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
        if (!(o instanceof ClaimToHeader)) {
            return false;
        }
        ClaimToHeader other = (ClaimToHeader) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$claim = this.getClaim();
        Object other$claim = other.getClaim();
        if (this$claim == null ? other$claim != null : !this$claim.equals(other$claim)) {
            return false;
        }
        Object this$header = this.getHeader();
        Object other$header = other.getHeader();
        if (this$header == null ? other$header != null : !this$header.equals(other$header)) {
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
        return other instanceof ClaimToHeader;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $claim = this.getClaim();
        result = result * prime + ($claim == null ? 43 : $claim.hashCode());
        Object $header = this.getHeader();
        result = result * prime + ($header == null ? 43 : $header.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ClaimToHeader(" + "claim=" + this.getClaim() + ", header=" + this.getHeader() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
