
package io.fabric8.kubernetes.api.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import io.sundr.builder.annotations.Buildable;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "command",
    "container",
    "stderr",
    "stdin",
    "stdout",
    "tty"
})
@ToString
@EqualsAndHashCode
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = true, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Version("v1")
@Group("")
public class PodExecOptions implements KubernetesResource
{

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("apiVersion")
    private String apiVersion = "v1";
    @JsonProperty("command")
    private List<String> command = new ArrayList<String>();
    @JsonProperty("container")
    private String container;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("kind")
    private String kind = "PodExecOptions";
    @JsonProperty("stderr")
    private Boolean stderr;
    @JsonProperty("stdin")
    private Boolean stdin;
    @JsonProperty("stdout")
    private Boolean stdout;
    @JsonProperty("tty")
    private Boolean tty;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public PodExecOptions() {
    }

    /**
     * 
     * @param container
     * @param stdin
     * @param apiVersion
     * @param stdout
     * @param kind
     * @param tty
     * @param stderr
     * @param command
     */
    public PodExecOptions(String apiVersion, List<String> command, String container, String kind, Boolean stderr, Boolean stdin, Boolean stdout, Boolean tty) {
        super();
        this.apiVersion = apiVersion;
        this.command = command;
        this.container = container;
        this.kind = kind;
        this.stderr = stderr;
        this.stdin = stdin;
        this.stdout = stdout;
        this.tty = tty;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("apiVersion")
    public String getApiVersion() {
        return apiVersion;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("apiVersion")
    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    @JsonProperty("command")
    public List<String> getCommand() {
        return command;
    }

    @JsonProperty("command")
    public void setCommand(List<String> command) {
        this.command = command;
    }

    @JsonProperty("container")
    public String getContainer() {
        return container;
    }

    @JsonProperty("container")
    public void setContainer(String container) {
        this.container = container;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    @JsonProperty("stderr")
    public Boolean getStderr() {
        return stderr;
    }

    @JsonProperty("stderr")
    public void setStderr(Boolean stderr) {
        this.stderr = stderr;
    }

    @JsonProperty("stdin")
    public Boolean getStdin() {
        return stdin;
    }

    @JsonProperty("stdin")
    public void setStdin(Boolean stdin) {
        this.stdin = stdin;
    }

    @JsonProperty("stdout")
    public Boolean getStdout() {
        return stdout;
    }

    @JsonProperty("stdout")
    public void setStdout(Boolean stdout) {
        this.stdout = stdout;
    }

    @JsonProperty("tty")
    public Boolean getTty() {
        return tty;
    }

    @JsonProperty("tty")
    public void setTty(Boolean tty) {
        this.tty = tty;
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
