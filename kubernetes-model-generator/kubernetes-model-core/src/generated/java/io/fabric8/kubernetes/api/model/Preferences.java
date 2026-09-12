
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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "colors",
    "extensions"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class Preferences implements Editable<PreferencesBuilder>, KubernetesResource
{

    @JsonProperty("colors")
    private Boolean colors;
    @JsonProperty("extensions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<NamedExtension> extensions = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Preferences() {
    }

    public Preferences(Boolean colors, List<NamedExtension> extensions) {
        super();
        this.colors = colors;
        this.extensions = extensions;
    }

    @JsonProperty("colors")
    public Boolean getColors() {
        return colors;
    }

    @JsonProperty("colors")
    public void setColors(Boolean colors) {
        this.colors = colors;
    }

    @JsonProperty("extensions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<NamedExtension> getExtensions() {
        return extensions;
    }

    @JsonProperty("extensions")
    public void setExtensions(List<NamedExtension> extensions) {
        this.extensions = extensions;
    }

    @JsonIgnore
    public PreferencesBuilder edit() {
        return new PreferencesBuilder(this);
    }

    @JsonIgnore
    public PreferencesBuilder toBuilder() {
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
        if (!(o instanceof Preferences)) {
            return false;
        }
        Preferences other = (Preferences) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$colors = this.getColors();
        Object other$colors = other.getColors();
        if (this$colors == null ? other$colors != null : !this$colors.equals(other$colors)) {
            return false;
        }
        Object this$extensions = this.getExtensions();
        Object other$extensions = other.getExtensions();
        if (this$extensions == null ? other$extensions != null : !this$extensions.equals(other$extensions)) {
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
        return other instanceof Preferences;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $colors = this.getColors();
        result = result * prime + ($colors == null ? 43 : $colors.hashCode());
        Object $extensions = this.getExtensions();
        result = result * prime + ($extensions == null ? 43 : $extensions.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Preferences(" + "colors=" + this.getColors() + ", extensions=" + this.getExtensions() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
