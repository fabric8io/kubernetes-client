
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
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
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
    "catalogSourceRef",
    "conditions",
    "identifier",
    "path",
    "properties",
    "replaces"
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
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class BundleLookup implements KubernetesResource
{

    @JsonProperty("catalogSourceRef")
    private io.fabric8.kubernetes.api.model.ObjectReference catalogSourceRef;
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<BundleLookupCondition> conditions = new ArrayList<BundleLookupCondition>();
    @JsonProperty("identifier")
    private String identifier;
    @JsonProperty("path")
    private String path;
    @JsonProperty("properties")
    private String properties;
    @JsonProperty("replaces")
    private String replaces;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public BundleLookup() {
    }

    public BundleLookup(io.fabric8.kubernetes.api.model.ObjectReference catalogSourceRef, List<BundleLookupCondition> conditions, String identifier, String path, String properties, String replaces) {
        super();
        this.catalogSourceRef = catalogSourceRef;
        this.conditions = conditions;
        this.identifier = identifier;
        this.path = path;
        this.properties = properties;
        this.replaces = replaces;
    }

    @JsonProperty("catalogSourceRef")
    public io.fabric8.kubernetes.api.model.ObjectReference getCatalogSourceRef() {
        return catalogSourceRef;
    }

    @JsonProperty("catalogSourceRef")
    public void setCatalogSourceRef(io.fabric8.kubernetes.api.model.ObjectReference catalogSourceRef) {
        this.catalogSourceRef = catalogSourceRef;
    }

    @JsonProperty("conditions")
    public List<BundleLookupCondition> getConditions() {
        return conditions;
    }

    @JsonProperty("conditions")
    public void setConditions(List<BundleLookupCondition> conditions) {
        this.conditions = conditions;
    }

    @JsonProperty("identifier")
    public String getIdentifier() {
        return identifier;
    }

    @JsonProperty("identifier")
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    @JsonProperty("path")
    public String getPath() {
        return path;
    }

    @JsonProperty("path")
    public void setPath(String path) {
        this.path = path;
    }

    @JsonProperty("properties")
    public String getProperties() {
        return properties;
    }

    @JsonProperty("properties")
    public void setProperties(String properties) {
        this.properties = properties;
    }

    @JsonProperty("replaces")
    public String getReplaces() {
        return replaces;
    }

    @JsonProperty("replaces")
    public void setReplaces(String replaces) {
        this.replaces = replaces;
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
