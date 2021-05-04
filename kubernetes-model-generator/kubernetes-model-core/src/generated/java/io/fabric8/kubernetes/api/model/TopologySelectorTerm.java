
package io.fabric8.kubernetes.api.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.sundr.builder.annotations.Buildable;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "matchLabelExpressions"
})
@ToString
@EqualsAndHashCode
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = true, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
public class TopologySelectorTerm implements KubernetesResource
{

    @JsonProperty("matchLabelExpressions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TopologySelectorLabelRequirement> matchLabelExpressions = new ArrayList<TopologySelectorLabelRequirement>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public TopologySelectorTerm() {
    }

    /**
     * 
     * @param matchLabelExpressions
     */
    public TopologySelectorTerm(List<TopologySelectorLabelRequirement> matchLabelExpressions) {
        super();
        this.matchLabelExpressions = matchLabelExpressions;
    }

    @JsonProperty("matchLabelExpressions")
    public List<TopologySelectorLabelRequirement> getMatchLabelExpressions() {
        return matchLabelExpressions;
    }

    @JsonProperty("matchLabelExpressions")
    public void setMatchLabelExpressions(List<TopologySelectorLabelRequirement> matchLabelExpressions) {
        this.matchLabelExpressions = matchLabelExpressions;
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
