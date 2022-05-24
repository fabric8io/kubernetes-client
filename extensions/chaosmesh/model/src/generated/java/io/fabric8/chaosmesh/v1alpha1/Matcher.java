
package io.fabric8.chaosmesh.v1alpha1;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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
    "exact_match",
    "invert_match",
    "name",
    "prefix_match",
    "present_match",
    "range_match",
    "regex_match",
    "safe_regex_match",
    "suffix_match"
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
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
public class Matcher implements KubernetesResource
{

    @JsonProperty("exact_match")
    private String exactMatch;
    @JsonProperty("invert_match")
    private String invertMatch;
    @JsonProperty("name")
    private java.lang.String name;
    @JsonProperty("prefix_match")
    private String prefixMatch;
    @JsonProperty("present_match")
    private String presentMatch;
    @JsonProperty("range_match")
    private String rangeMatch;
    @JsonProperty("regex_match")
    private String regexMatch;
    @JsonProperty("safe_regex_match")
    private String safeRegexMatch;
    @JsonProperty("suffix_match")
    private String suffixMatch;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new HashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Matcher() {
    }

    /**
     * 
     * @param rangeMatch
     * @param presentMatch
     * @param exactMatch
     * @param suffixMatch
     * @param safeRegexMatch
     * @param name
     * @param prefixMatch
     * @param regexMatch
     * @param invertMatch
     */
    public Matcher(String exactMatch, String invertMatch, java.lang.String name, String prefixMatch, String presentMatch, String rangeMatch, String regexMatch, String safeRegexMatch, String suffixMatch) {
        super();
        this.exactMatch = exactMatch;
        this.invertMatch = invertMatch;
        this.name = name;
        this.prefixMatch = prefixMatch;
        this.presentMatch = presentMatch;
        this.rangeMatch = rangeMatch;
        this.regexMatch = regexMatch;
        this.safeRegexMatch = safeRegexMatch;
        this.suffixMatch = suffixMatch;
    }

    @JsonProperty("exact_match")
    public String getExactMatch() {
        return exactMatch;
    }

    @JsonProperty("exact_match")
    public void setExactMatch(String exactMatch) {
        this.exactMatch = exactMatch;
    }

    @JsonProperty("invert_match")
    public String getInvertMatch() {
        return invertMatch;
    }

    @JsonProperty("invert_match")
    public void setInvertMatch(String invertMatch) {
        this.invertMatch = invertMatch;
    }

    @JsonProperty("name")
    public java.lang.String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(java.lang.String name) {
        this.name = name;
    }

    @JsonProperty("prefix_match")
    public String getPrefixMatch() {
        return prefixMatch;
    }

    @JsonProperty("prefix_match")
    public void setPrefixMatch(String prefixMatch) {
        this.prefixMatch = prefixMatch;
    }

    @JsonProperty("present_match")
    public String getPresentMatch() {
        return presentMatch;
    }

    @JsonProperty("present_match")
    public void setPresentMatch(String presentMatch) {
        this.presentMatch = presentMatch;
    }

    @JsonProperty("range_match")
    public String getRangeMatch() {
        return rangeMatch;
    }

    @JsonProperty("range_match")
    public void setRangeMatch(String rangeMatch) {
        this.rangeMatch = rangeMatch;
    }

    @JsonProperty("regex_match")
    public String getRegexMatch() {
        return regexMatch;
    }

    @JsonProperty("regex_match")
    public void setRegexMatch(String regexMatch) {
        this.regexMatch = regexMatch;
    }

    @JsonProperty("safe_regex_match")
    public String getSafeRegexMatch() {
        return safeRegexMatch;
    }

    @JsonProperty("safe_regex_match")
    public void setSafeRegexMatch(String safeRegexMatch) {
        this.safeRegexMatch = safeRegexMatch;
    }

    @JsonProperty("suffix_match")
    public String getSuffixMatch() {
        return suffixMatch;
    }

    @JsonProperty("suffix_match")
    public void setSuffixMatch(String suffixMatch) {
        this.suffixMatch = suffixMatch;
    }

    @JsonAnyGetter
    public Map<java.lang.String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
