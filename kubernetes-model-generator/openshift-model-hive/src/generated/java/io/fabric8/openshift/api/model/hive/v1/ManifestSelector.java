
package io.fabric8.openshift.api.model.hive.v1;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
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
import tools.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = tools.jackson.databind.ValueDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "glob"
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
public class ManifestSelector implements Editable<ManifestSelectorBuilder>, KubernetesResource
{

    @JsonProperty("glob")
    private String glob;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ManifestSelector() {
    }

    public ManifestSelector(String glob) {
        super();
        this.glob = glob;
    }

    /**
     * Glob is a file glob (per https://pkg.go.dev/path/filepath#Glob) identifying one or more manifests. Paths should be relative to the installer's working directory. Examples: - openshift/99_role-cloud-creds-secret-reader.yaml - openshift/99_openshift-cluster-api_worker-machineset-&#42;.yaml - &#42;/&#42;secret&#42; It is an error if a glob matches zero manifests.
     */
    @JsonProperty("glob")
    public String getGlob() {
        return glob;
    }

    /**
     * Glob is a file glob (per https://pkg.go.dev/path/filepath#Glob) identifying one or more manifests. Paths should be relative to the installer's working directory. Examples: - openshift/99_role-cloud-creds-secret-reader.yaml - openshift/99_openshift-cluster-api_worker-machineset-&#42;.yaml - &#42;/&#42;secret&#42; It is an error if a glob matches zero manifests.
     */
    @JsonProperty("glob")
    public void setGlob(String glob) {
        this.glob = glob;
    }

    @JsonIgnore
    public ManifestSelectorBuilder edit() {
        return new ManifestSelectorBuilder(this);
    }

    @JsonIgnore
    public ManifestSelectorBuilder toBuilder() {
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
        if (!(o instanceof ManifestSelector)) {
            return false;
        }
        ManifestSelector other = (ManifestSelector) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$glob = this.getGlob();
        Object other$glob = other.getGlob();
        if (this$glob == null ? other$glob != null : !this$glob.equals(other$glob)) {
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
        return other instanceof ManifestSelector;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $glob = this.getGlob();
        result = result * prime + ($glob == null ? 43 : $glob.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ManifestSelector(" + "glob=" + this.getGlob() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
