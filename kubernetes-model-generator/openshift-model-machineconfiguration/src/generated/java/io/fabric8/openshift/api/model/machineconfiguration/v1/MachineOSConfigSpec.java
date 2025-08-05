
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * MachineOSConfigSpec describes user-configurable options as well as information about a build process.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "baseImagePullSecret",
    "containerFile",
    "imageBuilder",
    "machineConfigPool",
    "renderedImagePushSecret",
    "renderedImagePushSpec"
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
public class MachineOSConfigSpec implements Editable<MachineOSConfigSpecBuilder>, KubernetesResource
{

    @JsonProperty("baseImagePullSecret")
    private ImageSecretObjectReference baseImagePullSecret;
    @JsonProperty("containerFile")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<MachineOSContainerfile> containerFile = new ArrayList<>();
    @JsonProperty("imageBuilder")
    private MachineOSImageBuilder imageBuilder;
    @JsonProperty("machineConfigPool")
    private MachineConfigPoolReference machineConfigPool;
    @JsonProperty("renderedImagePushSecret")
    private ImageSecretObjectReference renderedImagePushSecret;
    @JsonProperty("renderedImagePushSpec")
    private String renderedImagePushSpec;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public MachineOSConfigSpec() {
    }

    public MachineOSConfigSpec(ImageSecretObjectReference baseImagePullSecret, List<MachineOSContainerfile> containerFile, MachineOSImageBuilder imageBuilder, MachineConfigPoolReference machineConfigPool, ImageSecretObjectReference renderedImagePushSecret, String renderedImagePushSpec) {
        super();
        this.baseImagePullSecret = baseImagePullSecret;
        this.containerFile = containerFile;
        this.imageBuilder = imageBuilder;
        this.machineConfigPool = machineConfigPool;
        this.renderedImagePushSecret = renderedImagePushSecret;
        this.renderedImagePushSpec = renderedImagePushSpec;
    }

    /**
     * MachineOSConfigSpec describes user-configurable options as well as information about a build process.
     */
    @JsonProperty("baseImagePullSecret")
    public ImageSecretObjectReference getBaseImagePullSecret() {
        return baseImagePullSecret;
    }

    /**
     * MachineOSConfigSpec describes user-configurable options as well as information about a build process.
     */
    @JsonProperty("baseImagePullSecret")
    public void setBaseImagePullSecret(ImageSecretObjectReference baseImagePullSecret) {
        this.baseImagePullSecret = baseImagePullSecret;
    }

    /**
     * containerFile describes the custom data the user has specified to build into the image. This is also commonly called a Dockerfile and you can treat it as such. The content is the content of your Dockerfile. See https://github.com/containers/common/blob/main/docs/Containerfile.5.md for the spec reference. This is a list indexed by architecture name (e.g. AMD64), and allows specifying one containerFile per arch, up to 4.
     */
    @JsonProperty("containerFile")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<MachineOSContainerfile> getContainerFile() {
        return containerFile;
    }

    /**
     * containerFile describes the custom data the user has specified to build into the image. This is also commonly called a Dockerfile and you can treat it as such. The content is the content of your Dockerfile. See https://github.com/containers/common/blob/main/docs/Containerfile.5.md for the spec reference. This is a list indexed by architecture name (e.g. AMD64), and allows specifying one containerFile per arch, up to 4.
     */
    @JsonProperty("containerFile")
    public void setContainerFile(List<MachineOSContainerfile> containerFile) {
        this.containerFile = containerFile;
    }

    /**
     * MachineOSConfigSpec describes user-configurable options as well as information about a build process.
     */
    @JsonProperty("imageBuilder")
    public MachineOSImageBuilder getImageBuilder() {
        return imageBuilder;
    }

    /**
     * MachineOSConfigSpec describes user-configurable options as well as information about a build process.
     */
    @JsonProperty("imageBuilder")
    public void setImageBuilder(MachineOSImageBuilder imageBuilder) {
        this.imageBuilder = imageBuilder;
    }

    /**
     * MachineOSConfigSpec describes user-configurable options as well as information about a build process.
     */
    @JsonProperty("machineConfigPool")
    public MachineConfigPoolReference getMachineConfigPool() {
        return machineConfigPool;
    }

    /**
     * MachineOSConfigSpec describes user-configurable options as well as information about a build process.
     */
    @JsonProperty("machineConfigPool")
    public void setMachineConfigPool(MachineConfigPoolReference machineConfigPool) {
        this.machineConfigPool = machineConfigPool;
    }

    /**
     * MachineOSConfigSpec describes user-configurable options as well as information about a build process.
     */
    @JsonProperty("renderedImagePushSecret")
    public ImageSecretObjectReference getRenderedImagePushSecret() {
        return renderedImagePushSecret;
    }

    /**
     * MachineOSConfigSpec describes user-configurable options as well as information about a build process.
     */
    @JsonProperty("renderedImagePushSecret")
    public void setRenderedImagePushSecret(ImageSecretObjectReference renderedImagePushSecret) {
        this.renderedImagePushSecret = renderedImagePushSecret;
    }

    /**
     * renderedImagePushSpec describes the location of the final image. The MachineOSConfig object will use the in cluster image registry configuration. If you wish to use a mirror or any other settings specific to registries.conf, please specify those in the cluster wide registries.conf via the cluster image.config, ImageContentSourcePolicies, ImageDigestMirrorSet, or ImageTagMirrorSet objects. The format of the image push spec is: host[:port][/namespace]/name:&lt;tag&gt; or svc_name.namespace.svc[:port]/repository/name:&lt;tag&gt;. The length of the push spec must be between 1 to 447 characters.
     */
    @JsonProperty("renderedImagePushSpec")
    public String getRenderedImagePushSpec() {
        return renderedImagePushSpec;
    }

    /**
     * renderedImagePushSpec describes the location of the final image. The MachineOSConfig object will use the in cluster image registry configuration. If you wish to use a mirror or any other settings specific to registries.conf, please specify those in the cluster wide registries.conf via the cluster image.config, ImageContentSourcePolicies, ImageDigestMirrorSet, or ImageTagMirrorSet objects. The format of the image push spec is: host[:port][/namespace]/name:&lt;tag&gt; or svc_name.namespace.svc[:port]/repository/name:&lt;tag&gt;. The length of the push spec must be between 1 to 447 characters.
     */
    @JsonProperty("renderedImagePushSpec")
    public void setRenderedImagePushSpec(String renderedImagePushSpec) {
        this.renderedImagePushSpec = renderedImagePushSpec;
    }

    @JsonIgnore
    public MachineOSConfigSpecBuilder edit() {
        return new MachineOSConfigSpecBuilder(this);
    }

    @JsonIgnore
    public MachineOSConfigSpecBuilder toBuilder() {
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
