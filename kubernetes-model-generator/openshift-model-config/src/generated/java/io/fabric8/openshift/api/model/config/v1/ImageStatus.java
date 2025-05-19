
package io.fabric8.openshift.api.model.config.v1;

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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "externalRegistryHostnames",
    "imageStreamImportMode",
    "internalRegistryHostname"
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
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ImageStatus implements Editable<ImageStatusBuilder>, KubernetesResource
{

    @JsonProperty("externalRegistryHostnames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> externalRegistryHostnames = new ArrayList<>();
    @JsonProperty("imageStreamImportMode")
    private String imageStreamImportMode;
    @JsonProperty("internalRegistryHostname")
    private String internalRegistryHostname;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ImageStatus() {
    }

    public ImageStatus(List<String> externalRegistryHostnames, String imageStreamImportMode, String internalRegistryHostname) {
        super();
        this.externalRegistryHostnames = externalRegistryHostnames;
        this.imageStreamImportMode = imageStreamImportMode;
        this.internalRegistryHostname = internalRegistryHostname;
    }

    /**
     * externalRegistryHostnames provides the hostnames for the default external image registry. The external hostname should be set only when the image registry is exposed externally. The first value is used in 'publicDockerImageRepository' field in ImageStreams. The value must be in "hostname[:port]" format.
     */
    @JsonProperty("externalRegistryHostnames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getExternalRegistryHostnames() {
        return externalRegistryHostnames;
    }

    /**
     * externalRegistryHostnames provides the hostnames for the default external image registry. The external hostname should be set only when the image registry is exposed externally. The first value is used in 'publicDockerImageRepository' field in ImageStreams. The value must be in "hostname[:port]" format.
     */
    @JsonProperty("externalRegistryHostnames")
    public void setExternalRegistryHostnames(List<String> externalRegistryHostnames) {
        this.externalRegistryHostnames = externalRegistryHostnames;
    }

    /**
     * imageStreamImportMode controls the import mode behaviour of imagestreams. It can be `Legacy` or `PreserveOriginal`. `Legacy` indicates that the legacy behaviour should be used. For manifest lists, the legacy behaviour will discard the manifest list and import a single sub-manifest. In this case, the platform is chosen in the following order of priority: 1. tag annotations; 2. control plane arch/os; 3. linux/amd64; 4. the first manifest in the list. `PreserveOriginal` indicates that the original manifest will be preserved. For manifest lists, the manifest list and all its sub-manifests will be imported. This value will be reconciled based on either the spec value or if no spec value is specified, the image registry operator would look at the ClusterVersion status to determine the payload type and set the import mode accordingly, i.e single arch payload implies the import mode is Legacy and multi payload implies PreserveOriginal.<br><p> <br><p> Possible enum values:<br><p>  - `"Legacy"` indicates that the legacy behaviour should be used. For manifest lists, the legacy behaviour will discard the manifest list and import a single sub-manifest. In this case, the platform is chosen in the following order of priority: 1. tag annotations; 2. control plane arch/os; 3. linux/amd64; 4. the first manifest in the list. This mode is the default.<br><p>  - `"PreserveOriginal"` indicates that the original manifest will be preserved. For manifest lists, the manifest list and all its sub-manifests will be imported.
     */
    @JsonProperty("imageStreamImportMode")
    public String getImageStreamImportMode() {
        return imageStreamImportMode;
    }

    /**
     * imageStreamImportMode controls the import mode behaviour of imagestreams. It can be `Legacy` or `PreserveOriginal`. `Legacy` indicates that the legacy behaviour should be used. For manifest lists, the legacy behaviour will discard the manifest list and import a single sub-manifest. In this case, the platform is chosen in the following order of priority: 1. tag annotations; 2. control plane arch/os; 3. linux/amd64; 4. the first manifest in the list. `PreserveOriginal` indicates that the original manifest will be preserved. For manifest lists, the manifest list and all its sub-manifests will be imported. This value will be reconciled based on either the spec value or if no spec value is specified, the image registry operator would look at the ClusterVersion status to determine the payload type and set the import mode accordingly, i.e single arch payload implies the import mode is Legacy and multi payload implies PreserveOriginal.<br><p> <br><p> Possible enum values:<br><p>  - `"Legacy"` indicates that the legacy behaviour should be used. For manifest lists, the legacy behaviour will discard the manifest list and import a single sub-manifest. In this case, the platform is chosen in the following order of priority: 1. tag annotations; 2. control plane arch/os; 3. linux/amd64; 4. the first manifest in the list. This mode is the default.<br><p>  - `"PreserveOriginal"` indicates that the original manifest will be preserved. For manifest lists, the manifest list and all its sub-manifests will be imported.
     */
    @JsonProperty("imageStreamImportMode")
    public void setImageStreamImportMode(String imageStreamImportMode) {
        this.imageStreamImportMode = imageStreamImportMode;
    }

    /**
     * internalRegistryHostname sets the hostname for the default internal image registry. The value must be in "hostname[:port]" format. This value is set by the image registry operator which controls the internal registry hostname.
     */
    @JsonProperty("internalRegistryHostname")
    public String getInternalRegistryHostname() {
        return internalRegistryHostname;
    }

    /**
     * internalRegistryHostname sets the hostname for the default internal image registry. The value must be in "hostname[:port]" format. This value is set by the image registry operator which controls the internal registry hostname.
     */
    @JsonProperty("internalRegistryHostname")
    public void setInternalRegistryHostname(String internalRegistryHostname) {
        this.internalRegistryHostname = internalRegistryHostname;
    }

    @JsonIgnore
    public ImageStatusBuilder edit() {
        return new ImageStatusBuilder(this);
    }

    @JsonIgnore
    public ImageStatusBuilder toBuilder() {
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
