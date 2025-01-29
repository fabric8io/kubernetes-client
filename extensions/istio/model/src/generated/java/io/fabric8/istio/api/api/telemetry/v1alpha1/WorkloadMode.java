
package io.fabric8.istio.api.api.telemetry.v1alpha1;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * WorkloadMode allows selection of the role of the underlying workload in network traffic. A workload is considered as acting as a `SERVER` if it is the destination of the traffic (that is, traffic direction, from the perspective of the workload is &#42;inbound&#42;). If the workload is the source of the network traffic, it is considered to be in `CLIENT` mode (traffic is &#42;outbound&#42; from the workload).
 */
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public enum WorkloadMode 
{
    CLIENT(1),
    CLIENT_AND_SERVER(0),
    SERVER(2);
    private final int value;
    private WorkloadMode(int value) {
        this.value = value;
    }

    @JsonCreator
    public static WorkloadMode fromValue(Object value) {
        if (value instanceof String) {
            for (WorkloadMode e : WorkloadMode.values()) {
                if (e.name().equalsIgnoreCase(value.toString())) {
                    return e;
                }
            }
        } else if (value instanceof Integer) {
            for (WorkloadMode e : WorkloadMode.values()) {
                if (value.equals(e.value)) {
                    return e;
                }
            }
        }
        return null;
    }



}
