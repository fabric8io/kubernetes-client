
package io.fabric8.openshift.api.model.machineconfiguration.v1;

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
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * PinnedImageSetSpec defines the desired state of a PinnedImageSet.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "pinnedImages"
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
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class PinnedImageSetSpec implements Editable<PinnedImageSetSpecBuilder>, KubernetesResource
{

    @JsonProperty("pinnedImages")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PinnedImageRef> pinnedImages = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PinnedImageSetSpec() {
    }

    public PinnedImageSetSpec(List<PinnedImageRef> pinnedImages) {
        super();
        this.pinnedImages = pinnedImages;
    }

    /**
     * pinnedImages is a list of OCI Image referenced by digest that should be pinned and pre-loaded by the nodes of a MachineConfigPool. Translates into a new file inside the /etc/crio/crio.conf.d directory with content similar to this:<br><p> <br><p>      pinned_images = [<br><p>              "quay.io/openshift-release-dev/ocp-release@sha256:...",<br><p>              "quay.io/openshift-release-dev/ocp-v4.0-art-dev@sha256:...",<br><p>              "quay.io/openshift-release-dev/ocp-v4.0-art-dev@sha256:...",<br><p>              ...<br><p>      ]<br><p> <br><p> Image references must be by digest. A maximum of 500 images may be specified.
     */
    @JsonProperty("pinnedImages")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PinnedImageRef> getPinnedImages() {
        return pinnedImages;
    }

    /**
     * pinnedImages is a list of OCI Image referenced by digest that should be pinned and pre-loaded by the nodes of a MachineConfigPool. Translates into a new file inside the /etc/crio/crio.conf.d directory with content similar to this:<br><p> <br><p>      pinned_images = [<br><p>              "quay.io/openshift-release-dev/ocp-release@sha256:...",<br><p>              "quay.io/openshift-release-dev/ocp-v4.0-art-dev@sha256:...",<br><p>              "quay.io/openshift-release-dev/ocp-v4.0-art-dev@sha256:...",<br><p>              ...<br><p>      ]<br><p> <br><p> Image references must be by digest. A maximum of 500 images may be specified.
     */
    @JsonProperty("pinnedImages")
    public void setPinnedImages(List<PinnedImageRef> pinnedImages) {
        this.pinnedImages = pinnedImages;
    }

    @JsonIgnore
    public PinnedImageSetSpecBuilder edit() {
        return new PinnedImageSetSpecBuilder(this);
    }

    @JsonIgnore
    public PinnedImageSetSpecBuilder toBuilder() {
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
        if (!(o instanceof PinnedImageSetSpec)) {
            return false;
        }
        PinnedImageSetSpec other = (PinnedImageSetSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$pinnedImages = this.getPinnedImages();
        Object other$pinnedImages = other.getPinnedImages();
        if (this$pinnedImages == null ? other$pinnedImages != null : !this$pinnedImages.equals(other$pinnedImages)) {
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
        return other instanceof PinnedImageSetSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $pinnedImages = this.getPinnedImages();
        result = result * prime + ($pinnedImages == null ? 43 : $pinnedImages.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "PinnedImageSetSpec(" + "pinnedImages=" + this.getPinnedImages() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
