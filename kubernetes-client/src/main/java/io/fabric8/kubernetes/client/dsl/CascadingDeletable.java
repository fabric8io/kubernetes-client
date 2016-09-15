package io.fabric8.kubernetes.client.dsl;

/**
 * Created by iocanel on 9/15/16.
 */
public interface CascadingDeletable<B> extends Deletable<B>, Cascading<Deletable<B>> {
}
