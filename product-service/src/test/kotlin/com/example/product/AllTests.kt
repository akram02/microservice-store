package com.example.product

import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
        IntegrationTestSuite::class,
        UnitTestSuite::class,
        DatabaseHealthTest::class
)
class AllTests
