# CRD generator (preview release)

## Disclaimer

This is a preview CRD generator and there might still be some issues in the generated descriptors.
Please give it a try and report any issue you might find.

## Usage

- Classes extending the `CustomResource` class can now be used as the basis for CRD generation
- Several annotations are available to override the default behavior if it doesn't fit your needs
- Validation schema is automatically derived from your class' spec implementation (or from the CR
  class, if no spec is present)
- CRDs are automatically generated at compile-time if you include the `io.fabric8:crd-generator`
  dependency to your project (with the suggested `compile` scope)
- CRDs are generated for both `v1beta1` and `v1` versions of the specification at this point
- One CRD manifest is generated per CRD using the CRD name (e.g. `mycrplural.group.example.com`)
  suffixed with the specification version, e.g. `mycrplural.group.example.com-v1.yml`
- The CRD files are generated in the `target/classes/META-INF/fabric8` directory of your project
