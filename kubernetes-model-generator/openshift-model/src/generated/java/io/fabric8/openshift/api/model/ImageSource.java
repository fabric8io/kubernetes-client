
package io.fabric8.openshift.api.model;

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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * ImageSource is used to describe build source that will be extracted from an image or used during a multi stage build. A reference of type ImageStreamTag, ImageStreamImage or DockerImage may be used. A pull secret can be specified to pull the image from an external registry or override the default service account secret if pulling from the internal registry. Image sources can either be used to extract content from an image and place it into the build context along with the repository source, or used directly during a multi-stage container image build to allow content to be copied without overwriting the contents of the repository source (see the 'paths' and 'as' fields).
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "as",
    "from",
    "paths",
    "pullSecret"
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
    @BuildableReference(ObjectReference.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ImageSource implements Editable<ImageSourceBuilder>, KubernetesResource
{

    @JsonProperty("as")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> as = new ArrayList<>();
    @JsonProperty("from")
    private ObjectReference from;
    @JsonProperty("paths")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ImageSourcePath> paths = new ArrayList<>();
    @JsonProperty("pullSecret")
    private LocalObjectReference pullSecret;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ImageSource() {
    }

    public ImageSource(List<String> as, ObjectReference from, List<ImageSourcePath> paths, LocalObjectReference pullSecret) {
        super();
        this.as = as;
        this.from = from;
        this.paths = paths;
        this.pullSecret = pullSecret;
    }

    /**
     * A list of image names that this source will be used in place of during a multi-stage container image build. For instance, a Dockerfile that uses "COPY --from=nginx:latest" will first check for an image source that has "nginx:latest" in this field before attempting to pull directly. If the Dockerfile does not reference an image source it is ignored. This field and paths may both be set, in which case the contents will be used twice.
     */
    @JsonProperty("as")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getAs() {
        return as;
    }

    /**
     * A list of image names that this source will be used in place of during a multi-stage container image build. For instance, a Dockerfile that uses "COPY --from=nginx:latest" will first check for an image source that has "nginx:latest" in this field before attempting to pull directly. If the Dockerfile does not reference an image source it is ignored. This field and paths may both be set, in which case the contents will be used twice.
     */
    @JsonProperty("as")
    public void setAs(List<String> as) {
        this.as = as;
    }

    /**
     * ImageSource is used to describe build source that will be extracted from an image or used during a multi stage build. A reference of type ImageStreamTag, ImageStreamImage or DockerImage may be used. A pull secret can be specified to pull the image from an external registry or override the default service account secret if pulling from the internal registry. Image sources can either be used to extract content from an image and place it into the build context along with the repository source, or used directly during a multi-stage container image build to allow content to be copied without overwriting the contents of the repository source (see the 'paths' and 'as' fields).
     */
    @JsonProperty("from")
    public ObjectReference getFrom() {
        return from;
    }

    /**
     * ImageSource is used to describe build source that will be extracted from an image or used during a multi stage build. A reference of type ImageStreamTag, ImageStreamImage or DockerImage may be used. A pull secret can be specified to pull the image from an external registry or override the default service account secret if pulling from the internal registry. Image sources can either be used to extract content from an image and place it into the build context along with the repository source, or used directly during a multi-stage container image build to allow content to be copied without overwriting the contents of the repository source (see the 'paths' and 'as' fields).
     */
    @JsonProperty("from")
    public void setFrom(ObjectReference from) {
        this.from = from;
    }

    /**
     * paths is a list of source and destination paths to copy from the image. This content will be copied into the build context prior to starting the build. If no paths are set, the build context will not be altered.
     */
    @JsonProperty("paths")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ImageSourcePath> getPaths() {
        return paths;
    }

    /**
     * paths is a list of source and destination paths to copy from the image. This content will be copied into the build context prior to starting the build. If no paths are set, the build context will not be altered.
     */
    @JsonProperty("paths")
    public void setPaths(List<ImageSourcePath> paths) {
        this.paths = paths;
    }

    /**
     * ImageSource is used to describe build source that will be extracted from an image or used during a multi stage build. A reference of type ImageStreamTag, ImageStreamImage or DockerImage may be used. A pull secret can be specified to pull the image from an external registry or override the default service account secret if pulling from the internal registry. Image sources can either be used to extract content from an image and place it into the build context along with the repository source, or used directly during a multi-stage container image build to allow content to be copied without overwriting the contents of the repository source (see the 'paths' and 'as' fields).
     */
    @JsonProperty("pullSecret")
    public LocalObjectReference getPullSecret() {
        return pullSecret;
    }

    /**
     * ImageSource is used to describe build source that will be extracted from an image or used during a multi stage build. A reference of type ImageStreamTag, ImageStreamImage or DockerImage may be used. A pull secret can be specified to pull the image from an external registry or override the default service account secret if pulling from the internal registry. Image sources can either be used to extract content from an image and place it into the build context along with the repository source, or used directly during a multi-stage container image build to allow content to be copied without overwriting the contents of the repository source (see the 'paths' and 'as' fields).
     */
    @JsonProperty("pullSecret")
    public void setPullSecret(LocalObjectReference pullSecret) {
        this.pullSecret = pullSecret;
    }

    @JsonIgnore
    public ImageSourceBuilder edit() {
        return new ImageSourceBuilder(this);
    }

    @JsonIgnore
    public ImageSourceBuilder toBuilder() {
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
