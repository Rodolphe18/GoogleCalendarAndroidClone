plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}
// Root module
include(":app")

// Other modules
include(":domain")
include(":data")
include(":common")
include(":commonui")
include(":navigator")

include(":ui-onboarding")
include(":ui-dashboard")
include(":lib-uicalendar")
