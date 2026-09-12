
package io.fabric8.knative.sources.v1alpha1;

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
import io.fabric8.kubernetes.api.model.SecretKeySelector;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * AwsSqsSourceSpec defines the desired state of the source.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "annotations",
    "awsCredsSecret",
    "queueUrl",
    "serviceAccountName",
    "sink"
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
public class AwsSqsSourceSpec implements Editable<AwsSqsSourceSpecBuilder>, KubernetesResource
{

    @JsonProperty("annotations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> annotations = new LinkedHashMap<>();
    @JsonProperty("awsCredsSecret")
    private SecretKeySelector awsCredsSecret;
    @JsonProperty("queueUrl")
    private String queueUrl;
    @JsonProperty("serviceAccountName")
    private String serviceAccountName;
    @JsonProperty("sink")
    private ObjectReference sink;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AwsSqsSourceSpec() {
    }

    public AwsSqsSourceSpec(Map<String, String> annotations, SecretKeySelector awsCredsSecret, String queueUrl, String serviceAccountName, ObjectReference sink) {
        super();
        this.annotations = annotations;
        this.awsCredsSecret = awsCredsSecret;
        this.queueUrl = queueUrl;
        this.serviceAccountName = serviceAccountName;
        this.sink = sink;
    }

    /**
     * Annotations to add to the pod, mostly used for Kube2IAM role
     */
    @JsonProperty("annotations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getAnnotations() {
        return annotations;
    }

    /**
     * Annotations to add to the pod, mostly used for Kube2IAM role
     */
    @JsonProperty("annotations")
    public void setAnnotations(Map<String, String> annotations) {
        this.annotations = annotations;
    }

    /**
     * AwsSqsSourceSpec defines the desired state of the source.
     */
    @JsonProperty("awsCredsSecret")
    public SecretKeySelector getAwsCredsSecret() {
        return awsCredsSecret;
    }

    /**
     * AwsSqsSourceSpec defines the desired state of the source.
     */
    @JsonProperty("awsCredsSecret")
    public void setAwsCredsSecret(SecretKeySelector awsCredsSecret) {
        this.awsCredsSecret = awsCredsSecret;
    }

    /**
     * QueueURL of the SQS queue that we will poll from.
     */
    @JsonProperty("queueUrl")
    public String getQueueUrl() {
        return queueUrl;
    }

    /**
     * QueueURL of the SQS queue that we will poll from.
     */
    @JsonProperty("queueUrl")
    public void setQueueUrl(String queueUrl) {
        this.queueUrl = queueUrl;
    }

    /**
     * ServiceAccoutName is the name of the ServiceAccount that will be used to run the Receive Adapter Deployment.
     */
    @JsonProperty("serviceAccountName")
    public String getServiceAccountName() {
        return serviceAccountName;
    }

    /**
     * ServiceAccoutName is the name of the ServiceAccount that will be used to run the Receive Adapter Deployment.
     */
    @JsonProperty("serviceAccountName")
    public void setServiceAccountName(String serviceAccountName) {
        this.serviceAccountName = serviceAccountName;
    }

    /**
     * AwsSqsSourceSpec defines the desired state of the source.
     */
    @JsonProperty("sink")
    public ObjectReference getSink() {
        return sink;
    }

    /**
     * AwsSqsSourceSpec defines the desired state of the source.
     */
    @JsonProperty("sink")
    public void setSink(ObjectReference sink) {
        this.sink = sink;
    }

    @JsonIgnore
    public AwsSqsSourceSpecBuilder edit() {
        return new AwsSqsSourceSpecBuilder(this);
    }

    @JsonIgnore
    public AwsSqsSourceSpecBuilder toBuilder() {
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof AwsSqsSourceSpec)) {
            return false;
        }
        AwsSqsSourceSpec other = (AwsSqsSourceSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$annotations = this.getAnnotations();
        Object other$annotations = other.getAnnotations();
        if (this$annotations == null ? other$annotations != null : !this$annotations.equals(other$annotations)) {
            return false;
        }
        Object this$awsCredsSecret = this.getAwsCredsSecret();
        Object other$awsCredsSecret = other.getAwsCredsSecret();
        if (this$awsCredsSecret == null ? other$awsCredsSecret != null : !this$awsCredsSecret.equals(other$awsCredsSecret)) {
            return false;
        }
        Object this$queueUrl = this.getQueueUrl();
        Object other$queueUrl = other.getQueueUrl();
        if (this$queueUrl == null ? other$queueUrl != null : !this$queueUrl.equals(other$queueUrl)) {
            return false;
        }
        Object this$serviceAccountName = this.getServiceAccountName();
        Object other$serviceAccountName = other.getServiceAccountName();
        if (this$serviceAccountName == null ? other$serviceAccountName != null : !this$serviceAccountName.equals(other$serviceAccountName)) {
            return false;
        }
        Object this$sink = this.getSink();
        Object other$sink = other.getSink();
        if (this$sink == null ? other$sink != null : !this$sink.equals(other$sink)) {
            return false;
        }
        Object this$additionalProperties = this.getAdditionalProperties();
        Object other$additionalProperties = other.getAdditionalProperties();
        if (this$additionalProperties == null ? other$additionalProperties != null : !this$additionalProperties.equals(other$additionalProperties)) {
            return false;
        }
        return true;
    }

    protected boolean canEqual(Object other) {
        return other instanceof AwsSqsSourceSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $annotations = this.getAnnotations();
        result = result * prime + ($annotations == null ? 43 : $annotations.hashCode());
        Object $awsCredsSecret = this.getAwsCredsSecret();
        result = result * prime + ($awsCredsSecret == null ? 43 : $awsCredsSecret.hashCode());
        Object $queueUrl = this.getQueueUrl();
        result = result * prime + ($queueUrl == null ? 43 : $queueUrl.hashCode());
        Object $serviceAccountName = this.getServiceAccountName();
        result = result * prime + ($serviceAccountName == null ? 43 : $serviceAccountName.hashCode());
        Object $sink = this.getSink();
        result = result * prime + ($sink == null ? 43 : $sink.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "AwsSqsSourceSpec(" + "annotations=" + this.getAnnotations() + ", awsCredsSecret=" + this.getAwsCredsSecret() + ", queueUrl=" + this.getQueueUrl() + ", serviceAccountName=" + this.getServiceAccountName() + ", sink=" + this.getSink() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
