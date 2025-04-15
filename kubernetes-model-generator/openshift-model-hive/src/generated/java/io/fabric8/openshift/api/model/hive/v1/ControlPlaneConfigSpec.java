
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
 * ControlPlaneConfigSpec contains additional configuration settings for a target cluster's control plane.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiServerIPOverride",
    "apiURLOverride",
    "servingCertificates"
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
public class ControlPlaneConfigSpec implements Editable<ControlPlaneConfigSpecBuilder>, KubernetesResource
{

    @JsonProperty("apiServerIPOverride")
    private String apiServerIPOverride;
    @JsonProperty("apiURLOverride")
    private String apiURLOverride;
    @JsonProperty("servingCertificates")
    private ControlPlaneServingCertificateSpec servingCertificates;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ControlPlaneConfigSpec() {
    }

    public ControlPlaneConfigSpec(String apiServerIPOverride, String apiURLOverride, ControlPlaneServingCertificateSpec servingCertificates) {
        super();
        this.apiServerIPOverride = apiServerIPOverride;
        this.apiURLOverride = apiURLOverride;
        this.servingCertificates = servingCertificates;
    }

    /**
     * APIServerIPOverride is the optional override of the API server IP address. Hive will use this IP address for creating TCP connections. Port from the original API server URL will be used. This field can be used when repointing the APIServer's DNS is not viable option.
     */
    @JsonProperty("apiServerIPOverride")
    public String getApiServerIPOverride() {
        return apiServerIPOverride;
    }

    /**
     * APIServerIPOverride is the optional override of the API server IP address. Hive will use this IP address for creating TCP connections. Port from the original API server URL will be used. This field can be used when repointing the APIServer's DNS is not viable option.
     */
    @JsonProperty("apiServerIPOverride")
    public void setApiServerIPOverride(String apiServerIPOverride) {
        this.apiServerIPOverride = apiServerIPOverride;
    }

    /**
     * APIURLOverride is the optional URL override to which Hive will transition for communication with the API server of the remote cluster. When a remote cluster is created, Hive will initially communicate using the API URL established during installation. If an API URL Override is specified, Hive will periodically attempt to connect to the remote cluster using the override URL. Once Hive has determined that the override URL is active, Hive will use the override URL for further communications with the API server of the remote cluster.
     */
    @JsonProperty("apiURLOverride")
    public String getApiURLOverride() {
        return apiURLOverride;
    }

    /**
     * APIURLOverride is the optional URL override to which Hive will transition for communication with the API server of the remote cluster. When a remote cluster is created, Hive will initially communicate using the API URL established during installation. If an API URL Override is specified, Hive will periodically attempt to connect to the remote cluster using the override URL. Once Hive has determined that the override URL is active, Hive will use the override URL for further communications with the API server of the remote cluster.
     */
    @JsonProperty("apiURLOverride")
    public void setApiURLOverride(String apiURLOverride) {
        this.apiURLOverride = apiURLOverride;
    }

    /**
     * ControlPlaneConfigSpec contains additional configuration settings for a target cluster's control plane.
     */
    @JsonProperty("servingCertificates")
    public ControlPlaneServingCertificateSpec getServingCertificates() {
        return servingCertificates;
    }

    /**
     * ControlPlaneConfigSpec contains additional configuration settings for a target cluster's control plane.
     */
    @JsonProperty("servingCertificates")
    public void setServingCertificates(ControlPlaneServingCertificateSpec servingCertificates) {
        this.servingCertificates = servingCertificates;
    }

    @JsonIgnore
    public ControlPlaneConfigSpecBuilder edit() {
        return new ControlPlaneConfigSpecBuilder(this);
    }

    @JsonIgnore
    public ControlPlaneConfigSpecBuilder toBuilder() {
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
