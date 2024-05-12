package com.github.gustavoflor.zarco.entrypoint.job

import kotlinx.coroutines.*
import org.slf4j.LoggerFactory
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import kotlin.random.Random

@Component
class EstimateTravelTimeJob {

    private val log = LoggerFactory.getLogger(javaClass)

    @Scheduled(fixedDelay = 30000)
    suspend fun run() = runBlocking {
        log.info("Running estimate travel time job...")
        val distanceProcess = async {
            log.info("Calculating distance...")
            delay(5000)
            log.info("Distance calculated!")
            Random.nextInt(1000, 7000)
        }
        val currentTrafficProcess = async {
            log.info("Fetching current traffic...")
            delay(3000)
            log.info("Current traffic fetched!")
            Random.nextDouble(0.1, 1.2)
        }
        val distance = distanceProcess.await()
        val currentTraffic = currentTrafficProcess.await()
        val estimateTravelTime = distance * currentTraffic / 60
        log.info("Current estimate travel time: ${estimateTravelTime.toInt()} minutes!")
    }

}