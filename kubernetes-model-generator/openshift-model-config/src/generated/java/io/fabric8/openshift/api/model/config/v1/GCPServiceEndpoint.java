
package io.fabric8.openshift.api.model.config.v1;

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
 * GCPServiceEndpoint store the configuration of a custom url to override existing defaults of GCP Services.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "url"
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
public class GCPServiceEndpoint implements Editable<GCPServiceEndpointBuilder>, KubernetesResource
{

    @JsonProperty("name")
    private String name;
    @JsonProperty("url")
    private String url;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public GCPServiceEndpoint() {
    }

    public GCPServiceEndpoint(String name, String url) {
        super();
        this.name = name;
        this.url = url;
    }

    /**
     * name is the name of the GCP service whose endpoint is being overridden. This must be provided and cannot be empty.<br><p> <br><p> Allowed values are Compute, Container, CloudResourceManager, DNS, File, IAM, ServiceUsage, Storage, and TagManager.<br><p> <br><p> As an example, when setting the name to Compute all requests made by the caller to the GCP Compute Service will be directed to the endpoint specified in the url field.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * name is the name of the GCP service whose endpoint is being overridden. This must be provided and cannot be empty.<br><p> <br><p> Allowed values are Compute, Container, CloudResourceManager, DNS, File, IAM, ServiceUsage, Storage, and TagManager.<br><p> <br><p> As an example, when setting the name to Compute all requests made by the caller to the GCP Compute Service will be directed to the endpoint specified in the url field.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * url is a fully qualified URI that overrides the default endpoint for a client using the GCP service specified in the name field. url is required, must use the scheme https, must not be more than 253 characters in length, and must be a valid URL according to Go's net/url package (https://pkg.go.dev/net/url#URL)<br><p> <br><p> An example of a valid endpoint that overrides the Compute Service: "https://compute-myendpoint1.p.googleapis.com"
     */
    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    /**
     * url is a fully qualified URI that overrides the default endpoint for a client using the GCP service specified in the name field. url is required, must use the scheme https, must not be more than 253 characters in length, and must be a valid URL according to Go's net/url package (https://pkg.go.dev/net/url#URL)<br><p> <br><p> An example of a valid endpoint that overrides the Compute Service: "https://compute-myendpoint1.p.googleapis.com"
     */
    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonIgnore
    public GCPServiceEndpointBuilder edit() {
        return new GCPServiceEndpointBuilder(this);
    }

    @JsonIgnore
    public GCPServiceEndpointBuilder toBuilder() {
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
