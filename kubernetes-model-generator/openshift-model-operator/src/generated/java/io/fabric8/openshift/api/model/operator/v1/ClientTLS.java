
package io.fabric8.openshift.api.model.operator.v1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.openshift.api.model.config.v1.ConfigMapNameReference;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "allowedSubjectPatterns",
    "clientCA",
    "clientCertificatePolicy"
})
@ToString
@EqualsAndHashCode
@Setter
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
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class ClientTLS implements KubernetesResource
{

    @JsonProperty("allowedSubjectPatterns")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> allowedSubjectPatterns = new ArrayList<String>();
    @JsonProperty("clientCA")
    private ConfigMapNameReference clientCA;
    @JsonProperty("clientCertificatePolicy")
    private String clientCertificatePolicy;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ClientTLS() {
    }

    public ClientTLS(List<String> allowedSubjectPatterns, ConfigMapNameReference clientCA, String clientCertificatePolicy) {
        super();
        this.allowedSubjectPatterns = allowedSubjectPatterns;
        this.clientCA = clientCA;
        this.clientCertificatePolicy = clientCertificatePolicy;
    }

    @JsonProperty("allowedSubjectPatterns")
    public List<String> getAllowedSubjectPatterns() {
        return allowedSubjectPatterns;
    }

    @JsonProperty("allowedSubjectPatterns")
    public void setAllowedSubjectPatterns(List<String> allowedSubjectPatterns) {
        this.allowedSubjectPatterns = allowedSubjectPatterns;
    }

    @JsonProperty("clientCA")
    public ConfigMapNameReference getClientCA() {
        return clientCA;
    }

    @JsonProperty("clientCA")
    public void setClientCA(ConfigMapNameReference clientCA) {
        this.clientCA = clientCA;
    }

    @JsonProperty("clientCertificatePolicy")
    public String getClientCertificatePolicy() {
        return clientCertificatePolicy;
    }

    @JsonProperty("clientCertificatePolicy")
    public void setClientCertificatePolicy(String clientCertificatePolicy) {
        this.clientCertificatePolicy = clientCertificatePolicy;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
