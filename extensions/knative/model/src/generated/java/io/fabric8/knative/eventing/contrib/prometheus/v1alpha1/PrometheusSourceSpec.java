
package io.fabric8.knative.eventing.contrib.prometheus.v1alpha1;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.knative.internal.pkg.apis.duck.v1.Destination;
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
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
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
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
public class PrometheusSourceSpec implements KubernetesResource
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
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public PrometheusSourceSpec() {
    }

    /**
     * 
     * @param schedule
     * @param promQL
     * @param serviceAccountName
     * @param sink
     * @param serverURL
     * @param authTokenFile
     * @param caCertConfigMap
     * @param step
     */
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

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
