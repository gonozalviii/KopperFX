tasks {
    withType<Test>().configureEach {

        beforeSuite(closureOf<TestDescriptor> {
            if(this.parent != null && this.className != null) {
                println("Running ${this.className}")
            }
        })

        afterSuite(KotlinClosure2<TestDescriptor, TestResult, Any>({
                desc, result->
            if(desc.parent != null && desc.className != null) {
                println("Tests run: ${result.testCount}, " +
                        "Failures: ${result.failedTestCount}, " +
                        "Skipped: ${result.skippedTestCount}, " +
                        "Time elapsed: ${(result.endTime - result.startTime) / 1000f} sec")
            }
            desc.parent ?:
            println("\nResults:\n\n" +
                    "Tests run: ${result.testCount}, " +
                    "Failures: ${result.failedTestCount}, " +
                    "Skipped: ${result.skippedTestCount}")
        }))
    }
}