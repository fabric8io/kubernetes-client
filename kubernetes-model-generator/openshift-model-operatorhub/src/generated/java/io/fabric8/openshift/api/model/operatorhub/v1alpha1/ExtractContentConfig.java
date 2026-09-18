
package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

import java.util.LinkedHashMap;
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
 * ExtractContentConfig configures context extraction from a file-based catalog index image.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "cacheDir",
    "catalogDir"
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
public class ExtractContentConfig implements Editable<ExtractContentConfigBuilder>, KubernetesResource
{

    @JsonProperty("cacheDir")
    private String cacheDir;
    @JsonProperty("catalogDir")
    private String catalogDir;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ExtractContentConfig() {
    }

    public ExtractContentConfig(String cacheDir, String catalogDir) {
        super();
        this.cacheDir = cacheDir;
        this.catalogDir = catalogDir;
    }

    /**
     * CacheDir is the (optional) directory storing the pre-calculated API cache.
     */
    @JsonProperty("cacheDir")
    public String getCacheDir() {
        return cacheDir;
    }

    /**
     * CacheDir is the (optional) directory storing the pre-calculated API cache.
     */
    @JsonProperty("cacheDir")
    public void setCacheDir(String cacheDir) {
        this.cacheDir = cacheDir;
    }

    /**
     * CatalogDir is the directory storing the file-based catalog contents.
     */
    @JsonProperty("catalogDir")
    public String getCatalogDir() {
        return catalogDir;
    }

    /**
     * CatalogDir is the directory storing the file-based catalog contents.
     */
    @JsonProperty("catalogDir")
    public void setCatalogDir(String catalogDir) {
        this.catalogDir = catalogDir;
    }

    @JsonIgnore
    public ExtractContentConfigBuilder edit() {
        return new ExtractContentConfigBuilder(this);
    }

    @JsonIgnore
    public ExtractContentConfigBuilder toBuilder() {
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
        if (!(o instanceof ExtractContentConfig)) {
            return false;
        }
        ExtractContentConfig other = (ExtractContentConfig) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$cacheDir = this.getCacheDir();
        Object other$cacheDir = other.getCacheDir();
        if (this$cacheDir == null ? other$cacheDir != null : !this$cacheDir.equals(other$cacheDir)) {
            return false;
        }
        Object this$catalogDir = this.getCatalogDir();
        Object other$catalogDir = other.getCatalogDir();
        if (this$catalogDir == null ? other$catalogDir != null : !this$catalogDir.equals(other$catalogDir)) {
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
        return other instanceof ExtractContentConfig;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $cacheDir = this.getCacheDir();
        result = result * prime + ($cacheDir == null ? 43 : $cacheDir.hashCode());
        Object $catalogDir = this.getCatalogDir();
        result = result * prime + ($catalogDir == null ? 43 : $catalogDir.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ExtractContentConfig(" + "cacheDir=" + this.getCacheDir() + ", catalogDir=" + this.getCatalogDir() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
