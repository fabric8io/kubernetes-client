
package io.fabric8.kubernetes.api.model;

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
import io.sundr.builder.annotations.Buildable;

/**
 * NamespaceSpec describes the attributes on a Namespace.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "finalizers"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class NamespaceSpec implements Editable<NamespaceSpecBuilder>, KubernetesResource
{

    @JsonProperty("finalizers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> finalizers = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public NamespaceSpec() {
    }

    public NamespaceSpec(List<String> finalizers) {
        super();
        this.finalizers = finalizers;
    }

    /**
     * Finalizers is an opaque list of values that must be empty to permanently remove object from storage. More info: https://kubernetes.io/docs/tasks/administer-cluster/namespaces/
     */
    @JsonProperty("finalizers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getFinalizers() {
        return finalizers;
    }

    /**
     * Finalizers is an opaque list of values that must be empty to permanently remove object from storage. More info: https://kubernetes.io/docs/tasks/administer-cluster/namespaces/
     */
    @JsonProperty("finalizers")
    public void setFinalizers(List<String> finalizers) {
        this.finalizers = finalizers;
    }

    @JsonIgnore
    public NamespaceSpecBuilder edit() {
        return new NamespaceSpecBuilder(this);
    }

    @JsonIgnore
    public NamespaceSpecBuilder toBuilder() {
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
        if (!(o instanceof NamespaceSpec)) {
            return false;
        }
        NamespaceSpec other = (NamespaceSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$finalizers = this.getFinalizers();
        Object other$finalizers = other.getFinalizers();
        if (this$finalizers == null ? other$finalizers != null : !this$finalizers.equals(other$finalizers)) {
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
        return other instanceof NamespaceSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $finalizers = this.getFinalizers();
        result = result * prime + ($finalizers == null ? 43 : $finalizers.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "NamespaceSpec(" + "finalizers=" + this.getFinalizers() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
