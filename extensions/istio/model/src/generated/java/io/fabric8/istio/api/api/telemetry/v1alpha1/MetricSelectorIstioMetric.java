
package io.fabric8.istio.api.api.telemetry.v1alpha1;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Curated list of known metric types that is supported by Istio metric providers. See also: https://istio.io/latest/docs/reference/config/metrics/#metrics
 */
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public enum MetricSelectorIstioMetric 
{
    ALL_METRICS(0),
    GRPC_REQUEST_MESSAGES(9),
    GRPC_RESPONSE_MESSAGES(10),
    REQUEST_COUNT(1),
    REQUEST_DURATION(2),
    REQUEST_SIZE(3),
    RESPONSE_SIZE(4),
    TCP_CLOSED_CONNECTIONS(6),
    TCP_OPENED_CONNECTIONS(5),
    TCP_RECEIVED_BYTES(8),
    TCP_SENT_BYTES(7);
    private final int value;
    private MetricSelectorIstioMetric(int value) {
        this.value = value;
    }

    @JsonCreator
    public static MetricSelectorIstioMetric fromValue(Object value) {
        if (value instanceof String) {
            for (MetricSelectorIstioMetric e : MetricSelectorIstioMetric.values()) {
                if (e.name().equalsIgnoreCase(value.toString())) {
                    return e;
                }
            }
        } else if (value instanceof Integer) {
            for (MetricSelectorIstioMetric e : MetricSelectorIstioMetric.values()) {
                if (value.equals(e.value)) {
                    return e;
                }
            }
        }
        return null;
    }



}
