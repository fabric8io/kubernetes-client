package verifier

import (
	"bytes"
	"fmt"
	"io"

	"github.com/gosuri/uitable"
)

// Result holds the errors and warnings of a package verification
type Result struct {
	Errors   []string
	Warnings []string
}

// NewResult initializes the Result struct
func NewResult() Result {
	return Result{
		Errors:   []string{},
		Warnings: []string{},
	}
}

func NewError(err ...string) Result {
	result := NewResult()
	result.AddErrors(err...)
	return result
}

func NewWarning(warn ...string) Result {
	result := NewResult()
	result.AddWarnings(warn...)
	return result
}

// AddErrors adds an arbitrary error string to the verification result
func (vr *Result) AddErrors(err ...string) { vr.Errors = append(vr.Errors, err...) }

// AddWarnings adds an arbitrary warning string to the verification result
func (vr *Result) AddWarnings(wrn ...string) { vr.Warnings = append(vr.Warnings, wrn...) }

// AddParamError adds a formatted error string for a package parameter error
func (vr *Result) AddParamError(paramName string, reason string) {
	vr.AddErrors(fmt.Sprintf("parameter %q %s", paramName, reason))
}

// AddParamWarning adds a formatted warning string for a package parameter error
func (vr *Result) AddParamWarning(paramName string, reason string) {
	vr.AddWarnings(fmt.Sprintf("parameter %q %s", paramName, reason))
}

// Merge method merges the errors and warnings from two verification results
func (vr *Result) Merge(other Result) {
	vr.AddErrors(other.Errors...)
	vr.AddWarnings(other.Warnings...)
}

// IsValid returns true if verification result does not have errors
func (vr *Result) IsValid() bool { return len(vr.Errors) == 0 }

// IsEmpty returns true if verification result has no errors AND no warnings
func (vr *Result) IsEmpty() bool { return len(vr.Errors) == 0 && len(vr.Warnings) == 0 }

// ErrorsAsString returns all errors as a single string
func (vr *Result) ErrorsAsString() string {
	buf := new(bytes.Buffer)
	printStringsWithHeader(buf, vr.Errors, nil)
	return buf.String()
}

// PrintErrors is a pretty printer for verification errors
func (vr *Result) PrintErrors(out io.Writer) {
	header := "Errors"
	printStringsWithHeader(out, vr.Errors, &header)
}

// PrintWarnings is a pretty printer for verification warnings
func (vr *Result) PrintWarnings(out io.Writer) {
	header := "Warnings"
	printStringsWithHeader(out, vr.Warnings, &header)
}

// PrintErrors is a simple printer for errors in Error context
func printStringsWithHeader(out io.Writer, items []string, header *string) {
	if len(items) == 0 {
		return
	}
	table := uitable.New()
	if header != nil {
		table.AddRow(*header)
	}
	for _, row := range items {
		table.AddRow(row)
	}
	_, _ = fmt.Fprintln(out, table)
}
