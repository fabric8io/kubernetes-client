
package io.fabric8.kubernetes.api.model.clusterapi.core.v1beta1;

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
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.sundr.builder.annotations.Buildable;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "attributes",
    "controlPlane"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class FailureDomainSpec implements Editable<FailureDomainSpecBuilder>, KubernetesResource
{

    @JsonProperty("attributes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> attributes = new LinkedHashMap<>();
    @JsonProperty("controlPlane")
    private Boolean controlPlane;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public FailureDomainSpec() {
    }

    public FailureDomainSpec(Map<String, String> attributes, Boolean controlPlane) {
        super();
        this.attributes = attributes;
        this.controlPlane = controlPlane;
    }

    @JsonProperty("attributes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getAttributes() {
        return attributes;
    }

    @JsonProperty("attributes")
    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }

    @JsonProperty("controlPlane")
    public Boolean getControlPlane() {
        return controlPlane;
    }

    @JsonProperty("controlPlane")
    public void setControlPlane(Boolean controlPlane) {
        this.controlPlane = controlPlane;
    }

    @JsonIgnore
    public FailureDomainSpecBuilder edit() {
        return new FailureDomainSpecBuilder(this);
    }

    @JsonIgnore
    public FailureDomainSpecBuilder toBuilder() {
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
        if (!(o instanceof FailureDomainSpec)) {
            return false;
        }
        FailureDomainSpec other = (FailureDomainSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$attributes = this.getAttributes();
        Object other$attributes = other.getAttributes();
        if (this$attributes == null ? other$attributes != null : !this$attributes.equals(other$attributes)) {
            return false;
        }
        Object this$controlPlane = this.getControlPlane();
        Object other$controlPlane = other.getControlPlane();
        if (this$controlPlane == null ? other$controlPlane != null : !this$controlPlane.equals(other$controlPlane)) {
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
        return other instanceof FailureDomainSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $attributes = this.getAttributes();
        result = result * prime + ($attributes == null ? 43 : $attributes.hashCode());
        Object $controlPlane = this.getControlPlane();
        result = result * prime + ($controlPlane == null ? 43 : $controlPlane.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "FailureDomainSpec(" + "attributes=" + this.getAttributes() + ", controlPlane=" + this.getControlPlane() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
