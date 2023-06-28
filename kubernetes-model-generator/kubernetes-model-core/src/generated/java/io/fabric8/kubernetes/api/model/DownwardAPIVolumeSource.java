
package io.fabric8.kubernetes.api.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.sundr.builder.annotations.Buildable;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "defaultMode",
    "items"
})
@ToString
@EqualsAndHashCode
@Setter
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = true, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("jsonschema2pojo")
public class DownwardAPIVolumeSource implements KubernetesResource
{

    @JsonProperty("defaultMode")
    private Integer defaultMode;
    @JsonProperty("items")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<DownwardAPIVolumeFile> items = new ArrayList<DownwardAPIVolumeFile>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public DownwardAPIVolumeSource() {
    }

    public DownwardAPIVolumeSource(Integer defaultMode, List<DownwardAPIVolumeFile> items) {
        super();
        this.defaultMode = defaultMode;
        this.items = items;
    }

    @JsonProperty("defaultMode")
    public Integer getDefaultMode() {
        return defaultMode;
    }

    @JsonProperty("defaultMode")
    public void setDefaultMode(Integer defaultMode) {
        this.defaultMode = defaultMode;
    }

    @JsonProperty("items")
    public List<DownwardAPIVolumeFile> getItems() {
        return items;
    }

    @JsonProperty("items")
    public void setItems(List<DownwardAPIVolumeFile> items) {
        this.items = items;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
