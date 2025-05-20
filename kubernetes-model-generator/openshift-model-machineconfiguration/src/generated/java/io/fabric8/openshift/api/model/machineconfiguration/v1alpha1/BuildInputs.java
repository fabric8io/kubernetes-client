
package io.fabric8.openshift.api.model.machineconfiguration.v1alpha1;

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
 * BuildInputs holds all of the information needed to trigger a build
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "baseImagePullSecret",
    "baseOSExtensionsImagePullspec",
    "baseOSImagePullspec",
    "containerFile",
    "imageBuilder",
    "releaseVersion",
    "renderedImagePushSecret",
    "renderedImagePushspec"
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
public class BuildInputs implements Editable<BuildInputsBuilder>, KubernetesResource
{

    @JsonProperty("baseImagePullSecret")
    private ImageSecretObjectReference baseImagePullSecret;
    @JsonProperty("baseOSExtensionsImagePullspec")
    private String baseOSExtensionsImagePullspec;
    @JsonProperty("baseOSImagePullspec")
    private String baseOSImagePullspec;
    @JsonProperty("containerFile")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<MachineOSContainerfile> containerFile = new ArrayList<>();
    @JsonProperty("imageBuilder")
    private MachineOSImageBuilder imageBuilder;
    @JsonProperty("releaseVersion")
    private String releaseVersion;
    @JsonProperty("renderedImagePushSecret")
    private ImageSecretObjectReference renderedImagePushSecret;
    @JsonProperty("renderedImagePushspec")
    private String renderedImagePushspec;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public BuildInputs() {
    }

    public BuildInputs(ImageSecretObjectReference baseImagePullSecret, String baseOSExtensionsImagePullspec, String baseOSImagePullspec, List<MachineOSContainerfile> containerFile, MachineOSImageBuilder imageBuilder, String releaseVersion, ImageSecretObjectReference renderedImagePushSecret, String renderedImagePushspec) {
        super();
        this.baseImagePullSecret = baseImagePullSecret;
        this.baseOSExtensionsImagePullspec = baseOSExtensionsImagePullspec;
        this.baseOSImagePullspec = baseOSImagePullspec;
        this.containerFile = containerFile;
        this.imageBuilder = imageBuilder;
        this.releaseVersion = releaseVersion;
        this.renderedImagePushSecret = renderedImagePushSecret;
        this.renderedImagePushspec = renderedImagePushspec;
    }

    /**
     * BuildInputs holds all of the information needed to trigger a build
     */
    @JsonProperty("baseImagePullSecret")
    public ImageSecretObjectReference getBaseImagePullSecret() {
        return baseImagePullSecret;
    }

    /**
     * BuildInputs holds all of the information needed to trigger a build
     */
    @JsonProperty("baseImagePullSecret")
    public void setBaseImagePullSecret(ImageSecretObjectReference baseImagePullSecret) {
        this.baseImagePullSecret = baseImagePullSecret;
    }

    /**
     * baseOSExtensionsImagePullspec is the base Extensions image used in the build process the MachineOSConfig object will use the in cluster image registry configuration. if you wish to use a mirror or any other settings specific to registries.conf, please specify those in the cluster wide registries.conf. The format of the image pullspec is: host[:port][/namespace]/name@sha256:&lt;digest&gt;
     */
    @JsonProperty("baseOSExtensionsImagePullspec")
    public String getBaseOSExtensionsImagePullspec() {
        return baseOSExtensionsImagePullspec;
    }

    /**
     * baseOSExtensionsImagePullspec is the base Extensions image used in the build process the MachineOSConfig object will use the in cluster image registry configuration. if you wish to use a mirror or any other settings specific to registries.conf, please specify those in the cluster wide registries.conf. The format of the image pullspec is: host[:port][/namespace]/name@sha256:&lt;digest&gt;
     */
    @JsonProperty("baseOSExtensionsImagePullspec")
    public void setBaseOSExtensionsImagePullspec(String baseOSExtensionsImagePullspec) {
        this.baseOSExtensionsImagePullspec = baseOSExtensionsImagePullspec;
    }

    /**
     * baseOSImagePullspec is the base OSImage we use to build our custom image. the MachineOSConfig object will use the in cluster image registry configuration. if you wish to use a mirror or any other settings specific to registries.conf, please specify those in the cluster wide registries.conf. The format of the image pullspec is: host[:port][/namespace]/name@sha256:&lt;digest&gt;
     */
    @JsonProperty("baseOSImagePullspec")
    public String getBaseOSImagePullspec() {
        return baseOSImagePullspec;
    }

