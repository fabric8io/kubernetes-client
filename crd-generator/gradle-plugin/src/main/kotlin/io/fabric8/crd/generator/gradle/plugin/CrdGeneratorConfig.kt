package io.fabric8.crd.generator.gradle.plugin

import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.Nested
import org.gradle.api.tasks.Optional

/**
 * Configuration used by the [CrdGeneratorTask].
 */
abstract class CrdGeneratorConfig {
    /**
     * Directive configuring the collection of the classes
     */
    @get:Nested
    abstract val collect: CollectDirective

    /**
     * Directive configuring the emission of the CRDs.
     */
    @get:Nested
    abstract val emit: EmitDirective

    abstract class CollectDirective {
        /**
         * enforce the creation of a jandex index, even if one is found.
         */
        @get:Input
        @get:Optional
        abstract val forceIndex: Property<Boolean>

        /**
         * names of the classes to be scanned
         */
        @get:Input
        @get:Optional
        val classes = mutableSetOf<String>()

        /**
         * package filter for the classes
         */
        @get:Nested
        @get:Optional
        abstract val packages: Packages

        abstract class Packages {
            /**
             * include the provided packages by name.
             */
            @get:Input
            val include = mutableSetOf<String>()

            /**
             * exclude the provided packages by name.
             */
            @get:Input
            val exclude = mutableSetOf<String>()
        }
    }

    abstract class EmitDirective {
        /**
         * if to parallelize the generation of the CRDs
         */
        @get:Input
        @get:Optional
        abstract val parallel: Property<Boolean>

        /**
         * apiVersions of the CRDs to be generated
         */
        @get:Input
        @get:Optional
        val crdVersions = mutableSetOf<String>()
    }
}
