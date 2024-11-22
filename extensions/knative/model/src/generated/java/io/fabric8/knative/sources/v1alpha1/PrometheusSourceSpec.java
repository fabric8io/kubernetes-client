
package io.fabric8.knative.sources.v1alpha1;

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
import io.fabric8.knative.duck.v1.Destination;
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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "authTokenFile",
    "caCertConfigMap",
    "promQL",
    "schedule",
    "serverURL",
    "serviceAccountName",
    "sink",
    "step"
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
public class PrometheusSourceSpec implements Editable<PrometheusSourceSpecBuilder> , KubernetesResource
{

    @JsonProperty("authTokenFile")
    private String authTokenFile;
    @JsonProperty("caCertConfigMap")
    private String caCertConfigMap;
    @JsonProperty("promQL")
    private String promQL;
    @JsonProperty("schedule")
    private String schedule;
    @JsonProperty("serverURL")
    private String serverURL;
    @JsonProperty("serviceAccountName")
    private String serviceAccountName;
    @JsonProperty("sink")
    private Destination sink;
    @JsonProperty("step")
    private String step;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public PrometheusSourceSpec() {
    }

    public PrometheusSourceSpec(String authTokenFile, String caCertConfigMap, String promQL, String schedule, String serverURL, String serviceAccountName, Destination sink, String step) {
        super();
        this.authTokenFile = authTokenFile;
        this.caCertConfigMap = caCertConfigMap;
        this.promQL = promQL;
        this.schedule = schedule;
        this.serverURL = serverURL;
        this.serviceAccountName = serviceAccountName;
        this.sink = sink;
        this.step = step;
    }

    @JsonProperty("authTokenFile")
    public String getAuthTokenFile() {
        return authTokenFile;
    }

    @JsonProperty("authTokenFile")
    public void setAuthTokenFile(String authTokenFile) {
        this.authTokenFile = authTokenFile;
    }

    @JsonProperty("caCertConfigMap")
    public String getCaCertConfigMap() {
        return caCertConfigMap;
    }

    @JsonProperty("caCertConfigMap")
    public void setCaCertConfigMap(String caCertConfigMap) {
        this.caCertConfigMap = caCertConfigMap;
    }

    @JsonProperty("promQL")
    public String getPromQL() {
        return promQL;
    }

    @JsonProperty("promQL")
    public void setPromQL(String promQL) {
        this.promQL = promQL;
    }

    @JsonProperty("schedule")
    public String getSchedule() {
        return schedule;
    }

    @JsonProperty("schedule")
    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    @JsonProperty("serverURL")
    public String getServerURL() {
        return serverURL;
    }

    @JsonProperty("serverURL")
    public void setServerURL(String serverURL) {
        this.serverURL = serverURL;
    }

    @JsonProperty("serviceAccountName")
    public String getServiceAccountName() {
        return serviceAccountName;
    }

    @JsonProperty("serviceAccountName")
    public void setServiceAccountName(String serviceAccountName) {
        this.serviceAccountName = serviceAccountName;
    }

    @JsonProperty("sink")
    public Destination getSink() {
        return sink;
    }

    @JsonProperty("sink")
    public void setSink(Destination sink) {
        this.sink = sink;
    }

    @JsonProperty("step")
    public String getStep() {
        return step;
    }

    @JsonProperty("step")
    public void setStep(String step) {
        this.step = step;
    }

    @JsonIgnore
    public PrometheusSourceSpecBuilder edit() {
        return new PrometheusSourceSpecBuilder(this);
    }

    @JsonIgnore
    public PrometheusSourceSpecBuilder toBuilder() {
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
