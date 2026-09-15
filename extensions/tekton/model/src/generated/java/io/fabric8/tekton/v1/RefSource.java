
package io.fabric8.tekton.v1;

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
 * RefSource contains the information that can uniquely identify where a remote built definition came from i.e. Git repositories, Tekton Bundles in OCI registry and hub.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "digest",
    "entryPoint",
    "uri"
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
public class RefSource implements Editable<RefSourceBuilder>, KubernetesResource
{

    @JsonProperty("digest")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> digest = new LinkedHashMap<>();
    @JsonProperty("entryPoint")
    private String entryPoint;
    @JsonProperty("uri")
    private String uri;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public RefSource() {
    }

    public RefSource(Map<String, String> digest, String entryPoint, String uri) {
        super();
        this.digest = digest;
        this.entryPoint = entryPoint;
        this.uri = uri;
    }

    /**
     * Digest is a collection of cryptographic digests for the contents of the artifact specified by URI. Example: {"sha1": "f99d13e554ffcb696dee719fa85b695cb5b0f428"}
     */
    @JsonProperty("digest")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getDigest() {
        return digest;
    }

    /**
     * Digest is a collection of cryptographic digests for the contents of the artifact specified by URI. Example: {"sha1": "f99d13e554ffcb696dee719fa85b695cb5b0f428"}
     */
    @JsonProperty("digest")
    public void setDigest(Map<String, String> digest) {
        this.digest = digest;
    }

    /**
     * EntryPoint identifies the entry point into the build. This is often a path to a build definition file and/or a target label within that file. Example: "task/git-clone/0.10/git-clone.yaml"
     */
    @JsonProperty("entryPoint")
    public String getEntryPoint() {
        return entryPoint;
    }

    /**
     * EntryPoint identifies the entry point into the build. This is often a path to a build definition file and/or a target label within that file. Example: "task/git-clone/0.10/git-clone.yaml"
     */
    @JsonProperty("entryPoint")
    public void setEntryPoint(String entryPoint) {
        this.entryPoint = entryPoint;
    }

    /**
     * URI indicates the identity of the source of the build definition. Example: "https://github.com/tektoncd/catalog"
     */
    @JsonProperty("uri")
    public String getUri() {
        return uri;
    }

    /**
     * URI indicates the identity of the source of the build definition. Example: "https://github.com/tektoncd/catalog"
     */
    @JsonProperty("uri")
    public void setUri(String uri) {
        this.uri = uri;
    }

    @JsonIgnore
    public RefSourceBuilder edit() {
        return new RefSourceBuilder(this);
    }

    @JsonIgnore
    public RefSourceBuilder toBuilder() {
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
        if (!(o instanceof RefSource)) {
            return false;
        }
        RefSource other = (RefSource) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$digest = this.getDigest();
        Object other$digest = other.getDigest();
        if (this$digest == null ? other$digest != null : !this$digest.equals(other$digest)) {
            return false;
        }
        Object this$entryPoint = this.getEntryPoint();
        Object other$entryPoint = other.getEntryPoint();
        if (this$entryPoint == null ? other$entryPoint != null : !this$entryPoint.equals(other$entryPoint)) {
            return false;
        }
        Object this$uri = this.getUri();
        Object other$uri = other.getUri();
        if (this$uri == null ? other$uri != null : !this$uri.equals(other$uri)) {
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
        return other instanceof RefSource;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $digest = this.getDigest();
        result = result * prime + ($digest == null ? 43 : $digest.hashCode());
        Object $entryPoint = this.getEntryPoint();
        result = result * prime + ($entryPoint == null ? 43 : $entryPoint.hashCode());
        Object $uri = this.getUri();
        result = result * prime + ($uri == null ? 43 : $uri.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "RefSource(" + "digest=" + this.getDigest() + ", entryPoint=" + this.getEntryPoint() + ", uri=" + this.getUri() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
