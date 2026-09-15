
package io.fabric8.openshift.api.model.monitoring.v1alpha1;

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
 * PagerDutyImageConfig attaches images to an incident
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "alt",
    "href",
    "src"
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
public class PagerDutyImageConfig implements Editable<PagerDutyImageConfigBuilder>, KubernetesResource
{

    @JsonProperty("alt")
    private String alt;
    @JsonProperty("href")
    private String href;
    @JsonProperty("src")
    private String src;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PagerDutyImageConfig() {
    }

    public PagerDutyImageConfig(String alt, String href, String src) {
        super();
        this.alt = alt;
        this.href = href;
        this.src = src;
    }

    /**
     * alt is the optional alternative text for the image.
     */
    @JsonProperty("alt")
    public String getAlt() {
        return alt;
    }

    /**
     * alt is the optional alternative text for the image.
     */
    @JsonProperty("alt")
    public void setAlt(String alt) {
        this.alt = alt;
    }

    /**
     * href defines the optional URL; makes the image a clickable link.
     */
    @JsonProperty("href")
    public String getHref() {
        return href;
    }

    /**
     * href defines the optional URL; makes the image a clickable link.
     */
    @JsonProperty("href")
    public void setHref(String href) {
        this.href = href;
    }

    /**
     * src of the image being attached to the incident
     */
    @JsonProperty("src")
    public String getSrc() {
        return src;
    }

    /**
     * src of the image being attached to the incident
     */
    @JsonProperty("src")
    public void setSrc(String src) {
        this.src = src;
    }

    @JsonIgnore
    public PagerDutyImageConfigBuilder edit() {
        return new PagerDutyImageConfigBuilder(this);
    }

    @JsonIgnore
    public PagerDutyImageConfigBuilder toBuilder() {
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
        if (!(o instanceof PagerDutyImageConfig)) {
            return false;
        }
        PagerDutyImageConfig other = (PagerDutyImageConfig) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$alt = this.getAlt();
        Object other$alt = other.getAlt();
        if (this$alt == null ? other$alt != null : !this$alt.equals(other$alt)) {
            return false;
        }
        Object this$href = this.getHref();
        Object other$href = other.getHref();
        if (this$href == null ? other$href != null : !this$href.equals(other$href)) {
            return false;
        }
        Object this$src = this.getSrc();
        Object other$src = other.getSrc();
        if (this$src == null ? other$src != null : !this$src.equals(other$src)) {
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
        return other instanceof PagerDutyImageConfig;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $alt = this.getAlt();
        result = result * prime + ($alt == null ? 43 : $alt.hashCode());
        Object $href = this.getHref();
        result = result * prime + ($href == null ? 43 : $href.hashCode());
        Object $src = this.getSrc();
        result = result * prime + ($src == null ? 43 : $src.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "PagerDutyImageConfig(" + "alt=" + this.getAlt() + ", href=" + this.getHref() + ", src=" + this.getSrc() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
