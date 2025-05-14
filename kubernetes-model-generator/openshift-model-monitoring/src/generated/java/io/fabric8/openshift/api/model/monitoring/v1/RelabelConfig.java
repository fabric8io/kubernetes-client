
package io.fabric8.openshift.api.model.monitoring.v1;

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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * RelabelConfig allows dynamic rewriting of label sets for alerts. See Prometheus documentation: - https://prometheus.io/docs/prometheus/latest/configuration/configuration/#alert_relabel_configs - https://prometheus.io/docs/prometheus/latest/configuration/configuration/#relabel_config
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
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
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class RelabelConfig implements Editable<RelabelConfigBuilder>, KubernetesResource
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
    private List<String> sourceLabels = new ArrayList<>();
    @JsonProperty("targetLabel")
    private String targetLabel;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
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

    /**
     * action to perform based on regex matching. Must be one of: 'Replace', 'Keep', 'Drop', 'HashMod', 'LabelMap', 'LabelDrop', or 'LabelKeep'. Default is: 'Replace'
     */
    @JsonProperty("action")
    public String getAction() {
        return action;
    }

    /**
     * action to perform based on regex matching. Must be one of: 'Replace', 'Keep', 'Drop', 'HashMod', 'LabelMap', 'LabelDrop', or 'LabelKeep'. Default is: 'Replace'
     */
    @JsonProperty("action")
    public void setAction(String action) {
        this.action = action;
    }

    /**
     * modulus to take of the hash of the source label values.  This can be combined with the 'HashMod' action to set 'target_label' to the 'modulus' of a hash of the concatenated 'source_labels'. This is only valid if sourceLabels is not empty and action is not 'LabelKeep' or 'LabelDrop'.
     */
    @JsonProperty("modulus")
    public Long getModulus() {
        return modulus;
    }

    /**
     * modulus to take of the hash of the source label values.  This can be combined with the 'HashMod' action to set 'target_label' to the 'modulus' of a hash of the concatenated 'source_labels'. This is only valid if sourceLabels is not empty and action is not 'LabelKeep' or 'LabelDrop'.
     */
    @JsonProperty("modulus")
    public void setModulus(Long modulus) {
        this.modulus = modulus;
    }

    /**
     * regex against which the extracted value is matched. Default is: '(.&#42;)' regex is required for all actions except 'HashMod'
     */
    @JsonProperty("regex")
    public String getRegex() {
        return regex;
    }

    /**
     * regex against which the extracted value is matched. Default is: '(.&#42;)' regex is required for all actions except 'HashMod'
     */
    @JsonProperty("regex")
    public void setRegex(String regex) {
        this.regex = regex;
    }

    /**
     * replacement value against which a regex replace is performed if the regular expression matches. This is required if the action is 'Replace' or 'LabelMap' and forbidden for actions 'LabelKeep' and 'LabelDrop'. Regex capture groups are available. Default is: '$1'
     */
    @JsonProperty("replacement")
    public String getReplacement() {
        return replacement;
    }

    /**
     * replacement value against which a regex replace is performed if the regular expression matches. This is required if the action is 'Replace' or 'LabelMap' and forbidden for actions 'LabelKeep' and 'LabelDrop'. Regex capture groups are available. Default is: '$1'
     */
    @JsonProperty("replacement")
    public void setReplacement(String replacement) {
        this.replacement = replacement;
    }

    /**
     * separator placed between concatenated source label values. When omitted, Prometheus will use its default value of ';'.
     */
    @JsonProperty("separator")
    public String getSeparator() {
        return separator;
    }

    /**
     * separator placed between concatenated source label values. When omitted, Prometheus will use its default value of ';'.
     */
    @JsonProperty("separator")
    public void setSeparator(String separator) {
        this.separator = separator;
    }

    /**
     * sourceLabels select values from existing labels. Their content is concatenated using the configured separator and matched against the configured regular expression for the 'Replace', 'Keep', and 'Drop' actions. Not allowed for actions 'LabelKeep' and 'LabelDrop'.
     */
    @JsonProperty("sourceLabels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getSourceLabels() {
        return sourceLabels;
    }

    /**
     * sourceLabels select values from existing labels. Their content is concatenated using the configured separator and matched against the configured regular expression for the 'Replace', 'Keep', and 'Drop' actions. Not allowed for actions 'LabelKeep' and 'LabelDrop'.
     */
    @JsonProperty("sourceLabels")
    public void setSourceLabels(List<String> sourceLabels) {
        this.sourceLabels = sourceLabels;
    }

    /**
     * targetLabel to which the resulting value is written in a 'Replace' action. It is required for 'Replace' and 'HashMod' actions and forbidden for actions 'LabelKeep' and 'LabelDrop'. Regex capture groups are available.
     */
    @JsonProperty("targetLabel")
    public String getTargetLabel() {
        return targetLabel;
    }

    /**
     * targetLabel to which the resulting value is written in a 'Replace' action. It is required for 'Replace' and 'HashMod' actions and forbidden for actions 'LabelKeep' and 'LabelDrop'. Regex capture groups are available.
     */
    @JsonProperty("targetLabel")
    public void setTargetLabel(String targetLabel) {
        this.targetLabel = targetLabel;
    }

    @JsonIgnore
    public RelabelConfigBuilder edit() {
        return new RelabelConfigBuilder(this);
    }

    @JsonIgnore
    public RelabelConfigBuilder toBuilder() {
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

}
