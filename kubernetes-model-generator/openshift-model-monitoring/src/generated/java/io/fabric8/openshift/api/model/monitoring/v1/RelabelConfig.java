
package io.fabric8.openshift.api.model.monitoring.v1;

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
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
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
    "action",
    "modulus",
    "regex",
    "replacement",
    "separator",
    "sourceLabels",
    "targetLabel"
})
@ToString
@EqualsAndHashCode
@Setter
@Accessors(prefix = {
    "_",
    ""
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
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class RelabelConfig implements KubernetesResource
{

    @JsonProperty("action")
    private String action;
    @JsonProperty("modulus")
    private Long modulus;
    @JsonProperty("regex")
    private String regex;
    @JsonProperty("replacement")
    private String replacement;
    @JsonProperty("separator")
    private String separator;
    @JsonProperty("sourceLabels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> sourceLabels = new ArrayList<String>();
    @JsonProperty("targetLabel")
    private String targetLabel;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public RelabelConfig() {
    }

    public RelabelConfig(String action, Long modulus, String regex, String replacement, String separator, List<String> sourceLabels, String targetLabel) {
        super();
        this.action = action;
        this.modulus = modulus;
        this.regex = regex;
        this.replacement = replacement;
        this.separator = separator;
        this.sourceLabels = sourceLabels;
        this.targetLabel = targetLabel;
    }

    @JsonProperty("action")
    public String getAction() {
        return action;
    }

    @JsonProperty("action")
    public void setAction(String action) {
        this.action = action;
    }

    @JsonProperty("modulus")
    public Long getModulus() {
        return modulus;
    }

    @JsonProperty("modulus")
    public void setModulus(Long modulus) {
        this.modulus = modulus;
    }

    @JsonProperty("regex")
    public String getRegex() {
        return regex;
    }

    @JsonProperty("regex")
    public void setRegex(String regex) {
        this.regex = regex;
    }

    @JsonProperty("replacement")
    public String getReplacement() {
        return replacement;
    }

    @JsonProperty("replacement")
    public void setReplacement(String replacement) {
        this.replacement = replacement;
    }

    @JsonProperty("separator")
    public String getSeparator() {
        return separator;
    }

    @JsonProperty("separator")
    public void setSeparator(String separator) {
        this.separator = separator;
    }

    @JsonProperty("sourceLabels")
    public List<String> getSourceLabels() {
        return sourceLabels;
    }

    @JsonProperty("sourceLabels")
    public void setSourceLabels(List<String> sourceLabels) {
        this.sourceLabels = sourceLabels;
    }

    @JsonProperty("targetLabel")
    public String getTargetLabel() {
        return targetLabel;
    }

    @JsonProperty("targetLabel")
    public void setTargetLabel(String targetLabel) {
        this.targetLabel = targetLabel;
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
