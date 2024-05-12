package com.github.gustavoflor.zarco

import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.util.concurrent.CountDownLatch
import java.util.function.Consumer
import kotlin.concurrent.thread

@ActiveProfiles("test")
@ExtendWith(SpringExtension::class)
abstract class CoreTest {

    protected fun doSyncAndConcurrently(threadAmount: Int, operation: Consumer<Int>) {
        val startLatch = CountDownLatch(1)
        val endLatch = CountDownLatch(threadAmount)
        for (index in 0 until threadAmount) {
            thread {
                try {
                    startLatch.await()
                    operation.accept(index)
                } catch (e: Exception) {
                    System.err.printf("Error while executing operation on index [%s]: %s", index, e.message)
                } finally {
                    endLatch.countDown()
                }
            }.start()
        }
        startLatch.countDown()
        endLatch.await()
    }

}