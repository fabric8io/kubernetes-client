
package io.fabric8.openshift.api.model.console.v1;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
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
 * ConsoleSampleContainerImportSource let the user import a container image.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "image",
    "service"
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
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ConsoleSampleContainerImportSource implements Editable<ConsoleSampleContainerImportSourceBuilder>, KubernetesResource
{

    @JsonProperty("image")
    private String image;
    @JsonProperty("service")
    private ConsoleSampleContainerImportSourceService service;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ConsoleSampleContainerImportSource() {
    }

    public ConsoleSampleContainerImportSource(String image, ConsoleSampleContainerImportSourceService service) {
        super();
        this.image = image;
        this.service = service;
    }

    /**
     * reference to a container image that provides a HTTP service. The service must be exposed on the default port (8080) unless otherwise configured with the port field.<br><p> <br><p> Supported formats:<br><p>   - &lt;repository-name&gt;/&lt;image-name&gt;<br><p>   - docker.io/&lt;repository-name&gt;/&lt;image-name&gt;<br><p>   - quay.io/&lt;repository-name&gt;/&lt;image-name&gt;<br><p>   - quay.io/&lt;repository-name&gt;/&lt;image-name&gt;@sha256:&lt;image hash&gt;<br><p>   - quay.io/&lt;repository-name&gt;/&lt;image-name&gt;:&lt;tag&gt;
     */
    @JsonProperty("image")
    public String getImage() {
        return image;
    }

    /**
     * reference to a container image that provides a HTTP service. The service must be exposed on the default port (8080) unless otherwise configured with the port field.<br><p> <br><p> Supported formats:<br><p>   - &lt;repository-name&gt;/&lt;image-name&gt;<br><p>   - docker.io/&lt;repository-name&gt;/&lt;image-name&gt;<br><p>   - quay.io/&lt;repository-name&gt;/&lt;image-name&gt;<br><p>   - quay.io/&lt;repository-name&gt;/&lt;image-name&gt;@sha256:&lt;image hash&gt;<br><p>   - quay.io/&lt;repository-name&gt;/&lt;image-name&gt;:&lt;tag&gt;
     */
    @JsonProperty("image")
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * ConsoleSampleContainerImportSource let the user import a container image.
     */
    @JsonProperty("service")
    public ConsoleSampleContainerImportSourceService getService() {
        return service;
    }

    /**
     * ConsoleSampleContainerImportSource let the user import a container image.
     */
    @JsonProperty("service")
    public void setService(ConsoleSampleContainerImportSourceService service) {
        this.service = service;
    }

    @JsonIgnore
    public ConsoleSampleContainerImportSourceBuilder edit() {
        return new ConsoleSampleContainerImportSourceBuilder(this);
    }

    @JsonIgnore
    public ConsoleSampleContainerImportSourceBuilder toBuilder() {
        return edit();
    }

    @JsonAnyGetter
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
