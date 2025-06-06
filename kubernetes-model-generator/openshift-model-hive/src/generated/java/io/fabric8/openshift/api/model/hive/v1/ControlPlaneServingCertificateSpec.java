
package io.fabric8.openshift.api.model.hive.v1;

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
 * ControlPlaneServingCertificateSpec specifies serving certificate settings for the control plane of the target cluster.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "additional",
    "default"
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
public class ControlPlaneServingCertificateSpec implements Editable<ControlPlaneServingCertificateSpecBuilder>, KubernetesResource
{

    @JsonProperty("additional")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ControlPlaneAdditionalCertificate> additional = new ArrayList<>();
    @JsonProperty("default")
    private String _default;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ControlPlaneServingCertificateSpec() {
    }

    public ControlPlaneServingCertificateSpec(List<ControlPlaneAdditionalCertificate> additional, String _default) {
        super();
        this.additional = additional;
        this._default = _default;
    }

    /**
     * Additional is a list of additional domains and certificates that are also associated with the control plane's api endpoint.
     */
    @JsonProperty("additional")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ControlPlaneAdditionalCertificate> getAdditional() {
        return additional;
    }

    /**
     * Additional is a list of additional domains and certificates that are also associated with the control plane's api endpoint.
     */
    @JsonProperty("additional")
    public void setAdditional(List<ControlPlaneAdditionalCertificate> additional) {
        this.additional = additional;
    }

    /**
     * Default references the name of a CertificateBundle in the ClusterDeployment that should be used for the control plane's default endpoint.
     */
    @JsonProperty("default")
    public String getDefault() {
        return _default;
    }

    /**
     * Default references the name of a CertificateBundle in the ClusterDeployment that should be used for the control plane's default endpoint.
     */
    @JsonProperty("default")
    public void setDefault(String _default) {
        this._default = _default;
    }

    @JsonIgnore
    public ControlPlaneServingCertificateSpecBuilder edit() {
        return new ControlPlaneServingCertificateSpecBuilder(this);
    }

    @JsonIgnore
    public ControlPlaneServingCertificateSpecBuilder toBuilder() {
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
