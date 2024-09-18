
package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

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
import io.fabric8.kubernetes.api.builder.Editable;
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
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "matchExpressions",
    "matchLabels"
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
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class CatalogSourceSpecGPCAPAPDSIDEPATLabelSelector implements Editable<CatalogSourceSpecGPCAPAPDSIDEPATLabelSelectorBuilder> , KubernetesResource
{

    @JsonProperty("matchExpressions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<CatalogSourceSpecGPCAPAPDSIDEPATLSMatchExpressions> matchExpressions = new ArrayList<>();
    @JsonProperty("matchLabels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> matchLabels = new LinkedHashMap<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public CatalogSourceSpecGPCAPAPDSIDEPATLabelSelector() {
    }

    public CatalogSourceSpecGPCAPAPDSIDEPATLabelSelector(List<CatalogSourceSpecGPCAPAPDSIDEPATLSMatchExpressions> matchExpressions, Map<String, String> matchLabels) {
        super();
        this.matchExpressions = matchExpressions;
        this.matchLabels = matchLabels;
    }

    @JsonProperty("matchExpressions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<CatalogSourceSpecGPCAPAPDSIDEPATLSMatchExpressions> getMatchExpressions() {
        return matchExpressions;
    }

    @JsonProperty("matchExpressions")
    public void setMatchExpressions(List<CatalogSourceSpecGPCAPAPDSIDEPATLSMatchExpressions> matchExpressions) {
        this.matchExpressions = matchExpressions;
    }

    @JsonProperty("matchLabels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getMatchLabels() {
        return matchLabels;
    }

    @JsonProperty("matchLabels")
    public void setMatchLabels(Map<String, String> matchLabels) {
        this.matchLabels = matchLabels;
    }

    @JsonIgnore
    public CatalogSourceSpecGPCAPAPDSIDEPATLabelSelectorBuilder edit() {
        return new CatalogSourceSpecGPCAPAPDSIDEPATLabelSelectorBuilder(this);
    }

    @JsonIgnore
    public CatalogSourceSpecGPCAPAPDSIDEPATLabelSelectorBuilder toBuilder() {
        return edit();
    }

    @JsonAnyGetter
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