    /**
     * baseOSImagePullspec is the base OSImage we use to build our custom image. the MachineOSConfig object will use the in cluster image registry configuration. if you wish to use a mirror or any other settings specific to registries.conf, please specify those in the cluster wide registries.conf. The format of the image pullspec is: host[:port][/namespace]/name@sha256:&lt;digest&gt;
     */
    @JsonProperty("baseOSImagePullspec")
    public void setBaseOSImagePullspec(String baseOSImagePullspec) {
        this.baseOSImagePullspec = baseOSImagePullspec;
    }

    /**
     * containerFile describes the custom data the user has specified to build into the image. this is also commonly called a Dockerfile and you can treat it as such. The content is the content of your Dockerfile.
     */
    @JsonProperty("containerFile")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<MachineOSContainerfile> getContainerFile() {
        return containerFile;
    }

    /**
     * containerFile describes the custom data the user has specified to build into the image. this is also commonly called a Dockerfile and you can treat it as such. The content is the content of your Dockerfile.
     */
    @JsonProperty("containerFile")
    public void setContainerFile(List<MachineOSContainerfile> containerFile) {
        this.containerFile = containerFile;
    }

    /**
     * BuildInputs holds all of the information needed to trigger a build
     */
    @JsonProperty("imageBuilder")
    public MachineOSImageBuilder getImageBuilder() {
        return imageBuilder;
    }

    /**
     * BuildInputs holds all of the information needed to trigger a build
     */
    @JsonProperty("imageBuilder")
    public void setImageBuilder(MachineOSImageBuilder imageBuilder) {
        this.imageBuilder = imageBuilder;
    }

    /**
     * releaseVersion is associated with the base OS Image. This is the version of Openshift that the Base Image is associated with. This field is populated from the machine-config-osimageurl configmap in the openshift-machine-config-operator namespace. It will come in the format: 4.16.0-0.nightly-2024-04-03-065948 or any valid release. The MachineOSBuilder populates this field and validates that this is a valid stream. This is used as a label in the dockerfile that builds the OS image.
     */
    @JsonProperty("releaseVersion")
    public String getReleaseVersion() {
        return releaseVersion;
    }

    /**
     * releaseVersion is associated with the base OS Image. This is the version of Openshift that the Base Image is associated with. This field is populated from the machine-config-osimageurl configmap in the openshift-machine-config-operator namespace. It will come in the format: 4.16.0-0.nightly-2024-04-03-065948 or any valid release. The MachineOSBuilder populates this field and validates that this is a valid stream. This is used as a label in the dockerfile that builds the OS image.
     */
    @JsonProperty("releaseVersion")
    public void setReleaseVersion(String releaseVersion) {
        this.releaseVersion = releaseVersion;
    }

    /**
     * BuildInputs holds all of the information needed to trigger a build
     */
    @JsonProperty("renderedImagePushSecret")
    public ImageSecretObjectReference getRenderedImagePushSecret() {
        return renderedImagePushSecret;
    }

    /**
     * BuildInputs holds all of the information needed to trigger a build
     */
    @JsonProperty("renderedImagePushSecret")
    public void setRenderedImagePushSecret(ImageSecretObjectReference renderedImagePushSecret) {
        this.renderedImagePushSecret = renderedImagePushSecret;
    }

    /**
     * renderedImagePushspec describes the location of the final image. the MachineOSConfig object will use the in cluster image registry configuration. if you wish to use a mirror or any other settings specific to registries.conf, please specify those in the cluster wide registries.conf. The format of the image pushspec is: host[:port][/namespace]/name:&lt;tag&gt; or svc_name.namespace.svc[:port]/repository/name:&lt;tag&gt;
     */
    @JsonProperty("renderedImagePushspec")
    public String getRenderedImagePushspec() {
        return renderedImagePushspec;
    }

    /**
     * renderedImagePushspec describes the location of the final image. the MachineOSConfig object will use the in cluster image registry configuration. if you wish to use a mirror or any other settings specific to registries.conf, please specify those in the cluster wide registries.conf. The format of the image pushspec is: host[:port][/namespace]/name:&lt;tag&gt; or svc_name.namespace.svc[:port]/repository/name:&lt;tag&gt;
     */
    @JsonProperty("renderedImagePushspec")
    public void setRenderedImagePushspec(String renderedImagePushspec) {
        this.renderedImagePushspec = renderedImagePushspec;
    }

    @JsonIgnore
    public BuildInputsBuilder edit() {
        return new BuildInputsBuilder(this);
    }

    @JsonIgnore
    public BuildInputsBuilder toBuilder() {
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
