
package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

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

/**
 * BundleLookup is a request to pull and unpackage the content of a bundle to the cluster.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "catalogSourceRef",
    "conditions",
    "identifier",
    "path",
    "properties",
    "replaces"
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
public class BundleLookup implements Editable<BundleLookupBuilder>, KubernetesResource
{

    @JsonProperty("catalogSourceRef")
    private ObjectReference catalogSourceRef;
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<BundleLookupCondition> conditions = new ArrayList<>();
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
     */
    public BundleLookup() {
    }

    public BundleLookup(ObjectReference catalogSourceRef, List<BundleLookupCondition> conditions, String identifier, String path, String properties, String replaces) {
        super();
        this.catalogSourceRef = catalogSourceRef;
        this.conditions = conditions;
        this.identifier = identifier;
        this.path = path;
        this.properties = properties;
        this.replaces = replaces;
    }

    /**
     * BundleLookup is a request to pull and unpackage the content of a bundle to the cluster.
     */
    @JsonProperty("catalogSourceRef")
    public ObjectReference getCatalogSourceRef() {
        return catalogSourceRef;
    }

    /**
     * BundleLookup is a request to pull and unpackage the content of a bundle to the cluster.
     */
    @JsonProperty("catalogSourceRef")
    public void setCatalogSourceRef(ObjectReference catalogSourceRef) {
        this.catalogSourceRef = catalogSourceRef;
    }

    /**
     * Conditions represents the overall state of a BundleLookup.
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<BundleLookupCondition> getConditions() {
        return conditions;
    }

    /**
     * Conditions represents the overall state of a BundleLookup.
     */
    @JsonProperty("conditions")
    public void setConditions(List<BundleLookupCondition> conditions) {
        this.conditions = conditions;
    }

    /**
     * Identifier is the catalog-unique name of the operator (the name of the CSV for bundles that contain CSVs)
     */
    @JsonProperty("identifier")
    public String getIdentifier() {
        return identifier;
    }

    /**
     * Identifier is the catalog-unique name of the operator (the name of the CSV for bundles that contain CSVs)
     */
    @JsonProperty("identifier")
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    /**
     * Path refers to the location of a bundle to pull. It's typically an image reference.
     */
    @JsonProperty("path")
    public String getPath() {
        return path;
    }

    /**
     * Path refers to the location of a bundle to pull. It's typically an image reference.
     */
    @JsonProperty("path")
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * The effective properties of the unpacked bundle.
     */
    @JsonProperty("properties")
    public String getProperties() {
        return properties;
    }

    /**
     * The effective properties of the unpacked bundle.
     */
    @JsonProperty("properties")
    public void setProperties(String properties) {
        this.properties = properties;
    }

    /**
     * Replaces is the name of the bundle to replace with the one found at Path.
     */
    @JsonProperty("replaces")
    public String getReplaces() {
        return replaces;
    }

    /**
     * Replaces is the name of the bundle to replace with the one found at Path.
     */
    @JsonProperty("replaces")
    public void setReplaces(String replaces) {
        this.replaces = replaces;
    }

    @JsonIgnore
    public BundleLookupBuilder edit() {
        return new BundleLookupBuilder(this);
    }

    @JsonIgnore
    public BundleLookupBuilder toBuilder() {
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
        if (!(o instanceof BundleLookup)) {
            return false;
        }
        BundleLookup other = (BundleLookup) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$catalogSourceRef = this.getCatalogSourceRef();
        Object other$catalogSourceRef = other.getCatalogSourceRef();
        if (this$catalogSourceRef == null ? other$catalogSourceRef != null : !this$catalogSourceRef.equals(other$catalogSourceRef)) {
            return false;
        }
        Object this$conditions = this.getConditions();
        Object other$conditions = other.getConditions();
        if (this$conditions == null ? other$conditions != null : !this$conditions.equals(other$conditions)) {
            return false;
        }
        Object this$identifier = this.getIdentifier();
        Object other$identifier = other.getIdentifier();
        if (this$identifier == null ? other$identifier != null : !this$identifier.equals(other$identifier)) {
            return false;
        }
        Object this$path = this.getPath();
        Object other$path = other.getPath();
        if (this$path == null ? other$path != null : !this$path.equals(other$path)) {
            return false;
        }
        Object this$properties = this.getProperties();
        Object other$properties = other.getProperties();
        if (this$properties == null ? other$properties != null : !this$properties.equals(other$properties)) {
            return false;
        }
        Object this$replaces = this.getReplaces();
        Object other$replaces = other.getReplaces();
        if (this$replaces == null ? other$replaces != null : !this$replaces.equals(other$replaces)) {
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
        return other instanceof BundleLookup;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $catalogSourceRef = this.getCatalogSourceRef();
        result = result * prime + ($catalogSourceRef == null ? 43 : $catalogSourceRef.hashCode());
        Object $conditions = this.getConditions();
        result = result * prime + ($conditions == null ? 43 : $conditions.hashCode());
        Object $identifier = this.getIdentifier();
        result = result * prime + ($identifier == null ? 43 : $identifier.hashCode());
        Object $path = this.getPath();
        result = result * prime + ($path == null ? 43 : $path.hashCode());
        Object $properties = this.getProperties();
        result = result * prime + ($properties == null ? 43 : $properties.hashCode());
        Object $replaces = this.getReplaces();
        result = result * prime + ($replaces == null ? 43 : $replaces.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "BundleLookup(" + "catalogSourceRef=" + this.getCatalogSourceRef() + ", conditions=" + this.getConditions() + ", identifier=" + this.getIdentifier() + ", path=" + this.getPath() + ", properties=" + this.getProperties() + ", replaces=" + this.getReplaces() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
