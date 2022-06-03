
package io.fabric8.knative.eventing.contrib.awssqs.v1alpha1;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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
import io.fabric8.kubernetes.api.model.SecretKeySelector;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
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
    "annotations",
    "awsCredsSecret",
    "queueUrl",
    "serviceAccountName",
    "sink"
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
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
public class AwsSqsSourceSpec implements KubernetesResource
{

    @JsonProperty("annotations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> annotations = new LinkedHashMap<String, String>();
    @JsonProperty("awsCredsSecret")
    private SecretKeySelector awsCredsSecret;
    @JsonProperty("queueUrl")
    private java.lang.String queueUrl;
    @JsonProperty("serviceAccountName")
    private java.lang.String serviceAccountName;
    @JsonProperty("sink")
    private io.fabric8.kubernetes.api.model.ObjectReference sink;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new HashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public AwsSqsSourceSpec() {
    }

    /**
     * 
     * @param serviceAccountName
     * @param sink
     * @param awsCredsSecret
     * @param annotations
     * @param queueUrl
     */
    public AwsSqsSourceSpec(Map<String, String> annotations, SecretKeySelector awsCredsSecret, java.lang.String queueUrl, java.lang.String serviceAccountName, io.fabric8.kubernetes.api.model.ObjectReference sink) {
        super();
        this.annotations = annotations;
        this.awsCredsSecret = awsCredsSecret;
        this.queueUrl = queueUrl;
        this.serviceAccountName = serviceAccountName;
        this.sink = sink;
    }

    @JsonProperty("annotations")
    public Map<String, String> getAnnotations() {
        return annotations;
    }

    @JsonProperty("annotations")
    public void setAnnotations(Map<String, String> annotations) {
        this.annotations = annotations;
    }

    @JsonProperty("awsCredsSecret")
    public SecretKeySelector getAwsCredsSecret() {
        return awsCredsSecret;
    }

    @JsonProperty("awsCredsSecret")
    public void setAwsCredsSecret(SecretKeySelector awsCredsSecret) {
        this.awsCredsSecret = awsCredsSecret;
    }

    @JsonProperty("queueUrl")
    public java.lang.String getQueueUrl() {
        return queueUrl;
    }

    @JsonProperty("queueUrl")
    public void setQueueUrl(java.lang.String queueUrl) {
        this.queueUrl = queueUrl;
    }

    @JsonProperty("serviceAccountName")
    public java.lang.String getServiceAccountName() {
        return serviceAccountName;
    }

    @JsonProperty("serviceAccountName")
    public void setServiceAccountName(java.lang.String serviceAccountName) {
        this.serviceAccountName = serviceAccountName;
    }

    @JsonProperty("sink")
    public io.fabric8.kubernetes.api.model.ObjectReference getSink() {
        return sink;
    }

    @JsonProperty("sink")
    public void setSink(io.fabric8.kubernetes.api.model.ObjectReference sink) {
        this.sink = sink;
    }

    @JsonAnyGetter
    public Map<java.lang.String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
